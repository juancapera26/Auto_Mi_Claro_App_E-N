package tasks.AtencionClienteSoporte;

import interactions.Click.ClickEnCoordenadas;
import interactions.Click.ClickTextoQueContengaX;
import interactions.Scroll.ScrollHastaTexto;
import interactions.Scroll.ScrollHorizontal;
import interactions.Scroll.ScrollHorizontalCoordenadas;
import interactions.validations.ValidarTextoQueContengaX;
import interactions.validations.VerificarVersionModulo;
import interactions.wait.WaitForResponse;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebDriver;

import utils.EvidenciaUtils;
import utils.TestDataProvider;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static userinterfaces.ConsultarConsumosPage.BTN_WHATSAPP;
import static userinterfaces.EntretenimientoPage.BTN_VOLVER;
import static userinterfaces.LoginPage.LOADING_ESPERA_UN_MOMENTO;
import static userinterfaces.LoginPage.LOADING_SPLASH;
import static userinterfaces.PagosYConsultasPage.BTN_TRES_PUNTOS_MAS;
import static utils.Constants.*;
import static utils.ConstantsMiniVersiones.Versiones.MINI_VERSION_VISITAS_TECNICAS_CONSTANT;
import net.thucydides.core.webdriver.WebDriverFacade;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class VisitasTecnicas implements Task {

    private static final User user = TestDataProvider.getRealUser();

    private static final String paso = "Ingresar a visitas Técnicos en atención al cliente";
    private static final String paso1 = "Ingresar a visitas Técnicos";
    private static final String paso2 = "Ingreso a Acerca de";
    private static final String paso3 = "Validación Necesitas ayuda";
    private static final String paso4 = "Validación de cuenta y continuar";

    private static final String paso5 = "Validación WhatsApp - Visita técnica";
    private static final String paso6 = "Validación WhatsApp - Traslado";

    private static final String paso7 = "Ingreso a historial";
    private static final String paso8 = "Historial - Todas";
    private static final String paso9 = "Historial - Completadas";
    private static final String paso10 = "Historial - No realizadas";
    private static final String paso11 = "Historial - Canceladas";
    private static final String paso12 = "Historial - Suspendidas";

    @Override
    public <T extends Actor> void performAs(T actor) {

        // 🔽 Ver más
        actor.attemptsTo(
                ScrollHastaTexto.conTexto(VER_MAS),
                ClickTextoQueContengaX.elTextoContiene(VER_MAS),
                ValidarTextoQueContengaX.elTextoContiene(VISITAS_TECNICOS)
        );
        EvidenciaUtils.registrarCaptura(paso);

        // 🔽 Ingreso módulo
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(VISITAS_TECNICOS)
        );
        EvidenciaUtils.registrarCaptura(paso1);

        // 🔽 Acerca de
        actor.attemptsTo(
                Click.on(BTN_TRES_PUNTOS_MAS),
                ValidarTextoQueContengaX.elTextoContiene("Acerca de")
        );
        EvidenciaUtils.registrarCaptura(paso2);

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Acerca de"),
                WaitForResponse.withText("Ver"),
                ValidarTextoQueContengaX.elTextoContiene(VISITAS_TECNICOS),
                VerificarVersionModulo.conLaEsperada(MINI_VERSION_VISITAS_TECNICAS_CONSTANT)
        );
        EvidenciaUtils.registrarCaptura(paso3);

        // 🔙 Volver
        actor.attemptsTo(
                Click.on(BTN_VOLVER)
        );

        // 🔽 Selección cuenta
        actor.attemptsTo(
                ValidarTextoQueContengaX.elTextoContiene(
                        CUENTA + " " + user.getCuentaHogar() + " " + VER_DETALLE
                ),
                ClickTextoQueContengaX.elTextoContiene(user.getCuentaHogar())

        );
        try {
            Thread.sleep(35000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        EvidenciaUtils.registrarCaptura(paso4);



        // =========================
        // 🔹 WHATSAPP - VISITA TÉCNICA
        // =========================
        actor.attemptsTo(
                ValidarTextoQueContengaX.elTextoContiene(GESTION_VISITAS_TECNICAS),
                ValidarTextoQueContengaX.elTextoContiene(VISITAS_TECNICOS_WHATSAPP)
        );

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(VISITAS_TECNICOS_WHATSAPP),
                WaitForResponse.withText("Claro Colombia"),
                ValidarTextoQueContengaX.elTextoContiene(VISITAS_TECNICOS_WHATSAPP_MENSAJE)
        );
        EvidenciaUtils.registrarCaptura(paso5);

        volverALaApp(actor);

        // =========================
        // 🔹 WHATSAPP - TRASLADO
        // =========================
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(SOLICITUD_TRASLADO),
                WaitForResponse.withText("Claro Colombia"),
                ValidarTextoQueContengaX.elTextoContiene(SOLICITUD_TRASLADO_WHATSAPP_MENSAJE)
        );
        EvidenciaUtils.registrarCaptura(paso6);

        volverALaApp(actor);

        // =========================
        // 🔹 HISTORIAL
        // =========================
        actor.attemptsTo(
                ScrollHastaTexto.conTexto("Historial"),
                ClickTextoQueContengaX.elTextoContiene("Historial"),
                WaitForResponse.withText("Todas")
        );
        EvidenciaUtils.registrarCaptura(paso7);

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Todas"),
                ValidarTextoQueContengaX.elTextoContiene("Todas")
        );
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        EvidenciaUtils.registrarCaptura(paso8);

        actor.attemptsTo(

                ClickTextoQueContengaX.elTextoContiene("Completadas"),
                ValidarTextoQueContengaX.elTextoContiene("Completadas")
        );
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        EvidenciaUtils.registrarCaptura(paso9);

        actor.attemptsTo(

                ClickTextoQueContengaX.elTextoContiene("No realizadas"),
                ValidarTextoQueContengaX.elTextoContiene("No realizadas")
        );
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        EvidenciaUtils.registrarCaptura(paso10);

        actor.attemptsTo(
                ScrollHorizontalCoordenadas.desde(
                        610, 695,   // inicio
                        200, 1200    // final (hacia la izquierda visual = scroll derecha)
                )
        );
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Canceladas"),
                ValidarTextoQueContengaX.elTextoContiene("Cancelada")
        );
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        EvidenciaUtils.registrarCaptura(paso11);

        actor.attemptsTo(

                ClickTextoQueContengaX.elTextoContiene("Suspendidas"),
                ValidarTextoQueContengaX.elTextoContiene("Suspendidas")
        );
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        EvidenciaUtils.registrarCaptura(paso12);
    }

    private void volverALaApp(Actor actor) {

        WebDriver webDriver = BrowseTheWeb.as(actor).getDriver();

        // 🔥 Obtener el driver real (el de Appium)
        if (webDriver instanceof WebDriverFacade) {
            webDriver = ((WebDriverFacade) webDriver).getProxiedDriver();
        }

        if (webDriver instanceof AndroidDriver) {

            AndroidDriver<?> driver = (AndroidDriver<?>) webDriver;

            driver.activateApp("com.clarocolombia.miclaro");

        } else {
            throw new IllegalStateException("El driver no es AndroidDriver");
        }

        actor.attemptsTo(
                WaitUntil.the(LOADING_SPLASH, isNotPresent()),
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent())
                        .forNoMoreThan(40).seconds()
        );
    }

    public static Performable ingresar() {
        return instrumented(VisitasTecnicas.class);
    }
}