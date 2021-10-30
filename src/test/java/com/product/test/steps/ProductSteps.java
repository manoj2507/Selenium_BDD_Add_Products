package com.product.test.steps;

import com.product.test.manoj.pageactions.AddProductsActions;
import com.product.test.manoj.pageactions.ShopActions;
import com.product.test.manoj.testcontext.TestContext;
import io.cucumber.java.en.Given;

public class ProductSteps {
    TestContext testContext;
    AddProductsActions addProductsActions;
    ShopActions shopActions;

    public ProductSteps(TestContext testContext) {
        this.testContext = testContext;
         addProductsActions = new AddProductsActions(testContext);
         shopActions = new ShopActions(testContext);


    }
    @Given("I add four different products to my wish list")
    public void productSelect() {
        shopActions.chooseMenu();
        addProductsActions.addProductsWishList();
    }
}
