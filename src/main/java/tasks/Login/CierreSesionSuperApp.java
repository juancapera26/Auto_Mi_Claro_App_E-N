package tasks.Login;

import interactions.Click.ClickTextoQueContengaX;
import interactions.validations.ValidarTexto;
import interactions.validations.ValidarTextoQueContengaX;
import interactions.wait.WaitFor;
import models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Presence;
import net.serenitybdd.screenplay.targets.Target;
import utils.EvidenciaUtils;
import utils.TestDataProvider;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.LoginPage.*;
import static utils.Constants.PAGOS;
import static utils.Constants.VERSION;

public class CierreSesionSuperApp implements Task {

    private final User user = TestDataProvider.getRealUser();
    private static final String paso = "Cierre de sesión exitoso";

    @Override
    public <T extends Actor> void performAs(T actor) {

        // Si aparece "Iniciar sesión", significa que ya no hay una sesión activa
        if (isVisible(actor, LBL_INICIAR_SESION)) {
            EvidenciaUtils.registrarCaptura("La sesión ya se encuentra cerrada");
            return;
        }

        // Hay una sesión iniciada, se procede a cerrarla
        actor.attemptsTo(
                Click.on(MENU_USUARIO),
                ValidarTexto.validarTexto(user.getNombreUsuario()),
                ValidarTextoQueContengaX.elTextoContiene(VERSION),
                WaitFor.aTime(3000)
        );

        EvidenciaUtils.registrarCaptura(paso);

        actor.attemptsTo(
                Click.on(BTN_CERRAR_USUARIO),
                WaitFor.aTime(1000),
                ClickTextoQueContengaX.elTextoContiene("Si, cerrar"),
                WaitFor.aTime(2000)
        );

        // Validar que realmente quedó cerrada
        actor.attemptsTo(
                ValidarTextoQueContengaX.elTextoContiene("Iniciar sesión")
        );

        EvidenciaUtils.registrarCaptura("Sesión cerrada correctamente");
    }

    private <T extends Actor> boolean isVisible(T actor, Target element) {
        try {
            return !Presence.of(element).viewedBy(actor).resolveAll().isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    public static Performable cierreSesionSuperApp() {
        return instrumented(CierreSesionSuperApp.class);
    }
}