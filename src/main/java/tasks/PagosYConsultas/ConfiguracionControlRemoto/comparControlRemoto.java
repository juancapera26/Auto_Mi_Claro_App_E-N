package tasks.PagosYConsultas.ConfiguracionControlRemoto;

import interactions.Click.ClickTextoQueContengaX;
import interactions.validations.ValidarTextoQueContengaX;
import interactions.wait.WaitFor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import tasks.PagosYConsultas.AdquirirProductos.ValidarModuloTelevision;
import utils.EvidenciaUtils;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.EntretenimientoPage.BTN_VOLVER;

public class comparControlRemoto implements Task {
    private static final String paso1 = "ingrsar a Compar control remoto validar informacion";

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Comprar control remoto")
        );

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Comprar control remoto"),
                ValidarTextoQueContengaX.elTextoContiene("Control universal"),
                ValidarTextoQueContengaX.elTextoContiene("Características")


        );
        EvidenciaUtils.registrarCaptura(paso1);

    }

    public static Performable validar() {
        return instrumented(comparControlRemoto.class);
    }
}