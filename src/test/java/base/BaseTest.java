import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    @BeforeEach
    void setUp() {
        playwright = Playwright.create();

        // setHeadless(true) es obligatorio para entornos CI/CD sin pantalla
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));

        // Inicializamos el contexto explícitamente para que no sea null
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterEach
    void tearDown() {
        // Cerramos los recursos en orden inverso a su creación
        if (page != null) page.close();
        if (context != null) context.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}