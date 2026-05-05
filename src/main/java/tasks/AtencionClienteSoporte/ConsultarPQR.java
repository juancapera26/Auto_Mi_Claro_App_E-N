package tasks.AtencionClienteSoporte;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utils.Constants.*;

import interactions.Click.ClickTextoQueContengaX;
import interactions.validations.ValidarTextoQueContengaX;
import interactions.wait.WaitForResponse;
import models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import utils.AndroidObject;
import utils.EvidenciaUtils;
import utils.TestDataProvider;

public class ConsultarPQR extends AndroidObject implements Task {

  private final User user = TestDataProvider.getRealUser();
  private static final String paso1 = "Ingresar a Consultar PQR";


  @Override
  public <T extends Actor> void performAs(T actor) {

    // Evidencia inicial


    // Flujo de navegación
    actor.attemptsTo(
            ClickTextoQueContengaX.elTextoContiene(VER_MAS),
            ClickTextoQueContengaX.elTextoContiene(CONSULTAR_PQR),
            WaitForResponse.withText(HOGAR)
    );
    EvidenciaUtils.registrarCaptura(paso1);


  }

  public static Performable ingresar() {
    return instrumented(ConsultarPQR.class);
  }
}