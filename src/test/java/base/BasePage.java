
package base;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void type(By locator, String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }

    protected String getText(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    protected boolean isVisible(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
    }

    protected String getPageTitle(){
        return driver.getTitle();
    }

    protected String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    protected void clear(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).clear();
    }

    protected void clickJS(By locator){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        ((org.openqa.selenium.JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
    }

    protected void scrollToElement(By locator){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        ((org.openqa.selenium.JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void waitForElement(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected boolean elementExists(By locator){
        return !driver.findElements(locator).isEmpty();
    }

    protected void switchToFrame(By locator){
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
    }

    protected void switchToDefault(){
        driver.switchTo().defaultContent();
    }

    protected void acceptAlert(){
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    protected void dismissAlert(){
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
    }

    protected String getAlertText(){
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String texto = alert.getText();
        alert.accept();
        return texto;
    }
}
