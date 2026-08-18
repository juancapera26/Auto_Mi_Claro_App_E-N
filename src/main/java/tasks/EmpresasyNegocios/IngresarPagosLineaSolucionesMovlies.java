package tasks.EmpresasyNegocios;

import interactions.Click.ClickTextoQueContengaX;
import interactions.Scroll.Scroll;
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
import static userinterfaces.EmpresasNegociosPage.SELECIONAR_FACTURA;
import static userinterfaces.LoginPage.LOADING_SPLASH;

public class IngresarPagosLineaSolucionesMovlies implements Task {
    private final User user = TestDataProvider.getRealUser();
    private static final String paso1 = "ingresar a pagos en línea";
    private static final String paso2 = "ingresar a soluciones moviles y selecionar factura";
    private static final String paso3 = "validar factura y opcion de pagar";


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Pagos en línea"),
                WaitFor.aTime(3000)
        );
        EvidenciaUtils.registrarCaptura(paso1);

        actor.attemptsTo(
                WaitUntil.the(LOADING_SPLASH,  isNotPresent()),
                ClickTextoQueContengaX.elTextoContiene("Soluciones Móviles"),
                WaitFor.aTime(2000),
                Click.on(SELECIONAR_FACTURA)
        );

        EvidenciaUtils.registrarCaptura(paso2);

        actor.attemptsTo(
                Scroll.scrollUnaVista(),
                Scroll.scrollUnaVista(),
                WaitFor.aTime(3000)
        );
        EvidenciaUtils.registrarCaptura(paso3);
    }
    public static Performable ingresarPagosLineaSolucionesMovlies() {
        return instrumented(IngresarPagosLineaSolucionesMovlies.class);
    }

}
