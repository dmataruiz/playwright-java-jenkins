package tests.sauceDemo;

import PageObjects.SauceDemo.PO_CatalogoSauceDemo;
import PageObjects.SauceDemo.PO_LoginSauceDemo;
import com.microsoft.playwright.Page;
import hooks.Hooks;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;

public class Login_SauceDemo {

    private Page page = Hooks.getPage();
    private PO_LoginSauceDemo poLoginSauceDemo = new PO_LoginSauceDemo(page);
    private PO_CatalogoSauceDemo po_catalogoSauceDemo = new PO_CatalogoSauceDemo(page);

    @Dado("que el usuario navega a la página de inicio de sesión")
    public void navegarSauceDemo(){
        poLoginSauceDemo.navigate();
    }
    @Entonces("el titulo del logo deberia mostrar {string}")
    public void validarLoginSauceDemo(String mensajeEsperado){
        poLoginSauceDemo.validatePage(mensajeEsperado);
    }
    @Cuando("el usuario ingresa el nombre de usuario {string}")
    public void introducirUsuario(String user){
        poLoginSauceDemo.enterUsername(user);
    }
    @Y("ingresa la contraseña {string}")
    public void introducirPass(String pass){
        poLoginSauceDemo.enterPassword(pass);
    }
    @Y("hace clic en el botón de iniciar sesión")
    public void clickLogin(){
        poLoginSauceDemo.clickLogin();
    }
    @Entonces("El título de la cabecera debería mostrar {string}")
    public void validarCatalogo(String titulo){
        po_catalogoSauceDemo.validatePage(titulo);
    }
    @Entonces("debería ver un mensaje de error que contiene {string}")
    public void validarCredencialesIncorrectas(String mensajeError){
        poLoginSauceDemo.validarCredencialesIncorrectas(mensajeError);
    }
}
