package com.product.test.manoj.pagelocators;

import com.product.test.manoj.utils.BaseUtil;
import com.product.test.manoj.testcontext.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BaseUtil {
    public CartPage(TestContext testContext){
        super(testContext);
    }

    public WebElement cart() {
        return waitForElementPresent(By.xpath("//*[@id='blog']/div[2]/div[1]/div/div/div[3]/div[1]/div/div/a/i"));
    }

    public WebElement addToCart(int rows){
        return waitForElementPresent(By.xpath("//table[@class='shop_table cart wishlist_table wishlist_view traditional responsive   ']/tbody/tr["+rows+"]/td[6]"));
    }

    public List<WebElement> productInCart() {
        return findElements(By.xpath("//table[@class='shop_table shop_table_responsive cart woocommerce-cart-form__contents']/tbody/tr/td[@class='product-name']/a"));
    }

    public WebElement itemPrice(int rows){
        return waitForElementPresent(By.xpath("//table[@class='shop_table cart wishlist_table wishlist_view traditional responsive   ']/tbody/tr["+rows+"]/td[4]"));
    }
}
