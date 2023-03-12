package data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LoginData {
    private WebDriver driver;
    public LoginData(WebDriver driver){
        this.driver = driver;
    }

    public String name, password;

    public void UserData() throws IOException, ParseException {
        String src = System.getProperty("user.dir")+"/src/test/java/data/loginData.json";
        File file = new File(src);

        JSONParser parser = new JSONParser();
        JSONArray jArray = (JSONArray) parser.parse(new FileReader(file));

        for (Object object : jArray){
            JSONObject jsonObject = (JSONObject) object;

            name = (String) jsonObject.get("name");
            password = (String) jsonObject.get("password");
        }
    }
}
