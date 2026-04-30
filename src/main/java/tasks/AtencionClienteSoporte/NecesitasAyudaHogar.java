package tasks.AtencionClienteSoporte;

import interactions.Click.ClickTextoQueContengaX;
import interactions.validations.ValidarTextoQueContengaX;
import interactions.validations.VerificarVersionModulo;
import interactions.wait.WaitForResponse;
import models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import utils.AndroidObject;
import utils.EvidenciaUtils;
import utils.TestDataProvider;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.EntretenimientoPage.BTN_VOLVER;
import static userinterfaces.PagosYConsultasPage.BTN_TRES_PUNTOS_MAS;
import static utils.Constants.*;
import static utils.ConstantsMiniVersiones.Versiones.MINI_VERSION_NECESITAS_AYUDA_CONSTANT;

public class NecesitasAyudaHogar implements Task {

    private static final String paso1 = "Ingresar a ¿Necesitas ayuda?";
    private static final String paso2 = "Validar cuenta hogar";
    private static final String paso3 = "Validar version miniprogrma  acerca de";
    private static final String paso4 = "Validar version miniprogrma";
    private static final String paso5 = "Validar redireccion a chat bot";
    private final User user = TestDataProvider.getRealUser(); // ✅ agregado

    @Override
    public <T extends Actor> void performAs(T actor) {

        EvidenciaUtils.registrarCaptura(paso1);

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(NECESITAS_AYUDA),
                WaitForResponse.withText(HOGAR)
        );

        AndroidObject.scrollCorto2(
                actor,
                LINEA + " " + user.getCuentaHogar() + " " + CONTINUAR

        );
        EvidenciaUtils.registrarCaptura(paso2);

        actor.attemptsTo(
                Click.on(BTN_TRES_PUNTOS_MAS),
                ValidarTextoQueContengaX.elTextoContiene("Acerca de")
        );

        EvidenciaUtils.registrarCaptura(paso3);

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Acerca de")
        );

        actor.attemptsTo(
                WaitForResponse.withText("Ver"),
                ValidarTextoQueContengaX.elTextoContiene(NECESITAS_AYUDA),
                VerificarVersionModulo.conLaEsperada(MINI_VERSION_NECESITAS_AYUDA_CONSTANT)
        );

        EvidenciaUtils.registrarCaptura(paso4);

        actor.attemptsTo(Click.on(BTN_VOLVER));

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(user.getCuentaHogar()),
                WaitForResponse.withAnyText(CLAROBOT),
                ValidarTextoQueContengaX.elTextoContiene(CLAROBOT)
        );
        EvidenciaUtils.registrarCaptura(paso5);
    }

    public static Performable ingresar() {
        return instrumented(NecesitasAyudaHogar.class);
    }
}