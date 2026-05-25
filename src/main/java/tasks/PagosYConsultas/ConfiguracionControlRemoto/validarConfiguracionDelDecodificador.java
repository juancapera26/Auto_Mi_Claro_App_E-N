package tasks.PagosYConsultas.ConfiguracionControlRemoto;

import interactions.Click.ClickTextoDebajo;
import interactions.Click.ClickTextoQueContengaX;
import interactions.Scroll.ScrollHorizontalCoordenadas;
import interactions.validations.ValidarTextoQueContengaX;
import interactions.wait.WaitFor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import utils.EvidenciaUtils;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.EntretenimientoPage.BTN_VOLVER;

public class validarConfiguracionDelDecodificador implements Task {

    private static final String paso1 = "ingrsar a Configuracion control Universal1";
    private static final String paso2 = "ingrsar a Codigos del control Universal1";
    private static final String paso3 = "ingrsar a Configuracion control Universal2";
    private static final String paso4 = "ingrsar a Codigos del control Universal2";
    private static final String paso5 = "ingrsar a Configuracion control motorola";



    @Override
    public <T extends Actor> void performAs(T actor) {

        //Universal
        actor.attemptsTo(
                ClickTextoDebajo.de(
                        "Configuración con el decodificador",
                        "Universal1"
                ),
                ValidarTextoQueContengaX.elTextoContiene("Universal1")
        );
        EvidenciaUtils.registrarCaptura(paso1);
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Códigos de Deco"),
                ValidarTextoQueContengaX.elTextoContiene("Códigos de decodificador"),
                WaitFor.aTime(4000)

        );
        EvidenciaUtils.registrarCaptura(paso2);
        actor.attemptsTo(
                Click.on(BTN_VOLVER)

        );
        actor.attemptsTo(
                Click.on(BTN_VOLVER),
                ScrollHorizontalCoordenadas.desde(810, 1702, 77, 1702),
                WaitFor.aTime(4000)
        );
        //Universal2
        actor.attemptsTo(
                ClickTextoDebajo.de(
                        "Configuración con el decodificador",
                        "Universal2"
                ),
                ValidarTextoQueContengaX.elTextoContiene("Universal2")
        );
        EvidenciaUtils.registrarCaptura(paso3);
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Códigos de Deco"),
                ValidarTextoQueContengaX.elTextoContiene("Códigos de decodificador"),
                WaitFor.aTime(4000)

        );
        EvidenciaUtils.registrarCaptura(paso4);
        actor.attemptsTo(
                Click.on(BTN_VOLVER)
        );
        actor.attemptsTo(
                Click.on(BTN_VOLVER)
        );
        //Motorola
        actor.attemptsTo(
                ClickTextoDebajo.de(
                        "Configuración con el decodificador",
                        "Motorola"
                )

        );
        EvidenciaUtils.registrarCaptura(paso5);




    }

    public static Performable validar() {
        return instrumented(validarConfiguracionDelDecodificador.class);
    }
}