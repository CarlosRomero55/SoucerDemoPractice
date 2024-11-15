package com.Globant;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ConfigReader;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuButton;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Método para iniciar sesión
    public void login() {
        String username = ConfigReader.getProperty("username");
        String password = ConfigReader.getProperty("password");

        enterText(usernameField, username);  // Ingresa el nombre de usuario
        enterText(passwordField, password);  // Ingresa la contraseña
        clickElement(loginButton);           // Hace clic en el botón de login
    }

    // Método para cerrar sesión
    public void logout() {
        clickElement(menuButton);             // Abre el menú desplegable
        waitForVisibility(logoutButton);      // Espera a que el botón de logout sea visible
        clickElement(logoutButton);           // Hace clic en el botón de logout
    }

    // Método para verificar si el login se realizó correctamente (si la página de login está visible)
    public boolean isLoginpageDisplayed() {
        return usernameField.isDisplayed();  // Verifica que el campo de usuario esté visible
    }

    // Método para verificar si el botón de logout está visible
    public boolean isLogoutButtonDisplayed() {
        try {
            return logoutButton.isDisplayed();  // Verifica si el botón de logout está visible
        } catch (Exception e) {
            return false;  // Si el botón no es visible o hay un error, devuelve false
        }
    }
}