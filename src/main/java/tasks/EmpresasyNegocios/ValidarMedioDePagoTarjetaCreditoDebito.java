package tasks.EmpresasyNegocios;

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
import utils.EvidenciaUtils;
import utils.TestDataProvider;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.EmpresasNegociosPage.SELECIONAR_MEDIOS_DE_PAGO;

public class ValidarMedioDePagoTarjetaCreditoDebito implements Task {

    private final User user = TestDataProvider.getRealUser();

    private static final String paso1 = "Validar redirección al Portal de Pagos Claro";
    private static final String paso2 = "Seleccionar medio de pago Tarjeta de Crédito - Débito";

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                ClickEnCoordenadas.en(354, 1438),
                WaitFor.aTime(3000),
                ValidarTextoQueContengaX.elTextoContiene("Portal Pagos Claro"),
                ScrollHorizontalCoordenadas.desde(339, 200, 339, 1490),
                WaitFor.aTime(2000)
        );

        EvidenciaUtils.registrarCaptura(paso1);

        actor.attemptsTo(
                ScrollHorizontalCoordenadas.desde(339, 1490, 339, 200),
                Click.on(SELECIONAR_MEDIOS_DE_PAGO),
                WaitFor.aTime(1000),
                ClickTextoQueContengaX.elTextoContiene("Tarjeta de Crédito - Débito"),
                WaitFor.aTime(3000)
        );

        EvidenciaUtils.registrarCaptura(paso2);
    }

    public static Performable validarMedioDePagoTarjetaCreditoDebito() {
        return instrumented(ValidarMedioDePagoTarjetaCreditoDebito.class);
    }
}