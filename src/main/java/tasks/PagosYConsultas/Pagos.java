package tasks.PagosYConsultas;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.PagosYConsultasPage.BTN_BACK_TO_HOME;
import static userinterfaces.PagosYConsultasPage.BTN_TRES_PUNTOS_MAS;
import static utils.Constants.*;

import interactions.Click.ClickElementByText;
import interactions.Click.ClickTextoQueContengaX;
import interactions.Scroll.Scroll;
import interactions.comunes.Atras;
import interactions.validations.ValidarTexto;
import interactions.validations.ValidarTextoQueContengaX;
import interactions.wait.WaitForResponse;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import utils.EvidenciaUtils;

public class Pagos implements Task {

  private static final String paso1 = "Hacer clic en Pagos";
  private static final String paso2 = "Verificar versión de miniprograma";
  private static final String paso3 = "Verificar opciones disponibles";;
  private static final String paso4 = "Validar Cuenta hogar y direccionamiento portal pagos Claro";

  @Override
  public <T extends Actor> void performAs(T actor) {

    // 1. Hacer scroll hasta encontrar Pagos y hacer clic
    actor.attemptsTo(
            Scroll.scrollUnaVista(),
            ClickTextoQueContengaX.elTextoContiene(PAGOS),
            WaitForResponse.withText(QUE_QUIERES_PAGAR),
            ValidarTextoQueContengaX.elTextoContiene("Cuenta Hogar")
    );

    EvidenciaUtils.registrarCaptura(paso1);

    // 2. Verificar versión de miniprograma
    actor.attemptsTo(
            Click.on(BTN_TRES_PUNTOS_MAS),
            ClickTextoQueContengaX.elTextoContiene(ACERCA_DE),
            WaitForResponse.withText(DECLARACION_SERVICIO),
            ValidarTexto.validarTexto(PAGOS),
            ValidarTexto.validarTexto(DECLARACION_SERVICIO),
            ValidarTextoQueContengaX.elTextoContiene(VER));

    EvidenciaUtils.registrarCaptura(paso2);

    actor.attemptsTo(Atras.irAtras());

    // 3. Verificar opciones disponibles

    actor.attemptsTo(
            ValidarTextoQueContengaX.elTextoContiene(SELECCIONA_EL_TIPO_DE_SERVICIO),
            ValidarTexto.validarTexto(LINEA_POSTPAGO),
            ValidarTexto.validarTexto(CUENTA_HOGAR_PAGOS),
            ValidarTexto.validarTexto(DEUDAS_EN_MORA));

    EvidenciaUtils.registrarCaptura(paso3);


    // 5. Validar Cuenta hogar
    actor.attemptsTo(
            ClickTextoQueContengaX.elTextoContiene(CUENTA_HOGAR_PAGOS),
            WaitForResponse.withText(PERSONAS),
            ValidarTexto.validarTexto(PAGO_DE_FACTURAS),
            Scroll.scrollUnaVista(),
            ValidarTexto.validarTexto(HOGAR_MULTIPAY));

    EvidenciaUtils.registrarCaptura(paso4);

  }

  public static Performable validarDireccionamiento() {
    return instrumented(Pagos.class);
  }
}
