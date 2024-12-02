package com.Globant.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.util.*;

public class ProductPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(ProductPage.class);

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement product1;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    private WebElement product2;

    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    private WebElement product3;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement product4;

    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    private WebElement product5;

    @FindBy(id = "add-to-cart-test.allthethings()-t-shirt-(red)")
    private WebElement product6;

    @FindBy(css = "[data-test=shopping-cart-link]")
    private WebElement shoppingCartLink;

    @FindBy(xpath = "//*[@id='react-burger-menu-btn']")
    private WebElement openMenu;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutButton;




    private List<WebElement> productElements;
    private List<String> productIds;


    public ProductPage(WebDriver driver) {
        super(driver);
        initializeProducts();
    }


    private void initializeProducts() {

        productElements = List.of(product1, product2, product3, product4, product5, product6);
        productIds = List.of("sauce-labs-backpack", "sauce-labs-bolt-t-shirt", "sauce-labs-onesie",
                "sauce-labs-bike-light", "sauce-labs-fleece-jacket", "test.allthethings()-t-shirt-(red)");
    }


    public void addRandomProductToCart() {

        Random random = new Random();
        int randomIndex = random.nextInt(productIds.size());
        String selectedProductId = productIds.get(randomIndex);

        By addtToCartButtonSelector=By.id("add-to-cart-" + selectedProductId);

        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(addtToCartButtonSelector));

        addButton.click();

        log.info("Product [" + selectedProductId + "] was added to the shopping cart");

    }


    public void goToShoppingCart() {
        wait.until(ExpectedConditions.elementToBeClickable(shoppingCartLink)).click();
        log.info("Navigated to shopping cart");

    }


    public List<String> addThreeRandomProductsToCart() {
        initializeProducts();

        Random random = new Random();
        Set<Integer> selectedIndex = new HashSet<>();


        while (selectedIndex.size() < 3) {
            int randomIndex = random.nextInt(productIds.size());
            selectedIndex.add(randomIndex);
        }

        List<String> addedProductIds = new ArrayList<>();
        for (int index : selectedIndex) {

            WebElement addButton = wait.until(
                    ExpectedConditions.elementToBeClickable(productElements.get(index))
            );
            addButton.click();

            // Track the added product ID
            String selectedProductId = productIds.get(index);
            addedProductIds.add(selectedProductId);
            System.out.println("Added product ID: " + selectedProductId);
        }

        return addedProductIds;
    }

    public void TryToLogout(){
        wait.until(ExpectedConditions.elementToBeClickable(openMenu)).click();
        log.info("Menu is open");

        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
        log.info("Logout Successful");

    }
}