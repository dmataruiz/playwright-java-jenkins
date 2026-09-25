package PageObjects.SauceDemo;


import com.microsoft.playwright.Page;
import org.testng.Assert;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class PO_LoginSauceDemo {
    private final Page page;

    public PO_LoginSauceDemo(Page page){
        this.page= page;
    }
    public void navigate() {
        page.navigate("https://saucedemo.com");

    }
    public void validatePage(String mensajeEsperado){
        assertThat(page.locator(".login_logo")).containsText(mensajeEsperado);
    }
    public void enterUsername (String username){
        page.locator("#user-name").fill(username);
    }
    public void enterPassword(String password){
        page.locator("#password").fill(password);
    }
    public void clickLogin(){
        page.locator("#login-button").click();
    }
    public void login(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
    public void validarCredencialesIncorrectas(String mensajeError){
        assertThat(page.locator("[data-test='error']")).containsText(mensajeError);

    }

}
