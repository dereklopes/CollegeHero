import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class StudentUI extends javax.swing.JFrame {
    public String ID = "";
    Color blue = new Color(0,0,153);
    Color yellow = new Color(255,255,0);
    /**
     * Creates new form student
     */
    public StudentUI(Integer sID) {
        initComponents();
        ID = sID.toString();
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
        logoutButton = new javax.swing.JButton();
        searchSubjectButton = new javax.swing.JButton();

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

        logoutButton.setBackground(new java.awt.Color(255, 255, 0));
        logoutButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchIDButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchSubjectButton, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchIDButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(searchSubjectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchSubjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchSubjectButtonActionPerformed
        // Dialog to enter subject to search
        String sub = (String) JOptionPane.showInputDialog(this, 
                "Enter Class ID to Search",
                "Search Class ID",JOptionPane.PLAIN_MESSAGE);
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

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        searchTextArea.setText("");
        dispose();
    }//GEN-LAST:event_logoutButtonActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton searchIDButton;
    private javax.swing.JButton searchSubjectButton;
    private javax.swing.JTextArea searchTextArea;
    // End of variables declaration//GEN-END:variables
}
