import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class LoginDialog extends JDialog {

    private JTextField tfUsername;
    private JPasswordField pfPassword;
    private JLabel lbUsername;
    private JLabel lbPassword;
    private JButton btnLogin;
    private JButton btnCancel;
    private boolean succeeded;
    public Integer id;
    Color blue = new Color(0,0,153);
    Color yellow = new Color(255, 255, 0);
    
    public LoginDialog(Frame parent, String type) {
        super(parent, "Login", true);
        //
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(blue);
        GridBagConstraints cs = new GridBagConstraints();

        cs.fill = GridBagConstraints.HORIZONTAL;

        lbUsername = new JLabel(" " + type + " ID: ");
        lbUsername.setBackground(yellow);
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(lbUsername, cs);
        lbUsername.setOpaque(true);

        tfUsername = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(tfUsername, cs);

        lbPassword = new JLabel(" Password: ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(lbPassword, cs);
        lbPassword.setBackground(yellow);
        lbPassword.setOpaque(true);
        

        pfPassword = new JPasswordField(20);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        panel.add(pfPassword, cs);
        panel.setBorder(new LineBorder(Color.GRAY));

        btnLogin = new JButton("Login");
        btnLogin.setBackground(yellow);

        btnLogin.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (authenticate(type, getUsername(), getPassword())) {
                    JOptionPane.showMessageDialog(LoginDialog.this,
                            "Successfully logged in as ID " + getUsername() + "!",
                            "Login",
                            JOptionPane.INFORMATION_MESSAGE);
                    succeeded = true;
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(LoginDialog.this,
                            "Invalid ID or password",
                            "Login",
                            JOptionPane.ERROR_MESSAGE);
                    // reset username and password
                    tfUsername.setText("");
                    pfPassword.setText("");
                    succeeded = false;

                }
            }
        });
        btnCancel = new JButton("Cancel");
        btnCancel.setBackground(yellow);
        btnCancel.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        JPanel bp = new JPanel();
        bp.setBackground(blue);
        bp.add(btnLogin);
        bp.add(btnCancel);

        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.PAGE_END);

        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
    }

    public String getUsername() {
        return tfUsername.getText().trim();
    }

    public String getPassword() {
        try {
            char[] pwdChars = pfPassword.getPassword();
            StringBuilder bldr = new StringBuilder("");
            for (char character :
                    pwdChars) {
                bldr.append(character);
            }
            return bldr.toString();
        } catch (NullPointerException e) {
            return new String(pfPassword.getPassword());
        }
    }

    public boolean isSucceeded() {
        return succeeded;
    }

    public Integer getID() {
        return id;
    }

    private boolean authenticate(String type, String ID, String pass) {
        id = Integer.parseInt(ID);
        if (type.equals("student")) {
            if (id == DatabaseConnector.logInAsStudent(id, pass)) {
                return true;
            }
        }
        if (type.equals("staff")) {
            if (id == DatabaseConnector.logInAsStaff(id, pass)) {
                return true;
            }
        }
        return false;
    }
}
