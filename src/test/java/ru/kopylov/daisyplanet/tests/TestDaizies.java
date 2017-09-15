package ru.kopylov.daisyplanet.tests;

import org.junit.Test;
import ru.kopylov.daisyplanet.model.daizies.BlackDaisy;
import ru.kopylov.daisyplanet.model.daizies.Daisy;
import ru.kopylov.daisyplanet.model.daizies.WhiteDaizy;
import ru.kopylov.daisyplanet.utils.Conditions;

import static org.junit.Assert.assertTrue;

/**
 * Created by sergey on 14.09.17.
 */
public class TestDaizies {

    @Test
    public void testBlack(){
        for(int i = 50; i>-10;i--){


            System.out.printf("%+3.0f ",(float)i);
//            System.out.print("black:\t");

            if(BlackDaisy.isComfortable(Conditions.Kelvin+i))
                System.out.print("++");
            else
                System.out.print("--");

            if(BlackDaisy.isFitForLife(Conditions.Kelvin+i))
                System.out.print("++ ");
            else
                System.out.print("-- ");


//            System.out.print("white:\t");

            if(WhiteDaizy.isComfortable(Conditions.Kelvin+i))
                System.out.print("++");
            else
                System.out.print("--");

            if(WhiteDaizy.isFitForLife(Conditions.Kelvin+i))
                System.out.println("++");
            else
                System.out.println("--");



        }

//        assertTrue(BlackDaisy.isComfortable(Conditions.blackComfortableTemper));
//        assertTrue(BlackDaisy.isComfortable(Conditions.blackComfortableTemper+Conditions.comfortHalfGap));
//        assertTrue(BlackDaisy.isComfortable(Conditions.blackComfortableTemper-Conditions.comfortHalfGap));
//        assertTrue(BlackDaisy.isComfortable(20 + Conditions.Kelvin));

               }
}
