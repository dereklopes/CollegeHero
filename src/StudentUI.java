import java.awt.Color;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class StudentUI extends javax.swing.JFrame {
    public int ID = 0;
    Color blue = new Color(0,0,153);
    Color yellow = new Color(255,255,0);
    /**
     * Creates new form student
     */
    public StudentUI(Integer sID) {
        initComponents();
        ID = sID;
        getContentPane().setBackground(blue);
        this.setTitle("Course Hero: Student - " + ID);
        this.setLocationRelativeTo(null);
        UIManager UI = new UIManager();
        UI.put("OptionPane.background",blue);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        searchTextArea = new javax.swing.JTextArea();
        searchIDButton = new javax.swing.JButton();
        tuitionButton = new javax.swing.JButton();
        searchSubjectButton = new javax.swing.JButton();
        searchIDSecButton = new javax.swing.JButton();
        scheduleButton = new javax.swing.JButton();
        changePhoneButton = new javax.swing.JButton();
        changePassButton = new javax.swing.JButton();
        enrollButton = new javax.swing.JButton();
        unenrollButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        searchTextArea.setEditable(false);
        searchTextArea.setColumns(20);
        searchTextArea.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        searchTextArea.setRows(5);
        jScrollPane1.setViewportView(searchTextArea);

        searchIDButton.setBackground(new java.awt.Color(255, 255, 0));
        searchIDButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        searchIDButton.setText("Search by Class ID");
        searchIDButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchIDButtonActionPerformed(evt);
            }
        });

        tuitionButton.setBackground(new java.awt.Color(255, 255, 0));
        tuitionButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tuitionButton.setText("Pay Tuition");
        tuitionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tuitionButtonActionPerformed(evt);
            }
        });

        searchSubjectButton.setBackground(new java.awt.Color(255, 255, 0));
        searchSubjectButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        searchSubjectButton.setText("Search by Class Subject");
        searchSubjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchSubjectButtonActionPerformed(evt);
            }
        });

        searchIDSecButton.setBackground(new java.awt.Color(255, 255, 0));
        searchIDSecButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        searchIDSecButton.setText("Search by ID and Section");
        searchIDSecButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchIDSecButtonActionPerformed(evt);
            }
        });

        scheduleButton.setBackground(new java.awt.Color(255, 255, 0));
        scheduleButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        scheduleButton.setText("Get Schedule");
        scheduleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scheduleButtonActionPerformed(evt);
            }
        });

        changePhoneButton.setBackground(new java.awt.Color(255, 255, 0));
        changePhoneButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        changePhoneButton.setText("Change Phone Number");
        changePhoneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePhoneButtonActionPerformed(evt);
            }
        });

        changePassButton.setBackground(new java.awt.Color(255, 255, 0));
        changePassButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        changePassButton.setText("Change Password");
        changePassButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePassButtonActionPerformed(evt);
            }
        });

        enrollButton.setBackground(new java.awt.Color(255, 255, 0));
        enrollButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        enrollButton.setText("Enroll");
        enrollButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enrollButtonActionPerformed(evt);
            }
        });

        unenrollButton.setBackground(new java.awt.Color(255, 255, 0));
        unenrollButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        unenrollButton.setText("Unenroll");
        unenrollButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unenrollButtonActionPerformed(evt);
            }
        });

        logoutButton.setBackground(new java.awt.Color(255, 255, 0));
        logoutButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchIDSecButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(changePhoneButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(changePassButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchSubjectButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchIDButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scheduleButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(unenrollButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(enrollButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tuitionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(49, 49, 49))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tuitionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(enrollButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(unenrollButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(16, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchIDButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(searchSubjectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(searchIDSecButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(scheduleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(changePhoneButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(changePassButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchSubjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchSubjectButtonActionPerformed
        // Dialog to enter subject to search
        String sub = (String) JOptionPane.showInputDialog(this, 
                "Enter Class Subject to Search",
                "Search Class Subject",JOptionPane.PLAIN_MESSAGE);
        if(!sub.equals("")){
            String result = DatabaseConnector.getAllSectionInfoBySubject(sub);
            if(!result.equals("")){
                searchTextArea.setText(result);
            }
        }
    }//GEN-LAST:event_searchSubjectButtonActionPerformed

    private void searchIDButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchIDButtonActionPerformed
        // Dialog to enter class ID to search
        String cID = (String) JOptionPane.showInputDialog(this, 
                "Enter Class ID to Search",
                "Search Class ID",JOptionPane.PLAIN_MESSAGE);
        int id = Integer.parseInt(cID);
        if(!cID.equals("")){
            String result = DatabaseConnector.getAllSectionInfoByClassID(id);
            if(!result.equals("")){
                searchTextArea.setText(result);
            }
        }
    }//GEN-LAST:event_searchIDButtonActionPerformed

    private void tuitionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tuitionButtonActionPerformed
        // Dialog to display remaining tuition
        int tuition = DatabaseConnector.payTuition(ID,0);
        JOptionPane.showMessageDialog(null,
                            "Current Tuition Amount Owed: " + tuition,
                            "Tuition",
                            JOptionPane.INFORMATION_MESSAGE);
        // Dialog to pay tuition
        String pay = (String) JOptionPane.showInputDialog(this, 
                "Enter Payment Amount",
                "Pay Tuition",JOptionPane.PLAIN_MESSAGE);
        int payment = Integer.parseInt(pay);
        if(!pay.equals("")){
            int result = DatabaseConnector.payTuition(ID,payment);
            if(result != -1){
                searchTextArea.setText("Remaining Tuition = " + result);
            }
            else{
                searchTextArea.setText("Failed to Pay Tuition");
            }
        }
    }//GEN-LAST:event_tuitionButtonActionPerformed

    private void searchIDSecButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchIDSecButtonActionPerformed
        // Dialog to enter subject to search
        int cID = 0;
        int sec = 0;
        JTextField cIDField = new JTextField(10);
        JTextField secField = new JTextField(10);
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Class ID:"));
        myPanel.add(cIDField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("Section Number:"));
        myPanel.add(secField);
        int result = JOptionPane.showConfirmDialog(null, myPanel,
            "Please Enter Class and Section Numbers", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
          cID = Integer.parseInt(cIDField.getText());
          sec = Integer.parseInt(secField.getText());
          searchTextArea.setText(DatabaseConnector.getClassByIDAndSection(cID, sec));
        }
    }//GEN-LAST:event_searchIDSecButtonActionPerformed

    private void scheduleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scheduleButtonActionPerformed
        searchTextArea.setText(DatabaseConnector.getStudentSchedule(ID));
    }//GEN-LAST:event_scheduleButtonActionPerformed

    private void changePhoneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePhoneButtonActionPerformed
        // Dialog to change phone number
        String phone = (String) JOptionPane.showInputDialog(this, 
                "Enter New Phone Number",
                "Change Phone Number",JOptionPane.PLAIN_MESSAGE);
        if(!phone.equals("")){
            String result = DatabaseConnector.changeStudentPhone(ID,phone);
            if(!result.equals("") && (!result.equals("Error.") && !result.equals("Error setting phone."))){
                JOptionPane.showMessageDialog(null,
                            "Successfully changed phone number",
                            "Change Phone Number",
                            JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null,
                            "Error: Failed to change phone number",
                            "Change Phone Number",
                            JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_changePhoneButtonActionPerformed

    private void changePassButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePassButtonActionPerformed
        // Dialog to change password
        String pass = (String) JOptionPane.showInputDialog(this, 
                "Enter New Password",
                "Change Password",JOptionPane.PLAIN_MESSAGE);
        if(!pass.equals("")){
            boolean result = DatabaseConnector.changeStudentPassword(ID,pass);
            if(result){
                JOptionPane.showMessageDialog(null,
                            "Successfully changed password",
                            "Change Password",
                            JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null,
                            "Error: Failed to change password",
                            "Change Password",
                            JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_changePassButtonActionPerformed

    private void enrollButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enrollButtonActionPerformed
        // Dialog to enroll in class
        int cID = 0;
        int sec = 0;
        JTextField cIDField = new JTextField(10);
        JTextField secField = new JTextField(10);
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Class ID:"));
        myPanel.add(cIDField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("Section Number:"));
        myPanel.add(secField);
        int result = JOptionPane.showConfirmDialog(null, myPanel,
            "Please Enter Class and Section Numbers", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
          cID = Integer.parseInt(cIDField.getText());
          sec = Integer.parseInt(secField.getText());
          if(DatabaseConnector.enrollInClass(ID,cID,sec)){
              JOptionPane.showMessageDialog(null,
                            "Successfully enrolled",
                            "Enroll",
                            JOptionPane.INFORMATION_MESSAGE);
              searchTextArea.setText(DatabaseConnector.getStudentSchedule(ID));
          }
          else{
              JOptionPane.showMessageDialog(null,
                            "Error: Failed to enroll",
                            "Enroll",
                            JOptionPane.INFORMATION_MESSAGE);
          }
        }
    }//GEN-LAST:event_enrollButtonActionPerformed

    private void unenrollButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unenrollButtonActionPerformed
        // Dialog to unenroll in class
        int cID = 0;
        int sec = 0;
        JTextField cIDField = new JTextField(10);
        JTextField secField = new JTextField(10);
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Class ID:"));
        myPanel.add(cIDField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("Section Number:"));
        myPanel.add(secField);
        int result = JOptionPane.showConfirmDialog(null, myPanel,
            "Please Enter Class and Section Numbers", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
          cID = Integer.parseInt(cIDField.getText());
          sec = Integer.parseInt(secField.getText());
          if(DatabaseConnector.unEnrollInClass(ID,cID,sec)){
              JOptionPane.showMessageDialog(null,
                            "Successfully unenrolled",
                            "Unenroll",
                            JOptionPane.INFORMATION_MESSAGE);
              searchTextArea.setText(DatabaseConnector.getStudentSchedule(ID));
          }
          else{
              JOptionPane.showMessageDialog(null,
                            "Error: Failed to unenroll",
                            "Unenroll",
                            JOptionPane.INFORMATION_MESSAGE);
          }
        }
    }//GEN-LAST:event_unenrollButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        searchTextArea.setText("");
        dispose();
    }//GEN-LAST:event_logoutButtonActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton changePassButton;
    private javax.swing.JButton changePhoneButton;
    private javax.swing.JButton enrollButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton scheduleButton;
    private javax.swing.JButton searchIDButton;
    private javax.swing.JButton searchIDSecButton;
    private javax.swing.JButton searchSubjectButton;
    private javax.swing.JTextArea searchTextArea;
    private javax.swing.JButton tuitionButton;
    private javax.swing.JButton unenrollButton;
    // End of variables declaration//GEN-END:variables
}
