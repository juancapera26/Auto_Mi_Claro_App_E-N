package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.Scenario;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import models.User;

/**
 * Deja constancia, escenario por escenario, de CON QUE DATOS se corrio la prueba: correo, linea y
 * documento. Es el lado "proyecto" del contrato st-context con Smart Tester.
 *
 * <p>Como funciona: al terminar cada escenario se escribe UN archivo JSON en {@code
 * target/st-context/}. El orquestador lee esa carpeta antes de archivar el workspace, la mete en
 * report_metadata.json y la publica en /api/status; Smart Tester la convierte en las variables de
 * plantilla {@code {{correoPrueba}}}, {@code {{lineaPrueba}}}, {@code {{documentoPrueba}}}.
 *
 * <p>Este proyecto trabaja con UNA sola cuenta (real-user.json no tiene pool), asi que el correo y
 * el documento no admiten duda. La LINEA si cambia: hay escenarios que usan la principal, otros la
 * prepago y otros una linea concreta del plan. Por eso se registra donde de verdad se usa (via
 * {@code ReportHooks.setLinea}, que ya se llama en cada uno de esos puntos) y se marca con
 * {@code origenLinea} si es la que toco el escenario ("usada") o la de la cuenta ("cuenta"),
 * cuando el escenario no toco ninguna.
 *
 * <p>Un archivo por escenario (y no uno compartido) a proposito: el build corre con {@code
 * maxParallelForks}, y varios JVM escribiendo el mismo archivo se pisarian. Ademas, si la corrida
 * se cae a la mitad, lo ya escrito sobrevive.
 *
 * <p>REGLA: aqui NO se escriben contrasenas. Este archivo viaja a Smart Tester y su contenido
 * termina en mensajes de WhatsApp/Teams.
 */
public class ContextoST {

  private static final String CARPETA = "target/st-context";

  /** Lineas que toco el escenario en curso, en orden y sin repetir. Se limpia en cada @Before. */
  private static final List<String> LINEAS = new ArrayList<>();

  private ContextoST() {}

  /** Arranque de escenario: olvidar lo del anterior (los estaticos sobreviven la corrida). */
  public static synchronized void reiniciar() {
    LINEAS.clear();
  }

  /** Una linea que el escenario esta usando de verdad. Lo llama ReportHooks.setLinea. */
  public static synchronized void registrarLinea(String linea) {
    if (linea == null) {
      return;
    }
    String limpia = linea.trim();
    if (limpia.isEmpty() || "Sin datos".equalsIgnoreCase(limpia) || LINEAS.contains(limpia)) {
      return;
    }
    LINEAS.add(limpia);
  }

  /** Las lineas que toco el escenario, unidas por " -> ". Vacio si no toco ninguna. */
  public static synchronized String lineasUsadas() {
    return String.join(" -> ", LINEAS);
  }

  /**
   * Lo que identifica esta prueba: la(s) linea(s) que uso el escenario o, si no uso ninguna, la
   * linea principal de la cuenta. Lo consume tambien el informe Word.
   */
  public static synchronized String identificacionUsada() {
    String usadas = lineasUsadas();
    if (!usadas.isEmpty()) {
      return usadas;
    }
    User cuenta = cuenta();
    return cuenta == null || cuenta.getNumero() == null ? "" : cuenta.getNumero();
  }

  /**
   * Escribe el contexto del escenario que acaba de terminar. Nunca lanza: si algo falla, el
   * escenario no se entera (esto es telemetria, no parte de la prueba).
   */
  public static synchronized void registrarEscenario(Scenario scenario) {
    try {
      List<String> tags = new ArrayList<>();
      if (scenario != null && scenario.getSourceTagNames() != null) {
        tags.addAll(scenario.getSourceTagNames());
      }

      User cuenta = cuenta();
      String usadas = lineasUsadas();

      Map<String, Object> datos = new LinkedHashMap<>();
      datos.put("escenario", scenario == null ? null : scenario.getName());
      datos.put("tags", tags);
      datos.put("correo", cuenta == null ? null : cuenta.getEmail());
      datos.put("linea", identificacionUsada());
      datos.put("origenLinea", usadas.isEmpty() ? "cuenta" : "usada");
      datos.put("lineasUsadas", new ArrayList<>(LINEAS));
      datos.put("documento", cuenta == null ? null : cuenta.getCedula());
      datos.put("usuario", cuenta == null ? null : cuenta.getNombreUsuario());
      datos.put("resultado", scenario != null && scenario.isFailed() ? "FAILED" : "PASSED");
      datos.put("registradoEn", LocalDateTime.now().toString());

      escribir(datos);

      System.out.println(
          "[ContextoST] Escenario registrado | correo="
              + datos.get("correo")
              + " | linea="
              + datos.get("linea")
              + " ("
              + datos.get("origenLinea")
              + ")");

    } catch (Exception e) {
      System.err.println("[ContextoST] No se pudo registrar el contexto del escenario: " + e);
    }
  }

  private static User cuenta() {
    try {
      return TestDataProvider.getRealUser();
    } catch (Exception e) {
      System.err.println("[ContextoST] No se pudo leer real-user.json: " + e);
      return null;
    }
  }

  private static void escribir(Map<String, Object> datos) throws Exception {
    Path carpeta = Paths.get(CARPETA);
    Files.createDirectories(carpeta);
    String nombre =
        System.currentTimeMillis() + "-" + UUID.randomUUID().toString().substring(0, 8) + ".json";
    File destino = carpeta.resolve(nombre).toFile();
    new ObjectMapper().writerWithDefaultPrettyPrinter().writeValue(destino, datos);
  }
}
