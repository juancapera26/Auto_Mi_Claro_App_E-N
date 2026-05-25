package interactions.Click;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ClickTextoDebajo implements Interaction {

    private final String textoSuperior;
    private final String textoInferior;

    public ClickTextoDebajo(String textoSuperior, String textoInferior) {
        this.textoSuperior = textoSuperior;
        this.textoInferior = textoInferior;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        WebElement superior = BrowseTheWeb.as(actor)
                .getDriver()
                .findElement(By.xpath("//*[contains(@text,'" + textoSuperior + "')]"));

        int ySuperior = superior.getLocation().getY();

        List<WebElement> elementosInferiores = BrowseTheWeb.as(actor)
                .getDriver()
                .findElements(By.xpath("//*[contains(@text,'" + textoInferior + "')]"));

        for (WebElement elemento : elementosInferiores) {

            int yInferior = elemento.getLocation().getY();

            // valida que esté debajo
            if (yInferior > ySuperior) {
                elemento.click();
                break;
            }
        }
    }

    public static ClickTextoDebajo de(String textoSuperior, String textoInferior) {
        return Tasks.instrumented(
                ClickTextoDebajo.class,
                textoSuperior,
                textoInferior
        );
    }
}