package com.innowise.DudeWhereIsMyCar.Const;

import java.time.Year;

public class Const {
    public static final int MAX_MILEAGE = 2000_000;
    public static final int MIN_RELEASE_YEAR = 1886;

    public static int getMaxReleaseYear(){
        return Year.now().getValue();
    }
    public static final float MAX_PRICE = 1000_000_000;
    public static final int MIN_PAGE_SIZE = 10;
    public static final int MAX_PAGE_SIZE = 100;

}
