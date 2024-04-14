package login;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import static org.testng.Assert.*;


public class LoginTest extends BaseTest {

    @Test
    public  void testPasswordRequired(){
        LoginPage loginPage= homePage.clickFormAuthentication();
        loginPage.setUsername("DemoUser");
       loginPage.clickLoginButton();
       assertTrue(loginPage.isAlertPasswordRequiredDisplayed());

    }
    @Test
    public  void testUserIdRequired(){
        LoginPage loginPage= homePage.clickFormAuthentication();
        loginPage.setPassword("DemoPassword");
        loginPage.clickLoginButton();
        assertTrue(loginPage.isUserIdRequiredDisplayed());
    }
}
