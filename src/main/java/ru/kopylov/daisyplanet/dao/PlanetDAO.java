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
    static final String DB_NAME = "/daisyplanet";

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


    public PlanetDAO() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = connection.createStatement();){
            String sql = "CREATE DATABASE IF NOT EXISTS " +DB_NAME;
            stmt.executeUpdate(sql);

        }  catch (SQLException e){
            e.printStackTrace();
        }


    }

        private Connection getConnection() {
            try {
                if (conn!=null&&conn.isValid(1)){
                    return conn;
                } else {
                    conn= DriverManager.getConnection(DB_URL+DB_NAME,USER,PASS);
                    return conn;
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
            return null;
        }
    public void createDB(Planet planet){


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
