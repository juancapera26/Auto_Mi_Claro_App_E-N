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
import static userinterfaces.PagosYConsultasPage.BTN_TRES_PUNTOS_MAS;
import static userinterfaces.PagosYConsultasPage.LBL_FECHA_VALOR;
import static utils.Constants.*;
import static utils.Constants.FECHA_PAGO_OPORTUNO;
import static utils.ConstantsMiniVersiones.Versiones.MINI_VERSION_PAGA_TU_FACTURA_CONSTANT;

public class ingresaAServiciosFavoritosPagaTuFactura implements Task {
    private static final User user = TestDataProvider.getRealUser();
    private static final String paso = "Ingreso a Paga y consulta tus facturas";
    private static final String paso2 = "Seleccionar la cuenta Hogar";
    private static final String paso3 = "Validar Mini Versión";
    private static final String paso4 = "Validar datos de pago: Referencia, fechas y valor y validar fecha de pago oportuno";

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(PAGA_TU_FACTURA),
                WaitForResponse.withText(HOGAR));

        EvidenciaUtils.registrarCaptura(paso);

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(HOGAR)
        );actor.attemptsTo(
                ValidarTextoQueContengaX.elTextoContiene(
                        CUENTA + " " + user.getCuentaHogar() + " " + VER_DETALLE
                )
        );
        //AndroidObject.scrollCorto2(actor, CUENTA + " " + user.getCuentaHogar() + " " + VER_DETALLE);
        EvidenciaUtils.registrarCaptura(paso2);

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(user.getCuentaHogar()),
                WaitForResponse.withText(PAGAR_FACTURA),
                Click.on(BTN_TRES_PUNTOS_MAS),
                ClickTextoQueContengaX.elTextoContiene(ACERCA_DE),
                WaitFor.aTime(1000),
                ValidarTexto.validarTexto(PAGA_TU_FACTURA),
                ValidarTexto.validarTexto(DECLARACION_SERVICIO),
                ValidarTextoQueContengaX.elTextoContiene(VER));

        EvidenciaUtils.registrarCaptura(paso3);

        actor.attemptsTo(
                VerificarVersionModulo.conLaEsperada(MINI_VERSION_PAGA_TU_FACTURA_CONSTANT),
                Atras.irAtras(),
                WaitForResponse.withText(PAGAR_FACTURA),
                ValidarTextoQueContengaX.elTextoContiene(REFERENCIA_PAGO),
                ValidarTextoQueContengaX.elTextoContiene(VALOR_A_PAGAR),
                ValidarTextoQueContengaX.elTextoContiene("Fecha de pago oportuno"),
                ValidarTextoQueContengaX.elTextoContiene(FECHA_PAGO_OPORTUNO)
        );
        String fechaUI = LBL_FECHA_VALOR.resolveFor(actor).getText();

        if (fechaUI == null || fechaUI.trim().isEmpty()) {
            throw new AssertionError("La fecha de pago oportuno está vacía en la UI");
        }
        EvidenciaUtils.registrarCaptura(paso4);
    }

    public static Performable pagaTuFactura() {
        return instrumented(ingresaAServiciosFavoritosPagaTuFactura.class);
    }
}