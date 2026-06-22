package stepDefinitions;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static userinterfaces.PagosYConsultasPage.LBL_ELEGIR_OTRO_MEDIO_PAGO;
import static utils.Constants.*;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import hooks.ReportHooks;
import interactions.Click.ClickTextoQueContengaX;
import interactions.Scroll.Scroll;
import interactions.Scroll.ScrollHastaTexto;
import interactions.comunes.Atras;
import interactions.validations.ValidarTexto;
import interactions.validations.ValidarTextoQueContengaX;
import interactions.wait.WaitFor;
import interactions.wait.WaitForResponse;
import java.util.List;
import models.User;
import net.serenitybdd.core.pages.WebElementFacade;
import tasks.PagosYConsultas.*;
import tasks.PagosYConsultas.AdquirirProductos.*;
import tasks.PagosYConsultas.ConfiguracionControlRemoto.*;
import tasks.PagosYConsultas.DetalleDeTuPlan.*;
import tasks.PagosYConsultas.Portabilidad.*;
import tasks.PagosYConsultas.RecargasyPaquetes.*;
import tasks.PagosYConsultas.eSIM.MiniprogramaEsim;
import tasks.PagosYConsultas.eSIM.SeleccionarLineaPostEsim;
import tasks.PagosYConsultas.eSIM.ValidarOpcionesEsim;
import tasks.Prepago.RecargasyPaquetes.SeleccionLineaPrepago;
import utils.EvidenciaUtils;
import utils.TestDataProvider;

public class PagosYConsultasDefinitions {

  private final User user = TestDataProvider.getRealUser();

  @And("^el usuario hace scroll hasta el menú Pagos y consultas$")
  public void menuPagosYConsultas() {
    final String paso = "El usuario hace scroll hasta el menú Pagos y consultas";
    theActorInTheSpotlight()
            .attemptsTo(
                    ClickTextoQueContengaX.elTextoContiene(VER_MAS),
                    ScrollHastaTexto.conTexto(PAGOS_Y_CONSULTAS));
    EvidenciaUtils.registrarCaptura(paso);
  }

//@And("^ingresa al portal de paga tu factura servicios favoritos$")
  //public void portalPagaTuFacturaServiciosFavoritos() {
    //theActorInTheSpotlight().attemptsTo(ingresaAServiciosFavoritosPagaTuFactura.pagaTuFactura());
  //}

  @And("^ingresa al portal de paga tu factura$")
  public void portalPagaTuFactura() {
    theActorInTheSpotlight().attemptsTo(PagaTuFactura.pagaTuFactura());
  }

  @And("^validar redireccion boton pagar factura$")
  public void botonPagarFactura() {
    theActorInTheSpotlight().attemptsTo(RedireccionPagarFactura.redireccionPagarFactura());
  }

  @And("ingresa al portal de recargas y paquetes")
  public void ingresaPortalRecargas() {
    theActorInTheSpotlight()
        .attemptsTo(
            AccesoRecargasYPaquetes.accederRecargasYPaquetes(),
            ValidarInfoRecargas.validarInfoRecargas());

    ReportHooks.setLinea(user.getNumero());
  }

  @And("ingresa al portal de recargas y paquetes en prepago")
  public void ingresaPortalRecargasPrepago() {
    theActorInTheSpotlight()
        .attemptsTo(SeleccionLineaPrepago.seleccionar(), ValidarInfoRecargas.validarInfoRecargas());
  }

  @Then("valida paquetes ldi")
  public void validaPaquetesLDI() {
    theActorInTheSpotlight().attemptsTo(PaquetesLDI.seleccionarPaquetes());
  }

  @Then("valida paquetes de datos")
  public void validaPaquetesDatos() {
    theActorInTheSpotlight().attemptsTo(PaquetesDatos.seleccionarPaquetes());
  }

  @Then("validar redireccion de los medios de pago")
  public void redireccionMediosPago() {
    theActorInTheSpotlight().attemptsTo(RedireccionMedioPago.redireccionarMediosDePago());
  }

  @And("^realiza pago parcial$")
  public void realizaPagoParcial() {
    theActorInTheSpotlight().attemptsTo(RealizarPagoParcial.conLosDatos());
  }

  @Then("^valida la redireccion a medios de pago disponibles$")
  public void redireccionMediosPagoDisponibles() {
    List<WebElementFacade> lblelegirotromediopago =
        LBL_ELEGIR_OTRO_MEDIO_PAGO.resolveAllFor(theActorInTheSpotlight());

    if (!lblelegirotromediopago.isEmpty()) {

      final String paso5 = "Validar redirección a los medios de pago";

      theActorInTheSpotlight()
          .attemptsTo(
              ValidarTexto.validarTexto(ELEGIR_OTRO_MEDIO_PAGO),
              ValidarTextoQueContengaX.elTextoContiene(TARJETA_C_D),
              ValidarTextoQueContengaX.elTextoContiene(BOTON_BANCOLOMBIA),
              // ValidarTextoQueContengaX.elTextoContiene(CODENSA),
              ValidarTextoQueContengaX.elTextoContiene(OTROS_MEDIOS));

      EvidenciaUtils.registrarCaptura(paso5);
    }
  }

  @Then("^valida pagos automaticos$")
  public void validaPagosAutomaticos() {
    theActorInTheSpotlight().attemptsTo(PagosAutomaticos.validarPagosAutomaticos());
  }

  //@Then("^descarga factura$")
  //public void descargaFactura() {
    //theActorInTheSpotlight().attemptsTo(DescargaFactura.descargarFactura());
  //}

  @Then("^envia factura por correo$")
  public void enviaFacturaPorCorreo() {
    theActorInTheSpotlight().attemptsTo(EnviarFacturaPorCorreo.enviarFacturaPorCorreo());
  }

  @Then("^valida detalle ultima facturacion$")
  public void validaDetalleUltimaFacturacion() {
    theActorInTheSpotlight().attemptsTo(DetalleUltimaFacturacion.validarDetalleUltimaFacturacion());
  }

  @Then("^valida historial de pagos$")
  public void validaHistorialDePagos() {
    theActorInTheSpotlight().attemptsTo(HistorialDePagos.validarHistorialDePagos());
  }

  @Then("^selecciona recargas$")
  public void seleccionaRecargas() {
    theActorInTheSpotlight().attemptsTo(Recargas.seleccionarRecargas());
  }

  @Then("^gestiona compras recurrentes$")
  public void gestionaComprasRecurrentes() {
    theActorInTheSpotlight()
        .attemptsTo(GestionarComprasRecurrentes.validarGestionarComprasRecurrentes());
  }

  @Then("^valida detalle de tu plan$")
  public void validaDetalleTuPlan() {
    theActorInTheSpotlight().attemptsTo(DetalleTuPlan.validarDetalleTuPlan());

    ReportHooks.setLinea(user.getNumero());
  }

  @Then("^valida detalle de tu plan para linea que no permite comprar aplicaciones$")
  public void validaDetalleTuPlanLineaNoCompraApp() {
    theActorInTheSpotlight().attemptsTo(DetalleTuPlanCompraApp.validarDetalleTuPlan());
  }

  @And("valida descripcion del plan")
  public void validaDescripcionDelPlan() {
    theActorInTheSpotlight().attemptsTo(ValidarDescripcionDelPlan.validarInformacionDescripcion());
  }

  @And("ingresa ver factura")
  public void ingresaVerFactura() {
    theActorInTheSpotlight().attemptsTo(IngresarVerFactura.ingresarVerFactura());
  }

  @Then("valida direccionamiento pagar factura")
  public void validaDireccionamientoPagarFactura() {
    theActorInTheSpotlight()
        .attemptsTo(ValidarDireccionamientoPagarFactura.validarDireccionamientoPagarFactura());
  }

  @And("ingresa familia y amigos")
  public void ingresaFamiliaYAmigos() {
    theActorInTheSpotlight().attemptsTo(FamiliaYAmigos.ingresarFamiliaYAmigos());
  }

  @And("selecciona linea postpago")
  public void seleccionaLineaPostpago() {
    theActorInTheSpotlight().attemptsTo(SeleccionarLineaPostpago.seleccionarLinea());

    ReportHooks.setLinea(user.getNumero());
  }

  @And("valida direccionamiento familia y amigos")
  public void validaDireccionamientoFamiliaYAmigos() {
    theActorInTheSpotlight().attemptsTo(ValidarFamiliaYAmigos.validarDireccionamiento());
  }

  @And("ingresa opcion familia y amigos")
  public void ingresaOpcionFamiliaYAmigos() {
    theActorInTheSpotlight().attemptsTo(IngresarFamiliaYAmigos.ingresarOpcion());
  }

  @And("valida el grupo de familia y amigos")
  public void validaElGrupoDeFamiliaYAmigos() {
    theActorInTheSpotlight().attemptsTo(GrupoFamiliaYAmigos.validarGrupo());
  }

  @And("regresa atras")
  public void regresaAtras() {
    theActorInTheSpotlight().attemptsTo(Atras.irAtras());
  }

  @And("ingresa opcion elegidos todo destino")
  public void ingresaOpcionElegidosTodoDestino() {
    theActorInTheSpotlight().attemptsTo(ElegidosTodoDestino.ingresarOpcion());
  }

  @And("valida direccionamiento elegidos todo destino")
  public void validaDireccionamientoElegidosTodoDestino() {
    theActorInTheSpotlight().attemptsTo(ValidarElegidosTodoDestino.validarDireccionamiento());
  }

  @Then("ve terminos y condiciones")
  public void veTerminosYCondiciones() {
    theActorInTheSpotlight().attemptsTo(VerTerminosYCondiciones.verTerminos());
  }

  @And("ingresa y valida aplicaciones elegibles")
  public void ingresaYValidaAplicacionesElegibles() {
    theActorInTheSpotlight().attemptsTo(AplicacionesElegibles.ingresarYValidar());
  }

  @And("ingresa y valida comprar aplicaciones")
  public void ingresaYValidaComprarAplicaciones() {
    theActorInTheSpotlight().attemptsTo(ComprarAplicaciones.ingresarYValidar());
  }

  @Then("administra aplicaciones incluidas y valida popup")
  public void administraAplicacionesIncluidasYValidaPopup() {
    theActorInTheSpotlight().attemptsTo(AdministrarAplicacionesIncluidas.administrarYValidar());
  }

  @Then("^validar comprar aplicaciones no permitido$")
  public void validarComprarAplicacionesNoPermitido() {
    theActorInTheSpotlight().attemptsTo(ComprarAplicacionesNoPermitido.ingresarYValidar());
  }

  @And("ingresa mejorar plan")
  public void ingresaMejorarPlan() {
    EvidenciaUtils.registrarCaptura("Ingresar opción Gestionar mi plan - Mejorar plan");

    theActorInTheSpotlight()
        .attemptsTo(
            ClickTextoQueContengaX.elTextoContiene(GESTIONAR_MI_PLAN),
            ClickTextoQueContengaX.elTextoContiene(MEJORAR_PLAN),
            WaitForResponse.withText(VER_PLANES_ESPECIALES));
  }

  @Then("valida direccionamiento mejorar plan")
  public void validaDireccionamientoMejorarPlan() {
    theActorInTheSpotlight().attemptsTo(MejorarPlan.validarDireccionamiento());
  }

  @And("ingresa paquetes adicionales")
  public void ingresaPaquetesAdicionales() {
    EvidenciaUtils.registrarCaptura("Ingresar opción Paquetes adicionales");

    theActorInTheSpotlight()
        .attemptsTo(
            ClickTextoQueContengaX.elTextoContiene(PAQUETES_ADICIONALES), WaitFor.aTime(3000));
  }

  @Then("valida direccionamiento paquetes adicionales")
  public void validaDireccionamientoPaquetesAdicionales() {
    theActorInTheSpotlight().attemptsTo(PaquetesAdicionales.validarDireccionamiento());
  }

  @And("ingresa administrar roaming")
  public void ingresaAdministrarRoaming() {
    theActorInTheSpotlight().attemptsTo(AdministrarRoaming.ingresarRoaming());
  }

  @And("administrar roaming servicio activo")
  public void administrarRoaServActivo() {
    theActorInTheSpotlight().attemptsTo(AdministrarRoamingActivo.ingresarRoaming());
  }

  @Then("valida direccionamiento roaming")
  public void validaDireccionamientoRoaming() {
    theActorInTheSpotlight().attemptsTo(DireccionamientoRoaming.validarDireccionamiento());
  }

  @And("hace clic en adelanta tu saldo")
  public void haceClicEnAdelantaTuSaldo() {
    EvidenciaUtils.registrarCaptura("Hacer clic en Adelanta tu saldo");

    theActorInTheSpotlight()
        .attemptsTo(
            ClickTextoQueContengaX.elTextoContiene(ADELANTA_TU_SALDO),
            WaitForResponse.withText(POSTPAGO));
  }


  @Then("verifica popup adelanto")
  public void verificaPopupAdelanto() {
    theActorInTheSpotlight().attemptsTo(PopupAdelanto.verificarPopup());
  }

  @Then("valida direccionamiento agendar turnos")
  public void validaDireccionamientoAgendarTurnos() {
    theActorInTheSpotlight().attemptsTo(AgendarTurnos.validarDireccionamiento());
  }

  @Then("ingresa a familia y amigos y gestiona numeros")
  public void ingresaAFamiliaYAmigosYGestionaNumeros() {
    theActorInTheSpotlight().attemptsTo(DesactivarFamiliaYAmigos.gestionarFamiliaYAmigos());
  }

  @Then("valida direccionamiento a roaming")
  public void validaDireccionamientoARoaming() {
    theActorInTheSpotlight().attemptsTo(ValidarDireccionamientoARoaming.validarDireccionamiento());
  }

  @And("ingresa a portabilidad")
  public void ingresaAPortabilidad() {
    EvidenciaUtils.registrarCaptura("Hacer clic en Portabilidad");

    theActorInTheSpotlight()
        .attemptsTo(
            ClickTextoQueContengaX.elTextoContiene(PORTABILIDAD),
            WaitForResponse.withText(ESTADO_DE_PORTABILIDAD));
  }

  @And("valida version de miniprograma portabilidad")
  public void validaVersionDeMiniprogramaPortabilidad() {
    theActorInTheSpotlight().attemptsTo(MiniprogramaPortabilidad.validarVersion());
  }

  @Then("valida estado de portabilidad y redireccion")
  public void validaEstadoDePortabilidadYRedireccion() {
    theActorInTheSpotlight().attemptsTo(EstadoPortabilidad.validarEstadoYRedireccion());
  }

  @Then("valida envio de sim card y redireccion")
  public void validaEnvioSimCardYRedireccion() {
    theActorInTheSpotlight().attemptsTo(EnvioSimCard.validarEnvioSimCard());
  }

  @Then("valida portabilidad prepago y redireccion")
  public void validaPortabilidadPrepagoYRedireccion() {
    theActorInTheSpotlight().attemptsTo(PortabilidadPrepago.validarPortabilidadPrepago());
  }

  @Then("valida portabilidad postpago y redireccion")
  public void validaPortabilidadPostpagoYRedireccion() {
    theActorInTheSpotlight().attemptsTo(PortabilidadPostpago.validarPortabilidadPostpago());
  }

  @And("ingresa a adquirir productos")
  public void ingresaAAdquirirProductos() {
    theActorInTheSpotlight().attemptsTo(ScrollHastaTexto.conTexto(ADQUIRIR_PRODUCTOS));

    EvidenciaUtils.registrarCaptura("Hacer clic en Adquirir Productos");

    theActorInTheSpotlight()
        .attemptsTo(
            ClickTextoQueContengaX.elTextoContiene(ADQUIRIR_PRODUCTOS),
            WaitForResponse.withText(POSTPAGO));
  }

  @And("valida version de miniprograma adquirir")
  public void validaVersionDeMiniprogramaAdquirir() {
    theActorInTheSpotlight().attemptsTo(MiniprogramaAdquirirProductos.validarVersion());
  }



  @And("ingresa a esim claro")
  public void ingresaAEsimClaro() {
    theActorInTheSpotlight().attemptsTo(ScrollHastaTexto.conTexto(ESIM_CLARO));

    EvidenciaUtils.registrarCaptura("Hacer clic en eSIM Claro");

    theActorInTheSpotlight()
        .attemptsTo(
            ClickTextoQueContengaX.elTextoContiene(ESIM_CLARO), WaitForResponse.withText(POSTPAGO));
  }

  @Then("ingresar linea postpago esim")
  public void ingresarLineaPostpagoeSIM() {
    theActorInTheSpotlight().attemptsTo(SeleccionarLineaPostEsim.seleccionarLinea());

    ReportHooks.setLinea(user.getNumero());
  }

  @And("presiona boton siguiente")
  public void presionaBotonSiguiente() {
    EvidenciaUtils.registrarCaptura("Boton Siguiente");

    theActorInTheSpotlight().attemptsTo(WaitFor.aTime(5000));

    EvidenciaUtils.registrarCaptura("Hacer clic en boton Continuar");

    theActorInTheSpotlight().attemptsTo(ClickTextoQueContengaX.elTextoContiene(SIGUIENTE));
  }

  @And("valida version de miniprograma esim")
  public void validaVersionDeMiniprogramaEsim() {
    theActorInTheSpotlight().attemptsTo(MiniprogramaEsim.validarVersion());
  }

  @Then("valida direccionamiento opciones esim")
  public void validaDireccionamientoOpcionesEsim() {
    theActorInTheSpotlight().attemptsTo(ValidarOpcionesEsim.validarOpciones());
  }

  @Then("gestiona certificacion cuenta al dia")
  public void gestionaCertificacionCuentaAlDia() {
    theActorInTheSpotlight().attemptsTo(CertificacionCuentaAlDia.gestionarCertificacion());
    ReportHooks.setLinea(user.getNumero());
  }

  @Then("valida direccionamiento vehiculo conectado")
  public void validaDireccionamientoVehiculoConectado() {
    theActorInTheSpotlight().attemptsTo(VehiculoConectado.validarDireccionamiento());
  }

  @Then("valida la redirección a Pagos")
  public void validaDireccionamientoCorrectoPagos() {
    theActorInTheSpotlight().attemptsTo(Pagos.validarDireccionamiento());
  }

  @Then("valida direccionamiento correcto legalizacion")
  public void validaDireccionamientoCorrectoLegalizacion() {
    theActorInTheSpotlight().attemptsTo(LegalizacionLineas.validarDireccionamiento());
  }

  @Then("^valida direccionamiento correcto beneficios$")
  public void validaDireccionamientoCorrectoBeneficios() {
    theActorInTheSpotlight().attemptsTo(Beneficios.validarDireccionamiento());
  }

  @And("^seleccionar linea postpago que permita administrar apps$")
  public void seleccionarLineaPostpagoQuePermitaAdministrarApps() {
    theActorInTheSpotlight().attemptsTo(DetalleTuPlanLineaEspecifica.seleccionarLinea());
  }

  @Then("^administrar y validar aplicaciones incluidas$")
  public void administrarYValidarAplicacionesIncluidas() {
    theActorInTheSpotlight()
        .attemptsTo(AdministrarAplicacionesIncluidasPermitido.administrarYValidar());
  }

  @Then("^administrar y validar aplicaciones no permitido$")
  public void administrarYValidarAplicacionesNoPermitido() {
    theActorInTheSpotlight().attemptsTo(AdministrarAplicacionesNoPermitido.administrarYValidar());
  }

  @And("^valida detalle de tu plan linea especifica$")
  public void validaDetalleDeTuPlanLineaEspecifica() {
    theActorInTheSpotlight()
        .attemptsTo(DetalleTuPlanLineaEspecificaPaquetes.validarDetalleTuPlan());
  }

  @Then("^valida popup no tiene paquetes$")
  public void validaPopupNoTienePaquetes() {
    theActorInTheSpotlight().attemptsTo(PaquetesAdicionalesNoTienePaquetes.validarPopup());
  }

  @Then("valida vigencia y planes roaming")
  public void validaRoamingVigenciaPlanes() {
    theActorInTheSpotlight().attemptsTo(AdministrarRoamingCompleto.validarFlujoCompleto());
  }

  @Then("^valida direccionamiento paquetes complementarios$")
  public void validaDireccionamientoPaquetesComplementarios() {
    theActorInTheSpotlight().attemptsTo(PaquetesComplementarios.validarDireccionamiento());

    ReportHooks.setLinea(user.getNumero());
  }

  @And("ingresar linea postpago servicio familia activo")
  public void ingresarLineaPostpagoServicioActivo() {
    theActorInTheSpotlight()
        .attemptsTo(IngresarLineaPostpagoServicioActivo.ingresarLineaPostpagoServicioActivo());

    ReportHooks.setLinea(user.getNumero());
  }


  @Then("^ingresa a devolución de equipos$")
  public void ingresarDevolucionEquipos() {
    theActorInTheSpotlight()
            .attemptsTo(ingresarDevolucionEquipos.IngresarDevolucionEquipos());
  }
  @Then("^ingresa a solicitar traslado$")
  public void ingresarSolicitarTraslado() {
    theActorInTheSpotlight()
            .attemptsTo(ingresarSolicitarTraslado.IngresarSolicitarTraslado());
  }
  @Then("^ingresa a reiniciar módem$")
  public void ingresarReiniciarModem() {
    theActorInTheSpotlight()
            .attemptsTo(ingresarReiniciarModem.IngresarReiniciarModem());
  }

  @Then("^ingresa a administrar tu red wifi$")
  public void ingresarAdministrarTuRedWifi() {
    theActorInTheSpotlight()
            .attemptsTo(ingresarAdministrarTuRedWifi.IngresarAdministrarTuRedWifi());
  }

  // adquirir porducto

  @And("^ingresa a adquirir producto$")
  public void adquirirProducto() {
    theActorInTheSpotlight()
            .attemptsTo(AdquirirProducto.adquirir());
  }
  @And("^valida el módulo internet$")
  public void validaModuloInternet() {
    theActorInTheSpotlight()
            .attemptsTo(ValidarModuloInternet.validar());
  }

  @And("^valida el módulo televisión$")
  public void validaModuloTelevision() {
    theActorInTheSpotlight()
            .attemptsTo(ValidarModuloTelevision.validar());
  }

  @And("^valida el módulo teléfono$")
  public void validaModuloTelefono() {
    theActorInTheSpotlight()
            .attemptsTo(ValidarModuloTelefono.validar());
  }

  @Then("^valida el módulo ultra wifi$")
  public void validaModuloUltraWifi() {
    theActorInTheSpotlight()
            .attemptsTo(ValidarModuloUltraWifi.validar());
  }
  // configuracion control remoto


  @And("^ingresar a configuracion control remoto$")
  public void validarConfiguracionControlRemoto() {
    theActorInTheSpotlight()
            .attemptsTo(
                    ValidarConfiguracionControlRemoto.validar()
            );
  }@And("^valida informacion configuracion control remoto$")
  public void validarInformacionConfiguracionControlRemoto() {
    theActorInTheSpotlight()
            .attemptsTo(validarInformacionConfiguracionControlRemoto.validar());
  }
  @Then("^compar control remoto$")
  public void comparControlRemoto() {
    theActorInTheSpotlight()
            .attemptsTo(comparControlRemoto.validar());
  }
  @Then("^validar configuraciones de los controles remotos$")
  public void validarConfiguracionesDeLosControlesRemotos() {
    theActorInTheSpotlight()
            .attemptsTo(validarConfiguracionesDeLosControlesRemotos.validar());
  }
  @Then("^validar configuracion del decodificardor$")
  public void validarConfiguracionDelDecodificador() {
    theActorInTheSpotlight()
            .attemptsTo(validarConfiguracionDelDecodificador.validar());
  }

  @Then("^validar certifiacido cuenta al dia$")
  public void validarCertificadoCuentaAlDia() {
    theActorInTheSpotlight()
            .attemptsTo(validarCertificadoCuentaAlDia.validar());
  }





}
