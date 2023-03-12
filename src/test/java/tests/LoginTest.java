package tests;

import data.LoginData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.IOException;

public class LoginTest extends TestBase{

    LoginPage log;

    @Test
    public void TestLoginFunction() throws IOException, ParseException {
        LoginData data = new LoginData(driver);
        data.UserData();
        log = new LoginPage(driver);
        log.Login(data.name, data.password);
        Assert.assertEquals(log.getAssertionMessage(),"Swag Labs");
    }
}
