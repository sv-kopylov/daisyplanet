package ru.kopylov.daisyplanet.utils;

/**
 * Created by sergey on 11.08.17.
 */
public class Conditions {


    public static double Kelvin = -273.15;
// Planet constants
    public static double radius = 1000.0;
    public static int halfZonation = 90;
    public static long daiziesPerZone = 100;

//    эмпирическая отсебятина: разница температур на экваторе и на полюсах, если вычислять в зависимости от широты
//    то на полисе окажется нулевая по кльвину, что противоречит здравому смыслу
//    величина должна зависеть от теплопроводности планеты, миграции тепла по атмосфере, и т.п.
//    к тому же температура на повехности должна быть выше расчетной из за того, что поверхность первой прогревается,
//    и из за парникового эффекта, если, конечно, есть подходящая атмосфера
    public static double planetDeltaTemper = 70.0;


//    public static long

    // Daizies constants
    public static double blackDaisyAlbedo = 0.1;
    public static double whiteDaisyAlbedo = 0.9;
    public static double noDaisyAlbedo = 0.5;

//    половина темпеатурного интервала, при котором маргаритки могут жить
    public static double aliveHalfGap = 20.0;
//    половина темпеатурного интервала, при котором маргаритки максимально продуктивны
//      (не может быть больше aliveHalfGap)
    public static double comfortHalfGap = 3.0;
//    значение комфортной температуры для жизни маргариток
    public static double comfortableTemper = 20 - Kelvin;

    public static double blackDelta = 2;
    public static double whiteDelta = -2;



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
