package tasks.PagosYConsultas;

import interactions.Click.ClickTextoQueContengaX;
import interactions.comunes.Atras;
import interactions.validations.ValidarTexto;
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
import static userinterfaces.EmpresasNegociosPage.SELECIONAR_ANUNCIO;
import static userinterfaces.EntretenimientoPage.BTN_VOLVER;
import static userinterfaces.PagosYConsultasPage.BTN_TRES_PUNTOS_MAS;
import static userinterfaces.PagosYConsultasPage.LBL_FECHA_VALOR;
import static utils.Constants.*;
import static utils.Constants.FECHA_PAGO_OPORTUNO;
import static utils.ConstantsMiniVersiones.Versiones.MINI_VERSION_PAGA_TU_FACTURA_CONSTANT;

public class IngresarGuiaNovedades implements Task {
    private static final User user = TestDataProvider.getRealUser();
    private static final String paso = "Ingreso a Guias y novedades";
    private static final String paso2 = "Validar Mini Versión";
    private static final String paso3 = "Validar rericionamiento de anuncios";


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(GUIA_Y_NOVEDADES),
                WaitForResponse.withText(GUIA_Y_NOVEDADES));

        EvidenciaUtils.registrarCaptura(paso);

        actor.attemptsTo(
                Click.on(BTN_TRES_PUNTOS_MAS),
                ClickTextoQueContengaX.elTextoContiene(ACERCA_DE),
                WaitFor.aTime(1000),
                ValidarTexto.validarTexto(GUIA_Y_NOVEDADES),
                ValidarTexto.validarTexto(DECLARACION_SERVICIO),
                ValidarTextoQueContengaX.elTextoContiene(VER));

        EvidenciaUtils.registrarCaptura(paso2);

        actor.attemptsTo(Click.on(BTN_VOLVER));

        actor.attemptsTo(
                Click.on(SELECIONAR_ANUNCIO)
        );
    }

    public static Performable ingresarGuiaNovedades() {
        return instrumented(IngresarGuiaNovedades.class);
    }
}