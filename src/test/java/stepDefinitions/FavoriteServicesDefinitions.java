package stepDefinitions;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import models.User;
import net.serenitybdd.screenplay.actions.Click;
import tasks.PagaTuFactura.ClaroPay;
import tasks.PagosYConsultas.DescargaFactura;
import tasks.PagosYConsultas.PagaTuFactura;
import tasks.PagosYConsultas.ingresaAServiciosFavoritosPagaTuFactura;
import utils.TestDataProvider;

public class FavoriteServicesDefinitions {

  private final User user = TestDataProvider.getRealUser();

  @And("^ingresa a tus servicios favoritos paga tu factura$")
  public void ingresaAServiciosFavoritosPagaTuFactura() {
    theActorInTheSpotlight().attemptsTo(
            ingresaAServiciosFavoritosPagaTuFactura.pagaTuFactura()
    );
  }
  @And("^descargar factura$")
  public void DescargarFactura() {
    theActorInTheSpotlight().attemptsTo(
            DescargaFactura.descargarFactura()
    );
  }
}
