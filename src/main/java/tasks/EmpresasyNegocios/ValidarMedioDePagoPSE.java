package tasks.EmpresasyNegocios;

import interactions.Click.ClickEnCoordenadas;
import interactions.Click.ClickTextoQueContengaX;
import interactions.Scroll.Scroll;
import interactions.Scroll.ScrollHorizontalCoordenadas;
import interactions.validations.ValidarElementoVisible;
import interactions.validations.ValidarTextoQueContengaX;
import interactions.wait.WaitFor;
import models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import utils.EvidenciaUtils;
import utils.TestDataProvider;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.EmpresasNegociosPage.*;
import static userinterfaces.LoginPage.TXT_PASSWORD;

public class ValidarMedioDePagoPSE implements Task {

    private final User user = TestDataProvider.getRealUser();

    private static final String paso1 = "Validar redirección al Portal de Pagos Claro";
    private static final String paso2 = "Validar medio de pago PSE";
    private static final String paso3 = "Ingresar modolo de pago PSE";

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                ClickEnCoordenadas.en(354, 1438),
                WaitFor.aTime(4000),
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
                Click.on(VALIDAR_PSE),
                WaitFor.aTime(1000)
        );

        EvidenciaUtils.registrarCaptura(paso2);

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Continuar"),
                WaitFor.aTime(5000),
                Scroll.scrollUnaVista(),
                Scroll.scrollUnaVista(),
                Click.on(SELECCION_BANCO_PSE),
                ClickTextoQueContengaX.elTextoContiene("BANCO BBVA COLOMBIA S.A."),
                Click.on(SELECCION_CLIENTE_PSE),
                ClickTextoQueContengaX.elTextoContiene("Persona Natural"),
                Scroll.scrollUnaVista(),
                Click.on(SELECCION_TIPO_DOCUMENTO_PSE),
                ClickTextoQueContengaX.elTextoContiene("C.C. (Cédula de Ciudadanía)"),
                Enter.theValue(user.getCedula()).into(ESCRIBIR_DOCUMENTO_PSE),
                Enter.theValue("3226918354").into(ESCRIBIR_NUMERO_PSE)
        );
        EvidenciaUtils.registrarCaptura(paso3);
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Confirmar"),
                WaitFor.aTime(10000)
        );
    }

    public static Performable validarMedioDePagoPSE() {
        return instrumented(ValidarMedioDePagoPSE.class);
    }
}