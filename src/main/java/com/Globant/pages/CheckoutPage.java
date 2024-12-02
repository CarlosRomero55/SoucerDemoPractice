package com.Globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckoutPage extends  BasePage {
    private static final Logger log = LoggerFactory.getLogger(CheckoutPage.class);

    @FindBy(id = "first-name")
    private WebElement firstName;

    @FindBy(id = "last-name")
    private WebElement lastName;

    @FindBy(id = "postal-code")
    private WebElement postalCode;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(id = "finish")
    private WebElement finishButton;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void fillPersonalData(String fname, String lname, String zip) {
        wait.until(ExpectedConditions.visibilityOf(firstName)).sendKeys(fname);
        lastName.sendKeys(lname);
        postalCode.sendKeys(zip);
    }

    public void completeCheckoutOne() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
        log.info("Checkout: Overview");
    }

    public void completeCheckoutTwo() {
        wait.until(ExpectedConditions.elementToBeClickable(finishButton)).click();
        log.info("Checkout: Complete!");
        wait.until(ExpectedConditions.urlContains("checkout-complete"));
        log.info("THANK YOU FOR YOUR PURCHASE :) ");

    }

}