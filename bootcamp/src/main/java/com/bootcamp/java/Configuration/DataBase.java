package com.bootcamp.java.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.*;
/**
 * Created by facun on 11/01/2017.
 */

public class DataBase {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private static DataBase dataBase;
    private String urlDB;//="jdbc:mysql://localhost:3306/bootcamp2?useSSL=false";
    private String userDB;//="facuc28";
    private String passDB;//="cmdopentelnet123";

    public DataBase(){
    }

    public DataBase(String urlDB, String userDB, String passDB) {
        this.urlDB = urlDB;
        this.userDB = userDB;
        this.passDB = passDB;
        connect();
    }

    public Connection getConnection() {
        return connection;
    }

    public String getUrlDB() {
        return urlDB;
    }

    public String getUserDB() {
        return userDB;
    }

    //jdbc:mysql://localhost:3306/bootcamp2?useSSL=false
    public boolean connect()
    {

        try {
            connection = DriverManager.getConnection(urlDB, userDB, passDB);
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
