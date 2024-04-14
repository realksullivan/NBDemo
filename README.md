## Table of Contents
- [BaseTest.Java](#basetest)
- [LoginTest.Java](#logintest)

 ## BaseTest
 ***src/test/java/base/BaseTest.java***:  is a  Java class that serves as a base for Selenium WebDriver test classes in a project. It leverages the TestNG framework for testing and focuses on setting up the WebDriver, navigating to a specific URL, and tearing down the WebDriver instance when the tests are complete. Here is an explanation of each part of the code:

1. **Package Declaration**:
    - `package base;` indicates the package where this class is located. It is a part of the base package of your project.

2. **Imports**:
    - Various import statements at the beginning of the code bring in necessary classes from Selenium WebDriver (`WebDriver`, `ChromeDriver`, etc.), TestNG (`@BeforeClass`, `@BeforeMethod`, `@AfterTest`, etc.), and other relevant classes like the `HomePage` class from your project's `pages` package.

3. **Class Declaration**:
    - `public class BaseTest` declares a public class named `BaseTest`. This class serves as a base for test classes in your project.

4. **Private WebDriver Instance**:
    - `private WebDriver driver;` declares a private instance of `WebDriver` to manage the browser.

5. **Protected HomePage Instance**:
    - `protected HomePage homePage;` declares a protected instance of `HomePage` that other test classes can use to interact with the home page.

6. **@BeforeClass**:
    - The method `setUp()` is annotated with `@BeforeClass`, indicating that it will run once before any tests in this class. This method initializes a `ChromeDriver` instance (`driver = new ChromeDriver();`), which will be used to interact with the browser.

7. **@BeforeMethod**:
    - The method `goHome()` is annotated with `@BeforeMethod`, indicating that it will run before each test method in this class. It navigates the browser to the specified URL (`driver.get("https://nb.fidelity.com/public/nbpreloginnav/spa/fidelitywork/core/home");`) and initializes a `HomePage` instance (`homePage = new HomePage(driver);`) using the current WebDriver.

8. **@AfterTest**:
    - The method `tearDown()` is annotated with `@AfterTest`, indicating that it will run once after all tests in the class have completed. This method is responsible for quitting the WebDriver instance (`driver.quit();`), which closes the browser and cleans up resources.

This class forms the foundation for test classes in your project by setting up the browser, navigating to a specific URL before each test, and closing the browser when testing is complete.

 ## LoginTest
***src/test/java/login/LoginTest.java*** is a Java class that contains test methods for testing login functionality in a web application. It extends from a base test class (`BaseTest`) and uses the TestNG testing framework. The code tests different scenarios related to logging into the application and asserts the expected behavior. Here's an explanation of each part of the code:

1. **Package Declaration**:
    - `package login;` indicates that the class is part of the `login` package in the project.

2. **Imports**:
    - Various import statements bring in classes from other packages, such as the base package (`base.BaseTest`), TestNG (`@Test`, `assertTrue`), and other relevant classes (`LoginPage`) from the `pages` package.

3. **Class Declaration**:
    - `public class LoginTest extends BaseTest` declares a public class named `LoginTest` that extends the `BaseTest` class. This means it inherits the setup and teardown methods from the base class and has access to the `homePage` variable.

4. **Test Methods**:
    - The class contains two test methods (`testPasswordRequired` and `testUserIdRequired`) annotated with `@Test`. These methods are run as test cases by the TestNG framework.

5. **Test Methods Explanation**:
    - **`testPasswordRequired`:**
        - This method tests the scenario where a password is required for login.
        - It begins by using the `homePage` instance from the base class to navigate to the form authentication page (`homePage.clickFormAuthentication()`), which returns a `LoginPage` instance.
        - The username "DemoUser" is set using `loginPage.setUsername("DemoUser")`.
        - The login button is clicked using `loginPage.clickLoginButton()`.
        - The method asserts that the password required alert is displayed using `assertTrue(loginPage.isAlertPasswordRequiredDisplayed())`.

    - **`testUserIdRequired`:**
        - This method tests the scenario where a user ID (username) is required for login.
        - Similar to the previous test, it navigates to the form authentication page using `homePage.clickFormAuthentication()` and gets a `LoginPage` instance.
        - The password "DemoPassword" is set using `loginPage.setPassword("DemoPassword")`.
        - The login button is clicked using `loginPage.clickLoginButton()`.
        - The method asserts that the user ID required alert is displayed using `assertTrue(loginPage.isUserIdRequiredDisplayed())`.

Overall, this class contains test cases for validating the login functionality of a web application using assertions to verify expected outcomes (e.g., alert messages for required fields). By extending `BaseTest`, it leverages common setup and teardown functionality for tests, providing a consistent testing environment.

***src/main/java/pages/HomePage.java*** is a Java class representing the home page of a web application. This class uses Selenium WebDriver to interact with the web application and navigate to the form authentication (login) page. Here's an explanation of each part of the code:

1. **Package Declaration**:
    - `package pages;` indicates that the class is part of the `pages` package in the project. This package likely contains other page classes representing different pages of the application.

2. **Class Declaration**:
    - `public class HomePage` declares a public class named `HomePage`. This class represents the home page of the application.

3. **Private WebDriver Instance**:
    - `private WebDriver driver;` declares a private instance of `WebDriver` to manage the browser and interact with the web elements on the home page.

4. **Private By Locator**:
    - `private By formAuthenticatedLink = By.cssSelector(".login__text");` declares a `By` locator using a CSS selector to identify the form authentication link on the home page.

5. **Constructor**:
    - `public HomePage(WebDriver driver)` is a constructor that takes a `WebDriver` instance as a parameter. The constructor initializes the `WebDriver` instance for this page object.

6. **Methods**:
    - **`clickFormAuthentication()`:**
        - This method clicks the form authentication (login) link on the home page.
        - It uses the WebDriver instance (`driver`) to find the form authentication link using the locator (`formAuthenticatedLink`) and clicks it (`driver.findElement(formAuthenticatedLink).click();`).
        - After clicking the link, the method returns a new instance of `LoginPage` initialized with the current `WebDriver` instance (`return new LoginPage(driver);`), allowing the caller to interact with the login page.

In summary, the `HomePage` class serves as a page object model for the home page of the application. It provides methods for interacting with the elements on the home page, such as navigating to the login page by clicking the form authentication link. This class encapsulates the behavior of the home page, making it easier to write automated tests and manage the page's interactions.

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


