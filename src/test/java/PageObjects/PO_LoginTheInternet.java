package PageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class PO_LoginTheInternet {

    private final Page page;
    private final String flashMessage = "#flash";
    // Constructora
    public PO_LoginTheInternet(Page page) {
        this.page = page;
    }

    // Navegación
    public void navegar() {
        page.navigate("https://the-internet.herokuapp.com/login");
    }

    // Acciones / Métodos del Page Object
    public void enterUsername(String username) {
        page.locator("#username").fill((username));
    }

    public void enterPassword(String password) {
        page.locator("#password").fill(password);
    }

    public void clickLogin() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
    }

    public String obtenerMensajeFlash() {
        return page.locator(flashMessage).innerText();
    }
    public String obtenerUrlActual() {
        return page.url();
    }
    // Método agrupado para el flujo completo de Login
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}