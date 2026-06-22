package tasks.EmpresasyNegocios;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.EmpresasNegociosPage.*;
import static userinterfaces.EntretenimientoPage.BTN_VOLVER;
import static userinterfaces.PagosYConsultasPage.*;
import static utils.Constants.*;

import interactions.Click.ClickEnCoordenadas;
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
import utils.EvidenciaUtils;
import utils.TestDataProvider;

public class AcederIformacionTramites implements Task {
  private final User user = TestDataProvider.getRealUser();
  private static final String paso1 = "Ingresar a informacion de tramites";


  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
            ClickTextoQueContengaX.elTextoContiene(INFORMACION_TRAMITE),
            WaitForResponse.withText(INFORMACION_TRAMITE));

    EvidenciaUtils.registrarCaptura(paso1);

  }

  public static Performable acederIformacionTramites() {
    return instrumented(AcederIformacionTramites.class);
  }
}
