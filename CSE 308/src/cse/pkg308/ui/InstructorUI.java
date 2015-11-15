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
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import cse.pkg308.DBConnection;
import static cse.pkg308.ui.Login.sessionframe;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class InstructorUI {

    public static JFrame sessionframe;
    public static JFrame frameInstructorInterface;

    private JTextField textFieldUserID;
    private JPasswordField passwordFieldPassword;
    public static JLabel lblPassword;
    public static JLabel lblUserID;
    public static JLabel lblTestingCenter;
    public static JLabel lblPleaseLogIn;
    public static JButton btnLogin;
    public static JButton btnExit;

    public static JLabel lblInstructor;
    public static JLabel lblName;
    public static JLabel lblName2;
    public static JButton btnCreateAnExam;
    public static JButton btnAppointedRequests;
    public static JCalendar calendar;
    public static JButton btnLogOut;

    public JFrame frmTakeAnExam;
    public JTextField txtPm;

    public void initial() {
        sessionframe = new JFrame();
        //initializeLogin();
        System.out.println("testing");
    }

    public void initializeLogin(JFrame sessionFrame) {
        sessionframe = sessionFrame;
        continueLogin();
    }

    public void continueLogin() {

        sessionframe.setTitle("Testing Center Login");
        sessionframe.setBounds(100, 100, 264, 207);
        sessionframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sessionframe.getContentPane().setLayout(null);

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

        btnExit = new JButton("Exit");
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

                //switchtouserscreen();

            }
        });
    }

    public void initializeinstructor(Instructor i) {
        //frameInstructorInterface = new JFrame();

        frameInstructorInterface = new JFrame();
        frameInstructorInterface.setVisible(true);

        frameInstructorInterface.setTitle("Instructor Interface");
        frameInstructorInterface.setBounds(100, 100, 356, 239);
        frameInstructorInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameInstructorInterface.getContentPane().setLayout(null);

        lblInstructor = new JLabel("Instructor");
        lblInstructor.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblInstructor.setBounds(23, 8, 96, 25);
        frameInstructorInterface.getContentPane().add(lblInstructor);

        lblName = new JLabel("Name:");
        lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblName.setBounds(10, 44, 46, 14);
        frameInstructorInterface.getContentPane().add(lblName);

        lblName2 = new JLabel(i.getName());
        lblName2.setBounds(60, 44, 59, 14);
        frameInstructorInterface.getContentPane().add(lblName2);

        btnCreateAnExam = new JButton("Create an Exam");
        btnCreateAnExam.setBounds(10, 84, 115, 23);
        frameInstructorInterface.getContentPane().add(btnCreateAnExam);

        

        btnAppointedRequests = new JButton("View Requests");
        btnAppointedRequests.setBounds(10, 118, 115, 23);
        frameInstructorInterface.getContentPane().add(btnAppointedRequests);

        

        calendar = new JCalendar();
        calendar.setBounds(135, 7, 198, 153);
        frameInstructorInterface.getContentPane().add(calendar);

        btnLogOut = new JButton("Log Out");
        btnLogOut.setBounds(241, 171, 89, 23);
        frameInstructorInterface.getContentPane().add(btnLogOut);
        
        btnAppointedRequests.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
        btnCreateAnExam.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblName.setVisible(false);
        lblName2.setVisible(false);
        lblInstructor.setVisible(false);
        calendar.setVisible(false);
        btnCreateAnExam.setVisible(false);
        btnAppointedRequests.setVisible(false);
        btnLogOut.setVisible(false);
        switchToCreateExamPage(i);
            }
        });

        btnLogOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    
    public void switchToCreateExamPage(Instructor i){
        JLabel lblCreateAnExam = new JLabel("Create an Exam");
		lblCreateAnExam.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCreateAnExam.setBounds(33, 6, 150, 30);
		frameInstructorInterface.getContentPane().add(lblCreateAnExam);
		
		JLabel lblCourse = new JLabel("Course:");
		lblCourse.setBounds(20, 47, 46, 14);
		frameInstructorInterface.getContentPane().add(lblCourse);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {""}));
		comboBox.setBounds(89, 44, 94, 20);
		frameInstructorInterface.getContentPane().add(comboBox);
		
		JLabel lblExam = new JLabel("Exam:");
		lblExam.setBounds(20, 78, 46, 14);
		frameInstructorInterface.getContentPane().add(lblExam);
		
		JTextField textFieldExam = new JTextField();
		textFieldExam.setBounds(89, 75, 94, 20);
		frameInstructorInterface.getContentPane().add(textFieldExam);
		textFieldExam.setColumns(10);
		
		JTextField textFieldStartTime = new JTextField();
		textFieldStartTime.setText("");
		textFieldStartTime.setBounds(89, 106, 94, 20);
		frameInstructorInterface.getContentPane().add(textFieldStartTime);
		textFieldStartTime.setColumns(10);
		
		JLabel lblStartTime = new JLabel("Start Time:");
		lblStartTime.setBounds(20, 109, 53, 14);
		frameInstructorInterface.getContentPane().add(lblStartTime);
		
		JTextField textFieldEndTime = new JTextField();
		textFieldEndTime.setText("");
		textFieldEndTime.setBounds(89, 137, 94, 20);
		frameInstructorInterface.getContentPane().add(textFieldEndTime);
		textFieldEndTime.setColumns(10);
		
		JLabel lblEndTime = new JLabel("End Time:");
		lblEndTime.setBounds(20, 140, 53, 14);
		frameInstructorInterface.getContentPane().add(lblEndTime);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(89, 168, 94, 20);
		frameInstructorInterface.getContentPane().add(dateChooser);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(20, 165, 46, 23);
		frameInstructorInterface.getContentPane().add(lblDate);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(10, 203, 89, 23);
		frameInstructorInterface.getContentPane().add(btnCancel);
                
                JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(109, 203, 89, 23);
		frameInstructorInterface.getContentPane().add(btnConfirm);
		
                btnCancel.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        lblCreateAnExam.setVisible(false);
                        lblCourse.setVisible(false);
                        comboBox.setVisible(false);
                        lblExam.setVisible(false);
                        textFieldExam.setVisible(false);
                        textFieldStartTime.setVisible(false);
                        lblStartTime.setVisible(false);
                        textFieldEndTime.setVisible(false);
                        lblEndTime.setVisible(false);
                        dateChooser.setVisible(false);
                        lblDate.setVisible(false);
                        btnCancel.setVisible(false);
                        btnConfirm.setVisible(false);
                        
                        switchToInstructorSplashScreen();
                    }
                });
                
                
                btnConfirm.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        lblCreateAnExam.setVisible(false);
                        lblCourse.setVisible(false);
                        comboBox.setVisible(false);
                        lblExam.setVisible(false);
                        textFieldExam.setVisible(false);
                        textFieldStartTime.setVisible(false);
                        lblStartTime.setVisible(false);
                        textFieldEndTime.setVisible(false);
                        lblEndTime.setVisible(false);
                        dateChooser.setVisible(false);
                        lblDate.setVisible(false);
                        btnCancel.setVisible(false);
                        btnConfirm.setVisible(false);
                        
                        switchToInstructorSplashScreen();
                    }
                });
                
	
    }

    public void switchToInstructorSplashScreen() {
        lblName.setVisible(true);
        lblName2.setVisible(true);
        lblInstructor.setVisible(true);
        calendar.setVisible(true);
        btnCreateAnExam.setVisible(true);
        btnAppointedRequests.setVisible(true);
        btnLogOut.setVisible(true);
    }


    public void switchToAppointmentConfirmationPage() {
        JLabel confirmation = new JLabel("Your Appointment Has Been Confirmed");
        confirmation.setFont(new Font("Tahoma", Font.PLAIN, 15));
        confirmation.setBounds(35, 11, 77, 21);
        frameInstructorInterface.getContentPane().add(confirmation);

        JButton btnbacktohome = new JButton("Back to Home");
        btnbacktohome.setBounds(10, 150, 121, 23);
        frameInstructorInterface.getContentPane().add(btnbacktohome);

        btnbacktohome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                confirmation.setVisible(false);
                btnbacktohome.setVisible(false);

                switchToInstructorSplashScreen();

            }

        });
    }

    public void switchToCancellationConfirmationPage() {
        JLabel confirmation = new JLabel("Your Appointment Has Been Cancelled");
        confirmation.setFont(new Font("Tahoma", Font.PLAIN, 10));
        confirmation.setBounds(35, 11, 77, 21);
        frameInstructorInterface.getContentPane().add(confirmation);

        JButton btnbackhome = new JButton("Back to Home");
        btnbackhome.setBounds(30, 150, 121, 23);
        frameInstructorInterface.getContentPane().add(btnbackhome);

        btnbackhome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                confirmation.setVisible(false);
                btnbackhome.setVisible(false);

                switchToInstructorSplashScreen();

            }

        });
    }

    

    public void switchToCancelExamPage() {


        JLabel lblCancelAnExam = new JLabel("Cancel an Exam");
        lblCancelAnExam.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblCancelAnExam.setBounds(33, 11, 142, 25);
        frameInstructorInterface.getContentPane().add(lblCancelAnExam);

        JLabel lblCourse = new JLabel("Course:");
        lblCourse.setBounds(33, 47, 46, 14);
        frameInstructorInterface.getContentPane().add(lblCourse);

        JComboBox coursecomboBox = new JComboBox();
        coursecomboBox.setModel(new DefaultComboBoxModel(new String[]{"CSE 308"}));
        coursecomboBox.setBounds(104, 44, 81, 20);
        frameInstructorInterface.getContentPane().add(coursecomboBox);

        JLabel lblExam = new JLabel("Exam:");
        lblExam.setBounds(33, 77, 46, 14);
        frameInstructorInterface.getContentPane().add(lblExam);

        JComboBox examcomboBox = new JComboBox();
        examcomboBox.setModel(new DefaultComboBoxModel(new String[]{"Midterm 1"}));
        examcomboBox.setBounds(104, 74, 81, 20);
        frameInstructorInterface.getContentPane().add(examcomboBox);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(15, 113, 89, 23);
        frameInstructorInterface.getContentPane().add(btnCancel);

        JButton btnConfirm = new JButton("Confirm");
        btnConfirm.setBounds(114, 113, 89, 23);
        frameInstructorInterface.getContentPane().add(btnConfirm);

        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                lblCancelAnExam.setVisible(false);
                lblCourse.setVisible(false);
                coursecomboBox.setVisible(false);
                examcomboBox.setVisible(false);
                lblExam.setVisible(false);
                btnCancel.setVisible(false);
                btnConfirm.setVisible(false);

                switchToInstructorSplashScreen();

            }

        });

        btnConfirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                lblCancelAnExam.setVisible(false);
                lblCourse.setVisible(false);
                coursecomboBox.setVisible(false);
                examcomboBox.setVisible(false);
                lblExam.setVisible(false);
                btnCancel.setVisible(false);
                btnConfirm.setVisible(false);

                switchToCancellationConfirmationPage();

            }

        });
    }

    public void switchToTakeExamPage() {
        //frmTakeAnExam = new JFrame();
		/*frmTakeAnExam.setTitle("Take an Exam");
         frmTakeAnExam.setBounds(100, 100, 236, 246);
         frmTakeAnExam.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frmTakeAnExam.getContentPane().setLayout(null);*/

        JLabel lblTakeAnExam = new JLabel("Take an Exam");
        lblTakeAnExam.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblTakeAnExam.setBounds(44, 11, 140, 25);
        frameInstructorInterface.getContentPane().add(lblTakeAnExam);

        JLabel lblCourses = new JLabel("Courses:");
        lblCourses.setBounds(28, 50, 46, 14);
        frameInstructorInterface.getContentPane().add(lblCourses);

        JComboBox coursecomboBox = new JComboBox();
        coursecomboBox.setModel(new DefaultComboBoxModel(new String[]{"CSE 308"}));
        coursecomboBox.setBounds(111, 47, 94, 20);
        frameInstructorInterface.getContentPane().add(coursecomboBox);

        JComboBox examcomboBox = new JComboBox();
        examcomboBox.setModel(new DefaultComboBoxModel(new String[]{"Midterm 1"}));
        examcomboBox.setBounds(111, 75, 94, 20);
        frameInstructorInterface.getContentPane().add(examcomboBox);

        JLabel lblExam = new JLabel("Exam:");
        lblExam.setBounds(28, 78, 46, 14);
        frameInstructorInterface.getContentPane().add(lblExam);

        txtPm = new JTextField();
        txtPm.setText("12:00 PM");
        txtPm.setBounds(111, 106, 94, 20);
        frameInstructorInterface.getContentPane().add(txtPm);
        txtPm.setColumns(10);

        JLabel lblTime = new JLabel("Time:");
        lblTime.setBounds(28, 109, 46, 14);
        frameInstructorInterface.getContentPane().add(lblTime);

        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setBounds(111, 137, 94, 20);
        frameInstructorInterface.getContentPane().add(dateChooser);

        JLabel lblDate = new JLabel("Date:");
        lblDate.setBounds(28, 132, 46, 25);
        frameInstructorInterface.getContentPane().add(lblDate);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(17, 173, 89, 23);
        frameInstructorInterface.getContentPane().add(btnCancel);

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(116, 173, 89, 23);
        frameInstructorInterface.getContentPane().add(btnSubmit);

        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                lblTakeAnExam.setVisible(false);
                lblCourses.setVisible(false);
                coursecomboBox.setVisible(false);
                examcomboBox.setVisible(false);
                lblExam.setVisible(false);
                txtPm.setVisible(false);
                lblTime.setVisible(false);
                dateChooser.setVisible(false);
                lblDate.setVisible(false);
                btnCancel.setVisible(false);
                btnSubmit.setVisible(false);

                switchToInstructorSplashScreen();

            }

        });

        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                lblTakeAnExam.setVisible(false);
                lblCourses.setVisible(false);
                coursecomboBox.setVisible(false);
                examcomboBox.setVisible(false);
                lblExam.setVisible(false);
                txtPm.setVisible(false);
                lblTime.setVisible(false);
                dateChooser.setVisible(false);
                lblDate.setVisible(false);
                btnCancel.setVisible(false);
                btnSubmit.setVisible(false);

                switchToAppointmentConfirmationPage();

            }

        });
    }

}
