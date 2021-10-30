package com.product.test.manoj.pageactions;

import com.product.test.manoj.pagelocators.ShopPage;
import com.product.test.manoj.testcontext.TestContext;

public class ShopActions {
    TestContext testContext;
    ShopPage shopPage;

    public ShopActions(TestContext testContext) {
        this.testContext = testContext;
        shopPage = new ShopPage(testContext);
    }
    public void chooseMenu() {
        shopPage.acceptAll().click();
        shopPage.shopMenu().click();
    }
}
