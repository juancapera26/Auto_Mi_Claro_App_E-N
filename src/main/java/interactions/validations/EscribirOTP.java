package interactions.validations;

import io.appium.java_client.AppiumDriver;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.webdriver.WebDriverFacade;

public class EscribirOTP {

    public static Performable con(String otp) {

        return Task.where("Ingresar código OTP",
                actor -> {

                    WebDriverFacade facade =
                            (WebDriverFacade) BrowseTheWeb.as(actor).getDriver();

                    AppiumDriver<?> driver =
                            (AppiumDriver<?>) facade.getProxiedDriver();

                    for (char numero : otp.toCharArray()) {

                        driver.getKeyboard()
                                .sendKeys(String.valueOf(numero));

                        try {
                            Thread.sleep(300);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
        );
    }
}