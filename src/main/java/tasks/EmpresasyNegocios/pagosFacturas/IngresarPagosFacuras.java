package tasks.EmpresasyNegocios.pagosFacturas;

import interactions.Click.ClickTextoQueContengaX;
import interactions.Scroll.Scroll;
import interactions.wait.WaitFor;
import models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import utils.EvidenciaUtils;
import utils.TestDataProvider;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utils.Constants.VER_MAS;

public class IngresarPagosFacuras implements Task {
    private final User user = TestDataProvider.getRealUser();
    private static final String paso1 = "Ingresar a pagos y facturas ";
    private static final String paso2 = "Validar opciones de pagos y facturas ";


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.scrollUnaVista(),
                Scroll.scrollUnaVista()
        );
        EvidenciaUtils.registrarCaptura(paso1);

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(VER_MAS),
                WaitFor.aTime(3000)
        );
        EvidenciaUtils.registrarCaptura(paso2);
    }
    public static Performable ingresarPagosFacuras() {
        return instrumented(IngresarPagosFacuras.class);
    }
}