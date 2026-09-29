package tasks.EmpresasyNegocios.SolucionesFibraOptica;

import interactions.Click.ClickElementByText;
import interactions.Click.ClickTextoQueContengaX;
import interactions.EmpresasyNegocios.NavegarAtras;
import interactions.EmpresasyNegocios.ValidarAcercaDe;
import interactions.validations.ExisteTexto;
import interactions.validations.ValidarTextoQueContengaX;
import interactions.wait.WaitFor;
import interactions.wait.WaitForResponse;
import models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import tasks.EmpresasyNegocios.AcederIformacionTramites;
import utils.EvidenciaUtils;
import utils.TestDataProvider;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static userinterfaces.EntretenimientoPage.BTN_VOLVER;
import static userinterfaces.LoginPage.LOADING_ESPERA_UN_MOMENTO;
import static userinterfaces.LoginPage.LOADING_SPLASH;
import static userinterfaces.PagosYConsultasPage.BTN_HOME;
import static utils.Constants.*;

public class IngresaMisProductosFO implements Task {
    private static final String paso1 = "Ingresar a tus cuentas";
    private static final String paso2 = "Validar version de miniprograma: espera un momento";
    private static final String paso3 = "Menu mis productos";
    private static final String paso4 = "Validar version de miniprograma: Mis productos FO";
    private static final String paso5 = "Menu internet";
    private static final String paso6 = "Mejora tu plan de internet";
    private static final String paso7 = "Portal Contrata Servicios Claro Negocios";
    private static final String paso8 = "Ingreso a Voz";
    private static final String paso9 = "Ingreso a Cloud";
    private static final String paso10 = "Ingreso a Data Center";
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Mis productos FO"),
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
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent()),
               // ValidarTextoQueContengaX.porTiempo("Mis productos", 3),
                WaitForResponse.withText("Mis Productos"),
                ValidarTextoQueContengaX.elTextoContiene("Internet"),
                ValidarTextoQueContengaX.elTextoContiene("Voz"),
                ValidarTextoQueContengaX.elTextoContiene("Cloud"),
                ValidarTextoQueContengaX.elTextoContiene("Data Center")

        );
        EvidenciaUtils.registrarCaptura(paso3);
        actor.attemptsTo(
                ValidarAcercaDe.elMenu(),
                WaitFor.aTime(2500)
        );
        EvidenciaUtils.registrarCaptura(paso4);
        WaitFor.aTime(2500);
        actor.attemptsTo(Click.on(BTN_VOLVER));
        //Ingresar a Internet
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Internet"),
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent()),
                WaitForResponse.withText("Tus enlaces"),
                ValidarTextoQueContengaX.porTiempo("Total enlaces", 3)
        );
        EvidenciaUtils.registrarCaptura(paso5);
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("TPT0000295 - Bogotá"),
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent()),
                WaitForResponse.withText("Mis Productos"),
                ValidarTextoQueContengaX.porTiempo("Internet", 3)
        );
        EvidenciaUtils.registrarCaptura(paso6);
        /*
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Mejora tu plan"),
                WaitForResponse.withText("Contrata Servicios Claro Negocios"),
                ValidarTextoQueContengaX.porTiempo("Nombre", 3)
        );
        EvidenciaUtils.registrarCaptura(paso7);
         */
        //Volver al menu principal
        actor.attemptsTo(
                NavegarAtras.enElDispositivo(),
                WaitFor.aTime(1500)
        );
        //Ingresar a Menu Voz
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(VOZ),
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent()),
                WaitForResponse.withText(ACEPTAR_2)
        );
        EvidenciaUtils.registrarCaptura(paso8);
        actor.attemptsTo(
                ClickElementByText.clickElementByText(ACEPTAR_2),
                NavegarAtras.enElDispositivo()
        );
        //Ingreso Cloud
        actor.attemptsTo(
                ClickElementByText.clickElementByText(CLOUD),
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent()),
                WaitForResponse.withText(ACEPTAR_2)
        );
        EvidenciaUtils.registrarCaptura(paso9);
        actor.attemptsTo(
                ClickElementByText.clickElementByText(ACEPTAR_2),
                NavegarAtras.enElDispositivo()
        );
        ///Ingreso Data Center
        actor.attemptsTo(
                ClickElementByText.clickElementByText("Data Center"),
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent()),
                WaitForResponse.withText(ACEPTAR_2)
        );
        EvidenciaUtils.registrarCaptura(paso10);
        actor.attemptsTo(
                ClickElementByText.clickElementByText(ACEPTAR_2),
                NavegarAtras.enElDispositivo()
        );

    }

    public static Performable ingresaMisProductosFO() {
        return instrumented(IngresaMisProductosFO.class);
    }
}
