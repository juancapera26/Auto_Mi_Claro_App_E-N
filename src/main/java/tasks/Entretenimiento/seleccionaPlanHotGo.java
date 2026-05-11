package tasks.Entretenimiento;

import interactions.Click.ClickTextoQueContengaX;
import interactions.validations.ValidarTextoQueContengaX;
import interactions.wait.WaitForTextContains;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import utils.EvidenciaUtils;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.EntretenimientoPage.BTN_ELEGIR_PLAN_PREMIUM;
import static utils.Constants.HOTGO;

public class seleccionaPlanHotGo implements Task {

    private static final String paso = "Seleccionar Plan HotGo";

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                
                ValidarTextoQueContengaX.elTextoContiene(HOTGO));
        EvidenciaUtils.registrarCaptura(paso);

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Continuar")
        );

        // ejecutarAdbTap(523, 1786);  // Simula un toque en las coordenadas

    }

    public static Performable seleccionar() {
        return instrumented(seleccionaPlanHotGo.class);
    }
}
