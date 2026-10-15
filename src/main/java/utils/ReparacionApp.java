package utils;

import io.appium.java_client.android.AndroidDriver;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.thucydides.core.webdriver.SerenityWebdriverManager;

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

  private static AndroidDriver driver() {
    return (AndroidDriver) SerenityWebdriverManager.inThisTestThread().getCurrentDriver();
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

    Map<String, Object> args = new HashMap<>();
    args.put("command", "pm");
    args.put("args", List.of("clear", pkg));
    Object salida = driver.executeScript("mobile: shell", args);
    System.out.println("[ReparacionApp] pm clear " + pkg + " -> " + salida);

    dormir(2000);
    driver.activateApp(pkg);
    dormir(8000);
  }
}
