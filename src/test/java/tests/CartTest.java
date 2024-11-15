package tests;

import com.Globant.CartPage;
import com.Globant.InventoryPage;
import com.Globant.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void testRemoveItemsFromCart() {
        // Instanciamos las páginas necesarias
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);
        CartPage cartPage = new CartPage(driver);

        try {
            // Iniciamos sesión con las credenciales desde config.properties
            loginPage.login();

            // Agregamos múltiples productos aleatorios al carrito
            inventoryPage.addMultipleRandomProductsToCart(3);

            // Accedemos a la página del carrito
            inventoryPage.goToCart();

            // Verificamos que el carrito contiene productos antes de intentar eliminarlos
            Assert.assertTrue(cartPage.getCartItemCount() > 0, "El carrito debería tener al menos un producto antes de la eliminación.");

            // Eliminamos todos los productos del carrito
            cartPage.removeAllItemsFromCart();

            // Verificamos que el carrito esté vacío después de la eliminación
            Assert.assertTrue(cartPage.getCartItemCount() == 0, "El carrito debería estar vacío después de la eliminación.");
        } catch (Exception e) {
            Assert.fail("La prueba falló debido a una excepción: " + e.getMessage());
        }
    }
}