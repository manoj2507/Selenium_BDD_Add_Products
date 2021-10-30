package com.product.test.manoj.contants;

import com.product.test.manoj.exceptions.DoNotCreateException;
import lombok.Getter;

@Getter
public class TimeOut {

    private TimeOut() {
        throw new DoNotCreateException();
    }

    public static final int WEBDRIVER_WAIT = 15;
}
