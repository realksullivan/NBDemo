package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.xpath("//button[@class='radius'][contains(.,'Login')]");
    private By passwordRequired = By.id("flash");
    private By userIdRequired = By.xpath("//s-assigned-wrapper[.='Enter your username.']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }

    public void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public SecureAreaPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new SecureAreaPage(driver);
    }

    public boolean isAlertPasswordRequiredDisplayed() {
          return driver.findElement(passwordRequired).isDisplayed();
    }
    public boolean isUserIdRequiredDisplayed() {
        return driver.findElement(userIdRequired).isDisplayed();
    }
}

