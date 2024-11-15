package tests;

import com.Globant.CartPage;
import com.Globant.CheckoutPage;
import com.Globant.InventoryPage;
import com.Globant.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class CheckoutTest extends BaseTest {

    @Test
    public void testCheckoutProcess() {

        // Instancia de las páginas necesarias
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        // Iniciar sesión usando las credenciales del archivo config.properties
        loginPage.login();

        // Agregar productos al carrito
        inventoryPage.addMultipleRandomProductsToCart(3);

        // Proceder al checkout
        cartPage.proceedToCheckout();

        // Introducir datos de usuario en la página de checkout
        String firstName = ConfigReader.getProperty("firstName");
        String lastName = ConfigReader.getProperty("lastName");
        String postalCode = ConfigReader.getProperty("postalCode");
        checkoutPage.enterPersonalInfo(firstName, lastName, postalCode);

        // Continuar con el proceso de compra
        checkoutPage.continueToFinish();

        // Finalizar la compra y verificar el mensaje de confirmación
        Assert.assertTrue(checkoutPage.isThankYouMessageDisplayed(), "El mensaje de agradecimiento no se muestra.");
    }
}