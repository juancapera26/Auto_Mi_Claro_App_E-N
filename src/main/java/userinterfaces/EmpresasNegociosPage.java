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
    public static final Target BTN_CUENTAS_CORREO =
            Target.the("Ingresar a Cuentas de correo")
                    .located(By.xpath("//android.view.View[@resource-id=\"__react-content\"]/android.view.View[6]"));
    public static final Target VER_MAS_SF =
            Target.the("Ingresar a ver mas soluciones fijas")
                    .located(By.xpath("(//android.widget.RelativeLayout[@resource-id=\"com.clarocolombia.miclaro:id/rl_mini_app\"])[8]"));

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
public static final Target SELECIONAR_FACTURA =
            Target.the("Selecionar una factura")
                    .located(By.xpath("//android.view.View[@resource-id=\"__react-content\"]/android.view.View/android.view.View/android.view.View[2]/android.widget.CheckBox/android.widget.CheckBox"));
public static final Target SELECIONAR_FACTURA_FIJAS_HFC =
            Target.the("Selecionar una factura")
                    .located(By.xpath("//android.view.View[@resource-id=\"__react-content\"]/android.view.View/android.view.View[1]/android.widget.CheckBox/android.widget.CheckBox"));
public static final Target SELECIONAR_MEDIOS_DE_PAGO =
            Target.the("Selecionar medios de pagos")
                    .located(By.xpath("//android.view.View[@resource-id=\"select\"]"));
public static final Target SELECIONAR_CAMPO_DE_TEXTO =
            Target.the("Selecionar campo de texto de registro en claro empresas")
                    .located(By.xpath("//android.widget.EditText"));

    public static final Target PERFIL_DE_CONSULTA =
            Target.the("Eliminar ususario")
                    .located(By.xpath("//android.widget.RadioButton[@text=\"Elegir como perfil de consulta\"]/android.widget.TextView"));
    public static final Target EMAIL =
            Target.the("correo")
                    .locatedBy("//*[contains(@text,'{0}')]");
    public static final Target BOTON_ELIMINAR =
            Target.the("Boton eliminar perfil")
                    .locatedBy("//android.view.View[@resource-id=\"__react-content\"]/android.widget.Image[2]");
    public static final Target VALIDAR_PSE =
            Target.the("Validar medio de pago PSE")
                    .locatedBy("//android.view.View[@content-desc=\"confirmacionEmpresasURLConvivenciaParcial\"]/android.widget.TextView");
    public static final Target CAMPO_INGRESO_SERIAL =
            Target.the("ingresar los ultimos 12 digitos del seria de la SIM")
                    .locatedBy("//android.widget.TextView[@text=\"Escribe los números restantes\"]");
//medioos de pago PSE


public static final Target SELECCION_BANCO_PSE =
            Target.the("selecionar banco en medio de pago PSE")
                    .locatedBy("//android.view.View[@resource-id=\"BANCO\"]");
public static final Target SELECCION_CLIENTE_PSE =
            Target.the("selecionar tipo de cliente de pago PSE")
                    .locatedBy("//android.view.View[@resource-id=\"TIPO_CLIENTE\"]");
    public static final Target SELECCION_TIPO_DOCUMENTO_PSE =
            Target.the("selecionar selecionar tipo de documento en medio pago PSE")
                    .locatedBy("//android.view.View[@resource-id=\"TIPO_DOCUMENTO\"]");
    public static final Target ESCRIBIR_DOCUMENTO_PSE =
            Target.the("selecionar y escribir documento en medio pago PSE")
                    .locatedBy("//android.widget.EditText[@resource-id=\"NUMERO_DOCUMENTO\"]");
public static final Target ESCRIBIR_NUMERO_PSE =
            Target.the("selecionar numero telefonico en medio de pago PSE")
                    .locatedBy("//android.widget.EditText[@resource-id=\"TELEFONO\"]");
// ===============================
// MEDIO DE PAGO - TARJETA DE CRÉDITO
// ===============================

    public static final Target ESCRIBIR_NUMERO_TARJETA =
            Target.the("escribir número de la tarjeta de crédito")
                    .locatedBy("//android.widget.EditText[@resource-id=\"NUMERO_TARJETA\"]");

    public static final Target SELECCIONAR_MES_VENCIMIENTO =
            Target.the("seleccionar mes de vencimiento de la tarjeta")
                    .locatedBy("//android.view.View[@resource-id=\"FECHA_VENC_MES\"]");

    public static final Target SELECCIONAR_ANO_VENCIMIENTO =
            Target.the("seleccionar año de vencimiento de la tarjeta")
                    .locatedBy("//android.view.View[@resource-id=\"FECHA_VENC_ANNO\"]");

    public static final Target ESCRIBIR_CODIGO_SEGURIDAD =
            Target.the("escribir código de seguridad de la tarjeta")
                    .locatedBy("//android.widget.EditText[@resource-id=\"CODIGO_SEGURIDAD\"]");

    public static final Target SELECCIONAR_NUMERO_CUOTAS =
            Target.the("seleccionar número de cuotas")
                    .locatedBy("//android.view.View[@resource-id=\"CUOTAS\"]");

    public static final Target NOMBRE_APELLIDO =
            Target.the("seleccionar número de cuotas")
                    .locatedBy("//android.widget.EditText[@resource-id=\"NOMBRE_TARJETA\"]");

    public static final Target ESCRIBIR_NUMERO_TELEFONO =
            Target.the("escribir número telefónico")
                    .locatedBy("//android.widget.EditText[@resource-id=\"TELEFONO\"]");

//Soluciones Moviles

    public static final Target BOTON_CONTINUAR_ESIM =
        Target.the("Boton continuar eSIM")
                .locatedBy("//android.widget.Button[@text=\"Siguiente\"]");

}





