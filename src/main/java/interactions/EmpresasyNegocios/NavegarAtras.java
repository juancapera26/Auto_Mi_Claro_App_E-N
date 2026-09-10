package interactions.EmpresasyNegocios;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class NavegarAtras implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        BrowseTheWeb.as(actor).getDriver().navigate().back();
    }
    public static NavegarAtras enElDispositivo() {
        return instrumented(NavegarAtras.class);
    }
}
