package tasks.EmpresasyNegocios;

import interactions.Click.ClickEnCoordenadas;
import interactions.Click.ClickTextoQueContengaX;
import interactions.Scroll.Scroll;
import interactions.validations.ValidarTexto;
import interactions.validations.ValidarTextoQueContengaX;
import interactions.wait.WaitFor;
import interactions.wait.WaitForResponse;
import models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import utils.EvidenciaUtils;
import utils.TestDataProvider;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.EmpresasNegociosPage.*;
import static userinterfaces.EntretenimientoPage.BTN_VOLVER;
import static userinterfaces.PagosYConsultasPage.BTN_TRES_PUNTOS_MAS;
import static utils.Constants.*;
import static utils.Constants.ACERCA_DE;

public class ValidarCesionDeContrato  implements Task {
    private final User user = TestDataProvider.getRealUser();

    private static final String paso1 = "validar version de miniprograma";
    private static final String paso2 = "ingresar Cesion de contrato";
    private static final String paso3 = "como pudo realizar la cesion de contrato";
    private static final String paso4 = "scroll hasta el link de mi claro";
    private static final String paso5 = "Ingresar a soluciones moviles";
    private static final String paso6 = "Validar informacion de contacto";
    private static final String paso7 = "ver puntos de atencion";

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitFor.aTime(1000),
                Click.on(BTN_TRES_PUNTOS_MAS),
                ClickTextoQueContengaX.elTextoContiene(ACERCA_DE),
                WaitFor.aTime(1000),
                ValidarTexto.validarTexto(INFORMACION_TRAMITE),
                ValidarTexto.validarTexto(DECLARACION_SERVICIO),
                ValidarTextoQueContengaX.elTextoContiene(VER));

        EvidenciaUtils.registrarCaptura(paso1);

        actor.attemptsTo(Click.on(BTN_VOLVER));

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(CESION_CONTRATO));

        EvidenciaUtils.registrarCaptura(paso2);

        actor.attemptsTo(
                ValidarTextoQueContengaX.elTextoContiene("¿Cómo puedo realizar la cesión de contrato?")

        );
        EvidenciaUtils.registrarCaptura(paso3);
        actor.attemptsTo(
                Scroll.scrollUnaVista(),
                Scroll.scrollUnaVista(),
                Scroll.scrollUnaVista()

        );
        EvidenciaUtils.registrarCaptura(paso4);

        actor.attemptsTo(
                WaitFor.aTime(2000)
        );


        actor.attemptsTo(
                Click.on(BTN_VOLVER)
        );

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(SLUCIONES_MOVILES),
                ValidarTextoQueContengaX.elTextoContiene("consultor Comercial")
        );

        EvidenciaUtils.registrarCaptura(paso5);

        actor.attemptsTo(
                Scroll.scrollUnaVista(),
                ValidarTextoQueContengaX.elTextoContiene("Contactopyme.co@claro.com.co")
        );
        EvidenciaUtils.registrarCaptura(paso6);

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(SLUCIONES_FIJAS),
                Click.on(VER_PUNTOS_ATENCION),
                WaitFor.aTime(3000)
        );
        EvidenciaUtils.registrarCaptura(paso7);



    }

    public static Performable validarCesionDeContrato() {
        return instrumented(ValidarCesionDeContrato.class);
    }
}