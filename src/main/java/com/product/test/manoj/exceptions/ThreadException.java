package com.product.test.manoj.exceptions;

public class ThreadException extends IllegalStateException {
    public ThreadException() {
        super("Current Thread is Interrupted");
    }
}
