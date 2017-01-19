package com.bootcamp.java.Configuration;

import java.sql.*;
/**
 * Created by facun on 11/01/2017.
 */
public class DataBase {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private static DataBase dataBase;


    private DataBase(){}

    public static DataBase getInstance(){

        if (dataBase == null)
            dataBase = new DataBase();

        return dataBase;
    }

    public boolean connect()
    {

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bootcamp2?useSSL=false", "facuc28", "cmdopentelnet123");
            statement = connection.createStatement();

        }catch (Exception E)
        {
            E.printStackTrace();
            return false;

        }
        return true;
    }
    public ResultSet DBRequest(String request)
    {
        connect();
        try {
            resultSet = statement.executeQuery(request);
            return  resultSet;
        }catch (Exception E)
        {
            E.printStackTrace();
        }
       return null;
    }
    public boolean DBInsert(String sql)
    {
        connect();
        try {
            statement.executeUpdate(sql);

        }catch (Exception E)
        {
            E.printStackTrace();
            return false;
        }
        return true;
    }

}
