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
