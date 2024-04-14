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
###

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


