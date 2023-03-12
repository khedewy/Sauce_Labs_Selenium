package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UpdateCartPage {
    private final WebDriver driver;
    public UpdateCartPage(WebDriver driver){
        this.driver = driver;
    }

    private final By removeProductBtn = By.id("remove-sauce-labs-backpack");
    private final By removeAssertionMessage = By.xpath("//span[@class='shopping_cart_badge']");

    public void removeProduct(){
        driver.findElement(removeProductBtn).click();
    }
    public String getAssertionMessage(){
        return driver.findElement(removeAssertionMessage).getText();
    }
}
