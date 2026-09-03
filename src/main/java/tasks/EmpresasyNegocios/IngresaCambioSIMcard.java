package tasks.EmpresasyNegocios;

import interactions.Click.ClickEnCoordenadas;
import interactions.Click.ClickTextoQueContengaX;
import interactions.Scroll.Scroll;
import interactions.validations.ValidarTexto;
import interactions.validations.ValidarTextoQueContengaX;
import interactions.wait.WaitFor;
import models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import utils.EvidenciaUtils;
import utils.TestDataProvider;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static userinterfaces.EmpresasNegociosPage.CAMPO_INGRESO_SERIAL;
import static userinterfaces.EntretenimientoPage.BTN_VOLVER;
import static userinterfaces.LoginPage.LOADING_CAMBIO_SIM;
import static userinterfaces.LoginPage.LOADING_SPLASH;
import static userinterfaces.PagosYConsultasPage.BTN_TRES_PUNTOS_MAS;
import static utils.Constants.*;

public class IngresaCambioSIMcard implements Task {
    private final User user = TestDataProvider.getRealUser();
    private static final String paso1 = "ingresar a Cambio sim card";
    private static final String paso2 = "ingresar numero al que quieras administrar";
    private static final String paso3 = "validar version miniprogrma";
    private static final String paso4 = "validar informacion Cambio sim card";
    private static final String paso5 = "validar version miniprograma Cambio de Sim";
    private static final String paso6 = "validar Ingreso los últimos 12 números del serial";




    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Cambio"),
                WaitFor.aTime(2000),
                WaitUntil.the(LOADING_CAMBIO_SIM, isNotPresent()),
                WaitUntil.the(LOADING_SPLASH, isNotPresent())

        );

        EvidenciaUtils.registrarCaptura(paso1);

        EvidenciaUtils.registrarCaptura(paso2);

        actor.attemptsTo(
                WaitFor.aTime(1000),
                Click.on(BTN_TRES_PUNTOS_MAS),
                ClickTextoQueContengaX.elTextoContiene(ACERCA_DE),
                WaitFor.aTime(1500),
                ValidarTexto.validarTexto("Acerca de"),
                ValidarTexto.validarTexto(DECLARACION_SERVICIO),
                ValidarTextoQueContengaX.elTextoContiene(VER)
        );
        EvidenciaUtils.registrarCaptura(paso3);

        actor.attemptsTo(Click.on(BTN_VOLVER),
                WaitFor.aTime(1000)
        );


        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(CONTINUAR),
                WaitUntil.the(LOADING_SPLASH,  isNotPresent()),
                ValidarTextoQueContengaX.elTextoContiene(CAMBIO_SIM_CARD),
                ValidarTextoQueContengaX.elTextoContiene("Línea móvil a la que se aplicará el cambio:"),
                ValidarTextoQueContengaX.elTextoContiene("3226918354"),
                Scroll.scrollUnaVista(),
                WaitFor.aTime(2000)
        );
        EvidenciaUtils.registrarCaptura(paso4);
        actor.attemptsTo(
                WaitFor.aTime(1000),
                Click.on(BTN_TRES_PUNTOS_MAS),
                ClickTextoQueContengaX.elTextoContiene(ACERCA_DE),
                WaitFor.aTime(1500),
                //ValidarTexto.validarTexto(CAMBIO_SIM_CARD),
                ValidarTexto.validarTexto(DECLARACION_SERVICIO),
                ValidarTextoQueContengaX.elTextoContiene(VER)
        );
        actor.attemptsTo(Click.on(BTN_VOLVER),
                WaitFor.aTime(1000)
        );
        EvidenciaUtils.registrarCaptura(paso5);
        actor.attemptsTo(
                ValidarTextoQueContengaX.elTextoContiene("Serial de la SIM Card"),
                ValidarTextoQueContengaX.elTextoContiene("Ingresa los últimos 12 números del serial"),
                ClickTextoQueContengaX.elTextoContiene("Escribe los números restantes")
                //Enter.theValue("702504939445").into(CAMPO_INGRESO_SERIAL)
                );
        EvidenciaUtils.registrarCaptura(paso6);

    }
    public static Performable ingresaCambioSIMcard() {
        return instrumented(IngresaCambioSIMcard.class);
    }


}
