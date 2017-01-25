package com.bootcamp.java.Configuration;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.*;



public class DataBase {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    //private String urlDB;//="jdbc:mysql://localhost:3306/bootcamp2?useSSL=false";
    //private String userDB;//="facuc28";
    //private String passDB;//="cmdopentelnet123";

    public DataBase(){}


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
