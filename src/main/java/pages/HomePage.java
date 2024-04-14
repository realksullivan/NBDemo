package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By  formAuthenticatedLink = By.cssSelector(".login__text");
    public  HomePage(WebDriver driver){
        this.driver=driver;
    }

    public LoginPage clickFormAuthentication(){
        driver.findElement(formAuthenticatedLink).click();
        return new LoginPage(driver);
    }

}
