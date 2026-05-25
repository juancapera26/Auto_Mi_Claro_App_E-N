package tasks.PagosYConsultas.AdquirirProductos;

import interactions.Click.ClickTextoQueContengaX;
import interactions.validations.ValidarTextoQueContengaX;
import interactions.wait.WaitFor;
import interactions.wait.WaitForResponse;
import models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import utils.EvidenciaUtils;
import utils.TestDataProvider;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utils.Constants.VISITAS_TECNICOS_WHATSAPP_MENSAJE;
import static utils.Constants.VISITAS_TECNICOS_WHATSAPP_MENSAJE_AP;

public class ValidarModuloUltraWifi implements Task {
    private static final String paso1 = "Validar redireccion a WhatsApp ";

    @Override
    public <T extends Actor> void performAs(T actor) {


        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Ultra Wi-Fi"),
                WaitFor.aTime(3000)
        );
        actor.attemptsTo(
                WaitForResponse.withText("Claro Colombia"),
                ValidarTextoQueContengaX.elTextoContiene(VISITAS_TECNICOS_WHATSAPP_MENSAJE_AP)
        );
        EvidenciaUtils.registrarCaptura(paso1);


    }

    public static Performable validar() {
        return instrumented(ValidarModuloUltraWifi.class);
    }
}
