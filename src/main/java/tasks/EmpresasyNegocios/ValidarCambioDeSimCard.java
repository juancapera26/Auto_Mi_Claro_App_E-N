package tasks.EmpresasyNegocios;

import interactions.Click.ClickTextoQueContengaX;
import interactions.Scroll.ScrollHorizontalCoordenadas;
import interactions.validations.ValidarTexto;
import interactions.validations.ValidarTextoQueContengaX;
import interactions.wait.WaitFor;
import models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import utils.EvidenciaUtils;
import utils.TestDataProvider;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.EmpresasNegociosPage.VER_PUNTOS_ATENCION;
import static userinterfaces.EntretenimientoPage.BTN_VOLVER;
import static userinterfaces.PagosYConsultasPage.BTN_TRES_PUNTOS_MAS;
import static utils.Constants.*;

public class ValidarCambioDeSimCard implements Task {
    private final User user = TestDataProvider.getRealUser();

    private static final String paso1 = "validar version de miniprograma";
    private static final String paso2 = "ingresar Traslado";
    private static final String paso3 = "como pudo realizar el cabio de SIM card para mi empresa";
    private static final String paso4 = "scroll para validar informacion";
    private static final String paso5 = "ver puntos de atencion";

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitFor.aTime(1000),
                Click.on(BTN_TRES_PUNTOS_MAS),
                ClickTextoQueContengaX.elTextoContiene(ACERCA_DE),
                WaitFor.aTime(1000),
                ValidarTexto.validarTexto(INFORMACION_TRAMITE),
                ValidarTexto.validarTexto(DECLARACION_SERVICIO),
                ValidarTextoQueContengaX.elTextoContiene(VER)
        );

///

        EvidenciaUtils.registrarCaptura(paso1);

        actor.attemptsTo(Click.on(BTN_VOLVER));

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(CAMBIO_SIM_CARD));

        EvidenciaUtils.registrarCaptura(paso2);

        actor.attemptsTo(
                ValidarTextoQueContengaX.elTextoContiene("¿Cómo hago el cambio de SIM card para mi empresa?")

        );

        EvidenciaUtils.registrarCaptura(paso3);

        actor.attemptsTo(
                ScrollHorizontalCoordenadas.desde(510, 1657, 510,597)
        );

        EvidenciaUtils.registrarCaptura(paso4);

        actor.attemptsTo(
                WaitFor.aTime(2000)
        );

        actor.attemptsTo(
                Click.on(VER_PUNTOS_ATENCION),
                WaitFor.aTime(3000)
        );
        EvidenciaUtils.registrarCaptura(paso5);

    }

    public static Performable validarCambioDeSimCard() {
        return instrumented(ValidarCambioDeSimCard.class);
    }
}

