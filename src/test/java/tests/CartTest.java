package tests;

import com.Globant.pages.CartPage;
import com.Globant.pages.LoginPage;
import com.Globant.pages.ProductPage;
import org.testng.annotations.Test;

import java.util.List;

public class CartTest extends BaseTest {
    @Test public void completeRemoveFlow(){
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);


        loginPage.login("standard_user", "secret_sauce");


        List<String> addedProductIds = productPage.addThreeRandomProductsToCart();
        productPage.goToShoppingCart();



        cartPage.removeItemsFromCart(addedProductIds);
    }
}