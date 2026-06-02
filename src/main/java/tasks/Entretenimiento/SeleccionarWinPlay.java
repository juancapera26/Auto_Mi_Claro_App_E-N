package tasks.Entretenimiento;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.EntretenimientoPage.*;
import static utils.Constants.*;

import interactions.Click.ClickTextoQueContengaX;
import interactions.Scroll.Scroll;
import interactions.Scroll.ScrollHastaTexto;
import interactions.wait.WaitFor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import utils.EvidenciaUtils;

/** Task para seleccionar Win Play */
public class SeleccionarWinPlay  implements Task {

  private static final String paso = "Scrool hasta tus Tu lugar para el Mundial selecionar Win play";

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(ScrollHastaTexto.conTexto(TUS_LUGAR_PARA_EL_MUNDIAL)

    );
    EvidenciaUtils.registrarCaptura(paso);

    actor.attemptsTo(ClickTextoQueContengaX.elTextoContiene(IR_WIN_PLAY));

  }

  public static Performable seleccionar() {
    return instrumented(SeleccionarWinPlay.class);
  }
}

