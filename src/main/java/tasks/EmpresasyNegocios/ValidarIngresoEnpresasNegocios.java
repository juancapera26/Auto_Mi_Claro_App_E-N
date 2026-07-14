package tasks.EmpresasyNegocios;
import interactions.Click.ClickEnCoordenadas;
import interactions.Click.ClickTextoQueContengaX;
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
import tasks.EmpresasyNegocios.ValidarPortafolioDeSoluciones;
import utils.EvidenciaUtils;
import utils.TestDataProvider;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static userinterfaces.EmpresasNegociosPage.MENU_BURGES_EMPRESA;
import static userinterfaces.EntretenimientoPage.BTN_VOLVER;
import static userinterfaces.LoginPage.LOADING_ESPERA_UN_MOMENTO;
import static userinterfaces.LoginPage.LOADING_SPLASH;
import static userinterfaces.PagosYConsultasPage.BTN_TRES_PUNTOS_MAS;
import static utils.Constants.*;

public class ValidarIngresoEnpresasNegocios implements Task {
    private final User user = TestDataProvider.getRealUser();
    private static final String paso1 = "Ingresar a la cuenta de empresas";
    private static final String paso2 = "validar version de miniprograma";
    private static final String paso3 = "validar anuncios";
    private static final String paso4 = "validar ingresar a la cuenta de empresas";
    private static final String paso5 = "validar menu";
    private static final String paso6 = "validar informacion administrar perfil";
    private static final String paso7 = "validar informacion gestionar la cuenta";
    private static final String paso8 = "validar redireccion adquirir producto";
    private static final String paso9 = "validar terminos y condiciones";
    private static final String paso10 = "ingresar a Mi Administrador tu negocio";
    private static final String paso11 = "ingresar a conocer mas";

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(INGRESA_A_TU_CUENTA),
                WaitFor.aTime(3000)
                );

        EvidenciaUtils.registrarCaptura(paso1);

        actor.attemptsTo(
                WaitFor.aTime(1000),
                Click.on(BTN_TRES_PUNTOS_MAS),
                ClickTextoQueContengaX.elTextoContiene(ACERCA_DE),
                WaitFor.aTime(1000),
                ValidarTexto.validarTexto(INGRESA_A_TU_CUENTA),
                ValidarTexto.validarTexto(DECLARACION_SERVICIO),
                ValidarTextoQueContengaX.elTextoContiene(VER)
        );

///

        EvidenciaUtils.registrarCaptura(paso2);

        actor.attemptsTo(Click.on(BTN_VOLVER));

        EvidenciaUtils.registrarCaptura(paso3);


        actor.attemptsTo(
                WaitFor.aTime(2000),
                ClickTextoQueContengaX.elTextoContiene("Continuar"),
                WaitFor.aTime(1000),
                ClickTextoQueContengaX.elTextoContiene("Continuar"),
                WaitFor.aTime(1000),
                ClickTextoQueContengaX.elTextoContiene("Continuar"),
                WaitFor.aTime(6000)
        );

        EvidenciaUtils.registrarCaptura(paso4);

        actor.attemptsTo(
                Click.on(MENU_BURGES_EMPRESA)
        );
        EvidenciaUtils.registrarCaptura(paso5);
        actor.attemptsTo(
                ClickEnCoordenadas.en(361, 460)
        );
        EvidenciaUtils.registrarCaptura(paso6);

        actor.attemptsTo(ClickEnCoordenadas.en(44, 129));
        actor.attemptsTo(
                ClickEnCoordenadas.en(361, 642)
        );
        EvidenciaUtils.registrarCaptura(paso7);
        actor.attemptsTo(ClickEnCoordenadas.en(44, 129));

        actor.attemptsTo(
                ClickEnCoordenadas.en(361, 815)
        );
        EvidenciaUtils.registrarCaptura(paso8);
        volverALaApp(actor);
        actor.attemptsTo(
                ClickEnCoordenadas.en(361, 1132)
        );
        EvidenciaUtils.registrarCaptura(paso9);


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
    public static Performable validarIngresoEnpresasNegocios() {
        return instrumented(ValidarIngresoEnpresasNegocios.class);
    }
}