package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCartPage {
    private final WebDriver driver;
    public AddToCartPage(WebDriver driver){
        this.driver = driver;
    }

    private final By firstProduct = By.xpath("//div[@class='inventory_item_name' and text()='Sauce Labs Backpack']");
    private final By productAppearanceAssertion = By.xpath("//div[@class='inventory_details_name large_size']");
    private final By addToCartBtn = By.name("add-to-cart-sauce-labs-backpack");
    private final By showCartBtn = By.xpath("//a[@class='shopping_cart_link']");
    private final By AssertionMessage = By.xpath("//div[@class='inventory_item_price']");

    public void navigateToProduct(){
        driver.findElement(firstProduct).click();
    }

    public String getProductAppearanceAssertion(){
        return driver.findElement(productAppearanceAssertion).getText();
    }

    public void addProductToCart(){
        driver.findElement(addToCartBtn).click();
        driver.findElement(showCartBtn).click();
    }

    public String getAssertionMessage(){
        return driver.findElement(AssertionMessage).getText();
    }
}
