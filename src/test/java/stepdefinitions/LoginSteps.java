package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

import java.time.Duration;

public class LoginSteps {

    WebDriver driver = Hooks.driver;
    LoginPage loginPage;

    @Given("el usuario abre el navegador y va a la pagina de login")
    public void abrirLogin() {

        driver = Hooks.driver;

        driver.get("https://demoblaze.com");

        loginPage = new LoginPage(driver);
    }

    @When("ingresa usuario {string} y contrasena {string}")
    public void ingresarCredenciales(String usuario, String contrasena) {
        loginPage.Login();
        loginPage.enterUsername(usuario);
        loginPage.enterPassword(contrasena);
        loginPage.clickLogin();

    }

    @Then("el sistema muestra el mensaje {string}")
    public void verificarMensaje(String mensajeEsperado) {

        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());

            String textoAlert = alert.getText();

            Assert.assertTrue(textoAlert.contains(mensajeEsperado));

            alert.accept();

        } catch (TimeoutException e) {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement welcome = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser"))
            );

            String textoWelcome = welcome.getText();

            Assert.assertTrue(textoWelcome.contains("Welcome"));

        }
    }
}