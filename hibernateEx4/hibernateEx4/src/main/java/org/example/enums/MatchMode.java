package org.example.enums;


public enum MatchMode {

    NORMAL("normal"),
    START("start"),
    END("enf"),
    ANYWHERE("anywhere"),;
    private static String type  ;
    MatchMode(String type){

    }
    public static String getType(){
        return  type;
    }


}
