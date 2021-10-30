package com.product.test.steps.hooks;

import com.product.test.manoj.testcontext.TestContext;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;


public class Hooks
{
    private final TestContext testContext;
    public Hooks(TestContext testContext){
        this.testContext = testContext;
    }

   @Before
    public void beforeScenario(){
        testContext.getDriver().get(testContext.jsonReader().get("url").toString());
    }

    @After
    public void afterScenario(Scenario scenario){
        try{
            if(scenario.isFailed()){
                byte[] screenshot = ((TakesScreenshot) testContext.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot,"image/png","Screenshot");
            }

        }
        catch(WebDriverException e){
            System.out.println(e.getMessage());;

        }
        testContext.getDriver().quit();
    }
}
