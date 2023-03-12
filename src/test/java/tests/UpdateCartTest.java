package tests;

import data.LoginData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddToCartPage;
import pages.AddTowProductsToCartPage;
import pages.LoginPage;
import pages.UpdateCartPage;

import java.io.IOException;

public class UpdateCartTest extends TestBase{
    AddToCartPage add;
    AddTowProductsToCartPage tow;
    LoginPage log;
    UpdateCartPage update;

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
    public void continueShopping(){
        tow = new AddTowProductsToCartPage(driver);
        tow.setContinueShopping();
    }

    @Test(priority = 4)
    public void navigateToSecondProduct(){
        tow = new AddTowProductsToCartPage(driver);
        tow.navigateToSecondProduct();
        Assert.assertEquals(tow.getSecondProductAppearanceAssertionMessage(),"Sauce Labs Fleece Jacket");
    }
    @Test(priority = 5)
    public void addSecondProductToCart(){
        tow = new AddTowProductsToCartPage(driver);
        tow.addSecondProductToCart();
        Assert.assertEquals(tow.getSecondProductAssertionMessage(),"$49.99");
    }

    @Test(priority = 6)
    public void updateCart(){
        update = new UpdateCartPage(driver);
        update.removeProduct();
        Assert.assertEquals(update.getAssertionMessage(),"1");
    }
}
