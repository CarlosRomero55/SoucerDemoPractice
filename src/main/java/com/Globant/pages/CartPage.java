package com.Globant.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class CartPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(CartPage.class);
    private List<String> productIds;


    @FindBy(id = "checkout")
    private WebElement checkoutButton;


    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    public CartPage(WebDriver driver, List<String> productIds) {
        super(driver);
        this.productIds = productIds;
        PageFactory.initElements(driver, this);
    }

    public void proceedToCheckout() {
        checkoutButton.click();
        log.info("Checkout: Your Information");
    }


    public void removeItemsFromCart(List<String> productIdsToRemove) {
        for (String productId : productIdsToRemove) {
            // Construct the remove button's CSS selector dynamically using the product ID
            String removeButtonSelector = "remove-" + productId;

            // Find the remove button using the constructed CSS selector
            WebElement removeButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.id(removeButtonSelector))
            );

            // Click the remove button to remove the product from the cart
            removeButton.click();

            // Optionally, wait for the cart to update after removing the item
            System.out.println("Removed product ID: " + productId);  // Debugging


        }
        log.info("Shopping cart is empty!");
    }

}