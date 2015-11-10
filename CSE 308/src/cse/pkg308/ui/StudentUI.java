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
import cse.pkg308.ui.PrintTime;
import cse.pkg308.ui.UserUI;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

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
    public static JLabel time;

    public static JComboBox coursecomboBox;
    public static JComboBox examcomboBox;
    public static JComboBox datecomboBox;
    public static JComboBox timecomboBox;
    public static JComboBox ampmcomboBox;
    public static JDateChooser dateChooser;

    public JFrame frmTakeAnExam;
    public JTextField txtPm;

    public static Course[] courses = new Course[5];
    public static Exam[] examlist = new Exam[5];

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

        time = user.time;
        time.setFont(new Font("Tahoma", Font.BOLD, 11));
        time.setBounds(21, 238, 146, 21);
        frmStudentInterface.getContentPane().add(time);

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

        btnLogOut.setVisible(true);

        btnLogOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmStudentInterface.setVisible(false);
                

                //sessionframe.setVisible(true);
                user.initializeLogin(sessionframe);
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

                switchToTermPage(s, "Take");

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

                switchToTermPage(s, "Cancel");

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

    public void switchToAppointmentConfirmationPage(Student s, Exam exam, Date date) {
        JLabel confirmation = new JLabel("Your Appointment Has Been Confirmed");
        confirmation.setFont(new Font("Tahoma", Font.PLAIN, 15));
        confirmation.setBounds(35, 11, 177, 21);
        frmStudentInterface.getContentPane().add(confirmation);
        System.out.println(date);

        JButton btnbacktohome = new JButton("Back to Home");
        btnbacktohome.setBounds(10, 150, 121, 23);
        frmStudentInterface.getContentPane().add(btnbacktohome);

        String query = "Select (Max(appointmentID)+1) from appointment";
        java.sql.ResultSet rs = DBConnection.ExecQuery(query);

        String id = "";

        try {
            while (rs.next()) {
                id = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        Appointment app = new Appointment();
        app.addappointment(exam.getExamID(), s.getID() + "", date);
        System.out.println(s.getID());

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

    public void switchToCancelExamPage(Student s, String term) {

        JLabel lblCancelAnExam = new JLabel("Cancel an Exam");
        lblCancelAnExam.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblCancelAnExam.setBounds(33, 11, 142, 25);
        frmStudentInterface.getContentPane().add(lblCancelAnExam);

        JLabel lblCourse = new JLabel("Course:");
        lblCourse.setBounds(33, 47, 46, 14);
        frmStudentInterface.getContentPane().add(lblCourse);


        /*coursecomboBox = new JComboBox();
         coursecomboBox.setModel(new DefaultComboBoxModel(new String[]{"CSE 308"}));
         coursecomboBox.setBounds(104, 44, 81, 20);
         frmStudentInterface.getContentPane().add(coursecomboBox);*/
        JLabel lblExam = new JLabel("Exam:");
        lblExam.setBounds(33, 77, 46, 14);
        frmStudentInterface.getContentPane().add(lblExam);

        String exams[] = new String[5];

        String query = "Select e.examname from exam e, forexam f, appointment a, has h where "
                + "e.examID = f.examID AND f.appointmentID = a.appointmentID AND a.appointmentID"
                + " = h.appointmentID AND h.studentID = '" + s.getID() + "' AND e.term = '" + term + "'";

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

        examcomboBox = new JComboBox();
        examcomboBox.setModel(new DefaultComboBoxModel(exams));
        examcomboBox.setBounds(104, 74, 181, 20);
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
                //coursecomboBox.setVisible(false);
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
                //coursecomboBox.setVisible(false);
                examcomboBox.setVisible(false);
                lblExam.setVisible(false);
                btnCancel.setVisible(false);
                btnConfirm.setVisible(false);

                String query = "Select a.appointmentID from appointment a, forexam f, exam e, has h where"
                        + " e.examname = '" + examcomboBox.getSelectedItem().toString() + "' AND "
                        + "e.examID = f.examID AND f.appointmentID = a.appointmentID AND a.appointmentID = "
                        + "h.appointmentID AND h.studentID = '" + s.getID() + "' AND e.term = '" + term + "'";

                java.sql.ResultSet rs = DBConnection.ExecQuery(query);

                String id = "";
                try {
                    while (rs.next()) {
                        id = rs.getString(1);
                        System.out.println(id);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }

                System.out.println(examcomboBox.getSelectedItem().toString());
                System.out.println(s.getID());

                if (PrintTime.morethanaday(examcomboBox.getSelectedItem().toString(), term)) {
                    

                    query = "Select i.examid, i.date, i.seatsavailable from individualexam i, forexam f, appointment a where"
                            + " i.examid = f.examid AND f.appointmentid = a.appointmentID AND a.appointmentID"
                            + " = '" + id + "' AND a.date = i.date";

                    rs = DBConnection.ExecQuery(query);
                    String date = "";
                    String examid = "";
                    int seats = 0;
                    try {
                        while (rs.next()) {
                            examid = rs.getString(1);
                            date = rs.getString(2);
                            seats = rs.getInt(3);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    seats++;
                    query = "UPDATE individualexam SET seatsavailable ='" + seats + "' WHERE"
                            + " examid = '" + examid + "' AND date = '" + date + "'";
                    DBConnection.ExecUpdateQuery(query);
                    
                    query = "Delete from has where appointmentID = '" + id + "'";
                    DBConnection.ExecUpdateQuery(query);

                    query = "Delete from forexam where appointmentID = '" + id + "'";
                    DBConnection.ExecUpdateQuery(query);

                    query = "Delete from appointment where appointmentID = '" + id + "'";
                    DBConnection.ExecUpdateQuery(query);

                    switchToCancellationConfirmationPage();

                } else {
                    switchToCannotCancelPage();
                }

            }

        });
    }

    public void switchToCannotCancelPage() {
        JLabel notapproved = new JLabel("Your exam is less than 24 hours away. Cannot cancel");
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
    
    public void switchToTermPage(Student s, String option)
    {
        ArrayList<String> y = new ArrayList();
        String year = "";

        for (int i = 2010; i < 2017; i++) {
            year = i + "";
            y.add(year);
        }

        String[] years = new String[y.size()];

        for (int i = 0; i < y.size(); i++) {
            years[i] = y.get(i);
        }

        JComboBox season = new JComboBox();
        season.setModel(new DefaultComboBoxModel(new String[]{"Spring", "Summer", "Fall", "Winter"}));
        season.setBounds(111, 47, 94, 20);
        frmStudentInterface.getContentPane().add(season);

        JComboBox yearbox = new JComboBox();
        yearbox.setModel(new DefaultComboBoxModel(years));
        yearbox.setBounds(111, 77, 94, 20);
        frmStudentInterface.getContentPane().add(yearbox);

        JButton lookup = new JButton("View Term Appointments");
        lookup.setBounds(111, 107, 137, 23);
        frmStudentInterface.getContentPane().add(lookup);
        
        lookup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                season.setVisible(false);
                yearbox.setVisible(false);
                lookup.setVisible(false);
                
                String term = season.getSelectedItem() + "_" + yearbox.getSelectedItem();
                
                if(option.equals("Take"))
                    switchToTakeExamPage(s, term);
                else
                    switchToCancelExamPage(s, term);
            }
        });
    }

    public void switchToTakeExamPage(Student s, String term) {
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
        
        ArrayList <Course> cl = new ArrayList();

        String query = "Select * from course group by CourseName";
        java.sql.ResultSet rs = DBConnection.ExecQuery(query);
        int i = 0;
        try {
            while (rs.next()) {

                Course c = new Course();
                
                c.setCourseID(rs.getString(1));
                c.setDepartment(rs.getString(2));
                c.setCoursename(rs.getString(3));
                c.setCoursedescription(rs.getString(4));
                
                cl.add(c);

                //System.out.println(courses[i].getCoursename());

            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String [] courselist = new String[cl.size()];
        
        for(i = 0; i<cl.size(); i++)
        {
            courselist[i] = cl.get(i).getCoursename();
        }

        coursecomboBox = new JComboBox();
        coursecomboBox.setModel(new DefaultComboBoxModel(courselist));
        coursecomboBox.setBounds(111, 47, 94, 20);
        frmStudentInterface.getContentPane().add(coursecomboBox);
        
        ArrayList <String> exams = new ArrayList();
        ArrayList<Date> dates = new ArrayList();

        coursecomboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if(exams.size() > 0)
                {
                    for(int i = exams.size() - 1; i >= 0; i--)
                        exams.remove(i);
                    for(int i = dates.size() - 1; i >= 0; i--)
                        dates.remove(i);
                    
                    examcomboBox.setModel(new DefaultComboBoxModel());
                    datecomboBox.setModel(new DefaultComboBoxModel());
                timecomboBox.setModel(new DefaultComboBoxModel());
                }
                
                String query = "Select examname from exam e, courseexam c where e.examID = c.examID"
                        //+ " AND c.course = CSE 308";
                        + " AND c.Course = '" + coursecomboBox.getSelectedItem().toString() + "'"
                        + " AND e.term = '" + term + "'";
                java.sql.ResultSet rs = DBConnection.ExecQuery(query);
                int i = 0;
                try {
                    while (rs.next()) {
                        
                        exams.add(rs.getString(1));

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                String [] examlist = new String[exams.size()];
                
                for(i = 0; i < exams.size(); i++)
                {
                    examlist[i] = exams.get(i);
                }

                examcomboBox.setModel(new DefaultComboBoxModel(examlist));
                //examcomboBox.setBounds(111, 75, 94, 20);
                //frmStudentInterface.getContentPane().add(examcomboBox);
            }

        });

        //String select = coursecomboBox.getSelectedItem().toString();
        //System.out.println(select);
        examcomboBox = new JComboBox();
        examcomboBox.setModel(new DefaultComboBoxModel());
        examcomboBox.setBounds(111, 75, 194, 20);
        frmStudentInterface.getContentPane().add(examcomboBox);

        

        examcomboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                    for(int i = dates.size() - 1; i >= 0; i--)
                        dates.remove(i);

                    datecomboBox.setModel(new DefaultComboBoxModel());
                timecomboBox.setModel(new DefaultComboBoxModel());
                
                String[] stringdates = new String[5];
                String query = "Select startDate, endDate from exam where "
                        + "examname = '" + examcomboBox.getSelectedItem().toString() + "'"
                        + " AND term = '" + term + "'";
                //System.out.println(examcomboBox.getSelectedItem().toString());
                java.sql.ResultSet rs = DBConnection.ExecQuery(query);

                try {
                    while (rs.next()) {

                        //dates.add(rs.getDate(1));

                        Date tempdate = rs.getDate(1);
                        int j = 0;
                        Date temp2 = new Date();
                        Calendar cal = Calendar.getInstance();

                        while (temp2.getDate() != rs.getDate(2).getDate()) {

                            temp2 = new Date();

                            temp2.setYear(tempdate.getYear());
                            temp2.setMonth(tempdate.getMonth());
                            temp2.setDate(tempdate.getDate() + j);


                            cal.set(Calendar.YEAR, tempdate.getYear());
                            cal.set(Calendar.MONTH, tempdate.getMonth());
                            cal.set(Calendar.DAY_OF_MONTH, tempdate.getDate() + j);

                            java.sql.Date newdate = new java.sql.Date(cal.getTimeInMillis());
                            newdate.setYear(tempdate.getYear());

                            dates.add(newdate);

                            j++;
                        }

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }

                Date[] datearray = new Date[dates.size()];
                for (int i = 0; i < datearray.length; i++) {
                    datearray[i] = dates.get(i);
                }

                Time[] times = new Time[5];

                query = "Select StartTime from exam where "
                        + "examname = '" + examcomboBox.getSelectedItem().toString() + "'"
                        + " AND term = '" + term + "'";
                //System.out.println(examcomboBox.getSelectedItem().toString());
                rs = DBConnection.ExecQuery(query);
                int i = 0;
                try {
                    while (rs.next()) {

                        times[i] = rs.getTime(1);

                        i++;

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }

                datecomboBox.setModel(new DefaultComboBoxModel(datearray));
                timecomboBox.setModel(new DefaultComboBoxModel(times));
                //examcomboBox.setBounds(111, 75, 94, 20);
                //frmStudentInterface.getContentPane().add(examcomboBox);
            }

        });

        datecomboBox = new JComboBox();
        datecomboBox.setModel(new DefaultComboBoxModel());
        datecomboBox.setBounds(111, 137, 94, 20);
        frmStudentInterface.getContentPane().add(datecomboBox);

        JLabel lblExam = new JLabel("Exam:");
        lblExam.setBounds(28, 78, 46, 14);
        frmStudentInterface.getContentPane().add(lblExam);

        timecomboBox = new JComboBox();
        //timecomboBox.setModel(new DefaultComboBoxModel(new String[]{"1:00", "1:30", "2:00", "2:30"
        //    + "3:00", "3:30", "4:00", "4:30", "5:00", "5:30", "6:00", "6:30", "7:00", "7:30", "8:00"
        //    + "8:30", "9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30"}));
        timecomboBox.setModel(new DefaultComboBoxModel());
        timecomboBox.setBounds(111, 106, 144, 20);
        frmStudentInterface.getContentPane().add(timecomboBox);

        /*ampmcomboBox = new JComboBox();
         ampmcomboBox.setModel(new DefaultComboBoxModel(new String[]{"AM", "PM"}));
         ampmcomboBox.setBounds(171, 106, 44, 20);
         frmStudentInterface.getContentPane().add(ampmcomboBox);*/
        JLabel lblTime = new JLabel("Time:");
        lblTime.setBounds(28, 109, 46, 14);
        frmStudentInterface.getContentPane().add(lblTime);

        /*dateChooser = new JDateChooser();
         dateChooser.setBounds(111, 137, 94, 20);
         frmStudentInterface.getContentPane().add(dateChooser);*/
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
                timecomboBox.setVisible(false);
                //ampmcomboBox.setVisible(false);
                lblTime.setVisible(false);
                //dateChooser.setVisible(false);
                datecomboBox.setVisible(false);
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
                //ampmcomboBox.setVisible(false);
                timecomboBox.setVisible(false);
                lblTime.setVisible(false);
                //dateChooser.setVisible(false);
                datecomboBox.setVisible(false);
                lblDate.setVisible(false);
                btnCancel.setVisible(false);
                btnSubmit.setVisible(false);

                //coursecomboBox.getSelectedItem();
                int i = 0;
                for (i = 0; i < courselist.length; i++) {
                    if (courselist[i].equals(coursecomboBox.getSelectedItem())) {
                        break;
                    }
                }

                Exam exam = new Exam();

                String query = "Select * from Exam where examname = '" + examcomboBox.getSelectedItem().toString() + "'";
                // + " AND startDate = '" + datecomboBox.getSelectedItem() + "'"
                // + " AND startTime = '" + timecomboBox.getSelectedItem() + "'";
                java.sql.ResultSet rs = DBConnection.ExecQuery(query);

                try {
                    while (rs.next()) {
                        String id = rs.getString(1);
                        int intid = Integer.parseInt(id);

                        exam.setExamID(intid);
                        exam.setStartDate(rs.getDate(2));
                        exam.setEndDate(rs.getDate(3));
                        exam.setStartTime(rs.getTime(4));
                        exam.setEndTime(rs.getTime(5));

                        String seats = rs.getString(6);
                        int intseats = Integer.parseInt(seats);
                        exam.setSeatsAvailable(intseats);

                        exam.setTerm(rs.getString(7));
                        exam.setExamtype(rs.getString(8));
                        exam.setExamname(rs.getString(9));
                        System.out.println(exam.getExamID());

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (cl.get(i).lookupstudent(s.getID() + "") == false) {
                    switchToCannotSchedulePage("You are not currently enrolled in this course");
                } else if (exam.lookupstudent(s.getID() + "") == true) {
                    switchToCannotSchedulePage("You already have an appointment for this exam");
                } else if (exam.availableseats(exam.getExamID() + "", dates.get(datecomboBox.getSelectedIndex())) == false) {
                    switchToCannotSchedulePage("No Available Seats");
                } else {
                    System.out.println("HIIII");
                    switchToAppointmentConfirmationPage(s, exam, dates.get(datecomboBox.getSelectedIndex()));
                }

            }

        });

    }

    public void switchToCannotSchedulePage(String m) {
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
