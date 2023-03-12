package tests;

import data.LoginData;
import data.ProceedData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddToCartPage;
import pages.LoginPage;
import pages.ProceedCheckoutPage;

import java.io.IOException;

public class ProceedCheckoutTest extends TestBase{
    AddToCartPage add;
    LoginPage log;
    ProceedCheckoutPage checkoutPage;

    @Test
    public void TestLoginFunction() throws IOException, ParseException {
        LoginData data = new LoginData(driver);
        data.UserData();
        log = new LoginPage(driver);
        log.Login(data.name, data.password);
        Assert.assertEquals(log.getAssertionMessage(),"Swag Labs");
    }

    @Test(priority = 1)
    public void navigateToProductPage(){
        add = new AddToCartPage(driver);
        add.navigateToProduct();
        Assert.assertEquals(add.getProductAppearanceAssertion(),"Sauce Labs Backpack");
    }

    @Test(priority = 2)
    public void add_productToCart(){
        add = new AddToCartPage(driver);
        add.addProductToCart();
        Assert.assertEquals(add.getAssertionMessage(),"$29.99");
    }

    @Test(priority = 3)
    public void navigateToProceedCheckout(){
        checkoutPage = new ProceedCheckoutPage(driver);
        checkoutPage.navigateToCheckout();
    }

    @Test(priority = 4)
    public void completeCheckout() throws IOException, ParseException {
        ProceedData data = new ProceedData(driver);
        data.UserData();
        checkoutPage = new ProceedCheckoutPage(driver);
        checkoutPage.fillUserInformation(data.firstName, data.lastName, data.ziCode);
    }

    @Test(priority = 5)
    public void finishOrder(){
        checkoutPage = new ProceedCheckoutPage(driver);
        checkoutPage.setFinishOrder();
        Assert.assertEquals(checkoutPage.getAssertionMessage(),"Thank you for your order!");
        checkoutPage.setBackHomeBtn();
    }
}
