package ru.kopylov.daisyplanet.tests;

import org.junit.Test;
import ru.kopylov.daisyplanet.dao.PlanetDAO;



/**
 * Created by sergey on 25.09.17.
 */
public class TestDataBase {

    @Test
    public void testCreateDB(){
        new PlanetDAO();

    }
}
