package stepDefinitions;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import tasks.ConsultarConsumos.*;

/**
 * Step Definitions para el módulo Consultar Consumos Mantiene la consistencia con el estilo
 * existente del proyecto
 */
public class ConsultarConsumosDefinitions {

  @And("^ingresa al modulo consultar consumos$")
  public void ingresaModuloConsultarConsumos() {
    theActorInTheSpotlight().attemptsTo(AccederConsultarConsumos.acceder());
  }

  @And("^desplazarse hasta el numero y seleccionar ver detalle$")
  public void desplazarseHastaNumeroYSeleccionarVerDetalle() {
    theActorInTheSpotlight().attemptsTo(SeleccionarLineaYVerDetalle.seleccionar());
  }

  @And("^espera a que ingrese a la opcion$")
  public void esperaAQueIngreseALaOpcion() {
    theActorInTheSpotlight().attemptsTo(VerificarTextosDisponibles.verificar());
  }

  @And("^verifica los textos disponibles$")
  public void verificaLosTextosDisponibles() {
    theActorInTheSpotlight().attemptsTo(VerificarTextosDisponibles.verificar());
  }

  // ===========================================
  // Consumo de Datos
  // ===========================================

  @And("^selecciona consumo de datos$")
  public void seleccionaConsumoDeatos() {
    theActorInTheSpotlight().attemptsTo(ValidarConsumoDeDatos.validar());
  }

  @And("^valida la informacion disponible de datos$")
  public void validaLaInformacionDisponibleDeDatos() {
    theActorInTheSpotlight().attemptsTo(ValidarInformacionDisponibleDatos.validar());
  }

  // ===========================================
  // Apps sin límite de consumo
  // ===========================================

  @And("^regresa atras y selecciona apps sin limite de consumo$")
  public void regresaAtrasYSeleccionaAppsSinLimiteDeConsumo() {
    theActorInTheSpotlight().attemptsTo(ValidarAppsSinLimite.validar());
  }

  @And("^valida la informacion disponible de apps$")
  public void validaLaInformacionDisponibleDeApps() {
    theActorInTheSpotlight().attemptsTo(ValidarAppsSinLimite.validar());
  }

  // ===========================================
  // Consumo de Voz
  // ===========================================

  @And("^regresa atras y selecciona consumo de voz$")
  public void regresaAtrasYSeleccionaConsumoDeVoz() {
    theActorInTheSpotlight().attemptsTo(ValidarConsumoVoz.validar());
  }

  @And("^verifica mensaje aun no registras consumos voz$")
  public void verificaMensajeAunNoRegistrasConsumosVoz() {
    theActorInTheSpotlight().attemptsTo(ValidarConsumoVoz.validar());
  }

  // ===========================================
  // Consumo de SMS
  // ===========================================

  @And("^regresa atras y selecciona consumo de sms$")
  public void regresaAtrasYSeleccionaConsumoDeSMS() {
    theActorInTheSpotlight().attemptsTo(ValidarConsumoSMS.validar());
  }

  @And("^verifica mensaje aun no registras consumos sms$")
  public void verificaMensajeAunNoRegistrasConsumosSMS() {
    theActorInTheSpotlight().attemptsTo(ValidarConsumoSMS.validar());
  }

  // ===========================================
  // Consumo Paquetes y Recargas
  // ===========================================

  @And("^regresa atras y selecciona consumo paquetes y recargas$")
  public void regresaAtrasYSeleccionaConsumoPaquetesYRecargas() {
    theActorInTheSpotlight().attemptsTo(ValidarConsumoPaquetesRecargas.validar());
  }

  @And("^verifica la informacion disponible paquetes recargas$")
  public void verificaLaInformacionDisponiblePaquetesRecargas() {
    theActorInTheSpotlight().attemptsTo(VerificarInformacionPaquetesRecargas.verificar());
  }

  // ===========================================
  // Opción Paquetes
  // ===========================================

  @And("^verifica opcion paquetes$")
  public void verificaOpcionPaquetes() {
    theActorInTheSpotlight().attemptsTo(VerificarOpcionPaquetes.verificar());
  }

  @And("^valida mensaje aun no has adquirido paquetes$")
  public void validaMensajeAunNoHasAdquiridoPaquetes() {
    theActorInTheSpotlight().attemptsTo(ValidarMensajeNoHasAdquiridoPaquetes.validar());
  }

  // ===========================================
  // Opción Recargas
  // ===========================================

  @And("^verifica opcion recargas$")
  public void verificaOpcionRecargas() {
    theActorInTheSpotlight().attemptsTo(VerificarOpcionRecargas.verificar());
  }

  @And("^valida mensaje aun no has hecho recargas$")
  public void validaMensajeAunNoHasHechoRecargas() {
    theActorInTheSpotlight().attemptsTo(ValidarMensajeNoHasHechoRecargas.validar());
  }

  // ===========================================
  // Opción Consumo del mes
  // ===========================================

  @And("^verifica opcion consumo del mes$")
  public void verificaOpcionConsumoDelMes() {
    theActorInTheSpotlight().attemptsTo(VerificarOpcionConsumoDelMes.verificar());
  }

  @Then("^valida mensaje en este mes no registras consumos$")
  public void validaMensajeEnEsteMesNoRegistrasConsumos() {
    theActorInTheSpotlight().attemptsTo(ValidarMensajeNoRegistrasConsumos.validar());
  }
}
