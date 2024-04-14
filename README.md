## Table of Contents
- [BaseTest.Java](#basetest)
- [LoginTest.Java](#logintest)

 ## BaseTest
# BaseTest Class

The `BaseTest` class serves as a foundation for Selenium WebDriver tests in the project. It leverages the TestNG testing framework to provide setup and teardown functionality for web tests. By extending this class, test classes can share common test setup and teardown logic.

## Properties

- **`WebDriver driver`**:
    - A private instance of `WebDriver` to manage browser interactions during tests.
- **`HomePage homePage`**:
    - A protected instance of `HomePage`, allowing other test classes to access and interact with the home page.

## Methods

- **`@BeforeClass public void setUp()`**:
    - Initializes a `ChromeDriver` instance before any tests are run in the class.
    - This method sets up the WebDriver, preparing it for use in the tests.

- **`@BeforeMethod public void goHome()`**:
    - Navigates the WebDriver to the specified URL (`https://nb.fidelity.com/public/nbpreloginnav/spa/fidelitywork/core/home`) before each test method.
    - Initializes a `HomePage` instance with the current WebDriver, allowing the test methods to interact with the home page.

- **`@AfterTest public void tearDown()`**:
    - Quits the `WebDriver` instance after all tests in the class have been run.
    - This method closes the browser and cleans up resources.

## Usage

To use the `BaseTest` class, extend it in your test classes and leverage its setup and teardown methods. This allows you to keep your test code clean and maintainable.

```java
import base.BaseTest;

public class MyTest extends BaseTest {
    // Test methods here
}
```
# LoginTest Class

The `LoginTest` class contains test methods that verify the login functionality of a web application. It extends the `BaseTest` class to inherit setup and teardown methods, providing a consistent testing environment.

## Test Methods

- **`@Test public void testPasswordRequired()`**:
    - This method tests the scenario where the password is required for login.
    - It navigates to the form authentication page using `homePage.clickFormAuthentication()`, and returns a `LoginPage` instance.
    - The method sets the username to "DemoUser" using `loginPage.setUsername("DemoUser")`.
    - The login button is clicked using `loginPage.clickLoginButton()`.
    - The method uses an assertion (`assertTrue`) to verify that the password required alert is displayed (`loginPage.isAlertPasswordRequiredDisplayed()`).

- **`@Test public void testUserIdRequired()`**:
    - This method tests the scenario where the user ID (username) is required for login.
    - Similar to the previous test, it navigates to the form authentication page using `homePage.clickFormAuthentication()` and obtains a `LoginPage` instance.
    - The method sets the password to "DemoPassword" using `loginPage.setPassword("DemoPassword")`.
    - The login button is clicked using `loginPage.clickLoginButton()`.
    - The method uses an assertion (`assertTrue`) to verify that the user ID required alert is displayed (`loginPage.isUserIdRequiredDisplayed()`).

## Usage

- **Extending BaseTest**:
    - By extending `BaseTest`, the `LoginTest` class gains access to common setup and teardown methods that manage the WebDriver and home page.
    
- **Running the Tests**:
    - Use the TestNG framework to execute the test methods in the `LoginTest` class.
    - The test methods use assertions (`assertTrue`) to verify expected outcomes and validate the behavior of the login page.

## Conclusion

The `LoginTest` class contains focused test methods that verify critical aspects of the login functionality in a web application. By leveraging the `BaseTest` class for setup and teardown, these tests provide a reliable and consistent environment for ensuring the quality of the login process.

# HomePage Class

The `HomePage` class represents the home page of a web application and provides methods for interacting with elements on the page. This class is part of the page object model pattern used in the project for maintaining clear separation between the test code and the application's UI elements.

## Constructor

- **`HomePage(WebDriver driver)`**:
    - Initializes the `HomePage` with a given WebDriver instance.
    - The driver is used to interact with the web application.

## Properties

- **`By formAuthenticatedLink`**:
    - A private `By` locator for the form authentication (login) link on the home page.
    - The link is identified using a CSS selector (`.login__text`).

## Methods

- **`LoginPage clickFormAuthentication()`**:
    - Navigates to the form authentication (login) page by clicking the form authentication link.
    - Returns a new instance of `LoginPage` to represent the form authentication page.

## Usage

To use the `HomePage` class, first instantiate it with a WebDriver instance:

```java
WebDriver driver = new ChromeDriver(); // or other WebDriver instance
HomePage homePage = new HomePage(driver);
```
# LoginPage Class

The `LoginPage` class represents the login page of a web application and provides methods for interacting with the elements on the page. It follows the page object model pattern, which abstracts interactions with web pages and makes test code cleaner and more maintainable.

## Constructor

- **`LoginPage(WebDriver driver)`**:
    - Initializes the `LoginPage` with a given WebDriver instance.
    - The driver is used to interact with the web elements on the login page.

## Properties

- **`By usernameField`**:
    - A `By` locator for the username input field, identified by its HTML element ID (`dom-username-input`).
- **`By passwordField`**:
    - A `By` locator for the password input field, identified by its HTML element ID (`dom-pswd-input`).
- **`By loginButton`**:
    - A `By` locator for the login button, identified by its HTML element ID (`dom-login-button`).
- **`By passwordRequired`**:
    - A `By` locator for the alert element displayed when the password is required (`Enter your password.`).
- **`By userIdRequired`**:
    - A `By` locator for the alert element displayed when the username is required (`Enter your username.`).

## Methods

- **`void setUsername(String username)`**:
    - Sets the username in the username input field.
- **`void setPassword(String password)`**:
    - Sets the password in the password input field.
- **`SecureAreaPage clickLoginButton()`**:
    - Clicks the login button and returns a new instance of `SecureAreaPage`.
- **`boolean isAlertPasswordRequiredDisplayed()`**:
    - Returns `true` if the password required alert is displayed, otherwise `false`.
- **`boolean isUserIdRequiredDisplayed()`**:
    - Returns `true` if the user ID required alert is displayed, otherwise `false`.

## Usage

1. **Instantiate the LoginPage**:
    - Create a new instance of the `LoginPage` class using a `WebDriver` instance:

    ```java
    WebDriver driver = new ChromeDriver(); // or another WebDriver instance
    LoginPage loginPage = new LoginPage(driver);
    ```

2. **Set Username and Password**:
    - Use the `setUsername` and `setPassword` methods to enter credentials:

    ```java
    loginPage.setUsername("DemoUser");
    loginPage.setPassword("DemoPassword");
    ```

3. **Click Login Button**:
    - Click the login button using the `clickLoginButton` method:

    ```java
    SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
    ```

4. **Check Alerts**:
    - Use the `isAlertPasswordRequiredDisplayed` and `isUserIdRequiredDisplayed` methods to verify the presence of alerts:

    ```java
    boolean isPasswordAlertDisplayed = loginPage.isAlertPasswordRequiredDisplayed();
    boolean isUserIdAlertDisplayed = loginPage.isUserIdRequiredDisplayed();
    ```

## Conclusion

The `LoginPage` class abstracts the interactions with the login page of the web application, providing methods to enter credentials, click the login button, and check alerts. By using this class, test code becomes more readable and maintainable.

