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

    public static JLabel lblName;
    public static JLabel student;
    public static JLabel studentname;
    public static JLabel lblId;
    public static JLabel studentId;
    public static JCalendar calendar;
    public static JButton btnTakeAnExam;
    public static JButton btnCancelAnExam;
    public static JButton btnview;
    public static JButton btnLogOut;
    public static JLabel time;

    public static JComboBox coursecomboBox;
    public static JComboBox examcomboBox;
    public static JComboBox datecomboBox;
    public static JComboBox timecomboBox;

    public void initializestudent(Student s) {

        frmStudentInterface = new JFrame();
        frmStudentInterface.setVisible(true);

        frmStudentInterface.setTitle("Student Interface");
        frmStudentInterface.setBounds(100, 100, 477, 344);
        frmStudentInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmStudentInterface.getContentPane().setLayout(null);

        /*
         Display current time
         */
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

        /*
         Display Student's name
         */
        studentname = new JLabel(s.getName());
        studentname.setBounds(65, 41, 77, 14);
        frmStudentInterface.getContentPane().add(studentname);

        lblId = new JLabel("ID:");
        lblId.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblId.setBounds(21, 57, 46, 14);
        frmStudentInterface.getContentPane().add(lblId);

        /*
         Display Student ID
         */
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

        btnview = new JButton("View Appointments");
        btnview.setBounds(10, 150, 121, 23);
        frmStudentInterface.getContentPane().add(btnview);

        btnLogOut = new JButton("Log Out");
        btnLogOut.setBounds(261, 175, 89, 23);
        frmStudentInterface.getContentPane().add(btnLogOut);

        btnLogOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                /*
                 Close Student Page and open a new user frame to log out
                 */
                JFrame sessionframe = new JFrame();
                sessionframe.setVisible(true);

                user.continueLogin(sessionframe);

                frmStudentInterface.setVisible(false);

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
                btnview.setVisible(false);
                btnLogOut.setVisible(false);

                /*
                 Select a term for an appointment student will take when take 
                 exam button is clicked
                 */
                switchToTermPage(s, "Take");

            }

        });

        btnview.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblName.setVisible(false);
                student.setVisible(false);
                studentname.setVisible(false);
                lblId.setVisible(false);
                studentId.setVisible(false);
                calendar.setVisible(false);
                btnTakeAnExam.setVisible(false);
                btnCancelAnExam.setVisible(false);
                btnview.setVisible(false);
                btnLogOut.setVisible(false);

                /*
                 Create an ArrayList of years
                 */
                ArrayList<String> y = new ArrayList();
                String year = "";

                for (int i = 2010; i < 2017; i++) {
                    year = i + "";
                    y.add(year);
                }

                /*
                 Create an identical array of years to be displayed in the combo box
                 */
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

                        /*
                         Set term to the selected season and year
                         */
                        String term = season.getSelectedItem() + "_" + yearbox.getSelectedItem();

                        String query = "Select a.checkedin, a.date, a.starttime, a.endtime, e.examname from has h, forexam f,"
                                + " appointment a, exam e where e.examID = f.examID AND f.appointmentID = a.appointmentID"
                                + " AND e.term = '" + term + "' AND a.appointmentID = h.appointmentID AND h.studentID = '" + s.getID() + "'";
                        java.sql.ResultSet rs = DBConnection.ExecQuery(query);

                        ArrayList<String> applist = new ArrayList();

                        try {
                            while (rs.next()) {
                                applist.add(rs.getString(5) + ": " + rs.getString(2) + "   " + rs.getString(3)
                                        + "-" + rs.getString(4) + "   Status: " + rs.getString(1));

                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(StudentUI.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        String[] apparray = new String[applist.size()];
                        for (int i = 0; i < apparray.length; i++) {
                            apparray[i] = applist.get(i);
                        }

                        JComboBox apps = new JComboBox();
                        apps.setModel(new DefaultComboBoxModel(apparray));
                        apps.setBounds(104, 74, 241, 20);
                        frmStudentInterface.getContentPane().add(apps);

                    }
                });
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
                btnview.setVisible(false);
                btnLogOut.setVisible(false);

                /*
                 Select a term for an appointment Student will cancel when 
                 cancel exam button is clicked
                 */
                switchToTermPage(s, "Cancel");

            }
        });
    }

    public void switchToStudentSplashScreen(Student s) {
        lblName.setVisible(true);
        student.setVisible(true);
        studentname.setVisible(true);
        lblId.setVisible(true);
        studentId.setVisible(true);
        calendar.setVisible(true);
        btnTakeAnExam.setVisible(true);
        btnCancelAnExam.setVisible(true);
        btnview.setVisible(true);
        btnLogOut.setVisible(true);
    }

    public void switchToAppointmentConfirmationPage(Student s, Exam exam, Date date, Time time) {
        JLabel confirmation = new JLabel("Your Appointment Has Been Confirmed");
        confirmation.setFont(new Font("Tahoma", Font.PLAIN, 15));
        confirmation.setBounds(35, 11, 177, 21);
        frmStudentInterface.getContentPane().add(confirmation);

        JButton btnbacktohome = new JButton("Back to Home");
        btnbacktohome.setBounds(10, 150, 121, 23);
        frmStudentInterface.getContentPane().add(btnbacktohome);

        /*
         Create a new appointment object with the student id and selected exam id and date
         */
        Appointment app = new Appointment();
        app.addappointment(exam.getExamID(), s.getID() + "", date, time);

        btnbacktohome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                confirmation.setVisible(false);
                btnbacktohome.setVisible(false);

                switchToStudentSplashScreen(s);

            }

        });
    }

    public void switchToCancellationConfirmationPage(Student s) {
        /*
         Display confirmation that appointment was cancelled
         */
        JLabel confirmation = new JLabel("Your Appointment Has Been Cancelled");
        confirmation.setFont(new Font("Tahoma", Font.PLAIN, 10));
        confirmation.setBounds(35, 11, 77, 21);
        frmStudentInterface.getContentPane().add(confirmation);

        JButton btnbackhome = new JButton("Back to Home");
        btnbackhome.setBounds(30, 150, 121, 23);
        frmStudentInterface.getContentPane().add(btnbackhome);

        /*
         Return to the Student Splash Screen after back to home button is clicked
         */
        btnbackhome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                confirmation.setVisible(false);
                btnbackhome.setVisible(false);

                switchToStudentSplashScreen(s);

            }

        });
    }

    public void switchToCancelExamPage(Student s, String term) {

        JLabel lblCancelAnExam = new JLabel("Cancel an Exam");
        lblCancelAnExam.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblCancelAnExam.setBounds(33, 11, 142, 25);
        frmStudentInterface.getContentPane().add(lblCancelAnExam);

        JLabel lblCourse = new JLabel("Course:");
        lblCourse.setBounds(33, 47, 46, 14);
        frmStudentInterface.getContentPane().add(lblCourse);

        JLabel lblExam = new JLabel("Exam:");
        lblExam.setBounds(33, 77, 46, 14);
        frmStudentInterface.getContentPane().add(lblExam);

        /*
         Create an ArrayList for the exam names
         */
        ArrayList<String> examlist = new ArrayList();

        /*
         This query returns the names of all the exams the student has an appointment for in the
         selected term
         */
        String query = "Select e.examname from exam e, forexam f, appointment a, has h where "
                + "e.examID = f.examID AND f.appointmentID = a.appointmentID AND a.appointmentID"
                + " = h.appointmentID AND h.studentID = '" + s.getID() + "' AND e.term = '" + term + "'";

        java.sql.ResultSet rs = DBConnection.ExecQuery(query);
        try {
            while (rs.next()) {
                examlist.add(rs.getString(1));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        String[] exams = new String[examlist.size()];
        for (int i = 0; i < exams.length; i++) {
            exams[i] = examlist.get(i);
        }

        /*
         Display list of exams from a duplicated array from the ArrayList
         */
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
                examcomboBox.setVisible(false);
                lblExam.setVisible(false);
                btnCancel.setVisible(false);
                btnConfirm.setVisible(false);

                switchToStudentSplashScreen(s);

            }

        });

        btnConfirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                lblCancelAnExam.setVisible(false);
                lblCourse.setVisible(false);
                examcomboBox.setVisible(false);
                lblExam.setVisible(false);
                btnCancel.setVisible(false);
                btnConfirm.setVisible(false);

                /*
                 If the Confirm button is clicked, this query will return the appointment ID
                 the student wants to cancel
                 */
                String query = "Select a.appointmentID from appointment a, forexam f, exam e, has h where"
                        + " e.examname = '" + examcomboBox.getSelectedItem().toString() + "' AND "
                        + "e.examID = f.examID AND f.appointmentID = a.appointmentID AND a.appointmentID = "
                        + "h.appointmentID AND h.studentID = '" + s.getID() + "' AND e.term = '" + term + "'";

                java.sql.ResultSet rs = DBConnection.ExecQuery(query);

                String id = "";
                try {
                    while (rs.next()) {
                        id = rs.getString(1);

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                /*
                 Check if the appointment is less than 24 hours away
                 */
                if (PrintTime.morethanaday(examcomboBox.getSelectedItem().toString(), term)) {
                    Appointment app = new Appointment();
                    app.deleteappointment(id);

                    switchToCancellationConfirmationPage(s);

                } else {
                    switchToCannotCancelPage(s);
                }

            }

        });
    }

    public void switchToCannotCancelPage(Student s) {
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

                switchToStudentSplashScreen(s);

            }

        });
    }

    public void switchToTermPage(Student s, String option) {
        /*
         Create an ArrayList of years
         */
        ArrayList<String> y = new ArrayList();
        String year = "";

        for (int i = 2010; i < 2017; i++) {
            year = i + "";
            y.add(year);
        }

        /*
         Create an identical array of years to be displayed in the combo box
         */
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

                /*
                 Set term to the selected season and year
                 */
                String term = season.getSelectedItem() + "_" + yearbox.getSelectedItem();

                /*
                 If Student wants to make an appointment, go to switchToTakeExamPage. If Student
                 wants to cancel an appointment, go to switchToCancelExamPage. These pages will
                 give Student a list of exam appointments to make or cancel
                 */
                if (option.equals("Take")) {
                    switchToTakeExamPage(s, term);
                } else {
                    switchToCancelExamPage(s, term);
                }
            }
        });
    }

    public void switchToTakeExamPage(Student s, String term) {

        JLabel lblTakeAnExam = new JLabel("Take an Exam");
        lblTakeAnExam.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblTakeAnExam.setBounds(44, 11, 140, 25);
        frmStudentInterface.getContentPane().add(lblTakeAnExam);

        JLabel lblCourses = new JLabel("Courses:");
        lblCourses.setBounds(28, 50, 46, 14);
        frmStudentInterface.getContentPane().add(lblCourses);

        /*
         Create ArrayList of Courses. The query returns all course information with group by coursename
         keeping duplicates from being returned. A new course object is created with each course with
         the information entered into each object.
         */
        ArrayList<Course> cl = new ArrayList();

        String query = "Select * from course where term = '" + term + "'";
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

            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*
         Create equivalent array for course names
         */
        String[] courselist = new String[cl.size()];

        for (i = 0; i < cl.size(); i++) {
            courselist[i] = cl.get(i).getCoursename();
        }

        /*
         Display list of course names in combo box
         */
        coursecomboBox = new JComboBox();
        coursecomboBox.setModel(new DefaultComboBoxModel(courselist));
        coursecomboBox.setBounds(111, 47, 94, 20);
        frmStudentInterface.getContentPane().add(coursecomboBox);

        /*
         Empty ArrayLists for exam names and exam dates
         */
        ArrayList<String> exams = new ArrayList();
        ArrayList<Date> dates = new ArrayList();

        coursecomboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                /*
                 When a course object is selected, it clears the exam and date lists if
                 they have data inside
                 */
                if (exams.size() > 0) {
                    for (int i = exams.size() - 1; i >= 0; i--) {
                        exams.remove(i);
                    }
                    for (int i = dates.size() - 1; i >= 0; i--) {
                        dates.remove(i);
                    }

                    examcomboBox.setModel(new DefaultComboBoxModel());
                    datecomboBox.setModel(new DefaultComboBoxModel());
                    //timecomboBox.setModel(new DefaultComboBoxModel());
                }

                /*
                 This query returns all of the exam names where the course is equal to the selected
                 course combo box item and where the term equals the entered term. Add the exams
                 to an ArrayList that will be displayed in a separate combo box
                 */
                String query = "Select examname from exam e, courseexam c where e.examID = c.examID"
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

                /*
                 Display list of exams with an array equal to the ArrayList
                 */
                String[] examlist = new String[exams.size()];

                for (i = 0; i < exams.size(); i++) {
                    examlist[i] = exams.get(i);
                }

                examcomboBox.setModel(new DefaultComboBoxModel(examlist));

            }

        });

        TestingCenter t = new TestingCenter();
        t.setTerm(term);
        query = "Select Opens, Closes from testingcenter where term = '" + term + "'";
        rs = DBConnection.ExecQuery(query);
        Time open = null;
        Time close = null;
        try {
            while (rs.next()) {
                open = rs.getTime(1);
                close = rs.getTime(2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        Time ti = new Time(open.getHours(), open.getMinutes(), 0);
        close.setHours(close.getHours() - 2);

        ArrayList<Time> times = new ArrayList();

        while (ti.getTime() <= close.getTime()) {
            String query2 = "Select starttime, endtime from nonsbtimes where term = '" + term + "'";
            java.sql.ResultSet rs2 = DBConnection.ExecQuery(query2);
            Time nonsbstart = null;
            Time nonsbend = null;
            int checknonsb = 0;
            try {
                while (rs2.next()) {
                    nonsbstart = rs2.getTime(1);
                    nonsbstart.setMinutes(nonsbstart.getMinutes() - 30);
                    nonsbstart.setHours(nonsbstart.getHours() - 1);
                    nonsbend = rs2.getTime(2);
                    Time nonsbt = new Time(nonsbstart.getHours(), nonsbstart.getMinutes(), 0);

                    while (nonsbt.getTime() < nonsbend.getTime()) {
                        if (ti.getTime() == nonsbt.getTime()) {
                            checknonsb = 1;
                        }
                        nonsbt.setMinutes(nonsbt.getMinutes() + 30);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(StudentUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (checknonsb == 0) {
                Time temp = new Time(ti.getHours(), ti.getMinutes(), 0);
                times.add(temp);
            }
            ti.setMinutes(ti.getMinutes() + 30);
        }

        String[] timearray = new String[times.size()];
        for (int j = 0; j < timearray.length; j++) {
            if (times.get(j).getMinutes() < 10) {
                timearray[j] = times.get(j).getHours() + ":0" + times.get(j).getMinutes()
                        + "-" + (times.get(j).getHours() + 2) + ":0" + times.get(j).getMinutes();
            } else {
                timearray[j] = times.get(j).getHours() + ":" + times.get(j).getMinutes()
                        + "-" + (times.get(j).getHours() + 2) + ":" + times.get(j).getMinutes();
            }
            //System.out.println(timearray[j]);
        }

        examcomboBox = new JComboBox();
        examcomboBox.setModel(new DefaultComboBoxModel());
        examcomboBox.setBounds(111, 75, 194, 20);
        frmStudentInterface.getContentPane().add(examcomboBox);

        examcomboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                /*
                 If the exam combo box is selected, clear all the dates in the date ArrayList
                 */
                for (int i = dates.size() - 1; i >= 0; i--) {
                    dates.remove(i);
                }

                datecomboBox.setModel(new DefaultComboBoxModel());
                //timecomboBox.setModel(new DefaultComboBoxModel());

                /*
                 The query gets the start and end dates from the selected exam
                 */
                String query = "Select startDate, endDate from exam where "
                        + "examname = '" + examcomboBox.getSelectedItem().toString() + "'"
                        + " AND term = '" + term + "'";

                java.sql.ResultSet rs = DBConnection.ExecQuery(query);

                try {
                    while (rs.next()) {

                        Date tempdate = rs.getDate(1);
                        int j = 0;
                        Date temp2 = new Date();
                        Calendar cal = Calendar.getInstance();

                        /*
                         Iterate the dates from the start date leading up to the end date. Convert
                         the dates into an SQL format to be displayed and add to the date ArrayList.
                         */
                        while (temp2.getDate() != rs.getDate(2).getDate()) {

                            temp2 = new Date();

                            /*
                             Get the current date
                             */
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

                /*
                 Convert ArrayList of dates into an array to be displayed
                 */
                Date[] datearray = new Date[dates.size()];
                for (int i = 0; i < datearray.length; i++) {
                    datearray[i] = dates.get(i);
                }

                /*
                 Create a time for the start time. The query will return the start time of the 
                 selected exam
                 */
                /*
                 Display dates and start time of exam
                 */
                datecomboBox.setModel(new DefaultComboBoxModel(datearray));
                //timecomboBox.setModel(new DefaultComboBoxModel(times));

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
        timecomboBox.setModel(new DefaultComboBoxModel(timearray));
        timecomboBox.setBounds(111, 106, 144, 20);
        frmStudentInterface.getContentPane().add(timecomboBox);

        JLabel lblTime = new JLabel("Time:");
        lblTime.setBounds(28, 109, 46, 14);
        frmStudentInterface.getContentPane().add(lblTime);

        JLabel lblDate = new JLabel("Date:");
        lblDate.setBounds(28, 132, 46, 25);
        frmStudentInterface.getContentPane().add(lblDate);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(17, 173, 89, 23);
        frmStudentInterface.getContentPane().add(btnCancel);

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(116, 173, 89, 23);
        frmStudentInterface.getContentPane().add(btnSubmit);

        /*
         Go back to home page and don't make appointment
         */
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                lblTakeAnExam.setVisible(false);
                lblCourses.setVisible(false);
                coursecomboBox.setVisible(false);
                examcomboBox.setVisible(false);
                lblExam.setVisible(false);
                timecomboBox.setVisible(false);
                lblTime.setVisible(false);
                datecomboBox.setVisible(false);
                lblDate.setVisible(false);
                btnCancel.setVisible(false);
                btnSubmit.setVisible(false);

                switchToStudentSplashScreen(s);

            }

        });

        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                lblTakeAnExam.setVisible(false);
                lblCourses.setVisible(false);
                coursecomboBox.setVisible(false);
                examcomboBox.setVisible(false);
                lblExam.setVisible(false);
                timecomboBox.setVisible(false);
                lblTime.setVisible(false);
                datecomboBox.setVisible(false);
                lblDate.setVisible(false);
                btnCancel.setVisible(false);
                btnSubmit.setVisible(false);

                int i = 0;
                for (i = 0; i < courselist.length; i++) {
                    if (courselist[i].equals(coursecomboBox.getSelectedItem())) {
                        break;
                    }
                }

                /*
                 Create new exam object. The query will return the exam information of the exam selected
                 */
                Exam exam = new Exam();
                String query = "Select * from Exam where examname = '" + examcomboBox.getSelectedItem().toString() + "' AND term = '" + term + "'";
                java.sql.ResultSet rs = DBConnection.ExecQuery(query);

                try {
                    while (rs.next()) {

                        exam.setExamID(rs.getInt(1));
                        exam.setStartDate(rs.getDate(2));
                        exam.setEndDate(rs.getDate(3));
                        exam.setStartTime(rs.getTime(4));
                        exam.setEndTime(rs.getTime(5));

                        exam.setTerm(rs.getString(6));
                        exam.setExamtype(rs.getString(7));
                        exam.setExamname(rs.getString(8));

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }

                /*
                 From the selected course of the exam, check if the student is taking the course.
                 If they are not, the appointment cannot be scheduled, and the appropriate message
                 will be displayed.
                 */
                if (cl.get(i).lookupstudent(s.getID() + "") == false) {
                    switchToCannotSchedulePage(s, "You are not currently enrolled in this course");
                } /*
                 From the selected exam, check if the student already has an appointment for the exam
                 */ else if (exam.lookupstudent(s.getID() + "") == true) {
                    switchToCannotSchedulePage(s, "You already have an appointment for this exam");
                } /*
                 Check if there is a seat available
                 */ else if (exam.availableseats(exam.getExamID() + "", term, dates.get(datecomboBox.getSelectedIndex()), times.get(timecomboBox.getSelectedIndex())) == false) {
                    switchToCannotSchedulePage(s, "No Available Seats");
                } else {
                    //System.out.println(dates.get(datecomboBox.getSelectedIndex()));
                    switchToAppointmentConfirmationPage(s, exam, dates.get(datecomboBox.getSelectedIndex()), times.get(timecomboBox.getSelectedIndex()));
                }

            }

        });

    }

    public void switchToCannotSchedulePage(Student s, String m) {
        /*
         Display m, the message as the reason the appointment could not be scheduled
         */
        JLabel notapproved = new JLabel(m);
        notapproved.setFont(new Font("Tahoma", Font.PLAIN, 15));
        notapproved.setBounds(35, 11, 277, 21);
        frmStudentInterface.getContentPane().add(notapproved);

        JButton btnbacktohome = new JButton("Back to Home");
        btnbacktohome.setBounds(10, 150, 121, 23);
        frmStudentInterface.getContentPane().add(btnbacktohome);

        /*
         If the backtohome button is pressed, return to the student splash screen
         */
        btnbacktohome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                notapproved.setVisible(false);
                btnbacktohome.setVisible(false);

                switchToStudentSplashScreen(s);

            }

        });
    }
}
