package hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import java.util.ArrayList;
import java.util.List;
import listeners.OllamaStepListener;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.steps.StepEventBus;
import utils.CausaFallo;
import utils.ContextoST;
import utils.EstadoPrueba;
import utils.WordAppium;

/**
 * Hooks consolidados de Cucumber
 *
 * <p>Responsabilidades: - Inicializar actores de Serenity - Registrar OllamaStepListener - Generar
 * reportes Word - Tracking de pasos y estado
 */
public class ReportHooks {

  private static final List<String> pasosEjecutados = new ArrayList<>();
  private static String lineaUsada = "Sin datos";
  private static String ultimoPaso = "";
  private static boolean listenerRegistrado = false;

  public static void registrarPaso(String paso) {
    pasosEjecutados.add(paso);
    ultimoPaso = paso;
  }

  public static void setLinea(String linea) {
    lineaUsada = linea;
    // Contrato st-context: este método ya se llama en cada punto donde el escenario usa
    // una línea de verdad, así que es el sitio natural para registrarla y que llegue a
    // las alertas de Smart Tester ({{lineaPrueba}}).
    ContextoST.registrarLinea(linea);
  }

  @Before(order = 0) // ✅ Ejecutar PRIMERO
  public void initScenario(Scenario scenario) {
    System.out.println("\n══════════════════════════════════════════════════════");
    System.out.println("🚀 Iniciando escenario: " + scenario.getName());
    System.out.println("══════════════════════════════════════════════════════");

    // 🔹 Inicializar estado de prueba. Todo esto es estático y sobrevive la corrida
    // entera: sin limpiarlo, el escenario hereda los datos del anterior (era el caso
    // de lineaUsada y ultimoPaso, que se colaban en el informe Word).
    EstadoPrueba.inicio = System.currentTimeMillis();
    pasosEjecutados.clear();
    ultimoPaso = "";
    lineaUsada = "Sin datos";
    EstadoPrueba.fallo = false;
    EstadoPrueba.pasoFallido = "";
    ContextoST.reiniciar();

    // 🔹 Registrar el listener de Ollama solo una vez
    if (!listenerRegistrado) {
      try {
        OllamaStepListener ollamaListener = new OllamaStepListener();
        StepEventBus.getEventBus().registerListener(ollamaListener);
        listenerRegistrado = true;
        System.out.println("✅ [OLLAMA] Listener registrado correctamente");
      } catch (Exception e) {
        System.err.println("❌ [OLLAMA] Error al registrar listener: " + e.getMessage());
        e.printStackTrace();
      }
    }

    // 🔹 Inicializar actores de Serenity
    OnStage.setTheStage(new OnlineCast());
  }

  // order 1 = este @After corre el ÚLTIMO (Cucumber los ejecuta en orden descendente),
  // después de ErrorScreenshotHooks (order 10), que es quien guarda Error/error.png. El
  // informe la necesita ya escrita para insertarla.
  @After(order = 1)
  public void generarReporteFinal(Scenario scenario) {
    // Contrato st-context: con qué correo y línea corrió el escenario, para las alertas
    // de Smart Tester. Va primero para que un fallo del informe Word no se lleve el dato.
    ContextoST.registrarEscenario(scenario);

    EstadoPrueba.fin = System.currentTimeMillis();

    // Detectar fallo y último paso fallido
    if (scenario.isFailed()) {
      EstadoPrueba.fallo = true;
      EstadoPrueba.pasoFallido = !pasosEjecutados.isEmpty() ? ultimoPaso : "Paso no identificado";
    }

    long duracionTotal = (EstadoPrueba.fin - EstadoPrueba.inicio) / 1000;
    long minutos = duracionTotal / 60;
    long segundos = duracionTotal % 60;
    String duracionFormato = minutos + " min " + segundos + " seg";

    String estadoFinal = scenario.isFailed() ? "FAILED" : "PASSED";
    String pasoFallido = scenario.isFailed() ? EstadoPrueba.pasoFallido : null;
    String motivoFallo = scenario.isFailed() ? CausaFallo.descripcionCorta() : "";

    // La línea sale de ContextoST (se llena donde se usa de verdad y se limpia en cada
    // escenario), no del estático lineaUsada, que arrastraba la del escenario anterior.
    String identificacion = ContextoST.identificacionUsada();

    WordAppium.generarReporte(
        scenario.getName(),
        pasosEjecutados.toArray(new String[0]),
        identificacion.isEmpty() ? "Sin datos" : identificacion,
        duracionFormato,
        pasoFallido,
        estadoFinal,
        motivoFallo);

    System.out.println("══════════════════════════════════════════════════════");
    System.out.println("🏁 Escenario finalizado: " + scenario.getName());
    System.out.println("   Estado: " + (scenario.isFailed() ? "❌ FAILED" : "✅ PASSED"));
    System.out.println("   Duración: " + duracionFormato);
    System.out.println("══════════════════════════════════════════════════════\n");

    // Limpiar estado para el siguiente escenario
    pasosEjecutados.clear();
    ultimoPaso = "";
    lineaUsada = "Sin datos";
    EstadoPrueba.fallo = false;
    EstadoPrueba.pasoFallido = "";
  }
}
