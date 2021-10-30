package com.product.test.manoj.pagelocators;

import com.product.test.manoj.testcontext.TestContext;
import com.product.test.manoj.utils.BaseUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ShopPage extends BaseUtil {
    public ShopPage(TestContext testContext){
        super(testContext);
    }
    public WebElement acceptAll(){
        return waitForElementPresent(By.xpath("//a[contains(text(),'Accept all')]"));
    }
    public WebElement shopMenu() {
        return waitForElementPresent(By.xpath("//a[contains(text(),'Shop')]"));
    }
}
