/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse.pkg308.ui;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import cse.pkg308.DBConnection;
import static cse.pkg308.ui.Login.sessionframe;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UserUI {

    public static JFrame frmStudentInterface;

    public static JTextField textFieldUserID;
    public static JPasswordField passwordFieldPassword;
    public static JLabel lblPassword;
    public static JLabel lblUserID;
    public static JLabel lblTestingCenter;
    public static JLabel lblPleaseLogIn;
    public static JButton btnLogin;
    public static JButton btnExit;
    public static JButton btnBacktoHome;
    public static JLabel invalid;
    public static JLabel time;

    public JTextField getID() {
        return textFieldUserID;
    }

    public JPasswordField getPassword() {
        return passwordFieldPassword;
    }

    public JFrame getSession() {
        return sessionframe;
    }

    /*
     Create the User Login Page
     */
    public void continueLogin(JFrame sessionframe) {

        sessionframe.setTitle("Testing Center Login");
        sessionframe.setBounds(100, 100, 264, 207);
        sessionframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sessionframe.getContentPane().setLayout(null);

        //Get Current Time
        PrintTime.displaytime();

        time = new JLabel();
        time.setFont(new Font("Tahoma", Font.PLAIN, 10));
        time.setBounds(200, 11, 140, 25);
        sessionframe.getContentPane().add(time);

        lblTestingCenter = new JLabel("Testing Center");
        lblTestingCenter.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblTestingCenter.setBounds(56, 11, 146, 25);
        sessionframe.getContentPane().add(lblTestingCenter);

        lblPleaseLogIn = new JLabel("Please log in.");
        lblPleaseLogIn.setBounds(92, 47, 63, 14);
        sessionframe.getContentPane().add(lblPleaseLogIn);

        lblUserID = new JLabel("UserID:");
        lblUserID.setBounds(40, 82, 63, 14);
        sessionframe.getContentPane().add(lblUserID);

        textFieldUserID = new JTextField();
        textFieldUserID.setBounds(113, 79, 104, 20);
        sessionframe.getContentPane().add(textFieldUserID);
        textFieldUserID.setColumns(10);

        lblPassword = new JLabel("Password:");
        lblPassword.setBounds(40, 107, 63, 14);
        sessionframe.getContentPane().add(lblPassword);

        passwordFieldPassword = new JPasswordField();
        passwordFieldPassword.setBounds(113, 104, 104, 20);
        sessionframe.getContentPane().add(passwordFieldPassword);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(128, 135, 89, 23);
        sessionframe.getContentPane().add(btnLogin);

        btnBacktoHome = new JButton("Back to Login");
        btnBacktoHome.setBounds(128, 135, 89, 23);
        sessionframe.getContentPane().add(btnBacktoHome);

        invalid = new JLabel("Incorrect Username or Password");
        invalid.setFont(new Font("Tahoma", Font.PLAIN, 20));
        invalid.setBounds(56, 11, 146, 25);
        sessionframe.getContentPane().add(invalid);

        btnBacktoHome.setVisible(false);
        invalid.setVisible(false);

        btnExit = new JButton("Exit");
        btnExit.setBounds(29, 135, 89, 23);
        sessionframe.getContentPane().add(btnExit);

        /*
         Determine user type after the login button is clicked
         */
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                /*
                 Check for if userid and password are entered. If either are empty or incorrect, the
                 user will not log in.
                 */
                if (textFieldUserID.getText().equals("") || passwordFieldPassword.getText().equals("")) {
                    JOptionPane.showMessageDialog(sessionframe, "Invalid Login");
                } else {
                    String email = "";

                    /*
                     This query will test for if an email is returned where a user with the entered
                     userid and password has an email (and other information) in the database. If
                     nothing is returned, the user will be presented a dialog box that informs them
                     that the information was incorrect
                     */
                    String query = "SELECT email from user where "
                            + "userid = '" + getID().getText() + "'"
                            + "AND password = '" + getPassword().getText() + "'";

                    java.sql.ResultSet rs = DBConnection.ExecQuery(query);

                    try {
                        while (rs.next()) {
                            email = rs.getString(1);

                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);

                    }
                    /*
                     If the returned value from the query is empty, a dialog box is displayed. If there is
                     a value, the user will be logged in
                     */
                    if (email.equals("")) {
                        JOptionPane.showMessageDialog(sessionframe, "Invalid Login");
                    } else {
                        switchtouserscreen(sessionframe);
                    }
                }

            }
        });

        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public void switchtouserscreen(JFrame sessionframe) {

        /*
         isa table in database contains the userid and usertype. The query gets the ID entered in the
         user text box and returns the usertype with that ID
         */
        String usertype = "";

        String query = "SELECT usertype from isa where "
                + "userid = '" + getID().getText() + "'";

        java.sql.ResultSet rs = DBConnection.ExecQuery(query);

        try {
            while (rs.next()) {

                usertype = rs.getString(1);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*
         If the returned usertype is "student", a new student object is created.
         */
        if (usertype.equals("student")) {

            String password = "";
            String name = "";
            String email = "";

            /*
             The query returns all of the student information
             */
            query = "SELECT * from user where "
                    + "userid = '" + getID().getText() + "'"
                    + "AND password = '" + getPassword().getText() + "'";

            rs = DBConnection.ExecQuery(query);

            try {
                while (rs.next()) {

                    password = rs.getString(2);
                    name = rs.getString(3);
                    email = rs.getString(4);

                }
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);

            }

            /*
             Convert the Student ID in the text box to an integer
             */
            String id = getID().getText();
            Student s = new Student();
            int intid = Integer.parseInt(id);

            /*
             The object variables for student is set to the information in the database that was
             returned.
             */
            s.setID(intid);
            s.setPassword(password);
            s.setName(name);
            s.setEmail(email);

            /*
            Switch to student interface
            */
            sessionframe.setVisible(false);
            User.student.initializestudent(s);

        } else if (usertype.equals("instr")) {
            String password = "";
            String name = "";
            String email = "";
            
            /*
             The query returns all of the instructor information
             */
            query = "SELECT * from user where "
                    + "userid = '" + getID().getText() + "'"
                    + "AND password = '" + getPassword().getText() + "'";

            rs = DBConnection.ExecQuery(query);

            try {
                while (rs.next()) {
                    password = rs.getString(2);
                    name = rs.getString(3);
                    email = rs.getString(4);

                }
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);

            }

            /*
             Convert the Instructor ID in the text box to an integer
             */
            String id = getID().getText();
            Instructor i = new Instructor();
            int intid = Integer.parseInt(id);

            /*
             The object variables for student is set to the information in the database that was
             returned.
             */
            i.setID(intid);
            i.setPassword(password);
            i.setName(name);
            i.setEmail(email);

            /*
            Switch to instructor interface
            */
            sessionframe.setVisible(false);
            User.instructor.initializeinstructor(i);

        } else if (usertype.equals("admin")) {
            String password = "";
            String name = "";
            String email = "";
            
            /*
             The query returns all of the administrator information
             */
            query = "SELECT * from user where "
                    + "userid = '" + getID().getText() + "'"
                    + "AND password = '" + getPassword().getText() + "'";

            rs = DBConnection.ExecQuery(query);

            try {
                while (rs.next()) {
                    password = rs.getString(2);
                    name = rs.getString(3);
                    email = rs.getString(4);

                }
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);

            }

            /*
             Convert the Administrator ID in the text box to an integer
             */
            String id = getID().getText();
            Administrator a = new Administrator();
            int intid = Integer.parseInt(id);

            /*
             The object variables for student is set to the information in the database that was
             returned.
             */
            a.setID(intid);
            a.setPassword(password);
            a.setName(name);
            a.setEmail(email);

            /*
            Switch to administrator interface
            */
            sessionframe.setVisible(false);
            User.admin.initializeadmin(a);

        }

    }

}
