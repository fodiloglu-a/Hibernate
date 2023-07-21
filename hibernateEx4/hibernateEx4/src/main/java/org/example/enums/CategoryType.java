package org.example.enums;

public enum CategoryType {
    BUS("bus"),
    CAR("car"),
    TRIAN("train"),
    SHEP("shep"),;


    private static String type;


    CategoryType(String type) {

    }

    public static String getType() {
        return type;
    }
}
