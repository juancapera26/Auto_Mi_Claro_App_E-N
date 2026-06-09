package interactions.Scroll;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;
import utils.AndroidObject;

public class ScrollHastaTexto implements Interaction {

  private final String texto;

  public ScrollHastaTexto(String texto) {
    this.texto = texto;
  }

  public static ScrollHastaTexto conTexto(String texto) {
    return Tasks.instrumented(ScrollHastaTexto.class, texto);
  }

  @Override
  @Step("El usuario hace scroll hasta el texto '#texto'")
  public <T extends Actor> void performAs(T actor) {
    AndroidObject.scrollToText(actor, texto);
  }
}
