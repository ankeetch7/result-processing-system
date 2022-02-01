/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resultmgt.controller;

import com.resultmgt.model.UserRoles;
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
public class UserRoleDAO {
    
    // add role
    public int addRole(UserRoles ob){
        try{
            Connection conn=DBConnection.getConnection();
            String sql_add_role = "INSERT INTO user_roles(role_name, role_desc ) VALUES(?,?)";
            PreparedStatement pst = conn.prepareStatement(sql_add_role);
            
            pst.setString(1, ob.getRole_name());
            pst.setString(2, ob.getRole_desc());
            pst.executeUpdate();
            
            conn.close();    
            return 1;
        }catch(Exception ex){
            System.out.println(ex);
            return 0;
        }
        
    }
    
    
    
 
    // retrive data
    
    public List<UserRoles> viewUserRoles(){
        ArrayList<UserRoles> userRoleLists= new ArrayList();
        
        try{
            Connection conn=DBConnection.getConnection();
            
            String sql_view_users = "SELECT *FROM user_roles";
             PreparedStatement pst=conn.prepareStatement(sql_view_users);
             
             ResultSet res = pst.executeQuery();
             while(res.next()){
                 UserRoles obb = new UserRoles();
                 obb.setRole_id(res.getInt("role_id"));    
                 obb.setRole_name(res.getString("role_name"));    
                 userRoleLists.add(obb);
             }
             
             conn.close();
             
        }catch(Exception ex){
            System.out.println(ex);
            return null;
        }
        return userRoleLists;
    }
    
    public int getRoleId(UserRoles ob){
        int role_id;
        try{
            
            Connection conn = DBConnection.getConnection();
            String sql_getRoleId = "SELECT role_id FROM user_roles WHERE role_name = ?";
            PreparedStatement pst = conn.prepareStatement(sql_getRoleId);
            pst.setString(1, ob.getRole_name());
            
            ResultSet res = pst.executeQuery();
            
            if(res.next()){
                role_id = res.getInt("role_id");
               
                return role_id;
            }else{
                JOptionPane.showMessageDialog(null, "Didnot find roles!");
            }
            
        }catch(Exception ex){
            System.out.println(ex);
        }
        
        
        return 0;
    }
    
    public String getUserRoleName(UserRoles ob){
        String role_name;
        try{
            
            Connection conn = DBConnection.getConnection();
            String sql_getUserRole = "SELECT role_name FROM user_roles WHERE role_id=?";
            PreparedStatement pst = conn.prepareStatement(sql_getUserRole);
            pst.setInt(1, ob.getRole_id());
            
            ResultSet res = pst.executeQuery();
            
            if(res.next()){
                role_name = res.getString("role_name");
                return role_name;
            }
                    
            
        }catch(Exception ex){
            System.out.println(ex);
        }
        return null;
    }
}
