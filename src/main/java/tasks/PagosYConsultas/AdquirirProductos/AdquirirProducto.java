package tasks.PagosYConsultas.AdquirirProductos;

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
import utils.AndroidObject;
import utils.EvidenciaUtils;
import utils.TestDataProvider;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.EntretenimientoPage.BTN_VOLVER;
import static userinterfaces.PagosYConsultasPage.BTN_TRES_PUNTOS_MAS;
import static utils.Constants.*;
import static utils.ConstantsMiniVersiones.Versiones.MINI_VERSION_ADQUIRIRI_PRODUCTOS;

public class AdquirirProducto implements Task {
    private static final User user = TestDataProvider.getRealUser();
    private static final String paso1 = "Hacer clic en producto";
    private static final String paso2 = "Validar version de miniprograma";
    private static final String paso3 = "Seleccionar la cuenta Hogar";
    private static final String paso4 = "validar opciones de productos";

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                ScrollHastaTexto.conTexto(ADQUIRIR_PRODUCTOS)
        );

        EvidenciaUtils.registrarCaptura(paso1);

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(ADQUIRIR_PRODUCTOS),
                WaitForResponse.withText(HOGAR));


            actor.attemptsTo(
                Click.on(BTN_TRES_PUNTOS_MAS),
                ClickTextoQueContengaX.elTextoContiene("Acerca de"),
                WaitForResponse.withText("Ver"),
                ValidarTextoQueContengaX.elTextoContiene(ADQUIRIR_PRODUCTOS),
                VerificarVersionModulo.conLaEsperada(MINI_VERSION_ADQUIRIRI_PRODUCTOS),
                ValidarTextoQueContengaX.elTextoContiene(VER)
        );

        EvidenciaUtils.registrarCaptura(paso2);

        actor.attemptsTo(
                Click.on(BTN_VOLVER)
        );

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(HOGAR),
        ValidarTextoQueContengaX.elTextoContiene(CUENTA + " " + user.getCuentaHogar() + " " + VER_DETALLE));
        EvidenciaUtils.registrarCaptura(paso3);

        actor.attemptsTo(ClickTextoQueContengaX.elTextoContiene(user.getCuentaHogar()));
        EvidenciaUtils.registrarCaptura(paso4);
        actor.attemptsTo(
        WaitFor.aTime(6000));
    }

    public static Performable adquirir() {
        return instrumented(AdquirirProducto.class);
    }
}