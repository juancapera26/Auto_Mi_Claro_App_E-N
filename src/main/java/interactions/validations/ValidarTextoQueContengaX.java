package interactions.validations;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import utils.AndroidObject;

public class ValidarTextoQueContengaX extends AndroidObject implements Interaction {

  private final String text;
  private final int segundos;

  // Constructor original
  public ValidarTextoQueContengaX(String text) {
    this.text = text;
    this.segundos = 0;
  }

  // Nuevo constructor con tiempo
  public ValidarTextoQueContengaX(String text, int segundos) {
    this.text = text;
    this.segundos = segundos;
  }

  @Override
  @Step("Valida que el texto '#text' este contenido en otro texto visible.")
  public <T extends Actor> void performAs(T actor) {
    // Ejecuta la espera explícita solo si se configuró un tiempo
    if (segundos > 0) {
      Target objetivo = Target.the("Texto esperado: " + text)
              .located(By.xpath("//*[contains(@text, '" + text + "') or contains(@content-desc, '" + text + "')]"));

      actor.attemptsTo(
              WaitUntil.the(objetivo, net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible()).forNoMoreThan(segundos).seconds()
      );
    }

    // Llamado original a tu método base en AndroidObject
    ElTextoContiene(actor, text);
  }

  // Llamado estándar
  public static Interaction elTextoContiene(String text) {
    return instrumented(ValidarTextoQueContengaX.class, text);
  }

  // Nuevo llamado con espera de tiempo configurable
  public static Interaction porTiempo(String text, int segundos) {
    return instrumented(ValidarTextoQueContengaX.class, text, segundos);
  }
}