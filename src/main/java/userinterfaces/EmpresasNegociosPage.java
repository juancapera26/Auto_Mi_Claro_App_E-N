package userinterfaces;


import io.appium.java_client.MobileBy;
import models.User;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import utils.TestDataProvider;

public class EmpresasNegociosPage {

    public static final Target SELECIONAR_ANUNCIO =
            Target.the("Ingresar a los anuncions y validar redireccion")
                    .located(By.xpath("//android.view.View/android.widget.Image"));

    public static final Target SELECIONAR_ANUNCIO_2 =
            Target.the("Ingresar a los anuncions y validar redireccion")
                    .located(By.xpath("//android.view.View/android.widget.Image"));


}




}
