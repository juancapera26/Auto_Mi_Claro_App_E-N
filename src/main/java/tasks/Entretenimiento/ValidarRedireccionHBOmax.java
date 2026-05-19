package tasks.Entretenimiento;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static userinterfaces.EntretenimientoPage.*;
import static utils.Constants.*;

import interactions.Click.ClickTextoQueContengaX;
import interactions.wait.WaitFor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import utils.EvidenciaUtils;

/** Task para validar redirección HBOmax */
public class ValidarRedireccionHBOmax implements Task {

  private static final String paso = "Validar Modulo HBOmax";
  private static final String paso1 = "Validar terminos y condiciones ";
  private static final String paso2 = "Validar Redirección HBOmax";

  @Override
  public <T extends Actor> void performAs(T actor) {


    actor.attemptsTo(
            ClickTextoQueContengaX.elTextoContiene("Consulta Términos y condiciones"),
            WaitFor.aTime(5000)

    );

    EvidenciaUtils.registrarCaptura(paso1);
    actor.attemptsTo(Click.on(BTN_VOLVER_TC_HBO_MAX));

    actor.attemptsTo(
            ClickTextoQueContengaX.elTextoContiene("Ir a HBO Max"));
    EvidenciaUtils.registrarCaptura(paso);




    actor.attemptsTo(
        WaitUntil.the(LBL_ESPERA_UN_MOMENTO, isNotPresent()).forNoMoreThan(30).seconds(),
        WaitFor.aTime(5000));

    EvidenciaUtils.registrarCaptura(paso2);

  }

  public static Performable validar() {
    return instrumented(ValidarRedireccionHBOmax.class);
  }
}
