package  tests;
import com.Globant.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;



public class PurchaseTest extends BaseTest {

    @Test
    public void completePurchaseFlow() throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        // Login
        loginPage.login("standard_user", "secret_sauce");

        // Select and add product to cart
        productPage.addRandomProductToCart();
        productPage.goToShoppingCart();

        // Proceed to checkout
        cartPage.proceedToCheckout();

        // Fill checkout form and complete purchase
        checkoutPage.fillPersonalData("Carlos", "Romero", "09856931");
        checkoutPage.completeCheckoutOne();
        checkoutPage.completeCheckoutTwo();

        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-complete"));
    }
}