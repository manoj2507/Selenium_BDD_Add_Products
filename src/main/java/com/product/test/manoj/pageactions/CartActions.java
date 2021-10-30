package com.product.test.manoj.pageactions;

import com.product.test.manoj.pagelocators.CartPage;
import com.product.test.manoj.testcontext.TestContext;
import com.product.test.manoj.utils.BaseUtil;
import org.junit.Assert;

import java.util.*;

public class CartActions {
    TestContext testContext;
    CartPage cartPage;
    private static final int ITEM_COUNT = 4;
    private static final Map<Integer, Double> wishListTable = new HashMap<Integer, Double>();

    public CartActions(TestContext testContext) {
        this.testContext = testContext;
        cartPage = new CartPage(testContext);
    }

    public void addToCart() {
        cartPage.addToCart(Integer.parseInt(getLowestPriceTableRow())).click();
    }

    public void productPrice() {
        for (int i = 1; i <= ITEM_COUNT; i++) {
            String[] price = cartPage.itemPrice(i).getText().trim().split("£");
            double amount1 = Double.parseDouble(price[2]);
            addPriceFromTable(i, amount1);

        }

    }

    private String getLowestPriceTableRow() {
        return getLowestPriceRow(sortByValues(wishListTable));
    }

    public void addPriceFromTable(int key, Double value) {
        wishListTable.put(key, value);
    }

    public String getLowestPriceRow(Map<Integer, Double> map) {
        Optional<Integer> firstKey = map.keySet().stream().findFirst();
        if (firstKey.isPresent()) {
            return firstKey.get().toString();
        }
        return null;
    }

    private Map sortByValues(Map<Integer, Double> map) {
        List list = new LinkedList(map.entrySet());
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o1)).getValue())
                        .compareTo(((Map.Entry) (o2)).getValue());
            }
        });

        HashMap sortedHashMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext(); ) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());

        }
        return sortedHashMap;
    }

    public void cart() {
        BaseUtil.waitFor(1000);
        cartPage.cart().click();
        int actualItem = cartPage.productInCart().size();
        Assert.assertEquals("Cart items are not matched", 1, actualItem);
    }

}
