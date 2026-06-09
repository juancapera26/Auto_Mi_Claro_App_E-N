package tasks.PagosYConsultas;

import interactions.Click.ClickTextoQueContengaX;
import interactions.Scroll.ScrollHastaTexto;
import interactions.comunes.Atras;
import interactions.validations.ValidarTexto;
import interactions.validations.ValidarTextoQueContengaX;
import interactions.validations.VerificarVersionModulo;
import interactions.wait.WaitFor;
import interactions.wait.WaitForResponse;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import utils.EvidenciaUtils;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.EntretenimientoPage.BTN_VOLVER;
import static userinterfaces.PagosYConsultasPage.BTN_TRES_PUNTOS_MAS;
import static utils.Constants.*;
import static utils.Constants.LOGO_CLARO;
import static utils.ConstantsMiniVersiones.Versiones.MINI_VERSION_DEVOLUCION_DE_EQUIPOS;

public class ingresarDevolucionEquipos implements Task {
    private static final String paso1 = "Hacer clic en Devolución de equipos";
    private static final String paso2 = "Verificar versión de miniprograma";
    private static final String paso3 = "Verificar la redirección al formulario";

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(ScrollHastaTexto.conTexto(DEVOLUCION_EQUIPO2));

        EvidenciaUtils.registrarCaptura(paso1);

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene(DEVOLUCION_EQUIPO2), WaitForResponse.withText(DESEAS_DEVOLVER_EQUIPO));

        actor.attemptsTo(
               Click.on(BTN_TRES_PUNTOS_MAS),
               ClickTextoQueContengaX.elTextoContiene("Acerca de"),
                WaitForResponse.withText("Ver"),
                ValidarTextoQueContengaX.elTextoContiene(DEVOLUCION_EQUIPO2),
                VerificarVersionModulo.conLaEsperada(MINI_VERSION_DEVOLUCION_DE_EQUIPOS),
                ValidarTextoQueContengaX.elTextoContiene(VER));

        EvidenciaUtils.registrarCaptura(paso2);

        actor.attemptsTo(Click.on(BTN_VOLVER));


        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Continuar"),
                WaitFor.aTime(5000)

        );
        EvidenciaUtils.registrarCaptura(paso3);
    }


    public static Performable IngresarDevolucionEquipos() {
        return instrumented(ingresarDevolucionEquipos.class);
    }
}
