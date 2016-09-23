/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.edu.mx.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
        
/**
 *
 * @author jony
 */
public class UtilDB {
    private static Connection connection;

    public static Connection getConnection() {
    
        if (connection != null) {
            return connection;
        }
        InputStream inputStream = UtilDB.class.getClassLoader().getResourceAsStream("/db.properties");
       
        Properties properties = new Properties();
        try {
           properties.load(inputStream);
           String driver = properties.getProperty("driver");
           String url = properties.getProperty("url");
           String user = properties.getProperty("user");
            String Password = properties.getProperty("password");
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, Password);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (ClassCastException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
                
                
    }
    return  connection;

    }
    public static void closeConnection(Connection connection){
        if (connection == null) {
            return;
        }
        try {
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
                
    }
    
}
