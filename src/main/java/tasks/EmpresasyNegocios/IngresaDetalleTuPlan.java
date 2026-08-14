package tasks.EmpresasyNegocios;
import interactions.Click.ClickTextoQueContengaX;
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
import static userinterfaces.EntretenimientoPage.BTN_VOLVER;
import static userinterfaces.PagosYConsultasPage.BTN_TRES_PUNTOS_MAS;
import static utils.Constants.*;

public class IngresaDetalleTuPlan implements Task {
    private final User user = TestDataProvider.getRealUser();
    private static final String paso1 = "ingresar a detalle de tu plan";
    private static final String paso2 = "ingresar numero al que quieras administrar";
    private static final String paso3 = "validar version miniprogrma";
    private static final String paso4 = "validar Informacion detalle de tu plan";



    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Detalle de"),
                WaitFor.aTime(3000)
        );

        EvidenciaUtils.registrarCaptura(paso1);

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(CONTINUAR),
                WaitFor.aTime(6000)
        );
        EvidenciaUtils.registrarCaptura(paso2);



        actor.attemptsTo(
                WaitFor.aTime(1000),
                Click.on(BTN_TRES_PUNTOS_MAS),
                ClickTextoQueContengaX.elTextoContiene(ACERCA_DE),
                WaitFor.aTime(1000),
                ValidarTexto.validarTexto("Detalle de tu plan empresas"),
                ValidarTexto.validarTexto(DECLARACION_SERVICIO),
                ValidarTextoQueContengaX.elTextoContiene(VER)
        );
        EvidenciaUtils.registrarCaptura(paso3);

        actor.attemptsTo(Click.on(BTN_VOLVER),
                WaitFor.aTime(1000)
                );


        actor.attemptsTo(
                WaitUntil.the(LOADING_SPLASH, isNotPresent()),
                ClickTextoQueContengaX.elTextoContiene(CONTINUAR),
                WaitFor.aTime(3000)
        );
        actor.attemptsTo(
                WaitUntil.the(LOADING_SPLASH, isNotPresent()),
                ValidarTextoQueContengaX.elTextoContiene("Detalle de tu plan"),
                ValidarTextoQueContengaX.elTextoContiene("322 691 8354"),
                ValidarTextoQueContengaX.elTextoContiene("Explora tus servicios")

        );
        EvidenciaUtils.registrarCaptura(paso4);



    }
    public static Performable ingresaDetalleTuPlan() {
        return instrumented(IngresaDetalleTuPlan.class);
    }

}

