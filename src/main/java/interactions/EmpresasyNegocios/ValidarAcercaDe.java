package interactions.EmpresasyNegocios;

import interactions.Click.ClickTextoQueContengaX;
import interactions.validations.ValidarTexto;
import interactions.validations.ValidarTextoQueContengaX;
import interactions.wait.WaitFor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.PagosYConsultasPage.BTN_TRES_PUNTOS_MAS;
import static utils.Constants.ACERCA_DE;
import static utils.Constants.DECLARACION_SERVICIO;
import static utils.Constants.VER;

    public class ValidarAcercaDe implements Interaction {
        @Override
        public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(
                    Click.on(BTN_TRES_PUNTOS_MAS),
                    ClickTextoQueContengaX.elTextoContiene(ACERCA_DE),
                    WaitFor.aTime(2000),
                    ValidarTexto.validarTexto(DECLARACION_SERVICIO),
                    ValidarTextoQueContengaX.elTextoContiene(VER)
            );
        }
        public static ValidarAcercaDe elMenu() {
            return instrumented(ValidarAcercaDe.class);
        }
    }

