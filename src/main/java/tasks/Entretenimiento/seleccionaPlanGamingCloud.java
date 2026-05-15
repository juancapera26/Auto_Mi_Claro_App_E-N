package tasks.Entretenimiento;

import interactions.Click.ClickEnCoordenadas;
import interactions.Click.ClickTextoQueContengaX;
import interactions.Scroll.Scroll;
import interactions.validations.ValidarTexto;
import interactions.validations.ValidarTextoQueContengaX;
import interactions.wait.WaitFor;
import interactions.wait.WaitForResponse;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import utils.EvidenciaUtils;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.EntretenimientoPage.*;
import static utils.Constants.ACEPTAR_2;
import static utils.Constants.ESCRIBIR_CODIGO_VENDEDOR;

public class seleccionaPlanGamingCloud implements Task {

    private static final String paso = "validar anuncios de Claro Gaming Cloud";
    private static final String paso1 = "Activar Claro Gaming Cloud";
    private static final String paso2 = "validar plan Claro Gaming Cloud";
    private static final String paso3 = "Validar y aceptar Términos y Condiciones Claro Gaming Cloud";
    private static final String paso4 = " TC";
    private static final String paso5 = "confirmar compra";
    private static final String paso6 = "Boton Aceptar";

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitFor.aTime(5000),

                ValidarTextoQueContengaX.elTextoContiene(
                        "Comparte Claro Gaming Cloud con tu familia"
                )
        );

        // Tomar 3 pantallazos
        for (int i = 1; i <= 3; i++) {

            // Espera 2 segundos
            actor.attemptsTo(
                    WaitFor.aTime(1000)
            );

            // Pantallazo
            EvidenciaUtils.registrarCaptura(
                    paso + " " + i
            );
        }
        WaitFor.aTime(2000);
        actor.attemptsTo(
                ClickEnCoordenadas.en(551, 2108)
        );
        EvidenciaUtils.registrarCaptura(paso1);
        actor.attemptsTo(

                ValidarTextoQueContengaX.elTextoContiene("Claro Cloud Gaming"),
                Scroll.scrollUnaVista(),
                Scroll.scrollUnaVista(),
                ValidarTexto.validarTexto(ESCRIBIR_CODIGO_VENDEDOR));
        EvidenciaUtils.registrarCaptura(paso2);
        actor.attemptsTo(Click.on(CHECK_TERMINOS_CLARO_GAMING_CLOUD));
        EvidenciaUtils.registrarCaptura(paso3);
        actor.attemptsTo(ClickTextoQueContengaX.elTextoContiene("Suscribirse"));

        EvidenciaUtils.registrarCaptura(paso4);
                actor.attemptsTo(ClickEnCoordenadas.en(556, 1389));
        EvidenciaUtils.registrarCaptura(paso5);
        actor.attemptsTo(ClickEnCoordenadas.en(560, 1207));
        EvidenciaUtils.registrarCaptura(paso6);
        WaitFor.aTime(2000);



    }

    public static Performable seleccionar() {
        return instrumented(seleccionaPlanGamingCloud.class);
    }
}