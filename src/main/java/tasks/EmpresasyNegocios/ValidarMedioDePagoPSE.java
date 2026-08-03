package tasks.EmpresasyNegocios;

import interactions.Click.ClickEnCoordenadas;
import interactions.Scroll.ScrollHorizontalCoordenadas;
import interactions.validations.ValidarElementoVisible;
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
import static userinterfaces.EmpresasNegociosPage.VALIDAR_PSE;

public class ValidarMedioDePagoPSE implements Task {

    private final User user = TestDataProvider.getRealUser();

    private static final String paso1 = "Validar redirección al Portal de Pagos Claro";
    private static final String paso2 = "Validar medio de pago PSE";

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
                ValidarElementoVisible.elElemento(VALIDAR_PSE),
                WaitFor.aTime(1000)
        );

        EvidenciaUtils.registrarCaptura(paso2);
    }

    public static Performable validarMedioDePagoPSE() {
        return instrumented(ValidarMedioDePagoPSE.class);
    }
}