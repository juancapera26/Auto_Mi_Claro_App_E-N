package tasks.EmpresasyNegocios;

import interactions.Click.ClickEnCoordenadas;
import interactions.Click.ClickTextoQueContengaX;
import interactions.Scroll.Scroll;
import interactions.Scroll.ScrollHorizontalCoordenadas;
import interactions.validations.ValidarTexto;
import interactions.validations.ValidarTextoQueContengaX;
import interactions.wait.WaitFor;
import models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import utils.EvidenciaUtils;
import utils.TestDataProvider;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.EmpresasNegociosPage.SELECIONAR_FACTURA;
import static userinterfaces.EmpresasNegociosPage.SELECIONAR_MEDIOS_DE_PAGO;
import static userinterfaces.EntretenimientoPage.BTN_VOLVER;
import static userinterfaces.PagosYConsultasPage.BTN_TRES_PUNTOS_MAS;
import static utils.Constants.*;

public class IngresadministraPagos implements Task {
    private final User user = TestDataProvider.getRealUser();
    private static final String paso1 = "ingresar a Administra pagos";
    private static final String paso2 = "ingresar a pagos en línea";
    private static final String paso3 = "selecionar una factura";
    private static final String paso4 = "selecionar pagar";
    private static final String paso5 = "Validar Redirrecion a portal de pagos";
    private static final String paso6 = "validar Medios de pago";



    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Administrar"),
                WaitFor.aTime(3000)
        );

        EvidenciaUtils.registrarCaptura(paso1);

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Pagos en línea"),
                WaitFor.aTime(3000)
        );
        EvidenciaUtils.registrarCaptura(paso2);

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Soluciones Móviles"),
                WaitFor.aTime(2000),
                Click.on(SELECIONAR_FACTURA)
                );

        EvidenciaUtils.registrarCaptura(paso3);

        actor.attemptsTo(
                Scroll.scrollUnaVista(),
                Scroll.scrollUnaVista(),
                WaitFor.aTime(2000)
        );
        EvidenciaUtils.registrarCaptura(paso4);

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Pagar"),
                WaitFor.aTime(3000),
                ValidarTextoQueContengaX.elTextoContiene("Portal Pagos Claro"),
                ScrollHorizontalCoordenadas.desde(339, 200, 339, 1490),
                WaitFor.aTime(2000)
        );
        EvidenciaUtils.registrarCaptura(paso5);

actor.attemptsTo(
        ScrollHorizontalCoordenadas.desde(339, 1490, 339, 200 ),
        Click.on(SELECIONAR_MEDIOS_DE_PAGO),
                WaitFor.aTime(1000)
        );
        EvidenciaUtils.registrarCaptura(paso6);

        actor.attemptsTo(ClickEnCoordenadas.en(46, 126),
                WaitFor.aTime(2000)
        );







        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Pagos en línea"),
                WaitFor.aTime(3000)
        );
        EvidenciaUtils.registrarCaptura(paso2);



    }
    public static Performable ingresadministraPagos() {
        return instrumented(IngresadministraPagos.class);
    }

}