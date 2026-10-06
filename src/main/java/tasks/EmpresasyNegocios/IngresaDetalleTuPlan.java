package tasks.EmpresasyNegocios;
import interactions.Click.ClickTextoQueContengaX;
import interactions.mobile.EscribirConTeclado;
import interactions.validations.ValidarTexto;
import interactions.validations.ValidarTextoQueContengaX;
import interactions.wait.WaitFor;
import interactions.wait.WaitForResponse;
import models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Presence;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import utils.EvidenciaUtils;
import utils.TestDataProvider;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static userinterfaces.EmpresasNegociosPage.NUMERO_LINEA_MOVIL;
import static userinterfaces.EntretenimientoPage.BTN_VOLVER;
import static userinterfaces.LoginPage.LOADING_ESPERA_UN_MOMENTO;
import static userinterfaces.LoginPage.LOADING_SPLASH;
import static userinterfaces.PagosYConsultasPage.BTN_TRES_PUNTOS_MAS;
import static utils.Constants.*;

public class IngresaDetalleTuPlan implements Task {
    private final User user = TestDataProvider.getRealUser();
    private static final String paso1 = "ingresar a detalle de tu plan";
    private static final String paso2 = "ingresar numero al que quieras administrar";
    private static final String paso3 = "validar version miniprogrma";
    private static final String paso4 = "validar Informacion detalle de tu plan";



    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Detalle de"),
                WaitFor.aTime(3000),
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent()),
                WaitForResponse.withText("Soluciones móviles"),
                ValidarTextoQueContengaX.porTiempo("Número",90)
        );

        EvidenciaUtils.registrarCaptura(paso1);
        Target TARGET_NUMERO = Target.the("Número de línea móvil")
                .located(By.xpath("//*[contains(@text, '" + user.getNumeroempresas() + "') or contains(@content-desc, '" + user.getNumeroempresas() + "')]"));

        if (!isVisibleFast(actor, TARGET_NUMERO)) {
            actor.attemptsTo(
                    // 1. Damos clic al campo para garantizar que tenga el foco
                    Click.on(NUMERO_LINEA_MOVIL),

                    // 2. Pequeña espera para que el teclado/campo se habilite
                    WaitFor.aTime(1000),

                    // 3. Limpiamos e ingresamos el valor
                    EscribirConTeclado.nativo(user.getNumeroempresas())
            );
        }


        actor.attemptsTo(
                ValidarTextoQueContengaX.elTextoContiene(user.getNumeroempresas())
        );

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(CONTINUAR),
                WaitFor.aTime(6000)
        );
        EvidenciaUtils.registrarCaptura(paso2);



        actor.attemptsTo(
                WaitFor.aTime(1000),
                Click.on(BTN_TRES_PUNTOS_MAS),
                ClickTextoQueContengaX.elTextoContiene(ACERCA_DE),
                WaitFor.aTime(1000),
                //ValidarTexto.validarTexto("Detalle de tu plan empresas"),
                ValidarTexto.validarTexto(DECLARACION_SERVICIO),
                ValidarTextoQueContengaX.elTextoContiene(VER)
        );
        EvidenciaUtils.registrarCaptura(paso3);

        actor.attemptsTo(Click.on(BTN_VOLVER),
                WaitFor.aTime(1000)
                );
        EvidenciaUtils.registrarCaptura(paso4);

        actor.attemptsTo(
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent()),
                WaitForResponse.withText("Continuar"),
                ClickTextoQueContengaX.elTextoContiene(CONTINUAR),
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent())
        );

        actor.attemptsTo(
                WaitForResponse.withText("Detalle de tu plan"),
                ValidarTextoQueContengaX.porTiempo("Detalle de tu plan", 5),
                ValidarTextoQueContengaX.elTextoContiene("322 691 8354")
             //   ValidarTextoQueContengaX.elTextoContiene("Explora tus servicios")

        );




    }
    private <T extends Actor> boolean isVisibleFast(T actor, Target element) {
        try {
            return !Presence.of(element).viewedBy(actor).resolveAll().isEmpty();
        } catch (Exception e) {
            return false;
        }
    }
    public static Performable ingresaDetalleTuPlan() {
        return instrumented(IngresaDetalleTuPlan.class);
    }

}

