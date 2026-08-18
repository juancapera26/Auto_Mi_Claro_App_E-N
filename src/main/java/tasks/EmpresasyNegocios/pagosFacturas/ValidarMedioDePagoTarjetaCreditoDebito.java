package tasks.EmpresasyNegocios.pagosFacturas;

import interactions.Click.ClickEnCoordenadas;
import interactions.Click.ClickTextoQueContengaX;
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

public class ValidarMedioDePagoTarjetaCreditoDebito implements Task {

    private final User user = TestDataProvider.getRealUser();

    private static final String paso1 = "Validar redirección al Portal de Pagos Claro";
    private static final String paso2 = "Seleccionar medio de pago Tarjeta de Crédito - Débito";
    private static final String paso3 = "Validar registor de la Tarjeta de Crédito - Débito1";
    private static final String paso4 = "Validar registor de la Tarjeta de Crédito - Débito2";

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitFor.aTime(2000),
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
                ClickTextoQueContengaX.elTextoContiene("Tarjeta de Crédito - Débito"),
                WaitFor.aTime(2000)
        );

        EvidenciaUtils.registrarCaptura(paso2);

        /*actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Continuar"),
                WaitFor.aTime(5000),
                Scroll.scrollUnaVista(),
                // Número de tarjeta
                Enter.theValue("530310140640092").into(ESCRIBIR_NUMERO_TARJETA),
                // Fecha de vencimiento
                Click.on(SELECCIONAR_MES_VENCIMIENTO),
                ClickTextoQueContengaX.elTextoContiene("04"),
                Click.on(SELECCIONAR_ANO_VENCIMIENTO),
                ClickTextoQueContengaX.elTextoContiene("2028")
                );
        EvidenciaUtils.registrarCaptura(paso3);
        actor.attemptsTo(
                Scroll.scrollUnaVista(),
                Scroll.scrollUnaVista(),
                // Código de seguridad
                Enter.theValue("543").into(ESCRIBIR_CODIGO_SEGURIDAD),
                // Nobre y apellido
                Enter.theValue("LAURA A ROSERO S").into(NOMBRE_APELLIDO),
                // Número de cuotas
                Click.on(SELECCIONAR_NUMERO_CUOTAS),
                ClickTextoQueContengaX.elTextoContiene("3"),
                // Número telefónico
                Enter.theValue("3226918354").into(ESCRIBIR_NUMERO_TELEFONO)

        );

        EvidenciaUtils.registrarCaptura(paso4);*/

    }

    public static Performable validarMedioDePagoTarjetaCreditoDebito() {
        return instrumented(ValidarMedioDePagoTarjetaCreditoDebito.class);
    }
}