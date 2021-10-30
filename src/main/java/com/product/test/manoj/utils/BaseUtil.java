package com.product.test.manoj.utils;

import com.product.test.manoj.contants.TimeOut;
import com.product.test.manoj.exceptions.ThreadException;
import com.product.test.manoj.testcontext.TestContext;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

@Slf4j
public class BaseUtil {
    RemoteWebDriver driver;

    public BaseUtil(TestContext testContext) {
        this.driver = testContext.getDriver();
    }

    public WebElement waitForElementPresent(By by) {
        WebDriverWait wait = new WebDriverWait(this.driver, TimeOut.WEBDRIVER_WAIT);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public List<WebElement> findElements(By by) {
        WebDriverWait wait = new WebDriverWait(driver, TimeOut.WEBDRIVER_WAIT);
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public static void waitFor(long milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            log.error("Current Thread is interrupted" + e.getMessage());
            Thread.currentThread().interrupt();
            throw new ThreadException();
        }
    }

}
