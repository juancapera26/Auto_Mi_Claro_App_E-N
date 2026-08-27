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

public class IngresarGestionarLineasNuevas implements Task {
    private static final User user = TestDataProvider.getRealUser();
    private static final String paso1 = "Ingreso a gestionar lineas nuevas empresas";
    private static final String paso2 = "Validar Mini Versión";
    private static final String paso3 = "Validar solicitar lineas nuevas";
    private static final String paso4 = "Validar solicitudes finalizadas";
    private static final String paso5 = "Validar estado de solicitudes finalizadas";
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ValidarTextoQueContengaX.elTextoContiene("Soluciones móviles"),
                ClickTextoQueContengaX.elTextoContiene("Gestionar líneas nuevas empresas"),
                WaitUntil.the(LOADING_SPLASH, isNotPresent())
        );
        EvidenciaUtils.registrarCaptura(paso1);
        actor.attemptsTo(
                Click.on(BTN_TRES_PUNTOS_MAS),
                ClickTextoQueContengaX.elTextoContiene(ACERCA_DE),
                WaitFor.aTime(1500),
                ValidarTexto.validarTexto("Gestionar líneas nuevas empresas"),
                ValidarTexto.validarTexto(DECLARACION_SERVICIO),
                ValidarTextoQueContengaX.elTextoContiene(VER));

        EvidenciaUtils.registrarCaptura(paso2);
        WaitFor.aTime(2500);

        actor.attemptsTo(Click.on(BTN_VOLVER));

        actor.attemptsTo(
                ValidarTextoQueContengaX.elTextoContiene("Gestionar líneas nuevas"),
                ClickTextoQueContengaX.elTextoContiene("Solicitar líneas nuevas"),
                WaitFor.aTime(1000)
        );
        EvidenciaUtils.registrarCaptura(paso3);
        actor.attemptsTo(ClickTextoQueContengaX.elTextoContiene("Cancelar"));

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Solicitudes finalizadas"),
                WaitUntil.the(LOADING_SPLASH, isNotPresent()),
                ValidarTextoQueContengaX.elTextoContiene("Solicitudes finalizadas")
        );
        EvidenciaUtils.registrarCaptura(paso4);
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("27/5/2026"),
                WaitUntil.the(LOADING_SPLASH, isNotPresent()),
                ValidarTextoQueContengaX.elTextoContiene("Estado de activación")
        );
        EvidenciaUtils.registrarCaptura(paso5);
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Ver resumen de la solicitud"),
                WaitFor.aTime(1000),
                ValidarTextoQueContengaX.elTextoContiene("Estado de activación")
        );
        actor.attemptsTo(
                Click.on(BTN_VOLVER),
                ValidarTextoQueContengaX.elTextoContiene("Tus servicios fijos")
        );

    }

    public static Performable ingresarGestionarLineasNuevas() {
        return instrumented(IngresarGestionarLineasNuevas.class);
    }
}
