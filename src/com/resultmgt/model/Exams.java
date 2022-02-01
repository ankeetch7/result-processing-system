/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resultmgt.model;

/**
 *
 * @author Ankeet
 */
public class Exams {
    int exam_id;
    String exam_name, exam_start_date, exam_end_date, exam_desc;

    public int getExam_id() {
        return exam_id;
    }

    public void setExam_id(int exam_id) {
        this.exam_id = exam_id;
    }

    
    public String getExam_name() {
        return exam_name;
    }

    public void setExam_name(String exam_name) {
        this.exam_name = exam_name;
    }

    public String getExam_start_date() {
        return exam_start_date;
    }

    public void setExam_start_date(String exam_start_date) {
        this.exam_start_date = exam_start_date;
    }

    public String getExam_end_date() {
        return exam_end_date;
    }

    public void setExam_end_date(String exam_end_date) {
        this.exam_end_date = exam_end_date;
    }

    public String getExam_desc() {
        return exam_desc;
    }

    public void setExam_desc(String exam_desc) {
        this.exam_desc = exam_desc;
    }
    
}
