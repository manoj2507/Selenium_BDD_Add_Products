package com.product.test.manoj.pageactions;

import com.product.test.manoj.pagelocators.WishListPage;
import com.product.test.manoj.testcontext.TestContext;
import com.product.test.manoj.utils.BaseUtil;

public class AddProductsActions {

    TestContext testContext;
    WishListPage wishListPage;

    public AddProductsActions(TestContext testContext) {
        this.testContext = testContext;
        wishListPage = new WishListPage(testContext);
    }

    public void addProductsWishList(){
        String[] productList = testContext.jsonReader().get("products").toString().split(";");
        for(String product:productList){
            wishListPage.addWishList(product).click();
            BaseUtil.waitFor(1000);
        }

    }

}
