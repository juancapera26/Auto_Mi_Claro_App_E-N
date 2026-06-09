package stepDefinitions;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static userinterfaces.MediosPagoPage.BTN_PSE_RECARGAS;
import static userinterfaces.PagosYConsultasPage.*;
import static utils.Constants.*;
import static utils.ConstantsMiniVersiones.Versiones.MINI_VERSION_RECARGAS_Y_PAQUETES_PRE;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import hooks.ReportHooks;
import interactions.Click.ClickElementByText;
import interactions.Click.ClickTextoQueContengaX;
import interactions.comunes.Atras;
import interactions.validations.ValidarTexto;
import interactions.validations.ValidarTextoQueContengaX;
import interactions.validations.VerificarVersionModulo;
import interactions.wait.WaitForResponse;
import models.User;
import net.serenitybdd.screenplay.actions.Click;
import tasks.MediosDePagos.*;
import tasks.Prepago.RecargasyPaquetes.*;
import utils.EvidenciaUtils;
import utils.TestDataProvider;

public class PagosyConsultasPreDefinitions {

  private final User user = TestDataProvider.getRealUser();

  @And("^selecciona linea prepago$")
  public void seleccionaLineaPrepago() {
    theActorInTheSpotlight().attemptsTo(SeleccionLineaPrepago.seleccionar());

    ReportHooks.setLinea(user.getNumeroPrepago());
  }

  @And("^validar la mini version de recargas$")
  public void validarMiniVersionRecargas() {
    theActorInTheSpotlight()
        .attemptsTo(
            Click.on(BTN_TRES_PUNTOS_MAS),
            ClickTextoQueContengaX.elTextoContiene(ACERCA_DE),
            WaitForResponse.withText(DECLARACION_SERVICIO),
            ValidarTexto.validarTexto(RECARGAS_Y_PAQUETES),
            ValidarTexto.validarTexto(DECLARACION_SERVICIO),
            ValidarTextoQueContengaX.elTextoContiene(VER),
            VerificarVersionModulo.conLaEsperada(MINI_VERSION_RECARGAS_Y_PAQUETES_PRE));

    EvidenciaUtils.registrarCaptura("Validar Mini Versión de Recargas");

    theActorInTheSpotlight().attemptsTo(Atras.irAtras());

    ReportHooks.setLinea(user.getNumeroPrepago());
  }

  @And("^arma paquete personalizado$")
  public void armaPaquetePersonalizado() {
    theActorInTheSpotlight().attemptsTo(ArmarPaquete.armar(), VerResumenPaquete.validarResumen());
  }

  @And("^valida paquete seleccionado$")
  public void validaPaqueteSeleccionado() {
    theActorInTheSpotlight().attemptsTo(ValidarPaqueteSeleccionado.validarPaquete());
  }

  @And("^ingresar a tarjeta credito debito$")
  public void ingresarTDC() {
    EvidenciaUtils.registrarCaptura("Seleccionar medio de pago: Tarjeta Crédito/débito");

    theActorInTheSpotlight()
        .attemptsTo(
            ClickTextoQueContengaX.elTextoContiene(TARJETA_C_D),
            WaitForResponse.withText(RESUMEN_COMPRA));
  }

  @And("^validar el resumen de la compra$")
  public void validaResumenCompra() {
    theActorInTheSpotlight().attemptsTo(ResumenCompra.validar());
  }

  @And("^validar direccionamiento tarjeta credito debito$")
  public void direccionamientoTCD() {
    theActorInTheSpotlight().attemptsTo(TarjetaCreditoDebito.validarRedireccion());
  }

  @And("^ingresar a pse$")
  public void ingresarPSE() {
    EvidenciaUtils.registrarCaptura("Seleccionar PSE como medio de pago");

    theActorInTheSpotlight()
        .attemptsTo(Click.on(BTN_PSE_RECARGAS), WaitForResponse.withText(RESUMEN_COMPRA));
  }

  @And("^validar direccionamiento pse$")
  public void direccionamientoPSE() {
    theActorInTheSpotlight().attemptsTo(PSE.validarRedireccion());
  }

  @And("^ingresar a pagar con mi saldo$")
  public void pagarConMiSaldo() {
    EvidenciaUtils.registrarCaptura("Seleccionar Pagar con mi saldo");

    theActorInTheSpotlight()
        .attemptsTo(
            ClickTextoQueContengaX.elTextoContiene(PAGAR_CON_MI_SALDO),
            WaitForResponse.withText(RESUMEN_COMPRA));
  }

  @And("^validar pago con el saldo$")
  public void pagoConElSaldo() {
    theActorInTheSpotlight().attemptsTo(ValidarNotificacion.deCompra());
  }

  @And("^ingresar a bancolombia$")
  public void ingresarBancolombia() {
    EvidenciaUtils.registrarCaptura("Seleccionar medio de pago: Bancolombia");

    theActorInTheSpotlight()
        .attemptsTo(
            ClickTextoQueContengaX.elTextoContiene(BOTON_BANCOLOMBIA),
            WaitForResponse.withText(RESUMEN_COMPRA));
  }

  @And("^validar direccionamiento bancolombia$")
  public void direccionamientoBancolombia() {
    theActorInTheSpotlight().attemptsTo(Bancolombia.validarRedireccion());
  }

  @And("^ingresar a daviplata$")
  public void ingresarDaviplata() {
    EvidenciaUtils.registrarCaptura("Seleccionar medio de pago: Daviplata");

    theActorInTheSpotlight()
        .attemptsTo(
            ClickTextoQueContengaX.elTextoContiene(DAVIPLATA),
            WaitForResponse.withText(RESUMEN_COMPRA));
  }

  @And("^validar direccionamiento daviplata")
  public void direccionamientoDaviplata() {
    theActorInTheSpotlight().attemptsTo(Daviplata.validarRedireccion());
  }

  @And("^ingresar a codensa$")
  public void ingresarCodensa() {
    EvidenciaUtils.registrarCaptura("Seleccionar medio de pago: Codensa");

    theActorInTheSpotlight()
        .attemptsTo(
            ClickTextoQueContengaX.elTextoContiene(CODENSA),
            WaitForResponse.withText(RESUMEN_COMPRA));
  }

  @And("^ingresar a otros medios de pago$")
  public void ingresarOtrosMediosDePago() {
    EvidenciaUtils.registrarCaptura("Seleccionar medio de pago: Otros medios de pago");

    theActorInTheSpotlight()
        .attemptsTo(
            ClickTextoQueContengaX.elTextoContiene(OTROS_MEDIOS),
            WaitForResponse.withText(RESUMEN_COMPRA));
  }

  @And("^direccionamiento otros medios de pago pse$")
  public void direccionamientoOtrosMediosDePagoPSE() {
    theActorInTheSpotlight().attemptsTo(OtrosMediosDePagoPSE.validarOtrosMediosPSE());

    ReportHooks.setLinea(user.getNumeroPrepago());
  }

  @And("^validar direccionamiento otros medios de pago$")
  public void direccionamientoOtrosMediosDePago() {
    theActorInTheSpotlight().attemptsTo(OtrosMediosDePago.validarOtrosMedios());

    ReportHooks.setLinea(user.getNumeroPrepago());
  }

  @And("^seleccionar el menu paquetes$")
  public void seleccionarPaquetes() {
    EvidenciaUtils.registrarCaptura("Ingresar a Paquetes");

    theActorInTheSpotlight()
        .attemptsTo(
            ClickElementByText.clickElementByText(PAQUETES),
            WaitForResponse.withText(ELIGE_TIPO_PAQUETE),
            ValidarTextoQueContengaX.elTextoContiene(ELIGE_TIPO_PAQUETE),
            ValidarTextoQueContengaX.elTextoContiene(user.getNumeroPrepago()));

    EvidenciaUtils.registrarCaptura("Direccionamiento exitoso");

    theActorInTheSpotlight()
        .attemptsTo(Click.on(CBX_TIPO_PAQUETE_RECARGAS), WaitForResponse.withText(TIPO_PAQUETE));
  }

  @Then("^seleccionar el tipo de paquete todo incluido con redes$")
  public void seleccionarPaqueteTodoIncluidoRedes() {
    theActorInTheSpotlight().attemptsTo(TodoIncluidoConRedes.validar());
  }

  @Then("realiza la validación de paquetes todo incluido sin redes")
  public void validarPaquetesTodoIncluidoSinRedes() {
    theActorInTheSpotlight().attemptsTo(TodoIncluidoSinRedes.validar());
  }

  @And("realiza la validación de paquetes de datos")
  public void validarPaquetesDeDatos() {
    theActorInTheSpotlight().attemptsTo(PaquetesDeDatos.validar());
  }

  @Then("^realiza recorrido completo paquetes de voz$")
  public void realizaRecorridoCompletoPaquetesDeVoz() {
    theActorInTheSpotlight().attemptsTo(PaquetesDeVoz.validar());
  }

  @Then("^realiza recorrido completo paquetes de apps$")
  public void realizaRecorridoCompletoPaquetesDeApps() {
    theActorInTheSpotlight().attemptsTo(PaquetesApps.validar());
  }

  @Then("^realiza recorrido completo paquetes relevo comunidad sorda$")
  public void realizaRecorridoCompletoPaquetesRelevoComunidadSorda() {
    theActorInTheSpotlight().attemptsTo(PaquetesRelevoComunidadSorda.validar());
  }

  @And("^seleccionar la linea en prepago$")
  public void seleccionarLineaEnPrepago() {
    theActorInTheSpotlight().attemptsTo(SeleccionarLaLineaEnPrepago.seleccionar());

    ReportHooks.setLinea(user.getNumeroPrepago());
  }
}
