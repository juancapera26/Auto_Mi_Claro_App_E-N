package tasks.AtencionClienteSoporte;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static userinterfaces.AtencionClienteSoportePage.*;
import static userinterfaces.EntretenimientoPage.BTN_VOLVER;
import static userinterfaces.EntretenimientoPage.LBL_ESPERA_UN_MOMENTO;
import static userinterfaces.PagosYConsultasPage.BTN_TRES_PUNTOS_MAS;
import static utils.Constants.*;
import static utils.ConstantsMiniVersiones.Versiones.MINI_VERSION_ESTADO_SERVICIOS_TECNICOS_CONSTANT;

import interactions.Click.ClickElementByText;
import interactions.Click.ClickTextoQueContengaX;
import interactions.Scroll.ScrollHastaTexto;
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
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import utils.EvidenciaUtils;
import utils.TestDataProvider;

public class EstadoServiciosTecnicos implements Task {

  private final User user = TestDataProvider.getRealUser();

  @Override
  public <T extends Actor> void performAs(T actor) {

    EvidenciaUtils.registrarCaptura("Ingresar a Estado Servicios Técnicos");

    actor.attemptsTo(
            ClickTextoQueContengaX.elTextoContiene(VER_MAS),
            ClickTextoQueContengaX.elTextoContiene(ESTADO_SERVICIOS_TECNICOS),
            WaitForResponse.withText(HOGAR)
    );

    actor.attemptsTo(
            WaitUntil.the(LBL_ESPERA_UN_MOMENTO, isNotPresent())
                    .forNoMoreThan(30).seconds()

    );

    EvidenciaUtils.registrarCaptura("Pantalla cargada");

    // ======================================================
    // 🔹 ACERCA DE
    // ======================================================
    actor.attemptsTo(
            Click.on(BTN_TRES_PUNTOS_MAS),
            ClickTextoQueContengaX.elTextoContiene("Acerca de"),
            WaitForResponse.withText("Ver"),
            ValidarTextoQueContengaX.elTextoContiene(ESTADO_SERVICIOS_TECNICOS),
            VerificarVersionModulo.conLaEsperada(MINI_VERSION_ESTADO_SERVICIOS_TECNICOS_CONSTANT),
            Click.on(BTN_VOLVER)

    );

    EvidenciaUtils.registrarCaptura("Seleccionar línea y ver detalle");

    actor.attemptsTo(
            ScrollHastaTexto.conTexto(user.getCuentaHogar() + " " + VER_DETALLE),
            ClickTextoQueContengaX.elTextoContiene(user.getCuentaHogar()),
            WaitForResponse.withText(ORDENES_DE_SERVICIO),
            WaitFor.aTime(4000)
    );

    // ======================================================
    // 🔹 DOCUMENTO
    // ======================================================
    EvidenciaUtils.registrarCaptura("Consultar por documento");

    actor.attemptsTo(
            Click.on(COMBO_CRITERIO_BUSQUEDA),
            ClickTextoQueContengaX.elTextoContiene(NUMERO_DE_DOCUMENTO),
            Enter.theValue(user.getCedula()).into(TXT_INGRESA_NUMERO),
            Click.on(BTN_CONSULTAR),
            WaitFor.aTime(25000),
            ValidarTexto.validarTexto(NO_SE_ENCONTRO_INFORMACION),
            ClickElementByText.clickElementByText(ACEPTAR_2)
    );

    // ======================================================
    // 🔹 CELULAR
    // ======================================================
    EvidenciaUtils.registrarCaptura("Consultar por celular");

    actor.attemptsTo(
            Click.on(COMBO_CRITERIO_BUSQUEDA),
            ClickTextoQueContengaX.elTextoContiene(NUMERO_DE_CELULAR),
            Enter.theValue(user.getNumero()).into(TXT_INGRESA_NUMERO),
            Click.on(BTN_CONSULTAR),
            WaitFor.aTime(25000),
            WaitForResponse.withText(NO_SE_ENCONTRO_INFORMACION),
            ValidarTexto.validarTexto(NO_SE_ENCONTRO_INFORMACION),
            ClickElementByText.clickElementByText(ACEPTAR_2)
    );

    // ======================================================
    // 🔹 IMEI
    // ======================================================
    EvidenciaUtils.registrarCaptura("Consultar por IMEI");

    actor.attemptsTo(
            Click.on(COMBO_CRITERIO_BUSQUEDA),
            ClickTextoQueContengaX.elTextoContiene(IMEI),
            Enter.theValue(user.getImei()).into(TXT_INGRESA_NUMERO),
            Click.on(BTN_CONSULTAR),
            WaitFor.aTime(25000),
            WaitForResponse.withText(NO_SE_ENCONTRO_INFORMACION),
            ValidarTexto.validarTexto(NO_SE_ENCONTRO_INFORMACION),
            ClickElementByText.clickElementByText(ACEPTAR_2)
    );
  }

  public static Performable ingresar() {
    return instrumented(EstadoServiciosTecnicos.class);
  }
}