package tasks.PagosYConsultas.AdquirirProductos;

import interactions.Click.ClickTextoQueContengaX;
import interactions.wait.WaitFor;
import models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import utils.EvidenciaUtils;
import utils.TestDataProvider;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.EntretenimientoPage.BTN_VOLVER;

public class ValidarModuloTelevision implements Task {
    private static final String paso1 = "ingrsar a internet";
    private static final String paso2 = "Validar opcion de Movimiento o reinstalación de punto";
    private static final String paso3 = "Validar opcion Punto adicional";

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Televisión")

        );
        EvidenciaUtils.registrarCaptura(paso1);
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Movimiento")

        );
        EvidenciaUtils.registrarCaptura(paso2);
        actor.attemptsTo(
                Click.on(BTN_VOLVER)

        );
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Punto adicional"),
                WaitFor.aTime(3000)

        );
        EvidenciaUtils.registrarCaptura(paso3);
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Volver")


        );
        actor.attemptsTo(
                Click.on(BTN_VOLVER)

        );

    }

    public static Performable validar() {
        return instrumented(ValidarModuloTelevision.class);
    }
}