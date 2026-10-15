package utils;

import io.appium.java_client.android.AndroidDriver;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import net.thucydides.core.webdriver.SerenityWebdriverManager;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Autorreparación de Mi Claro cuando el Inicio se queda cargando sin fin.
 *
 * <p>OPPO A80 5G (CPH2639, Android 16), 13 y 14-oct-2026: tras tocar "Iniciar sesión" en el
 * aviso de sesión cerrada, la app cae al Inicio con el indicador de carga girando y no sale de
 * ahí (30 de 30 corridas fallidas el 14-oct). En los demás celulares el Inicio carga normal. Se
 * arreglaba borrando a mano los datos de la app o reinstalándola; esto hace lo mismo desde la
 * prueba: detecta el Inicio atascado, borra los datos (pm clear) y relanza la app para ingresar
 * desde cero.
 *
 * <p>Se lee el page source en vez de buscar elementos para no depender de la espera implícita.
 */
public class ReparacionApp {

  private static final String PAQUETE_POR_DEFECTO = "com.clarocolombia.miclaro";

  /** Textos que solo aparecen cuando el Inicio (o la pantalla de ingreso) ya cargó. */
  private static final String[] SENALES_CARGADO = {
    "Iniciar sesi", "Tus favoritos", "Te puede interesar"
  };

  private ReparacionApp() {}

  /** El driver de Appium real: Serenity lo entrega envuelto en un WebDriverFacade. */
  private static AndroidDriver driver() {
    WebDriver driver = SerenityWebdriverManager.inThisTestThread().getCurrentDriver();
    if (driver instanceof WebDriverFacade) {
      driver = ((WebDriverFacade) driver).getProxiedDriver();
    }
    return (AndroidDriver) driver;
  }

  private static String fuente(AndroidDriver driver) {
    try {
      String s = driver.getPageSource();
      return s == null ? "" : s;
    } catch (Exception e) {
      return "";
    }
  }

  /**
   * El aviso "Por seguridad, hemos cerrado tu sesión" trae su propio botón "Iniciar sesión":
   * mientras siga en pantalla (justo después de tocarlo tarda en cerrarse) no prueba nada.
   */
  private static boolean avisoSesionCerrada(String fuente) {
    return fuente.contains("hemos cerrado tu sesi");
  }

  private static boolean cargado(String fuente) {
    if (avisoSesionCerrada(fuente)) {
      return false;
    }
    for (String senal : SENALES_CARGADO) {
      if (fuente.contains(senal)) {
        return true;
      }
    }
    return false;
  }

  private static void dormir(long ms) {
    try {
      Thread.sleep(ms);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }

  /**
   * ¿El Inicio sigue cargando sin mostrar nada después de {@code segundos}? Solo responde true
   * si al final está en el Inicio (home_content_container) con el indicador de carga y sin
   * ninguna señal de pantalla cargada: con otra pantalla o un aviso encima no se toca nada.
   */
  public static boolean inicioAtascado(int segundos) {
    // Un fallo aquí nunca debe tumbar la prueba: sin certeza, se sigue el flujo normal.
    try {
      return inicioAtascadoSinProteger(segundos);
    } catch (Exception e) {
      System.out.println("[ReparacionApp] no se pudo revisar el Inicio: " + e);
      return false;
    }
  }

  private static boolean inicioAtascadoSinProteger(int segundos) {
    AndroidDriver driver = driver();
    long fin = System.currentTimeMillis() + segundos * 1000L;
    String fuente = "";
    while (System.currentTimeMillis() < fin) {
      fuente = fuente(driver);
      if (cargado(fuente)) {
        return false;
      }
      dormir(3000);
    }
    fuente = fuente(driver);
    boolean atascado =
        !cargado(fuente)
            && !avisoSesionCerrada(fuente)
            && fuente.contains("home_content_container")
            && fuente.contains("animation_lottie");
    System.out.println("[ReparacionApp] tras " + segundos + " s el Inicio "
        + (atascado ? "sigue cargando: se repara" : "no está atascado (otra pantalla)"));
    return atascado;
  }

  /** Borra los datos de la app (como "Borrar datos" en Ajustes) y la vuelve a abrir. */
  public static void borrarDatosYRelanzar() {
    AndroidDriver driver = driver();
    Object paquete = driver.getCapabilities().getCapability("appPackage");
    String pkg = paquete != null ? paquete.toString() : PAQUETE_POR_DEFECTO;

    try {
      Object salida = shell(driver, "pm", "clear", pkg);
      System.out.println("[ReparacionApp] pm clear " + pkg + " -> " + salida);
    } catch (Exception e) {
      // ColorOS (OPPO A80 5G) le niega a adb CLEAR_APP_USER_DATA: se hace como una persona,
      // por Información de la app → Uso del almacenamiento → Borrar datos → Eliminar.
      System.out.println("[ReparacionApp] pm clear bloqueado por el sistema; se borra desde Ajustes");
      borrarDatosDesdeAjustes(driver, pkg);
    }

    dormir(2000);
    driver.activateApp(pkg);
    dormir(8000);
  }

  /**
   * Con la app recién borrada salen, con retraso y en este orden, la hoja "Condiciones del
   * servicio", la de "Permiso de acceso a tu ubicación", el diálogo del sistema, el de
   * notificaciones y a veces "Omitir" o el aviso de otra zona. Se atienden según aparecen hasta que se ve "Iniciar sesión" (o se acaba el tiempo).
   * Hace falta porque el manejo de permisos del ingreso desde cero mira una sola vez, y en ese
   * momento la app todavía está en blanco.
   */
  public static void atenderPantallasIniciales(int segundos) {
    try {
      AndroidDriver driver = driver();
      long fin = System.currentTimeMillis() + segundos * 1000L;
      while (System.currentTimeMillis() < fin) {
        String f = fuente(driver);
        String xpath = null;
        if (f.contains("Condiciones del servicio")
            || f.contains("Permiso de acceso a tu ubicaci")
            || f.contains("medición de velocidad")) {
          xpath = "//*[@text='Aceptar']";
        } else if (f.contains("ientras la app est") || f.contains("ientras se usa la app")) {
          xpath = "//*[contains(@text, 'ientras la app est')"
              + " or contains(@text, 'ientras se usa la app')]";
        } else if (f.contains("Permitir que Mi Claro")) {
          xpath = "//*[@text='No permitir']";
        } else if (f.contains("Estás entrando a otra zona")) {
          xpath = "//*[@text='Continuar']";
        } else if (f.contains("text=\"Omitir\"")) {
          xpath = "//*[@text='Omitir']";
        } else if (f.contains("Iniciar sesi") || f.contains("Te damos la bienvenida")) {
          System.out.println("[ReparacionApp] app lista para ingresar");
          return;
        }
        if (xpath != null) {
          try {
            driver.findElement(By.xpath(xpath)).click();
            System.out.println("[ReparacionApp] pantalla inicial atendida: " + xpath);
          } catch (Exception e) {
            // Cambió entre la lectura y el toque: se vuelve a mirar.
          }
          dormir(2500);
        } else {
          dormir(3000);
        }
      }
      System.out.println("[ReparacionApp] la app no llegó a mostrar 'Iniciar sesión'");
    } catch (Exception e) {
      System.out.println("[ReparacionApp] no se pudieron atender las pantallas iniciales: " + e);
    }
  }

  /**
   * Tras el primer ingreso con la app recién borrada sale un carrusel de bienvenida ("¡Desliza y
   * descúbrela!") con "Omitir". Espera a que pase la carga y lo omite. Vuelve en cuanto se ve
   * "Tus favoritos" o cualquier otra pantalla (términos, biometría, permisos...), que la manejan
   * los pasos del ingreso. En el flujo normal cuesta una lectura de pantalla.
   */
  public static void omitirBienvenidaTrasIngreso(int segundos) {
    try {
      AndroidDriver driver = driver();
      long fin = System.currentTimeMillis() + segundos * 1000L;
      while (System.currentTimeMillis() < fin) {
        String f = fuente(driver);
        if (f.contains("Tus favoritos")) {
          return;
        }
        if (f.contains("Desliza y descúbrela") || f.contains("text=\"Omitir\"")) {
          try {
            driver.findElement(By.xpath("//*[@text='Omitir']")).click();
            System.out.println("[ReparacionApp] carrusel de bienvenida omitido");
          } catch (Exception e) {
            // Cambió entre la lectura y el toque: se vuelve a mirar.
          }
          dormir(2500);
        } else if (f.contains("Espera un momento") || !TEXTO_VISIBLE.matcher(f).find()) {
          dormir(3000);   // todavía cargando
        } else {
          return;
        }
      }
    } catch (Exception e) {
      System.out.println("[ReparacionApp] no se pudo revisar la bienvenida: " + e);
    }
  }

  private static final Pattern TEXTO_VISIBLE = Pattern.compile("text=\"[^\"]+\"");

  /**
   * Diálogos de permisos DEL SISTEMA que la app dispara con retraso (al aceptar la medición de
   * velocidad sale el de ubicación, encima del Inicio). Durante {@code segundos} responde
   * "Mientras la app está en uso" al de ubicación y "No permitir" al de notificaciones, como el
   * resto del proyecto.
   */
  public static void responderPermisosDelSistema(int segundos) {
    try {
      AndroidDriver driver = driver();
      long fin = System.currentTimeMillis() + segundos * 1000L;
      while (System.currentTimeMillis() < fin) {
        String f = fuente(driver);
        String xpath = null;
        if (f.contains("ientras la app est") || f.contains("ientras se usa la app")) {
          xpath = "//*[contains(@text, 'ientras la app est')"
              + " or contains(@text, 'ientras se usa la app')]";
        } else if (f.contains("Permitir que Mi Claro")) {
          xpath = "//*[@text='No permitir']";
        }
        if (xpath == null) {
          dormir(1000);
          continue;
        }
        try {
          driver.findElement(By.xpath(xpath)).click();
          System.out.println("[ReparacionApp] permiso del sistema respondido: " + xpath);
        } catch (Exception e) {
          // Cambió entre la lectura y el toque: se vuelve a mirar.
        }
        dormir(2000);
      }
    } catch (Exception e) {
      System.out.println("[ReparacionApp] no se pudieron revisar los permisos: " + e);
    }
  }

  private static Object shell(AndroidDriver driver, String comando, String... argumentos) {
    Map<String, Object> args = new HashMap<>();
    args.put("command", comando);
    args.put("args", List.of(argumentos));
    return driver.executeScript("mobile: shell", args);
  }

  private static void tocar(AndroidDriver driver, String xpath) {
    driver.findElement(By.xpath(xpath)).click();
    dormir(2500);
  }

  private static void borrarDatosDesdeAjustes(AndroidDriver driver, String pkg) {
    try {
      borrarDatosDesdeAjustesSinCerrar(driver, pkg);
    } finally {
      shell(driver, "am", "force-stop", "com.android.settings");
    }
  }

  private static void borrarDatosDesdeAjustesSinCerrar(AndroidDriver driver, String pkg) {
    // Con Ajustes ya abierto en esa página, el intent reusa la pantalla vieja y el tamaño de
    // los datos sale desactualizado (0 B, botón deshabilitado): se abre siempre desde cero.
    shell(driver, "am", "force-stop", "com.android.settings");
    shell(driver, "am", "start", "-a", "android.settings.APPLICATION_DETAILS_SETTINGS",
        "-d", "package:" + pkg);
    dormir(3000);
    tocar(driver, "//*[contains(@text, 'lmacenamiento')]");
    By botonBorrar = By.xpath("//*[@text='Borrar datos'"
        + " or @text='Borrar almacenamiento' or @text='Clear data' or @text='Clear storage']");
    WebElement borrar = driver.findElement(botonBorrar);
    // Ajustes habilita el botón cuando termina de calcular el tamaño: se le dan unos segundos.
    for (int i = 0; i < 4 && !borrar.isEnabled(); i++) {
      dormir(1500);
      borrar = driver.findElement(botonBorrar);
    }
    if (!borrar.isEnabled()) {
      // Datos en 0 B: Android deshabilita el botón y no hay nada que borrar.
      System.out.println("[ReparacionApp] la app no tenía datos que borrar");
      return;
    }
    borrar.click();
    dormir(2500);
    // Confirmación: "Eliminar" en ColorOS, "Aceptar"/"Borrar" en otras capas.
    tocar(driver, "//*[(@resource-id='android:id/button1' or @resource-id='android:id/button3')"
        + " and (@text='Eliminar' or @text='Aceptar' or @text='Borrar' or @text='OK'"
        + " or @text='Delete')]");
    System.out.println("[ReparacionApp] datos de " + pkg + " borrados desde Ajustes");
  }
}
