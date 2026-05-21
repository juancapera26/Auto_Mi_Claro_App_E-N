package tasks.PagosYConsultas.DetalleDeTuPlan;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.EntretenimientoPage.BTN_VOLVER;
import static userinterfaces.PagosYConsultasPage.BTN_TRES_PUNTOS_MAS;
import static utils.Constants.*;
import static utils.ConstantsMiniVersiones.Versiones.MINI_VERSION_DETALLE_DE_TU_PLAN_CONSTANT;

import interactions.Click.ClickTextoQueContengaX;
import interactions.Scroll.Scroll;
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
import utils.AndroidObject;
import utils.EvidenciaUtils;
import utils.TestDataProvider;

public class DetalleTuPlan implements Task {
  private static final User user = TestDataProvider.getRealUser();
  private static final String paso1 = "Seleccionar Detalle de tu plan";
  private static final String paso2 = "Seleccionar cuenta hogar " + user.getCuentaHogar();
  private static final String paso3 = "Validar versión de miniprograma";
  private static final String paso4 = "Validar información detalle del plan";
  private static final String paso5 = "Validar opciones disponibles";

  @Override
  public <T extends Actor> void performAs(T actor) {

    EvidenciaUtils.registrarCaptura(paso1);

    // Seleccionar "Detalle de tu plan"
    actor.attemptsTo(
        ClickTextoQueContengaX.elTextoContiene(DETALLE_DE_TU_PLAN),
        WaitForResponse.withText(HOGAR));

    EvidenciaUtils.registrarCaptura(paso2);

    // Seleccionar línea postpago
    AndroidObject.scrollCorto2(actor, CUENTA + " " + user.getCuentaHogar() + " " + VER_DETALLE);

    actor.attemptsTo(
        ClickTextoQueContengaX.elTextoContiene(user.getCuentaHogar()),
        WaitForResponse.withText(DETALLE_DE_TU_PLAN));

    // Validar versión de miniprograma
    actor.attemptsTo(
        WaitFor.aTime(2000),
        Click.on(BTN_TRES_PUNTOS_MAS),
        ClickTextoQueContengaX.elTextoContiene(ACERCA_DE),
        WaitForResponse.withText(DETALLE_DE_TU_PLAN_MINIPROGRAMA),
        ValidarTexto.validarTexto(DETALLE_DE_TU_PLAN_MINIPROGRAMA),
        ValidarTexto.validarTexto(DECLARACION_SERVICIO),
        ValidarTextoQueContengaX.elTextoContiene(VER),
            VerificarVersionModulo.conLaEsperada(MINI_VERSION_DETALLE_DE_TU_PLAN_CONSTANT));


    EvidenciaUtils.registrarCaptura(paso3);
    // Validar información detalle del plan
    actor.attemptsTo(
        Atras.irAtras(),
        ValidarTexto.validarTexto(CONSULTA_LA_FACTURA_DE_TU_PLAN_HOGAR),
        ValidarTexto.validarTexto(VER_FACTURA),
        //ValidarTexto.validarTexto(TU_PLAN),
        //ValidarTextoQueContengaX.elTextoContiene(CARGO_FIJO_MENSUAL_IVA_INCLUIDO),

        // Validar datos del plan
        ValidarTexto.validarTexto(INTERNET),
            ValidarTextoQueContengaX.elTextoContiene(VER_DETALLE_DE_INTERNET),

        // Validar television
            ValidarTextoQueContengaX.elTextoContiene(TELEVISION),
        ValidarTextoQueContengaX.elTextoContiene(VER_CANALES_INCLUIDOS),

            // Validar telefonia
            ValidarTextoQueContengaX.elTextoContiene(TELEFONIA),
            ValidarTextoQueContengaX.elTextoContiene(VER_INDICATIVOS)


    );


    EvidenciaUtils.registrarCaptura(paso4);

    actor.attemptsTo(
        // ir al portal de voz
        Scroll.scrollUnaVista(),
            WaitFor.aTime(2000),
            ValidarTexto.validarTexto(PORTAL_VOZ),
        ClickTextoQueContengaX.elTextoContiene(PORTAL_VOZ),
        ClickTextoQueContengaX.elTextoContiene(ACEPTAR_2),
            WaitFor.aTime(2000),
        Click.on(BTN_VOLVER),

        // Descarga teléfono virtual
            ValidarTexto.validarTexto(DESCARGA_TELEFONO_VIRTUAL),
            ClickTextoQueContengaX.elTextoContiene(DESCARGA_TELEFONO_VIRTUAL),
            WaitFor.aTime(2000)
    );

    EvidenciaUtils.registrarCaptura(paso5);
  }

  public static Performable validarDetalleTuPlan() {
    return instrumented(DetalleTuPlan.class);
  }
}
