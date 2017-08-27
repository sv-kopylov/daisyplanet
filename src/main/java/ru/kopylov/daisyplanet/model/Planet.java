package ru.kopylov.daisyplanet.model;
import ru.kopylov.daisyplanet.logic.InitialDaysiePopulator;
import ru.kopylov.daisyplanet.logic.ZoneMaker;
import ru.kopylov.daisyplanet.utils.Conditions;



/**
 * Created by sergey on 10.08.17.
 */
public class Planet {
    Starr star;
    Zone[] zones;

    // Metrics
    private double albedo = 0;
    private double temperature = 0;

    // primary parameters
    private double radius = Conditions.radius;

    /** количество поясов на которое разбито одно полушарие*/
    private int halfZonation = Conditions.halfZonation;

    /** фрагментация пояса: максимальное количество маргариток на пояс, на всех поясах - количество маргариток одинаковое */
    private long daiziesPerZone = Conditions.daiziesPerZone;

    // derivative parameters
    /** эффективная площадь - проекция планеты на плоскость перпендикулярную напправлению излучения идущему
     * от звезды к планете,
     *  используется для расчета альбедо  */
    private double effectiveArea;

    /**  площадь пояса у  всех area - одинаковая
      S = 2πrh,
      r  – радиус сферы,
      h  – высота сферического пояса.
     */
    private double zoneArea;


    /** условная площадь одной маргаритки, справочный параметр*/
    private double daisyArea;


    public Planet(Starr star){
        this.star = star;
        zones = ZoneMaker.makeZones(radius, halfZonation);
        InitialDaysiePopulator idp = new InitialDaysiePopulator();
        idp.populate(zones, daiziesPerZone, 10, 10, 10);
        effectiveArea = Math.PI*radius*radius;
        zoneArea = 2*Math.PI*radius*(radius/halfZonation);
        daisyArea = zoneArea/daiziesPerZone;
        update();
    }




    public void update() {

    }






}
