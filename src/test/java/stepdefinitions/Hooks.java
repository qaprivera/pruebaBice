package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void iniciarDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://sucursalvirtual.metrogas.cl/ingreso/ingresar");
    }

    @After
    public void cerrarNavegador() {
        if (driver != null) {
            driver.quit();
        }
    }
}