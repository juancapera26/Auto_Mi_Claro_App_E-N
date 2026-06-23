package stepDefinitions;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static utils.Constants.*;

import cucumber.api.java.en.And;
import interactions.Click.ClickTextoQueContengaX;
import interactions.Scroll.Scroll;
import interactions.Scroll.ScrollHastaTexto;
import models.User;
import tasks.EmpresasyNegocios.*;

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

  @And("^validar portafolio de soluciones$")
  public void ValidarPortafolioDeSoluciones() {
    theActorInTheSpotlight().attemptsTo(
            ValidarPortafolioDeSoluciones.validarPortafolioDeSoluciones()
    );
  }
}
