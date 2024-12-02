package tests;


import com.Globant.pages.LoginPage;
import com.Globant.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest{

    @Test
    public void completeLogoutFlow (){

        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = new ProductPage(driver);


        loginPage.login("standard_user", "secret_sauce");


        productPage.TryToLogout();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/"));
    }

}