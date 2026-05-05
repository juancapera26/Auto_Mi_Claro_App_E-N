package tasks.Entretenimiento.ValidarRedirecciones;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utils.Constants.*;

import interactions.Click.ClickTextoQueContengaX;
import interactions.validations.ValidarTexto;
import interactions.validations.ValidarTextoQueContengaX;
import models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import utils.AndroidObject;
import utils.EvidenciaUtils;
import utils.TestDataProvider;

public class ValidarRedireccionPlayStoreClaroVideo implements Task {

  private static final String paso = "Validar redirección a la Play Store";
  private static final User user = TestDataProvider.getRealUser();

  @Override
  public <T extends Actor> void performAs(T actor) {

    ValidarTextoQueContengaX.elTextoContiene(
            CUENTA + " " + user.getCuentaHogar() + " " + VER_DETALLE
    );
    actor.attemptsTo(ClickTextoQueContengaX.elTextoContiene(user.getCuentaHogar()));
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }

    // Validar textos visibles en Play Store
    actor.attemptsTo(
        ValidarTexto.validarTexto("Claro video"), ValidarTexto.validarTexto("Desinstalar"));

    EvidenciaUtils.registrarCaptura(paso);
  }

  public static Performable validar() {
    return instrumented(ValidarRedireccionPlayStoreClaroVideo.class);
  }
}
