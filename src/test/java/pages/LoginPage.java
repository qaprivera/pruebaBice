package pages;


import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private By loginLink = By.id("login2");

    private By usernameInput = By.id("loginusername");
    private By passwordInput = By.id("loginpassword");
    private By loginButton = By.xpath("//button[text()='Log in']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username){
        type(usernameInput, username);
    }

    public void enterPassword(String password){
        type(passwordInput, password);
    }

    public void Login(){click(loginLink);}
    public void clickLogin(){
        click(loginButton);
    }
}