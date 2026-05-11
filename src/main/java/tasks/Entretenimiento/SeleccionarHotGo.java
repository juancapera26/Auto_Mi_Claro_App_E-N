package tasks.Entretenimiento;

// ===========================================
// SA068 - HOT GO
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

/** Task para seleccionar HotGo */
public class SeleccionarHotGo implements Task {

  private static final String paso = "Scrool hasta tus plataformas favoritas y seleccionar ver mas";
  private static final String paso1 = "Seleccionar HotGo";

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(ScrollHastaTexto.conTexto(TUS_PLATAFORMAS_FAVORITAS),
            Scroll.scrollUnaVista()
    );
    EvidenciaUtils.registrarCaptura(paso);
    actor.attemptsTo(ClickTextoQueContengaX.elTextoContiene(VER_MAS),
            Scroll.scrollUnaVista());
    EvidenciaUtils.registrarCaptura(paso1);
    actor.attemptsTo(ClickTextoQueContengaX.elTextoContiene(HOTGO));

  }

  public static Performable seleccionar() {
    return instrumented(SeleccionarHotGo.class);
  }
}
