package tests;

import PageObjects.PO_LoginTheInternet;
import com.microsoft.playwright.Page;
import hooks.Hooks;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import org.testng.Assert;

public class PrimerTest {


    private Page page = Hooks.getPage();
    private PO_LoginTheInternet loginPage = new PO_LoginTheInternet(page);

    @Dado("que el usuario navega a la página de login de The Internet")
    public void navegarALogin() {
        loginPage.navegar();
    }

    @Cuando("ingresa el usuario {string} y la contraseña {string}")
    public void ingresarCredenciales(String user, String pass) {
        loginPage.login(user, pass);
    }

    @Cuando("hace clic en el botón de login")
    public void hacerClicLogin() {
        // Ejecutado dentro de login() en la clase Page Object
    }

    @Entonces("debe ver el mensaje de éxito {string}")
    public void verificarMensajeExito(String textoEsperado) {
        String mensajeActual = loginPage.obtenerMensajeFlash();
        Assert.assertTrue(mensajeActual.contains(textoEsperado),
                "El mensaje de éxito no coincide. Obtenido: " + mensajeActual);
    }

    @Entonces("la URL debe ser {string}")
    public void verificarUrl(String urlEsperada) {
        Assert.assertEquals(loginPage.obtenerUrlActual(), urlEsperada, "La URL tras el login no es la esperada.");
    }

    @Entonces("debe ver el mensaje de error {string}")
    public void verificarMensajeError(String textoEsperado) {
        String mensajeActual = loginPage.obtenerMensajeFlash();
        Assert.assertTrue(mensajeActual.contains(textoEsperado),
                "El mensaje de error no coincide. Obtenido: " + mensajeActual);
    }
}