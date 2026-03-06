package pages;
import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private  By buttonEntendido = By.cssSelector("button[data-testid=\"dialog.acceptButton\"");
    private By loginText = By.xpath("//h4[text()='Ya tengo un usuario']");
    private  By inputEmail = By.cssSelector("input[data-testid='unifiedAuth.form.email']");
    private By inputPassword = By.cssSelector("input[data-testid=\"unifiedAuth.form.password\"]");
    private By buttonIniciarSesion = By.cssSelector("div[class='c0073   styles_textContainer__1uzht undefined']");
    private By msje = By.cssSelector("div[data-testid=\"snackbar.label\"]");


    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void cerrarModal(){click(buttonEntendido);}
    public void iraLogin(){click(loginText);}
    public void enterUsername(String username){
        type(inputEmail, username);
    }

    public void enterPassword(String password){
        type(inputPassword, password);
    }

    public void Login(){click(buttonIniciarSesion);}

    public String validarMensaje(){

        int intentos = 0;

        while (intentos < 3) {
            try {
                return getText(msje);   // tu método original
            } catch (Exception e) {
                System.out.println("Reintento " + (intentos + 1) + " por DOM actualizado...");

            }
            intentos++;
        }

        throw new RuntimeException("No se pudo obtener el mensaje después de 3 reintentos.");
    }



}


