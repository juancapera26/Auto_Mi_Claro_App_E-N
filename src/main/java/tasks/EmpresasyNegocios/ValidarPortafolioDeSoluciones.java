package tasks.EmpresasyNegocios;

import interactions.Click.ClickTextoQueContengaX;
import interactions.Scroll.ScrollHorizontalCoordenadas;
import interactions.validations.ValidarTexto;
import interactions.validations.ValidarTextoQueContengaX;
import interactions.wait.WaitFor;
import interactions.wait.WaitForResponse;
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
import static utils.Constants.CAMBIO_SIM_CARD;

public class ValidarPortafolioDeSoluciones implements Task {
    private final User user = TestDataProvider.getRealUser();
    private static final String paso1 = "Ingresar a informacion de tramites";
    private static final String paso2 = "validar version de miniprograma";
    private static final String paso3 = "ingresar Cambio de plan";
    private static final String paso4 = "como pudo realizar el cambio de plan";
    private static final String paso5 = "scroll hasta el link de clarocloud";
    private static final String paso6 = "ver puntos de atencion";


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(PORTAFOLIO_DE_SOLUCIONES),
                WaitForResponse.withText(PORTAFOLIO_DE_SOLUCIONES));

        EvidenciaUtils.registrarCaptura(paso1);

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

        EvidenciaUtils.registrarCaptura(paso2);

        actor.attemptsTo(Click.on(BTN_VOLVER));

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(CLOUD),
                ValidarTextoQueContengaX.elTextoContiene("¿qué es Claro Cloud?")
        );

        EvidenciaUtils.registrarCaptura(paso3);

        actor.attemptsTo(Click.on(BTN_VOLVER));

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(SOLUCIONES_MOVILES),
                ValidarTextoQueContengaX.elTextoContiene("Los mejores planes de voz y datos para tu negocio")
        );

        EvidenciaUtils.registrarCaptura(paso4);

        actor.attemptsTo(Click.on(BTN_VOLVER));

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(INTERNET),
                ValidarTextoQueContengaX.elTextoContiene("El ritmo de tu comunicacíon es el ritmo de tus negocios")
        );

        EvidenciaUtils.registrarCaptura(paso5);

        actor.attemptsTo(Click.on(BTN_VOLVER));

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(TELEVISION),
                ValidarTextoQueContengaX.elTextoContiene("Televisíon")
        );

        EvidenciaUtils.registrarCaptura(paso5);

        actor.attemptsTo(Click.on(BTN_VOLVER));

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(INTERNET_DE_LAS_COSAS),
                ValidarTextoQueContengaX.elTextoContiene(INTERNET_DE_LAS_COSAS)
        );

        EvidenciaUtils.registrarCaptura(paso5);
        
        actor.attemptsTo(Click.on(BTN_VOLVER));

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(INTERNET_DE_LAS_COSAS),
                ValidarTextoQueContengaX.elTextoContiene(INTERNET_DE_LAS_COSAS)
        );

        EvidenciaUtils.registrarCaptura(paso5);


    }


    public static Performable validarPortafolioDeSoluciones() {
        return instrumented(ValidarPortafolioDeSoluciones.class);
    }
}
