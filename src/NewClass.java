import java.awt.Color;
import java.sql.Date;
import java.sql.Time;

public class NewClass extends javax.swing.JFrame {
    public boolean finished = false;
    public int cID = 0;
    public int sec = 0;
    public String sub = "";
    public int tID = 0;
    public int rID = 0;
    public String days = "";
    public Time start;
    public Time end;
    public int cap;
    public int cost;
    Color blue = new Color(0,0,153);
    public String result ="";
    /**
     * Creates new form NewClass
     */
    public NewClass() {
        initComponents();
        getContentPane().setBackground(blue);
        this.setLocationRelativeTo(null);
        this.setTitle("Course Hero: Create a New Class");
        cIDLabel.setOpaque(true);
        secLabel.setOpaque(true);
        subLabel.setOpaque(true);
        tIDLabel.setOpaque(true);
        rIDLabel.setOpaque(true);
        daysLabel.setOpaque(true);
        startLabel.setOpaque(true);
        endLabel.setOpaque(true);
        capLabel.setOpaque(true);
        costLabel.setOpaque(true);
        
    }
    
    public void setFinished(){
        finished = true;
    }
    
    public String getResult(){
        return result;
    }
    public boolean check(){
        if (cIDTextField.getText().equals("") || secTextField.getText().equals("") || subTextField.getText().equals("") || tIDTextField.getText().equals("") || rIDTextField.getText().equals("")
                || daysTextField.getText().equals("") || startTextField.getText().equals("") || endTextField.getText().equals("") || capTextField.getText().equals("") || costTextField.getText().equals("")){
            return false;
        } else {
            return true;
        }

    }
    /**
     * 
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cIDLabel = new javax.swing.JLabel();
        secLabel = new javax.swing.JLabel();
        subLabel = new javax.swing.JLabel();
        tIDLabel = new javax.swing.JLabel();
        rIDLabel = new javax.swing.JLabel();
        cIDTextField = new javax.swing.JTextField();
        secTextField = new javax.swing.JTextField();
        subTextField = new javax.swing.JTextField();
        tIDTextField = new javax.swing.JTextField();
        rIDTextField = new javax.swing.JTextField();
        daysLabel = new javax.swing.JLabel();
        daysTextField = new javax.swing.JTextField();
        startLabel = new javax.swing.JLabel();
        endLabel = new javax.swing.JLabel();
        capLabel = new javax.swing.JLabel();
        costLabel = new javax.swing.JLabel();
        startTextField = new javax.swing.JTextField();
        endTextField = new javax.swing.JTextField();
        capTextField = new javax.swing.JTextField();
        costTextField = new javax.swing.JTextField();
        cancelButton = new javax.swing.JButton();
        createButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cIDLabel.setBackground(new java.awt.Color(255, 255, 0));
        cIDLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cIDLabel.setText(" Enter Class ID:");

        secLabel.setBackground(new java.awt.Color(255, 255, 0));
        secLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        secLabel.setText(" Enter Section:");

        subLabel.setBackground(new java.awt.Color(255, 255, 0));
        subLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        subLabel.setText(" Enter Subject:");

        tIDLabel.setBackground(new java.awt.Color(255, 255, 0));
        tIDLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tIDLabel.setText(" Enter Teacher ID:");

        rIDLabel.setBackground(new java.awt.Color(255, 255, 0));
        rIDLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rIDLabel.setText(" Enter Room ID:");

        cIDTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cIDTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cIDTextFieldActionPerformed(evt);
            }
        });

        secTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        subTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tIDTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        rIDTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        daysLabel.setBackground(new java.awt.Color(255, 255, 0));
        daysLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        daysLabel.setText(" Enter Class Days:");

        daysTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        startLabel.setBackground(new java.awt.Color(255, 255, 0));
        startLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        startLabel.setText(" Enter Start Time:");

        endLabel.setBackground(new java.awt.Color(255, 255, 0));
        endLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        endLabel.setText(" Enter End Time:");

        capLabel.setBackground(new java.awt.Color(255, 255, 0));
        capLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        capLabel.setText(" Enter Capacity:");

        costLabel.setBackground(new java.awt.Color(255, 255, 0));
        costLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        costLabel.setText(" Enter Cost:");

        startTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        endTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        capTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        costTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        cancelButton.setBackground(new java.awt.Color(255, 255, 0));
        cancelButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        createButton.setBackground(new java.awt.Color(255, 255, 0));
        createButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        createButton.setText("Create");
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(tIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(subLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(subTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(secLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(secTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(cIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(daysLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(startLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(endLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(capLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(costLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(daysTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(capTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(costTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(160, Short.MAX_VALUE)
                .addComponent(createButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(160, 160, 160))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(daysLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(daysTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(secLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(secTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(capLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(capTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(costLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(costTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cIDTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cIDTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cIDTextFieldActionPerformed

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
        if(check()){
            cID = Integer.parseInt(cIDTextField.getText());
            sec = Integer.parseInt(secTextField.getText());
            sub = subTextField.getText();
            tID = Integer.parseInt(tIDTextField.getText());
            rID = Integer.parseInt(rIDTextField.getText());
            days = daysTextField.getText();
            start = Time.valueOf(startTextField.getText());
            end = Time.valueOf(endTextField.getText());
            cap = Integer.parseInt(capTextField.getText());
            cost = Integer.parseInt(costTextField.getText());
            result = DatabaseConnector.createClass(cID,sec, sub, tID, rID, days, start,end,cap,cost);
            setFinished();
            dispose();
        }
    }//GEN-LAST:event_createButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cIDLabel;
    private javax.swing.JTextField cIDTextField;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel capLabel;
    private javax.swing.JTextField capTextField;
    private javax.swing.JLabel costLabel;
    private javax.swing.JTextField costTextField;
    private javax.swing.JButton createButton;
    private javax.swing.JLabel daysLabel;
    private javax.swing.JTextField daysTextField;
    private javax.swing.JLabel endLabel;
    private javax.swing.JTextField endTextField;
    private javax.swing.JLabel rIDLabel;
    private javax.swing.JTextField rIDTextField;
    private javax.swing.JLabel secLabel;
    private javax.swing.JTextField secTextField;
    private javax.swing.JLabel startLabel;
    private javax.swing.JTextField startTextField;
    private javax.swing.JLabel subLabel;
    private javax.swing.JTextField subTextField;
    private javax.swing.JLabel tIDLabel;
    private javax.swing.JTextField tIDTextField;
    // End of variables declaration//GEN-END:variables
}
