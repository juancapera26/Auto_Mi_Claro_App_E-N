package tasks.EmpresasyNegocios.SolucionesFibraOptica;

import interactions.Click.ClickTextoQueContengaX;
import interactions.EmpresasyNegocios.ValidarAcercaDe;
import interactions.validations.ValidarTextoQueContengaX;
import interactions.wait.WaitFor;
import interactions.wait.WaitForResponse;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import utils.EvidenciaUtils;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static userinterfaces.EntretenimientoPage.BTN_VOLVER;
import static userinterfaces.LoginPage.LOADING_ESPERA_UN_MOMENTO;

public class IngresaPersonalizaWifiFO implements Task {
    private static final String paso1 = "Ingresar a tus cuentas";
    private static final String paso2 = "Valida version miniprograma: Espera un momento";
    private static final String paso3 = "Ingresa a menu Personaliza Wifi FO";
    private static final String paso4 = "Valida version miniprograma: Personaliza red wifi FO";
    private static final String paso5 = "Valida enlances TPT";


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Personaliza red wifi FO"),
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent()),
                WaitForResponse.withText("Tus cuentas")
        );

        EvidenciaUtils.registrarCaptura(paso1);
        actor.attemptsTo(
                ValidarAcercaDe.elMenu(),
                WaitFor.aTime(2500)
        );
        EvidenciaUtils.registrarCaptura(paso2);
        WaitFor.aTime(2500);

        actor.attemptsTo(Click.on(BTN_VOLVER));

        actor.attemptsTo(
                ValidarTextoQueContengaX.elTextoContiene("Tus cuentas"),
                ClickTextoQueContengaX.elTextoContiene("No. 12491848"),
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent()),
                WaitForResponse.withText("Total enlaces")
        );

        EvidenciaUtils.registrarCaptura(paso3);
        actor.attemptsTo(
                ValidarAcercaDe.elMenu(),
                WaitFor.aTime(2500)
        );
        EvidenciaUtils.registrarCaptura(paso4);
        WaitFor.aTime(2500);

        actor.attemptsTo(Click.on(BTN_VOLVER));

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("TPT0000295 - Bogotá"),
                WaitFor.aTime(2500),
                ValidarTextoQueContengaX.porTiempo("Ir al chat",3)
        );
        EvidenciaUtils.registrarCaptura(paso5);

    }

    public static Performable ingresaPersonalizaWifiFO() {
        return instrumented(IngresaPersonalizaWifiFO.class);
    }
}
