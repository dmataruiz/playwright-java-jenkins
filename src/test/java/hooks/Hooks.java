package hooks;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    // Manejo de variables por hilo de ejecución (seguro para paralelo y secuencial)
    private static final ThreadLocal<Playwright> playwrightThread = new ThreadLocal<>();
    private static final ThreadLocal<Browser> browserThread = new ThreadLocal<>();
    private static final ThreadLocal<Page> pageThread = new ThreadLocal<>();

    @Before
    public void setUp() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(true)
        );
        Page page = browser.newPage();

        playwrightThread.set(playwright);
        browserThread.set(browser);
        pageThread.set(page);
    }

    @After
    public void tearDown() {
        if (pageThread.get() != null) {
            pageThread.get().close();
        }
        if (browserThread.get() != null) {
            browserThread.get().close();
        }
        if (playwrightThread.get() != null) {
            playwrightThread.get().close();
        }

        // Limpiar variables de hilo
        pageThread.remove();
        browserThread.remove();
        playwrightThread.remove();
    }

    public static Page getPage() {
        return pageThread.get();
    }
}