package com.Globant;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class InventoryPage extends BasePage {

    @FindBy(css = ".inventory_item .btn_inventory")
    private List<WebElement> addToCartButtons;

    @FindBy(css = ".shopping_cart_container")
    private WebElement cartButton;

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public void addMultipleRandomProductsToCart(int minItems) {
        int itemsToAdd = Math.min(minItems, addToCartButtons.size());
        Set<Integer> selectedIndices = new HashSet<>();
        Random random = new Random();

        while (selectedIndices.size() < itemsToAdd) {
            int randomIndex = random.nextInt(addToCartButtons.size());
            if (!selectedIndices.contains(randomIndex)) {
                WebElement randomProductButton = addToCartButtons.get(randomIndex);
                clickElement(randomProductButton);
                selectedIndices.add(randomIndex);
            }
        }
    }

    public void goToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            wait.until(ExpectedConditions.elementToBeClickable(cartButton));

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", cartButton);

            cartButton.click();

            wait.until(ExpectedConditions.urlContains("cart.html"));

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cart_checkout_container")));

        } catch (Exception e) {
            System.out.println("Error al navegar al carrito: " + e.getMessage());
        }
    }
}