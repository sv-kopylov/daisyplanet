package ru.kopylov.daisyplanet.utils;

/**
 * Created by sergey on 11.08.17.
 */
public class Conditions {
    // Planet constants
    public static double radius = 1000.0;
    public static int halfZonation = 90;
    public static long daiziesPerZone = 100;

    // Daizies constants
    public static double blackDaisyAlbedo = 0.1;
    public static double whiteDaisyAlbedo = 0.9;
    public static double noDaisyAlbedo = 0.5;

    // Starr constants
    public static double StarConstant = 1367.0;
    public static double StephanBoltsmanConst = 5.67e-8;


    private Conditions(){
     }
    private static Conditions unicInstance;
    public static Conditions getInstance(){
        if(unicInstance==null){
            unicInstance=new Conditions();
        }
        return unicInstance;
    }

}
