package tasks.EmpresasyNegocios;
import interactions.Click.ClickElementByText;
import interactions.Click.ClickTextoQueContengaX;
import interactions.Scroll.Scroll;
import interactions.Scroll.ScrollHastaTexto;
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

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static userinterfaces.EmpresasNegociosPage.BTN_CUENTAS_CORREO;
import static userinterfaces.EntretenimientoPage.BTN_VOLVER;
import static userinterfaces.LoginPage.BTN_CONTINUAR;
import static userinterfaces.LoginPage.LOADING_SPLASH;
import static userinterfaces.PagosYConsultasPage.BTN_TRES_PUNTOS_MAS;
import static utils.Constants.*;

public class IngresarConsultaServiciosfijos implements Task {
    private static final User user = TestDataProvider.getRealUser();
    private static final String paso1 = "Ingreso a Consulta servicios fijos";
    private static final String paso2 = "Validar Mini Versión";
    private static final String paso3 = "Validar menu tus servicios fijos";
    private static final String paso4 = "Validar Mini version tus servicios fijos";
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ValidarTextoQueContengaX.elTextoContiene("Consulta los detalles de tus soluciones"),
                ClickTextoQueContengaX.elTextoContiene("Consulta servicios fijos"),
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
        actor.attemptsTo(
                Click.on(BTN_TRES_PUNTOS_MAS),
                ClickTextoQueContengaX.elTextoContiene(ACERCA_DE),
                WaitFor.aTime(3000),
                ValidarTextoQueContengaX.elTextoContiene("Consulta servicios fijos"),
                ValidarTexto.validarTexto(DECLARACION_SERVICIO),
                ValidarTextoQueContengaX.elTextoContiene(VER));
        EvidenciaUtils.registrarCaptura(paso4);
        actor.attemptsTo(
                Click.on(BTN_VOLVER),
                ValidarTextoQueContengaX.elTextoContiene("Tus servicios fijos")
        );

    }

    public static Performable ingresarConsultaServiciosfijos() {
        return instrumented(IngresarConsultaServiciosfijos.class);
    }
}
