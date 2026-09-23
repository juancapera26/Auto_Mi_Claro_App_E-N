package tasks.EmpresasyNegocios;

import interactions.Click.ClickElementByText;
import interactions.Click.ClickTextoQueContengaX;
import interactions.EmpresasyNegocios.ValidarAcercaDe;
import interactions.Scroll.ScrollHastaTexto;
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
import static userinterfaces.EntretenimientoPage.BTN_VOLVER;
import static userinterfaces.LoginPage.LOADING_ESPERA_UN_MOMENTO;
import static utils.Constants.DESCARGAR;

public class IngresarCertificadoIPs implements Task {
    private final User user = TestDataProvider.getRealUser();
    private static final String paso1 = "ingresar a Visitas y trasladso";
    private static final String paso2 = "ingresar a version de miniprograma";
    private static final String paso3 = "validar menu de visitas y traslados";
    private static final String paso4 = "validar version de miniprograma";
    private static final String paso5 = "";
    private static final String paso6 = "";
    private static final String paso7 = "";

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ValidarTextoQueContengaX.elTextoContiene("Certificado IP"),
                ClickTextoQueContengaX.elTextoContiene("Certificado IP"),
                WaitFor.aTime(3000),
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent()),
                ValidarTextoQueContengaX.porTiempo("Tus cuentas",3)
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
                ValidarTextoQueContengaX.porTiempo("Elige", 3)
        );
        EvidenciaUtils.registrarCaptura(paso3);

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("190.146.245.245"),
                WaitFor.aTime(1500),
                ValidarTextoQueContengaX.elTextoContiene("Descargar"),
                ClickElementByText.clickElementByText(DESCARGAR),
                //ClickTextoQueContengaX.elTextoContiene("Descargar"),
                WaitFor.aTime(3000),
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent()),
                ValidarTextoQueContengaX.porTiempo("Abrir",5)
        );

        EvidenciaUtils.registrarCaptura(paso4);

    }

    public static Performable ingresarCertificadoIPs() {
        return instrumented(IngresarCertificadoIPs.class);
    }

}
