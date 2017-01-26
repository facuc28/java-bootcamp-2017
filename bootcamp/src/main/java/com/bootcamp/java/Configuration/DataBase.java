package com.bootcamp.java.Configuration;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.*;



public interface DataBase {

    String driver="com.mysql.jdbc.Driver";
    String db_url="jdbc:mysql://localhost:3306/bootcamp2?useSSL=false";
    String db_user="facuc28";
    String db_pass="cmdopentelnet123";

}
