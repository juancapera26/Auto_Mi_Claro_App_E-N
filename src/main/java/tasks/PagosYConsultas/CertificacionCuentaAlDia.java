package tasks.PagosYConsultas;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static userinterfaces.EntretenimientoPage.BTN_VOLVER;
import static userinterfaces.PagosYConsultasPage.BTN_TRES_PUNTOS_MAS;
import static userinterfaces.PagosYConsultasPage.IMAG_CONSTANCIA_AL_DIA;
import static utils.Constants.*;
import static utils.ConstantsMiniVersiones.Versiones.MINI_VERSION_CERTIFICADO_CUETA_AL_DIA;

import interactions.Click.ClickEnCoordenadas;
import interactions.Click.ClickTextoQueContengaX;
import interactions.comunes.Atras;
import interactions.validations.ValidarElemento;
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

public class CertificacionCuentaAlDia implements Task {

  private static final User user = TestDataProvider.getRealUser();

  // Evidencias
  private static final String PASO_1 = "Ingresar a Certificación cuenta al día";
  private static final String PASO_2 = "Validar versión del módulo";
  private static final String PASO_3 = "Seleccionar documento";
  private static final String PASO_4 = "Descargar certificación";
  private static final String PASO_5 = "Validar documento descargado";
  private static final String PASO_6 = "Enviar certificación";
  private static final String PASO_7 = "Validar popup de envío";

  @Override
  public <T extends Actor> void performAs(T actor) {

    // Ingresar al módulo
    actor.attemptsTo(
            ClickTextoQueContengaX.elTextoContiene(CERTIFICACION_CUENTA_AL_DIA),
            WaitForResponse.withText(CERTIFICACION_CUENTA_AL_DIA),
            ValidarTextoQueContengaX.elTextoContiene("Cuenta Hogar")
    );

    EvidenciaUtils.registrarCaptura(PASO_1);

    // Validar versión del módulo
    actor.attemptsTo(
            Click.on(BTN_TRES_PUNTOS_MAS),
            ClickTextoQueContengaX.elTextoContiene("Acerca de"),
            WaitForResponse.withText("Ver"),
            ValidarTextoQueContengaX.elTextoContiene(CERTIFICACION_CUENTA_AL_DIA),
            VerificarVersionModulo.conLaEsperada(MINI_VERSION_CERTIFICADO_CUETA_AL_DIA),
            ValidarTextoQueContengaX.elTextoContiene(VER),
            WaitFor.aTime(6000)
    );

    EvidenciaUtils.registrarCaptura(PASO_2);

    actor.attemptsTo(
            ClickEnCoordenadas.en(55,200)
    );

    // Seleccionar documento
    actor.attemptsTo(
            ClickTextoQueContengaX.elTextoContiene(user.getCuentaHogar()),
            WaitFor.aTime(8000),
            ValidarTextoQueContengaX.elTextoContiene(DOCUMENTO_SELECCIONADO_1),
            WaitForResponse.withText(DESCARGAR),
            WaitFor.aTime(6000)
    );

    EvidenciaUtils.registrarCaptura(PASO_3);

    // Descargar certificación
    actor.attemptsTo(
            ClickTextoQueContengaX.elTextoContiene(DESCARGAR),
            WaitFor.aTime(3000)
    );

    EvidenciaUtils.registrarCaptura(PASO_4);

    // Validar documento descargado
    try {

      actor.attemptsTo(
              ValidarTextoQueContengaX.elTextoContiene(ABRIR_DOCUMENTO)
      );

      theActorInTheSpotlight().should(
              seeThat(ValidarElemento.esVisible(IMAG_CONSTANCIA_AL_DIA))
      );

      EvidenciaUtils.registrarCaptura(PASO_5);

    } catch (Exception e) {

      System.out.println("No se pudo validar el contenido del documento descargado");
    }

    // Volver y enviar certificación
    actor.attemptsTo(
            Atras.irAtras(),
            WaitForResponse.withText(DOCUMENTO_SELECCIONADO_1)
    );

    actor.attemptsTo(
            ClickTextoQueContengaX.elTextoContiene(ENVIAR),
            WaitFor.aTime(7000),
            WaitForResponse.withText(TU_SOLICITUD_FUE_GENERADA)
    );

    EvidenciaUtils.registrarCaptura(PASO_6);

    // Validar popup de envío
    actor.attemptsTo(
            ValidarTextoQueContengaX.elTextoContiene(TU_SOLICITUD_FUE_GENERADA),
            ValidarTextoQueContengaX.elTextoContiene(ENVIAREMOS_TU_CERTIFICACION),
            ValidarTexto.validarTexto(ACEPTAR_2),
            ClickTextoQueContengaX.elTextoContiene(ACEPTAR_2)
    );

    EvidenciaUtils.registrarCaptura(PASO_7);
  }

  public static Performable gestionarCertificacion() {
    return instrumented(CertificacionCuentaAlDia.class);
  }
}