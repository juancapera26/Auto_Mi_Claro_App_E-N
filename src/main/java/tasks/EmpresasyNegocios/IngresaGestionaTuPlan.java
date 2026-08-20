package tasks.EmpresasyNegocios;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static userinterfaces.EntretenimientoPage.BTN_VOLVER;
import static userinterfaces.LoginPage.LOADING_SPLASH;
import static userinterfaces.PagosYConsultasPage.BTN_TRES_PUNTOS_MAS;
import static utils.Constants.*;

import interactions.Click.ClickTextoQueContengaX;
import interactions.validations.ValidarTexto;
import interactions.validations.ValidarTextoQueContengaX;
import interactions.wait.WaitFor;
import interactions.wait.WaitForResponse;
import models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.statematchers.IsNotPresentMatcher;
import net.serenitybdd.screenplay.waits.WaitUntil;
import utils.EvidenciaUtils;
import utils.TestDataProvider;

public class IngresaGestionaTuPlan implements Task {
  private final User user = TestDataProvider.getRealUser();
  private static final String paso1 = "Ingresar a gestiona tu plan";
  private static final String paso2 = "validar version de miniprograma";


  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
            ClickTextoQueContengaX.elTextoContiene(GESTIONA_TU_PLAN),
            WaitForResponse.withText(SOLUCIONES_MOVILES));

    EvidenciaUtils.registrarCaptura(paso1);
    actor.attemptsTo(
            WaitFor.aTime(1000),
            Click.on(BTN_TRES_PUNTOS_MAS),
            ClickTextoQueContengaX.elTextoContiene(ACERCA_DE),
            WaitFor.aTime(3500),
            ValidarTexto.validarTexto(ACERCA_DE),
            ValidarTexto.validarTexto(DECLARACION_SERVICIO)
    );

    EvidenciaUtils.registrarCaptura(paso2);

    actor.attemptsTo(
            Click.on(BTN_VOLVER),
            WaitUntil.the(LOADING_SPLASH, isNotPresent()),
            ClickTextoQueContengaX.elTextoContiene("Continuar"),
            WaitUntil.the(LOADING_SPLASH, isNotPresent())
    );

  }

  public static Performable ingresaGestionaTuPlan() {
    return instrumented(IngresaGestionaTuPlan.class);
  }
}
