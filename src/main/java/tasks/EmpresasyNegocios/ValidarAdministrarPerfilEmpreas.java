package tasks.EmpresasyNegocios;

import com.ibm.icu.impl.Assert;
import interactions.Click.ClickEnCoordenadas;
import interactions.Click.ClickTextoQueContengaX;
import interactions.Scroll.Scroll;
import interactions.Scroll.ScrollHastaTexto;
import interactions.Scroll.ScrollHorizontalText;
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
import static userinterfaces.EmpresasNegociosPage.*;
import static userinterfaces.EntretenimientoPage.BTN_VOLVER;
import static userinterfaces.LoginPage.*;
import static userinterfaces.PagosYConsultasPage.BTN_TRES_PUNTOS_MAS;
import static utils.Constants.*;

public class ValidarAdministrarPerfilEmpreas implements Task {
    private final User user = TestDataProvider.getRealUser();
    private static final String paso1 = "validar ingreso Administrar perfil";
    private static final String paso2 = "validar informacion Administrar perfil";
    private static final String paso3 = "validar version del mini programa";
    private static final String paso4 = "agregar nuevo usuario";
    private static final String paso5 = "ingresar correo del nuevo ususario";
    private static final String paso6 = "Crear usuario";
    private static final String paso7 = "Mesaje Eliminar usuario";
    private static final String paso8 = "usuario eliminado";


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(ADMINISTRAR_PERFILES),
                WaitFor.aTime(3000)
        );
        EvidenciaUtils.registrarCaptura(paso1);
        actor.attemptsTo(
                ValidarTextoQueContengaX.elTextoContiene("Administrar perfiles"),
                WaitFor.aTime(3000)
        );

        EvidenciaUtils.registrarCaptura(paso2);

        actor.attemptsTo(
                WaitFor.aTime(1000),
                Click.on(BTN_TRES_PUNTOS_MAS),
                ClickTextoQueContengaX.elTextoContiene(ACERCA_DE),
                WaitFor.aTime(1000),
                ValidarTexto.validarTexto(ADMINISTRAR_PERFILES),
                ValidarTexto.validarTexto(DECLARACION_SERVICIO),
                ValidarTextoQueContengaX.elTextoContiene(VER)
        );

        EvidenciaUtils.registrarCaptura(paso3);

        actor.attemptsTo(Click.on(BTN_VOLVER));

        actor.attemptsTo(
                Scroll.scrollUnaVista(),
                Scroll.scrollUnaVista(),
                Scroll.scrollUnaVista(),
                Scroll.scrollUnaVista(),
                Scroll.scrollUnaVista(),
                Scroll.scrollUnaVista(),
                Scroll.scrollUnaVista(),
                Scroll.scrollUnaVista(),
                Scroll.scrollUnaVista(),
                ValidarTextoQueContengaX.elTextoContiene("Agregar nuevo perfil"),
                ClickTextoQueContengaX.elTextoContiene("Agregar nuevo perfil"),
                WaitFor.aTime(1000)

        );
        EvidenciaUtils.registrarCaptura(paso4);
        actor.attemptsTo(
                Enter.theValue(user.getemailSecundario()).into(SELECIONAR_CAMPO_DE_TEXTO),
                Click.on(PERFIL_DE_CONSULTA),
                WaitFor.aTime(1000)
        );
        EvidenciaUtils.registrarCaptura(paso5);
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Crear"),
                WaitFor.aTime(6000)
        );
        EvidenciaUtils.registrarCaptura(paso6);
        actor.attemptsTo(
                ScrollHorizontalText.izquierda(user.getemailSecundario()),
                WaitFor.aTime(3000),
                Click.on(BOTON_ELIMINAR),
                WaitFor.aTime(1000)



        );
        EvidenciaUtils.registrarCaptura(paso7);
        actor.attemptsTo(
                ValidarTextoQueContengaX.elTextoContiene("¿Deseas eliminar el perfil asociado"),
                ClickTextoQueContengaX.elTextoContiene(ACEPTAR_2),
                WaitFor.aTime(4000)
        );
        // Verificar que el usuario ya no exista
        if (EMAIL.of(user.getemailSecundario()).resolveFor(actor).isPresent()) {
            Assert.fail("El usuario no fue eliminado");
        }
        EvidenciaUtils.registrarCaptura(paso8);

    }
    public static Performable validarAdministrarPerfilEmpreas() {
        return instrumented(ValidarAdministrarPerfilEmpreas.class);
    }
}
