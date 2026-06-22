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
                    .located(By.xpath("//android.view.View[@resource-id=\"1\"]/android.widget.Image"));
    public static final Target SCROLL_SELECIONAR_ANUNCIO =
            Target.the("Scroll Ingresar a anuncios y validar redireccion")
                    .located(By.xpath("//android.view.View[@resource-id=\"__react-content\"]/android.widget.Button[2]"));
public static final Target VER_PUNTOS_ATENCION =
            Target.the("Scroll Ingresar a anuncios y validar redireccion")
                    .located(By.xpath("//android.widget.TextView[@text=\"1. Cámara de comercio original y vigente no mayor a 30 días.\"]"));


}





