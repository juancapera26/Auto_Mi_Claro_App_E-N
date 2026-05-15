package tasks.Entretenimiento;

import interactions.Click.ClickTextoQueContengaX;
import interactions.Scroll.Scroll;
import interactions.Scroll.ScrollHastaTexto;
import interactions.wait.WaitFor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import utils.EvidenciaUtils;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utils.Constants.*;

public class SeleccionarGamingCloud implements Task {

    private static final String paso = "Scrool hasta tus plataformas favoritas y seleccionar ver mas";
    private static final String paso2 = "Seleccionar  GamingCloud";

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(ScrollHastaTexto.conTexto(TUS_PLATAFORMAS_FAVORITAS));

        EvidenciaUtils.registrarCaptura(paso);


        actor.attemptsTo( Scroll.scrollUnaVista(), ClickTextoQueContengaX.elTextoContiene(VER_MAS));

        EvidenciaUtils.registrarCaptura(paso2);

        actor.attemptsTo(ClickTextoQueContengaX.elTextoContiene(GAMING_CLOUD));
    }

    public static Performable seleccionar() {
        return instrumented(SeleccionarGamingCloud.class);
    }
}
