package com.free.demo.service;

import java.util.HashMap;

public class ControlCharacter {

    public String getControllCharacter(String controlCharacter) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("0", "0");
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");
        map.put("5", "5");
        map.put("6", "6");
        map.put("7", "7");
        map.put("8", "8");
        map.put("9", "9");
        map.put("10", "A");
        map.put("11", "B");
        map.put("12", "C");
        map.put("13", "D");
        map.put("14", "E");
        map.put("15", "F");
        map.put("16", "H");
        map.put("17", "J");
        map.put("18", "K");
        map.put("19", "L");
        map.put("20", "M");
        map.put("21", "N");
        map.put("22", "P");
        map.put("23", "R");
        map.put("24", "S");
        map.put("25", "T");
        map.put("26", "U");
        map.put("27", "V");
        map.put("28", "W");
        map.put("29", "X");
        map.put("30", "Y");
        return map.get(controlCharacter);
    }

}
