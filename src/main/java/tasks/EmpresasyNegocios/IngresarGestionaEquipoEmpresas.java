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


public class IngresarGestionaEquipoEmpresas implements Task {
    private static final User user = TestDataProvider.getRealUser();
    private static final String paso1 = "Ingreso a gestionar lineas nuevas empresas";
    private static final String paso2 = "Validar Mini Versión";
    private static final String paso3 = "Validar solicitar lineas nuevas";
    private static final String paso4 = "Validar solicitudes finalizadas";
    private static final String paso5 = "Validar estado de solicitudes finalizadas";
    private static final String paso6 = "Validar resumen de la solicitud";
    private static final String paso7 = "Validar listado de lineas activas";
    private static final String paso8 = "Validar Solicitudes en curso";
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Gestiona tu equipo - empresas"),
                WaitUntil.the(LOADING_GestionaTuEquipo, isNotPresent())
        );
    }

    public static Performable ingresarGestionaEquipoEmpresas() {
        return instrumented(IngresarGestionaEquipoEmpresas.class);
    }
}
