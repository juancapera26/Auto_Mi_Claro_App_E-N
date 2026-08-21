package stepDefinitions;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static utils.Constants.*;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import interactions.Click.ClickTextoQueContengaX;
import interactions.Scroll.Scroll;
import interactions.Scroll.ScrollHastaTexto;
import models.User;
import tasks.EmpresasyNegocios.*;

import tasks.EmpresasyNegocios.pagosFacturas.IngresarPagosFacuras;
import tasks.EmpresasyNegocios.pagosFacturas.ValidarMedioDePagoBancolombia;
import tasks.EmpresasyNegocios.pagosFacturas.ValidarMedioDePagoPSE;
import tasks.EmpresasyNegocios.pagosFacturas.ValidarMedioDePagoTarjetaCreditoDebito;
import utils.EvidenciaUtils;
import utils.TestDataProvider;

public class FavoriteServicesDefinitions {

  private final User user = TestDataProvider.getRealUser();

  @And("^el usuario hace scroll hasta el menú Empresas y negocios$")
  public void menuEmpresasNegocios() {
    final String paso = "El usuario hace scroll hasta el menú Empresas y negocios";
    theActorInTheSpotlight()
            .attemptsTo(
                    ClickTextoQueContengaX.elTextoContiene(VER_MAS),
                    ScrollHastaTexto.conTexto(EMPRESAS_Y_NEGOCIOS),
                    Scroll.scrollUnaVista());

    EvidenciaUtils.registrarCaptura(paso);
  }

  @And("^ingresar a Guia y Novedades$")
  public void ingresarGuiaNovedades() {
    theActorInTheSpotlight().attemptsTo(
            IngresarGuiaNovedades.ingresarGuiaNovedades()
    );
  }
  @And("^ingresa a informacion de tramintes$")
  public void AcederIformacionTramites() {
    theActorInTheSpotlight().attemptsTo(
            AcederIformacionTramites.acederIformacionTramites()
    );
  }
  @And("^validar cession de contrato$")
  public void ValidarCesionDeContrato() {
    theActorInTheSpotlight().attemptsTo(
            ValidarCesionDeContrato.validarCesionDeContrato()
    );

  }
  @And("^validar cambio de plan$")
  public void ValidarCambioDePlan() {
    theActorInTheSpotlight().attemptsTo(
            ValidarCambioDePlan.validarCambioDePlan()
    );
  }
  @And("^validar traslados$")
  public void ValidarTraslados() {
    theActorInTheSpotlight().attemptsTo(
            ValidarTraslados.validarTraslados()
    );

  }
  @And("^validar cambio de SIM card$")
  public void ValidarCambioDeSimCard() {
    theActorInTheSpotlight().attemptsTo(
            ValidarCambioDeSimCard.validarCambioDeSimCard()
    );
  }
  @And("^ingresar a otras fucionalidades$")
  public void IngresarOtrasFucionalidades() {
    theActorInTheSpotlight().attemptsTo(
            IngresarOtrasFucionalidades.ingresarOtrasFucionalidades()
    );
  }

  @And("^ingresar a soluciones moviles$")
  public void IngresarSolucionesMoviles() {
    theActorInTheSpotlight().attemptsTo(
            IngresarSolucionesMoviles.ingresarSolucionesMoviles()
    );
  }
//////////////////////////////////////////
  @And("^ingresar a pagos y facturas$")
  public void IngresarPagosFacuras() {
    theActorInTheSpotlight().attemptsTo(
            IngresarPagosFacuras.ingresarPagosFacuras()
    );
  }
  @And("^validar ingreso a Administar perfiles Empresas$")
  public void ValidarAdministrarPerfilEmpreas() {
    theActorInTheSpotlight().attemptsTo(
            ValidarAdministrarPerfilEmpreas.validarAdministrarPerfilEmpreas()
    );
  }

  @And("^ingresa a Roaming internacional$")
  public void IngresaRoaminginternacional() {
    theActorInTheSpotlight().attemptsTo(
            IngresaRoaminginternacional.ingresaRoaminginternacional()
    );
  }

  @Then("^ingresa a Consulta tu plan EYP$")
  public void IngresaDetalleTuPlanEYP() {
    theActorInTheSpotlight().attemptsTo(
            IngresaDetalleTuPlanEYP.ingresaDetalleTuPlanEYP()
    );
  }
  @And("^ingresa a detalle de tu plan$")
  public void IngresaDetalleTuPlan() {
    theActorInTheSpotlight().attemptsTo(
            IngresaDetalleTuPlan.ingresaDetalleTuPlan()
    );
  }
  @And("^ingresa a administra tu factura$")
  public void IngresadministraTuFactura() {
    theActorInTheSpotlight().attemptsTo(
            IngresadministraTuFactura.ingresadministraTuFactura()
    );
  }
  @And("^ingresa a Pagos en linea Soluciones moviles")
  public void IngresarPagosLineaSolucionesMovlies() {
    theActorInTheSpotlight().attemptsTo(
            IngresarPagosLineaSolucionesMovlies.ingresarPagosLineaSolucionesMovlies()
    );
  }
  @And("^ingresa a Pagos en linea Soluciones Fijas HFC")
  public void IngresarPagosLineaSolucionesFiHFC() {
    theActorInTheSpotlight().attemptsTo(
            IngresarPagosLineaSolucionesFiHFC.ingresarPagosLineaSolucionesFiHFC()
    );
  }
  @And("^ingresa a Pagos en linea Soluciones Fijas FO")
  public void IngresarPagosLineaSolucionesFO() {
    theActorInTheSpotlight().attemptsTo(
            IngresarPagosLineaSolucionesFO.ingresarPagosLineaSolucionesFO()
    );
  }
  @And("^Validar medio de pago PSE$")
  public void ValidarMedioDePagoPSE() {
    theActorInTheSpotlight().attemptsTo(
            ValidarMedioDePagoPSE.validarMedioDePagoPSE()
    );
  }

  @And("^Validar medio de pago Tarjeta de Crédito - Débito$")
  public void ValidarMedioDePagoTarjetaCreditoDebito() {
    theActorInTheSpotlight().attemptsTo(
            ValidarMedioDePagoTarjetaCreditoDebito.validarMedioDePagoTarjetaCreditoDebito()
    );
  }

  @And("^Validar medio de pago Bancolombia$")
  public void ValidarMedioDePagoBancolombia() {
    theActorInTheSpotlight().attemptsTo(
            ValidarMedioDePagoBancolombia.validarMedioDePagoBancolombia()
    );
  }
  @And("^ingresa a Consultar tus consumos$")
  public void IngresaConsultarConsumos() {
    theActorInTheSpotlight().attemptsTo(
            IngresaConsultarConsumos.ingresaConsultarConsumos()
    );
  }
  @And("^ingresa a Cambio de SIM Card$")
  public void IngresaCambioSIMcard() {
    theActorInTheSpotlight().attemptsTo(
            IngresaCambioSIMcard.ingresaCambioSIMcard()
    );
  }@And("^ingresa a Activa eSIM Empresas$")
  public void IngresaActivareSIMempresas() {
    theActorInTheSpotlight().attemptsTo(
            IngresaActivareSIMempresas.ingresaActivareSIMempresas()
    );
  }/*@And("^ingresa a Win Play$")
  public void IngresaWinPlay(){
    theActorInTheSpotlight().attemptsTo(
            IngresaWinPlay
    );
  }*/
}
