/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.pkg308.ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import cse.pkg308.ui.StudentUI;
import cse.pkg308.DBConnection;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class User {

    private int ID;
    private String password;
    private String name;
    private String email;

    public static JFrame sessionframe;
     private JTextField textFieldUserID;
     private JPasswordField passwordFieldPassword;
                
     public static StudentUI student = new StudentUI();
     public static UserUI user = new UserUI();
        
     public static JLabel lblPassword = new JLabel("Password:");
        //static Student student = new Student();
    /**
     * Launch the application.
     */
    /*public static void main(String[] args) {
     EventQueue.invokeLater(new Runnable() {
     public void run() {
     try {
     Login window = new Login();
     window.frameLogin.setVisible(true);
     } catch (Exception e) {
     e.printStackTrace();
     }
     }
     });
     }*/
    public static JFrame getLogin() {
        return sessionframe;
    }

    public static void setLogin(JFrame SessionFrame) {
        sessionframe = SessionFrame;
    }

    public void startlogin() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                                        //sessionframe = new JFrame();
                    //user.initializeLogin(sessionframe);
                    User window = new User();
                    window.sessionframe.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public User() {
        sessionframe = new JFrame();
        //System.out.println("HH");
        user.initializeLogin(sessionframe);
            //user.switchToLogin();

        //initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

        sessionframe.setTitle("Testing Center Login");
        sessionframe.setBounds(100, 100, 264, 207);
        sessionframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sessionframe.getContentPane().setLayout(null);

        JLabel lblTestingCenter = new JLabel("Testing Center");
        lblTestingCenter.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblTestingCenter.setBounds(56, 11, 146, 25);
        sessionframe.getContentPane().add(lblTestingCenter);

        JLabel lblPleaseLogIn = new JLabel("Please log in.");
        lblPleaseLogIn.setBounds(92, 47, 63, 14);
        sessionframe.getContentPane().add(lblPleaseLogIn);

        JLabel lblUserID = new JLabel("UserID:");
        lblUserID.setBounds(40, 82, 63, 14);
        sessionframe.getContentPane().add(lblUserID);

        textFieldUserID = new JTextField();
        textFieldUserID.setBounds(113, 79, 104, 20);
        sessionframe.getContentPane().add(textFieldUserID);
        textFieldUserID.setColumns(10);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(40, 107, 63, 14);
        sessionframe.getContentPane().add(lblPassword);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(128, 135, 89, 23);
        sessionframe.getContentPane().add(btnLogin);

        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(29, 135, 89, 23);
        sessionframe.getContentPane().add(btnExit);

        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textFieldUserID.setVisible(false);
                passwordFieldPassword.setVisible(false);

                lblPassword.setVisible(false);
                lblUserID.setVisible(false);
                lblTestingCenter.setVisible(false);
                lblPleaseLogIn.setVisible(false);

                btnLogin.setVisible(false);
                btnExit.setVisible(false);

                switchtouserscreen();
            }
        });

        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        passwordFieldPassword = new JPasswordField();
        passwordFieldPassword.setBounds(113, 104, 104, 20);
        sessionframe.getContentPane().add(passwordFieldPassword);
    }

    public JFrame getFrameLogin() {
        return sessionframe;
    }

    public static void makeallvisible() {

    }

    public void switchtouserscreen() {
        String usertype = "";

        String query = "SELECT usertype from isa where "
                + "userid = '" + textFieldUserID.getText() + "'";

        //Connection connection = DBConnection.getconnection();
        //System.out.println(connection);
        java.sql.ResultSet rs = DBConnection.ExecQuery(query);
        //System.out.println(DBConnection.getconnection());
        try {
            while (rs.next()) {

                usertype = rs.getString(1);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (usertype.equals("student")) {

            Student.openstudent();
        }

    }

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
