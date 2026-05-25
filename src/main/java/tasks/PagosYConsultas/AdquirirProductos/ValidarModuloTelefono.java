package tasks.PagosYConsultas.AdquirirProductos;

import interactions.Click.ClickTextoQueContengaX;
import interactions.validations.ValidarTextoQueContengaX;
import models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import utils.EvidenciaUtils;
import utils.TestDataProvider;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.PagosYConsultasPage.BTN_ACEPTAR;

public class ValidarModuloTelefono  implements Task {
    private static final String paso1 = "Validar mesanje Atualmente ya tienes contratado el servicio de telefonia en Telefonia";


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("TelefonÍa"),
                ValidarTextoQueContengaX.elTextoContiene("Actualmente ya tienes")
        );
        EvidenciaUtils.registrarCaptura(paso1);
        actor.attemptsTo(
                Click.on(BTN_ACEPTAR)
        );

    }

    public static Performable validar() {
        return instrumented(ValidarModuloTelefono.class);
    }
}
