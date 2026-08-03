package tasks.EmpresasyNegocios;

import interactions.Click.ClickTextoQueContengaX;
import interactions.validations.EscribirOTP;
import interactions.validations.ObtenerOtp;
import interactions.validations.ValidarTexto;
import interactions.validations.ValidarTextoQueContengaX;
import interactions.wait.WaitFor;
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

public class IngresaDetalleTuPlanEYP implements Task {

    private final User user = TestDataProvider.getRealUser();

    private static final String paso1 = "Ingresar a Consulta tu plan";
    private static final String paso2 = "Pantalla ingreso del numero a consultar";
    private static final String paso3 = "Ingreso de código OTP";
    private static final String paso4 = "Validar versión del miniprograma";
    private static final String paso5 = "Validar información detalle de tu plan";

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Claro Empresas"),
                WaitFor.aTime(3000),
                ClickTextoQueContengaX.elTextoContiene("Consulta tu plan"),
                WaitFor.aTime(3000)
        );

        // Pantalla Consulta tu plan
        EvidenciaUtils.registrarCaptura(paso1);

        // Captura antes de presionar Continuar
        EvidenciaUtils.registrarCaptura(paso2);

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(CONTINUAR),
                WaitFor.aTime(10000)
        );

        // Ya cargó la pantalla para ingresar el OTP
        EvidenciaUtils.registrarCaptura(paso3);

        String otp = ObtenerOtp.obtener(actor);

        actor.attemptsTo(
                EscribirOTP.con(otp),
                WaitFor.aTime(3000)
        );

        actor.attemptsTo(
                WaitFor.aTime(1000),
                Click.on(BTN_TRES_PUNTOS_MAS),
                ClickTextoQueContengaX.elTextoContiene(ACERCA_DE),
                WaitFor.aTime(1000),
                ValidarTexto.validarTexto("Detalle de tu plan empresas"),
                ValidarTexto.validarTexto(DECLARACION_SERVICIO),
                ValidarTextoQueContengaX.elTextoContiene(VER)
        );

        EvidenciaUtils.registrarCaptura(paso4);

        actor.attemptsTo(
                Click.on(BTN_VOLVER),
                WaitFor.aTime(1000)
        );

        actor.attemptsTo(
                ValidarTextoQueContengaX.elTextoContiene("Detalle de tu plan"),
                ValidarTextoQueContengaX.elTextoContiene("322 691 8354"),
                ValidarTextoQueContengaX.elTextoContiene("Explora tus servicios")
        );

        EvidenciaUtils.registrarCaptura(paso5);
    }

    public static Performable ingresaDetalleTuPlanEYP() {
        return instrumented(IngresaDetalleTuPlanEYP.class);
    }
}