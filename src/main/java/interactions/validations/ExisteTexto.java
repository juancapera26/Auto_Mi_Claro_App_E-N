package interactions.validations;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class ExisteTexto implements Question<Boolean> {

    private final String texto;

    public ExisteTexto(String texto) {
        this.texto = texto;
    }

    public static ExisteTexto con(String texto) {
        return new ExisteTexto(texto);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return !Target.the("texto")
                .locatedBy("//*[contains(@text,'" + texto + "')]")
                .resolveAllFor(actor)
                .isEmpty();
    }
}