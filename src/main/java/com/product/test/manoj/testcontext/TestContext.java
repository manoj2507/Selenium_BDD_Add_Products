package com.product.test.manoj.testcontext;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileReader;
import java.io.IOException;

public class TestContext {
    public RemoteWebDriver driver;
    JSONObject jsonObject;

    //Read Browser value from Json File
    private Browser browser = Browser.valueOf(jsonReader().get("browser").toString());

    public RemoteWebDriver getDriver() {
        if (driver == null) {

            switch (browser) {

                case CHROME:
                    WebDriverManager.chromedriver().setup(); // method to get the webdriver dynamically
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--silent");
                    driver = new ChromeDriver(options);
                    driver.manage().window().maximize();
                    break;
                case CHROME_HEADLESS:
                    WebDriverManager.chromedriver().setup(); // method to get the webdriver dynamically
                    ChromeOptions chOptions = new ChromeOptions();
                    chOptions.addArguments("--headless");
                    driver = new ChromeDriver(chOptions);
                    driver.manage().window().maximize();
                    break;
                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    driver = new ChromeDriver();
                    break;
                default:
                    driver = null;
            }
        }

        return driver;
    }

    public JSONObject jsonReader() {

        try {
            Object obj = new JSONParser().parse(new FileReader("input.json"));
            jsonObject = (JSONObject) obj;

        } catch (IOException|ParseException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

}

