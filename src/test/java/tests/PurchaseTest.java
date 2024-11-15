package  tests;

import com.Globant.CartPage;
import com.Globant.CheckoutPage;
import com.Globant.InventoryPage;
import com.Globant.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class PurchaseTest extends BaseTest {

    @Test
    public void testPurchaseFlow() {
        // Instanciamos las páginas necesarias
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        try {
            // Iniciar sesión con las credenciales obtenidas desde config.properties
            loginPage.login();

            // Verificar si el login fue exitoso antes de continuar
            Assert.assertTrue(loginPage.isLogoutButtonDisplayed(), "Logout button should be visible after login.");

            // Añadir productos al carrito
            inventoryPage.addMultipleRandomProductsToCart(3);

            // Proceder al carrito
            inventoryPage.goToCart();

            // Verificar que el carrito contiene productos antes de proceder
            Assert.assertTrue(cartPage.getCartItemCount() > 0, "El carrito debe contener productos antes de proceder al checkout.");

            // Proceder al checkout
            cartPage.proceedToCheckout();

            // Completar el proceso de checkout (introducir datos de usuario si es necesario)
            String firstName = ConfigReader.getProperty("firstName");
            String lastName = ConfigReader.getProperty("lastName");
            String postalCode = ConfigReader.getProperty("postalCode");
            checkoutPage.enterPersonalInfo(firstName, lastName, postalCode);
            checkoutPage.continueToFinish();

            // Verificar que se muestre el mensaje de "Gracias" al finalizar la compra
            Assert.assertTrue(checkoutPage.isThankYouMessageDisplayed(), "El mensaje de agradecimiento no se muestra después de finalizar la compra.");
        } catch (Exception e) {
            // En caso de fallo, la prueba reporta la excepción
            Assert.fail("La prueba de flujo de compra falló debido a una excepción: " + e.getMessage());
        }
    }
}