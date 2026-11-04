package interactions.Click;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebElement;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClickForzado implements Interaction {

    private final Target target;

    public ClickForzado(Target target) {
        this.target = target;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Obliga al driver a esperar hasta que el elemento esté presente
        // antes de intentar resolverlo, evitando el NoSuchElementException
        target.resolveFor(actor).waitUntilPresent();

        // Extrae el elemento nativo puro de Selenium/Appium
        WebElement elemento = target.resolveFor(actor).getWrappedElement();
        elemento.click();
    }

    public static ClickForzado sobre(Target target) {
        return instrumented(ClickForzado.class, target);
    }
}