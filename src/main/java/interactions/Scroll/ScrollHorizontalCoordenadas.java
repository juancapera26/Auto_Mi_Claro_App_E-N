package interactions.Scroll;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import io.appium.java_client.AppiumDriver;

import java.time.Duration;
import java.util.Collections;

public class ScrollHorizontalCoordenadas implements Interaction {

    private final int startX;
    private final int startY;
    private final int endX;
    private final int endY;

    public ScrollHorizontalCoordenadas(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    public static ScrollHorizontalCoordenadas desde(int startX, int startY, int endX, int endY) {
        return Tasks.instrumented(ScrollHorizontalCoordenadas.class,
                startX, startY, endX, endY);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();

        AppiumDriver<?> appiumDriver =
                (AppiumDriver<?>) ((WebDriverFacade) driver).getProxiedDriver();

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence swipe = new Sequence(finger, 1);

        // 👉 inicio del swipe
        swipe.addAction(
                finger.createPointerMove(Duration.ZERO,
                        PointerInput.Origin.viewport(), startX, startY));

        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        // 👉 movimiento hacia la derecha o izquierda
        swipe.addAction(
                finger.createPointerMove(Duration.ofMillis(600),
                        PointerInput.Origin.viewport(), endX, endY));

        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        appiumDriver.perform(Collections.singletonList(swipe));
    }
}