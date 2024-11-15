package com.Globant;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    @FindBy(css = "#first-name")
    private WebElement firstNameField;

    @FindBy(css = "#last-name")
    private WebElement lastNameField;

    @FindBy(css = "#postal-code")
    private WebElement postalCodeField;

    @FindBy(css = "#continue")
    private WebElement continueButton;

    @FindBy(css = "#finish")
    private WebElement finishButton;

    @FindBy(css = "#back-to-products")
    private WebElement thankYouMessage;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void enterPersonalInfo(String firstName, String lastName, String postalCode) {
        enterText(firstNameField, firstName);
        enterText(lastNameField, lastName);
        enterText(postalCodeField, postalCode);
    }

    public void continueToFinish() {
        clickElement(continueButton);
    }

    public void finishPurchase() {
        clickElement(finishButton);
    }

    public boolean isThankYouMessageDisplayed() {
        waitForVisibility(thankYouMessage);
        return thankYouMessage.isDisplayed();
    }
}