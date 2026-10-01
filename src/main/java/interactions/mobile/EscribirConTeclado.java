package interactions.mobile;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EscribirConTeclado implements Interaction {

    private final String texto;

    public EscribirConTeclado(String texto) {
        this.texto = texto;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        Actions actions = new Actions(driver);

        // Convertimos el texto en un arreglo de caracteres para enviarlo uno por uno
        for (char caracter : texto.toCharArray()) {
            actions.sendKeys(String.valueOf(caracter)).perform();

            // Micro-pausa de 150ms para que la App alcance a registrar cada número
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static EscribirConTeclado nativo(String texto) {
        return instrumented(EscribirConTeclado.class, texto);
    }
}