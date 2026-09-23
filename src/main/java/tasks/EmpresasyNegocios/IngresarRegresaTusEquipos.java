package tasks.EmpresasyNegocios;

import interactions.Click.ClickTextoQueContengaX;
import interactions.EmpresasyNegocios.NavegarAtras;
import interactions.EmpresasyNegocios.ValidarAcercaDe;
import interactions.Scroll.ScrollHastaTexto;
import interactions.validations.ValidarTextoQueContengaX;
import interactions.wait.WaitFor;
import models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import utils.EvidenciaUtils;
import utils.TestDataProvider;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static userinterfaces.EntretenimientoPage.BTN_VOLVER;
import static userinterfaces.LoginPage.LOADING_ESPERA_UN_MOMENTO;

public class IngresarRegresaTusEquipos implements Task {
    private final User user = TestDataProvider.getRealUser();
    private static final String paso1 = "ingresar a Visitas y trasladso";
    private static final String paso2 = "ingresar a version de miniprograma";
    private static final String paso3 = "validar menu de visitas y traslados";
    private static final String paso4 = "validar version de miniprograma";
    private static final String paso5 = "";
    private static final String paso6 = "";
    private static final String paso7 = "";

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ValidarTextoQueContengaX.elTextoContiene("Regresa tus equipos"),
                ClickTextoQueContengaX.elTextoContiene("Regresa tus equipos"),
                WaitFor.aTime(1500),
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent())
        );
        EvidenciaUtils.registrarCaptura(paso1);
        actor.attemptsTo(
                ValidarAcercaDe.elMenu(),
                WaitFor.aTime(2500)
        );

        EvidenciaUtils.registrarCaptura(paso2);
        WaitFor.aTime(2500);

        actor.attemptsTo(Click.on(BTN_VOLVER));

        actor.attemptsTo(
                ValidarTextoQueContengaX.elTextoContiene("Regresa tus equipos"),
                ClickTextoQueContengaX.elTextoContiene("Continuar"),
                WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent()),
                ValidarTextoQueContengaX.porTiempo("Devolución de Equipos Hogar", 3)
        );
        EvidenciaUtils.registrarCaptura(paso3);

        actor.attemptsTo(
                ScrollHastaTexto.conTexto("Enviar")
        );

        EvidenciaUtils.registrarCaptura(paso4);

    }
    public static Performable ingresarRegresaTusEquipos() {
        return instrumented(IngresarRegresaTusEquipos.class);
    }
}

