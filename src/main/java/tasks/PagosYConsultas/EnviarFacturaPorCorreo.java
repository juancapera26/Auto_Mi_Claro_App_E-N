package tasks.PagosYConsultas;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utils.Constants.*;

import interactions.Click.ClickTextoQueContengaX;
import interactions.Scroll.ScrollHastaTexto;
import interactions.validations.ValidarTexto;
import interactions.validations.ValidarTextoQueContengaX;
import interactions.wait.WaitForResponse;
import models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import utils.EvidenciaUtils;
import utils.TestDataProvider;

public class EnviarFacturaPorCorreo implements Task {
  private final User user = TestDataProvider.getRealUser();
  private static final String paso1 = "Seleccionar Factura por correo electrónico";
  private static final String paso2 = "Verificar numero de cuenta hogar informacion de envio de factura por correo";
  private static final String paso3 = "Validar opciones de envio de factura por correo";

  @Override
  public <T extends Actor> void performAs(T actor) {

    EvidenciaUtils.registrarCaptura(paso1);
    // Seleccionar "Factura por correo electrónico"
    actor.attemptsTo(
        ScrollHastaTexto.conTexto(ULTIMOS_PAGOS),
        ClickTextoQueContengaX.elTextoContiene(FACTURA_POR_CORREO_ELECTRONICO),
        WaitForResponse.withText(HOGAR));

    // Verificar número de celular en pantalla
    actor.attemptsTo(
        ValidarTextoQueContengaX.elTextoContiene(user.getCuentaHogar()),
        ValidarTextoQueContengaX.elTextoContiene(INFORMACION_ENVIO_DE_FACTURA));
    EvidenciaUtils.registrarCaptura(paso2);

    // Verificar campos de información (número cuenta y email y imail secundario)
    actor.attemptsTo(
            ValidarTexto.validarTexto(CORREO_ELECTRONICO_PRINCIPAL),
            ValidarTexto.validarTexto(CORREO_ELECTRONICO_SECUNDARIO),
            ValidarTextoQueContengaX.elTextoContiene(
                    user.getemailSecundario().replace(" ", "")
            )
    );
    EvidenciaUtils.registrarCaptura(paso3);
  }

  public static Performable enviarFacturaPorCorreo() {
    return instrumented(EnviarFacturaPorCorreo.class);
  }
}
