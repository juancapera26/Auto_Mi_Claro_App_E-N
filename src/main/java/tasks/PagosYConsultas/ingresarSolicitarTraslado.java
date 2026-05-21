package tasks.PagosYConsultas;
import interactions.Click.ClickTextoQueContengaX;
import interactions.Scroll.ScrollHastaTexto;
import interactions.wait.WaitForResponse;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import utils.EvidenciaUtils;
import static net.serenitybdd.screenplay.Tasks.instrumented;


import static utils.Constants.*;

public class ingresarSolicitarTraslado implements Task {
    private static final String paso1 = "Hacer clic en Devolucion de equipos";

    private static final String paso3 = "validar redireccion whatsApp ";

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(ScrollHastaTexto.conTexto(SOLICITAR_TRASLADO));

        EvidenciaUtils.registrarCaptura(paso1);

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(SOLICITAR_TRASLADO), WaitForResponse.withText(SOLICITAR_TRASLADO_WHATSAPP));

        EvidenciaUtils.registrarCaptura(paso3);
    }

    public static Performable IngresarSolicitarTraslado() {
        return instrumented(ingresarSolicitarTraslado.class);
    }
}