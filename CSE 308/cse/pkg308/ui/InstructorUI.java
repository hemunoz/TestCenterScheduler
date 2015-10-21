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
    public static JFrame frmStudentInterface;
    
    private JTextField textFieldUserID;
    private JPasswordField passwordFieldPassword;
    public static JLabel lblPassword;
    public static JLabel lblUserID;
    public static JLabel lblTestingCenter;
    public static JLabel lblPleaseLogIn;
    public static JButton btnLogin;
    public static JButton btnExit;
    
    
    public static JLabel lblName = new JLabel("Name:");
    public static JLabel student = new JLabel("Student");
    public static JLabel studentname = new JLabel("John Smith");
    public static JLabel lblId = new JLabel("ID:");
    public static JLabel studentId;
    public static JCalendar calendar = new JCalendar();
    public static JButton btnTakeAnExam = new JButton("Take an Exam");
    public static JButton btnCancelAnExam = new JButton("Cancel an Exam");
    public static JButton btnSetAReminder = new JButton("Set a Reminder");
    public static JButton btnLogOut = new JButton("Log Out");

    public JFrame frmTakeAnExam;
    public JTextField txtPm;
    
    /*

                        lblUserID.setVisible(false);
                        lblTestingCenter.setVisible(false);
                        lblPleaseLogIn.setVisible(false);
                        
                        btnLogin.setVisible(false);
                        btnExit.setVisible(false);
    */
    
    public void initial()
    {
        sessionframe = new JFrame();
        //initializeLogin();
        System.out.println("testing");
    }
    
    public void initializeLogin(JFrame sessionFrame)
    {
        sessionframe = sessionFrame;
        continueLogin();
    }
    public void continueLogin(){
        
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
                
                btnLogin.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        textFieldUserID.setVisible(false);
                        passwordFieldPassword.setVisible(false);
                        
                        lblPassword.setVisible(false);
                        lblUserID.setVisible(false);
                        lblTestingCenter.setVisible(false);
                        lblPleaseLogIn.setVisible(false);
                        
                        btnLogin.setVisible(false);
                        btnExit.setVisible(false);
                        
                        switchtouserscreen();
                        
                        //Student.openstudent();
                    }
                });
    }
    
    public void initializestudent(){
        frmStudentInterface = Login.getLogin();
		
                frmStudentInterface.setTitle("Student Interface");
		frmStudentInterface.setBounds(100, 100, 477, 344);
		frmStudentInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStudentInterface.getContentPane().setLayout(null);
                
		//lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblName.setBounds(21, 38, 46, 21);
		frmStudentInterface.getContentPane().add(lblName);
		
		student = new JLabel("Student");
		student.setFont(new Font("Tahoma", Font.PLAIN, 20));
		student.setBounds(35, 11, 77, 21);
		frmStudentInterface.getContentPane().add(student);
		
		studentname = new JLabel("John Smith");
		studentname.setBounds(65, 41, 77, 14);
		frmStudentInterface.getContentPane().add(studentname);
		
		lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblId.setBounds(21, 57, 46, 14);
		frmStudentInterface.getContentPane().add(lblId);
		
		studentId = new JLabel("123456789");
		studentId.setBounds(65, 57, 77, 14);
		frmStudentInterface.getContentPane().add(studentId);
		
		calendar = new JCalendar();
		calendar.setBounds(152, 11, 198, 153);
		frmStudentInterface.getContentPane().add(calendar);
		
		btnTakeAnExam = new JButton("Take an Exam");
		btnTakeAnExam.setBounds(10, 82, 121, 23);
		frmStudentInterface.getContentPane().add(btnTakeAnExam);
		
		btnCancelAnExam = new JButton("Cancel an Exam");
		btnCancelAnExam.setBounds(10, 116, 121, 23);
		frmStudentInterface.getContentPane().add(btnCancelAnExam);
		
		btnSetAReminder = new JButton("Set a Reminder");
		btnSetAReminder.setBounds(10, 150, 121, 23);
		frmStudentInterface.getContentPane().add(btnSetAReminder);
		
		//btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(261, 175, 89, 23);
		frmStudentInterface.getContentPane().add(btnLogOut);
                
                lblName.setVisible(true);
                        /*student.setVisible(true);
                        studentname.setVisible(true);
                        lblId.setVisible(true);
                        studentId.setVisible(true);
                        calendar.setVisible(true);
                        btnTakeAnExam.setVisible(true);
                        btnCancelAnExam.setVisible(true);
                        btnSetAReminder.setVisible(true);*/
                        btnLogOut.setVisible(true);
                
                btnLogOut.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        
                        lblName.setVisible(false);
                        student.setVisible(false);
                        studentname.setVisible(false);
                        lblId.setVisible(false);
                        studentId.setVisible(false);
                        calendar.setVisible(false);
                        btnTakeAnExam.setVisible(false);
                        btnCancelAnExam.setVisible(false);
                        btnSetAReminder.setVisible(false);
                        btnLogOut.setVisible(false);
                        
                        switchToLogin();

                    }

                });
                
                btnTakeAnExam.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        
                        lblName.setVisible(false);
                        student.setVisible(false);
                        studentname.setVisible(false);
                        lblId.setVisible(false);
                        studentId.setVisible(false);
                        calendar.setVisible(false);
                        btnTakeAnExam.setVisible(false);
                        btnCancelAnExam.setVisible(false);
                        btnSetAReminder.setVisible(false);
                        btnLogOut.setVisible(false);
                        
                        switchToTakeExamPage();

                    }

                });
                
                btnCancelAnExam.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        
                        lblName.setVisible(false);
                        student.setVisible(false);
                        studentname.setVisible(false);
                        lblId.setVisible(false);
                        studentId.setVisible(false);
                        calendar.setVisible(false);
                        btnTakeAnExam.setVisible(false);
                        btnCancelAnExam.setVisible(false);
                        btnSetAReminder.setVisible(false);
                        btnLogOut.setVisible(false);
                        
                        switchToCancelExamPage();

                    }
                });
    }
    
    public void switchToStudentSplashScreen()
    {
        lblName.setVisible(true);
                        student.setVisible(true);
                        studentname.setVisible(true);
                        lblId.setVisible(true);
                        studentId.setVisible(true);
                        calendar.setVisible(true);
                        btnTakeAnExam.setVisible(true);
                        btnCancelAnExam.setVisible(true);
                        btnSetAReminder.setVisible(true);
                        btnLogOut.setVisible(true);
    }
    
    public void switchToLogin()
    {
        textFieldUserID.setVisible(true);
                        passwordFieldPassword.setVisible(true);
                        lblUserID.setVisible(true);
                        lblPassword.setVisible(true);
                        lblTestingCenter.setVisible(true);
                        lblPleaseLogIn.setVisible(true);
                        btnLogin.setVisible(true);
                        btnExit.setVisible(true);
    }
    
    public void switchToAppointmentConfirmationPage(){
        JLabel confirmation = new JLabel("Your Appointment Has Been Confirmed");
		confirmation.setFont(new Font("Tahoma", Font.PLAIN, 15));
		confirmation.setBounds(35, 11, 77, 21);
		frmStudentInterface.getContentPane().add(confirmation);
		
		JButton btnbacktohome = new JButton("Back to Home");
		btnbacktohome.setBounds(10, 150, 121, 23);
		frmStudentInterface.getContentPane().add(btnbacktohome);
                
                btnbacktohome.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        
                        confirmation.setVisible(false);
                        btnbacktohome.setVisible(false);
                        
                        switchToStudentSplashScreen();

                    }

                });
    }
    
    public void switchToCancellationConfirmationPage(){
        JLabel confirmation = new JLabel("Your Appointment Has Been Cancelled");
		confirmation.setFont(new Font("Tahoma", Font.PLAIN, 10));
		confirmation.setBounds(35, 11, 77, 21);
		frmStudentInterface.getContentPane().add(confirmation);
		
		JButton btnbackhome = new JButton("Back to Home");
		btnbackhome.setBounds(30, 150, 121, 23);
		frmStudentInterface.getContentPane().add(btnbackhome);
                
                
                
                btnbackhome.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        
                        confirmation.setVisible(false);
                        btnbackhome.setVisible(false);
                        
                        switchToStudentSplashScreen();

                    }

                });
    }
    
    public void switchtouserscreen(){
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
        
        if(usertype.equals("student"))
        {
            
            Student.openstudent();
        }
        else
            continueLogin();
        
            
        }
    
    public void switchToCancelExamPage(){
        /*frmCancelAnExam = new JFrame();
		frmCancelAnExam.setTitle("Cancel an Exam");
		frmCancelAnExam.setBounds(100, 100, 240, 185);
		frmCancelAnExam.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCancelAnExam.getContentPane().setLayout(null);*/
		
		JLabel lblCancelAnExam = new JLabel("Cancel an Exam");
		lblCancelAnExam.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCancelAnExam.setBounds(33, 11, 142, 25);
		frmStudentInterface.getContentPane().add(lblCancelAnExam);
		
		JLabel lblCourse = new JLabel("Course:");
		lblCourse.setBounds(33, 47, 46, 14);
		frmStudentInterface.getContentPane().add(lblCourse);
		
		JComboBox coursecomboBox = new JComboBox();
		coursecomboBox.setModel(new DefaultComboBoxModel(new String[] {"CSE 308"}));
		coursecomboBox.setBounds(104, 44, 81, 20);
		frmStudentInterface.getContentPane().add(coursecomboBox);
		
		JLabel lblExam = new JLabel("Exam:");
		lblExam.setBounds(33, 77, 46, 14);
		frmStudentInterface.getContentPane().add(lblExam);
		
		JComboBox examcomboBox = new JComboBox();
		examcomboBox.setModel(new DefaultComboBoxModel(new String[] {"Midterm 1"}));
		examcomboBox.setBounds(104, 74, 81, 20);
		frmStudentInterface.getContentPane().add(examcomboBox);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(15, 113, 89, 23);
		frmStudentInterface.getContentPane().add(btnCancel);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(114, 113, 89, 23);
		frmStudentInterface.getContentPane().add(btnConfirm);
                
                btnCancel.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        
                        lblCancelAnExam.setVisible(false);
                        lblCourse.setVisible(false);
                        coursecomboBox.setVisible(false);
                        examcomboBox.setVisible(false);
                        lblExam.setVisible(false);
                        btnCancel.setVisible(false);
                        btnConfirm.setVisible(false);
                        
                        switchToStudentSplashScreen();

                    }

                });
                
                btnConfirm.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        
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
    
    
    public void switchToTakeExamPage(){
        //frmTakeAnExam = new JFrame();
		/*frmTakeAnExam.setTitle("Take an Exam");
		frmTakeAnExam.setBounds(100, 100, 236, 246);
		frmTakeAnExam.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTakeAnExam.getContentPane().setLayout(null);*/
		
		JLabel lblTakeAnExam = new JLabel("Take an Exam");
		lblTakeAnExam.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTakeAnExam.setBounds(44, 11, 140, 25);
		frmStudentInterface.getContentPane().add(lblTakeAnExam);
		
		JLabel lblCourses = new JLabel("Courses:");
		lblCourses.setBounds(28, 50, 46, 14);
		frmStudentInterface.getContentPane().add(lblCourses);
		
		JComboBox coursecomboBox = new JComboBox();
		coursecomboBox.setModel(new DefaultComboBoxModel(new String[] {"CSE 308"}));
		coursecomboBox.setBounds(111, 47, 94, 20);
		frmStudentInterface.getContentPane().add(coursecomboBox);
		
		JComboBox examcomboBox = new JComboBox();
		examcomboBox.setModel(new DefaultComboBoxModel(new String[] {"Midterm 1"}));
		examcomboBox.setBounds(111, 75, 94, 20);
		frmStudentInterface.getContentPane().add(examcomboBox);
		
		JLabel lblExam = new JLabel("Exam:");
		lblExam.setBounds(28, 78, 46, 14);
		frmStudentInterface.getContentPane().add(lblExam);
		
		txtPm = new JTextField();
		txtPm.setText("12:00 PM");
		txtPm.setBounds(111, 106, 94, 20);
		frmStudentInterface.getContentPane().add(txtPm);
		txtPm.setColumns(10);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setBounds(28, 109, 46, 14);
		frmStudentInterface.getContentPane().add(lblTime);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(111, 137, 94, 20);
		frmStudentInterface.getContentPane().add(dateChooser);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(28, 132, 46, 25);
		frmStudentInterface.getContentPane().add(lblDate);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(17, 173, 89, 23);
		frmStudentInterface.getContentPane().add(btnCancel);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(116, 173, 89, 23);
		frmStudentInterface.getContentPane().add(btnSubmit);
                
                btnCancel.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        
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
                        
                        switchToStudentSplashScreen();

                    }

                });
                
                btnSubmit.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        
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

