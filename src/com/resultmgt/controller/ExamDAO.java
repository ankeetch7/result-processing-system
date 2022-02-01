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
import com.resultmgt.model.Exams;
import com.resultmgt.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
public class ExamDAO {
    public int insertData(Exams ob){
        try{
            Connection conn = DBConnection.getConnection();
            String sql_add_exams = "INSERT INTO exams(exam_name,exam_start_date,exam_end_date,exam_desc) VALUES(?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql_add_exams);
            pst.setString(1, ob.getExam_name());
            pst.setString(2, ob.getExam_start_date());
            pst.setString(3, ob.getExam_end_date());
            pst.setString(4, ob.getExam_desc());
            pst.executeUpdate();
            
            conn.close();
            return 1;
        }catch(Exception ex){
            System.out.println(ex);
        }  
        return 0;
    }
    
     public List<Exams> viewExams(){
        ArrayList<Exams> examLists = new ArrayList();
        
        try{
            Connection conn = DBConnection.getConnection();
            
            String sql_view_exams = "SELECT *FROM exams";
            PreparedStatement pst = conn.prepareStatement(sql_view_exams);
            ResultSet res = pst.executeQuery();
            
            while(res.next()){
                Exams eOb = new Exams();
                eOb.setExam_id(res.getInt("exam_id"));
                eOb.setExam_name(res.getString("exam_name"));
                eOb.setExam_start_date(res.getString("exam_start_date"));
                eOb.setExam_end_date(res.getString("exam_end_date"));
                eOb.setExam_desc(res.getString("exam_desc"));

                examLists.add(eOb);
            }
            
            conn.close();
            return examLists;
        }catch(Exception ex){
            System.out.println(ex);
            return null;
        }
        
    }
     
     public List<Exams> viewSingleExam(Exams ob){
        ArrayList<Exams> examList = new ArrayList();
        
        try{
            Connection conn = DBConnection.getConnection();
            
            String sql_view_users = "SELECT *FROM exams where exam_id=?";
            PreparedStatement pst = conn.prepareStatement(sql_view_users);
            pst.setInt(1,ob.getExam_id());
            ResultSet res = pst.executeQuery();
            
            while(res.next()){
                Exams eOb = new Exams();
                eOb.setExam_id(res.getInt("exam_id"));
                eOb.setExam_name(res.getString("exam_name"));
                eOb.setExam_start_date(res.getString("exam_start_date"));
                eOb.setExam_end_date(res.getString("exam_end_date"));
                eOb.setExam_desc(res.getString("exam_desc"));
                
                examList.add(eOb);
            }
            
            conn.close();
            return examList;
        }catch(Exception ex){
            System.out.println(ex);
            return null;
        }
        
    }
     
     public int updateExams(Exams ob){
      
         try{
             Connection conn = DBConnection.getConnection();
             String sql_update_exam = "UPDATE exams SET exam_name=?,exam_start_date=?,exam_end_date=?,exam_desc=? WHERE exam_id=?";
             PreparedStatement pst= conn.prepareStatement(sql_update_exam);
             pst.setString(1, ob.getExam_name());
             pst.setString(2, ob.getExam_start_date());
             pst.setString(3, ob.getExam_end_date());
             pst.setString(4, ob.getExam_desc());
             pst.setInt(5, ob.getExam_id());
             
             pst.executeUpdate();
             conn.close();
             return 1;
         }catch(Exception ex){
             System.out.println(ex);
         }
         
         return 0;
     }
     
     public int deleteExam(Exams ob){
         try{
             Connection conn = DBConnection.getConnection();
             String sql_delete_exams = "DELETE FROM exams WHERE exam_id=?";
             PreparedStatement pst = conn.prepareStatement(sql_delete_exams);
             pst.setInt(1, ob.getExam_id());
             pst.executeUpdate();
             
             conn.close();
             return 1;
         }catch(Exception ex){
             System.out.println(ex);
         }
         return 0;
     }
     
     public int getExamID(Exams ob){
         int exam_id;
         try{
             Connection conn = DBConnection.getConnection();
             String sql_get_exam_id = "SELECT exam_id FROM exams WHERE exam_name = ? && exam_start_date=? && exam_end_date=?";
             PreparedStatement pst = conn.prepareStatement(sql_get_exam_id);
             pst.setString(1, ob.getExam_name());
             pst.setString(2, ob.getExam_start_date());
             pst.setString(3, ob.getExam_end_date());
             ResultSet res = pst.executeQuery();
             if(res.next()){
                 exam_id = res.getInt("exam_id");
                 return exam_id;
             }else{
                 JOptionPane.showMessageDialog(null, "Didnot find Exams!");  
             }
            conn.close();
         }catch(Exception ex){
             System.out.println(ex);
         }
         return 0;
     }
     

     
     public List<Exams> getExamDates(Exams ob){
         ArrayList<Exams> gradeLists = new ArrayList();
        try{
            Connection conn = DBConnection.getConnection();
            
            String sql_get_exam_date = "SELECT *FROM exams WHERE exam_name = ?";
            PreparedStatement pst = conn.prepareStatement(sql_get_exam_date);
            pst.setString(1, ob.getExam_name());
            ResultSet res = pst.executeQuery();
            while(res.next()){
                Exams eOb = new Exams();
                eOb.setExam_start_date(res.getString("exam_start_date"));
                eOb.setExam_end_date(res.getString("exam_end_date"));
                
                gradeLists.add(eOb);
            }
            
            
            conn.close();
          return gradeLists;  
        }catch(Exception ex){
            System.out.println(ex);
            return null;
        }    
    }
}
