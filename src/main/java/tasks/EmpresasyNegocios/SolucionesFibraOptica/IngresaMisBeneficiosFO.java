package tasks.EmpresasyNegocios.SolucionesFibraOptica;

import interactions.Click.ClickTextoQueContengaX;
import interactions.EmpresasyNegocios.ValidarAcercaDe;
import interactions.Scroll.ScrollHastaTexto;
import interactions.validations.ValidarTexto;
import interactions.validations.ValidarTextoQueContengaX;
import interactions.wait.WaitFor;
import interactions.wait.WaitForResponse;
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
import static userinterfaces.LoginPage.LOADING_ESPERA_UN_MOMENTO;
import static userinterfaces.PagosYConsultasPage.BTN_TRES_PUNTOS_MAS;
import static utils.Constants.*;

public class IngresaMisBeneficiosFO implements Task {
    private final User user = TestDataProvider.getRealUser();
    private static final String paso1 = "Ingresar a mis beneficios HFC ";
    private static final String paso2 = "Validar miniVersion del programa";
    private static final String paso3 = "Validar el ingreso al menu mis beneficios ";
    private static final String paso4 = "Validar miniVersion del programa";
    private static final String paso5 = "Validar el ingreso a llamadas a larga distancia ";
    private static final String paso6 = "Validar el ingreso a Elegidos fijos ";
    private static final String paso7 = "Validar el ingreso a Teléfono virtual ";
    private static final String paso8 = "Validar el ingreso a Página Web ";
    private static final String paso9 = "Validar el ingreso a Dominio ";
    private static final String paso10 = "Validar el ingreso a Cuentas de correo ";


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ValidarTextoQueContengaX.elTextoContiene("Soluciones FO Emp"),
                ClickTextoQueContengaX.elTextoContiene("Mis beneficios FO"),
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent()),
                WaitForResponse.withText("Tus cuentas")
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
                ClickTextoQueContengaX.elTextoContiene("No. 12491848"),
                ValidarTextoQueContengaX.porTiempo("Mis beneficios", 4),
                ValidarTextoQueContengaX.elTextoContiene("Cuenta")
        );
        EvidenciaUtils.registrarCaptura(paso3);
        actor.attemptsTo(
                ValidarAcercaDe.elMenu(),
                WaitFor.aTime(2500)
        );
        EvidenciaUtils.registrarCaptura(paso4);
        WaitFor.aTime(2500);

        actor.attemptsTo(
                Click.on(BTN_VOLVER),
                ValidarTextoQueContengaX.elTextoContiene("Mis beneficios")
        );

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Llamadas a larga distancia"),
                ValidarTextoQueContengaX.porTiempo("Llamadas a larga distancia", 3)
        );
        EvidenciaUtils.registrarCaptura(paso5);

        actor.attemptsTo(
                Click.on(BTN_VOLVER),
                ValidarTextoQueContengaX.elTextoContiene("Mis beneficios")
        );
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Elegidos fijos"),
                ValidarTextoQueContengaX.porTiempo("Elegidos líneas fijas", 3)
        );
        EvidenciaUtils.registrarCaptura(paso6);
        actor.attemptsTo(
                Click.on(BTN_VOLVER),
                ValidarTextoQueContengaX.elTextoContiene("Mis beneficios")
        );
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Teléfono virtual"),
                ValidarTextoQueContengaX.porTiempo("Teléfono virtual", 3)
        );
        EvidenciaUtils.registrarCaptura(paso7);
        actor.attemptsTo(
                Click.on(BTN_VOLVER),
                ValidarTextoQueContengaX.elTextoContiene("Mis beneficios")
        );
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Página Web"),
                WaitFor.aTime(2500),
                ValidarTextoQueContengaX.elTextoContiene("Página Web")
        );
        EvidenciaUtils.registrarCaptura(paso8);
        actor.attemptsTo(
                Click.on(BTN_VOLVER),
                ValidarTextoQueContengaX.elTextoContiene("Mis beneficios")
        );
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Dominio"),
                WaitFor.aTime(2500),
                ValidarTextoQueContengaX.elTextoContiene("Dominio")
        );
        EvidenciaUtils.registrarCaptura(paso9);
        actor.attemptsTo(
                Click.on(BTN_VOLVER),
                ValidarTextoQueContengaX.elTextoContiene("Mis beneficios")
        );
        actor.attemptsTo(
                Click.on(BTN_CUENTAS_CORREO),
                WaitFor.aTime(2500),
                ValidarTextoQueContengaX.elTextoContiene("Cuentas de correo")
        );
        EvidenciaUtils.registrarCaptura(paso10);
    }

    public static Performable ingresaMisBeneficiosFO() {
        return instrumented(IngresaMisBeneficiosFO.class);
    }
}
