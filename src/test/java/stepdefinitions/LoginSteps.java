package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginSteps {

    WebDriver driver = Hooks.driver;
    LoginPage loginPage;

    @Given("el usuario esta en la pagina de login")
    public void abrirLogin() {

        driver = Hooks.driver;
        loginPage = new LoginPage(driver);
    }

    @When("ingresa email {string} y contrasena {string}")
    public void ingresarCredenciales(String email, String contrasena) {
        loginPage.cerrarModal();
        loginPage.iraLogin();
        loginPage.enterUsername(email);
        loginPage.enterPassword(contrasena);

    }

    @Then("hace click en login y aparece el mensaje {string}")
    public void clickLogin(String mensaje) {
        loginPage.Login();
        String textoActual = loginPage.validarMensaje();
        Assert.assertEquals(textoActual, mensaje);

    }
}
