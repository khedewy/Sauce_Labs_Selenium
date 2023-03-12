package tests;

import data.LoginData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddToCartPage;
import pages.LoginPage;

import java.io.IOException;

public class AddToCartTest extends TestBase{
    AddToCartPage add;
    LoginPage log;

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
}
