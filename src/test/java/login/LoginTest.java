package login;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

import static org.testng.Assert.*;


public class LoginTest extends BaseTest {

    @Test
    public  void testValidUserIdRequired(){
        LoginPage loginPage= homePage.clickFormAuthentication();
        loginPage.setUsername("DemoUser");
       loginPage.clickLoginButton();
       assertTrue(loginPage.isAlertPasswordRequiredDisplayed());

    }
    @Test
    public void testSuccessfullLogon(){
        LoginPage loginPage =homePage.clickFormAuthentication();
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        SecureAreaPage secureAreaPage=  loginPage.clickLoginButton();
        assertTrue(secureAreaPage.returnFlashMessage().contains("You logged into a secure area!"));
    }
}
