/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resultmgt.controller;

import com.resultmgt.model.Students;
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
public class StudentDAO {
    
    // add students
    public int addStudent(Students ob){
        
        try{
            Connection conn = DBConnection.getConnection();
            String sql_add_student = "INSERT INTO students (roll_no, first_name, middle_name, last_name, dob, gender, father_name, mother_name, address, parent_phone, parent_email, picture, g_id)"
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql_add_student);
            
            pst.setString(1, ob.getRoll_no());
            pst.setString(2, ob.getFirst_name());
            pst.setString(3, ob.getMiddle_name());
            pst.setString(4, ob.getLast_name());
            pst.setString(5, ob.getDob());
            pst.setString(6, ob.getGender());
            pst.setString(7, ob.getFather_name());
            pst.setString(8, ob.getMother_name());
            pst.setString(9, ob.getAddress());
            pst.setString(10, ob.getParent_phone());
            pst.setString(11, ob.getParent_email());  
            pst.setString(12, ob.getPicture());
            pst.setInt(13, ob.getG_id());
            
            pst.executeUpdate();
            conn.close();
                    
            return 1;
        }catch(Exception ex){    
            System.out.println(ex);
            return 0;
        }  
    }
//    add student method ends here
    
    
    // view students in jtable
    // view user details
    public List<Students> viewStudents(){
        ArrayList<Students> studentLists = new ArrayList();
        
        try{
            Connection conn = DBConnection.getConnection();
            
            String sql_view_users = "SELECT *FROM students";
            PreparedStatement pst = conn.prepareStatement(sql_view_users);
            ResultSet res = pst.executeQuery();
            
            while(res.next()){
                Students sOb = new Students();
                String name = res.getString("first_name")+" "+res.getString("middle_name")+" "+res.getString("last_name");
                sOb.setStudent_id(res.getInt("student_id"));
                sOb.setFull_name(name);
                sOb.setGender(res.getString("gender"));
                sOb.setFather_name(res.getString("father_name"));
                sOb.setMother_name(res.getString("mother_name"));
                sOb.setParent_phone(res.getString("parent_phone"));
                sOb.setParent_email(res.getString("parent_email"));
                sOb.setG_id(res.getInt("g_id"));

                studentLists.add(sOb);
            }
            
            conn.close();
            return studentLists;
        }catch(Exception ex){
            System.out.println(ex);
            return null;
        }
        
    }
    
    
    // show selected data from table into boxes
    public List<Students> viewSingleStudent(Students ob){
        ArrayList<Students> studentLists = new ArrayList();
        
        try{
            Connection conn = DBConnection.getConnection();
            
            String sql_view_users = "SELECT *FROM students where student_id=?";
            PreparedStatement pst = conn.prepareStatement(sql_view_users);
            pst.setInt(1,ob.getStudent_id());
            ResultSet res = pst.executeQuery();
            
            while(res.next()){
                Students sOb = new Students();
                sOb.setStudent_id(res.getInt("student_id"));
                sOb.setRoll_no(res.getString("roll_no"));
                sOb.setFirst_name(res.getString("first_name"));
                sOb.setMiddle_name(res.getString("middle_name"));
                sOb.setLast_name(res.getString("last_name"));
                sOb.setDob(res.getString("dob"));
                sOb.setGender(res.getString("gender"));
                sOb.setFather_name(res.getString("father_name"));
                sOb.setMother_name(res.getString("mother_name"));
                sOb.setAddress(res.getString("address"));
                sOb.setParent_phone(res.getString("parent_phone"));
                sOb.setParent_email(res.getString("parent_email"));
                sOb.setPicture(res.getString("picture"));
                sOb.setG_id(res.getInt("g_id"));
                
                
                studentLists.add(sOb);
            }
            
            conn.close();
            return studentLists;
        }catch(Exception ex){
            System.out.println(ex);
            return null;
        }
        
    }
    
    public int deleteStudent(Students ob){
       try{
            Connection conn = DBConnection.getConnection();
            String sql_delete_user = "DELETE FROM students where student_id = ?";
            PreparedStatement pst =  conn.prepareStatement(sql_delete_user);
            pst.setInt(1, ob.getStudent_id());
            
            pst.executeUpdate();
            
            conn.close();
            return 1;
            
        }catch(Exception ex){
            System.out.println(ex);
            return 0; 
        }
    }
    
    public int updateStudent(Students ob){
        try{
            Connection conn = DBConnection.getConnection();
            String sql_update_student = "UPDATE students SET roll_no = ?, first_name=?, middle_name=?, last_name=?,"
                    + " dob=?, gender=?, father_name=?, mother_name=?, address=?,"
                    + " parent_phone=?, parent_email=?, picture=?, g_id=? WHERE student_id=? ";
            
            PreparedStatement pst = conn.prepareStatement(sql_update_student);
            
            pst.setString(1, ob.getRoll_no());
            pst.setString(2, ob.getFirst_name());
            pst.setString(3, ob.getMiddle_name());
            pst.setString(4, ob.getLast_name());
            pst.setString(5, ob.getDob());
            pst.setString(6, ob.getGender());
            pst.setString(7, ob.getFather_name());
            pst.setString(8, ob.getMother_name());
            pst.setString(9, ob.getAddress());
            pst.setString(10, ob.getParent_phone());
            pst.setString(11, ob.getParent_email());  
            pst.setString(12, ob.getPicture());
            pst.setInt(13, ob.getG_id());
            pst.setInt(14, ob.getStudent_id());
            
            pst.executeUpdate();
            
            conn.close();
            return 1;
        }catch(Exception ex){
            System.out.println(ex);
            return 0;
        }  
    }
    
    public List<Students> getStudentDetails(Students ob){
         ArrayList<Students> studentLists = new ArrayList();
        
        try{
            Connection conn = DBConnection.getConnection();
            
            String sql_view_users = "SELECT *FROM students WHERE roll_no=?";
            PreparedStatement pst = conn.prepareStatement(sql_view_users);
            pst.setString(1, ob.getRoll_no());
            ResultSet res = pst.executeQuery();
            
            while(res.next()){
                Students sOb = new Students();
                String name = res.getString("first_name")+" "+res.getString("middle_name")+" "+res.getString("last_name");
                sOb.setStudent_id(res.getInt("student_id"));
                sOb.setFull_name(name);
                sOb.setGrade(res.getString("g_id"));

                studentLists.add(sOb);
            }
            
            conn.close();
            return studentLists;
        }catch(Exception ex){
            System.out.println(ex);
            return null;
        }
    }
    
     public List<Students> viewStudentAccordingToGrade(int grade_id){
        ArrayList<Students> studentLists = new ArrayList();
        
        try{
            Connection conn = DBConnection.getConnection();
            
            String sql_view_users = "SELECT *FROM students where g_id=?";
            PreparedStatement pst = conn.prepareStatement(sql_view_users);
            pst.setInt(1,grade_id);
            ResultSet res = pst.executeQuery();
            
            while(res.next()){
               Students sOb = new Students();
                String name = res.getString("first_name")+" "+res.getString("middle_name")+" "+res.getString("last_name");
                sOb.setStudent_id(res.getInt("student_id"));
                sOb.setFull_name(name);
                sOb.setGender(res.getString("gender"));
                sOb.setFather_name(res.getString("father_name"));
                sOb.setMother_name(res.getString("mother_name"));
                sOb.setParent_phone(res.getString("parent_phone"));
                sOb.setParent_email(res.getString("parent_email"));
                sOb.setG_id(res.getInt("g_id"));

                studentLists.add(sOb);
            }
            
            conn.close();
            return studentLists;
        }catch(Exception ex){
            System.out.println(ex);
            return null;
        }
        
    }
     
     public int getStudentId(Students ob){
         int student_id;
         try{
             Connection conn = DBConnection.getConnection();
             
             String sql_getStudentId = "select student_id from students as s inner join grades as g on s.g_id=g.g_id where s.roll_no=? && s.g_id=?";
             
             PreparedStatement pst = conn.prepareStatement(sql_getStudentId);
             pst.setString(1, ob.getRoll_no());
             pst.setInt(2, ob.getG_id());
             
             ResultSet res = pst.executeQuery();
             
             if(res.next()){
                 student_id = res.getInt("student_id");
                 return student_id;
             }else{
               JOptionPane.showMessageDialog(null, "Didnot find student!");  
           }
             
         }catch(Exception ex){
             System.out.println(ex);
         }
         return 0;
     }
   
    
}



