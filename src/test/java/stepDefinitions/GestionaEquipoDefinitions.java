package stepDefinitions;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import tasks.GestionaEquipo.*;

/**
 * Step Definitions para el módulo Gestiona tu Equipo Mantiene la consistencia con el estilo
 * existente del proyecto
 */
public class GestionaEquipoDefinitions {

  @And("^ingresa al modulo gestiona tu equipo$")
  public void ingresaModuloGestionaEquipo() {
    theActorInTheSpotlight().attemptsTo(AccederGestionaEquipo.acceder());
  }

  // ===========================================
  // SA020 - Registrar Equipo
  // ===========================================

  @And("^selecciona la opcion registrar equipo$")
  public void seleccionaRegistrarEquipo() {
    theActorInTheSpotlight().attemptsTo(RegistrarEquipo.registrar());
  }

  @And("^selecciona el boton registrar$")
  public void seleccionaBotonRegistrar() {
    theActorInTheSpotlight().attemptsTo(ConfirmarRegistroEquipo.confirmar());
  }

  @Then("^confirma ingreso al registro de equipo$")
  public void confirmaIngresoRegistroEquipo() {
    theActorInTheSpotlight().attemptsTo(RegistrarEquipo.registrar());
  }

  // ===========================================
  // SA021 - Reportar por Robo o Pérdida
  // ===========================================

  @And("^selecciona la opcion reportar por robo o perdida$")
  public void seleccionaReportarRoboPerdida() {
    theActorInTheSpotlight().attemptsTo(ReportarRoboPerdida.reportar());
  }

  @Then("^confirma ingreso a la opcion y valida textos disponibles$")
  public void confirmaIngresoYValidaTextos() {
    theActorInTheSpotlight().attemptsTo(ConfirmarIngresoReporte.confirmar());
  }

  // ===========================================
  // SA022 - Solucionar IMEI Duplicado
  // ===========================================

  @And("^selecciona la opcion solucionar equipo con imei duplicado$")
  public void seleccionaSolucionarIMEIDuplicado() {
    theActorInTheSpotlight().attemptsTo(SolucionarIMEIDuplicado.solucionar());
  }

  @Then("^verifica que se muestren las dos opciones en pantalla$")
  public void verificaOpcionesIMEIDuplicado() {
    theActorInTheSpotlight().attemptsTo(VerificarOpcionesIMEI.verificar());
  }

  // ===========================================
  // SA023 - Reconectar por Robo o Pérdida
  // ===========================================

  @And("^selecciona la opcion reconectar por robo o perdida$")
  public void seleccionaReconectarRoboPerdida() {
    theActorInTheSpotlight().attemptsTo(ReconectarRoboPerdida.reconectar());
  }

  @Then("^valida texto disponible y cierra modal$")
  public void validaTextoYCierraModal() {
    theActorInTheSpotlight().attemptsTo(ValidarTextoYCerrar.validarYCerrar());
  }

  // ===========================================
  // SA024 - Consultar Equipo
  // ===========================================

  @And("^selecciona la opcion consultar equipo$")
  public void seleccionaConsultarEquipo() {
    theActorInTheSpotlight().attemptsTo(ConsultarEquipo.consultar());
  }

  @Then("^verifica informacion disponible del equipo$")
  public void verificaInformacionEquipo() {
    theActorInTheSpotlight().attemptsTo(VerificarInformacionEquipo.verificar());
  }

  // ===========================================
  // SA025 - Actualizar Datos de Equipo
  // ===========================================

  @And("^selecciona la opcion actualizar datos de tu equipo$")
  public void seleccionaActualizarDatos() {
    theActorInTheSpotlight().attemptsTo(ActualizarDatosEquipo.actualizar());
  }

  @Then("^verifica la informacion disponible de equipos$")
  public void verificaInformacionDisponible() {
    theActorInTheSpotlight().attemptsTo(VerificarInformacionDisponible.verificar());
  }
}
