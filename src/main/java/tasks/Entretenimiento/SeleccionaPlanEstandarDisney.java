package tasks.Entretenimiento;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.EntretenimientoPage.*;
import static utils.AdbUtils.ejecutarAdbTap;
import static utils.Constants.*;

import interactions.Click.ClickEnCoordenadas;
import interactions.Scroll.ScrollHorizontalCoordenadas;
import interactions.Scroll.ScrollHorizontalYValidar;
import interactions.validations.ValidarTextoQueContengaX;
import interactions.wait.WaitFor;
import interactions.wait.WaitForTextContains;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import utils.EvidenciaUtils;

/**
 * Task para seleccionar el Plan Estándar de Disney+ Implementa scroll horizontal para encontrar la
 * opción específica
 *
 * <p>Aplicación de principios SOLID: - SRP: Responsabilidad única de seleccionar plan Disney - OCP:
 * Extensible para otros planes sin modificar código existente - DIP: Depende de abstracciones
 * (Interactions) no de implementaciones
 */
public class SeleccionaPlanEstandarDisney implements Task {

  private static final String paso = "Seleccionar Plan estandar Disney+";

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
            WaitForTextContains.withAnyTextContains("Todos los canales de ESPN"),
            ScrollHorizontalCoordenadas.desde(
                    610, 1389,   // inicio
                    200, 1200    // final (hacia la izquierda visual = scroll derecha)
            ),
            ValidarTextoQueContengaX.elTextoContiene("Disney+ Premium"));
    EvidenciaUtils.registrarCaptura(paso);

    actor.attemptsTo(
            WaitFor.aTime(5000),
            ClickEnCoordenadas.en(536, 1609)
    );

    // ejecutarAdbTap(523, 1786);  // Simula un toque en las coordenadas

  }

  public static Performable seleccionar() {
    return instrumented(SeleccionaPlanEstandarDisney.class);
  }
}

