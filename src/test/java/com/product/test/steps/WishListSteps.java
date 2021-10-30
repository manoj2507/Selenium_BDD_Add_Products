package com.product.test.steps;

import com.product.test.manoj.pageactions.WishListActions;
import com.product.test.manoj.testcontext.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class WishListSteps {

    TestContext testContext;
    WishListActions wishListActions;

    public WishListSteps(TestContext testContext) {
        this.testContext = testContext;
        wishListActions= new WishListActions(testContext);
    }
    @When("I view my wishlist table")
    public void iViewMyWishlistTable() {
        wishListActions.viewMyWishLists();
    }

    @And("I find total {int} selected items in my Wishlist")
    public void iFindTotalFourSelectedItemsInMyWishlist(int count) {
        wishListActions.findMySelection(count);
    }

}
