package tasks.PagosYConsultas;

import interactions.Click.ClickTextoQueContengaX;
import interactions.Scroll.ScrollHastaTexto;
import interactions.validations.ValidarTextoQueContengaX;
import interactions.validations.VerificarVersionModulo;
import interactions.wait.WaitFor;
import interactions.wait.WaitForResponse;
import models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import utils.EvidenciaUtils;
import utils.TestDataProvider;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.EntretenimientoPage.BTN_VOLVER;
import static userinterfaces.PagosYConsultasPage.BTN_TRES_PUNTOS_MAS;
import static utils.Constants.*;
import static utils.ConstantsMiniVersiones.Versiones.MINI_VERSION_DEVOLUCION_DE_EQUIPOS;
import static utils.ConstantsMiniVersiones.Versiones.MINI_VERSION_REINICIAR_MODEM;

public class ingresarReiniciarModem implements Task {
    private final User user = TestDataProvider.getRealUser();
    private static final String paso1 = "Hacer clic en Reiniciar Modem";
    private static final String paso2 = "Verificar versión de miniprograma";
    private static final String paso3 = "Validar redireccion a reiniciar modem";
    private static final String paso4 = "Validar mensaje de confirmacion de redireccion a reiniciar modem";

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(ScrollHastaTexto.conTexto(REINICIAR_MODEM));

        EvidenciaUtils.registrarCaptura(paso1);

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(REINICIAR_MODEM), WaitForResponse.withText(CUENTA + " " + user.getCuentaHogar() + " " + "Diagnosticar"));

        actor.attemptsTo(
                Click.on(BTN_TRES_PUNTOS_MAS),
                ClickTextoQueContengaX.elTextoContiene("Acerca de"),
                WaitForResponse.withText("Ver"),
                ValidarTextoQueContengaX.elTextoContiene(REINICIAR_MODEM),
                VerificarVersionModulo.conLaEsperada(MINI_VERSION_REINICIAR_MODEM),
                ValidarTextoQueContengaX.elTextoContiene(VER));

        EvidenciaUtils.registrarCaptura(paso2);

        actor.attemptsTo(Click.on(BTN_VOLVER));


        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(
                        CUENTA + " " + user.getCuentaHogar() + " " + "Diagnosticar"
                ),
                WaitFor.aTime(10000)

        );
        EvidenciaUtils.registrarCaptura(paso3);
        actor.attemptsTo(
                WaitForResponse.withText("Diagnóstico del módem"),
                ClickTextoQueContengaX.elTextoContiene("Reiniciar Módem")

        );
    }
    public static Performable IngresarReiniciarModem() {
        return instrumented(ingresarReiniciarModem.class);
    }
}