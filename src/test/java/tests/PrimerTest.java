package tests;

import PageObjects.PO_LoginSauceLabs;
import PageObjects.PO_LoginTheInternet;
import base.BaseTest;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrimerTest extends BaseTest {

    private PO_LoginTheInternet loginPage;

    @BeforeEach
    void initPageObjects(){
        loginPage = new PO_LoginTheInternet(page);
    }

    @Test
    @DisplayName("Login exitoso con credenciales validas")
    void abrirPaginaWeb() {


        // 1. Ir a la página
        loginPage.navigate();

        // 2. Validar título
        PlaywrightAssertions.assertThat(page).hasTitle("The Internet");

        loginPage.login("tomsmith", "SuperSecretPassword!");

        PlaywrightAssertions.assertThat(page.locator("#flash")).containsText("You logged into a secure area");

    }

    @Test
    @DisplayName("Login fallido con credenciales incorrectas")
    void loginFallido(){


        // 1. Ir a la página
        loginPage.navigate();

        // 2. Validar título
        PlaywrightAssertions.assertThat(page).hasTitle("The Internet");

        loginPage.login("tomsmith123", "123456");

        PlaywrightAssertions.assertThat(page.locator("#flash")).containsText("Your username is invalid");

    }


}