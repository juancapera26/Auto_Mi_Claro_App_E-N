package tasks.EmpresasyNegocios;

import interactions.Click.ClickElementByText;
import interactions.Click.ClickEnCoordenadas;
import interactions.Click.ClickTextoQueContengaX;
import interactions.Scroll.Scroll;
import interactions.mobile.ClickIfPresent;
import interactions.validations.ValidarTexto;
import interactions.validations.ValidarTextoQueContengaX;
import interactions.wait.WaitFor;
import models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Presence;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import utils.EvidenciaUtils;
import utils.TestDataProvider;

import static interactions.wait.WaitElement.isVisible;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static userinterfaces.EmpresasNegociosPage.*;
import static userinterfaces.EntretenimientoPage.BTN_CONTINUAR;
import static userinterfaces.EntretenimientoPage.BTN_VOLVER;
import static userinterfaces.LoginPage.ACTIVAR_ESIM;
import static userinterfaces.LoginPage.LOADING_SPLASH;
import static userinterfaces.PagosYConsultasPage.BTN_TRES_PUNTOS_MAS;
import static utils.Constants.*;

public class IngresaActivareSIMempresas implements Task {
    private final User user = TestDataProvider.getRealUser();
    private static final String paso1 = "ingresar a Activa eSIM Empresas";
    private static final String paso2 = "ingresar numero al que quieras administrar";
    private static final String paso3 = "validar mensaje empresas";
    private static final String paso4 = "validar version de miniprograma";
    private static final String paso5 = "validar informacion Cámbiate a eSIM y disfruta de más tecnología!";
    private static final String paso6 = "validar recomendaciones";
    private static final String paso7 = "validar ingreso de los dispositivos";




    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Activa"),
                WaitFor.aTime(1000),
                WaitUntil.the(LOADING_SPLASH,  isNotPresent())

        );

        EvidenciaUtils.registrarCaptura(paso1);

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(CONTINUAR),
                WaitFor.aTime(6000)
        );
        EvidenciaUtils.registrarCaptura(paso2);
        actor.attemptsTo(
                WaitFor.aTime(6000)
        );
        EvidenciaUtils.registrarCaptura(paso3);
        actor.attemptsTo(
                ClickEnCoordenadas.en(366, 1407),
                WaitFor.aTime(3000)
        );

        actor.attemptsTo(
                WaitFor.aTime(1000),
                Click.on(BTN_TRES_PUNTOS_MAS),
                ClickTextoQueContengaX.elTextoContiene(ACERCA_DE),
                WaitFor.aTime(2500),
                ValidarTexto.validarTexto("Espera un momento"),
                ValidarTexto.validarTexto(DECLARACION_SERVICIO),
                ValidarTextoQueContengaX.elTextoContiene(VER),
                WaitFor.aTime(1000)
        );
        EvidenciaUtils.registrarCaptura(paso4);

        actor.attemptsTo(Click.on(BTN_VOLVER),
                WaitFor.aTime(1000)
        );

        actor.attemptsTo(Click.on(BTN_CONTINUAR),
                WaitFor.aTime(1000)
        );
        EvidenciaUtils.registrarCaptura(paso5);

        actor.attemptsTo(
                WaitUntil.the(ACTIVAR_ESIM,  isPresent()),
                WaitFor.aTime(10000),
                Click.on(BOTON_SIGUIENTE_ESIM),
                //WaitFor.aTime(2000),
                //WaitUntil.the(BOTON_CONTINUAR_ESIM, WebElementStateMatchers.isEnabled()).forNoMoreThan(10).seconds(),
                //Click.on(BOTON_CONTINUAR_ESIM),
                ClickElementByText.clickElementByText("Continuar"),
                WaitUntil.the(LOADING_SPLASH, isNotPresent())
                );

        EvidenciaUtils.registrarCaptura(paso6);

        actor.attemptsTo(
                WaitUntil.the(LOADING_SPLASH,  isNotPresent()),
                ClickTextoQueContengaX.elTextoContiene("Elige la marca de tu celular"),
                ClickTextoQueContengaX.elTextoContiene("Honor"),
                WaitFor.aTime(1000),
                ClickTextoQueContengaX.elTextoContiene("Elige el modelo de tu celular"),
                ClickTextoQueContengaX.elTextoContiene("Honor 200")
        );
        EvidenciaUtils.registrarCaptura(paso7);



    }
    private <T extends Actor> boolean visible(T actor, Target t) {
        try {
            return !Presence.of(t).viewedBy(actor).resolveAll().isEmpty();
        } catch (Exception e) {
            return false;
        }
    }
    private <T extends Actor> boolean isVisible(T actor, Target element) {
        try {
            return !Presence.of(element).viewedBy(actor).resolveAll().isEmpty();
        } catch (Exception e) {
            return false;
        }
    }
    public static Performable ingresaActivareSIMempresas() {
        return instrumented(IngresaActivareSIMempresas.class);
    }


}

