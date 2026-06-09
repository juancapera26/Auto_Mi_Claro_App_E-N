package stepDefinitions;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static userinterfaces.AtencionClienteSoportePage.CHK_AUTORIZAR_MEDICION;
import static utils.Constants.*;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import interactions.Click.ClickTextoQueContengaX;
import interactions.Scroll.Scroll;
import interactions.Scroll.ScrollHastaTexto;
import interactions.validations.ValidarTexto;
import interactions.validations.ValidarTextoQueContengaX;
import models.User;
import net.serenitybdd.screenplay.actions.Click;
import tasks.AtencionClienteSoporte.*;
import tasks.AtencionClienteSoporte.ValidarMiniprogramaAtencionAlClienteYsoporte.ValidarVersionMiniprogramaConsultarPQR;
import tasks.AtencionClienteSoporte.ValidarMiniprogramaAtencionAlClienteYsoporte.ValidarVersionMiniprogramaEstadoServiciosTecnicos;
import tasks.AtencionClienteSoporte.ValidarMiniprogramaAtencionAlClienteYsoporte.ValidarVersionMiniprogramaNecesitasAyuda;
import utils.EvidenciaUtils;
import utils.TestDataProvider;

public class AtencionClienteSoporteDefinitions {

  private final User user = TestDataProvider.getRealUser();

  @And("^desplaza hasta la opcion atencion al cliente y soporte$")
  public void desplazaHastaAtencionClienteSoporte() {
    theActorInTheSpotlight()
        .attemptsTo(ScrollHastaTexto.conTexto(ATENCION_AL_CLIENTE), Scroll.scrollUnaVista());
    EvidenciaUtils.registrarCaptura("Desplazarse hasta Atención al cliente y soporte");
  }

  @And("^ingresa al boton medicion de red$")
  public void ingresaAlBotonMedicionDeRed() {
    theActorInTheSpotlight().attemptsTo(MedicionDeRed.ingresarMedicionRed());
  }

  @And("^verifica el mensaje de autorizacion en pantalla$")
  public void verificaMensajeAutorizacion() {
    theActorInTheSpotlight().attemptsTo(ValidarTexto.validarTexto(AUTORIZO_MEDICION_CALIDAD_RED));
    EvidenciaUtils.registrarCaptura("Verificar mensaje de autorización");
  }

  @And("^acepta la autorizacion de medicion$")
  public void aceptaAutorizacionMedicion() {
    theActorInTheSpotlight().attemptsTo(Click.on(CHK_AUTORIZAR_MEDICION));
  }

  @And("^realiza test de velocidad$")
  public void realizaTestVelocidad() {
    theActorInTheSpotlight()
        .attemptsTo(ClickTextoQueContengaX.elTextoContiene(REALIZAR_TEST_VELOCIDAD));
  }

  @Then("^verifica la informacion en pantalla y maneja condicionales$")
  public void verificaInformacionYManejaCondicionales() {
    theActorInTheSpotlight().attemptsTo(ManejarCondicionalMedicionRed.verificarYManejar());
  }

  @And("^ingresa a la opcion soporte hogar$")
  public void ingresaASoporteHogar() {
    theActorInTheSpotlight().attemptsTo(SoporteHogar.ingresar());
  }

  @Then("^selecciona whatsapp y valida redireccion$")
  public void seleccionaWhatsappYValidaRedireccion() {
    theActorInTheSpotlight().attemptsTo(SoporteHogar.seleccionarWhatsappYValidar());
  }

  @And("^selecciona la opcion ver mas$")
  public void seleccionaLaOpcionVerMas() {
    theActorInTheSpotlight().attemptsTo(ClickTextoQueContengaX.elTextoContiene(VER_MAS));
    EvidenciaUtils.registrarCaptura("Seleccionar opción Ver más");
  }

  @And("^ingresa a la opcion consultar pqr$")
  public void ingresaAConsultarPQR() {
    theActorInTheSpotlight().attemptsTo(ConsultarPQR.ingresar());
  }



  @Then("^verifica redireccion correcta a pagina claro$")
  public void verificaRedireccionAPaginaClaro() {
    theActorInTheSpotlight()
        .attemptsTo(ValidarTextoQueContengaX.elTextoContiene(CLARO_COLOMBIA_PQR));
    EvidenciaUtils.registrarCaptura("Verificar redirección a página Claro");
  }

  @And("^ingresa a la opcion puntos de atencion$")
  public void ingresaAPuntosDeAtencion() {
    theActorInTheSpotlight().attemptsTo(PuntosDeAtencion.ingresar());
  }

  @And("^maneja permisos de ubicacion$")
  public void manejaPermisosUbicacion() {
    theActorInTheSpotlight().attemptsTo(PuntosDeAtencion.manejarPermisosUbicacion());
  }

  @Then("^verifica que este presente el mapa$")
  public void verificaQueEstePresenteElMapa() {
    theActorInTheSpotlight().attemptsTo(PuntosDeAtencion.verificarMapa());
  }

  @And("^selecciona la opcion necesitas ayuda$")
  public void seleccionaLaOpcionNecesitasAyuda() {
    theActorInTheSpotlight().attemptsTo(NecesitasAyuda.ingresar());
  }
  @And("^selecciona la opcion necesitas ayuda hogar$")
  public void seleccionaLaOpcionNecesitasAyudaHogar() {
    theActorInTheSpotlight().attemptsTo(NecesitasAyudaHogar.ingresar());
  }

  @And("^desplaza hasta linea y selecciona ver detalle necesitas ayuda$")
  public void desplazaHastaLineaYSeleccionaVerDetalleNecesitasAyuda() {
    theActorInTheSpotlight().attemptsTo(NecesitasAyuda.seleccionarLineaYVerDetalle());
  }

  @Then("^verifica redireccion a clarobot$")
  public void verificaRedireccionAClarobot() {
    theActorInTheSpotlight().attemptsTo(NecesitasAyuda.verificarRedireccionClarobot());
  }


  @And("^selecciona la opcion estado servicios tecnicos$")
  public void seleccionaLaOpcionEstadoServiciosTecnicos() {
    theActorInTheSpotlight().attemptsTo(EstadoServiciosTecnicos.ingresar());
  }
  @And("^selecciona la opcion visitas tecnicas$")
  public void seleccionaLaOpcionVisitasTecnicas() {
    theActorInTheSpotlight().attemptsTo(VisitasTecnicas.ingresar());
  }


  @And("^desplaza hasta cuenta y selecciona ver detalle servicios tecnicos$")
  public void desplazaHastaCuetaYSeleccionaVerDetalleServiciosTecnicos() {
    theActorInTheSpotlight().attemptsTo(EstadoServiciosTecnicos.ingresar());
  }

  @And("^verifica redireccion ordenes de servicio$")
  public void verificaRedireccionOrdenesDeServicio() {
    theActorInTheSpotlight().attemptsTo(ValidarTexto.validarTexto(ORDENES_DE_SERVICIO));
    EvidenciaUtils.registrarCaptura("Verificar redirección Órdenes de servicio");
  }

  //@And("^consulta por numero de documento$")
  //public void consultaPorNumeroDeDocumento() {
  //  theActorInTheSpotlight().attemptsTo(EstadoServiciosTecnicos.consultarPorNumeroDocumento());
  //}

  //@And("^consulta por numero de celular$")
  //public void consultaPorNumeroDeCelular() {
  // theActorInTheSpotlight().attemptsTo(EstadoServiciosTecnicos.consultarPorNumeroCelular());
  //}

  //@Then("^consulta por imei$")
  // public void consultaPorImei() {
  //theActorInTheSpotlight().attemptsTo(EstadoServiciosTecnicos.consultarPorImei());
  //}

  @And("^valida version de miniprograma necesitas ayuda$")
  public void validaVersionMiniprogramaNecesitasAyuda() {
    theActorInTheSpotlight().attemptsTo(ValidarVersionMiniprogramaNecesitasAyuda.validar());
  }

  @And("^valida version de miniprograma estado servicios tecnicos$")
  public void ValidarVersionMiniprogramaEstadoServiciosTecnicos() {
    theActorInTheSpotlight()
        .attemptsTo(ValidarVersionMiniprogramaEstadoServiciosTecnicos.validar());
  }

  @And("^valida version de miniprograma consultar pqr$")
  public void ValidarVersionMiniprogramaConsultarPQR() {
    theActorInTheSpotlight().attemptsTo(ValidarVersionMiniprogramaConsultarPQR.validar());
  }

  @And("^ver detalle consulta pqr$")
  public void DetallePQR() {
    theActorInTheSpotlight().attemptsTo(DetallePQR.detallePQR());
  }
}
