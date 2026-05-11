package tasks.Entretenimiento;

// ===========================================
// SA065 - HBO MAX
// ===========================================

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

/** Task para seleccionar HBOmax */
public class SeleccionarHBOmax implements Task {

  private static final String paso = "ir a Tus plataformas favoritos";
  private static final String paso1 = "Seleccionar HBOmax";

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(ScrollHastaTexto.conTexto(TUS_PLATAFORMAS_FAVORITAS),
            Scroll.scrollUnaVista());
    EvidenciaUtils.registrarCaptura(paso);
    actor.attemptsTo(ClickTextoQueContengaX.elTextoContiene(VER_MAS));
    EvidenciaUtils.registrarCaptura(paso1);
    actor.attemptsTo(ClickTextoQueContengaX.elTextoContiene(HBO_MAX));
  }

  public static Performable seleccionar() {
    return instrumented(SeleccionarHBOmax.class);
  }
}
