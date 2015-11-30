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
import cse.pkg308.ui.InstructorUI;
import cse.pkg308.ui.AdministratorUI;
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

    public static StudentUI student = new StudentUI();
    public static InstructorUI instructor = new InstructorUI();
    public static AdministratorUI admin = new AdministratorUI();
    public static UserUI user = new UserUI();

    public static JLabel lblPassword = new JLabel("Password:");

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

                    /*
                    Initiate a new User object and create a new user frame
                    */
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
        user.continueLogin(sessionframe);

    }

    /**
     * Initialize the contents of the frame.
     */
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
