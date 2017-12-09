package ru.kopylov.daisyplanet.tests;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.kopylov.daisyplanet.model.Planet;

public class TestSpringContext {

    @Test
    public void testSteps(){

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("ru.kopylov.daisyplanet");

        Planet planet = context.getBean(Planet.class);
        planet.update();
        System.out.println("Planet temper"+planet.getTemperature());
    }

}
