package tasks.EmpresasyNegocios;

import interactions.Click.ClickElementByText;
import interactions.Click.ClickEnCoordenadas;
import interactions.Click.ClickTextoQueContengaX;
import interactions.comunes.Atras;
import interactions.validations.ExisteTexto;
import interactions.validations.ValidarTexto;
import interactions.validations.ValidarTextoQueContengaX;
import interactions.wait.WaitFor;
import models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import utils.EvidenciaUtils;
import utils.TestDataProvider;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static userinterfaces.EntretenimientoPage.BTN_VOLVER;
import static userinterfaces.LoginPage.LOADING_SPLASH;
import static userinterfaces.PagosYConsultasPage.BTN_HOME;
import static userinterfaces.PagosYConsultasPage.BTN_TRES_PUNTOS_MAS;
import static utils.Constants.*;

public class IngresadministraTuFactura implements Task {
    private final User user = TestDataProvider.getRealUser();
    private static final String paso1 = "ingresar a Administra tu factura";
    private static final String paso2 = "validar version miniprogrma";
    private static final String paso3 = "validar Informacion Administra tu factura ";
    private static final String paso4 = "Redireccion a portal de pagos";
    private static final String paso5 = "validar Historial de pagos";
    private static final String paso6 = "validar descaga tu facuta";



    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitFor.aTime(3000),
                ClickTextoQueContengaX.elTextoContiene("Administra factura"),
                WaitFor.aTime(3000)
        );

        EvidenciaUtils.registrarCaptura(paso1);



        actor.attemptsTo(
                WaitFor.aTime(3000),
                Click.on(BTN_TRES_PUNTOS_MAS),
                ClickTextoQueContengaX.elTextoContiene(ACERCA_DE),
                WaitFor.aTime(1000),
                ValidarTexto.validarTexto("Administra tu factura"),
                ValidarTexto.validarTexto(DECLARACION_SERVICIO),
                ValidarTextoQueContengaX.elTextoContiene(VER)

        );
        EvidenciaUtils.registrarCaptura(paso2);

        actor.attemptsTo(Click.on(BTN_VOLVER),
                WaitFor.aTime(7000)
        );


        actor.attemptsTo(
                ValidarTextoQueContengaX.elTextoContiene("Administra tu factura"),
                ValidarTextoQueContengaX.elTextoContiene("6224489807"),
                ValidarTextoQueContengaX.elTextoContiene("Cuenta Maestra"),
                ValidarTextoQueContengaX.elTextoContiene("Fecha de pago oportuno"),
                ValidarTextoQueContengaX.elTextoContiene("Total a pagar")

        );
        EvidenciaUtils.registrarCaptura(paso3);

        if (actor.asksFor(ExisteTexto.con(PAGAR))) {

            actor.attemptsTo(
                    WaitFor.aTime(1000),
                    ClickElementByText.clickElementByText(PAGAR),
                    WaitFor.aTime(5000),
                    ValidarTextoQueContengaX.elTextoContiene("Selecciona el medio de pago"),
                    ValidarTextoQueContengaX.elTextoContiene("Consulta"),
                    Click.on(BTN_HOME),
                    WaitUntil.the(LOADING_SPLASH, isNotPresent())
                    //  ClickEnCoordenadas.en(360, 902),
                    // WaitFor.aTime(2000),
                    // ClickEnCoordenadas.en(351, 847),
                    // WaitFor.aTime(2000)
            );

            EvidenciaUtils.registrarCaptura(paso4);

           /* actor.attemptsTo(
                    ClickEnCoordenadas.en(46, 126)
            );*/
        }

        actor.attemptsTo(
                WaitFor.aTime(5000),
                ClickElementByText.clickElementByText("Historial de pagos"),
                WaitUntil.the(LOADING_SPLASH, isNotPresent()),
                ValidarTextoQueContengaX.elTextoContiene("Histórico de pagos en Línea"),
                ValidarTextoQueContengaX.elTextoContiene("Valor"),
                ValidarTextoQueContengaX.elTextoContiene("Fecha de pago")
        );
        EvidenciaUtils.registrarCaptura(paso5);

        actor.attemptsTo(Click.on(BTN_VOLVER),
                WaitFor.aTime(4000)
        );

        actor.attemptsTo(
                ClickTextoQueContengaX.elTextoContiene("Descarga"),
                WaitFor.aTime(6000),
                ValidarTextoQueContengaX.elTextoContiene("Abrir Documento")
        );
        EvidenciaUtils.registrarCaptura(paso6);
    }
    public static Performable ingresadministraTuFactura() {
        return instrumented(IngresadministraTuFactura.class);
    }

}

