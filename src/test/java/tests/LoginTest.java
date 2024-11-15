package tests;

import com.Globant.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testLogin() {
        // Instanciamos la página de login
        LoginPage loginPage = new LoginPage(driver);

        // Iniciar sesión con las credenciales obtenidas desde config.properties
        loginPage.login();

        // Verificación opcional: asegurarse de que el login fue exitoso comprobando que el botón de logout esté visible
        Assert.assertTrue(loginPage.isLogoutButtonDisplayed(), "Logout button is not displayed, login may have failed.");
    }

    @Test
    public void testLogout() {
        // Instanciamos la página de login
        LoginPage loginPage = new LoginPage(driver);

        // Iniciar sesión con las credenciales obtenidas desde config.properties
        loginPage.login();

        // Realizamos el logout
        loginPage.logout();

        // Verificación: asegurarse de que la página de login esté visible después del logout
        Assert.assertTrue(loginPage.isLoginpageDisplayed(), "Login page is not displayed after logout.");
    }
}