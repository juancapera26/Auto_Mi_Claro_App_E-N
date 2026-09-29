package tasks.EmpresasyNegocios.SolucionesFibraOptica;

import interactions.Click.ClickTextoQueContengaX;
import interactions.EmpresasyNegocios.ValidarAcercaDe;
import interactions.Scroll.ScrollHastaTexto;
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
import static utils.Constants.VER_MAS;

public class IngresaAdministrarFacturaFO implements Task {
    private static final String paso1 = "Ingresar a tus cuentas";
    private static final String paso2 = "Validar miniprograma: Espera un momento";
    private static final String paso3 = "Menu Administra tu factura";
    private static final String paso4 = "Validar miniprograma: Administrar Factura FO";

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Administrar factura FO"),
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
                ClickTextoQueContengaX.elTextoContiene("No. 12491848"),
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent()),
                WaitForResponse.withText("Administra tu factura"),
                ValidarTextoQueContengaX.porTiempo("Total a pagar",3)
        );
        EvidenciaUtils.registrarCaptura(paso3);
        actor.attemptsTo(
                ValidarAcercaDe.elMenu(),
                WaitFor.aTime(2500)
        );
        EvidenciaUtils.registrarCaptura(paso4);
        WaitFor.aTime(2500);

        actor.attemptsTo(Click.on(BTN_VOLVER));


    }

    public static Performable ingresaAdministrarFacturaFO() {
        return instrumented(IngresaAdministrarFacturaFO.class);
    }
}
