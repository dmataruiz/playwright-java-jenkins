package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        // Ruta a la carpeta donde están tus archivos .feature
        features = "src/test/resources/features",

        // Paquetes donde Cucumber buscará las Step Definitions y los Hooks
        glue = {"tests", "hooks"},

        // Filtro por etiquetas/tags (p. ej. ejecutar solo @Smoke o @Regression)
        tags = "@Smoke or @Regression",

        // Reportes de ejecución
        plugin = {
                "pretty",                                                // Muestra la salida formateada en consola
                "html:target/cucumber-reports/cucumber-pretty.html",     // Reporte HTML visual
                "json:target/cucumber-reports/cucumber.json"            // Reporte JSON para herramientas CI/CD
        },

        // Limpia caracteres extraños en los logs de la consola
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

    /**
     * Habilita la ejecución paralela de los escenarios de Gherkin con TestNG.
     * Si no quieres ejecución en paralelo, elimina este método.
     */
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}