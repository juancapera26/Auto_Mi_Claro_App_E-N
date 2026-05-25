package tasks.PagosYConsultas;

import interactions.Click.ClickTextoQueContengaX;
import interactions.Scroll.Scroll;
import interactions.Scroll.ScrollHastaTexto;
import interactions.validations.ValidarTextoQueContengaX;
import interactions.validations.VerificarVersionModulo;
import interactions.wait.WaitFor;
import interactions.wait.WaitForResponse;

import java.util.List;

import interactions.wait.WaitUntilText;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

import org.openqa.selenium.By;

import utils.EvidenciaUtils;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.PagosYConsultasPage.BTN_TRES_PUNTOS_MAS;
import static userinterfaces.EntretenimientoPage.BTN_VOLVER;
import static utils.Constants.*;
import static utils.ConstantsMiniVersiones.Versiones.MINI_VERSION_ADMINISTRAR_RED_WIFI;

public class ingresarAdministrarTuRedWifi implements Task {

    private static final String TEXTO_SIN_SENAL = "No se encuentra señal";

    private static final Target LBL_NO_SE_ENCUENTRA_SENAL =
            Target.the("Mensaje no se encuentra señal")
                    .located(By.xpath(
                            "//*[contains(@text,'" + TEXTO_SIN_SENAL + "') " +
                                    "or contains(@label,'" + TEXTO_SIN_SENAL + "')]"
                    ));

    private static final String paso1 = "Ingresar a Administrar tu red wifi";
    private static final String paso2 = "Validar version del mini programa";
    private static final String paso3 = "Validar campos de ingreso de datos";
    private static final String paso4 = "Ingresar administrar tu ultra wifi";
    private static final String paso5 = "Validar instrucciones de ultra wifi";
    private static final String paso6 = "Validar instrucciones de ultra wifi manual";

    @Override
    public <T extends Actor> void performAs(T actor) {

        // INGRESAR A ADMINISTRAR TU RED WIFI
        actor.attemptsTo(
                ScrollHastaTexto.conTexto(ADMINISTRA_TU_RED_WIFI)
        );

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(ADMINISTRA_TU_RED_WIFI),
                WaitUntilText.appears(CONFIGURAR_RED),
                WaitFor.aTime(14000)
        );

        // VALIDAR SI APARECE MENSAJE SIN SEÑAL
        if (debeFinalizarPorSinSenal(actor)) {

            EvidenciaUtils.registrarCaptura(TEXTO_SIN_SENAL);

            actor.attemptsTo(
                    ClickTextoQueContengaX.elTextoContiene("Reintentar"),
                    WaitFor.aTime(8000)
            );
        }

        // VALIDAR QUE APAREZCA CONFIGURAR RED
        actor.attemptsTo(
                WaitUntilText.appears(CONFIGURAR_RED),
                ValidarTextoQueContengaX.elTextoContiene(CONFIGURAR_RED)
        );

        EvidenciaUtils.registrarCaptura(paso1);

        // VALIDAR VERSION MINI PROGRAMA
        actor.attemptsTo(
                Click.on(BTN_TRES_PUNTOS_MAS),
                ClickTextoQueContengaX.elTextoContiene(ACERCA_DE),
                WaitForResponse.withText(VER),
                ValidarTextoQueContengaX.elTextoContiene(ADMINISTRA_TU_RED_WIFI),
                VerificarVersionModulo.conLaEsperada(MINI_VERSION_ADMINISTRAR_RED_WIFI),
                ValidarTextoQueContengaX.elTextoContiene(VER),
                WaitFor.aTime(1000)
        );

        EvidenciaUtils.registrarCaptura(paso2);

        actor.attemptsTo(
                Click.on(BTN_VOLVER)
        );

        // VALIDAR CAMPOS
        actor.attemptsTo(
                ValidarTextoQueContengaX.elTextoContiene(NOMBRE_DE_RED),
                ValidarTextoQueContengaX.elTextoContiene(CONTRASENA)
        );

        EvidenciaUtils.registrarCaptura(paso3);

        // INGRESAR ADMINISTRAR TU ULTRA WIFI
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(ADMINISTRAR_TU_ULTRA_WIFI),
                WaitForResponse.withText(ULTRA_WIFI),
                WaitFor.aTime(1000)
        );

        EvidenciaUtils.registrarCaptura(paso4);

        // VALIDAR INSTRUCCIONES
        actor.attemptsTo(
                ValidarTextoQueContengaX.elTextoContiene(INSTRUCCIONES_POR_PRODUCTOS),
                ClickTextoQueContengaX.elTextoContiene(INSTRUCCIONES_POR_PRODUCTOS),
                WaitFor.aTime(2000)
        );

        EvidenciaUtils.registrarCaptura(paso5);

        actor.attemptsTo(
                ValidarTextoQueContengaX.elTextoContiene(COMO_AGREGAR_EQUIPOS_ULTRA_WIFI),
                ClickTextoQueContengaX.elTextoContiene(COMO_AGREGAR_EQUIPOS_ULTRA_WIFI),
                Scroll.scrollUnaVista(),
                WaitFor.aTime(1000)
        );

        EvidenciaUtils.registrarCaptura(paso6);
    }

    private <T extends Actor> boolean debeFinalizarPorSinSenal(T actor) {

        List<WebElementFacade> mensajeSinSenal =
                LBL_NO_SE_ENCUENTRA_SENAL.resolveAllFor(actor);

        return !mensajeSinSenal.isEmpty();
    }

    public static Performable IngresarAdministrarTuRedWifi() {
        return instrumented(ingresarAdministrarTuRedWifi.class);
    }
}