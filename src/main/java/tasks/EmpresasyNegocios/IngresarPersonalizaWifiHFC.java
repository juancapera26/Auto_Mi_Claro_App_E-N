package tasks.EmpresasyNegocios;

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

public class IngresarPersonalizaWifiHFC implements Task {
    private final User user = TestDataProvider.getRealUser();
    private static final String paso1 = "ingresar a pagos en línea";
    private static final String paso2 = "ingresar a soluciones moviles y selecionar factura";
    private static final String paso3 = "validar factura y opcion de pagar";


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ValidarTextoQueContengaX.elTextoContiene("Personaliza red wifi HFC"),
                ClickTextoQueContengaX.elTextoContiene("Personaliza red wifi HFC"),
                WaitFor.aTime(3000),
                WaitUntil.the(LOADING_SPLASH, isNotPresent())
        );
        EvidenciaUtils.registrarCaptura(paso1);
        actor.attemptsTo(
                Click.on(BTN_TRES_PUNTOS_MAS),
                ClickTextoQueContengaX.elTextoContiene(ACERCA_DE),
                WaitFor.aTime(1000),
                ValidarTexto.validarTexto(DECLARACION_SERVICIO),
                ValidarTextoQueContengaX.elTextoContiene(VER));

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
    }

    public static Performable ingresarPersonalizaWifiHFC() {
        return instrumented(IngresarPersonalizaWifiHFC.class);
    }
}
