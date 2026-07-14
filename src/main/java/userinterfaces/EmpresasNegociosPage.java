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
            Target.the("Ingresar a selecionar anuncio ")
                    .located(By.xpath("//android.view.View[@resource-id=\"1\"]/android.widget.Image"));
    public static final Target SCROLL_SELECIONAR_ANUNCIO =
            Target.the("Scroll selecionar anuncio")
                    .located(By.xpath("//android.view.View[@resource-id=\"__react-content\"]/android.widget.Button[2]"));
public static final Target VER_PUNTOS_ATENCION =
            Target.the("ver puntos de atencion")
                    .located(By.xpath("//android.widget.TextView[@text=\"Ver puntos de atención\"]"));

public static final Target MAS_INFORMACION =
            Target.the("mas informacion elige tipo de servicio")
                    .located(By.xpath("//android.view.View[@resource-id=\"__react-content\"]/android.view.View[3]/android.view.View"));

public static final Target MENU_BURGES_EMPRESA =
            Target.the("Menu burges claro empresas")
                    .located(By.xpath("//android.view.View[@resource-id=\"__react-content\"]/android.view.View/android.view.View[1]/android.view.View/android.widget.Image"));


}





