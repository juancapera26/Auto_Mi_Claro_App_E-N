package interactions.Scroll;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import io.appium.java_client.AppiumDriver;
import net.thucydides.core.webdriver.WebDriverFacade;

import java.time.Duration;
import java.util.Collections;

public class ScrollHorizontalText implements Interaction {

    private final Target target;
    private final String texto;

    // Constructor para Target
    public ScrollHorizontalText(Target target) {
        this.target = target;
        this.texto = null;
    }

    // Constructor para String
    public ScrollHorizontalText(String texto) {
        this.target = null;
        this.texto = texto;
    }

    // Usar con Target
    public static ScrollHorizontalText izquierda(Target target) {
        return Tasks.instrumented(
                ScrollHorizontalText.class,
                target
        );
    }

    // Usar con String
    public static ScrollHorizontalText izquierda(String texto) {
        return Tasks.instrumented(
                ScrollHorizontalText.class,
                texto
        );
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();

        AppiumDriver<?> appiumDriver =
                (AppiumDriver<?>) ((WebDriverFacade) driver).getProxiedDriver();

        WebElementFacade elemento;


        // Si viene Target
        if (target != null) {

            elemento = target.resolveFor(actor);

        }
        // Si viene String
        else {

            elemento = Target.the("texto dinámico")
                    .locatedBy("//*[@text='" + texto + "']")
                    .resolveFor(actor);

        }


        Point ubicacion = elemento.getLocation();

        int startX = ubicacion.getX() + elemento.getSize().width - 50;
        int endX = ubicacion.getX() + 50;

        int y = ubicacion.getY() + (elemento.getSize().height / 2);


        PointerInput finger = new PointerInput(
                PointerInput.Kind.TOUCH,
                "finger"
        );

        Sequence swipe = new Sequence(finger, 1);


        swipe.addAction(
                finger.createPointerMove(
                        Duration.ZERO,
                        PointerInput.Origin.viewport(),
                        startX,
                        y
                )
        );

        swipe.addAction(
                finger.createPointerDown(
                        PointerInput.MouseButton.LEFT.asArg()
                )
        );

        swipe.addAction(
                finger.createPointerMove(
                        Duration.ofMillis(600),
                        PointerInput.Origin.viewport(),
                        endX,
                        y
                )
        );

        swipe.addAction(
                finger.createPointerUp(
                        PointerInput.MouseButton.LEFT.asArg()
                )
        );

        appiumDriver.perform(Collections.singletonList(swipe));
    }
}