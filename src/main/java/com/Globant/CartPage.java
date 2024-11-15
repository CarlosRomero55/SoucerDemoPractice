package com.Globant;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(css = "#cart_contents_container > div > div.cart_list > div.cart_item")
    private List<WebElement> cartItems;

    @FindBy(css = ".btn_secondary.btn_small.cart_button")
    private List<WebElement> removeButtons;

    @FindBy(css = ".btn.btn_action.btn_medium.checkout_button")
    private WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public int getCartItemCount() {
        waitForVisibilityOfAll(cartItems);
        return cartItems.size();
    }

    public void removeAllItemsFromCart() {
        waitForVisibilityOfAll(removeButtons);
        for (WebElement removeButton : removeButtons) {
            clickElement(removeButton);
        }
    }

    public void proceedToCheckout() {
        clickElement(checkoutButton);
    }

    public boolean isCartEmpty() {
        return getCartItemCount() == 0;
    }

    private void waitForVisibilityOfAll(List<WebElement> elements) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }
}