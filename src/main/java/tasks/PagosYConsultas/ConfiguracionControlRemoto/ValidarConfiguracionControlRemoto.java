package tasks.PagosYConsultas.ConfiguracionControlRemoto;

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
import tasks.PagosYConsultas.AdquirirProductos.AdquirirProducto;
import utils.EvidenciaUtils;
import utils.TestDataProvider;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.EntretenimientoPage.BTN_VOLVER;
import static userinterfaces.PagosYConsultasPage.BTN_TRES_PUNTOS_MAS;
import static utils.Constants.*;
import static utils.Constants.VER_DETALLE;
import static utils.ConstantsMiniVersiones.Versiones.MINI_VERSION_ADQUIRIRI_PRODUCTOS;
import static utils.ConstantsMiniVersiones.Versiones.MINI_VERSION_CONFIGURACION_CONTROL_REMOTO;

public class ValidarConfiguracionControlRemoto  implements Task {
    private static final User user = TestDataProvider.getRealUser();
    private static final String paso1 = "Hacer clic Configurar control remoto";
    private static final String paso2 = "Validar version de miniprograma";
    private static final String paso3 = "Seleccionar la cuenta Hogar";
    private static final String paso4 = "validar opciones de Configurar control remoto";

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                ScrollHastaTexto.conTexto(CONFIGURACION_CONTROL_REMOTO)
        );

        EvidenciaUtils.registrarCaptura(paso1);

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(CONFIGURACION_CONTROL_REMOTO),
                WaitForResponse.withText(HOGAR));


        actor.attemptsTo(
                Click.on(BTN_TRES_PUNTOS_MAS),
                ClickTextoQueContengaX.elTextoContiene("Acerca de"),
                WaitForResponse.withText("Ver"),
                ValidarTextoQueContengaX.elTextoContiene(CONFIGURACION_CONTROL_REMOTO),
                VerificarVersionModulo.conLaEsperada(MINI_VERSION_CONFIGURACION_CONTROL_REMOTO),
                ValidarTextoQueContengaX.elTextoContiene(VER)
        );

        EvidenciaUtils.registrarCaptura(paso2);

        actor.attemptsTo(
                Click.on(BTN_VOLVER)
        );

        actor.attemptsTo(
                ValidarTextoQueContengaX.elTextoContiene(CUENTA + " " + user.getCuentaHogar() + " " + VER_DETALLE));
        EvidenciaUtils.registrarCaptura(paso3);

        actor.attemptsTo(ClickTextoQueContengaX.elTextoContiene(user.getCuentaHogar()));
        EvidenciaUtils.registrarCaptura(paso4);
        actor.attemptsTo(
                WaitFor.aTime(6000));
    }

    public static Performable validar() {
        return instrumented(ValidarConfiguracionControlRemoto.class);
    }
}
