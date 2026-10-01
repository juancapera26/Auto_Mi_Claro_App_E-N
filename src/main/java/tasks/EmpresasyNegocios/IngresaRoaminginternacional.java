package tasks.EmpresasyNegocios;

import interactions.Click.ClickElementByText;
import interactions.Click.ClickEnCoordenadas;
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
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.Presence;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import utils.EvidenciaUtils;
import utils.TestDataProvider;
import net.serenitybdd.screenplay.actions.SendKeys;

import static interactions.Click.ClickElementByText.clickElementByText;
import static interactions.wait.WaitElement.isVisible;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static userinterfaces.EmpresasNegociosPage.INFO_ROAMING;
import static userinterfaces.EmpresasNegociosPage.NUMERO_LINEA_MOVIL;
import static userinterfaces.LoginPage.*;
import static userinterfaces.PagosYConsultasPage.BTN_TRES_PUNTOS_MAS;
import static utils.Constants.*;
import org.openqa.selenium.By;

public class IngresaRoaminginternacional implements Task {
    private final User user = TestDataProvider.getRealUser();
    private static final String paso1 = "Ingresar a ingreso Roaming internacional ";
    private static final String paso2 = "ingresar numero al que quieras administrar";
    private static final String paso3 = "validar Informacion de Roaming internacional";
    private static final String paso4 = "validar Informacion Paquete";
    private static final String paso5 = "validar Informacion Paquete2";
    private static final String paso6 = "validar Informacion Paquete3";



    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitFor.aTime(1000)
        );
        EvidenciaUtils.registrarCaptura(paso1);
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Roaming"),
                WaitFor.aTime(3500),
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent()),
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent()),
                WaitForResponse.withText("Soluciones Móviles"),
                ValidarTextoQueContengaX.porTiempo("Número",90)
        );
        actor.attemptsTo(
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent()),
                WaitForResponse.withText("Soluciones Móviles")
        );

        EvidenciaUtils.registrarCaptura(paso2);
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
        EvidenciaUtils.registrarCaptura(paso3);
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(CONTINUAR),
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent()),
                ValidarTextoQueContengaX.porTiempo("Roaming internacional",5),
                ValidarTextoQueContengaX.elTextoContiene("3226918354")

        );
        EvidenciaUtils.registrarCaptura(paso3);
        if (!isVisibleFast(actor, INFO_ROAMING)) {
            actor.attemptsTo(
                    ValidarTextoQueContengaX.elTextoContiene("Pass AmericaEYN"),
                    ClickTextoQueContengaX.elTextoContiene("Detalles del Paquete")
            );
            EvidenciaUtils.registrarCaptura(paso4);

            actor.attemptsTo(
                    ClickTextoQueContengaX.elTextoContiene("Detalles del Paquete"),
                    WaitFor.aTime(2000)

            );
            actor.attemptsTo(
                    ClickEnCoordenadas.en(385, 988),
                    ValidarTextoQueContengaX.elTextoContiene("Pass AmericaEYN"),
                    ClickTextoQueContengaX.elTextoContiene("Detalles del Paquete")

            );

            EvidenciaUtils.registrarCaptura(paso5);

            actor.attemptsTo(
                    ClickTextoQueContengaX.elTextoContiene("Detalles del Paquete"),
                    WaitFor.aTime(2000)

            );
            actor.attemptsTo(
                    ClickEnCoordenadas.en(450, 988),
                    WaitFor.aTime(2000),
                    ClickTextoQueContengaX.elTextoContiene("Detalles del Paquete")

            );
            EvidenciaUtils.registrarCaptura(paso6);



        }



    }
    private <T extends Actor> boolean isVisibleFast(T actor, Target element) {
        try {
            return !Presence.of(element).viewedBy(actor).resolveAll().isEmpty();
        } catch (Exception e) {
            return false;
        }
    }
    public static Performable ingresaRoaminginternacional() {
        return instrumented(IngresaRoaminginternacional.class);
    }

}
