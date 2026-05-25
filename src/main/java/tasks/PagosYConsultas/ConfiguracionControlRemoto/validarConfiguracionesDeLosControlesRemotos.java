package tasks.PagosYConsultas.ConfiguracionControlRemoto;

import interactions.Click.ClickTextoQueContengaX;
import interactions.Scroll.ScrollHorizontalCoordenadas;
import interactions.validations.ValidarTextoQueContengaX;
import interactions.wait.WaitFor;
import interactions.wait.WaitForResponse;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import utils.EvidenciaUtils;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.EntretenimientoPage.BTN_VOLVER;

public class validarConfiguracionesDeLosControlesRemotos implements Task {
    private static final String paso1 = "ingrsar a Configuracion control motorola";
    private static final String paso2 = "ingrsar a Codigos del control motorola";
    private static final String paso3 = "ingrsar a Configuracion control Universal1";
    private static final String paso4 = "ingrsar a Codigos del control Universal1";
    private static final String paso5 = "ingrsar a Configuracion control Universal2";
    private static final String paso6 = "ingrsar a Codigos del control Universal2";
    private static final String paso7 = "ingrsar a Configuracion control DVB";


    @Override
    public <T extends Actor> void performAs(T actor) {
//Motorola
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Motorola"),
                ValidarTextoQueContengaX.elTextoContiene("Motorola")
        );
        EvidenciaUtils.registrarCaptura(paso1);
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Códigos de TV"),
                WaitFor.aTime(4000)

        );
        EvidenciaUtils.registrarCaptura(paso2);
        actor.attemptsTo(
                Click.on(BTN_VOLVER)
        );
        actor.attemptsTo(
                Click.on(BTN_VOLVER)
        );
        //Universal
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Universal1"),
                ValidarTextoQueContengaX.elTextoContiene("Universal1")
        );
        EvidenciaUtils.registrarCaptura(paso3);
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Códigos de TV"),
                WaitFor.aTime(4000)

        );
        EvidenciaUtils.registrarCaptura(paso4);
        actor.attemptsTo(
                Click.on(BTN_VOLVER)

        );
        actor.attemptsTo(
                Click.on(BTN_VOLVER),
                ScrollHorizontalCoordenadas.desde(991, 810, 77, 810),
                WaitFor.aTime(4000)
        );
        //Universal2
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Universal2"),
                ValidarTextoQueContengaX.elTextoContiene("Universal2")
        );
        EvidenciaUtils.registrarCaptura(paso5);
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Códigos de TV"),
                WaitFor.aTime(4000)

        );
        EvidenciaUtils.registrarCaptura(paso6);
        actor.attemptsTo(
                Click.on(BTN_VOLVER)
        );
        actor.attemptsTo(
                Click.on(BTN_VOLVER)
        );
        //DVB
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("DVB")

        );
        EvidenciaUtils.registrarCaptura(paso7);



    }

    public static Performable validar() {
        return instrumented(validarConfiguracionesDeLosControlesRemotos.class);
    }
}