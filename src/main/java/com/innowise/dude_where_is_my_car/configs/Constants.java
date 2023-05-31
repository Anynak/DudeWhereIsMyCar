package com.innowise.dude_where_is_my_car.configs;

public class Constants {

    private Constants(){
        throw new IllegalStateException("Utility class");
    }
    public static final int MAX_MILEAGE = 2000_000;
    public static final int MIN_RELEASE_YEAR = 1886;
    public static final int MAX_RELEASE_YEAR = Integer.MAX_VALUE;
    public static final float MAX_PRICE = 1000_000_000;
    public static final int MIN_PAGE_SIZE = 10;
    public static final String DEFAULT_CURRENCY = "EUR";
    public static final int MIN_PAGE_NUMBER = 1;
    public static final float MIN_PRICE = 0;
    public static final int MIN_MILEAGE = 0;

}
