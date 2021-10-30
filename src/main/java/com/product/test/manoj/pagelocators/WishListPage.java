package com.product.test.manoj.pagelocators;

import com.product.test.manoj.utils.BaseUtil;
import com.product.test.manoj.testcontext.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WishListPage extends BaseUtil {
    
    public WishListPage(TestContext testContext){
        super(testContext);
    }
    public WebElement viewWishList() {
        return waitForElementPresent(By.xpath("//*[@id='blog']/div[3]/div[1]/div/div/div[3]/div[3]/a/i"));
    }

    public List<WebElement> wishListItems() {
        return findElements(By.xpath("//table[@class='shop_table cart wishlist_table wishlist_view traditional responsive   ']/tbody/tr"));
    }

    public WebElement addWishList(String product) {
        return waitForElementPresent(By.xpath("//h2[contains(text(),'"+product+"')]/../../div/div[2]//div/div/a"));
    }
}
