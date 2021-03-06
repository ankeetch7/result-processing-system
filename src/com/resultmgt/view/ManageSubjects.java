/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resultmgt.view;

import com.resultmgt.controller.GradeDAO;
import com.resultmgt.controller.SubjectDAO;
import com.resultmgt.model.Grades;
import com.resultmgt.model.Subjects;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ankeet
 */
public class ManageSubjects extends javax.swing.JInternalFrame {

    // to view students data in jtable
    String cols[]={"Subject ID","Subject Name","Full Marks","Pass Marks"};
    DefaultTableModel model;
    
    /**
     * Creates new form ManageSubjects
     */
    public ManageSubjects() {
        initComponents();
        
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        //setLocation(size.width/2 - getWidth()/2, (size.height/2 - getHeight()/2)-50);
        setSize(size.width, size.height);
        
        jPanel2.setSize(size.width, size.height);
        jTabbedPane1.setSize(size.width, size.height-10);
        
        // calling loadGrades()
        loadGrades();
                

        // for table
         model=new DefaultTableModel(null,cols);
        jTable_viewSubjects.setModel(model);
        // load data in tables
        loadData();
        
    }
    
    // view user profile
    public void clearTableRows(){
        int rowCount=jTable_viewSubjects.getRowCount();
        for(int i=0;i<rowCount;i++){
            model.removeRow(0);
        }
    }
    
    public void loadData(){
        clearTableRows();
        SubjectDAO sDAO=new SubjectDAO();
        
        List<Subjects> subjectLists=sDAO.viewSubjects();
        
        if(subjectLists == null){
            
        }else{
                for(int i=0;i<subjectLists.size();i++){
                model.addRow(new Object[]{ 
                subjectLists.get(i).getSubject_id(),
                subjectLists.get(i).getSubject_name(),
                subjectLists.get(i).getFull_marks(),
                subjectLists.get(i).getPass_marks(),           
                
               });
            }
        }
    } 

    
    
     
    
    // load grades in add Subjects panel
    public void loadGrades(){
        GradeDAO gDAO = new GradeDAO();
                
        List<Grades> gradeLists=gDAO.viewGrades();
           
            if(gradeLists == null){
                jComboBox_Grades.addItem("Grades not added");
                jComboBox_ChooseGrades.addItem("Grades not added");
                jComboBox_eGrades.addItem("Grades not added");
                
            }else{
                for(int i=0;i<gradeLists.size();i++){
                jComboBox_Grades.addItem(gradeLists.get(i).getGrade_name());
                jComboBox_ChooseGrades.addItem(gradeLists.get(i).getGrade_name());
                 jComboBox_eGrades.addItem(gradeLists.get(i).getGrade_name());
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField_subjectName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jComboBox_Grades = new javax.swing.JComboBox<>();
        jButton_addSubjects = new javax.swing.JButton();
        jButton_Cancel = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextField_fullMarks = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField_passMarks = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jComboBox_ChooseGrades = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_viewSubjects = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextField_eSubjectId = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField_eSubjectName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox_eGrades = new javax.swing.JComboBox<>();
        jButton_Update = new javax.swing.JButton();
        jButton_Delete = new javax.swing.JButton();
        jButton_eCancel = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jTextField_efullMarks = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField_epassMarks = new javax.swing.JTextField();

        setClosable(true);

        jPanel1.setMinimumSize(new java.awt.Dimension(1350, 610));
        jPanel1.setPreferredSize(new java.awt.Dimension(1350, 610));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 185, 205));
        jPanel2.setPreferredSize(new java.awt.Dimension(620, 51));

        jLabel1.setFont(new java.awt.Font("Serif", 3, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Result Processing System");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1138, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1420, 40));

        jTabbedPane1.setFont(new java.awt.Font("Serif", 1, 16)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Serif", 3, 24)); // NOI18N
        jLabel2.setText("Add Subjects");

        jLabel3.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabel3.setText("Subject Name:");

        jTextField_subjectName.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabel4.setText("Grade:");

        jComboBox_Grades.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jComboBox_Grades.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Grade" }));

        jButton_addSubjects.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add-16.png"))); // NOI18N
        jButton_addSubjects.setText("Add");
        jButton_addSubjects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_addSubjectsActionPerformed(evt);
            }
        });

        jButton_Cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cancel.png"))); // NOI18N
        jButton_Cancel.setText("Cancel");
        jButton_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CancelActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabel9.setText("Full Marks:");

        jTextField_fullMarks.setEditable(false);
        jTextField_fullMarks.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jTextField_fullMarks.setText("100");

        jLabel10.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabel10.setText("Pass Marks:");

        jTextField_passMarks.setEditable(false);
        jTextField_passMarks.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jTextField_passMarks.setText("40");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel9)
                    .addComponent(jLabel4)
                    .addComponent(jLabel10))
                .addGap(46, 46, 46)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField_subjectName)
                    .addComponent(jComboBox_Grades, 0, 199, Short.MAX_VALUE)
                    .addComponent(jTextField_fullMarks)
                    .addComponent(jTextField_passMarks))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jButton_addSubjects)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(jButton_Cancel)
                .addGap(77, 77, 77))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField_subjectName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_Grades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jTextField_fullMarks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField_passMarks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addContainerGap(221, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_addSubjects)
                            .addComponent(jButton_Cancel))
                        .addGap(39, 39, 39))))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(469, 469, 469)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(593, 593, 593)
                        .addComponent(jLabel2)))
                .addContainerGap(530, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addGap(32, 32, 32)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Add Subjects", jPanel3);

        jComboBox_ChooseGrades.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jComboBox_ChooseGrades.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose Grade" }));
        jComboBox_ChooseGrades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_ChooseGradesActionPerformed(evt);
            }
        });

        jTable_viewSubjects.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable_viewSubjects.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_viewSubjectsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_viewSubjects);

        jLabel5.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabel5.setText("Subject ID:");

        jTextField_eSubjectId.setEditable(false);
        jTextField_eSubjectId.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabel6.setText("Subject Name:");

        jTextField_eSubjectName.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Serif", 3, 22)); // NOI18N
        jLabel7.setText("Edit Details");

        jLabel8.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabel8.setText("Grade:");

        jComboBox_eGrades.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jComboBox_eGrades.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Grade" }));

        jButton_Update.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jButton_Update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/available-updates-16 (1).png"))); // NOI18N
        jButton_Update.setText("Update");
        jButton_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_UpdateActionPerformed(evt);
            }
        });

        jButton_Delete.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jButton_Delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/delete-16 (1).png"))); // NOI18N
        jButton_Delete.setText("Delete");
        jButton_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DeleteActionPerformed(evt);
            }
        });

        jButton_eCancel.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jButton_eCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cancel.png"))); // NOI18N
        jButton_eCancel.setText("Cancel");
        jButton_eCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eCancelActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabel11.setText("Full Marks:");

        jTextField_efullMarks.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabel12.setText("Pass Marks:");

        jTextField_epassMarks.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jButton_Update)
                        .addGap(84, 84, 84)
                        .addComponent(jButton_Delete)
                        .addGap(61, 61, 61)
                        .addComponent(jButton_eCancel))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(72, 72, 72)
                                    .addComponent(jTextField_eSubjectId, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField_eSubjectName, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBox_eGrades, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField_efullMarks, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField_epassMarks, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(145, 145, 145)
                                .addComponent(jLabel7)))))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel7)
                .addGap(43, 43, 43)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField_eSubjectId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField_eSubjectName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBox_eGrades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_efullMarks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_epassMarks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Update)
                    .addComponent(jButton_Delete)
                    .addComponent(jButton_eCancel))
                .addGap(80, 80, 80))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jComboBox_ChooseGrades, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(172, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jComboBox_ChooseGrades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72))))
        );

        jTabbedPane1.addTab("Manage Subjects", jPanel4);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1410, 580));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_addSubjectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_addSubjectsActionPerformed
        
        String subject_name = jTextField_subjectName.getText().trim();
        String full_marks = jTextField_fullMarks.getText().trim();
        String pass_marks = jTextField_passMarks.getText().trim();
        String grade_name = jComboBox_Grades.getSelectedItem().toString();
        
        Grades gOb = new Grades();
        gOb.setGrade_name(grade_name);
        GradeDAO gDAO = new GradeDAO();
        
        int grade_id = gDAO.getGradeID(gOb);
        
        
        if(!subject_name.isEmpty() || !full_marks.isEmpty() || !pass_marks.isEmpty() || !grade_name.isEmpty()){
            String full_pattern = "[0-9]{3}";
            String pass_pattern = "[0-9]{2}";
            String string_validation = "^[a-zA-Z]+$";
            if(!subject_name.matches(string_validation)){
                // it has numbers in name fields
                JOptionPane.showMessageDialog(null, "Number cannot be addded to name fields!");
            }else{
                 if(full_marks.matches(full_pattern) && pass_marks.matches(pass_pattern)){
                
                Subjects sOb = new Subjects();
                sOb.setSubject_name(subject_name);
                sOb.setFull_marks(full_marks);
                sOb.setPass_marks(pass_marks);
                sOb.setG_id(grade_id);
                
                SubjectDAO sDAO = new SubjectDAO();
                
                if(sDAO.addSubjects(sOb) == 1){
                    JOptionPane.showMessageDialog(null,"Subjects added successfully!"); 
                    loadData();
                    reset();
                }else{
                    JOptionPane.showMessageDialog(null,"Subjects add failed!"); 
                }
                
                
            }else{
                JOptionPane.showMessageDialog(null,"Please insert integer number in Full Marks and Pass Marks Field!");
            }
            }
   
        }else{
            JOptionPane.showMessageDialog(null,"Fields are empty!");
        }
        
        
    }//GEN-LAST:event_jButton_addSubjectsActionPerformed

    private void jButton_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CancelActionPerformed
        dispose();
    }//GEN-LAST:event_jButton_CancelActionPerformed

    private void jComboBox_ChooseGradesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_ChooseGradesActionPerformed
        String grade_name  = jComboBox_ChooseGrades.getSelectedItem().toString();
        Grades gOb = new Grades();
        gOb.setGrade_name(grade_name);
        GradeDAO gDAO = new GradeDAO();
        int grade_id = gDAO.getGradeID(gOb);
        
         clearTableRows();
        SubjectDAO sDAO=new SubjectDAO();
        
        List<Subjects> subjectLists=sDAO.viewSpecificGradeSubjects(grade_id);
        
        if(subjectLists == null){
            
        }else{
                for(int i=0;i<subjectLists.size();i++){
                model.addRow(new Object[]{ 
                subjectLists.get(i).getSubject_id(),
                subjectLists.get(i).getSubject_name(),
                subjectLists.get(i).getFull_marks(),
                subjectLists.get(i).getPass_marks(),
                subjectLists.get(i).getG_id(),               
                
               });
            }
        }  
        
    }//GEN-LAST:event_jComboBox_ChooseGradesActionPerformed

    private void jTable_viewSubjectsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_viewSubjectsMouseClicked
         int subject_id = (int)jTable_viewSubjects.getValueAt(jTable_viewSubjects.getSelectedRow(), 0);
         Subjects sOb = new Subjects();
         sOb.setSubject_id(subject_id);
         SubjectDAO sDAO = new SubjectDAO();
          List<Subjects> subjectList = sDAO.viewSingleSubject(sOb);           
          try{
              
            jTextField_eSubjectId.setText(""+subjectList.get(0).getSubject_id()); 
            jTextField_eSubjectName.setText(""+subjectList.get(0).getSubject_name()); 
            jTextField_efullMarks.setText(""+subjectList.get(0).getFull_marks()); 
            jTextField_epassMarks.setText(""+subjectList.get(0).getPass_marks()); 
            jComboBox_eGrades.setSelectedIndex(subjectList.get(0).getG_id());
              
          }catch(Exception ex){
              System.out.println(ex);
          }
          
    }//GEN-LAST:event_jTable_viewSubjectsMouseClicked

    private void jButton_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_UpdateActionPerformed
         int subject_id = Integer.parseInt(jTextField_eSubjectId.getText());
        
        String subject_name = jTextField_eSubjectName.getText().trim();
        
        String full_marks = jTextField_efullMarks.getText().trim();
        String pass_marks = jTextField_epassMarks.getText().trim();
        String grade_name = jComboBox_eGrades.getSelectedItem().toString();
        String string_validation = "^[a-zA-Z]+$";
        if(!subject_name.matches(string_validation)){
            JOptionPane.showMessageDialog(null, "Number cannot be addded to name fields!");
        }else{
          Grades gOb = new Grades();
        gOb.setGrade_name(grade_name);
        GradeDAO gDAO = new GradeDAO();
        int grade_id = gDAO.getGradeID(gOb);
        
        Subjects sOb = new Subjects();
        sOb.setSubject_name(subject_name);
        sOb.setFull_marks(full_marks);
        sOb.setPass_marks(pass_marks);
        sOb.setG_id(grade_id);
        sOb.setSubject_id(subject_id);
        
        SubjectDAO sDAO = new SubjectDAO();
        if(sDAO.updateSubjects(sOb) == 1){
            JOptionPane.showMessageDialog(null, "Subjects updated successfully!");
            loadData();
        }else{
            JOptionPane.showMessageDialog(null, "Subjects updated failed!");
        }  
        } 
        
    }//GEN-LAST:event_jButton_UpdateActionPerformed

    private void jButton_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DeleteActionPerformed
        int subject_id = Integer.parseInt(jTextField_eSubjectId.getText());
        
        Subjects sOb = new Subjects();
        sOb.setSubject_id(subject_id);
        SubjectDAO sDAO = new SubjectDAO();
        
        if(sDAO.deleteSubjects(sOb) == 1){
            loadData();
            JOptionPane.showMessageDialog(null, "Subject deleted successfully!");
            eReset();
        }else{
            JOptionPane.showMessageDialog(null, "Subject deleted failed!");
        }
    }//GEN-LAST:event_jButton_DeleteActionPerformed

    private void jButton_eCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eCancelActionPerformed
        dispose();
    }//GEN-LAST:event_jButton_eCancelActionPerformed

    
    public void reset(){
        jTextField_subjectName.setText("");
//        jTextField_fullMarks.setText("");
//        jTextField_passMarks.setText("");
        jComboBox_Grades.setSelectedIndex(0);
        
    }
    
    public void eReset(){
        jTextField_eSubjectId.setText("");
        jTextField_eSubjectName.setText("");
        jTextField_efullMarks.setText("");
        jTextField_epassMarks.setText("");
        jComboBox_eGrades.setSelectedIndex(0);
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Cancel;
    private javax.swing.JButton jButton_Delete;
    private javax.swing.JButton jButton_Update;
    private javax.swing.JButton jButton_addSubjects;
    private javax.swing.JButton jButton_eCancel;
    private javax.swing.JComboBox<String> jComboBox_ChooseGrades;
    private javax.swing.JComboBox<String> jComboBox_Grades;
    private javax.swing.JComboBox<String> jComboBox_eGrades;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable_viewSubjects;
    private javax.swing.JTextField jTextField_eSubjectId;
    private javax.swing.JTextField jTextField_eSubjectName;
    private javax.swing.JTextField jTextField_efullMarks;
    private javax.swing.JTextField jTextField_epassMarks;
    private javax.swing.JTextField jTextField_fullMarks;
    private javax.swing.JTextField jTextField_passMarks;
    private javax.swing.JTextField jTextField_subjectName;
    // End of variables declaration//GEN-END:variables
}
