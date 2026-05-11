package tasks.Entretenimiento.ValidarTC;

import interactions.Click.ClickTextoQueContengaX;
import interactions.validations.ValidarTexto;
import interactions.validations.ValidarTextoQueContengaX;
import interactions.wait.WaitForResponse;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import utils.EvidenciaUtils;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.EntretenimientoPage.CHECK_TERMINOS;
import static userinterfaces.LoginPage.BTN_ACEPTAR;
import static utils.Constants.*;

public class validaTerminosYCondicionesHotGo implements Task {
    // private static final String paso = "Validar Plan y Términos y Condiciones Disney+";
    private static final String paso2 = "Aceptar TC";
    private static final String paso3 = "Aceptar";

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitForResponse.withText(HOTGO),
                ValidarTextoQueContengaX.elTextoContiene("HotGo"));
        EvidenciaUtils.registrarCaptura(paso2);
        actor.attemptsTo(Click.on(CHECK_TERMINOS), ClickTextoQueContengaX.elTextoContiene(ACTIVAR));

        EvidenciaUtils.registrarCaptura(paso3);
        actor.attemptsTo(ValidarTexto.validarTexto(ACEPTAR_2), Click.on(BTN_ACEPTAR));
    }

    public static Performable validar() {
        return instrumented(ValidarTerminosCondicionesDisneyPremium.class);
    }
}
