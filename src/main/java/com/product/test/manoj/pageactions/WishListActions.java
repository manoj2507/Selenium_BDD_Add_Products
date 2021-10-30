package com.product.test.manoj.pageactions;

import com.product.test.manoj.pagelocators.WishListPage;
import com.product.test.manoj.testcontext.TestContext;
import org.junit.Assert;

public class WishListActions {

    TestContext testContext;
    WishListPage wishListPage;

    public WishListActions(TestContext testContext) {
        this.testContext = testContext;
        wishListPage = new WishListPage(testContext);
    }

    public void viewMyWishLists() {
        wishListPage.viewWishList().click();
    }

    public void findMySelection(int expectedCount) {
        int productCounts = wishListPage.wishListItems().size();
        Assert.assertEquals("WishList Product counts are not matched", expectedCount, productCounts);
    }
}
