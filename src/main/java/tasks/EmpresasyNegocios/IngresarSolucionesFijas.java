package tasks.EmpresasyNegocios;
import interactions.Click.ClickTextoQueContengaX;
import interactions.Scroll.Scroll;
import interactions.Scroll.ScrollHastaTexto;
import interactions.validations.ValidarTextoQueContengaX;
import interactions.wait.WaitFor;
import models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.ClickOnBy;
import utils.EvidenciaUtils;
import utils.TestDataProvider;

import static interactions.Scroll.Scroll.scrollUnaVista;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.EmpresasNegociosPage.VER_MAS_SF;
import static utils.Constants.*;

public class IngresarSolucionesFijas implements Task {
    private final User user = TestDataProvider.getRealUser();
    private static final String paso1 = "Ingresar a soluciones fijas ";
    private static final String paso2 = "Validar opciones de soluciones fijas ";


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ScrollHastaTexto.conTexto("Explora nuestros servicios")
        );

        EvidenciaUtils.registrarCaptura(paso1);
        WaitFor.aTime(2500);
        actor.attemptsTo(
                Click.on(VER_MAS_SF),
              //  ClickTextoQueContengaX.elTextoContiene(VER_MAS),
                WaitFor.aTime(3000)
        );
        EvidenciaUtils.registrarCaptura(paso2);
    }
    public static Performable ingresarSolucionesFijas() {
        return instrumented(IngresarSolucionesFijas.class);
    }
}

