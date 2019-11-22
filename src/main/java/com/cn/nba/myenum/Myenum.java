package com.cn.nba.myenum;

public enum Myenum {

    G71326("G71326-4-13990568|13150158,G71326-14-13990568|13150158");


    private String value;

    private Myenum(String value){
        this.value =value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


}
