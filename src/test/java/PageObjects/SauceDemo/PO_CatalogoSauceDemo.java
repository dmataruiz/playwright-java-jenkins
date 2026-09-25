package PageObjects.SauceDemo;

import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class PO_CatalogoSauceDemo {

    protected Page page;

    public PO_CatalogoSauceDemo(Page page){
        this.page = page;
    }
    public void validatePage(String tituloEsperado){
        assertThat(page.locator(".title")).containsText(tituloEsperado);
    }
}
