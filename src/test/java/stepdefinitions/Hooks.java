package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void iniciarDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void cerrarNavegador() {
        if (driver != null) {
            driver.quit();
        }
    }
}