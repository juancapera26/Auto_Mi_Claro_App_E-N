package tasks.AtencionClienteSoporte;

import interactions.Click.ClickTextoQueContengaX;
import interactions.Scroll.Scroll;
import interactions.validations.ValidarTextoQueContengaX;
import interactions.wait.WaitFor;
import interactions.wait.WaitForResponse;
import models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import tasks.PagosYConsultas.AdquirirProductos.AdquirirProducto;
import utils.EvidenciaUtils;
import utils.TestDataProvider;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.AtencionClienteSoportePage.*;
import static utils.Constants.*;
import static utils.Constants.CLARO_COLOMBIA_PQR;
import static utils.Constants.VER_DETALLE;

public class DetallePQR implements Task {
    private final User user = TestDataProvider.getRealUser();

    private static final String paso1 = "Ingresar a peticiones, quejas y recuersos";
    private static final String paso2 = "Ingresar datos  ";
    private static final String paso3 = "validar opciones de servicio fijo ";
    private static final String paso4 = "validar datos y continuar ";



    @Override
    public <T extends Actor> void performAs(T actor) {



        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(CONSULTAR_PQR),
                WaitForResponse.withText(HOGAR)
        );

        EvidenciaUtils.registrarCaptura("Seleccionar línea y ver detalle - PQR");

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(HOGAR)
        );

        ValidarTextoQueContengaX.elTextoContiene(CUENTA + " " + user.getCuentaHogar() + " " + VER_DETALLE);

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(user.getCuentaHogar()),
                WaitForResponse.withText(CLARO_COLOMBIA_PQR)
        );
        EvidenciaUtils.registrarCaptura(paso1);
        actor.attemptsTo(
                Click.on(LST_TIPO_DOCUMENTO),
                ClickTextoQueContengaX.elTextoContiene("CÉDULA DE CIUDADANÍA"),
                Click.on(NUM_DOCUMENTO),
                Enter.theValue(user.getCedula()).into(NUM_DOCUMENTO),
                Scroll.scrollUnaVista(),
                ClickTextoQueContengaX.elTextoContiene("Conocer el estado de su petición, queja")
        );

        EvidenciaUtils.registrarCaptura(paso2);
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Radicar una petición y/o queja"),
                ClickTextoQueContengaX.elTextoContiene("Servicio Fijo"),
                Click.on(TIPO_DE_SERVICIO)
        );
        EvidenciaUtils.registrarCaptura(paso3);
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Internet Hogar")


        );
        EvidenciaUtils.registrarCaptura(paso4);

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Continuar"),
                WaitFor.aTime(5000),
                ValidarTextoQueContengaX.elTextoContiene("Datos Solicitud")
        );

    }
    public static DetallePQR detallePQR() {
        return instrumented(DetallePQR.class);
    }
}

