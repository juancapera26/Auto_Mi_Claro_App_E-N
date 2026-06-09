package stepDefinitions;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import tasks.Entretenimiento.*;
import tasks.Entretenimiento.RutasDeAcceso.*;
import tasks.Entretenimiento.ValidarMiniVersionesEntretenimientoPospago.*;
import tasks.Entretenimiento.ValidarMiniVersionesEntretenimientoPrepago.*;
import tasks.Entretenimiento.ValidarRedirecciones.*;
import tasks.Entretenimiento.ValidarTC.*;

/**
 * Step Definitions para el módulo Entretenimiento Mantiene la consistencia con el estilo existente
 * del proyecto
 */
public class EntretenimientoDefinitions {

  // ===========================================
  // Generales
  // ===========================================

  @When("^selecciona el boton entretenimiento en la barra inferior$")
  public void seleccionaBotonEntretenimiento() {
    theActorInTheSpotlight().attemptsTo(AccederEntretenimiento.acceder());
  }

  @When("^selecciona el boton ver mas en seccion tus servcicos favoritos$")
  public void seleccionaVerMasEnTusServiciosFavoritos() {
    theActorInTheSpotlight().attemptsTo(AccederVerMasTusServiciosFavoritos.acceder());
  }

  @Then("^valida redireccionamiento id claro$")
  public void validaRedireccionamientoIdClaro() {
    theActorInTheSpotlight().attemptsTo(ValidaRedireccionamientoIdClaro.validar());
  }
  @Then("^valida redireccionamiento id claro gaming cloud$")
  public void validaRedireccionamientoIdClaroGamingCloud() {
    theActorInTheSpotlight().attemptsTo(validaRedireccionamientoIdClaroGamingCloud.validar());
  }

  @And("^valida version de miniprograma pre claro video$")
  public void validaVersionMiniProgramaClaroVideoPre() {
    theActorInTheSpotlight().attemptsTo(ValidarVersionMiniProgramaClaroVideoPre.validar());
  }

  @And("^valida version de miniprograma pre claro musica$")
  public void validaVersionMiniProgramaClaroMusicaPre() {
    theActorInTheSpotlight().attemptsTo(ValidarVersionMiniProgramaClaroMusicaPre.validar());
  }

  @And("^valida version de miniprograma pre claro club$")
  public void validaVersionMiniProgramaClaroClubPre() {
    theActorInTheSpotlight().attemptsTo(ValidarVersionMiniProgramaClaroClubPre.validar());
  }

  /*@And("^valida redireccion a entretenimiento$")
  public void validaRedireccionEntretenimiento() {
      theActorInTheSpotlight().attemptsTo(
              ValidarRedireccionEntretenimiento.validar()
      );
  }*/

  // ===========================================
  // SA059 - Claro Video
  // ===========================================

  @And("^selecciona el boton claro video$")
  public void seleccionaBotonClaroVideo() {
    theActorInTheSpotlight().attemptsTo(SeleccionarClaroVideo.seleccionar());
  }

  @And("^valida version de miniprograma claro video$")
  public void validaVersionMiniProgramaClaroVideo() {
    theActorInTheSpotlight().attemptsTo(ValidarVersionMiniProgramaClaroVideo.validar());
  }

  @Then("^valida redireccion app store claro video$")
  public void ValidarRedireccionAppStoreClaroVideo() {
    theActorInTheSpotlight().attemptsTo(ValidarRedireccionPlayStoreClaroVideo.validar());
  }

  // ===========================================
  // SA070 - Claro Club
  // ===========================================
  @And("^selecciona el boton cupones en explora y compra$")
  public void seleccionaBotonClaroClubEnExploraYCompra() {
    theActorInTheSpotlight().attemptsTo(SeleccionarClaroClubEnExploraYCompra.seleccionar());
  }

  @And("^selecciona el boton claro club$")
  public void seleccionaBotonClaroClub() {
    theActorInTheSpotlight().attemptsTo(SeleccionarClaroClub.seleccionar());
  }

  @And("^valida version de miniprograma claro club$")
  public void validaVersionMiniProgramaClaroClub() {
    theActorInTheSpotlight().attemptsTo(ValidarVersionMiniProgramaClaroClub.validar());
  }

  @Then("^valida redireccion claro club$")
  public void ValidarRedireccionClaroClub() {
    theActorInTheSpotlight().attemptsTo(ValidarRedireccionClaroClub.validar());
  }

  // ===========================================
  // SA059 - Claro Musica
  // ===========================================

  @And("^selecciona el boton claro musica$")
  public void seleccionaBotonClaroMusica() {
    theActorInTheSpotlight().attemptsTo(SeleccionarClaroMusica.seleccionar());
  }

  @And("^valida version de miniprograma claro musica$")
  public void validaVersionMiniProgramaClaroMusica() {
    theActorInTheSpotlight().attemptsTo(ValidarVersionMiniProgramaClaroMusica.validar());
  }

  @Then("^valida redireccion claro musica app$")
  public void ValidarRedireccionClaroMusicaApp() {
    theActorInTheSpotlight().attemptsTo(ValidarRedireccionClaroMusicaApp.validar());
  }



  // ===========================================
  // @EN004 - HBOmax
  // ===========================================

  // ===========================================
  // SA063 - Netflix
  // ===========================================

  @And("^selecciona boton netflix$")
  public void seleccionaBotonNetflix() {
    theActorInTheSpotlight().attemptsTo(SeleccionarNetflix.seleccionar());
  }

  @And("valida version de miniprograma netflix")
  public void validaRedireccionamientoNetflix() {
    theActorInTheSpotlight().attemptsTo(ValidarVersionMiniProgramaNetflix.validar());
  }

  @Then("^valida terminos y condiciones netflix$")
  public void validaTerminosYCondicionesNetflix() {
    theActorInTheSpotlight().attemptsTo(ValidarTerminosCondicionesNetflix.validar());
  }

  // ===========================================
  // SA066 - Disney+ Plan Estándar
  // ===========================================

  @And("^selecciona boton disney plus$")
  public void seleccionaBotonDisneyPlus() {
    theActorInTheSpotlight().attemptsTo(SeleccionarDisneyPlus.seleccionar());
  }

  @And("^validar version de miniprograma disney$")
  public void validarVersionDeMiniprogramaDisney() {
    theActorInTheSpotlight().attemptsTo(ValidarVersionMiniprogramaDisney.validar());
  }

  @And("^selecciona plan estandar disney$")
  public void seleccionaPlanEstandarDisney() {
    theActorInTheSpotlight().attemptsTo(SeleccionaPlanEstandarDisney.seleccionar());
  }

  @And("^selecciona plan premium disney$")
  public void seleccionaPlanPremiumDisney() {
    theActorInTheSpotlight().attemptsTo(SeleccionarPlanPremiumDisney.seleccionar());
  }

  @Then("^valida terminos y condiciones disney estandar$")
  public void validaTerminosYCondicionesDisneyEstandar() {
    theActorInTheSpotlight().attemptsTo(ValidarTerminosCondicionesDisneyEstandar.validar());
  }


  @Then("^valida terminos y condiciones disney premium$")
  public void validaTerminosYCondicionesDisneyPremium() {
    theActorInTheSpotlight().attemptsTo(ValidarTerminosCondicionesDisneyPremium.validar());
  }

  // ===========================================
  // SA069 - Amazon Prime
  // ===========================================

  @And("^selecciona boton amazon prime$")
  public void seleccionaBotonAmazonPrime() {
    theActorInTheSpotlight().attemptsTo(SeleccionarAmazonPrime.seleccionar());
  }

  @And("^validar version de miniprograma amazonprime$")
  public void validarVersionDeMiniProgramaAmazonPrime() {
    theActorInTheSpotlight().attemptsTo(ValidarVersionMiniProgramaAmazonPrime.validar());
  }

  @And("^selecciona plan amazon prime$")
  public void seleccionaPlanAmazonPrime() {
    theActorInTheSpotlight().attemptsTo(SeleccionarPlanAmazonPrime.seleccionar());
  }

  @Then("^valida terminos y condiciones amazon prime$")
  public void validaTerminosYCondicionesAmazonPrime() {
    theActorInTheSpotlight().attemptsTo(ValidarTerminosCondicionesAmazonPrime.validar());
  }
  // ===========================================
  // SA060 - RED + TV EN VIVO
  // ===========================================

  @And("^selecciona el boton red plus tv en vivo$")
  public void seleccionaBotonRedPlusTVEnVivo() {
    theActorInTheSpotlight().attemptsTo(SeleccionarRedTVEnVivo.seleccionar());
  }

  @Then("^valida redireccion a red plus tv en vivo$")
  public void validaRedireccionRedPlusTVEnVivo() {
    theActorInTheSpotlight().attemptsTo(ValidarRedireccionRedTV.validar());
  }

  // ===========================================
  // SA061 - RED + NOTICIAS
  // ===========================================

  @And("^desplazarse hasta el modulo tus plataformas favoritas$")
  public void desplazarseHastaModuloTusPlataformasFavoritas() {
    theActorInTheSpotlight().attemptsTo(AccederVerMasPlataformas.acceder());
  }

  @And("^selecciona boton red plus noticias$")
  public void seleccionaBotonRedPlusNoticias() {
    theActorInTheSpotlight().attemptsTo(SeleccionarRedNoticias.seleccionar());
  }
  /*
  @Then("^valida redireccion red plus noticias$")
  public void validaRedireccionRedPlusNoticias() {
      theActorInTheSpotlight().attemptsTo(
              ValidarRedireccionRedNoticias.validar()
      );
  }*/

  // ===========================================
  // SA065 - HBO Max
  // ===========================================

  @And("^selecciona boton hbomax$")
  public void seleccionaBotonHBOmax() {
    theActorInTheSpotlight().attemptsTo(SeleccionarHBOmax.seleccionar());
  }

  @Then("^valida redireccion pagina a hbo max$")
  public void validaRedireccionPaginaAHBOmax() {
    theActorInTheSpotlight().attemptsTo(ValidarRedireccionHBOmax.validar());
  }

  @And("^valida version de miniprograma hbo max$")
  public void validaVersionMiniProgramaHBOmax() {
    theActorInTheSpotlight().attemptsTo(validaVersionMiniProgramaHBOmax.validar());
  }


  // ===========================================
  // SA068 - HotGo
  // ===========================================

  @And("^selecciona boton hotgo$")
  public void seleccionaBotonHotGo() {
    theActorInTheSpotlight().attemptsTo(SeleccionarHotGo.seleccionar());
  }

  @Then("^valida redireccion a pagina hotgo$")
  public void validaRedireccionAPaginaHotGo() {
    theActorInTheSpotlight().attemptsTo(ValidarRedireccionHotGo.validar());
  }
  @And("^validar version de miniprograma hotgo$")
  public void validarVersionDeMiniprogramaHotgo() {
    theActorInTheSpotlight().attemptsTo(validarVersionDeMiniprogramaHotgo.validar());
  }
  @And("^selecciona plan hotgo$")
  public void seleccionaPlanHotGo() {
    theActorInTheSpotlight().attemptsTo(seleccionaPlanHotGo.seleccionar());
  }

  @Then("^valida terminos y condiciones hotgo$")
  public void validaTerminosYCondicionesHotGo() {
    theActorInTheSpotlight().attemptsTo(validaTerminosYCondicionesHotGo.validar());
  }

  // ===========================================
// SA069 - Gaming Cloud
// ===========================================
  @And("^selecciona boton gaming cloud$")
  public void seleccionaBotonGamingCloud() {
    theActorInTheSpotlight().attemptsTo(SeleccionarGamingCloud.seleccionar());
  }

  @Then("^valida redireccion a pagina gaming cloud$")
  public void validaRedireccionAPaginaGamingCloud() {
 //   theActorInTheSpotlight().attemptsTo(ValidarRedireccionGamingCloud.validar());
  }
  @And("^validar version de miniprograma gaming cloud$")
  public void validarVersionDeMiniprogramaGamingCloud() {
    theActorInTheSpotlight().attemptsTo(validarVersionDeMiniprogramaGamingCloud.validar());
  }
  @And("^selecciona plan gaming cloud$")
  public void seleccionaPlanGamingCloud() {
    theActorInTheSpotlight().attemptsTo(seleccionaPlanGamingCloud.seleccionar());
  }

  //@Then("^valida terminos y condiciones gaming cloud$")
  //public void validaTerminosYCondicionesGamingCloud() {
   // theActorInTheSpotlight().attemptsTo(validaTerminosYCondicionesGamingCloud.validar());
  //}

  // ===========================================
// SA069 - WIN PlAY
// ===========================================
  @And("^selecciona boton win play$")
  public void seleccionaBotonWinPlay() {
    theActorInTheSpotlight().attemptsTo(SeleccionarWinPlay.seleccionar());
  }

  @Then("^valida redireccion a pagina win play$")
  public void validaRedireccionAPaginaWinPlay() {
    theActorInTheSpotlight().attemptsTo(ValidarRedireccionWinPlay.validar());
  }
  @And("^validar version de miniprograma win play$")
  public void validarVersionDeMiniprogramaWinPlay() {
    theActorInTheSpotlight().attemptsTo(validarVersionDeMiniprogramaWinPlay.validar());
  }
  @And("^selecciona plan win play$")
  public void seleccionaPlanWinPlay() {
    theActorInTheSpotlight().attemptsTo(seleccionaPlanWinPlay.seleccionar());
  }

  @Then("^valida terminos y condiciones win play$")
  public void validaTerminosYCondicionesWinPlay() {
    theActorInTheSpotlight().attemptsTo(validaTerminosYCondicionesWinPlay.validar());
  }
}




// ===========================================
