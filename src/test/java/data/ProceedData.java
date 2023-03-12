package data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ProceedData {
    private WebDriver driver;
    public ProceedData(WebDriver driver){
        this.driver = driver;
    }

    public String firstName, lastName, ziCode;

    public void UserData() throws IOException, ParseException {
        String srcFile = System.getProperty("user.dir")+"/src/test/java/data/proceedData.json";
        File file = new File(srcFile);

        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray)  parser.parse(new FileReader(file));

        for (Object object : jsonArray){
            JSONObject jsonObject = (JSONObject)  object;

            firstName = (String) jsonObject.get("firstName");
            lastName = (String) jsonObject.get("lastName");
            ziCode = (String) jsonObject.get("zipCode");
        }
    }
}
