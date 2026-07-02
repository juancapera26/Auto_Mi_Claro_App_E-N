package tasks.EmpresasyNegocios;

import interactions.Click.ClickEnCoordenadas;
import interactions.Click.ClickTextoQueContengaX;
import interactions.Scroll.ScrollHorizontalCoordenadas;
import interactions.validations.ValidarTexto;
import interactions.validations.ValidarTextoQueContengaX;
import interactions.wait.WaitFor;
import interactions.wait.WaitForResponse;
import io.appium.java_client.android.AndroidDriver;
import models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.WebDriver;
import utils.EvidenciaUtils;
import utils.TestDataProvider;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static userinterfaces.EmpresasNegociosPage.VER_PUNTOS_ATENCION;

import static userinterfaces.EntretenimientoPage.BTN_VOLVER;
import static userinterfaces.LoginPage.LOADING_ESPERA_UN_MOMENTO;
import static userinterfaces.LoginPage.LOADING_SPLASH;
import static userinterfaces.PagosYConsultasPage.BTN_TRES_PUNTOS_MAS;
import static utils.Constants.*;
import static utils.Constants.CAMBIO_SIM_CARD;

public class ValidarPortafolioDeSoluciones implements Task {
    private final User user = TestDataProvider.getRealUser();
    private static final String paso1 = "Ingresar a Portafolio de soluciones";
    private static final String paso2 = "validar version de miniprograma";
    private static final String paso3 = "redireccionar a WhatsApp";
    private static final String paso4 = "ingresar a la opcion de clud";
    private static final String paso5 = "ingresar a la opcion de Soluciones moviles";
    private static final String paso6 = "ingresar a la opcion Internet banda ancha";
    private static final String paso7 = "ingresar a la opcion Televición";
    private static final String paso8 = "ingresar a la opcion Internet de las cosas";
    private static final String paso9 = "ingresar a Mi negocio digital";
    private static final String paso10 = "ingresar a Mi Administrador tu negocio";
    private static final String paso11 = "ingresar a conocer mas";



    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(PORTAFOLIO_DE_SOLUCIONES),
                WaitForResponse.withText(PORTAFOLIO_DE_SOLUCIONES));

        EvidenciaUtils.registrarCaptura(paso1);

        actor.attemptsTo(
                WaitFor.aTime(1000),
                Click.on(BTN_TRES_PUNTOS_MAS),
                ClickTextoQueContengaX.elTextoContiene(ACERCA_DE),
                WaitFor.aTime(1000),
                ValidarTexto.validarTexto(PORTAFOLIO_DE_SOLUCIONES),
                ValidarTexto.validarTexto(DECLARACION_SERVICIO),
                ValidarTextoQueContengaX.elTextoContiene(VER)
        );

///

        EvidenciaUtils.registrarCaptura(paso2);

        actor.attemptsTo(Click.on(BTN_VOLVER));

        actor.attemptsTo(
                WaitFor.aTime(2000),
                ClickTextoQueContengaX.elTextoContiene("Adquirir servicio"),
                WaitFor.aTime(3000)

        );
        EvidenciaUtils.registrarCaptura(paso3);
        volverALaApp(actor);

        actor.attemptsTo(
                WaitFor.aTime(2000),
                ClickTextoQueContengaX.elTextoContiene(CLOUD),
                WaitFor.aTime(2000),
                ValidarTextoQueContengaX.elTextoContiene("¿qué es Claro Cloud?")
        );

        EvidenciaUtils.registrarCaptura(paso4);

        actor.attemptsTo(Click.on(BTN_VOLVER));

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(SOLUCIONES_MOVILES),
                WaitFor.aTime(2000),
                ValidarTextoQueContengaX.elTextoContiene("Los mejores planes de voz y datos para tu negocio")
        );

        EvidenciaUtils.registrarCaptura(paso5);

        actor.attemptsTo(Click.on(BTN_VOLVER));

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(INTERNET),
                WaitFor.aTime(2000)

        );

        EvidenciaUtils.registrarCaptura(paso6);

        actor.attemptsTo(Click.on(BTN_VOLVER));

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(TELEVISION),
                WaitFor.aTime(2000)

        );

        EvidenciaUtils.registrarCaptura(paso7);

        actor.attemptsTo(Click.on(BTN_VOLVER));

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(INTERNET_DE_LAS_COSAS),
                WaitFor.aTime(2000)

        );

        EvidenciaUtils.registrarCaptura(paso8);
        
        actor.attemptsTo(Click.on(BTN_VOLVER));

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(MI_NEGOCIO_DIGITAL),
                WaitFor.aTime(2000)

        );

        EvidenciaUtils.registrarCaptura(paso9);

        actor.attemptsTo(Click.on(BTN_VOLVER));

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(ADMINISTRAR_TU_NEGOCIO),
                WaitFor.aTime(2000)
        );


        EvidenciaUtils.registrarCaptura(paso10);
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Conoce más"),
                WaitFor.aTime(2000),
                ClickEnCoordenadas.en(299, 1398),
                WaitFor.aTime(2000)
        );

        EvidenciaUtils.registrarCaptura(paso11);

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

    public static Performable validarPortafolioDeSoluciones() {
        return instrumented(ValidarPortafolioDeSoluciones.class);
    }
}
