package interactions.validations;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;
import org.junit.Assert;

public class ValidarElementoVisible implements Interaction {

    private final Target elemento;

    public ValidarElementoVisible(Target elemento) {
        this.elemento = elemento;
    }

    public static ValidarElementoVisible elElemento(Target elemento) {
        return Tasks.instrumented(
                ValidarElementoVisible.class,
                elemento
        );
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        WebElementFacade webElement = elemento.resolveFor(actor);

        Assert.assertTrue(
                "El elemento '" + elemento.getName() + "' no está visible.",
                webElement.isVisible()
        );
    }
}