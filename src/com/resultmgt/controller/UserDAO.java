/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resultmgt.controller;

import com.resultmgt.model.Users;
import com.resultmgt.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author AnkitPC
 */
public class UserDAO {
    
    // add users
    public int addUser(Users ob){
        try{
            Connection conn = DBConnection.getConnection();
            String sql_add_user = "INSERT INTO users (full_name, email, phone, username,"
                    + "password, picture,role_id ) VALUES (?,?,?,?,md5(?),?,?)";
            PreparedStatement pst=conn.prepareStatement(sql_add_user);
            
            pst.setString(1, ob.getFull_name());
            pst.setString(2, ob.getEmail());
            pst.setString(3, ob.getPhone());
            pst.setString(4, ob.getUsername());
            pst.setString(5, ob.getPassword());     
            pst.setString(6, ob.getPicture());
            pst.setInt(7, ob.getRole_id()); 
            
          pst.executeUpdate();
          conn.close(); 
          return 1;
        }catch(Exception ex){
            System.out.println(ex);
            return 0;
        }
    }
    
//    add users method ends here
    
    
    // view user details
    public List<Users> viewUsers(){
        ArrayList<Users> userLists = new ArrayList();
        
        try{
            Connection conn = DBConnection.getConnection();
            
            String sql_view_users = "SELECT *FROM users";
            PreparedStatement pst = conn.prepareStatement(sql_view_users);
            ResultSet res = pst.executeQuery();
            
            while(res.next()){
                Users uOb = new Users();
                uOb.setUser_id(res.getInt("user_id"));
                uOb.setFull_name(res.getString("full_name"));
                uOb.setEmail(res.getString("email"));
                uOb.setPhone(res.getString("phone"));

                userLists.add(uOb);
            }
            
            conn.close();
            return userLists;
        }catch(Exception ex){
            System.out.println(ex);
            return null;
        }
        
    }
    
    
    // show selected data from table into boxes
    public List<Users> viewSingleUser(int user_id){
        ArrayList<Users> userLists = new ArrayList();
        
        try{
            Connection conn = DBConnection.getConnection();
            
            String sql_view_users = "SELECT *FROM users where user_id=?";
            PreparedStatement pst = conn.prepareStatement(sql_view_users);
            pst.setInt(1,user_id);
            ResultSet res = pst.executeQuery();
            
            while(res.next()){
                Users uOb = new Users();
                uOb.setUser_id(res.getInt("user_id"));
                uOb.setFull_name(res.getString("full_name"));
                uOb.setEmail(res.getString("email"));
                uOb.setPhone(res.getString("phone"));
                uOb.setUsername(res.getString("username"));
                uOb.setPassword(res.getString("password"));
                uOb.setPicture(res.getString("picture"));  
                uOb.setRole_id(res.getInt("role_id"));
                userLists.add(uOb);
            }
            
            conn.close();
            return userLists;
        }catch(Exception ex){
            System.out.println(ex);
            return null;
        }
        
    }
    
    // delete selected user
    public int deleteUser(int user_id){ 
        try{
            Connection conn = DBConnection.getConnection();
            String sql_delete_user = "DELETE FROM users where user_id = ?";
            PreparedStatement pst =  conn.prepareStatement(sql_delete_user);
            pst.setInt(1, user_id);
            
            pst.executeUpdate();
            
            conn.close();
            return 1;
            
        }catch(Exception ex){
            System.out.println(ex);
            return 0; 
        }
      
    }
    
    // update selected user
    public int updateUser(int user_id, Users ob){
        
        try{
            Connection conn = DBConnection.getConnection();
            String sql_update_user = "UPDATE users SET full_name = ?, email = ?,phone = ?, username = ?,picture = ? WHERE user_id = ?";
            
            PreparedStatement pst = conn.prepareStatement(sql_update_user);
            
            pst.setString(1, ob.getFull_name());
            pst.setString(2, ob.getEmail());
            pst.setString(3, ob.getPhone());
            pst.setString(4, ob.getUsername());  
            pst.setString(5, ob.getPicture());
            pst.setInt(6, user_id);
            
            pst.executeUpdate();
            conn.close();
            return 1;
        }catch(Exception ex){
            System.out.println(ex);
            return 0;
        }
        
    }
    
     // user login
    public int loginUser(Users ob){
        try{
            Connection conn = DBConnection.getConnection();
            
            String sql_login_users = "SELECT *FROM users WHERE username = ? &&"
                    + "password = md5(?) && role_name = ?";
            PreparedStatement pst = conn.prepareStatement(sql_login_users);
            pst.setString(1, ob.getUsername());
            pst.setString(2, ob.getPassword());
            pst.setString(3, ob.getRole_name());
            ResultSet res = pst.executeQuery();
            if(res.next()){  
                JOptionPane.showMessageDialog(null, "Login Successfull");
            }  
            else{
                JOptionPane.showMessageDialog(null, "Login Unsuccessfull");
               return 0;
            }
            conn.close();
            return 1;
        }catch(Exception ex){
            System.out.println(ex); 
            return 0;
        }  
    }
    

}
