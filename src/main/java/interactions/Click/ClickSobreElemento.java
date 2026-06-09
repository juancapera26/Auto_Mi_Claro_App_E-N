package interactions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.thucydides.core.annotations.Step;
import net.serenitybdd.screenplay.targets.Target;
import utils.AndroidObject;

public class ClickSobreElemento extends AndroidObject implements Interaction {

  private final Target target;

  public ClickSobreElemento(Target target) {
    this.target = target;
  }

  @Override
  @Step("Hace clic en '#target'")
  public <T extends Actor> void performAs(T actor) {
    WebElementFacade elemento = target.resolveFor(actor).waitUntilVisible();
    elemento.click();
  }

  public static Interaction sobre(Target target) {
    return instrumented(ClickSobreElemento.class, target);
  }
}
