package tasks.EmpresasyNegocios.pagosFacturas;

import interactions.Click.ClickEnCoordenadas;
import interactions.Scroll.ScrollHorizontalCoordenadas;
import interactions.validations.ValidarTextoQueContengaX;
import interactions.wait.WaitFor;
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
import static userinterfaces.EmpresasNegociosPage.SELECIONAR_MEDIOS_DE_PAGO;
import static userinterfaces.LoginPage.LOADING_SPLASH;
import static userinterfaces.PagosYConsultasPage.BTN_PAGAR;

public class ValidarMedioDePagoBancolombia implements Task {

    private final User user = TestDataProvider.getRealUser();

    private static final String paso1 = "Validar redirección al Portal de Pagos Claro";
    private static final String paso2 = "Validar medio de pago Botón Bancolombia";
    private static final String paso3 = "Validar redireccion a Bancolombia";

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitFor.aTime(1000),
                Click.on(BTN_PAGAR),
                WaitUntil.the(LOADING_SPLASH, isNotPresent()),
                ValidarTextoQueContengaX.elTextoContiene("Portal Pagos Claro"),
                ScrollHorizontalCoordenadas.desde(339, 200, 339, 1490),
                WaitFor.aTime(2000)
        );

        EvidenciaUtils.registrarCaptura(paso1);

        actor.attemptsTo(
                ScrollHorizontalCoordenadas.desde(339, 1490, 339, 200),
                WaitFor.aTime(2000),
                Click.on(SELECIONAR_MEDIOS_DE_PAGO),
                WaitFor.aTime(1000),
                ValidarTextoQueContengaX.elTextoContiene("Botón Bancolombia"),
                WaitFor.aTime(1000)
        );

        EvidenciaUtils.registrarCaptura(paso2);
        /*actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Botón Bancolombia"),
                WaitFor.aTime(2000),
                ClickTextoQueContengaX.elTextoContiene("Continuar"),
                WaitFor.aTime(10000),
                ValidarTextoQueContengaX.elTextoContiene("Autenticación Bancolombia")


        );*/
    }

    public static Performable validarMedioDePagoBancolombia() {
        return instrumented(ValidarMedioDePagoBancolombia.class);
    }
}