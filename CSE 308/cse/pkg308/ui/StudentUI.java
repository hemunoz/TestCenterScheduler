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
import cse.pkg308.ui.UserUI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class StudentUI {

    public static JFrame sessionframe;
    public static JFrame frmStudentInterface;
    public UserUI user = new UserUI();

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
    public static JLabel studentname;
    public static JLabel lblId = new JLabel("ID:");
    public static JLabel studentId;
    public static JCalendar calendar = new JCalendar();
    public static JButton btnTakeAnExam = new JButton("Take an Exam");
    public static JButton btnCancelAnExam = new JButton("Cancel an Exam");
    public static JButton btnSetAReminder = new JButton("Set a Reminder");
    public static JButton btnLogOut = new JButton("Log Out");
    
    public static JComboBox coursecomboBox;
    public static JComboBox examcomboBox;
    public static JComboBox timecomboBox;
    public static JComboBox ampmcomboBox;
    public static JDateChooser dateChooser;

    public JFrame frmTakeAnExam;
    public JTextField txtPm;
    
    public static Course [] courses = new Course[5];
    public static Exam [] examlist = new Exam[5];

    /*

     lblUserID.setVisible(false);
     lblTestingCenter.setVisible(false);
     lblPleaseLogIn.setVisible(false);
                        
     btnLogin.setVisible(false);
     btnExit.setVisible(false);
     */
    public void initial() {
        sessionframe = new JFrame();
        //initializeLogin();
        System.out.println("testing");
    }

    public void initializeLogin(JFrame sessionFrame) {
        sessionframe = sessionFrame;

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

                switchtouserscreen();

                //Student.openstudent();
            }
        });
    }

    public void begin(Student s) {

    }

    public void initializestudent(Student s) {

        //frmStudentInterface = user.getSession();
        frmStudentInterface = new JFrame();
        frmStudentInterface.setVisible(true);

        frmStudentInterface.setTitle("Student Interface");
        frmStudentInterface.setBounds(100, 100, 477, 344);
        frmStudentInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmStudentInterface.getContentPane().setLayout(null);

        lblName = new JLabel("Name:");
        lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblName.setBounds(21, 38, 46, 21);
        frmStudentInterface.getContentPane().add(lblName);

        student = new JLabel("Student");
        student.setFont(new Font("Tahoma", Font.PLAIN, 20));
        student.setBounds(35, 11, 77, 21);
        frmStudentInterface.getContentPane().add(student);

        studentname = new JLabel(s.getName());
        studentname.setBounds(65, 41, 77, 14);
        frmStudentInterface.getContentPane().add(studentname);

        lblId = new JLabel("ID:");
        lblId.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblId.setBounds(21, 57, 46, 14);
        frmStudentInterface.getContentPane().add(lblId);

        studentId = new JLabel(s.getID() + "");
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

        btnLogOut = new JButton("Log Out");
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

        btnLogOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

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

                frmStudentInterface.remove(lblId);
                frmStudentInterface.remove(lblName);
                frmStudentInterface.remove(student);
                frmStudentInterface.remove(studentname);
                frmStudentInterface.remove(studentId);
                frmStudentInterface.remove(calendar);
                frmStudentInterface.remove(btnTakeAnExam);
                frmStudentInterface.remove(btnCancelAnExam);
                frmStudentInterface.remove(btnSetAReminder);
                frmStudentInterface.remove(btnLogOut);

                        //user.getSession().remove(lblName);
                //User.setLogin(sessionframe);
                //user.switchToLogin();
                System.out.println(2);
                User u = new User();
                //switchToLogin();

            }

        });

        btnTakeAnExam.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

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

                switchToTakeExamPage(s);

            }

        });

        btnCancelAnExam.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

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

    public void switchToStudentSplashScreen() {
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

    public void switchToLogin() {
        textFieldUserID.setVisible(true);
        passwordFieldPassword.setVisible(true);
        lblUserID.setVisible(true);
        lblPassword.setVisible(true);
        lblTestingCenter.setVisible(true);
        lblPleaseLogIn.setVisible(true);
        btnLogin.setVisible(true);
        btnExit.setVisible(true);
    }

    public void switchToAppointmentConfirmationPage() {
        JLabel confirmation = new JLabel("Your Appointment Has Been Confirmed");
        confirmation.setFont(new Font("Tahoma", Font.PLAIN, 15));
        confirmation.setBounds(35, 11, 77, 21);
        frmStudentInterface.getContentPane().add(confirmation);

        JButton btnbacktohome = new JButton("Back to Home");
        btnbacktohome.setBounds(10, 150, 121, 23);
        frmStudentInterface.getContentPane().add(btnbacktohome);

        btnbacktohome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                confirmation.setVisible(false);
                btnbacktohome.setVisible(false);

                switchToStudentSplashScreen();

            }

        });
    }

    public void switchToCancellationConfirmationPage() {
        JLabel confirmation = new JLabel("Your Appointment Has Been Cancelled");
        confirmation.setFont(new Font("Tahoma", Font.PLAIN, 10));
        confirmation.setBounds(35, 11, 77, 21);
        frmStudentInterface.getContentPane().add(confirmation);

        JButton btnbackhome = new JButton("Back to Home");
        btnbackhome.setBounds(30, 150, 121, 23);
        frmStudentInterface.getContentPane().add(btnbackhome);

        btnbackhome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                confirmation.setVisible(false);
                btnbackhome.setVisible(false);

                switchToStudentSplashScreen();

            }

        });
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
        } else {
            initializeLogin(frmStudentInterface);
        }

    }

    public void switchToCancelExamPage() {
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

        coursecomboBox = new JComboBox();
        coursecomboBox.setModel(new DefaultComboBoxModel(new String[]{"CSE 308"}));
        coursecomboBox.setBounds(104, 44, 81, 20);
        frmStudentInterface.getContentPane().add(coursecomboBox);

        JLabel lblExam = new JLabel("Exam:");
        lblExam.setBounds(33, 77, 46, 14);
        frmStudentInterface.getContentPane().add(lblExam);

        examcomboBox = new JComboBox();
        examcomboBox.setModel(new DefaultComboBoxModel(new String[]{"Midterm 1"}));
        examcomboBox.setBounds(104, 74, 81, 20);
        frmStudentInterface.getContentPane().add(examcomboBox);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(15, 113, 89, 23);
        frmStudentInterface.getContentPane().add(btnCancel);

        JButton btnConfirm = new JButton("Confirm");
        btnConfirm.setBounds(114, 113, 89, 23);
        frmStudentInterface.getContentPane().add(btnConfirm);

        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

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

    public void switchToTakeExamPage(Student s) {
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

        String[] courselist = new String[5];
        String query = "Select * from course group by CourseName";
        java.sql.ResultSet rs = DBConnection.ExecQuery(query);
        int i = 0;
        try {
            while (rs.next()) {

                courselist[i] = rs.getString(3);
                
                courses[i] = new Course();
                courses[i].setCourseID(rs.getString(1));
                courses[i].setDepartment(rs.getString(2));
                courses[i].setCoursename(rs.getString(3));
                courses[i].setCoursedescription(rs.getString(4));
                i++;
                //System.out.println(courses[i].getCoursename());

            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        coursecomboBox = new JComboBox();
        coursecomboBox.setModel(new DefaultComboBoxModel(courselist));
        coursecomboBox.setBounds(111, 47, 94, 20);
        frmStudentInterface.getContentPane().add(coursecomboBox);

        coursecomboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                System.out.println(coursecomboBox.getSelectedItem().toString());
                String[] exams = new String[5];
                String query = "Select examname from exam e, courseexam c where e.examID = c.examID"
                        //+ " AND c.course = CSE 308";
                        + " AND c.Course = '" + coursecomboBox.getSelectedItem().toString() + "'";
                java.sql.ResultSet rs = DBConnection.ExecQuery(query);
                int i = 0;
                try {
                    while (rs.next()) {

                        exams[i] = rs.getString(1);
                        
                        i++;

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
               
                
            examcomboBox.setModel(new DefaultComboBoxModel(exams));
        //examcomboBox.setBounds(111, 75, 94, 20);
        //frmStudentInterface.getContentPane().add(examcomboBox);
            }

        });

        String select = coursecomboBox.getSelectedItem().toString();
        System.out.println(select);

        examcomboBox = new JComboBox();
        examcomboBox.setModel(new DefaultComboBoxModel());
        examcomboBox.setBounds(111, 75, 94, 20);
        frmStudentInterface.getContentPane().add(examcomboBox);

        JLabel lblExam = new JLabel("Exam:");
        lblExam.setBounds(28, 78, 46, 14);
        frmStudentInterface.getContentPane().add(lblExam);

        timecomboBox = new JComboBox();
        timecomboBox.setModel(new DefaultComboBoxModel(new String []{"1:00", "1:30", "2:00", "2:30"
        + "3:00", "3:30", "4:00", "4:30", "5:00", "5:30", "6:00", "6:30", "7:00", "7:30", "8:00"
        + "8:30", "9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30"}));
        timecomboBox.setBounds(111, 106, 44, 20);
        frmStudentInterface.getContentPane().add(timecomboBox);
        
        ampmcomboBox = new JComboBox();
        ampmcomboBox.setModel(new DefaultComboBoxModel(new String[]{"AM", "PM"}));
        ampmcomboBox.setBounds(171, 106, 44, 20);
        frmStudentInterface.getContentPane().add(ampmcomboBox);
        

        JLabel lblTime = new JLabel("Time:");
        lblTime.setBounds(28, 109, 46, 14);
        frmStudentInterface.getContentPane().add(lblTime);

        dateChooser = new JDateChooser();
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

                switchToStudentSplashScreen();

            }

        });

        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                lblTakeAnExam.setVisible(false);
                lblCourses.setVisible(false);
                coursecomboBox.setVisible(false);
                examcomboBox.setVisible(false);
                lblExam.setVisible(false);
                ampmcomboBox.setVisible(false);
                timecomboBox.setVisible(false);
                lblTime.setVisible(false);
                dateChooser.setVisible(false);
                lblDate.setVisible(false);
                btnCancel.setVisible(false);
                btnSubmit.setVisible(false);
                
                //coursecomboBox.getSelectedItem();
                int i = 0;
                for(i = 0; i<courses.length; i++)
                {
                    if(courses[i].getCoursename().equals(coursecomboBox.getSelectedItem()))
                        break;
                }
                
                Exam exam = new Exam();
                
                String query = "Select * from Exam";
                java.sql.ResultSet rs = DBConnection.ExecQuery(query);
                
                try {
                    while (rs.next()) {
                        String id = rs.getString(1);
                        int intid = Integer.parseInt(id);
                        
                        exam.setExamID(intid);
                        exam.setStartDate(rs.getString(2));
                        exam.setEndDate(rs.getString(3));
                        exam.setStartTime(rs.getString(4));
                        exam.setEndTime(rs.getString(5));
                        
                        String seats = rs.getString(6);
                        int intseats = Integer.parseInt(seats);
                        exam.setSeatsAvailable(intseats);
                        
                        exam.setTerm(rs.getString(7));
                        exam.setExamtype(rs.getString(8));
                        exam.setExamname(rs.getString(9));
                       

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                //System.out.println(courses[i].getCoursename());
                
                
                if(courses[i].lookupstudent(s) == false)
                    switchToCannotSchedulePage("You are not currently enrolled in this course");
                else if(exam.lookupstudent(s) == true)
                    switchToCannotSchedulePage("You already have an appointment for this exam");
                else
                    switchToAppointmentConfirmationPage();

            }

        });
        
    }

public void switchToCannotSchedulePage(String m){
        JLabel notapproved = new JLabel(m);
        notapproved.setFont(new Font("Tahoma", Font.PLAIN, 15));
        notapproved.setBounds(35, 11, 277, 21);
        frmStudentInterface.getContentPane().add(notapproved);

        JButton btnbacktohome = new JButton("Back to Home");
        btnbacktohome.setBounds(10, 150, 121, 23);
        frmStudentInterface.getContentPane().add(btnbacktohome);

        btnbacktohome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                notapproved.setVisible(false);
                btnbacktohome.setVisible(false);

                switchToStudentSplashScreen();

            }

        });
    }
}
