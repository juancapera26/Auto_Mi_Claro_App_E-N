package tasks.EmpresasyNegocios;

import interactions.Click.ClickElementByText;
import interactions.Click.ClickTextoQueContengaX;
import interactions.EmpresasyNegocios.ValidarAcercaDe;
import interactions.validations.ExisteTexto;
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
import static userinterfaces.LoginPage.LOADING_SPLASH;
import static userinterfaces.PagosYConsultasPage.BTN_HOME;
import static utils.Constants.*;

public class IngresarAdministrarFacturaHFC implements Task {
    private final User user = TestDataProvider.getRealUser();
    private static final String paso1 = "";
    private static final String paso2 = "";
    private static final String paso3 = "";
    private static final String paso4 = "";
    private static final String paso5 = "";
    private static final String paso6 = "";
    private static final String paso7 = "";

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ValidarTextoQueContengaX.elTextoContiene("Administrar factura HFC"),
                ClickTextoQueContengaX.elTextoContiene("Administrar factura HFC"),
                WaitFor.aTime(3000),
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent()),
                WaitForResponse.withText("Tus cuentas")
                //ValidarTextoQueContengaX.porTiempo("Tus cuentas",3)
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
                ClickTextoQueContengaX.elTextoContiene("No. 56220783"),
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent()),
                ValidarTextoQueContengaX.porTiempo("Administra tu factura", 3)
        );
        EvidenciaUtils.registrarCaptura(paso3);

        if (actor.asksFor(ExisteTexto.con(PAGAR))) {

            actor.attemptsTo(
                    WaitFor.aTime(1000),
                    ClickElementByText.clickElementByText(PAGAR),
                    WaitFor.aTime(5000),
                    ValidarTextoQueContengaX.elTextoContiene("Selecciona el medio de pago"),
                    ValidarTextoQueContengaX.elTextoContiene("Consulta")
            );

            EvidenciaUtils.registrarCaptura(paso4);

        actor.attemptsTo(
                Click.on(BTN_HOME),
                WaitUntil.the(LOADING_SPLASH, isNotPresent())
        );

        actor.attemptsTo(
                WaitForResponse.withText("Administra tu factura"),
                ClickTextoQueContengaX.elTextoContiene("Factura digital"),
                WaitForResponse.withText("Factura digital")
            );
        EvidenciaUtils.registrarCaptura(paso5);
        actor.attemptsTo(
                Click.on(BTN_VOLVER),
                WaitForResponse.withText("Administra tu factura")
        );
        actor.attemptsTo(
                ClickElementByText.clickElementByText("Descarga tu factura"),
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent()),
                WaitForResponse.withText("Abrir documento")
            );
            EvidenciaUtils.registrarCaptura(paso6);

    }



}
    public static Performable ingresarAdministrarFacturaHFC() {
        return instrumented(IngresarAdministrarFacturaHFC.class);
    }
}
