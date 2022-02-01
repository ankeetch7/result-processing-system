/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resultmgt.view;

import com.resultmgt.controller.ExamDAO;
import com.resultmgt.controller.GradeDAO;
import com.resultmgt.controller.ResultDAO;
import com.resultmgt.controller.StudentDAO;
import com.resultmgt.model.Exams;
import com.resultmgt.model.Grades;
import com.resultmgt.model.Results;
import com.resultmgt.model.Students;
import com.resultmgt.util.DBConnection;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JTable;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import net.proteanit.sql.DbUtils;



/**
 *
 * @author Ankeet
 */
public class ViewResult extends javax.swing.JInternalFrame {
         Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
       private int grade_id,student_id,exam_id;
       
       
    /**
     * Creates new form ViewResult
     */
    public ViewResult() {
        initComponents();
       
        setSize(size.width, size.height);      
         jPanel1.setSize(size.width, size.height); 
       loadGrades();
    }
    
    public void loadGrades(){
        GradeDAO gDAO = new GradeDAO();
                
        List<Grades> gradeLists=gDAO.viewGrades();
           
            if(gradeLists == null){
                jComboBox_grade.addItem("Grades not found!");
                
            }else{
                for(int i=0;i<gradeLists.size();i++){
                jComboBox_grade.addItem(gradeLists.get(i).getGrade_name());
                }  
            }

    }
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox_examName = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jComboBox_startDate = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jComboBox_endDate = new javax.swing.JComboBox<>();
        jTextField_roll = new javax.swing.JTextField();
        jButton_View = new javax.swing.JButton();
        jButton_viewPerformance = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jComboBox_grade = new javax.swing.JComboBox<>();
        jPanel_print = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_result = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel_exam = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel_name = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel_roll = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel_grade = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel_date = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel_percentage = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel_total_marks = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(1368, 613));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 185, 205));

        jLabel1.setFont(new java.awt.Font("Serif", 3, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Result Processing System");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 1327, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabel2.setText("Roll No:");

        jLabel6.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabel6.setText("Select Exam Terminal:");

        jComboBox_examName.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jComboBox_examName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Terminal", "First Terminal Exam", "Second Terminal Exam", "Third Terminal Exam", "Final Terminal Exam" }));
        jComboBox_examName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_examNameActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabel7.setText("Exam Start Date:");

        jComboBox_startDate.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jComboBox_startDate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Start Date" }));

        jLabel8.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabel8.setText("Exam End Date:");

        jComboBox_endDate.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jComboBox_endDate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select End Date" }));

        jTextField_roll.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N

        jButton_View.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jButton_View.setText("View Result");
        jButton_View.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ViewActionPerformed(evt);
            }
        });

        jButton_viewPerformance.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jButton_viewPerformance.setText("View Performance");
        jButton_viewPerformance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_viewPerformanceActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabel3.setText("Grade:");

        jComboBox_grade.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jComboBox_grade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Grade" }));
        jComboBox_grade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_gradeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jButton_View)
                        .addGap(50, 50, 50)
                        .addComponent(jButton_viewPerformance))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox_endDate, 0, 176, Short.MAX_VALUE)
                            .addComponent(jComboBox_startDate, 0, 176, Short.MAX_VALUE)
                            .addComponent(jComboBox_examName, 0, 176, Short.MAX_VALUE)
                            .addComponent(jTextField_roll)
                            .addComponent(jComboBox_grade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox_grade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jTextField_roll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox_examName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBox_startDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox_endDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_View)
                    .addComponent(jButton_viewPerformance))
                .addGap(34, 34, 34))
        );

        jPanel_print.setBackground(new java.awt.Color(255, 255, 255));

        jTable_result.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable_result.setFocusable(false);
        jScrollPane1.setViewportView(jTable_result);

        jLabel4.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Parijat Sikshya Niketan");

        jLabel5.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Kanakai-6, Jhapa");

        jLabel_exam.setFont(new java.awt.Font("Serif", 1, 16)); // NOI18N
        jLabel_exam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_exam.setText("Terminal Here");

        jLabel10.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Progress Report");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabel13.setText("Full Name:");

        jLabel_name.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabel_name.setText("name here");

        jLabel15.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabel15.setText("Roll No:");

        jLabel_roll.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabel_roll.setText("roll no here");

        jLabel17.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabel17.setText("Grade:");

        jLabel_grade.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabel_grade.setText("grade here");

        jLabel11.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabel11.setText("Date:");

        jLabel_date.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabel_date.setText("date here");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(111, 111, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel_date, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(56, 56, 56))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(41, 41, 41)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_name, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_roll, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(97, 97, 97)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel_grade, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(127, 127, 127))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel_date))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel_name)
                    .addComponent(jLabel17)
                    .addComponent(jLabel_grade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel_roll)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabel9.setText("Percentage");

        jLabel_percentage.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabel_percentage.setText("percentage here");

        jLabel12.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabel12.setText("Grand Total: ");

        jLabel_total_marks.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabel_total_marks.setText("total_marks here");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_total_marks)
                    .addComponent(jLabel_percentage))
                .addGap(41, 41, 41))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel_total_marks))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_percentage)
                    .addComponent(jLabel9))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel_printLayout = new javax.swing.GroupLayout(jPanel_print);
        jPanel_print.setLayout(jPanel_printLayout);
        jPanel_printLayout.setHorizontalGroup(
            jPanel_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel_exam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_printLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_printLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_printLayout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70))))
        );
        jPanel_printLayout.setVerticalGroup(
            jPanel_printLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_printLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_exam)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jButton1.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jButton1.setText("Print Result");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jPanel_print, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(391, 391, 391))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel_print, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox_examNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_examNameActionPerformed
        String exam_name = jComboBox_examName.getSelectedItem().toString();
        Exams eOb = new Exams();
        eOb.setExam_name(exam_name);
        ExamDAO eDAO = new ExamDAO();

        List<Exams> examDateLists=eDAO.getExamDates(eOb);

        if(examDateLists == null){
            jComboBox_startDate.addItem("Date not found");
            jComboBox_endDate.addItem("Date not found");

        }else{
            for(int i=0;i<examDateLists.size();i++){
                jComboBox_startDate.addItem(examDateLists.get(i).getExam_start_date());
                jComboBox_endDate.addItem(examDateLists.get(i).getExam_end_date());
            }
        }

    }//GEN-LAST:event_jComboBox_examNameActionPerformed

    private void jButton_ViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ViewActionPerformed
         
        String grade_name  = jComboBox_grade.getSelectedItem().toString();
        String exam_name = jComboBox_examName.getSelectedItem().toString();
        String exam_start_date = jComboBox_startDate.getSelectedItem().toString();
        String exam_end_date = jComboBox_endDate.getSelectedItem().toString();
        String roll_no = jTextField_roll.getText().trim();
        
        // get grade id
        Grades gOb = new Grades();
        gOb.setGrade_name(grade_name);
        GradeDAO gDAO = new GradeDAO();
        grade_id = gDAO.getGradeID(gOb);
        
//        // get exam id
        Exams eOb = new Exams();
        eOb.setExam_name(exam_name);
        eOb.setExam_start_date(exam_start_date);
        eOb.setExam_end_date(exam_end_date);
        
        ExamDAO eDAO = new ExamDAO();
        int e_id = eDAO.getExamID(eOb);
        
        Students sOb = new Students();
        sOb.setRoll_no(roll_no);
        sOb.setG_id(grade_id);
        StudentDAO sDAO = new StudentDAO();
        int std_id =sDAO.getStudentId(sOb);
        
        Results rOb = new Results();
        rOb.setStudent_id(student_id);
        rOb.setExam_id(exam_id);

            showDetails(std_id,e_id);
            showstudentDetails(std_id,e_id);
            calculate(std_id, e_id);
        
       
    
    }//GEN-LAST:event_jButton_ViewActionPerformed

    private void jComboBox_gradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_gradeActionPerformed
        String grade_name  = jComboBox_grade.getSelectedItem().toString();
        Grades gOb = new Grades();
        gOb.setGrade_name(grade_name);
        GradeDAO gDAO = new GradeDAO();
        grade_id = gDAO.getGradeID(gOb);
    }//GEN-LAST:event_jComboBox_gradeActionPerformed

    private void jButton_viewPerformanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_viewPerformanceActionPerformed
        String roll_no = jTextField_roll.getText().trim();
        Students sOb = new Students();
        sOb.setRoll_no(roll_no);
        sOb.setG_id(grade_id);
        StudentDAO sDAO = new StudentDAO();
        int student_id =sDAO.getStudentId(sOb);
        String exam_name = jComboBox_examName.getSelectedItem().toString();
        String exam_start_date = jComboBox_startDate.getSelectedItem().toString();
        String exam_end_date = jComboBox_endDate.getSelectedItem().toString();
        
        
        Exams eOb = new Exams();
        eOb.setExam_name(exam_name);
        eOb.setExam_start_date(exam_start_date);
        eOb.setExam_end_date(exam_end_date);
        
        ExamDAO eDAO = new ExamDAO();
        
         exam_id = eDAO.getExamID(eOb);
        
        Results rOb = new Results();
        rOb.setStudent_id(student_id);
        rOb.setExam_id(exam_id);
        
        String grade_name = jComboBox_grade.getSelectedItem().toString().toLowerCase();
        
        ResultDAO rDAO = new ResultDAO();
        
        List<Results> marksList = rDAO.showBarGraph(rOb);
        
        try{
            
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            if(grade_name.equals("nursery") || grade_name.equals("lkg") || grade_name.equals("kg") ){
                
                dataset.setValue(marksList.get(0).getMarks_scored(), "Marks", "English");
                dataset.setValue(marksList.get(1).getMarks_scored(), "Marks", "Nepali");
                dataset.setValue(marksList.get(2).getMarks_scored(), "Marks", "Maths");
                
                
            }else{
                
                dataset.setValue(marksList.get(0).getMarks_scored(), "Marks", "English");
                dataset.setValue(marksList.get(1).getMarks_scored(), "Marks", "Nepali");
                dataset.setValue(marksList.get(2).getMarks_scored(), "Marks", "Maths");
                dataset.setValue(marksList.get(3).getMarks_scored(), "Marks", "Science");
                dataset.setValue(marksList.get(4).getMarks_scored(), "Marks", "GK");
                
            }   
            
        JFreeChart chart = ChartFactory.createBarChart("Student Score", "Subjects", "Marks", dataset, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.black);
        ChartFrame f = new ChartFrame("Bar Chart for Student", chart);
        
        f.setLocation(size.width/2 - getWidth()/2+400, (size.height/2 - getHeight()/2)+160);
        f.setVisible(true);
        f.setSize(650,450);
        }catch(Exception ex){
            System.out.println(ex);
        }   
    }//GEN-LAST:event_jButton_viewPerformanceActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PrinterJob job = PrinterJob.getPrinterJob();
            job.setJobName("Print Data");
            
            job.setPrintable(new Printable(){
            public int print(Graphics pg,PageFormat pf, int pageNum){
                    pf.setOrientation(PageFormat.LANDSCAPE);
                 if(pageNum > 0){
                    return Printable.NO_SUCH_PAGE;
                }
                
                Graphics2D g2 = (Graphics2D)pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                g2.scale(0.80,0.80);
                
                jPanel_print.print(g2);
         
               
                return Printable.PAGE_EXISTS;
                         
                
            }
    });
        boolean ok = job.printDialog();
        if(ok){
        try{    
        job.print();
        }catch (Exception ex){
            ex.printStackTrace();
            }
        }else{
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed
       
    public void showDetails(int std_id, int e_id){    
        try{           
            Connection conn = DBConnection.getConnection();
            String sql_view_result = "select s.subject_name,s.full_marks,s.pass_marks,r.marks_scored,r.remarks FROM ((((results as r inner join subjects as s on s.subject_id=r.subject_id) inner join students as std on r.student_id=std.student_id) inner join exams as e on r.exam_id=e.exam_id) inner join grades as g on g.g_id=r.g_id) where r.student_id=? && r.exam_id=?";
            PreparedStatement pst = conn.prepareStatement(sql_view_result);
            pst.setInt(1, std_id);
            pst.setInt(2, e_id);
            
            ResultSet res = pst.executeQuery();
            
           jTable_result.setModel(DbUtils.resultSetToTableModel(res));
        }catch(Exception ex){
            System.out.println(ex);
            
        }
        
    }
    public void showstudentDetails(int std_id, int e_id){
        String name, roll_no, grade, exam, result_date;
        
        try{
            Connection conn = DBConnection.getConnection();
            String sql_view_student = "select std.student_id, std.roll_no,std.first_name, std.middle_name, std.last_name, e.exam_name,g.grade_name,r.result_date FROM ((((results as r inner join subjects as s on s.subject_id=r.subject_id) inner join students as std on r.student_id=std.student_id) inner join exams as e on r.exam_id=e.exam_id) inner join grades as g on g.g_id=r.g_id) where r.student_id=? && r.exam_id=?";
            PreparedStatement pst = conn.prepareStatement(sql_view_student);
            pst.setInt(1, std_id);
            pst.setInt(2, e_id);
            
            ResultSet res = pst.executeQuery();
            
            while(res.next()){
                Students obb = new Students();
                obb.setFull_name(res.getString("first_name")+" "+res.getString("middle_name")+" "+res.getString("last_name"));
                obb.setRoll_no(res.getString("roll_no"));
                
               
                roll_no = res.getString("roll_no");
                name = res.getString("first_name")+" "+res.getString("middle_name")+" "+res.getString("last_name");
                grade = res.getString("grade_name");
                exam = res.getString("exam_name");
                result_date = res.getString("result_date");
                
                
                
                jLabel_name.setText(name);
                jLabel_roll.setText(roll_no);
                jLabel_grade.setText(grade);
                jLabel_exam.setText(exam);
                jLabel_date.setText(result_date);
            }
            
            
            
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    public void calculate(int std_id, int e_id){
        int total_marks_scored;
        try{
            Connection conn = DBConnection.getConnection();
            
            String sql = "SELECT SUM(marks_scored) FROM results WHERE student_id=? && exam_id=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, std_id);
            pst.setInt(2, e_id);
            
            ResultSet res = pst.executeQuery();
            
            if(res.next()){
                total_marks_scored = res.getInt("SUM(marks_scored)");
                int percentage = total_marks_scored /5;
                jLabel_total_marks.setText(""+total_marks_scored);
                
                jLabel_percentage.setText(percentage+"%");
                
            }else{
                
            }
            
            
            
            conn.close();
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private static javax.swing.JButton jButton_View;
    private javax.swing.JButton jButton_viewPerformance;
    private javax.swing.JComboBox<String> jComboBox_endDate;
    private javax.swing.JComboBox<String> jComboBox_examName;
    private javax.swing.JComboBox<String> jComboBox_grade;
    private javax.swing.JComboBox<String> jComboBox_startDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_date;
    private javax.swing.JLabel jLabel_exam;
    private javax.swing.JLabel jLabel_grade;
    private javax.swing.JLabel jLabel_name;
    private javax.swing.JLabel jLabel_percentage;
    private javax.swing.JLabel jLabel_roll;
    private javax.swing.JLabel jLabel_total_marks;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel_print;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_result;
    private javax.swing.JTextField jTextField_roll;
    // End of variables declaration//GEN-END:variables
}
