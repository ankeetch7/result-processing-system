/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resultmgt.util;


import java.sql.*;

/**
 *
 * @author AnkitPC
 */
public class DBConnection {
    
    
    public static Connection getConnection(){
        Connection conn=null;
        String url="jdbc:mysql://localhost:3306/rps_db";
        String username="root";
        String pass="";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection(url,username,pass);
        }catch(SQLException|ClassNotFoundException ex){
            System.out.println(ex);
        }
        return conn;
    }
    
    
     
}
