package ru.kopylov.daisyplanet.model;

import org.springframework.stereotype.Component;

/**
 * Created by sergey on 11.08.17.
 */
@Component("conditions")
public class Conditions {


    public double Kelvin = -273.15;
// Planet constants
    public double radius = 1000.0;
    public int halfZonation = 90;
    public long daiziesPerZone = 100;

    /**

     эмпирическая отсебятина: разница температур на экваторе и на полюсах, если брать эффективную температуру и
     вычислять в зависимости от широты то на полисе окажется нулевая по кльвину, что противоречит здравому смыслу.
     Поэтому базовая температура устанавливается как эффективная, но к ней добавляется эта величина умноженная косинус
     широты (если на экваторе широта 0, то прибавляется величина полностью, если на полюсе широта 90, то ничего не
     прибавляется, то есть коэфициент должен быть пропорционален проекции площади поглощения )
      */
    public double planetDeltaTemper = 70.0;


//    public static long

    // Daizies constants
    /* используются для вычисления большого альбедо*/
    public double blackDaisyAlbedo = 0.1;
    public double whiteDaisyAlbedo = 0.9;
    public double noDaisyAlbedo = 0.5;

    /**
     * пример:
     *  black white
     +43 ---- ----
     +42 ---- --++
     +41 ---- --++
     +40 ---- --++
     +39 ---- --++
     +38 --++ --++
     +37 --++ --++
     +36 --++ --++
     +35 --++ --++
     +34 --++ --++
     +33 --++ --++
     +32 --++ --++
     +31 --++ --++
     +30 --++ --++
     +29 --++ --++
     +28 --++ --++
     +27 --++ --++
     +26 --++ --++
     +25 --++ ++++
     +24 --++ ++++
     +23 --++ ++++
     +22 --++ ++++
     +21 ++++ ++++
     +20 ++++ ++++
     +19 ++++ ++++
     +18 ++++ --++
     +17 ++++ --++
     +16 ++++ --++
     +15 ++++ --++
     +14 --++ --++
     +13 --++ --++
     +12 --++ --++
     +11 --++ --++
     +10 --++ --++
      +9 --++ --++
      +8 --++ --++
      +7 --++ --++
      +6 --++ --++
      +5 --++ --++
      +4 --++ --++
      +3 --++ --++
      +2 --++ --++
      +1 --++ ----
       0 --++ ----
      -1 --++ ----
      -2 --++ ----
      -3 ---- ----
     */

//    половина темпеатурного интервала, при котором маргаритки могут жить
    public double aliveHalfGap = 20.0;
//    половина темпеатурного интервала, при котором маргаритки максимально продуктивны
//      (не может быть больше aliveHalfGap)
    public double comfortHalfGap = 3.0;

      /* Значение комфортной температуры для жизни маргариток
    Собственно реализация прогрева и охлаждения почвы вокруг маргариток,
      */
    public double blackComfortableTemper = 18 + (-Kelvin);
    public double whiteComfortableTemper = 22 + (-Kelvin);

    // Starr constants
    /**Звездная постоянная - суммарная мощность излучения звезды, проходящего через единичную площадку,
     * ориентированную перпендикулярно потоку, на расстоянии одной астрономической единицы от Звезды
     * для Солнца и Земли равняется 1367 Вт/м²*/
    public double StarConstant = 1367.0;

    /** Значение постоянной Стефана-Больцмана
     * */
    public double StephanBoltsmanConst = 5.67e-8;

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
