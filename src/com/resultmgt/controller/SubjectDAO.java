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
import com.resultmgt.model.Subjects;
import com.resultmgt.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class SubjectDAO {
    // add subjects
    public int addSubjects(Subjects sOb){
        
        try{
           Connection conn = DBConnection.getConnection();
           String sql_add_subjects = "INSERT INTO subjects(subject_name,  full_marks, pass_marks, g_id) VALUES(?,?,?,?)";
           PreparedStatement pst = conn.prepareStatement(sql_add_subjects);
           
           pst.setString(1, sOb.getSubject_name());
           pst.setString(2, sOb.getFull_marks());
           pst.setString(3, sOb.getPass_marks());
           pst.setInt(4, sOb.getG_id());
           
           pst.executeUpdate();
           conn.close();
            
          return 1;  
        }catch(Exception ex){
            System.out.println(ex);
            return 0;
        }
        
    }
    
     // view students in jtable
    // view user details
    public List<Subjects> viewSubjects(){
        ArrayList<Subjects> subjectsLists = new ArrayList();
        
        try{
            Connection conn = DBConnection.getConnection();
            
            String sql_view_users = "SELECT *FROM subjects";
            PreparedStatement pst = conn.prepareStatement(sql_view_users);
            ResultSet res = pst.executeQuery();
            
            while(res.next()){
                Subjects sOb = new Subjects();
                sOb.setSubject_id(res.getInt("subject_id"));
                sOb.setSubject_name(res.getString("subject_name"));
                sOb.setFull_marks(res.getString("full_marks"));
                sOb.setPass_marks(res.getString("pass_marks"));
                sOb.setG_id(res.getInt("g_id"));

                subjectsLists.add(sOb);
            }
            
            conn.close();
            return subjectsLists;
        }catch(Exception ex){
            System.out.println(ex);
            return null;
        }
        
    }
    
    // to view specific grade subjects in table
    public List<Subjects> viewSpecificGradeSubjects(int grade_id){
        ArrayList<Subjects> subjectsLists = new ArrayList();
        
        try{
            Connection conn = DBConnection.getConnection();
            
            String sql_view_users = "SELECT *FROM subjects WHERE g_id = ?";
            PreparedStatement pst = conn.prepareStatement(sql_view_users);
            pst.setInt(1, grade_id);
            ResultSet res = pst.executeQuery();
            
            while(res.next()){
                Subjects sOb = new Subjects();
                sOb.setSubject_id(res.getInt("subject_id"));
                sOb.setSubject_name(res.getString("subject_name"));
                sOb.setFull_marks(res.getString("full_marks"));
                sOb.setPass_marks(res.getString("pass_marks"));
                sOb.setG_id(res.getInt("g_id"));

                subjectsLists.add(sOb);
            }
            
            conn.close();
            return subjectsLists;
        }catch(Exception ex){
            System.out.println(ex);
            return null;
        }
        
    }
    
    public List<Subjects> viewSingleSubject(Subjects ob){
        ArrayList<Subjects> subjectList = new ArrayList();
        
        try{
            Connection conn = DBConnection.getConnection();
            
            String sql_view_users = "SELECT *FROM subjects where subject_id=?";
            PreparedStatement pst = conn.prepareStatement(sql_view_users);
            pst.setInt(1,ob.getSubject_id());
            ResultSet res = pst.executeQuery();
            
            while(res.next()){
                Subjects sOb = new Subjects();
                sOb.setSubject_id(res.getInt("subject_id"));
                sOb.setSubject_name(res.getString("subject_name"));
                sOb.setFull_marks(res.getString("full_marks"));
                sOb.setPass_marks(res.getString("pass_marks"));
                sOb.setG_id(res.getInt("g_id"));
                
                subjectList.add(sOb);
            }
            
            conn.close();
            return subjectList;
        }catch(Exception ex){
            System.out.println(ex);
            return null;
        }
        
    }
    
    
    public int deleteSubjects(Subjects sOb){
        
        try{
            Connection conn = DBConnection.getConnection();
            String sql_delete_subject = "DELETE FROM subjects WHERE subject_id = ?";
            PreparedStatement pst = conn.prepareStatement(sql_delete_subject);
            pst.setInt(1, sOb.getSubject_id());
            
            pst.executeUpdate();
            conn.close();
            return 1;
            
        }catch(Exception ex){
            System.out.println(ex);
            return 0;
        }    
    }
    
    public int updateSubjects(Subjects sOb){
        try{
            Connection conn = DBConnection.getConnection();
            String sql_update_subjects = "UPDATE subjects SET subject_name = ?, full_marks = ?, pass_marks = ?,  g_id = ? WHERE subject_id = ?";
            PreparedStatement pst = conn.prepareStatement(sql_update_subjects);
            pst.setString(1, sOb.getSubject_name());
            pst.setString(2, sOb.getFull_marks());
            pst.setString(3, sOb.getPass_marks());
            pst.setInt(4, sOb.getG_id());
            pst.setInt(5, sOb.getSubject_id());
           
           pst.executeUpdate();
            
            
            conn.close();
            return 1;
        }catch(Exception ex){
            System.out.println(ex);
            return 0;
        }
    }
    
     // to view specific grade subjects in table
    public List<Subjects> viewSpecificGradeSubjectsForMarksInput(Subjects ob){
        ArrayList<Subjects> subjectsLists = new ArrayList();
        
        try{
            Connection conn = DBConnection.getConnection();
            
            String sql_view_users = "SELECT *FROM subjects WHERE g_id = ?";
            PreparedStatement pst = conn.prepareStatement(sql_view_users);
            pst.setInt(1, ob.getG_id());
            ResultSet res = pst.executeQuery();
            
            while(res.next()){
                Subjects sOb = new Subjects();
                sOb.setSubject_id(res.getInt("subject_id"));
                sOb.setSubject_name(res.getString("subject_name"));
                sOb.setFull_marks(res.getString("full_marks"));
                sOb.setPass_marks(res.getString("pass_marks"));
                sOb.setG_id(res.getInt("g_id"));

                subjectsLists.add(sOb);
            }
            
            conn.close();
            return subjectsLists;
        }catch(Exception ex){
            System.out.println(ex);
            return null;
        }
        
    }
    
    public int getSubjectID(Subjects ob){
        int subject_id;
        try{
            Connection conn = DBConnection.getConnection();
            String sql_get_subject_id = "SELECT subject_id FROM subjects WHERE subject_name=? && g_id=?";
            PreparedStatement pst = conn.prepareStatement(sql_get_subject_id);
            pst.setString(1, ob.getSubject_name());
            pst.setInt(2, ob.getG_id());
            ResultSet res = pst.executeQuery();
            if(res.next()){
                subject_id = res.getInt("subject_id");
                return subject_id;
            }else{
                
            }
            
            conn.close();
        }catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
 
}
