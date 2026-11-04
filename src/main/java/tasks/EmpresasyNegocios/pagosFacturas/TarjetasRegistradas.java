package tasks.EmpresasyNegocios.pagosFacturas;

import interactions.Click.ClickElementByText;
import interactions.Click.ClickTextoQueContengaX;
import interactions.EmpresasyNegocios.ValidarAcercaDe;
import interactions.validations.ValidarTextoQueContengaX;
import interactions.wait.WaitFor;
import interactions.wait.WaitForResponse;
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

public class TarjetasRegistradas implements Task {
    private final User user = TestDataProvider.getRealUser();
    private static final String paso1 = "Ingreso a Mis tarjetas registradas";
    private static final String paso2 = "Validar mini version del programa";
    private static final String paso3 = "Ingreso a Registrar nueva tarjeta";
    private static final String paso4 = "";

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                    ValidarTextoQueContengaX.elTextoContiene("Tarjetas registradas"),
                    ClickTextoQueContengaX.elTextoContiene("Tarjetas registradas"),
                    WaitFor.aTime(5000),
                    WaitUntil.the(LOADING_ESPERA_UN_MOMENTO, isNotPresent()),
            WaitForResponse.withText("Mis Tarjetas Registradas")
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
                ValidarTextoQueContengaX.elTextoContiene("Mis Tarjetas Registradas"),
                ClickElementByText.clickElementByText("Registrar una nueva tarjeta"),
                WaitFor.aTime(5000),
                WaitForResponse.withText("Registrar nueva tarjeta")
                );
        EvidenciaUtils.registrarCaptura(paso3);


}


public static Performable tarjetasRegistradas() {
    return instrumented(TarjetasRegistradas.class);
}

}
