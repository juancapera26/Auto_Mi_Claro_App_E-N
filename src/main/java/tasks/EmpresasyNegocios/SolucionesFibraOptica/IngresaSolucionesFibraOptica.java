package tasks.EmpresasyNegocios.SolucionesFibraOptica;

import interactions.Click.ClickTextoQueContengaX;
import interactions.Scroll.ScrollHastaTexto;
import interactions.wait.WaitFor;
import interactions.wait.WaitForResponse;
import models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;
import utils.EvidenciaUtils;
import utils.TestDataProvider;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static userinterfaces.LoginPage.LOADING_SPLASH;
import static utils.Constants.INFORMACION_TRAMITE;
import static utils.Constants.VER_MAS;

public class IngresaSolucionesFibraOptica implements Task {
    private static final String paso1 = "Ingresar a soluciones fibra optica";


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ScrollHastaTexto.conTexto("Otras funcionalidades")
        );

        EvidenciaUtils.registrarCaptura(paso1);
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(VER_MAS),
                WaitForResponse.withText("Soluciones FO Emp")
        );

    }

    public static Performable ingresaSolucionesFibraOptica() {
        return instrumented(IngresaSolucionesFibraOptica.class);
    }
}
