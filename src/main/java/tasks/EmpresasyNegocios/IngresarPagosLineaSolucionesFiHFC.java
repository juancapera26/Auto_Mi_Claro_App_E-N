package tasks.EmpresasyNegocios;

import interactions.Click.ClickElementByText;
import interactions.Click.ClickTextoQueContengaX;
import interactions.Scroll.Scroll;
import interactions.wait.WaitFor;
import models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import utils.EvidenciaUtils;
import utils.TestDataProvider;

import static interactions.Click.ClickElementByText.clickElementByText;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.EmpresasNegociosPage.SELECIONAR_FACTURA;
import static userinterfaces.EmpresasNegociosPage.SELECIONAR_FACTURA_FIJAS_HFC;
import static utils.Constants.TUS_SERVICIOS_FAVORITOS;

public class IngresarPagosLineaSolucionesFiHFC implements Task {

    private final User user = TestDataProvider.getRealUser();

    private static final String paso1 = "ingresar a pagos en línea";
    private static final String paso2 = "ingresar a soluciones fijas HFC y seleccionar factura";
    private static final String paso3 = "validar factura y opción de pagar";

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Pagos en línea"),
                WaitFor.aTime(3000)
        );
        EvidenciaUtils.registrarCaptura(paso1);

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Soluciones Fijas HFC"),
                WaitFor.aTime(2000),
                Click.on(SELECIONAR_FACTURA_FIJAS_HFC)
        );

        EvidenciaUtils.registrarCaptura(paso2);

        actor.attemptsTo(
                Scroll.scrollUnaVista(),
                Scroll.scrollUnaVista(),
                WaitFor.aTime(3000)
        );

        EvidenciaUtils.registrarCaptura(paso3);
    }

    public static Performable ingresarPagosLineaSolucionesFiHFC() {
        return instrumented(IngresarPagosLineaSolucionesFiHFC.class);
    }
}