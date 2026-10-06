package tasks.EmpresasyNegocios;

import interactions.Click.ClickEnCoordenadas;
import interactions.Click.ClickTextoQueContengaX;
import interactions.Scroll.Scroll;
import interactions.Scroll.ScrollHorizontalCoordenadas;
import interactions.mobile.EscribirConTeclado;
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
import static userinterfaces.EmpresasNegociosPage.NUMERO_LINEA_MOVIL;
import static userinterfaces.EntretenimientoPage.BTN_VOLVER;
import static userinterfaces.LoginPage.LOADING_ESPERA_UN_MOMENTO;
import static userinterfaces.LoginPage.LOADING_SPLASH;
import static userinterfaces.PagosYConsultasPage.BTN_TRES_PUNTOS_MAS;
import static utils.Constants.*;
import static utils.Constants.VER;

public class IngresaConsultarConsumos implements Task {
    private final User user = TestDataProvider.getRealUser();
    private static final String paso1 = "ingresar a Consultar consumos";
    private static final String paso2 = "ingresar numero al que quieras administrar";
    private static final String paso3 = "validar version miniprogrma";
    private static final String paso4 = "validar Informacion Consultar consumos";
    private static final String paso5 = "validar consumo de datos roaming";
    private static final String paso6 = "validar consumo de apliaciones";
    private static final String paso7 = "app sin limites de consumo";
    private static final String paso8 = "Consultar consumo de voz";
    private static final String paso9 = "Consultar consumo paquetes y recargas adicionales";



    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Consulta tus Consumos"),
                WaitFor.aTime(3000),
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent()),
                WaitForResponse.withText("Soluciones Móviles"),
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
                ValidarTexto.validarTexto("Acerca de"),
                ValidarTexto.validarTexto(DECLARACION_SERVICIO),
                ValidarTextoQueContengaX.elTextoContiene(VER)
        );
        EvidenciaUtils.registrarCaptura(paso3);

        actor.attemptsTo(Click.on(BTN_VOLVER),
                WaitFor.aTime(1000)
        );

        actor.attemptsTo(
                ValidarTextoQueContengaX.elTextoContiene(CONSULTAR_CONSUMO),
                ValidarTextoQueContengaX.elTextoContiene("40GB Emp 2 Mx"),
                ValidarTextoQueContengaX.elTextoContiene("Ver descripción del plan"),
                ScrollHorizontalCoordenadas.desde(366, 653 ,366, 339),
                WaitFor.aTime(5000)
        );
        EvidenciaUtils.registrarCaptura(paso4);
        actor.attemptsTo(
         ClickTextoQueContengaX.elTextoContiene("Detalle de consumos"),
                WaitFor.aTime(5000),
                ClickTextoQueContengaX.elTextoContiene("Consumo de datos roaming"),
                WaitFor.aTime(6000)
        );
        EvidenciaUtils.registrarCaptura(paso5);
        actor.attemptsTo(
                ClickEnCoordenadas.en(326, 323),
                ScrollHorizontalCoordenadas.desde(366, 653 ,366, 339),
                ClickTextoQueContengaX.elTextoContiene("Aplicaciones"),
                WaitFor.aTime(6000)
        );
        EvidenciaUtils.registrarCaptura(paso6);
        actor.attemptsTo(

                ClickEnCoordenadas.en(326, 323),
                ScrollHorizontalCoordenadas.desde(366, 653 ,366, 339),
                ClickTextoQueContengaX.elTextoContiene("Apps sin límite de consumo"),
                WaitFor.aTime(6000)
        );
        EvidenciaUtils.registrarCaptura(paso7);
        actor.attemptsTo(

                ClickEnCoordenadas.en(326, 323),
                ScrollHorizontalCoordenadas.desde(366, 653 ,366, 339),
                ClickTextoQueContengaX.elTextoContiene("Consulta consumo de voz"),
                WaitFor.aTime(6000),
                ScrollHorizontalCoordenadas.desde(366, 653 ,366, 339)

        );
        EvidenciaUtils.registrarCaptura(paso8);
        actor.attemptsTo(

                ClickEnCoordenadas.en(326, 323),
                ScrollHorizontalCoordenadas.desde(366, 653 ,366, 339),
                ClickTextoQueContengaX.elTextoContiene("Paquetes y recargas adicionales"),
                WaitFor.aTime(7000)
        );
        EvidenciaUtils.registrarCaptura(paso9);

    }
    private <T extends Actor> boolean isVisibleFast(T actor, Target element) {
        try {
            return !Presence.of(element).viewedBy(actor).resolveAll().isEmpty();
        } catch (Exception e) {
            return false;
        }
    }
    public static Performable ingresaConsultarConsumos() {
        return instrumented(IngresaConsultarConsumos.class);
    }

}

