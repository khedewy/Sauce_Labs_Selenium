package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddTowProductsToCartPage {
    private final WebDriver driver;
    public AddTowProductsToCartPage(WebDriver driver){
        this.driver = driver;
    }

    private final By continueShoppingBtn = By.id("continue-shopping");
    private final By secondProduct = By.xpath("//div[@class='inventory_item_name' and text()='Sauce Labs Fleece Jacket']");
    private final By secondProductAppearanceAssertion = By.xpath("//div[@class='inventory_details_name large_size']");
    private final By addSecondProductToCartBtn = By.id("add-to-cart-sauce-labs-fleece-jacket");
    private final By showCartBtn = By.xpath("//a[@class='shopping_cart_link']");
    private final By secondProductAssertionMessage = By.xpath("//div[@class='inventory_item_price' and text()='49.99']");

    public void setContinueShopping(){
        driver.findElement(continueShoppingBtn).click();
    }

    public void navigateToSecondProduct(){
        driver.findElement(secondProduct).click();
    }

    public String getSecondProductAppearanceAssertionMessage(){
        return driver.findElement(secondProductAppearanceAssertion).getText();
    }

    public void addSecondProductToCart(){
        driver.findElement(addSecondProductToCartBtn).click();
        driver.findElement(showCartBtn).click();
    }

    public String getSecondProductAssertionMessage(){
        return driver.findElement(secondProductAssertionMessage).getText();
    }
}
