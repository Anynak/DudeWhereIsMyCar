package com.innowise.DudeWhereIsMyCar.configs.consts;

import java.time.Year;

public class Const {
    public static final int MAX_MILEAGE = 2000_000;
    public static final int MIN_RELEASE_YEAR = 1886;
    public static final float MAX_PRICE = 1000_000_000;
    public static final int MIN_PAGE_SIZE = 10;
    public static final int MAX_PAGE_SIZE = 100;
    public static final String defaultCurrency = "EUR";
    public static final int MIN_PAGE_NUMBER = 1;
    public static final float MIN_PRICE = 0;
    public static final int MIN_MILEAGE = 0;

    public static int getMaxReleaseYear() {
        return Year.now().getValue();
    }

}
