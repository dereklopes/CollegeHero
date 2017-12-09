import java.awt.Color;
import java.sql.Date;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class StaffUI extends javax.swing.JFrame {
    public int ID = 0;
    Color blue = new Color(0,0,153);
    Color yellow = new Color(255,255,0);
    /**
     * Creates new form staff
     */
    public StaffUI(Integer sID) {
        initComponents();
        ID = sID;
        getContentPane().setBackground(blue);
        this.setTitle("Course Hero: Staff - " + ID);
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

        logAttendanceButton = new javax.swing.JButton();
        studentAttendanceButton = new javax.swing.JButton();
        studentsBySecButton = new javax.swing.JButton();
        studentsByClassButton = new javax.swing.JButton();
        studentsTuitionButton = new javax.swing.JButton();
        scheduleButton = new javax.swing.JButton();
        roomScheduleButton = new javax.swing.JButton();
        staffByNameButton = new javax.swing.JButton();
        staffByTypeButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        searchTextArea = new javax.swing.JTextArea();
        changeInstrButton = new javax.swing.JButton();
        createClassButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        logAttendanceButton.setBackground(new java.awt.Color(255, 255, 0));
        logAttendanceButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        logAttendanceButton.setText("Log Attendance");
        logAttendanceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logAttendanceButtonActionPerformed(evt);
            }
        });

        studentAttendanceButton.setBackground(new java.awt.Color(255, 255, 0));
        studentAttendanceButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        studentAttendanceButton.setText("Get Student Attendance");
        studentAttendanceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentAttendanceButtonActionPerformed(evt);
            }
        });

        studentsBySecButton.setBackground(new java.awt.Color(255, 255, 0));
        studentsBySecButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        studentsBySecButton.setText("Get Students by Section");
        studentsBySecButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentsBySecButtonActionPerformed(evt);
            }
        });

        studentsByClassButton.setBackground(new java.awt.Color(255, 255, 0));
        studentsByClassButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        studentsByClassButton.setText("Get Students by Class");
        studentsByClassButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentsByClassButtonActionPerformed(evt);
            }
        });

        studentsTuitionButton.setBackground(new java.awt.Color(255, 255, 0));
        studentsTuitionButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        studentsTuitionButton.setText("Get Students with Tuition");
        studentsTuitionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentsTuitionButtonActionPerformed(evt);
            }
        });

        scheduleButton.setBackground(new java.awt.Color(255, 255, 0));
        scheduleButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        scheduleButton.setText("Get Staff Schedule");
        scheduleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scheduleButtonActionPerformed(evt);
            }
        });

        roomScheduleButton.setBackground(new java.awt.Color(255, 255, 0));
        roomScheduleButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        roomScheduleButton.setText("Get Room Schedule");
        roomScheduleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomScheduleButtonActionPerformed(evt);
            }
        });

        staffByNameButton.setBackground(new java.awt.Color(255, 255, 0));
        staffByNameButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        staffByNameButton.setText("Get Staff by Name");
        staffByNameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffByNameButtonActionPerformed(evt);
            }
        });

        staffByTypeButton.setBackground(new java.awt.Color(255, 255, 0));
        staffByTypeButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        staffByTypeButton.setText("Get Staff by Type");
        staffByTypeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffByTypeButtonActionPerformed(evt);
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

        searchTextArea.setEditable(false);
        searchTextArea.setColumns(20);
        searchTextArea.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        searchTextArea.setRows(5);
        jScrollPane1.setViewportView(searchTextArea);

        changeInstrButton.setBackground(new java.awt.Color(255, 255, 0));
        changeInstrButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        changeInstrButton.setText("Change Class Instructor");
        changeInstrButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeInstrButtonActionPerformed(evt);
            }
        });

        createClassButton.setBackground(new java.awt.Color(255, 255, 0));
        createClassButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        createClassButton.setText("Create New Class");
        createClassButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createClassButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(studentAttendanceButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logAttendanceButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(studentsBySecButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(studentsByClassButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(studentsTuitionButton, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(createClassButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(changeInstrButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scheduleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roomScheduleButton, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(staffByNameButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(staffByTypeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logoutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
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
                            .addComponent(changeInstrButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(createClassButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(logAttendanceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(scheduleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(studentAttendanceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(roomScheduleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(studentsBySecButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(staffByNameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(studentsByClassButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(staffByTypeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(studentsTuitionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logAttendanceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logAttendanceButtonActionPerformed
        // Dialog to log attendance
        int sID = 0;
        int cID = 0;
        int sec = 0;
        Date day;
        JTextField sIDField = new JTextField(10);
        JTextField cIDField = new JTextField(10);
        JTextField secField = new JTextField(10);
        JTextField dayField = new JTextField(10);
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Student ID:"));
        myPanel.add(sIDField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("Class ID:"));
        myPanel.add(cIDField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("Section Number:"));
        myPanel.add(secField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("Class Day:"));
        myPanel.add(dayField);
        int result = JOptionPane.showConfirmDialog(null, myPanel,
            "Please Enter Class and Section Numbers", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
          sID = Integer.parseInt(sIDField.getText());
          cID = Integer.parseInt(cIDField.getText());
          sec = Integer.parseInt(secField.getText());
          day = Date.valueOf(dayField.getText());
          if(DatabaseConnector.logAttendance(sID,cID,sec,day)){
              JOptionPane.showMessageDialog(null,
                            "Successfully logged attendance",
                            "Log Attendance",
                            JOptionPane.INFORMATION_MESSAGE);
          }
          else{
              JOptionPane.showMessageDialog(null,
                            "Error: Failed to log attendance",
                            "Log Attendance",
                            JOptionPane.INFORMATION_MESSAGE);
          
          }
        }
        
    }//GEN-LAST:event_logAttendanceButtonActionPerformed

    private void studentAttendanceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentAttendanceButtonActionPerformed
        // Dialog to enter sID to search
        String sID = (String) JOptionPane.showInputDialog(this, 
                "Enter Staff Name to Search",
                "Search Staff by Name",JOptionPane.PLAIN_MESSAGE);
        int id = Integer.parseInt(sID);
        if(!sID.equals("")){
            String result = DatabaseConnector.getStudentAttendance(id);
            searchTextArea.setText(result);
        }
    }//GEN-LAST:event_studentAttendanceButtonActionPerformed

    private void studentsBySecButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentsBySecButtonActionPerformed
        // Dialog to enter class ID and section to search
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
          searchTextArea.setText(DatabaseConnector.getStudentsEnrolledInSection(cID, sec));
        }
    }//GEN-LAST:event_studentsBySecButtonActionPerformed

    private void studentsByClassButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentsByClassButtonActionPerformed
        // Dialog to enter cID to search
        String cID = (String) JOptionPane.showInputDialog(this, 
                "Enter Class ID to Search",
                "Search Students by Class ID",JOptionPane.PLAIN_MESSAGE);
        int id = Integer.parseInt(cID);
        if(!cID.equals("")){
            String result = DatabaseConnector.getAllStudentsEnrolledInClass(id);
            searchTextArea.setText(result);
        }
    }//GEN-LAST:event_studentsByClassButtonActionPerformed

    private void studentsTuitionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentsTuitionButtonActionPerformed
        searchTextArea.setText(DatabaseConnector.getStudentsOwingTuition());
    }//GEN-LAST:event_studentsTuitionButtonActionPerformed

    private void scheduleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scheduleButtonActionPerformed
        searchTextArea.setText(DatabaseConnector.getStaffSchedule(ID));
    }//GEN-LAST:event_scheduleButtonActionPerformed

    private void roomScheduleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomScheduleButtonActionPerformed
       // Dialog to enter rID to search
        String rID = (String) JOptionPane.showInputDialog(this, 
                "Enter Room ID to Search",
                "Search Schedule by Room ID",JOptionPane.PLAIN_MESSAGE);
        int id = Integer.parseInt(rID);
        if(!rID.equals("")){
            String result = DatabaseConnector.getRoomSchedule(id);
            searchTextArea.setText(result);
        }
    }//GEN-LAST:event_roomScheduleButtonActionPerformed

    private void staffByNameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffByNameButtonActionPerformed
        // Dialog to enter name to search
        String name = (String) JOptionPane.showInputDialog(this, 
                "Enter Staff Name to Search",
                "Search Staff by Name",JOptionPane.PLAIN_MESSAGE);
        if(!name.equals("")){
            String result = DatabaseConnector.getStaffByName(name);
            searchTextArea.setText(result);
        }
    }//GEN-LAST:event_staffByNameButtonActionPerformed

    private void staffByTypeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffByTypeButtonActionPerformed
        // Dialog to enter type to search
        String type = (String) JOptionPane.showInputDialog(this, 
                "Enter Staff Type to Search",
                "Search Staff by Type",JOptionPane.PLAIN_MESSAGE);
        boolean typ;
        if(type.equals("0")){
            typ = false;
        }
        else{
            typ = true;
        }
        if(!type.equals("")){
            String result = DatabaseConnector.getStaffByType(typ);
            searchTextArea.setText(result);
        }
    }//GEN-LAST:event_staffByTypeButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        searchTextArea.setText("");
        dispose();
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void changeInstrButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeInstrButtonActionPerformed
        // Dialog to change instructor
        int cID = 0;
        int sec = 0;
        int tID = 0;
        JTextField cIDField = new JTextField(10);
        JTextField secField = new JTextField(10);
        JTextField tIDField = new JTextField(10);
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Class ID:"));
        myPanel.add(cIDField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("Section Number:"));
        myPanel.add(secField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("Instructor ID:"));
        myPanel.add(tIDField);
        int result = JOptionPane.showConfirmDialog(null, myPanel,
            "Please Enter Class, Section and Instructor Numbers", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
          cID = Integer.parseInt(cIDField.getText());
          sec = Integer.parseInt(secField.getText());
          tID = Integer.parseInt(tIDField.getText());
          if(DatabaseConnector.changeClassInstructor(cID,sec,tID)){
              JOptionPane.showMessageDialog(null,
                            "Successfully changed class instructor",
                            "Change Class Instructor",
                            JOptionPane.INFORMATION_MESSAGE);
          }
          else{
              JOptionPane.showMessageDialog(null,
                            "Error: Failed to change class instructor",
                            "Change Class Instructor",
                            JOptionPane.INFORMATION_MESSAGE);
          
          }
        }
    }//GEN-LAST:event_changeInstrButtonActionPerformed

    private void createClassButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createClassButtonActionPerformed
        NewClass newClass = new NewClass();
        newClass.setAlwaysOnTop(true);
        newClass.setVisible(true);
        newClass.setLocationRelativeTo(null);
        if(newClass.finished = true){
            JOptionPane.showMessageDialog(null,
                            "Successfully created a new class",
                            "Create a New Class",
                            JOptionPane.INFORMATION_MESSAGE);
            searchTextArea.setText(newClass.getResult());
          }
          else{
              JOptionPane.showMessageDialog(null,
                            "Error: Failed to create a new class",
                            "Create a New Class",
                            JOptionPane.INFORMATION_MESSAGE);
          
          }
        
    }//GEN-LAST:event_createClassButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton changeInstrButton;
    private javax.swing.JButton createClassButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logAttendanceButton;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton roomScheduleButton;
    private javax.swing.JButton scheduleButton;
    private javax.swing.JTextArea searchTextArea;
    private javax.swing.JButton staffByNameButton;
    private javax.swing.JButton staffByTypeButton;
    private javax.swing.JButton studentAttendanceButton;
    private javax.swing.JButton studentsByClassButton;
    private javax.swing.JButton studentsBySecButton;
    private javax.swing.JButton studentsTuitionButton;
    // End of variables declaration//GEN-END:variables
}
