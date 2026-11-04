package tasks.EmpresasyNegocios.pagosFacturas;

import interactions.Click.ClickElementByText;
import interactions.Click.ClickTextoQueContengaX;
import interactions.EmpresasyNegocios.NavegarAtras;
import interactions.EmpresasyNegocios.ValidarAcercaDe;
import interactions.Scroll.Scroll;
import interactions.Scroll.ScrollHastaTexto;
import interactions.validations.ValidarTextoQueContengaX;
import interactions.wait.WaitFor;
import interactions.wait.WaitForResponse;
import models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.ClickOnBy;
import net.serenitybdd.screenplay.waits.WaitUntil;
import tasks.EmpresasyNegocios.IngresarVisitasyTraslados;
import utils.EvidenciaUtils;
import utils.TestDataProvider;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static userinterfaces.EntretenimientoPage.BTN_VOLVER;
import static userinterfaces.LoginPage.LOADING_ESPERA_UN_MOMENTO;
import static userinterfaces.PagosYConsultasPage.BTN_INSCRIBIR_TARJETA;
import static userinterfaces.PagosYConsultasPage.BTN_INSCRIBIR_TARJETA2;

public class IngresaPagosAutomaticos implements Task {

    private final User user = TestDataProvider.getRealUser();
    private static final String paso1 = "Ingresa a pagos automaticos";
    private static final String paso2 = "Validar version mini programa";
    private static final String paso3 = "Ingreso a soluciones moviles";
    private static final String paso4 = "Validar Registrar nueva tarjeta";
    private static final String paso5 = "Validar Tarjetas inscritas";
    private static final String paso6 = "Validar facturas no inscritas";
    private static final String paso7 = "";

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ValidarTextoQueContengaX.elTextoContiene("Pagos automáticos"),
                ClickTextoQueContengaX.elTextoContiene("Pagos automáticos"),
                WaitFor.aTime(5000),
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent()),
                WaitForResponse.withText("Pagos automáticos")
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
                ValidarTextoQueContengaX.elTextoContiene("Pagos automáticos"),
                ClickElementByText.clickElementByText("Soluciones Móviles"),
                WaitFor.aTime(5000),
                WaitForResponse.withText("Soluciones Móviles")
        );
        EvidenciaUtils.registrarCaptura(paso3);

        actor.attemptsTo(
                ValidarTextoQueContengaX.porTiempo("Soluciones Móviles",60),
                ScrollHastaTexto.conTexto("Inscribir tarjeta:"),
                Click.on(BTN_INSCRIBIR_TARJETA),
                ValidarTextoQueContengaX.porTiempo("Opciones de Inscripción",60),
                Click.on(BTN_INSCRIBIR_TARJETA2),
                WaitForResponse.withText("Registrar Nueva Tarjeta")
        );
        EvidenciaUtils.registrarCaptura(paso4);
        actor.attemptsTo(
                ValidarTextoQueContengaX.porTiempo("Registrar Nueva Tarjeta", 60),
                Scroll.scrollUnaVista(),
                Scroll.scrollUnaVista(),
                Scroll.scrollUnaVista(),
                Scroll.scrollUnaVista(),
                ClickTextoQueContengaX.elTextoContiene("Regresar"),
                WaitForResponse.withText("Pagos automáticos"),
                ClickElementByText.clickElementByText("Soluciones Móviles"),
                WaitFor.aTime(5000),
                WaitForResponse.withText("Soluciones Móviles"),
                ClickTextoQueContengaX.elTextoContiene("Inscritas"),
                Scroll.scrollUnaVista()
        );
        EvidenciaUtils.registrarCaptura(paso5);
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("No Inscritas"),
                Scroll.scrollUnaVista()
        );
        EvidenciaUtils.registrarCaptura(paso6);


    }


    public static Performable ingresaPagosAutomaticos() {
        return instrumented(IngresaPagosAutomaticos.class);
    }
}