package tasks.PagosYConsultas.AdquirirProductos;

import interactions.Click.ClickTextoQueContengaX;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import utils.EvidenciaUtils;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.EntretenimientoPage.BTN_VOLVER;


public class ValidarModuloInternet implements Task {
    private static final String paso1 = "ingrsar a internet";
    private static final String paso2 = "Validar opcion de Movimiento o reinstalacion de conexion de red";
    private static final String paso3 = "Validar opcion Punto Cableado";



    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Internet")

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
                ClickTextoQueContengaX.elTextoContiene("Punto Cableado")

        );
        EvidenciaUtils.registrarCaptura(paso3);
        actor.attemptsTo(
                Click.on(BTN_VOLVER)

        );
        actor.attemptsTo(
                Click.on(BTN_VOLVER)

        );

    }

    public static Performable validar() {
        return instrumented(ValidarModuloInternet.class);
    }
}