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
import utils.EvidenciaUtils;
import utils.TestDataProvider;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utils.Constants.*;

public class IngresarSolucionesMoviles implements Task {
    private final User user = TestDataProvider.getRealUser();
    private static final String paso1 = "Ingresar a solcuiones moviles ";
    private static final String paso2 = "Validar opciones de solcuiones moviles ";


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                        Scroll.scrollUnaVista()
                );


       // actor.attemptsTo(
       //         ValidarTextoQueContengaX.elTextoContiene(SOLUCIONES_MOVILES));

        EvidenciaUtils.registrarCaptura(paso1);
        WaitFor.aTime(2500);
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(VER_MAS),
                WaitFor.aTime(3000)
        );
        EvidenciaUtils.registrarCaptura(paso2);
    }
    public static Performable ingresarSolucionesMoviles() {
        return instrumented(IngresarSolucionesMoviles.class);
    }
}