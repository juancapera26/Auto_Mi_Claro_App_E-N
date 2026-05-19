package tasks.Entretenimiento.ValidarTC;

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

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.EntretenimientoPage.CHECK_TERMINOS;
import static userinterfaces.EntretenimientoPage.CHECK_TERMINOS_HOTGO;
import static userinterfaces.LoginPage.BTN_ACEPTAR;
import static userinterfaces.LoginPage.BTN_ACEPTAR_HOTGO;
import static utils.Constants.*;

public class validaTerminosYCondicionesHotGo implements Task {
    private static final User user = TestDataProvider.getRealUser();
    // private static final String paso = "Validar Plan y Términos y Condiciones Disney+";
    private static final String paso2 = "Validar terminos y condiciones HotGo";
    private static final String paso3 = "Aceptar";

    @Override
    public <T extends Actor> void performAs(T actor) {
        EvidenciaUtils.registrarCaptura(paso2);

        actor.attemptsTo(WaitFor.aTime(5000) ,

                Click.on(CHECK_TERMINOS_HOTGO),
                ClickTextoQueContengaX.elTextoContiene(ACTIVAR));

        EvidenciaUtils.registrarCaptura(paso3);
        actor.attemptsTo(WaitFor.aTime(5000),ValidarTexto.validarTexto(ACEPTAR_2), Click.on(BTN_ACEPTAR_HOTGO));
    }

    public static Performable validar() {
        return instrumented(validaTerminosYCondicionesHotGo.class);
    }
}
