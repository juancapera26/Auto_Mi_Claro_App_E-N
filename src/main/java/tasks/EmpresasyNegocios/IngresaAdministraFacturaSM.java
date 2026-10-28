package tasks.EmpresasyNegocios;

import interactions.Click.ClickElementByText;
import interactions.Click.ClickTextoQueContengaX;
import interactions.mobile.EscribirConTeclado;
import interactions.validations.ExisteTexto;
import interactions.validations.ValidarTexto;
import interactions.validations.ValidarTextoQueContengaX;
import interactions.wait.WaitFor;
import interactions.wait.WaitForResponse;
import models.User;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Presence;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import utils.EvidenciaUtils;
import utils.TestDataProvider;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static userinterfaces.EmpresasNegociosPage.ADMINISTRA_TU_FACTURA;
import static userinterfaces.EmpresasNegociosPage.NUMERO_LINEA_MOVIL;
import static userinterfaces.EntretenimientoPage.BTN_VOLVER;
import static userinterfaces.LoginPage.LOADING_ESPERA_UN_MOMENTO;
import static userinterfaces.LoginPage.LOADING_SPLASH;
import static userinterfaces.PagosYConsultasPage.BTN_HOME;
import static userinterfaces.PagosYConsultasPage.BTN_TRES_PUNTOS_MAS;
import static utils.Constants.*;
import static utils.Constants.PAGAR;

public class IngresaAdministraFacturaSM implements Task {
    private final User user = TestDataProvider.getRealUser();
    private static final String paso1 = "ingresar a Administra tu factura";
    private static final String paso2 = "validar version miniprogrma";
    private static final String paso3 = "validar Informacion Administra tu factura ";
    private static final String paso4 = "Redireccion a portal de pagos";
    private static final String paso5 = "validar Historial de pagos";
    private static final String paso6 = "validar descaga tu facuta";



    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Administra tu factura"),
                WaitFor.aTime(5000),
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent()),
                WaitForResponse.withText("Soluciones móviles")
        );

        EvidenciaUtils.registrarCaptura(paso1);



        actor.attemptsTo(
                WaitFor.aTime(3000),
                Click.on(BTN_TRES_PUNTOS_MAS),
                ClickTextoQueContengaX.elTextoContiene(ACERCA_DE),
                WaitFor.aTime(1000),
                ValidarTexto.validarTexto(DECLARACION_SERVICIO),
                ValidarTextoQueContengaX.elTextoContiene(VER)

        );
        EvidenciaUtils.registrarCaptura(paso2);

        actor.attemptsTo(Click.on(BTN_VOLVER),
                WaitFor.aTime(7000)
        );
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
                ValidarTextoQueContengaX.elTextoContiene(user.getNumeroempresas()),
                ClickElementByText.clickElementByText(CONTINUAR),
                WaitFor.aTime(5000),
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent()),
                WaitForResponse.withText("Administra tu factura")
        );

        actor.attemptsTo(
                ValidarTextoQueContengaX.elTextoContiene("Administra tu factura"),
                ValidarTextoQueContengaX.elTextoContiene("6224489807"),
                ValidarTextoQueContengaX.elTextoContiene("Cuenta Maestra"),
                ValidarTextoQueContengaX.elTextoContiene("Fecha de pago oportuno"),
                ValidarTextoQueContengaX.elTextoContiene("Total a pagar")

        );
        EvidenciaUtils.registrarCaptura(paso3);

        if (actor.asksFor(ExisteTexto.con(PAGAR))) {

            actor.attemptsTo(
                    WaitFor.aTime(1000),
                    ClickElementByText.clickElementByText(PAGAR),
                    WaitFor.aTime(5000),
                    ValidarTextoQueContengaX.elTextoContiene("Selecciona el medio de pago"),
                    ValidarTextoQueContengaX.elTextoContiene("Consulta"),
                    Click.on(BTN_HOME),
                    WaitUntil.the(LOADING_SPLASH, isNotPresent())
            );

            EvidenciaUtils.registrarCaptura(paso4);

           /* actor.attemptsTo(
                    ClickEnCoordenadas.en(46, 126)
            );*/
        }

        actor.attemptsTo(
                WaitFor.aTime(5000),
                ClickElementByText.clickElementByText("Historial de pagos"),
                WaitUntil.the(LOADING_SPLASH, isNotPresent()),
                ValidarTextoQueContengaX.elTextoContiene("Histórico de pagos en Línea"),
                ValidarTextoQueContengaX.elTextoContiene("Valor"),
                ValidarTextoQueContengaX.elTextoContiene("Fecha de pago")
        );
        EvidenciaUtils.registrarCaptura(paso5);

        actor.attemptsTo(Click.on(BTN_VOLVER),
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent())
        );

        actor.attemptsTo(
                ClickElementByText.clickElementByText("Descarga tu factura"),
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent()),
                ValidarTextoQueContengaX.porTiempo("Abrir documento",60)
        );
        EvidenciaUtils.registrarCaptura(paso6);
    }
    private <T extends Actor> boolean isVisibleFast(T actor, Target element) {
        try {
            return !Presence.of(element).viewedBy(actor).resolveAll().isEmpty();
        } catch (Exception e) {
            return false;
        }
    }
    public static Performable ingresaAdministraFacturaSM() {
        return instrumented(IngresaAdministraFacturaSM.class);
    }

}
