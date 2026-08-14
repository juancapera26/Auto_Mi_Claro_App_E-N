package tasks.EmpresasyNegocios;

import interactions.Click.ClickElementByText;
import interactions.Click.ClickEnCoordenadas;
import interactions.Click.ClickTextoQueContengaX;
import interactions.validations.ValidarTexto;
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
import static userinterfaces.LoginPage.LOADING_SPLASH;
import static userinterfaces.PagosYConsultasPage.BTN_TRES_PUNTOS_MAS;
import static utils.Constants.*;

public class IngresaRoaminginternacional implements Task {
    private final User user = TestDataProvider.getRealUser();
    private static final String paso1 = "Ingresar a ingreso Roaming internacional ";
    private static final String paso2 = "ingresar numero al que quieras administrar";
    private static final String paso3 = "validar Informacion de Roaming internacional";
    private static final String paso4 = "validar Informacion Paquete";
    private static final String paso5 = "validar Informacion Paquete2";
    private static final String paso6 = "validar Informacion Paquete3";



    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitFor.aTime(1000)
        );
        EvidenciaUtils.registrarCaptura(paso1);
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Roaming"),
                WaitFor.aTime(1000),
                WaitUntil.the(LOADING_SPLASH, isNotPresent())
        );
        EvidenciaUtils.registrarCaptura(paso2);

        actor.attemptsTo(
                WaitUntil.the(LOADING_SPLASH, isNotPresent()),
                ClickTextoQueContengaX.elTextoContiene(CONTINUAR),
                WaitFor.aTime(3000)
        );

        actor.attemptsTo(
                WaitFor.aTime(2000),
                ValidarTextoQueContengaX.elTextoContiene(ROAMING_INTERNACIONAL),
                ValidarTextoQueContengaX.elTextoContiene("3226918354")

        );
        EvidenciaUtils.registrarCaptura(paso3);
        actor.attemptsTo(
                ValidarTextoQueContengaX.elTextoContiene("Pass AmericaEYN"),
                ClickTextoQueContengaX.elTextoContiene("Detalles del Paquete")
        );
        EvidenciaUtils.registrarCaptura(paso4);

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Detalles del Paquete"),
                WaitFor.aTime(2000)

        );
        actor.attemptsTo(
                ClickEnCoordenadas.en(385, 988),
                ValidarTextoQueContengaX.elTextoContiene("Pass AmericaEYN"),
                ClickTextoQueContengaX.elTextoContiene("Detalles del Paquete")

        );

        EvidenciaUtils.registrarCaptura(paso5);

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Detalles del Paquete"),
                WaitFor.aTime(2000)

        );
        actor.attemptsTo(
                ClickEnCoordenadas.en(450, 988),
                WaitFor.aTime(2000),
                ClickTextoQueContengaX.elTextoContiene("Detalles del Paquete")

        );
        EvidenciaUtils.registrarCaptura(paso6);




    }
    public static Performable ingresaRoaminginternacional() {
        return instrumented(IngresaRoaminginternacional.class);
    }

}
