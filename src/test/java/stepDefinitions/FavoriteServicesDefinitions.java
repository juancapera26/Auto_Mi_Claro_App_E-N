package stepDefinitions;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import models.User;
import net.serenitybdd.screenplay.actions.Click;
import tasks.PagaTuFactura.ClaroPay;
import tasks.PagosYConsultas.PagaTuFactura;
import utils.TestDataProvider;

public class FavoriteServicesDefinitions {

  private final User user = TestDataProvider.getRealUser();

  @And("^INGRESA A TUS SERVICIOS FAVORITOS PAGA TU FACTURA$")
  public void ingresaAServiciosFavoritosPagaTuFactura() {
    theActorInTheSpotlight().attemptsTo(
            PagaTuFactura.pagaTuFactura()
    );
  }
}
