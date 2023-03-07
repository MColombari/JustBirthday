package com.example.justbirthday;

public class Utils {
    public static String join_string(String[] in){
        StringBuilder ret = new StringBuilder();
        for(String i : in){
            ret.append(i);
        }
        return ret.toString();
    }
}
