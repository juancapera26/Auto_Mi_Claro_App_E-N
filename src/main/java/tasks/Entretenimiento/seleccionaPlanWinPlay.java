package tasks.Entretenimiento;

import interactions.Click.ClickTextoQueContengaX;
import interactions.validations.ValidarTextoQueContengaX;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import utils.EvidenciaUtils;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utils.Constants.HOTGO;
import static utils.Constants.WIN_PLAY;

public class seleccionaPlanWinPlay implements Task {

    private static final String paso = "Seleccionar Plan HotGo";

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

                ValidarTextoQueContengaX.elTextoContiene(WIN_PLAY));
        EvidenciaUtils.registrarCaptura(paso);

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Continuar")
        );

        // ejecutarAdbTap(523, 1786);  // Simula un toque en las coordenadas

    }

    public static Performable seleccionar() {
        return instrumented(seleccionaPlanWinPlay.class);
    }
}
