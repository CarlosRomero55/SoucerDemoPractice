# Selenium - Java - TestNG Project: Automation of SauceDemo Website 🖥️

This project automates the **SauceDemo** web application using **Selenium**, **Java**, and **TestNG** with the **Page Object Model (POM)** design pattern and **WebDriverManager** for browser driver management. It aims to test the following scenarios:

- **Purchase a product** 🛒
- **Remove items from the shopping cart** 🗑️
- **Logout from the website** 🚪

## Project Structure 📁

### 1. **BaseTest.java** 🏗️

- **Purpose**: This is the base class where we configure the WebDriver (ChromeDriver in this case) using **WebDriverManager**.
- **Key Features**:
  - **WebDriverManager** handles the downloading and setup of ChromeDriver automatically.
  - **@BeforeMethod** annotation sets up the browser and navigates to the SauceDemo login page.
  - **@AfterMethod** annotation ensures that the browser closes after each test.

### 2. **LoginPage.java** 🔑

- **Purpose**: Represents the login page where users can input their credentials to access the website.
- **Key Methods**:
  - `enterUsername(String username)`: Enters the username into the username field.
  - `enterPassword(String password)`: Enters the password into the password field.
  - `clickLogin()`: Clicks the login button and redirects to the home page.

### 3. **HomePage.java** 🏠

- **Purpose**: Represents the homepage after a successful login. From here, users can select products, view the shopping cart, etc.
- **Key Methods**:
  - `selectProduct(int index)`: Selects a product based on its index from the list.
  - `goToCart()`: Navigates to the shopping cart page.

### 4. **CartPage.java** 🛍️

- **Purpose**: Represents the shopping cart where users can proceed to checkout or remove items.
- **Key Methods**:
  - `goToCheckout()`: Proceeds to the checkout page where users can enter their personal information for the purchase.

### 5. **CheckoutPage.java** 💳

- **Purpose**: Represents the checkout page where users fill out their personal information before finalizing the purchase.
- **Key Methods**:
  - `fillPersonalInfo(String firstName, String lastName, String postalCode)`: Fills out personal information required for the checkout.
  - `completePurchase()`: Completes the purchase and navigates to the "Thank You" page.

### 6. **ThankYouPage.java** 🎉

- **Purpose**: Represents the "Thank You" page that appears after a successful purchase.
- **Key Method**:
  - `isThankYouMessageDisplayed()`: Verifies that the "Thank You" message is displayed, confirming the purchase was successful.

### 7. **PurchaseTest.java** 🛒✅

- **Purpose**: Contains the test scenario for purchasing a product from the website.
- **Key Flow**:
  1. Log in to the website.
  2. Select a product.
  3. Add it to the shopping cart.
  4. Proceed to checkout and enter personal information.
  5. Complete the purchase and verify the "Thank You" message.

### 8. **LogoutTest.java** 🚪🔒

- **Purpose**: Contains the test scenario for logging out of the SauceDemo website.
- **Key Flow**:
  1. Log in to the website.
  2. Click the logout button from the side menu.
  3. Verify that the user is redirected to the login page.

### 9. **HomePage.java - Logout Method** 🔐

- **Purpose**: The `logout()` method is used in the `HomePage.java` class to log out the user.
- **Key Steps**:
  1. Click on the menu button.
  2. Click the logout option from the sidebar.
  3. Verify that the user is redirected to the login page.

## How to Run the Tests 🚀

1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-username/saucedemo-automation.git



   Technologies Used 💻
Selenium: For automating browser interactions.
TestNG: For managing and running the tests.
WebDriverManager: For automatically managing the ChromeDriver.
Java: The programming language used to write the automation scripts
/src
    /main
        /java
            /pages           # Page Object Model (POM) classes
            /tests           # Test classes
            BaseTest.java     # Base class with WebDriver configuration
    /test
        /java
            /tests           # Test classes for Purchase and Logout scenarios
/pom.xml                     # Maven dependencies and build configuration
