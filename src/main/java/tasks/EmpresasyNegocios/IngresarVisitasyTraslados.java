package tasks.EmpresasyNegocios;

import interactions.EmpresasyNegocios.NavegarAtras;
import interactions.EmpresasyNegocios.ValidarAcercaDe;
import net.serenitybdd.screenplay.Task;

import interactions.validations.ValidarTexto;
import interactions.validations.ValidarTextoQueContengaX;
import net.serenitybdd.screenplay.Performable;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import interactions.Click.ClickTextoQueContengaX;
import interactions.Scroll.Scroll;
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
import static userinterfaces.EmpresasNegociosPage.SELECIONAR_FACTURA;
import static userinterfaces.EntretenimientoPage.BTN_VOLVER;
import static userinterfaces.LoginPage.LOADING_ESPERA_UN_MOMENTO;
import static userinterfaces.LoginPage.LOADING_SPLASH;
import static userinterfaces.PagosYConsultasPage.BTN_TRES_PUNTOS_MAS;
import static utils.Constants.*;

public class IngresarVisitasyTraslados implements Task {
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
                ValidarTextoQueContengaX.elTextoContiene("Visitas y Traslados"),
                ClickTextoQueContengaX.elTextoContiene("Visitas y Traslados"),
                WaitFor.aTime(3000),
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent())
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
                ValidarTextoQueContengaX.porTiempo("Gestiona las visitas técnicas", 3),
                ValidarTextoQueContengaX.elTextoContiene("Traslados")
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
                ClickTextoQueContengaX.elTextoContiene("Solicitar traslado"),
                WaitFor.aTime(3000),
                ValidarTextoQueContengaX.elTextoContiene("Gestiona las visitas")

        );
        EvidenciaUtils.registrarCaptura(paso5);
        actor.attemptsTo(
                ValidarTextoQueContengaX.elTextoContiene("Solicitar traslado"),
                ClickTextoQueContengaX.elTextoContiene("Interno"),
                WaitFor.aTime(1500),
                ClickTextoQueContengaX.elTextoContiene("Siguiente")
        );
        EvidenciaUtils.registrarCaptura(paso6);
        actor.attemptsTo(
                NavegarAtras.enElDispositivo(),
                WaitFor.aTime(2000)
        );
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Ver detalle")
        );
        EvidenciaUtils.registrarCaptura(paso7);
    }


    public static Performable ingresarVisitasyTraslados() {
        return instrumented(IngresarVisitasyTraslados.class);
    }
}


