package tasks.PagosYConsultas.ConfiguracionControlRemoto;

import interactions.Click.ClickTextoQueContengaX;
import interactions.Scroll.Scroll;
import interactions.validations.ValidarTextoQueContengaX;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import tasks.PagosYConsultas.AdquirirProductos.ValidarModuloInternet;
import utils.EvidenciaUtils;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.EntretenimientoPage.BTN_VOLVER;

public class validarInformacionConfiguracionControlRemoto implements Task {
    private static final String paso1 = "ingrsar a configurar control remoto validar opciones";



    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                ValidarTextoQueContengaX.elTextoContiene("Configuración con el control remoto"),
                ValidarTextoQueContengaX.elTextoContiene("Configuración con el decodificador"),
                ValidarTextoQueContengaX.elTextoContiene("Comprar control remoto")

        );
        EvidenciaUtils.registrarCaptura(paso1);


    }
    public static Performable validar() {
        return instrumented(validarInformacionConfiguracionControlRemoto.class);
    }
}

