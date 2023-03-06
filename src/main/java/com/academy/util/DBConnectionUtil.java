package com.academy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {
private static Connection connection;
    
    private DBConnectionUtil(){}
    
    public static Connection getDbConnection() throws ClassNotFoundException, SQLException{
        if(connection==null || connection.isClosed()){
            Class.forName(Constants.DRIVER_NAME);
            connection = DriverManager.getConnection(Constants.URL, Constants.USERNAME, Constants.PASSWORD);
        }
        
        return connection;
    }
}
