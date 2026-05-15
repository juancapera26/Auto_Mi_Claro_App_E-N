package tasks.Entretenimiento.ValidarRedirecciones;

import interactions.validations.ValidarTextoQueContengaX;
import interactions.wait.WaitForResponse;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import utils.EvidenciaUtils;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class validaRedireccionamientoIdClaroGamingCloud  implements Task {

    private static final String paso = "Validar pantalla de Identificación de Cliente";

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                // Espera breve para asegurar carga

                ValidarTextoQueContengaX.elTextoContiene("Verifiquemos tus datos"));
        EvidenciaUtils.registrarCaptura(paso);
    }

    public static Performable validar() {
        return instrumented(validaRedireccionamientoIdClaroGamingCloud.class);
    }
}
