package ru.kopylov.daisyplanet.utils;

import java.util.HashMap;
import java.util.Properties;

/**
 * Created by sergey on 11.08.17.
 */
public class Conditions {
    public static double blackDaisyAlbedo = 0.9;
    public static double whiteDaisyAlbedo = 0.1;
    public static double noDaisyAlbedo = 0.5;
    private HashMap<String, String> conditions;


    private Conditions(){
        init();
    }
    private static Conditions unicInstance;
    public static Conditions getInstance(){
        if(unicInstance==null){
            unicInstance=new Conditions();
        }
        return unicInstance;
    }
    private void init(){
        conditions = new HashMap<String, String>();

    }

    public String getProperty(String key){
        if(conditions==null) return null;
        return String.valueOf(conditions.get(key));

    }

    public double getDoubleProperty(String key){
        return Double.parseDouble(conditions.get(key));

    }

    public int getIntProperty(String key) {
        return Integer.parseInt(conditions.get(key));
    }
}
