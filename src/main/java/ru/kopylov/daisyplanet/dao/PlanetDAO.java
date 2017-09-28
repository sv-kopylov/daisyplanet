package ru.kopylov.daisyplanet.dao;

import ru.kopylov.daisyplanet.model.Conditions;
import ru.kopylov.daisyplanet.model.Planet;
import ru.kopylov.daisyplanet.model.Zone;

import java.sql.*;

/**
 * Created by sergey on 20.09.17.
 */
public class PlanetDAO {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost";
    static final String DB_NAME = "daisyplanet";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "1510";
    Connection conn = null;

    public void test ()  {

        try {
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            ResultSet rs = conn.getMetaData().getCatalogs();
            while (rs.next()) {
                System.out.println("TABLE_CAT = " + rs.getString("TABLE_CAT") );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally  {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void drop(){
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = connection.createStatement()){
            String sql = "DROP DATABASE IF EXISTS " +DB_NAME;
            stmt.executeUpdate(sql);

        }  catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void create(){

    }

    public PlanetDAO() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        drop();
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = connection.createStatement()){
            String sql = "CREATE DATABASE " +DB_NAME;
            stmt.executeUpdate(sql);

        }  catch (SQLException e){
            e.printStackTrace();
        }


        createTables();

    }

    private Connection getConnection() {
            try {
                if (conn!=null&&conn.isValid(1)){
                    return conn;
                } else {
                    conn= DriverManager.getConnection(DB_URL+"/"+DB_NAME,USER,PASS);
                    return conn;
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
            return null;
        }

    public void createTables(){
        String planetSql ="CREATE TABLE Planet" +
                "(" +
                "iterationId BIGINT UNSIGNED NOT NULL UNIQUE," +
                "StarConstant DOUBLE," +
                "inhabited BOOLEAN," +
                "albedo DOUBLE," +
                "temperature DOUBLE," +
                "radius DOUBLE," +
                "halfZonation INT," +
                "daiziesPerZone BIGINT," +
                "effectiveArea DOUBLE," +
                "zoneArea DOUBLE," +
                "daisyArea DOUBLE," +
                "PRIMARY KEY (iterationId)" +
                ")" +
                "ENGINE InnoDB CHARACTER SET utf8;";

        String zoneSql = "CREATE TABLE Zone" +
                "(" +
                "id BIGINT UNSIGNED NOT NULL UNIQUE," +
                "iterationId BIGINT UNSIGNED NOT NULL UNIQUE," +
                "latitude DOUBLE," +
                "effectiveArea DOUBLE," +
                "height DOUBLE," +
                "localTemperature DOUBLE," +
                "numBlackDaisies BIGINT," +
                "numWhiteDaisies BIGINT," +
                "numEmptyCells BIGINT," +
                "PRIMARY KEY (id, iterationId)," +
                "FOREIGN KEY (iterationId) REFERENCES Planet (iterationId)" +
                "ON DELETE CASCADE ON UPDATE CASCADE" +
                ")" +
                "ENGINE InnoDB CHARACTER SET utf8;";

        String conditionsSql = "CREATE TABLE Conditions" +
                "(" +
                "iterationId BIGINT UNSIGNED NOT NULL UNIQUE," +
                "Kelvin DOUBLE," +
                "radius DOUBLE," +
                "halfZonation DOUBLE," + // todo
                "daiziesPerZone BIGINT," + // todo
                "planetDeltaTemper DOUBLE," +
                "blackDaisyAlbedo DOUBLE," +
                "whiteDaisyAlbedo DOUBLE," +
                "noDaisyAlbedo DOUBLE," +
                "aliveHalfGap DOUBLE," +
                "comfortHalfGap DOUBLE," +
                "blackComfortableTemper DOUBLE," +
                "whiteComfortableTemper DOUBLE," +
                "StarConstant DOUBLE," + // todo
                "StephanBoltsmanConst DOUBLE," +
                "PRIMARY KEY (iterationId)," +
                "FOREIGN KEY (iterationId) REFERENCES Planet (iterationId) " +
                "ON DELETE CASCADE ON UPDATE CASCADE" +
                ")" +
                "ENGINE InnoDB CHARACTER SET utf8;";
        ;
        try (Statement stmt = getConnection().createStatement()) {
            stmt.executeUpdate(planetSql);
            stmt.executeUpdate(zoneSql);
            stmt.executeUpdate(conditionsSql);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public Planet getPlanet(Long iteration){
        return null;
    }
    public Planet[] getPlanets(Long iterationFrom, Long iterationtO){
         return null;
    }
    public void persist(Planet planet){

    }

    public void persist(Zone zone, Planet planet){

    }
    public Zone[] getZones(Long iteration){
        return null;
    }

    public void persist(Conditions conditions, Planet planet){

    }
    public Conditions getConditions(Long iteration){
        return null;
    }



}
