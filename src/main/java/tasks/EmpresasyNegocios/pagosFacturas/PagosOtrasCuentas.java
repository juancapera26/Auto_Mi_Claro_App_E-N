package tasks.EmpresasyNegocios.pagosFacturas;

import interactions.Click.ClickElementByText;
import interactions.Click.ClickTextoQueContengaX;
import interactions.EmpresasyNegocios.ValidarAcercaDe;
import interactions.validations.ValidarTextoQueContengaX;
import interactions.wait.WaitFor;
import interactions.wait.WaitForResponse;
import models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import utils.EvidenciaUtils;
import utils.TestDataProvider;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static userinterfaces.EntretenimientoPage.BTN_VOLVER;
import static userinterfaces.LoginPage.LOADING_ESPERA_UN_MOMENTO;


public class PagosOtrasCuentas implements Task {
    private final User user = TestDataProvider.getRealUser();
    private static final String paso1 = "Ingreso a pagos a otras cuentas";
    private static final String paso2 = "Validar mini version del programa";
    private static final String paso3 = "Ingreso a Portal pagos claro";
    private static final String paso4 = "Opciones para escoger el servicio que quieres pagar";

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ValidarTextoQueContengaX.elTextoContiene("Pagos a otras cuentas"),
                ClickTextoQueContengaX.elTextoContiene("Pagos a otra cuentas"),
                WaitFor.aTime(5000),
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent()),
                WaitForResponse.withText("Pagos en linea")
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
                ValidarTextoQueContengaX.elTextoContiene("Pagos en linea"),
                ClickElementByText.clickElementByText("Continuar"),
                WaitFor.aTime(5000),
                WaitForResponse.withText("Información Importante")
        );
        EvidenciaUtils.registrarCaptura(paso3);

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Entendido"),
                ValidarTextoQueContengaX.porTiempo("Elige",60),
                ClickTextoQueContengaX.elTextoContiene("Elige el servicio que quieres pagar")
        );
        EvidenciaUtils.registrarCaptura(paso4);

    }


    public static Performable pagosOtrasCuentas() {
        return instrumented(PagosOtrasCuentas.class);
    }

}
