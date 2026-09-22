package PageObjects;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class PO_LoginSauceLabs {

    private final Page page;

    // Constructora
    public PO_LoginSauceLabs(Page page) {
        this.page = page;
    }

    // Navegación
    public void navigate() {
        page.navigate("https://accounts.saucelabs.com/am/XUI/#login/");
    }

    // Acciones / Métodos del Page Object
    public void enterUsername(String username) {
        page.getByPlaceholder("User Name").fill(username);
    }

    public void enterPassword(String password) {
        page.getByPlaceholder("Password").fill(password);
    }

    public void clickLogin() {
        page.locator("input[value='Log in']").click();
    }

    // Método agrupado para el flujo completo de Login
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}