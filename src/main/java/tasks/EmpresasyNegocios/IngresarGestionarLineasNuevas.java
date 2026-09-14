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
import static userinterfaces.LoginPage.*;
import static userinterfaces.PagosYConsultasPage.BTN_TRES_PUNTOS_MAS;
import static utils.Constants.*;

public class IngresarGestionarLineasNuevas implements Task {
    private static final User user = TestDataProvider.getRealUser();
    private static final String paso1 = "Ingreso a gestionar lineas nuevas empresas";
    private static final String paso2 = "Validar Mini Versión";
    private static final String paso3 = "Validar solicitar lineas nuevas";
    private static final String paso4 = "Validar solicitudes finalizadas";
    private static final String paso5 = "Validar estado de solicitudes finalizadas";
    private static final String paso6 = "Validar resumen de la solicitud";
    private static final String paso7 = "Validar listado de lineas activas";
    private static final String paso8 = "Validar Solicitudes en curso";
    private static final String paso9 = "Validar Solicitudes en curso";
    private static final String paso10 = "Validar Solicitudes en curso";
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ValidarTextoQueContengaX.elTextoContiene("Soluciones móviles"),
                ClickTextoQueContengaX.elTextoContiene("Gestionar líneas nuevas empresas"),
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent())
        );
        EvidenciaUtils.registrarCaptura(paso1);
        actor.attemptsTo(
                Click.on(BTN_TRES_PUNTOS_MAS),
                ClickTextoQueContengaX.elTextoContiene(ACERCA_DE),
                WaitFor.aTime(1500),
                //ValidarTexto.validarTexto("Gestionar líneas nuevas empresas"),
                ValidarTexto.validarTexto(DECLARACION_SERVICIO),
                ValidarTextoQueContengaX.elTextoContiene(VER));

        EvidenciaUtils.registrarCaptura(paso2);
        WaitFor.aTime(2500);

        actor.attemptsTo(Click.on(BTN_VOLVER),
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent()));

        actor.attemptsTo(

                ValidarTextoQueContengaX.elTextoContiene("Gestionar líneas nuevas"),
                ClickTextoQueContengaX.elTextoContiene("Solicitar líneas nuevas"),
                WaitFor.aTime(1000)
        );
        EvidenciaUtils.registrarCaptura(paso3);
        actor.attemptsTo(ClickTextoQueContengaX.elTextoContiene("Cancelar"));

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Solicitudes finalizadas"),
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent()),
                ValidarTextoQueContengaX.porTiempo("Solicitudes finalizadas",3)
        );
        EvidenciaUtils.registrarCaptura(paso4);
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("27/5/2026"),
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent()),
                ValidarTextoQueContengaX.porTiempo("Estado de activación", 3)
        );
        EvidenciaUtils.registrarCaptura(paso5);
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Ver resumen de la solicitud"),
                WaitFor.aTime(1000),
                ValidarTextoQueContengaX.elTextoContiene("Estado de activación")
        );
        EvidenciaUtils.registrarCaptura(paso6);
        actor.attemptsTo(
                Click.on(BTN_VOLVER),
                ClickTextoQueContengaX.elTextoContiene("27/5/2026"),
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent()),
                ValidarTextoQueContengaX.porTiempo("Estado de activación",3)
        );
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Ver listado de líneas activadas"),
                ValidarTextoQueContengaX.porTiempo("Plan 1",3)
        );
        EvidenciaUtils.registrarCaptura(paso7);
        actor.attemptsTo(
                Click.on(BTN_VOLVER),
                WaitFor.aTime(2000),
                Click.on(BTN_VOLVER),
                WaitFor.aTime(2000),
                Click.on(BTN_VOLVER)
        );
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Solicitudes en curso"),
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent()),
                ValidarTextoQueContengaX.porTiempo("Solicitudes en alistamiento",5)
        );
        EvidenciaUtils.registrarCaptura(paso8);
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("10/9/2026"),
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent()),
                ValidarTextoQueContengaX.porTiempo("Solicitud", 5)
        );
        EvidenciaUtils.registrarCaptura(paso9);
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Ver resumen de la solicitud"),
                ValidarTextoQueContengaX.porTiempo("Resumen de la solicitud", 5)
        );
        EvidenciaUtils.registrarCaptura(paso10);
    }

    public static Performable ingresarGestionarLineasNuevas() {
        return instrumented(IngresarGestionarLineasNuevas.class);
    }
}
