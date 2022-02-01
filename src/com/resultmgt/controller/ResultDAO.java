/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resultmgt.controller;
import com.resultmgt.model.Results;
import com.resultmgt.model.Students;
import com.resultmgt.model.Subjects;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Ankeet
 */
import com.resultmgt.util.DBConnection;
import com.resultmgt.view.ViewResult;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ResultDAO {
    
    public int saveData(Results ob){
        try{
            Connection conn = DBConnection.getConnection();
            String sql_save_data = "INSERT INTO results (g_id,student_id,marks_scored,remarks,result_date,subject_id,exam_id) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql_save_data);
            pst.setInt(1, ob.getG_id());
            pst.setInt(2, ob.getStudent_id());
            pst.setInt(3, ob.getMarks_scored());
            pst.setString(4, ob.getRemarks());
            pst.setString(5, ob.getResult_date());
            pst.setInt(6, ob.getSubject_id());
            pst.setInt(7, ob.getExam_id());
            pst.executeUpdate();   
            conn.close();
            return 1;
        }catch(Exception ex){
            System.out.println(ex);
            return 0;     
        }
        
    }
    
   
    
    public List<Students> showStudentData(Results ob){
        ArrayList<Students> studentList = new ArrayList();
        try{
            
            Connection conn = DBConnection.getConnection();
            
            String sql_view_student = "SELECT *FROM students WHERE student_id=?";
            PreparedStatement pst = conn.prepareStatement(sql_view_student);
            pst.setInt(1, ob.getStudent_id());
            
            ResultSet res = pst.executeQuery();
            while(res.next()){
                Students sOb = new Students();
                sOb.setFirst_name(res.getString("first_name"));
                sOb.setMiddle_name(res.getString("middle_name"));
                sOb.setLast_name(res.getString("last_name"));
                sOb.setG_id(res.getInt("g_id"));
                sOb.setRoll_no(res.getString("roll_no"));
                
                studentList.add(sOb);
                
            }
            conn.close();
            return studentList;
            
        }catch(Exception ex){
            System.out.println(ex);
        }
     return null;
    }
    
    
    public List<Results> showBarGraph(Results ob){
        ArrayList<Results> marksList = new ArrayList();
        
        try{
            
            Connection conn = DBConnection.getConnection();
            
            String sql_view_marks = "SELECT *FROM results where student_id = ? && exam_id =?";
            PreparedStatement pst = conn.prepareStatement(sql_view_marks);
            
            pst.setInt(1, ob.getStudent_id());
            pst.setInt(2, ob.getExam_id());
            
            ResultSet res = pst.executeQuery();
            
            while(res.next()){
                Results rOb = new Results();
                
                rOb.setMarks_scored(res.getInt("marks_scored"));
                marksList.add(rOb);
                
            }
            
            conn.close();
            return marksList;
        }catch(Exception ex){
            System.out.println(ex);
        } 
        return null;
    }
    
    public List<Results> viewResult(Results ob){
        ArrayList<Results> resultLists =  new ArrayList();
        ArrayList<Subjects> subjectLists = new ArrayList();
        try{           
            Connection conn = DBConnection.getConnection();
            String sql_view_result = "select s.subject_name,s.full_marks,s.pass_marks,r.marks_scored,r.remarks FROM ((((results as r inner join subjects as s on s.subject_id=r.subject_id) inner join students as std on r.student_id=std.student_id) inner join exams as e on r.exam_id=e.exam_id) inner join grades as g on g.g_id=r.g_id) where r.student_id=? && r.exam_id=?";
            PreparedStatement pst = conn.prepareStatement(sql_view_result);
            pst.setInt(1, ob.getStudent_id());
            pst.setInt(2, ob.getExam_id());
            
           
            
            ResultSet res = pst.executeQuery();
            while(res.next()){
                 
                Subjects sOb = new Subjects(); 
                sOb.setSubject_name(res.getString("subject_name"));
                sOb.setFull_marks(res.getString("full_marks"));
                sOb.setPass_marks(res.getString("pass_marks"));
                ob.setMarks_scored(res.getInt("marks_scored"));
                ob.setRemarks(res.getString("remarks"));
                
                resultLists.add(ob);
                subjectLists.add(sOb);
                
                
            }
            
            return resultLists;
            
        }catch(Exception ex){
            System.out.println(ex);
            return null;
        }
        
    }
    
    public void updateReult(Results ob){
        
    }
} 