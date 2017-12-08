import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Login extends javax.swing.JFrame {
    /**
     * Creates new form login
     */
    Color blue = new Color(0,0,153);
    Color yellow = new Color(255, 255, 0);
    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
        getContentPane().setBackground(blue);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchPhoneButton = new javax.swing.JButton();
        loginStaffButton = new javax.swing.JButton();
        loginStudentButton = new javax.swing.JButton();
        newStudentButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        newStudentButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CollegeHero v0.1 - CS157A Fall 2017");
        setBackground(new java.awt.Color(0, 0, 255));
        setForeground(new java.awt.Color(0, 0, 204));
        setLocation(new java.awt.Point(0, 0));

        searchPhoneButton.setBackground(new java.awt.Color(255, 255, 0));
        searchPhoneButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        searchPhoneButton.setText("Search for ID by phone");
        searchPhoneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchPhoneButtonActionPerformed(evt);
            }
        });

        loginStaffButton.setBackground(new java.awt.Color(255, 255, 0));
        loginStaffButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        loginStaffButton.setText("Login as Staff");
        loginStaffButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginStaffButtonActionPerformed(evt);
            }
        });

        loginStudentButton.setBackground(new java.awt.Color(255, 255, 0));
        loginStudentButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        loginStudentButton.setText("Login as Student");
        loginStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginStudentButtonActionPerformed(evt);
            }
        });

        newStudentButton.setBackground(new java.awt.Color(255, 255, 0));
        newStudentButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        newStudentButton.setText("Register as new Student");
        newStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newStudentButtonActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Spartans_logo.jpg"))); // NOI18N

        newStudentButton1.setBackground(new java.awt.Color(255, 255, 0));
        newStudentButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        newStudentButton1.setText("Search for phone by ID");
        newStudentButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newStudentButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(loginStudentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(loginStaffButton, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(newStudentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchPhoneButton, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newStudentButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchPhoneButton, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(newStudentButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(newStudentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginStudentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginStaffButton, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginStudentButtonActionPerformed
        LoginDialog loginDlg = new LoginDialog(this, "student");
        loginDlg.setVisible(true);
        // if logon successfully
        if(loginDlg.isSucceeded()){
            //show studentUI for logged in user
            StudentUI student = new StudentUI(loginDlg.getID());
            student.setVisible(true);
            student.setAlwaysOnTop(true);
        }
    }//GEN-LAST:event_loginStudentButtonActionPerformed

    private void loginStaffButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginStaffButtonActionPerformed
        LoginDialog loginDlg = new LoginDialog(this, "staff");
        loginDlg.setVisible(true);
        // if logon successfully
        if(loginDlg.isSucceeded()){
            //show staffUI for logged in user
            StaffUI staff = new StaffUI(loginDlg.getID());
            staff.setVisible(true);
            staff.setLocationRelativeTo(null);
            staff.setAlwaysOnTop(true);
        }
    }//GEN-LAST:event_loginStaffButtonActionPerformed

    private void newStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newStudentButtonActionPerformed
        NewStudent newStudent = new NewStudent();
        newStudent.setVisible(true);
        newStudent.setAlwaysOnTop(true);
        newStudent.setLocationRelativeTo(null);
    }//GEN-LAST:event_newStudentButtonActionPerformed

    private void searchPhoneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchPhoneButtonActionPerformed
        SearchPhone phone = new SearchPhone();
        phone.setVisible(true);
        phone.setAlwaysOnTop(true);
        phone.setLocationRelativeTo(null);
    }//GEN-LAST:event_searchPhoneButtonActionPerformed

    private void newStudentButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newStudentButton1ActionPerformed
        SearchID id = new SearchID();
        id.setVisible(true);
        id.setAlwaysOnTop(true);
        id.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_newStudentButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton loginStaffButton;
    private javax.swing.JButton loginStudentButton;
    private javax.swing.JButton newStudentButton;
    private javax.swing.JButton newStudentButton1;
    private javax.swing.JButton searchPhoneButton;
    // End of variables declaration//GEN-END:variables
}
