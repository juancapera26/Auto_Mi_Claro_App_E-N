package tasks.EmpresasyNegocios;

import interactions.Click.ClickEnCoordenadas;
import interactions.Click.ClickTextoQueContengaX;
import interactions.validations.ValidarTexto;
import interactions.validations.ValidarTextoQueContengaX;
import interactions.wait.WaitFor;
import io.appium.java_client.android.AndroidDriver;
import models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.WebDriver;
import utils.EvidenciaUtils;
import utils.TestDataProvider;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static userinterfaces.EmpresasNegociosPage.MENU_BURGES_EMPRESA;
import static userinterfaces.EntretenimientoPage.BTN_VOLVER;
import static userinterfaces.LoginPage.*;
import static userinterfaces.PagosYConsultasPage.BTN_TRES_PUNTOS_MAS;
import static utils.Constants.*;
import static utils.Constants.VER;

public class IngresaSolucionesmoviles implements Task {
    private final User user = TestDataProvider.getRealUser();
    private static final String paso1 = "Ingresar a Soluciones";
    private static final String paso2 = "Ingresar al modulo soluciones moviles";
    private static final String paso3 = "validar version miniprogrma";
    private static final String paso4 = "Validar Ingresar a Soluciones";


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(SOLUCIONES_MOVILES),
                WaitFor.aTime(4000)
        );

        EvidenciaUtils.registrarCaptura(paso1);

        EvidenciaUtils.registrarCaptura(paso2);


        actor.attemptsTo(
                WaitFor.aTime(1000),
                Click.on(BTN_TRES_PUNTOS_MAS),
                ClickTextoQueContengaX.elTextoContiene(ACERCA_DE),
                WaitFor.aTime(1000),
                ValidarTexto.validarTexto("Soluciones Moviles"),
                ValidarTextoQueContengaX.elTextoContiene(VER)
        );
        EvidenciaUtils.registrarCaptura(paso3);
        actor.attemptsTo(
                Click.on(BTN_VOLVER),
                WaitFor.aTime(1000)
                );

        actor.attemptsTo(
                ClickEnCoordenadas.en(373, 1373),
                WaitFor.aTime(3000)
        );
        EvidenciaUtils.registrarCaptura(paso4);

        actor.attemptsTo(

        );

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
    public static Performable ingresaSolucionesmoviles() {
        return instrumented(IngresaSolucionesmoviles.class);
    }

}
