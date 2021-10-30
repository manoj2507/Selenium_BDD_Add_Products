package com.product.test.manoj.exceptions;

public class DoNotCreateException  extends IllegalStateException {
    public DoNotCreateException() {
        super("Class Containing Static fields, Do Not Initialize");
    }
}
