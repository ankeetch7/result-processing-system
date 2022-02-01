/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resultmgt.view;

import com.resultmgt.controller.StudentDAO;
import com.resultmgt.controller.UserDAO;
import com.resultmgt.model.Students;
import java.awt.Dimension;
import java.awt.Toolkit;
import static java.lang.Thread.sleep;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author AnkitPC
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        desktop.setSize(size.width, size.height);
        
        // for clock
        clock();
        
        // to show login in first desktop
        Login ob = new Login();
        desktop.add(ob);
        ob.setVisible(true);
        
        
       jMenu_Records.setEnabled(false);
       Main.jMenu2.setEnabled(false);
       
        
       
    }
    
    
    // display time and date in main frame
    public void clock(){
        Thread clock=new Thread()
                {
                public void run()
                {
                    try {
                   while(true)
                       {
                        Calendar cal=new GregorianCalendar();
                        int day=cal.get(Calendar.DAY_OF_MONTH);
                        int month=cal.get(Calendar.MONTH)+1;
                        int year=cal.get(Calendar.YEAR);

                        int second=cal.get(Calendar.SECOND);
                        int minute=cal.get(Calendar.MINUTE);
                        int hour=cal.get(Calendar.HOUR);
                        int am_pm = cal.get(Calendar.AM_PM);
                        String ampm = "ampm";
                        if (am_pm == 0) {
                            ampm = "AM";
                        } else {
                            ampm = "PM";
                        }

                        jLabel_time.setText( hour +":"+ minute +":"+ second+" "+ampm);
                        jLabel_date.setText( year +"-"+ month +"-"+ day );
                      //  getTime=lbltime.getText();
                       // getDate=lbldate.getText();
                                        sleep(1000);
                        }
                    } catch (InterruptedException ex) {
                       // Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                       
                    }
                }
            };
        clock.start();
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
        desktop = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel_time = new javax.swing.JLabel();
        jLabel_date = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu_Records = new javax.swing.JMenu();
        jMenuItem_ManageStudent = new javax.swing.JMenuItem();
        jMenuItem_ManageSubjects = new javax.swing.JMenuItem();
        jMenuItem_ManageExams = new javax.swing.JMenuItem();
        jMenuItem_createResult = new javax.swing.JMenuItem();
        jMenuItem_viewResult = new javax.swing.JMenuItem();
        jMenuItem_logout = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem_addUser = new javax.swing.JMenuItem();
        jMenuItem_addRole = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Parijat Sikshya Niketan");
        setMinimumSize(new java.awt.Dimension(1364, 740));

        jPanel2.setBackground(new java.awt.Color(0, 185, 205));

        jLabel_time.setFont(new java.awt.Font("Serif", 1, 16)); // NOI18N
        jLabel_time.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_time.setText("Time");

        jLabel_date.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        jLabel_date.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_date.setText("Date");

        jLabel1.setFont(new java.awt.Font("Serif", 3, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Result Processing System");

        jLabel2.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Time:");

        jLabel3.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Date:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 229, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_time)
                .addGap(35, 35, 35)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_date)
                .addGap(31, 31, 31))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel_time)
                    .addComponent(jLabel_date)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        desktop.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 506, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jMenuBar1.setPreferredSize(new java.awt.Dimension(120, 30));

        jMenu_Records.setText("Records");
        jMenu_Records.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jMenu_Records.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu_RecordsActionPerformed(evt);
            }
        });

        jMenuItem_ManageStudent.setFont(new java.awt.Font("Serif", 1, 16)); // NOI18N
        jMenuItem_ManageStudent.setText("Manage Student");
        jMenuItem_ManageStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_ManageStudentActionPerformed(evt);
            }
        });
        jMenu_Records.add(jMenuItem_ManageStudent);

        jMenuItem_ManageSubjects.setFont(new java.awt.Font("Serif", 1, 16)); // NOI18N
        jMenuItem_ManageSubjects.setText("Manage Subjects");
        jMenuItem_ManageSubjects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_ManageSubjectsActionPerformed(evt);
            }
        });
        jMenu_Records.add(jMenuItem_ManageSubjects);

        jMenuItem_ManageExams.setFont(new java.awt.Font("Serif", 1, 16)); // NOI18N
        jMenuItem_ManageExams.setText("Manage Exams");
        jMenuItem_ManageExams.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_ManageExamsActionPerformed(evt);
            }
        });
        jMenu_Records.add(jMenuItem_ManageExams);

        jMenuItem_createResult.setFont(new java.awt.Font("Serif", 1, 16)); // NOI18N
        jMenuItem_createResult.setText("Create Result");
        jMenuItem_createResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_createResultActionPerformed(evt);
            }
        });
        jMenu_Records.add(jMenuItem_createResult);

        jMenuItem_viewResult.setFont(new java.awt.Font("Serif", 1, 16)); // NOI18N
        jMenuItem_viewResult.setText("View Result");
        jMenuItem_viewResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_viewResultActionPerformed(evt);
            }
        });
        jMenu_Records.add(jMenuItem_viewResult);

        jMenuItem_logout.setFont(new java.awt.Font("Serif", 1, 16)); // NOI18N
        jMenuItem_logout.setText("Exit");
        jMenuItem_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_logoutActionPerformed(evt);
            }
        });
        jMenu_Records.add(jMenuItem_logout);

        jMenuBar1.add(jMenu_Records);

        jMenu2.setText("Application");
        jMenu2.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N

        jMenuItem_addUser.setFont(new java.awt.Font("Serif", 1, 16)); // NOI18N
        jMenuItem_addUser.setText("Manage User");
        jMenuItem_addUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_addUserActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem_addUser);

        jMenuItem_addRole.setFont(new java.awt.Font("Serif", 1, 16)); // NOI18N
        jMenuItem_addRole.setText("Add Role");
        jMenuItem_addRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_addRoleActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem_addRole);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

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

        setBounds(0, 0, 759, 628);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem_ManageStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_ManageStudentActionPerformed
       ManageStudent ob = new ManageStudent();
       desktop.add(ob);
       ob.setVisible(true);
    }//GEN-LAST:event_jMenuItem_ManageStudentActionPerformed

    private void jMenuItem_addRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_addRoleActionPerformed
        AddRole ob = new AddRole();
        desktop.add(ob);
        ob.setVisible(true);
    }//GEN-LAST:event_jMenuItem_addRoleActionPerformed

    private void jMenuItem_addUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_addUserActionPerformed
        ManageUser ob = new ManageUser();
        desktop.add(ob);
        ob.setVisible(true);
    }//GEN-LAST:event_jMenuItem_addUserActionPerformed

    private void jMenuItem_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_logoutActionPerformed
        int option = JOptionPane.showConfirmDialog(
			null, 
			"Are you sure you want to close the application?",
			"Close Confirmation", 
			JOptionPane.YES_NO_OPTION, 
			JOptionPane.QUESTION_MESSAGE);
                    if (option == JOptionPane.YES_OPTION) {
			System.exit(0);
                        
                }
        
    }//GEN-LAST:event_jMenuItem_logoutActionPerformed

    private void jMenuItem_ManageSubjectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_ManageSubjectsActionPerformed
        ManageSubjects ob = new ManageSubjects();
        desktop.add(ob);
        ob.setVisible(true);
    }//GEN-LAST:event_jMenuItem_ManageSubjectsActionPerformed

    private void jMenuItem_createResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_createResultActionPerformed

            CreateResult ob = new CreateResult();
            desktop.add(ob);
            ob.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem_createResultActionPerformed

    private void jMenuItem_ManageExamsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_ManageExamsActionPerformed
        ManageExam ob = new ManageExam();
        desktop.add(ob);
        ob.setVisible(true);
    }//GEN-LAST:event_jMenuItem_ManageExamsActionPerformed

    private void jMenuItem_viewResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_viewResultActionPerformed
        ViewResult ob = new ViewResult();
        desktop.add(ob);
        ob.setVisible(true);
    }//GEN-LAST:event_jMenuItem_viewResultActionPerformed

    private void jMenu_RecordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu_RecordsActionPerformed
        
    }//GEN-LAST:event_jMenu_RecordsActionPerformed

   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane desktop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel_date;
    private javax.swing.JLabel jLabel_time;
    public static javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem_ManageExams;
    private javax.swing.JMenuItem jMenuItem_ManageStudent;
    private javax.swing.JMenuItem jMenuItem_ManageSubjects;
    private javax.swing.JMenuItem jMenuItem_addRole;
    private javax.swing.JMenuItem jMenuItem_addUser;
    private javax.swing.JMenuItem jMenuItem_createResult;
    private javax.swing.JMenuItem jMenuItem_logout;
    private javax.swing.JMenuItem jMenuItem_viewResult;
    public static javax.swing.JMenu jMenu_Records;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
