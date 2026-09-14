package tasks.EmpresasyNegocios;
import interactions.Click.ClickTextoQueContengaX;
import interactions.Scroll.ScrollHorizontalCoordenadas;
import interactions.validations.ValidarElementoVisible;
import interactions.validations.ValidarTexto;
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
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static userinterfaces.EmpresasNegociosPage.*;
import static userinterfaces.EmpresasNegociosPage.VALIDAR_PSE;
import static userinterfaces.EntretenimientoPage.BTN_CERRAR_MINPROGRAMA;
import static userinterfaces.EntretenimientoPage.BTN_VOLVER;
import static userinterfaces.LoginPage.*;
import static userinterfaces.PagosYConsultasPage.BTN_PAGAR;
import static userinterfaces.PagosYConsultasPage.BTN_TRES_PUNTOS_MAS;
import static utils.Constants.*;
import interactions.EmpresasyNegocios.*;

public class IngresarConsultaServiciosfijos implements Task {
    private static final User user = TestDataProvider.getRealUser();
    private static final String paso1 = "Ingreso a Consulta servicios fijos";
    private static final String paso2 = "Validar Mini Versión";
    private static final String paso3 = "Validar menu tus servicios fijos";
    private static final String paso4 = "Validar Mini version tus servicios fijos";
    private static final String paso5 = "Validar Ingreso en Administra tu factura";
    private static final String paso6 = "";
    private static final String paso7 = "";
    private static final String paso8 = "";
    private static final String paso9 = "";
    private static final String paso10 = "";
    private static final String paso11 = "";
    private static final String paso12 = "";
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                ValidarTextoQueContengaX.elTextoContiene("Consulta los detalles de tus soluciones"),
                ClickTextoQueContengaX.elTextoContiene("Consulta servicios fijos"),
                WaitFor.aTime(3000),
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent())
        );
        EvidenciaUtils.registrarCaptura(paso1);
        actor.attemptsTo(
                ValidarAcercaDe.elMenu(), // Flujo optimizado
                WaitFor.aTime(2500)
        );

        EvidenciaUtils.registrarCaptura(paso2);
        WaitFor.aTime(2500);

        actor.attemptsTo(Click.on(BTN_VOLVER));

        actor.attemptsTo(
                ValidarTextoQueContengaX.elTextoContiene("Tus cuentas"),
                ClickTextoQueContengaX.elTextoContiene("No. 56220783"),
                WaitFor.aTime(3000),
                ValidarTextoQueContengaX.elTextoContiene("Tus servicios fijos"),
                ValidarTextoQueContengaX.elTextoContiene("Cuenta")
        );
        EvidenciaUtils.registrarCaptura(paso3);
        actor.attemptsTo(
                ValidarAcercaDe.elMenu(), // Flujo optimizado
                WaitFor.aTime(2500)
        );
        EvidenciaUtils.registrarCaptura(paso4);
        actor.attemptsTo(
                Click.on(BTN_VOLVER),
                ValidarTextoQueContengaX.elTextoContiene("Tus servicios fijos")
        );
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Administra"),
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent()),
                ValidarTexto.validarTexto("Administra tu factura"),
                ValidarTexto.validarTexto("Cuenta Maestra")
        );
        EvidenciaUtils.registrarCaptura(paso5);
        actor.attemptsTo(
                WaitFor.aTime(1000),
                Click.on(BTN_PAGAR),
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent()),
                ValidarTextoQueContengaX.elTextoContiene("Portal Pagos Claro"),
                ScrollHorizontalCoordenadas.desde(339, 200, 339, 1490),
                WaitFor.aTime(2000)
        );

        EvidenciaUtils.registrarCaptura(paso6);

        actor.attemptsTo(
                ScrollHorizontalCoordenadas.desde(339, 1490, 339, 200),
                WaitFor.aTime(2000),
                Click.on(SELECIONAR_MEDIOS_DE_PAGO),
                WaitFor.aTime(1000),
                ValidarElementoVisible.elElemento(VALIDAR_PSE),
                Click.on(VALIDAR_PSE),
                WaitFor.aTime(1000)
        );

        EvidenciaUtils.registrarCaptura(paso7);

        actor.attemptsTo(
                NavegarAtras.enElDispositivo(),
                WaitFor.aTime(3000),
                ClickTextoQueContengaX.elTextoContiene("Administra"),
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent()),
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent()),
                ValidarTexto.validarTexto("Administra tu factura"),
                ValidarTexto.validarTexto("Cuenta Maestra"),
                ClickTextoQueContengaX.elTextoContiene("Descarga tu factura"),
                WaitFor.aTime(3000)
        );
        EvidenciaUtils.registrarCaptura(paso8);

        actor.attemptsTo(
                NavegarAtras.enElDispositivo(),
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent()),
                ClickTextoQueContengaX.elTextoContiene("Factura digital"),
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent()),
                ValidarTextoQueContengaX.elTextoContiene("Factura digital")
        );
        EvidenciaUtils.registrarCaptura(paso9);
        actor.attemptsTo(
                Click.on(BTN_CERRAR_MINPROGRAMA),
                WaitFor.aTime(2000),
                ValidarTextoQueContengaX.elTextoContiene("Tus servicios fijos")
        );
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Gestiona tu visita"),
                WaitFor.aTime(4000),
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent()),
                ValidarTextoQueContengaX.elTextoContiene("Gestiona las visitas")
        );
        EvidenciaUtils.registrarCaptura(paso10);
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Solicitar traslado"),
                WaitFor.aTime(2000),
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent()),
                ValidarTextoQueContengaX.elTextoContiene("Gestiona las visitas técnicas")
        );
        EvidenciaUtils.registrarCaptura(paso11);
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Interno"),
                WaitFor.aTime(1500),
                ClickTextoQueContengaX.elTextoContiene("Siguiente")
        );
        EvidenciaUtils.registrarCaptura(paso12);
        actor.attemptsTo(
                Click.on(BTN_CERRAR_MINPROGRAMA)

        );



    }

    public static Performable ingresarConsultaServiciosfijos() {
        return instrumented(IngresarConsultaServiciosfijos.class);
    }
}

