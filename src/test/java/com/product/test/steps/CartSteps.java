package com.product.test.steps;

import com.product.test.manoj.pageactions.CartActions;
import com.product.test.manoj.testcontext.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CartSteps {

    TestContext testContext;
    CartActions cartActions;

    public CartSteps(TestContext testContext) {
        this.testContext = testContext;
        cartActions = new CartActions(testContext);
    }

    @And("I am able to add the lowest price item to my cart")
    public void iAmAbleToAddTheLowestPriceItemToMyCart() {
        cartActions.addToCart();
    }

    @Then("I am able to verify the item in my cart")
    public void iAmAbleToVerifyTheItemInMyCart() {
        cartActions.cart();
    }


    @And("I search for lowest price product")
    public void iSearchForLowestPriceProduct() {
        cartActions.productPrice();
    }
}
