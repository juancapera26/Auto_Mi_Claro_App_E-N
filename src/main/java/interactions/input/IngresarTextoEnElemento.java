package interactions.input;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import utils.AndroidObject;

public class IngresarTextoEnElemento extends AndroidObject implements Interaction {

  private final Target target;
  private final String texto;

  public IngresarTextoEnElemento(Target target, String texto) {
    this.target = target;
    this.texto = texto;
  }

  @Override
  @Step("Ingresa '#texto' en '#target'")
  public <T extends Actor> void performAs(T actor) {
    WebElementFacade elemento = target.resolveFor(actor).waitUntilVisible();
    elemento.click();
    elemento.clear();
    elemento.sendKeys(texto);
  }

  public static Interaction ingresar(Target target, String texto) {
    return instrumented(IngresarTextoEnElemento.class, target, texto);
  }
}
