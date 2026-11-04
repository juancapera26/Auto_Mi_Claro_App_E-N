package tasks.EmpresasyNegocios.pagosFacturas;

import interactions.Click.ClickElementByText;
import interactions.Click.ClickForzado;
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
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import utils.EvidenciaUtils;
import utils.TestDataProvider;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static userinterfaces.EntretenimientoPage.BTN_VOLVER;
import static userinterfaces.LoginPage.LOADING_ESPERA_UN_MOMENTO;
import static userinterfaces.PagosYConsultasPage.*;

public class ConsultaTuFactura implements Task {

    private final User user = TestDataProvider.getRealUser();
    private static final String paso1 = "Ingresa a Consulta tu factura";
    private static final String paso2 = "Validar miniprograma";
    private static final String paso3 = "Ingresa a analisis grafico";
    private static final String paso4 = "Ingresa a Descarga tu factura";
    private static final String paso5 = "Valida Soluciones fijas HFC descarga tu factura";
    private static final String paso6 = "Valida Soluciones moviles y equipos financiados";
    private static final String paso7 = "Valida órdenes de compra";

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ValidarTextoQueContengaX.elTextoContiene("Consulta tu factura"),
                ClickTextoQueContengaX.elTextoContiene("Consulta tu factura"),
                WaitFor.aTime(6000),
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent()),
                WaitForResponse.withText("Consulta tu factura")
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
                ValidarTextoQueContengaX.elTextoContiene("Consulta tu factura"),
                ClickElementByText.clickElementByText("Análisis gráfico"),
                WaitFor.aTime(5000),
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent()),
                WaitForResponse.withText("Número de Documento:")
        );
        EvidenciaUtils.registrarCaptura(paso3);

        actor.attemptsTo(
                NavegarAtras.enElDispositivo(),
                ValidarTextoQueContengaX.porTiempo("Consulta tu factura",60),
                ClickTextoQueContengaX.elTextoContiene("Descarga tu factura"),
                WaitFor.aTime(5000),
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent()),
                ValidarTextoQueContengaX.porTiempo("Documento",60),
                WaitFor.aTime(10000)
        );
        EvidenciaUtils.registrarCaptura(paso4);
        // PASO 5
        actor.attemptsTo(
                WaitForResponse.withText("Documento/NIT"),
                ClickForzado.sobre(BTN_SOLUCIONES_FIJAS),
                WaitFor.aTime(2000),
                ValidarTextoQueContengaX.elTextoContiene("Nro. cuenta:")
        );
        EvidenciaUtils.registrarCaptura(paso5);

        // PASO 6
        actor.attemptsTo(
                ClickForzado.sobre(BTN_SOLUCIONES_FIJAS), // Cierra la tarjeta anterior
                WaitFor.aTime(1000),
                ClickForzado.sobre(BTN_SOLUCIONES_MOVILES), // Abre la nueva tarjeta
                WaitFor.aTime(2000),
                ValidarTextoQueContengaX.elTextoContiene("Nro. cuenta:")
        );
        EvidenciaUtils.registrarCaptura(paso6);

        // PASO 7
        actor.attemptsTo(
                ClickForzado.sobre(BTN_SOLUCIONES_MOVILES), // Cierra la tarjeta anterior
                WaitFor.aTime(1000),
                ClickForzado.sobre(BTN_ORDENES_COMPRA), // Abre la nueva tarjeta
                WaitFor.aTime(2000),
                ValidarTextoQueContengaX.elTextoContiene("Nro. cuenta:")
        );
        EvidenciaUtils.registrarCaptura(paso7);
    }



    public static Performable consultaTuFactura() {
        return instrumented(ConsultaTuFactura.class);
    }
}