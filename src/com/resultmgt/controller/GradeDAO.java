/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resultmgt.controller;

/**
 *
 * @author Ankeet
 */
import com.resultmgt.model.Grades;
import com.resultmgt.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
public class GradeDAO {
    
    public List<Grades> viewGrades(){
         ArrayList<Grades> gradeLists = new ArrayList();
        try{
            Connection conn = DBConnection.getConnection();
            
            String sql_view_grades = "SELECT *FROM grades";
            PreparedStatement pst = conn.prepareStatement(sql_view_grades);
            ResultSet res = pst.executeQuery();
            while(res.next()){
                Grades gOb = new Grades();
                gOb.setG_id(res.getInt("g_id"));
                gOb.setGrade_name(res.getString("grade_name"));
                
                gradeLists.add(gOb);
            }
            
            
            conn.close();
          return gradeLists;  
        }catch(Exception ex){
            System.out.println(ex);
            return null;
        }    
    }
    
    public int getGradeID(Grades gOb){
        int grade_id;
        try{
            
           Connection conn = DBConnection.getConnection();
           String get_gradeID = "SELECT g_id FROM grades WHERE grade_name = ? "; 
           PreparedStatement pst = conn.prepareStatement(get_gradeID);
           pst.setString(1, gOb.getGrade_name());
           ResultSet res = pst.executeQuery();
           if(res.next()){
               grade_id = res.getInt("g_id");
               return grade_id;
           }else{
               JOptionPane.showMessageDialog(null, "Didnot find grade!");  
           }
           
        }catch(Exception ex){
            System.out.println(ex);
           
        }
        return 0;
        
    }
    
    public String getGrade(Grades gOb){
        String grade_name;
         try{ 
           Connection conn = DBConnection.getConnection();
           String get_gradeID = "SELECT grade_name FROM grades WHERE g_id = ? "; 
           PreparedStatement pst = conn.prepareStatement(get_gradeID);
           pst.setInt(1, gOb.getG_id());
           ResultSet res = pst.executeQuery();
           if(res.next()){
               grade_name = res.getString("grade_name");
               return grade_name;
               
           }else{
               JOptionPane.showMessageDialog(null, "Didnot find grade!");  
           }
           
        }catch(Exception ex){
            System.out.println(ex);
           
        }
         
         return null;
    }
}
