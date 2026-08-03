package interactions.validations;

import io.appium.java_client.AppiumDriver;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ObtenerOtp {

    public static String obtener(Actor actor) {

        WebDriver webDriver = BrowseTheWeb.as(actor).getDriver();

        AppiumDriver driver =
                (AppiumDriver) ((WebDriverFacade) webDriver)
                        .getProxiedDriver();

        // Abrir Google Messages
        driver.activateApp("com.google.android.apps.messaging");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Obtener todos los mensajes que contienen OTP
        List<WebElement> mensajes = driver.findElements(
                By.xpath("//android.widget.TextView[contains(@text,'tu pin de autenticacion es')]")
        );

        if (mensajes.isEmpty()) {
            throw new RuntimeException("No se encontró ningún mensaje OTP");
        }

        // Mostrar mensajes encontrados
        for (int i = 0; i < mensajes.size(); i++) {
            System.out.println("SMS [" + i + "]: " + mensajes.get(i).getText());
        }

        // El primer mensaje es el más reciente en Google Messages (OPPO)
        String mensaje = mensajes.get(0).getText();

        System.out.println("Mensaje seleccionado: " + mensaje);

        // Extraer OTP
        Pattern pattern = Pattern.compile(
                "tu pin de autenticacion es:\\s*(\\d{6})",
                Pattern.CASE_INSENSITIVE
        );

        Matcher matcher = pattern.matcher(mensaje);

        if (!matcher.find()) {
            throw new RuntimeException("No fue posible extraer el OTP del mensaje");
        }

        String otp = matcher.group(1);

        System.out.println("OTP encontrado: " + otp);

        // Regresar a Mi Claro
        driver.activateApp("com.clarocolombia.miclaro");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return otp;
    }
}