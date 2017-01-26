package com.bootcamp.java.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by facun on 26/01/2017.
 */
public class DataBaseImpl implements DataBase {

    private Connection connection;

    public  Connection getConnection(){
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(db_url,db_user,db_pass);

        }catch (Exception E)
        {
            E.printStackTrace();
        }
        return connection;
    }
}
