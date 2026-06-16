package stepDefinitions;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static utils.Constants.*;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import interactions.Click.ClickTextoQueContengaX;
import interactions.Scroll.Scroll;
import interactions.Scroll.ScrollHastaTexto;
import models.User;
import net.serenitybdd.screenplay.actions.Click;
import tasks.PagaTuFactura.ClaroPay;
import tasks.PagosYConsultas.DescargaFactura;
import tasks.PagosYConsultas.IngresarGuiaNovedades;
import tasks.PagosYConsultas.PagaTuFactura;
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
  @And("^descargar factura$")
  public void DescargarFactura() {
    theActorInTheSpotlight().attemptsTo(
            DescargaFactura.descargarFactura()
    );
  }
}
