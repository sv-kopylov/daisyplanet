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
    private String DB_NAME = "daisyplanet";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "1510";
    Connection conn = null;

    public void drop(){
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = connection.createStatement()){
            String sql = "DROP DATABASE IF EXISTS " +DB_NAME;
            stmt.executeUpdate(sql);

        }  catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void createDB(){
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
    }
    public void createTables() {
        String planetSql = "CREATE TABLE Planet" +
                "(" +
                "iterationId BIGINT UNSIGNED NOT NULL UNIQUE," +
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
                "id BIGINT UNSIGNED NOT NULL," +
                "iterationId BIGINT UNSIGNED NOT NULL," +
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
                "StarConstant DOUBLE," +
                "StephanBoltsmanConst DOUBLE," +
                "PRIMARY KEY (iterationId)," +
                "FOREIGN KEY (iterationId) REFERENCES Planet (iterationId) " +
                "ON DELETE CASCADE ON UPDATE CASCADE" +
                ")" +
                "ENGINE InnoDB CHARACTER SET utf8;";

        try (Statement stmt = getConnection().createStatement()) {
            stmt.executeUpdate(planetSql);
            stmt.executeUpdate(zoneSql);
            stmt.executeUpdate(conditionsSql);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public PlanetDAO(String DB_NAME) {
        this.DB_NAME = DB_NAME;

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

    public void persist(Planet planet){

        String sql = "INSERT INTO Planet (iterationId, inhabited, albedo, " +
                "temperature, radius, effectiveArea, zoneArea, daisyArea) " +
                "VALUES (?,?,?,?,?,?,?,?)";
        Connection conn = getConnection();
        try ( PreparedStatement sttm = conn.prepareStatement(sql)){
            sttm.setLong(1, planet.getIterationId());
            sttm.setBoolean(2, planet.isInhabited());
            sttm.setDouble(3, planet.getAlbedo());
            sttm.setDouble(4, planet.getTemperature());
            sttm.setDouble(5, planet.getRadius());
            sttm.setDouble(6, planet.getEffectiveArea());
            sttm.setDouble(7, planet.getZoneArea());
            sttm.setDouble(8, planet.getDaisyArea());

            sttm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        persist(planet.getZones(), planet.getIterationId());
        persist(Conditions.getInstance(), planet.getIterationId());


    }
    private void persist(Zone[] zones, long iteration){
        String sql = "INSERT INTO Zone ( id ,iterationId, latitude, effectiveArea, height, " +
                "localTemperature, numBlackDaisies, numWhiteDaisies, numEmptyCells) " +
                "VALUES (?,?,?,?,?,?,?,?,?)" +
                "";
        Connection conn = getConnection();
        try ( PreparedStatement sttm = conn.prepareStatement(sql)){
        for(int i=0; i<zones.length;i++){
            sttm.setLong(1, i);
            sttm.setLong(2, iteration);
            sttm.setDouble(3, zones[i].getLatitude());
            sttm.setDouble(4, zones[i].getEffectiveArea());
            sttm.setDouble(5, zones[i].getHeight());
            sttm.setDouble(6, zones[i].getLocalTemperature());
            sttm.setDouble(7, zones[i].getNumBlackDaisies());
            sttm.setDouble(8, zones[i].getNumWhiteDaisies());
            sttm.setDouble(9, zones[i].getNumEmptyCells());
            sttm.executeUpdate();

        }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    private void persist(Conditions conditions, long iteration){

        String sql = "INSERT INTO Conditions (iterationId, Kelvin, radius, halfZonation, daiziesPerZone, " +
                "planetDeltaTemper, blackDaisyAlbedo, whiteDaisyAlbedo, noDaisyAlbedo, aliveHalfGap, " +
                "comfortHalfGap, blackComfortableTemper, whiteComfortableTemper, StarConstant, StephanBoltsmanConst) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)" +
                "";
        Connection conn = getConnection();
        try ( PreparedStatement sttm = conn.prepareStatement(sql)){
            sttm.setLong(1, iteration);
            sttm.setDouble(2, Conditions.getInstance().Kelvin);
            sttm.setDouble(3, Conditions.getInstance().radius);
            sttm.setInt(4, Conditions.getInstance().halfZonation);
            sttm.setDouble(5, Conditions.getInstance().daiziesPerZone);
            sttm.setDouble(6, Conditions.getInstance().planetDeltaTemper);
            sttm.setDouble(7, Conditions.getInstance().blackDaisyAlbedo);
            sttm.setDouble(8, Conditions.getInstance().whiteDaisyAlbedo);
            sttm.setDouble(9, Conditions.getInstance().noDaisyAlbedo);
            sttm.setDouble(10, Conditions.getInstance().aliveHalfGap);
            sttm.setDouble(11, Conditions.getInstance().comfortHalfGap);
            sttm.setDouble(12, Conditions.getInstance().blackComfortableTemper);
            sttm.setDouble(13, Conditions.getInstance().whiteComfortableTemper);
            sttm.setDouble(14, Conditions.getInstance().StarConstant);
            sttm.setDouble(15, Conditions.getInstance().StephanBoltsmanConst);


            sttm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    private void persist(Zone zone, long iteration, int zoneId){
        String sql = "INSERT INTO Zone ( id ,iterationId, latitude, effectiveArea, height, " +
                "localTemperature, numBlackDaisies, numWhiteDaisies, numEmptyCells) " +
                "VALUES (?,?,?,?,?,?,?,?,?)" +
                "";
        Connection conn = getConnection();
        try ( PreparedStatement sttm = conn.prepareStatement(sql)){
            sttm.setLong(1, zoneId);
            sttm.setLong(2, iteration);
            sttm.setDouble(3, zone.getLatitude());
            sttm.setDouble(4, zone.getEffectiveArea());
            sttm.setDouble(5, zone.getHeight());
            sttm.setDouble(6, zone.getLocalTemperature());
            sttm.setDouble(7, zone.getNumBlackDaisies());
            sttm.setDouble(8, zone.getNumWhiteDaisies());
            sttm.setDouble(9, zone.getNumEmptyCells());
            sttm.executeUpdate();
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



    private Zone[] getZones(Long iteration){
        return null;
    }

    private void persist(Conditions conditions, Planet planet){

    }
    private Conditions getConditions(Long iteration){
        return null;
    }



}
