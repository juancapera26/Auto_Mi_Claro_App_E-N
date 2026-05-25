package interactions.wait;

import io.appium.java_client.MobileBy;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUntilText implements Interaction {

    private final String text;
    private static final int DEFAULT_TIMEOUT = 90;

    public WaitUntilText(String text) {
        this.text = text;
    }

    public static WaitUntilText appears(String text) {
        return new WaitUntilText(text);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();

        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);

        By locator = MobileBy.AndroidUIAutomator(
                "new UiSelector().textContains(\"" + text + "\")"
        );

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}