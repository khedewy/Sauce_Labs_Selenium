package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProceedCheckoutPage {
    private final WebDriver driver;
    public ProceedCheckoutPage(WebDriver driver){
        this.driver = driver;
    }

    private final By checkoutBtn = By.id("checkout");
    private final By firstNameTxt = By.id("first-name");
    private final By lastNameTxt = By.id("last-name");
    private final By zipCodeTxt = By.id("postal-code");
    private final By continueBtn = By.id("continue");
    private final By finishOrder = By.id("finish");
    private final By assertionMessage = By.xpath("//h2");
    private final By backHomeBtn = By.id("back-to-products");

    public void navigateToCheckout(){
        driver.findElement(checkoutBtn).click();
    }

    public void fillUserInformation(String firstname, String lastName, String zipCode){
        driver.findElement(firstNameTxt).sendKeys(firstname);
        driver.findElement(lastNameTxt).sendKeys(lastName);
        driver.findElement(zipCodeTxt).sendKeys(zipCode);
        driver.findElement(continueBtn).click();
    }

    public void setFinishOrder(){
        driver.findElement(finishOrder).click();
    }

    public String getAssertionMessage(){
        return  driver.findElement(assertionMessage).getText();
    }

    public void setBackHomeBtn(){
        driver.findElement(backHomeBtn).click();
    }
}
