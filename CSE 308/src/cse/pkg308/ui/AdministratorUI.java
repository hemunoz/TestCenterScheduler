package cse.pkg308.ui;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import cse.pkg308.DBConnection;
import static cse.pkg308.ui.Login.sessionframe;
import cse.pkg308.ui.UserUI;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
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
import org.apache.commons.io.FileUtils;

public class AdministratorUI {

    public static JFrame sessionframe;
    public static JFrame frmAdministratorInterface;
    public UserUI user = new UserUI();

    public static JTextField textFieldOpenTime;
    public static JTextField textFieldCloseTime;
    public static JTextField textFieldID;
    public static JLabel lblAdministrator;
    public static JLabel lblName;
    public static JLabel lblName2;
    public static JLabel lblNumberOfSeats;
    public static JComboBox comboBox;
    public static JLabel lblNumberOfReserved;
    public static JComboBox comboBox_1;
    public static JCalendar calendar;
    public static JLabel lblSemester;
    public static JComboBox comboBox_2;
    public static JLabel lblOpenTime;
    public static JDateChooser dateChooser;
    public static JLabel lblCloseTime;
    public static JLabel lblOpenDate;
    public static JDateChooser dateChooser_1;
    public static JLabel lblCloseDate;
    public static JButton btnLogOut;
    public static JButton btnImportData;
    public static JButton btnUtilization;
    public static JButton btnSchedulingRequests;
    public static JButton btnMakeAnAppointment;
    public static JButton btnCheckInStudent;
    public static JLabel lblStudentId;
    public static JButton btnGenerateReport;
    public static JButton btnAppointments;
    public static JButton btnedittestingcenter;
    public static JLabel time;

    public int buttonindex = 0;
    public static JComboBox examcomboBox;
    public static JComboBox datecomboBox;
    public static JComboBox timecomboBox;
    public static Course[] courses = new Course[5];

    public void initializeadmin(Administrator a) {
        frmAdministratorInterface = new JFrame();
        frmAdministratorInterface.setVisible(true);

        frmAdministratorInterface.setTitle("Administrator Interface");
        frmAdministratorInterface.setBounds(100, 100, 451, 441);
        frmAdministratorInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmAdministratorInterface.getContentPane().setLayout(null);

        time = user.time;
        time.setFont(new Font("Tahoma", Font.BOLD, 11));
        time.setBounds(21, 190, 146, 21);
        frmAdministratorInterface.getContentPane().add(time);

        lblAdministrator = new JLabel("Administrator");
        lblAdministrator.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblAdministrator.setBounds(158, 11, 121, 19);
        frmAdministratorInterface.getContentPane().add(lblAdministrator);

        lblName = new JLabel("Name:");
        lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblName.setBounds(10, 41, 46, 14);
        frmAdministratorInterface.getContentPane().add(lblName);

        lblName2 = new JLabel(a.getName());
        lblName2.setBounds(57, 41, 74, 14);
        frmAdministratorInterface.getContentPane().add(lblName2);

        btnedittestingcenter = new JButton("Edit Testing Center");
        btnedittestingcenter.setBounds(57, 100, 189, 23);
        frmAdministratorInterface.getContentPane().add(btnedittestingcenter);

        calendar = new JCalendar();
        calendar.setBounds(226, 41, 198, 153);
        frmAdministratorInterface.getContentPane().add(calendar);

        btnLogOut = new JButton("Log Out");
        btnLogOut.setBounds(335, 371, 89, 23);
        frmAdministratorInterface.getContentPane().add(btnLogOut);

        btnLogOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                /*
                 Close Administrator Page and open a new user frame to log out
                 */
                JFrame sessionframe = new JFrame();
                sessionframe.setVisible(true);

                user.continueLogin(sessionframe);

                frmAdministratorInterface.setVisible(false);
            }
        });

        btnImportData = new JButton("Import Data");
        btnImportData.setBounds(262, 205, 137, 23);
        frmAdministratorInterface.getContentPane().add(btnImportData);

        btnUtilization = new JButton("Utilization");
        btnUtilization.setBounds(57, 290, 89, 23);
        frmAdministratorInterface.getContentPane().add(btnUtilization);

        btnSchedulingRequests = new JButton("Scheduling Requests");
        btnSchedulingRequests.setBounds(262, 239, 137, 23);
        frmAdministratorInterface.getContentPane().add(btnSchedulingRequests);

        btnMakeAnAppointment = new JButton("Make an Appointment");
        btnMakeAnAppointment.setBounds(262, 273, 137, 23);
        frmAdministratorInterface.getContentPane().add(btnMakeAnAppointment);

        btnCheckInStudent = new JButton("Check In Student");
        btnCheckInStudent.setBounds(41, 371, 137, 23);
        frmAdministratorInterface.getContentPane().add(btnCheckInStudent);

        lblStudentId = new JLabel("Student ID:");
        lblStudentId.setBounds(10, 346, 56, 14);
        frmAdministratorInterface.getContentPane().add(lblStudentId);

        textFieldID = new JTextField();
        textFieldID.setText("");
        textFieldID.setBounds(76, 340, 126, 20);
        frmAdministratorInterface.getContentPane().add(textFieldID);
        textFieldID.setColumns(10);

        btnGenerateReport = new JButton("Generate Report");
        btnGenerateReport.setBounds(262, 305, 137, 23);
        frmAdministratorInterface.getContentPane().add(btnGenerateReport);

        btnAppointments = new JButton("View Appointments");
        btnAppointments.setBounds(262, 335, 137, 23);
        frmAdministratorInterface.getContentPane().add(btnAppointments);

        btnUtilization.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblName.setVisible(false);
                textFieldID.setVisible(false);
                lblAdministrator.setVisible(false);
                lblName2.setVisible(false);
                calendar.setVisible(false);
                btnLogOut.setVisible(false);
                lblName2.setVisible(false);
                btnImportData.setVisible(false);
                btnUtilization.setVisible(false);
                btnSchedulingRequests.setVisible(false);
                btnMakeAnAppointment.setVisible(false);
                btnCheckInStudent.setVisible(false);
                lblStudentId.setVisible(false);
                btnGenerateReport.setVisible(false);
                btnAppointments.setVisible(false);
                btnedittestingcenter.setVisible(false);

                switchToDisplayUtilization(a);
            }
        });

        /*
         If administrator wants to edit the testing center, switch to edit page
         */
        btnedittestingcenter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblName.setVisible(false);
                textFieldID.setVisible(false);
                lblAdministrator.setVisible(false);
                lblName2.setVisible(false);
                calendar.setVisible(false);
                btnLogOut.setVisible(false);
                lblName2.setVisible(false);
                btnImportData.setVisible(false);
                btnUtilization.setVisible(false);
                btnSchedulingRequests.setVisible(false);
                btnMakeAnAppointment.setVisible(false);
                btnCheckInStudent.setVisible(false);
                lblStudentId.setVisible(false);
                btnGenerateReport.setVisible(false);
                btnAppointments.setVisible(false);
                btnedittestingcenter.setVisible(false);

                switchToEditTestingCenter(a);
            }
        });

        btnGenerateReport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblName.setVisible(false);
                textFieldID.setVisible(false);
                lblAdministrator.setVisible(false);
                lblName2.setVisible(false);
                calendar.setVisible(false);
                btnLogOut.setVisible(false);
                lblName2.setVisible(false);
                btnImportData.setVisible(false);
                btnUtilization.setVisible(false);
                btnSchedulingRequests.setVisible(false);
                btnMakeAnAppointment.setVisible(false);
                btnCheckInStudent.setVisible(false);
                lblStudentId.setVisible(false);
                btnGenerateReport.setVisible(false);
                btnAppointments.setVisible(false);
                btnedittestingcenter.setVisible(false);

                switchToGenerateReports(a);
            }
        });

        btnSchedulingRequests.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblName.setVisible(false);
                textFieldID.setVisible(false);
                lblAdministrator.setVisible(false);
                lblName2.setVisible(false);
                calendar.setVisible(false);
                btnLogOut.setVisible(false);
                lblName2.setVisible(false);
                btnImportData.setVisible(false);
                btnUtilization.setVisible(false);
                btnSchedulingRequests.setVisible(false);
                btnMakeAnAppointment.setVisible(false);
                btnCheckInStudent.setVisible(false);
                lblStudentId.setVisible(false);
                btnGenerateReport.setVisible(false);
                btnAppointments.setVisible(false);
                btnedittestingcenter.setVisible(false);

                switchToViewRequests(a);
            }
        });

        btnAppointments.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                lblName.setVisible(false);
                textFieldID.setVisible(false);
                lblAdministrator.setVisible(false);
                lblName2.setVisible(false);
                calendar.setVisible(false);
                btnLogOut.setVisible(false);
                lblName2.setVisible(false);
                btnImportData.setVisible(false);
                btnUtilization.setVisible(false);
                btnSchedulingRequests.setVisible(false);
                btnMakeAnAppointment.setVisible(false);
                btnCheckInStudent.setVisible(false);
                lblStudentId.setVisible(false);
                btnGenerateReport.setVisible(false);
                btnAppointments.setVisible(false);
                btnedittestingcenter.setVisible(false);

                switchToViewAppointments(a);
            }
        });

        btnImportData.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                lblName.setVisible(false);
                textFieldID.setVisible(false);
                lblAdministrator.setVisible(false);
                lblName2.setVisible(false);
                calendar.setVisible(false);
                btnLogOut.setVisible(false);
                lblName2.setVisible(false);
                btnImportData.setVisible(false);
                btnUtilization.setVisible(false);
                btnSchedulingRequests.setVisible(false);
                btnMakeAnAppointment.setVisible(false);
                btnCheckInStudent.setVisible(false);
                lblStudentId.setVisible(false);
                btnGenerateReport.setVisible(false);
                btnAppointments.setVisible(false);
                btnedittestingcenter.setVisible(false);

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
                frmAdministratorInterface.getContentPane().add(season);

                JComboBox yearbox = new JComboBox();
                yearbox.setModel(new DefaultComboBoxModel(years));
                yearbox.setBounds(111, 77, 94, 20);
                frmAdministratorInterface.getContentPane().add(yearbox);

                JButton lookup = new JButton("View Term Appointments");
                lookup.setBounds(111, 107, 137, 23);
                frmAdministratorInterface.getContentPane().add(lookup);

                lookup.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        season.setVisible(false);
                        yearbox.setVisible(false);
                        lookup.setVisible(false);

                        String term = season.getSelectedItem() + "_" + yearbox.getSelectedItem();

                        try {
                            /*
                             Make an appointment for a student for selected term
                             */
                            switchToImport(a, term);
                        } catch (IOException ex) {
                            Logger.getLogger(AdministratorUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });

            }
        });

        /*
         Make an appointment for a student
         */
        btnMakeAnAppointment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                lblName.setVisible(false);
                textFieldID.setVisible(false);
                lblAdministrator.setVisible(false);
                lblName2.setVisible(false);
                calendar.setVisible(false);
                btnLogOut.setVisible(false);
                lblName2.setVisible(false);
                btnImportData.setVisible(false);
                btnUtilization.setVisible(false);
                btnSchedulingRequests.setVisible(false);
                btnMakeAnAppointment.setVisible(false);
                btnCheckInStudent.setVisible(false);
                lblStudentId.setVisible(false);
                btnGenerateReport.setVisible(false);
                btnAppointments.setVisible(false);
                btnedittestingcenter.setVisible(false);

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
                frmAdministratorInterface.getContentPane().add(season);

                JComboBox yearbox = new JComboBox();
                yearbox.setModel(new DefaultComboBoxModel(years));
                yearbox.setBounds(111, 77, 94, 20);
                frmAdministratorInterface.getContentPane().add(yearbox);

                JButton lookup = new JButton("View Term Appointments");
                lookup.setBounds(111, 107, 137, 23);
                frmAdministratorInterface.getContentPane().add(lookup);

                lookup.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        season.setVisible(false);
                        yearbox.setVisible(false);
                        lookup.setVisible(false);

                        String term = season.getSelectedItem() + "_" + yearbox.getSelectedItem();

                        /*
                         Make an appointment for a student for selected term
                         */
                        switchToMakeStudentAppointment(a, term);
                    }
                });

            }
        });
    }

    public void switchToMakeStudentAppointment(Administrator a, String term) {
        JLabel StudentID = new JLabel("Enter Student ID");
        StudentID.setBounds(76, 160, 256, 14);
        frmAdministratorInterface.getContentPane().add(StudentID);

        JTextField IDtext = new JTextField();
        IDtext.setBounds(76, 190, 186, 20);
        frmAdministratorInterface.getContentPane().add(IDtext);
        IDtext.setColumns(10);

        JButton btnID = new JButton("Search Student by ID");
        btnID.setBounds(76, 220, 237, 23);
        frmAdministratorInterface.getContentPane().add(btnID);

        JLabel Studentname = new JLabel("Enter Student Last Name");
        Studentname.setBounds(76, 40, 256, 14);
        frmAdministratorInterface.getContentPane().add(Studentname);

        JTextField nametext = new JTextField();
        nametext.setBounds(76, 70, 186, 20);
        frmAdministratorInterface.getContentPane().add(nametext);
        nametext.setColumns(10);

        JButton btnname = new JButton("Search Student by Last Name");
        btnname.setBounds(76, 100, 237, 23);
        frmAdministratorInterface.getContentPane().add(btnname);

        /*
         Search Student by last name
         */
        btnname.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StudentID.setVisible(false);
                IDtext.setVisible(false);
                btnID.setVisible(false);
                Studentname.setVisible(false);
                nametext.setVisible(false);
                btnname.setVisible(false);

                int i = 0;
                ArrayList<JButton> btnapp = new ArrayList();
                ArrayList<JLabel> lblapp = new ArrayList();

                /*
                 This query returns the Students with the last name entered
                 */
                String query = "SELECT u.name from user u, student s where u.lastname = '" + nametext.getText() + "'"
                        + "AND s.studentid = u.userid";

                java.sql.ResultSet rs = DBConnection.ExecQuery(query);

                try {
                    /*
                     Create a new button for the student name returned
                     */
                    while (rs.next()) {
                        i++;
                        JButton testbutton = new JButton(rs.getString(1));
                        btnapp.add(testbutton);

                        JLabel lblname = new JLabel(rs.getString(1));
                        lblapp.add(lblname);

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }

                //System.out.println(i);
                int j = 0;

                /*
                 Set bounds for the buttons of student names with actionlisteners
                 */
                for (j = 0; j < i; j++) {
                    lblapp.get(j).setBounds(10, 50 + (j * 35), 137, 23);
                    frmAdministratorInterface.getContentPane().add(lblapp.get(j));

                    btnapp.get(j).setBounds(176, 50 + (j * 35), 137, 23);
                    frmAdministratorInterface.getContentPane().add(btnapp.get(j));

                    /*
                     Make appointment for selected student
                     */
                    btnapp.get(j).addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            /*
                             This query returns the userID of selected student and switches to appointment page
                             */
                            String query = "Select userid from user where name = '" + e.getActionCommand() + "'";
                            String id = "";
                            java.sql.ResultSet rs = DBConnection.ExecQuery(query);

                            try {
                                while (rs.next()) {
                                    id = rs.getString(1);

                                }
                            } catch (SQLException ex) {
                                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            for (int k = 0; k < btnapp.size(); k++) {
                                btnapp.get(k).setVisible(false);
                                lblapp.get(k).setVisible(false);
                            }

                            switchToSelectExamPage(a, id, term);

                        }
                    });
                }
            }
        });

        /*
         Lookup student by ID
         */
        btnID.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StudentID.setVisible(false);
                IDtext.setVisible(false);
                btnID.setVisible(false);
                Studentname.setVisible(false);
                nametext.setVisible(false);
                btnname.setVisible(false);

                int i = 0;
                ArrayList<JButton> btnapp = new ArrayList();
                ArrayList<JLabel> lblapp = new ArrayList();

                /*
                 This query returns the student with the entered user ID
                 */
                String query = "SELECT u.name from user u where u.userid = '" + IDtext.getText() + "'"
                        + "AND s.studentid = u.userid";

                java.sql.ResultSet rs = DBConnection.ExecQuery(query);

                try {
                    /*
                     Create a new button for each student returned
                     */
                    while (rs.next()) {
                        i++;
                        JButton testbutton = new JButton(rs.getString(1));
                        btnapp.add(testbutton);

                        JLabel lblname = new JLabel(rs.getString(1));
                        lblapp.add(lblname);

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }

                System.out.println(i);
                int j = 0;

                /*
                 Set bounds and actionlistener for each new student button
                 */
                for (j = 0; j < i; j++) {
                    lblapp.get(j).setBounds(10, 50 + (j * 35), 137, 23);
                    frmAdministratorInterface.getContentPane().add(lblapp.get(j));

                    btnapp.get(j).setBounds(176, 50 + (j * 35), 137, 23);
                    frmAdministratorInterface.getContentPane().add(btnapp.get(j));

                    /*
                     Select student to make appointment
                     */
                    btnapp.get(j).addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {

                            for (int k = 0; k < btnapp.size(); k++) {
                                btnapp.get(k).setVisible(false);
                                lblapp.get(k).setVisible(false);
                            }

                            switchToSelectExamPage(a, IDtext.getText(), term);

                        }
                    });
                }
            }
        });
    }

    /*
     Makes the student's appointment. Works the same as when the student makes their
     own appointment
     */
    public void switchToSelectExamPage(Administrator a, String studentID, String term) {
        JLabel lblTakeAnExam = new JLabel("Take an Exam");
        lblTakeAnExam.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblTakeAnExam.setBounds(44, 11, 140, 25);
        frmAdministratorInterface.getContentPane().add(lblTakeAnExam);

        JLabel lblCourses = new JLabel("Courses:");
        lblCourses.setBounds(28, 50, 46, 14);
        frmAdministratorInterface.getContentPane().add(lblCourses);

        ArrayList<Course> cl = new ArrayList();

        /*
         This query returns the course information from the course table
         */
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

        String[] courselist = new String[cl.size()];

        /*
         Duplicate course ArrayList for array to be displayed in combo box
         */
        for (i = 0; i < cl.size(); i++) {
            courselist[i] = cl.get(i).getCoursename();
        }

        JComboBox coursecomboBox = new JComboBox();
        coursecomboBox.setModel(new DefaultComboBoxModel(courselist));
        coursecomboBox.setBounds(111, 47, 94, 20);
        frmAdministratorInterface.getContentPane().add(coursecomboBox);

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
                    timecomboBox.setModel(new DefaultComboBoxModel());
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

                String[] examlist = new String[exams.size()];

                for (i = 0; i < exams.size(); i++) {
                    examlist[i] = exams.get(i);
                }

                /*
                 Display exams in course
                 */
                examcomboBox.setModel(new DefaultComboBoxModel(examlist));
            }

        });

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
        frmAdministratorInterface.getContentPane().add(examcomboBox);

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
        frmAdministratorInterface.getContentPane().add(datecomboBox);

        JLabel lblExam = new JLabel("Exam:");
        lblExam.setBounds(28, 78, 46, 14);
        frmAdministratorInterface.getContentPane().add(lblExam);

        timecomboBox = new JComboBox();
        timecomboBox.setModel(new DefaultComboBoxModel(timearray));
        timecomboBox.setBounds(111, 106, 144, 20);
        frmAdministratorInterface.getContentPane().add(timecomboBox);

        JLabel lblTime = new JLabel("Time:");
        lblTime.setBounds(28, 109, 46, 14);
        frmAdministratorInterface.getContentPane().add(lblTime);

        JLabel lblDate = new JLabel("Date:");
        lblDate.setBounds(28, 132, 46, 25);
        frmAdministratorInterface.getContentPane().add(lblDate);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(17, 173, 89, 23);
        frmAdministratorInterface.getContentPane().add(btnCancel);

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(116, 173, 89, 23);
        frmAdministratorInterface.getContentPane().add(btnSubmit);

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

                switchToAdminSplashScreen(a);

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
                String query = "Select * from Exam where examname = '" + examcomboBox.getSelectedItem().toString() + "'";
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
                if (cl.get(i).lookupstudent(studentID) == false) {
                    switchToCannotSchedulePage(a, "You are not currently enrolled in this course");
                } /*
                 From the selected exam, check if the student already has an appointment for the exam
                 */ else if (exam.lookupstudent(studentID) == true) {
                    switchToCannotSchedulePage(a, "You already have an appointment for this exam");
                } /*
                 Check if there is a seat available
                 */ else if (exam.availableseats(exam.getExamID() + "", term, dates.get(datecomboBox.getSelectedIndex()), times.get(timecomboBox.getSelectedIndex())) == false) {
                    switchToCannotSchedulePage(a, "No Available Seats");
                } else {

                    switchToAppointmentConfirmationPage(a, studentID, exam, dates.get(datecomboBox.getSelectedIndex()), times.get(timecomboBox.getSelectedIndex()));
                }

            }

        });

    }

    public void switchToAppointmentConfirmationPage(Administrator a, String studentID, Exam exam, Date date, Time time) {
        JLabel confirmation = new JLabel("Your Appointment Has Been Confirmed");
        confirmation.setFont(new Font("Tahoma", Font.PLAIN, 15));
        confirmation.setBounds(35, 11, 177, 21);
        frmAdministratorInterface.getContentPane().add(confirmation);

        JButton btnbacktohome = new JButton("Back to Home");
        btnbacktohome.setBounds(10, 150, 121, 23);
        frmAdministratorInterface.getContentPane().add(btnbacktohome);

        Appointment app = new Appointment();
        app.addappointment(exam.getExamID(), studentID, date, time);

        btnbacktohome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                confirmation.setVisible(false);
                btnbacktohome.setVisible(false);

                switchToAdminSplashScreen(a);

            }

        });
    }

    public void switchToAdminSplashScreen(Administrator a) {
        lblName.setVisible(true);
        textFieldID.setVisible(true);
        lblAdministrator.setVisible(true);
        lblName2.setVisible(true);
        calendar.setVisible(true);
        btnLogOut.setVisible(true);
        lblName2.setVisible(true);
        btnImportData.setVisible(true);
        btnUtilization.setVisible(true);
        btnSchedulingRequests.setVisible(true);
        btnMakeAnAppointment.setVisible(true);
        btnCheckInStudent.setVisible(true);
        lblStudentId.setVisible(true);
        btnGenerateReport.setVisible(true);
        btnAppointments.setVisible(true);
        btnedittestingcenter.setVisible(true);

    }

    public void switchToCannotSchedulePage(Administrator a, String m) {
        /*
         Display m, the message as the reason the appointment could not be scheduled
         */
        JLabel notapproved = new JLabel(m);
        notapproved.setFont(new Font("Tahoma", Font.PLAIN, 15));
        notapproved.setBounds(35, 11, 277, 21);
        frmAdministratorInterface.getContentPane().add(notapproved);

        JButton btnbacktohome = new JButton("Back to Home");
        btnbacktohome.setBounds(10, 150, 121, 23);
        frmAdministratorInterface.getContentPane().add(btnbacktohome);

        /*
         If the backtohome button is pressed, return to the student splash screen
         */
        btnbacktohome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                notapproved.setVisible(false);
                btnbacktohome.setVisible(false);

                switchToAdminSplashScreen(a);

            }

        });
    }

    public void switchToViewAppointments(Administrator a) {
        /*
         Select a term based on the season and year
         */
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
        frmAdministratorInterface.getContentPane().add(season);

        JComboBox yearbox = new JComboBox();
        yearbox.setModel(new DefaultComboBoxModel(years));
        yearbox.setBounds(111, 77, 94, 20);
        frmAdministratorInterface.getContentPane().add(yearbox);

        JButton lookup = new JButton("View Term Appointments");
        lookup.setBounds(111, 107, 137, 23);
        frmAdministratorInterface.getContentPane().add(lookup);

        lookup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                season.setVisible(false);
                yearbox.setVisible(false);
                lookup.setVisible(false);

                String term = season.getSelectedItem().toString() + "_" + yearbox.getSelectedItem().toString();

                /*
                 This query returns all of the appointments made in the selected term
                 */
                String query = "Select u.name, e.examname, a.date, a.checkedin, e.examID, "
                        + "a.appointmentID, s.studentID from appointment a, "
                        + "exam e, student s, user u, has h, forexam f where e.examID = f.examID AND "
                        + "f.appointmentID = a.appointmentID AND a.appointmentID = h.appointmentID AND "
                        + "h.studentID = s.studentID AND s.studentID = u.userID AND e.term = '" + term + "'";

                java.sql.ResultSet rs = DBConnection.ExecQuery(query);
                ArrayList<String> appstrings = new ArrayList();//List of Strings to display
                ArrayList<Appointment> appointments = new ArrayList();//List of Appointments
                ArrayList<String> names = new ArrayList();//List of student names

                try {
                    while (rs.next()) {
                        /*
                         Display Student name, appointment exam name, and appointment date
                         */
                        appstrings.add(rs.getString(1) + ": " + rs.getString(2) + "-" + rs.getString(3));

                        /*
                         Create appointment 
                         */
                        Appointment a = new Appointment();
                        a.setAppointmentid(rs.getString(6));
                        a.setCheckedin(rs.getString(4));
                        a.setExamid(rs.getInt(5));
                        a.setStudentid(rs.getString(7));
                        a.setDate(rs.getDate(3));

                        appointments.add(a);

                        names.add(rs.getString(1));//Add name of student to name list
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(AdministratorUI.class.getName()).log(Level.SEVERE, null, ex);
                }

                /*
                 Display appointment information
                 */
                String[] apparray = new String[appstrings.size()];
                for (int i = 0; i < apparray.length; i++) {
                    apparray[i] = appstrings.get(i);
                }

                JComboBox termappointments = new JComboBox();
                termappointments.setModel(new DefaultComboBoxModel(apparray));
                termappointments.setBounds(111, 77, 294, 30);
                frmAdministratorInterface.getContentPane().add(termappointments);

                JButton backtohome = new JButton("Back to Home");
                backtohome.setBounds(150, 340, 127, 23);
                frmAdministratorInterface.getContentPane().add(backtohome);

                backtohome.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        termappointments.setVisible(false);
                        backtohome.setVisible(false);

                        switchToAdminSplashScreen(a);
                    }
                });

                /*
                 The appointment has been selected
                 */
                termappointments.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        backtohome.setVisible(false);
                        JButton backtohome2 = new JButton("Back to Home");
                        backtohome2.setBounds(150, 340, 127, 23);
                        frmAdministratorInterface.getContentPane().add(backtohome2);

                        String name = names.get(termappointments.getSelectedIndex());
                        String checkedin = appointments.get(termappointments.getSelectedIndex()).getCheckedin();
                        String appid = appointments.get(termappointments.getSelectedIndex()).getAppointmentid();

                        JLabel studentcheckedin = new JLabel(name + " is " + checkedin);
                        studentcheckedin.setFont(new Font("Tahoma", Font.PLAIN, 15));
                        studentcheckedin.setBounds(135, 111, 377, 21);
                        frmAdministratorInterface.getContentPane().add(studentcheckedin);

                        JButton CheckedIn = new JButton("Checked In");
                        CheckedIn.setBounds(150, 140, 127, 23);
                        frmAdministratorInterface.getContentPane().add(CheckedIn);

                        JButton Pending = new JButton("Pending");
                        Pending.setBounds(150, 170, 127, 23);
                        frmAdministratorInterface.getContentPane().add(Pending);

                        JButton NotCheckedIn = new JButton("Not Checked In");
                        NotCheckedIn.setBounds(150, 200, 127, 23);
                        frmAdministratorInterface.getContentPane().add(NotCheckedIn);

                        JButton cancel = new JButton("Cancel Appointments");
                        cancel.setBounds(100, 260, 127, 23);
                        frmAdministratorInterface.getContentPane().add(cancel);

                        JButton modify = new JButton("Modify Appointments");
                        modify.setBounds(250, 260, 127, 23);
                        frmAdministratorInterface.getContentPane().add(modify);

                        /*
                         Modify the appointment
                         */
                        modify.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                Appointment ap = appointments.get(termappointments.getSelectedIndex());

                                backtohome2.setVisible(false);
                                studentcheckedin.setVisible(false);
                                CheckedIn.setVisible(false);
                                Pending.setVisible(false);
                                NotCheckedIn.setVisible(false);
                                termappointments.setVisible(false);
                                cancel.setVisible(false);
                                modify.setVisible(false);

                                /*
                                 Display appointment date
                                 */
                                JLabel date = new JLabel("Date: " + ap.getDate());
                                date.setFont(new Font("Tahoma", Font.PLAIN, 15));
                                date.setBounds(50, 151, 207, 21);
                                frmAdministratorInterface.getContentPane().add(date);

                                /*
                                 Calendar of dates to select
                                 */
                                JCalendar appcalendar = new JCalendar();
                                appcalendar.setBounds(226, 41, 198, 153);
                                frmAdministratorInterface.getContentPane().add(appcalendar);

                                JButton setdate = new JButton("Print Date");
                                setdate.setBounds(50, 200, 127, 23);
                                frmAdministratorInterface.getContentPane().add(setdate);

                                /*
                                 Enter the selected date
                                 */
                                setdate.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                        Calendar cal = Calendar.getInstance();

                                        /*
                                         Change selected date to SQL format
                                         */
                                        cal.set(Calendar.YEAR, appcalendar.getDate().getYear());
                                        cal.set(Calendar.MONTH, appcalendar.getDate().getMonth());
                                        cal.set(Calendar.DAY_OF_MONTH, appcalendar.getDate().getDate());
                                        java.sql.Date newdate = new java.sql.Date(cal.getTimeInMillis());

                                        newdate.setYear(newdate.getYear() + 1900);

                                        /*
                                         Set the appointment date to the selected date
                                         */
                                        ap.setDate(newdate);
                                        String query = "UPDATE `scheduler`.`appointment` SET `date`= '" + newdate + "' WHERE `appointmentID`='" + ap.getAppointmentid() + "'";
                                        DBConnection.ExecUpdateQuery(query);

                                        date.setText("Date: " + ap.getDate());

                                    }
                                });

                            }
                        });

                        /*
                         Cancel selected appointment
                         */
                        cancel.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                Appointment ap = appointments.get(termappointments.getSelectedIndex());
                                ap.deleteappointment(appid);

                                backtohome2.setVisible(false);
                                studentcheckedin.setVisible(false);
                                CheckedIn.setVisible(false);
                                Pending.setVisible(false);
                                NotCheckedIn.setVisible(false);
                                termappointments.setVisible(false);
                                cancel.setVisible(false);
                                modify.setVisible(false);
                            }
                        });

                        backtohome2.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                backtohome2.setVisible(false);
                                studentcheckedin.setVisible(false);
                                CheckedIn.setVisible(false);
                                Pending.setVisible(false);
                                NotCheckedIn.setVisible(false);
                                termappointments.setVisible(false);
                                cancel.setVisible(false);
                                modify.setVisible(false);

                                switchToAdminSplashScreen(a);
                            }
                        });

                        /*
                         Check in student that attended appointment
                         */
                        CheckedIn.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                /*
                                 Set the status of the selected appointment to "Checked In"
                                 */
                                String query = "UPDATE `scheduler`.`appointment` SET `checkedin`='checked in' "
                                        + "WHERE `appointmentID`= '" + appid + "'";

                                DBConnection.ExecUpdateQuery(query);

                                appointments.get(termappointments.getSelectedIndex()).setCheckedin("checked in");

                                /*
                                 Display student is checked in
                                 */
                                studentcheckedin.setText(name + " is checked in");

                            }

                        });

                        Pending.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                /*
                                 Set the status of the selected appointment to "Pending"
                                 */
                                String query = "UPDATE `scheduler`.`appointment` SET `checkedin`='checked in' "
                                        + "WHERE `appointmentID`= '" + appid + "'";

                                DBConnection.ExecUpdateQuery(query);

                                appointments.get(termappointments.getSelectedIndex()).setCheckedin("pending");

                                /*
                                 Display student is pending
                                 */
                                studentcheckedin.setText(name + " is pending");

                            }

                        });

                        NotCheckedIn.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                /*
                                 Set the status of the selected appointment to "Not Checked In"
                                 */
                                String query = "UPDATE `scheduler`.`appointment` SET `checkedin`='checked in' "
                                        + "WHERE `appointmentID`= '" + appid + "'";

                                DBConnection.ExecUpdateQuery(query);

                                appointments.get(termappointments.getSelectedIndex()).setCheckedin("not checked in");

                                /*
                                 Display student is Not Checked In
                                 */
                                studentcheckedin.setText(name + " is not checked in");

                            }

                        });

                    }
                });
            }
        });
    }

    /*
     View all pending requests for a selected term
     */
    public void switchToViewRequests(Administrator a) {
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
        season.setBounds(100, 47, 94, 20);
        frmAdministratorInterface.getContentPane().add(season);

        JComboBox yearbox = new JComboBox();
        yearbox.setModel(new DefaultComboBoxModel(years));
        yearbox.setBounds(100, 77, 94, 20);
        frmAdministratorInterface.getContentPane().add(yearbox);

        JButton lookup = new JButton("View Exam Requests");
        lookup.setBounds(100, 107, 137, 23);
        frmAdministratorInterface.getContentPane().add(lookup);

        JLabel instrlabel = new JLabel("Instructor:");
        instrlabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        instrlabel.setBounds(100, 100, 100, 20);
        frmAdministratorInterface.getContentPane().add(instrlabel);

        JLabel startdatelabel = new JLabel("Start Date:");
        startdatelabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        startdatelabel.setBounds(100, 120, 100, 20);
        frmAdministratorInterface.getContentPane().add(startdatelabel);

        JLabel enddatelabel = new JLabel("End Date:");
        enddatelabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        enddatelabel.setBounds(100, 140, 100, 20);
        frmAdministratorInterface.getContentPane().add(enddatelabel);

        JLabel starttimelabel = new JLabel("Start Time:");
        starttimelabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        starttimelabel.setBounds(100, 160, 100, 20);
        frmAdministratorInterface.getContentPane().add(starttimelabel);

        JLabel endtimelabel = new JLabel("End Time:");
        endtimelabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        endtimelabel.setBounds(100, 180, 100, 20);
        frmAdministratorInterface.getContentPane().add(endtimelabel);

        JLabel courselabel = new JLabel("Course:");
        courselabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        courselabel.setBounds(100, 200, 100, 20);
        frmAdministratorInterface.getContentPane().add(courselabel);

        JLabel seatslabel = new JLabel("Seats:");
        seatslabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        seatslabel.setBounds(100, 220, 100, 20);
        frmAdministratorInterface.getContentPane().add(seatslabel);

        JLabel studentslabel = new JLabel("Students:");
        studentslabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        studentslabel.setBounds(100, 240, 100, 20);
        frmAdministratorInterface.getContentPane().add(studentslabel);

        JLabel instr = new JLabel();
        instr.setFont(new Font("Tahoma", Font.PLAIN, 15));
        instr.setBounds(200, 100, 200, 20);
        frmAdministratorInterface.getContentPane().add(instr);

        JLabel startdate = new JLabel();
        startdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
        startdate.setBounds(200, 120, 200, 20);
        frmAdministratorInterface.getContentPane().add(startdate);

        JLabel enddate = new JLabel();
        enddate.setFont(new Font("Tahoma", Font.PLAIN, 15));
        enddate.setBounds(200, 140, 200, 20);
        frmAdministratorInterface.getContentPane().add(enddate);

        JLabel starttime = new JLabel();
        starttime.setFont(new Font("Tahoma", Font.PLAIN, 15));
        starttime.setBounds(200, 160, 200, 20);
        frmAdministratorInterface.getContentPane().add(starttime);

        JLabel endtime = new JLabel();
        endtime.setFont(new Font("Tahoma", Font.PLAIN, 15));
        endtime.setBounds(200, 180, 200, 20);
        frmAdministratorInterface.getContentPane().add(endtime);

        JLabel course = new JLabel();
        course.setFont(new Font("Tahoma", Font.PLAIN, 15));
        course.setBounds(200, 200, 200, 20);
        frmAdministratorInterface.getContentPane().add(course);

        JLabel seats = new JLabel();
        seats.setFont(new Font("Tahoma", Font.PLAIN, 15));
        seats.setBounds(200, 220, 200, 20);
        frmAdministratorInterface.getContentPane().add(seats);

        JLabel students = new JLabel();
        students.setFont(new Font("Tahoma", Font.PLAIN, 15));
        students.setBounds(200, 240, 200, 20);
        frmAdministratorInterface.getContentPane().add(students);

        JLabel approvelabel = new JLabel();
        approvelabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        approvelabel.setBounds(200, 180, 200, 20);
        frmAdministratorInterface.getContentPane().add(approvelabel);

        JLabel denylabel = new JLabel();
        denylabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        denylabel.setBounds(200, 200, 200, 20);
        frmAdministratorInterface.getContentPane().add(denylabel);

        JButton approve = new JButton("Approve");
        approve.setBounds(300, 150, 100, 50);
        frmAdministratorInterface.getContentPane().add(approve);

        JButton deny = new JButton("Deny");
        deny.setBounds(300, 200, 100, 50);
        frmAdministratorInterface.getContentPane().add(deny);

        instrlabel.setVisible(false);
        startdatelabel.setVisible(false);
        enddatelabel.setVisible(false);
        starttimelabel.setVisible(false);
        endtimelabel.setVisible(false);
        courselabel.setVisible(false);
        seatslabel.setVisible(false);
        studentslabel.setVisible(false);
        instr.setVisible(false);
        startdate.setVisible(false);
        enddate.setVisible(false);
        starttime.setVisible(false);
        endtime.setVisible(false);
        course.setVisible(false);
        seats.setVisible(false);
        students.setVisible(false);
        approve.setVisible(false);
        deny.setVisible(false);
        approvelabel.setVisible(false);
        denylabel.setVisible(false);

        /*
         When lookup button is clicked, first get the selected term
         */
        lookup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                season.setVisible(false);
                yearbox.setVisible(false);
                lookup.setVisible(false);
                frmAdministratorInterface.getContentPane().remove(season);
                frmAdministratorInterface.getContentPane().remove(yearbox);
                frmAdministratorInterface.getContentPane().remove(lookup);

                String term = season.getSelectedItem().toString() + "_" + yearbox.getSelectedItem().toString();

                /*
                 Get the pending requests for the selected term that are currently pending
                 */
                String query = "Select requestname from pendingrequest where term = '" + term + "'"
                        + "AND status = 'pending'";

                java.sql.ResultSet rs = DBConnection.ExecQuery(query);

                ArrayList<String> names = new ArrayList();

                try {
                    while (rs.next()) {
                        names.add(rs.getString(1));//Add the name of the request to an ArrayList
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(AdministratorUI.class.getName()).log(Level.SEVERE, null, ex);
                }

                /*
                 Create a duplicate array of the ArrayList to be displayed in a combo box
                 */
                String[] namearray = new String[names.size()];
                for (int i = 0; i < namearray.length; i++) {
                    namearray[i] = names.get(i);
                }

                /*
                 Display request names
                 */
                JComboBox exams = new JComboBox();
                exams.setModel(new DefaultComboBoxModel(namearray));
                exams.setBounds(100, 47, 124, 20);
                frmAdministratorInterface.getContentPane().add(exams);

                instrlabel.setVisible(true);
                startdatelabel.setVisible(true);
                enddatelabel.setVisible(true);
                starttimelabel.setVisible(true);
                endtimelabel.setVisible(true);
                courselabel.setVisible(true);
                seatslabel.setVisible(true);
                studentslabel.setVisible(true);

                /*
                 If a request is selected, display information
                 */
                exams.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        /*
                         This query returns the name of the instructor who made the request,
                         the requested start and end times and dates of the exam, the request ID,
                         instructor ID, and the course the exam is for where the requests term is
                         the selected term and the request name is the one selected from
                         the exam request combobox
                         */
                        String query = "Select u.name, p.StartDate, p.EndDate, p.startTime, p.endTime, "
                                + "p.requestID, p.course, i.instructorid from pendingrequest p, "
                                + "requests r, instructor i, user u where r.requestID = p.requestID AND "
                                + "r.instructorID = i.instructorID AND i.instructorID = u.userID AND p.Term = '"
                                + term + "' AND p.requestname = '" + exams.getSelectedItem().toString() + "'";

                        java.sql.ResultSet rs = DBConnection.ExecQuery(query);

                        PendingRequest p = new PendingRequest();

                        try {
                            while (rs.next()) {

                                /*
                                 Set the request information into a new pendingrequest object
                                 */
                                p.setStartDate(rs.getDate(2));
                                p.setEndDate(rs.getDate(3));
                                p.setStartTime(rs.getTime(4));
                                p.setEndTime(rs.getTime(5));
                                p.setRequestid(rs.getString(6));
                                p.setCourse(rs.getString(7));
                                p.setRequestname(exams.getSelectedItem().toString());
                                p.setTerm(term);

                                /*
                                 Display the request information
                                 */
                                instr.setVisible(true);
                                startdate.setVisible(true);
                                enddate.setVisible(true);
                                starttime.setVisible(true);
                                endtime.setVisible(true);
                                course.setVisible(true);
                                seats.setVisible(true);
                                students.setVisible(true);

                                instr.setText(rs.getString(1));
                                startdate.setText(rs.getString(2));
                                enddate.setText(rs.getString(3));
                                starttime.setText(rs.getString(4));
                                endtime.setText(rs.getString(5));
                                course.setText(rs.getString(7));

                                String query2 = "Select seats from testingcenter where term = '" + term + "'";
                                java.sql.ResultSet rs2 = DBConnection.ExecQuery(query2);

                                while (rs2.next()) {
                                    seats.setText(rs2.getString(1));
                                }

                                query2 = "Select students from course where courseID = '" + rs.getString(7) + "'";
                                rs2 = DBConnection.ExecQuery(query2);

                                while (rs2.next()) {
                                    students.setText(rs2.getString(1));
                                }

                                /*
                                 With a request selected, the approve and deny buttons are
                                 now active
                                 */
                                approve.setVisible(true);
                                deny.setVisible(true);
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(AdministratorUI.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        approve.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                instrlabel.setVisible(false);
                                startdatelabel.setVisible(false);
                                enddatelabel.setVisible(false);
                                starttimelabel.setVisible(false);
                                endtimelabel.setVisible(false);
                                courselabel.setVisible(false);
                                seatslabel.setVisible(false);
                                studentslabel.setVisible(false);
                                instr.setVisible(false);
                                startdate.setVisible(false);
                                enddate.setVisible(false);
                                starttime.setVisible(false);
                                endtime.setVisible(false);
                                course.setVisible(false);
                                seats.setVisible(false);
                                students.setVisible(false);
                                approve.setVisible(false);
                                deny.setVisible(false);
                                exams.setVisible(false);

                                /*
                                 If the approve button is selected, set the pendingrequest status to approved
                                 and get the new highest examID from the exam table
                                 */
                                String query = "UPDATE `scheduler`.`pendingrequest` SET `status`='approved' WHERE `requestID`= '" + p.getRequestid() + "'";
                                DBConnection.ExecUpdateQuery(query);

                                query = "Select (Max(examid)+1) from exam";
                                java.sql.ResultSet rs = DBConnection.ExecQuery(query);

                                String id = "";

                                try {
                                    while (rs.next()) {
                                        id = rs.getString(1);
                                    }
                                } catch (SQLException ex) {
                                    Logger.getLogger(StudentUI.class.getName()).log(Level.SEVERE, null, ex);
                                }

                                /*
                                 This query creates a new exam, adding the request information to the exam table
                                 with the new exam ID
                                 */
                                query = "INSERT INTO `scheduler`.`exam` (`examID`, `startDate`, `endDate`, `StartTime`, "
                                        + "`endTime`, `term`, `examtype`, `examname`) VALUES "
                                        + "('" + id + "', '" + p.getStartDate() + "', '" + p.getEndDate() + "', '"
                                        + p.getStartTime() + "', '" + p.getEndTime() + "', '" + p.getTerm()
                                        + "', 'course', '" + p.getRequestname() + "')";
                                DBConnection.ExecUpdateQuery(query);

                                /*
                                 With the new exam, update the approvedfor table where the request is
                                 approved to be an exam
                                 */
                                query = "INSERT INTO `scheduler`.`approvedfor` (`requestid`, `examid`) VALUES ('"
                                        + p.getRequestid() + "', '" + id + "')";
                                DBConnection.ExecUpdateQuery(query);

                                query = "Select Count(e.examID) from exam e, pendingrequest p, approvedfor a where e.term = '" + p.getTerm() + "'"
                                        + " AND e.examID = a.examID AND p.requestID = a.requestID AND p.course = '" + p.getCourse() + "'"
                                        + " AND p.status = 'approved'";

                                rs = DBConnection.ExecQuery(query);
                                int count = 1;
                                try {
                                    while (rs.next()) {
                                        count = rs.getInt(1);
                                    }
                                } catch (SQLException ex) {
                                    Logger.getLogger(AdministratorUI.class.getName()).log(Level.SEVERE, null, ex);
                                }

                                String exidentifier = p.getCourse() + "_ex" + count;

                                query = "Select CourseName from course where courseID = '" + p.getCourse() + "'";
                                rs = DBConnection.ExecQuery(query);
                                String name = "";
                                try {
                                    while (rs.next()) {
                                        name = rs.getString(1);
                                    }
                                } catch (SQLException ex) {
                                    Logger.getLogger(AdministratorUI.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                System.out.println(id + " " + name + " " + exidentifier + " " + p.getCourse());

                                query = "Insert into courseexam Values('" + id + "', '" + name + "', '" + exidentifier + "', '" + p.getCourse() + "')";
                                DBConnection.ExecUpdateQuery(query);

                                /*
                                 This query gets the number of seats in the testing center for the selected term
                                 */
                                query = "Select seats from testingcenter where term = '" + term + "'";
                                int seats = 0;
                                rs = DBConnection.ExecQuery(query);
                                try {
                                    while (rs.next()) {
                                        seats = rs.getInt(1);
                                    }
                                } catch (SQLException ex) {
                                    Logger.getLogger(AdministratorUI.class.getName()).log(Level.SEVERE, null, ex);
                                }

                                Date curs = p.getStartDate();

                                /*
                                 Create a new individual exam in the individualexam table. From the
                                 start and end date of the exam, a new individual exam for the exam
                                 will contain a date in the range
                                 */
                                while (curs.getTime() <= p.getEndDate().getTime()) {
                                    query = "Select max(individualid) + 1 from individualexam";
                                    rs = DBConnection.ExecQuery(query);
                                    String rangeid = "";

                                    try {
                                        while (rs.next()) {
                                            rangeid = rs.getString(1);
                                        }
                                    } catch (SQLException ex) {
                                        Logger.getLogger(AdministratorUI.class.getName()).log(Level.SEVERE, null, ex);
                                    }

                                    /*
                                     This query returns the minimum number of seats that will be available in the timeslot.
                                     The seats returned will be based on whether the start and end times overlap with an existing
                                     exam's time. The query will consider an overlapping exam to be one that starts before the
                                     end time of another exam and ends after the exam, one that starts before the start time and
                                     ends after the start time of the exam, one that starts and ends between the start and end
                                     times of an exam, or one that starts before the start time of an exam and ends after the
                                     end time of an exam
                                     */
                                    String query2 = "Select Min(seatsavailable) from individualexam where date = '" + curs
                                            + "' AND ((starttime <= '" + p.getEndTime() + "' AND endtime >= '" + p.getEndTime() + "') OR "
                                            + "(starttime <= '" + p.getStartTime() + "' AND endtime >= '" + p.getEndTime() + "') OR (starttime >= '" + p.getStartTime() + "' AND "
                                            + "endtime <= '" + p.getEndTime() + "') OR (starttime <= '" + p.getStartTime() + "' AND endtime >= '" + p.getStartTime() + "'))";
                                    java.sql.ResultSet rs2 = DBConnection.ExecQuery(query2);

                                    try {
                                        while (rs2.next()) {
                                            seats = rs2.getInt(1);
                                        }
                                    } catch (SQLException ex) {
                                        Logger.getLogger(AdministratorUI.class.getName()).log(Level.SEVERE, null, ex);
                                    }

                                    /*
                                     Insert new individual exam into individualexam table with the given date in the range
                                     and seats
                                     */
                                    String query3 = "INSERT INTO `scheduler`.`individualexam` (`individualid`, `examid`, `date`, "
                                            + "`starttime`, `endtime`, `seatsavailable`) VALUES ('" + rangeid + "', '" + id
                                            + "', '" + curs + "', '" + p.getStartTime() + "', '" + p.getEndTime() + "', '" + seats + "')";
                                    DBConnection.ExecUpdateQuery(query3);

                                    /*
                                     Since the new individual exam has the new minimum seats available, all other overlapping
                                     individual exams must have the updated seat value
                                     */
                                    query3 = "UPDATE `scheduler`.`individualexam` SET `seatsavailable`='" + seats + "' where date = '" + curs
                                            + "' AND ((starttime <= '" + p.getEndTime() + "' AND endtime >= '" + p.getEndTime() + "') OR "
                                            + "(starttime <= '" + p.getStartTime() + "' AND endtime >= '" + p.getEndTime() + "') OR (starttime >= '" + p.getStartTime() + "' AND "
                                            + "endtime <= '" + p.getEndTime() + "') OR (starttime <= '" + p.getStartTime() + "' AND endtime >= '" + p.getStartTime() + "'))";
                                    DBConnection.ExecUpdateQuery(query3);

                                    curs.setDate(curs.getDate() + 1);

                                }

                                /*
                                 Display approved message for selected exam
                                 */
                                switchToApproveDenyConfirmation(a, exams.getSelectedItem().toString(),
                                        "Request for " + exams.getSelectedItem().toString() + " has been approved");
                            }
                        });

                        deny.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                instrlabel.setVisible(false);
                                startdatelabel.setVisible(false);
                                enddatelabel.setVisible(false);
                                starttimelabel.setVisible(false);
                                endtimelabel.setVisible(false);
                                courselabel.setVisible(false);
                                instr.setVisible(false);
                                startdate.setVisible(false);
                                enddate.setVisible(false);
                                starttime.setVisible(false);
                                endtime.setVisible(false);
                                course.setVisible(false);
                                approve.setVisible(false);
                                deny.setVisible(false);
                                exams.setVisible(false);

                                String query = "UPDATE `scheduler`.`pendingrequest` SET `status`='denied' WHERE `requestID`='" + p.getRequestid() + "'";
                                DBConnection.ExecUpdateQuery(query);

                                /*
                                 Display deny message
                                 */
                                switchToApproveDenyConfirmation(a, exams.getSelectedItem().toString(),
                                        "Request for " + exams.getSelectedItem().toString() + " has been denied");
                            }
                        });

                    }
                });

            }
        });
    }

    public void switchToApproveDenyConfirmation(Administrator a, String requestname, String message) {
        JLabel approvedeny = new JLabel(message);
        approvedeny.setFont(new Font("Tahoma", Font.PLAIN, 15));
        approvedeny.setBounds(200, 200, 200, 20);
        frmAdministratorInterface.getContentPane().add(approvedeny);

        JButton backhome = new JButton("Back to Home");
        backhome.setBounds(200, 300, 100, 50);
        frmAdministratorInterface.getContentPane().add(backhome);

        backhome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                backhome.setVisible(false);
                approvedeny.setVisible(false);

                switchToAdminSplashScreen(a);
            }
        });

    }

    public void switchToGenerateReports(Administrator a) {
        JLabel Select = new JLabel("Select Report Type");
        Select.setFont(new Font("Tahoma", Font.PLAIN, 15));
        Select.setBounds(100, 100, 200, 20);
        frmAdministratorInterface.getContentPane().add(Select);

        JButton btnday = new JButton("Appointments By Day");
        btnday.setBounds(50, 200, 200, 50);
        frmAdministratorInterface.getContentPane().add(btnday);

        JButton btnweek = new JButton("Appointments By Week");
        btnweek.setBounds(50, 250, 200, 50);
        frmAdministratorInterface.getContentPane().add(btnweek);

        JButton btncourseterm = new JButton("Courses By Term");
        btncourseterm.setBounds(50, 300, 200, 50);
        frmAdministratorInterface.getContentPane().add(btncourseterm);

        JButton btnappterm = new JButton("Appointments By Terms");
        btnappterm.setBounds(50, 350, 200, 50);
        frmAdministratorInterface.getContentPane().add(btnappterm);

        /*
         Generate reports by day if btnday button is clicked
         */
        btnday.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Select.setVisible(false);
                btnday.setVisible(false);
                btnweek.setVisible(false);
                btncourseterm.setVisible(false);
                btnappterm.setVisible(false);

                switchToAppointmentsByDayPage(a);
            }
        });

        /*
         Generate reports by week if btnweek button is clicked
         */
        btnweek.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Select.setVisible(false);
                btnday.setVisible(false);
                btnweek.setVisible(false);
                btncourseterm.setVisible(false);
                btnappterm.setVisible(false);

                switchToAppointmentsByWeekPage(a);
            }
        });

        /*
         Generate reports by course for term if btncourseterm button is clicked
         */
        btncourseterm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Select.setVisible(false);
                btnday.setVisible(false);
                btnweek.setVisible(false);
                btncourseterm.setVisible(false);
                btnappterm.setVisible(false);

                switchToCoursesByTermPage(a);
            }
        });

        /*
         Generate reports by term if btnappterm button is clicked
         */
        btnappterm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Select.setVisible(false);
                btnday.setVisible(false);
                btnweek.setVisible(false);
                btncourseterm.setVisible(false);
                btnappterm.setVisible(false);

                switchToAppointmentsByTermsPage(a);
            }
        });

    }

    public void switchToAppointmentsByDayPage(Administrator a) {
        /*
         Select a term
         */

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
        frmAdministratorInterface.getContentPane().add(season);

        JComboBox yearbox = new JComboBox();
        yearbox.setModel(new DefaultComboBoxModel(years));
        yearbox.setBounds(111, 77, 94, 20);
        frmAdministratorInterface.getContentPane().add(yearbox);

        JButton lookup = new JButton("View Term Appointments");
        lookup.setBounds(111, 200, 137, 23);
        frmAdministratorInterface.getContentPane().add(lookup);

        lookup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String term = season.getSelectedItem() + "_" + yearbox.getSelectedItem();

                Date startdate = new Date();//Start date for the term
                Date enddate = new Date();//End date for the term
                int year = Integer.parseInt(yearbox.getSelectedItem().toString());

                FileWriter fWriter;
                BufferedWriter newfile;
                try {
                    /*
                     Create a new HTML document
                     */

                    String desktop = System.getProperty("user.home");

                    fWriter = new FileWriter(desktop + "/Desktop/TermReport.xhtml");
                    newfile = new BufferedWriter(fWriter);
                    newfile.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n <head>\n"
                            + "<title>Term Report</title>\n </head>\n<body>\n");

                    newfile.write("Courses that used Testing Center in " + season.getSelectedItem()
                            + " " + yearbox.getSelectedItem() + "<br></br><br></br>");

                    /*
                     Get date range for specific season
                     */
                    if (season.getSelectedItem().equals("Fall")) {
                        startdate.setYear(year);
                        startdate.setMonth(7);
                        startdate.setDate(25);
                        enddate.setYear(year);
                        enddate.setMonth(11);
                        enddate.setDate(18);

                    } else if (season.getSelectedItem().equals("Winter")) {
                        startdate.setYear(year);
                        startdate.setMonth(11);
                        startdate.setDate(19);
                        enddate.setYear(year + 1);
                        enddate.setMonth(0);
                        enddate.setDate(25);
                    } else if (season.getSelectedItem().equals("Spring")) {
                        startdate.setYear(year);
                        startdate.setMonth(0);
                        startdate.setDate(26);
                        enddate.setYear(year);
                        enddate.setMonth(4);
                        enddate.setDate(18);
                    } else {
                        startdate.setYear(year);
                        startdate.setMonth(4);
                        startdate.setDate(25);
                        enddate.setYear(year);
                        enddate.setMonth(6);
                        enddate.setDate(10);
                    }

                    Date currentdate = new Date();
                    currentdate.setYear(startdate.getYear());
                    currentdate.setMonth(startdate.getMonth());
                    currentdate.setDate(startdate.getDate());

                    Calendar cal = Calendar.getInstance();

                    cal.set(Calendar.YEAR, currentdate.getYear());
                    cal.set(Calendar.MONTH, currentdate.getMonth());
                    cal.set(Calendar.DAY_OF_MONTH, currentdate.getDate());
                    java.sql.Date newdate = new java.sql.Date(cal.getTimeInMillis());

                    /*
                     Start at start date and iterate through dates up to the end date
                     */
                    while (currentdate.getYear() != enddate.getYear() || currentdate.getMonth() != enddate.getMonth() || currentdate.getDate() != enddate.getDate()) {

                        /*
                         This query returns the number of appointments made on the current date in the loop
                         */
                        String query = "Select count(a.appointmentID) from appointment a where"
                                + " a.date = '" + newdate + "'";

                        java.sql.ResultSet rs = DBConnection.ExecQuery(query);

                        /*
                         Enter the date and number of appointments into the document
                         */
                        while (rs.next()) {
                            newfile.write(currentdate.getMonth() + 1 + "/" + currentdate.getDate() + "/"
                                    + currentdate.getYear() + ": " + rs.getString(1) + "<br></br>");
                        }

                        currentdate.setDate(currentdate.getDate() + 1);
                        cal.set(Calendar.YEAR, currentdate.getYear());
                        cal.set(Calendar.MONTH, currentdate.getMonth());
                        cal.set(Calendar.DAY_OF_MONTH, currentdate.getDate());
                        newdate = new java.sql.Date(cal.getTimeInMillis());
                    }

                    /*
                     Close the document
                     */
                    newfile.write("\n</body>\n </html>");

                    newfile.close();

                } catch (Exception ex) {
                    //catch any exceptions here
                }

            }
        });
    }

    public void switchToAppointmentsByWeekPage(Administrator a) {
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
        frmAdministratorInterface.getContentPane().add(season);

        JComboBox yearbox = new JComboBox();
        yearbox.setModel(new DefaultComboBoxModel(years));
        yearbox.setBounds(111, 77, 94, 20);
        frmAdministratorInterface.getContentPane().add(yearbox);

        JButton lookup = new JButton("View Term Appointments");
        lookup.setBounds(111, 200, 137, 23);
        frmAdministratorInterface.getContentPane().add(lookup);

        lookup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String term = season.getSelectedItem() + "_" + yearbox.getSelectedItem();
                Date startdate = new Date();//Start date of term
                Date enddate = new Date();//End date of term
                int year = Integer.parseInt(yearbox.getSelectedItem().toString());

                FileWriter fWriter = null;
                BufferedWriter newfile = null;
                try {
                    /*
                     Create a new HTML document
                     */
                    String desktop = System.getProperty("user.home");

                    fWriter = new FileWriter(desktop + "/Desktop/TermReport.xhtml");
                    newfile = new BufferedWriter(fWriter);
                    newfile.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n <head>\n"
                            + "<title>Term Report</title>\n </head>\n<body>\n");

                    newfile.write("Courses that used Testing Center in " + season.getSelectedItem()
                            + " " + yearbox.getSelectedItem() + "<br></br><br></br>");

                    /*
                     Set date ranges for each season
                     */
                    if (season.getSelectedItem().equals("Fall")) {
                        startdate.setYear(year);
                        startdate.setMonth(7);
                        startdate.setDate(25);
                        enddate.setYear(year);
                        enddate.setMonth(11);
                        enddate.setDate(18);

                    } else if (season.getSelectedItem().equals("Winter")) {
                        startdate.setYear(year);
                        startdate.setMonth(11);
                        startdate.setDate(19);
                        enddate.setYear(year + 1);
                        enddate.setMonth(0);
                        enddate.setDate(25);
                    } else if (season.getSelectedItem().equals("Spring")) {
                        startdate.setYear(year);
                        startdate.setMonth(0);
                        startdate.setDate(26);
                        enddate.setYear(year);
                        enddate.setMonth(4);
                        enddate.setDate(18);
                    } else {
                        startdate.setYear(year);
                        startdate.setMonth(4);
                        startdate.setDate(25);
                        enddate.setYear(year);
                        enddate.setMonth(6);
                        enddate.setDate(10);
                    }

                    Date currentdate = new Date();
                    currentdate.setYear(startdate.getYear());
                    currentdate.setMonth(startdate.getMonth());
                    currentdate.setDate(startdate.getDate());

                    Calendar cal = Calendar.getInstance();

                    cal.set(Calendar.YEAR, currentdate.getYear());
                    cal.set(Calendar.MONTH, currentdate.getMonth());
                    cal.set(Calendar.DAY_OF_MONTH, currentdate.getDate());
                    java.sql.Date newdate = new java.sql.Date(cal.getTimeInMillis());
                    int week = cal.get(Calendar.WEEK_OF_YEAR);
                    int num = 0;

                    Date startweek = new Date();
                    startweek.setYear(currentdate.getYear());
                    startweek.setMonth(currentdate.getMonth());
                    startweek.setDate(currentdate.getDate());
                    Date endweek = startweek;

                    ArrayList<String> courses = new ArrayList();

                    while (currentdate.getYear() != enddate.getYear() || currentdate.getMonth() != enddate.getMonth() || currentdate.getDate() != enddate.getDate()) {
                        endweek = startweek;

                        /*
                         This query returns the number of appointments made on the current week in the loop
                         */
                        String query = "Select count(a.appointmentID) from appointment a where"
                                + " a.date = '" + newdate + "'";

                        java.sql.ResultSet rs = DBConnection.ExecQuery(query);

                        while (rs.next()) {
                            num = num + rs.getInt(1);//Increment number of appointments by day in week

                        }

                        /*
                         This query returns the course identifier for the course that the appointment
                         is for
                         */
                        query = "Select ce.courseidentifier from exam e, courseexam ce, appointment a, forexam f"
                                + " where a.date = '" + newdate + "' AND a.appointmentID = f.appointmentID"
                                + " AND f.examID = e.examID AND e.examID = ce.examID";

                        rs = DBConnection.ExecQuery(query);

                        while (rs.next()) {
                            int check = 0;
                            /*
                             Check that there are no duplicate courses for the exam
                             */
                            for (int i = 0; i < courses.size(); i++) {
                                if (rs.getString(1).equals(courses.get(i))) {
                                    check = 1;
                                }
                            }
                            if (check == 0) {
                                courses.add(rs.getString(1));
                            }

                        }

                        currentdate.setDate(currentdate.getDate() + 1);
                        cal.set(Calendar.YEAR, currentdate.getYear());
                        cal.set(Calendar.MONTH, currentdate.getMonth());
                        cal.set(Calendar.DAY_OF_MONTH, currentdate.getDate());
                        newdate = new java.sql.Date(cal.getTimeInMillis());

                        /*
                         Check for if the next day is in the same week as the current day
                         */
                        endweek = currentdate;

                        if (cal.get(Calendar.WEEK_OF_YEAR) != week) {
                            currentdate.setDate(currentdate.getDate() - 1);
                            week = cal.get(Calendar.WEEK_OF_YEAR);

                            /*
                             With the end of the week, write start of week, end of week, courses, and 
                             number of appointments to the HTML document
                             */
                            newfile.write((startweek.getMonth() + 1) + "/" + startweek.getDate() + "/"
                                    + startweek.getYear() + " - " + (endweek.getMonth() + 1) + "/" + endweek.getDate() + "/"
                                    + endweek.getYear() + ": " + num + "   ");

                            for (int i = 0; i < courses.size(); i++) {
                                newfile.write(courses.get(i) + "  ");
                            }
                            newfile.write("<br></br>");

                            int j = courses.size();

                            /*
                             Empty course ArrayList
                             */
                            for (int i = j - 1; i >= 0; i--) {
                                courses.remove(i);
                            }

                            num = 0;

                            /*
                             Start of the week is now the current date
                             */
                            startweek.setYear(currentdate.getYear());
                            startweek.setMonth(currentdate.getMonth());
                            startweek.setDate(currentdate.getDate());

                        }

                    }
                    /*
                     Write week information for the end of the loop. Empty course list at end of loop
                     */
                    newfile.write((startweek.getMonth() + 1) + "/" + startweek.getDate() + "/"
                            + startweek.getYear() + " - " + (endweek.getMonth() + 1) + "/" + endweek.getDate() + "/"
                            + endweek.getYear() + ": " + num + "  ");

                    for (int i = 0; i < courses.size(); i++) {
                        newfile.write(courses.get(i) + "  ");
                    }
                    newfile.write("<br></br>");

                    int j = courses.size();

                    for (int i = j - 1; i >= 0; i--) {
                        courses.remove(i);
                    }

                    /*
                     Close document
                     */
                    newfile.write("\n</body>\n </html>");

                    newfile.close();

                } catch (Exception ex) {
                    //catch any exceptions here
                }

            }
        });
    }

    public void switchToCoursesByTermPage(Administrator a) {
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
        frmAdministratorInterface.getContentPane().add(season);

        JComboBox yearbox = new JComboBox();
        yearbox.setModel(new DefaultComboBoxModel(years));
        yearbox.setBounds(111, 77, 94, 20);
        frmAdministratorInterface.getContentPane().add(yearbox);

        JButton lookup = new JButton("View Term Appointments");
        lookup.setBounds(111, 107, 137, 23);
        frmAdministratorInterface.getContentPane().add(lookup);

        lookup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String term = season.getSelectedItem() + "_" + yearbox.getSelectedItem();

                /*
                 Open new HTML document
                 */
                FileWriter fWriter;
                BufferedWriter newfile;
                try {
                    String desktop = System.getProperty("user.home");

                    fWriter = new FileWriter(desktop + "/Desktop/TermReport.xhtml");

                    newfile = new BufferedWriter(fWriter);
                    newfile.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n <head>\n"
                            + "<title>Term Report</title>\n </head>\n<body>\n");

                    newfile.write("Courses that used Testing Center in " + season.getSelectedItem()
                            + " " + yearbox.getSelectedItem() + "<br></br><br></br>");

                    /*
                     This query returns the courses that have exams in the current term while
                     not returning any duplicate courses
                     */
                    String query = "Select c.course from courseexam c, exam e where"
                            + " e.Term = '" + term + "' AND e.examID = c.examID Group By course";

                    java.sql.ResultSet rs = DBConnection.ExecQuery(query);

                    while (rs.next()) {
                        newfile.write(rs.getString(1) + "<br></br>");
                    }

                    /*
                     Close the document
                     */
                    newfile.write("\n</body>\n </html>");

                    newfile.close();
                } catch (Exception ex) {
                    //catch any exceptions here
                }
            }
        });
    }

    public void switchToAppointmentsByTermsPage(Administrator a) {
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
        frmAdministratorInterface.getContentPane().add(season);

        JComboBox yearbox = new JComboBox();
        yearbox.setModel(new DefaultComboBoxModel(years));
        yearbox.setBounds(111, 77, 94, 20);
        frmAdministratorInterface.getContentPane().add(yearbox);

        JButton addterm = new JButton("Add term");
        addterm.setBounds(111, 107, 137, 23);
        frmAdministratorInterface.getContentPane().add(addterm);

        JComboBox termbox = new JComboBox();
        termbox.setModel(new DefaultComboBoxModel());
        termbox.setBounds(111, 150, 140, 20);
        frmAdministratorInterface.getContentPane().add(termbox);

        ArrayList<String> terms = new ArrayList();

        /*
         Add a new term to the term range
         */
        addterm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (season.getSelectedItem() != null && yearbox.getSelectedItem() != null) {
                    terms.add(season.getSelectedItem() + "_" + yearbox.getSelectedItem());
                    String[] termarray = new String[terms.size()];
                    for (int i = 0; i < termarray.length; i++) {
                        termarray[i] = terms.get(i);
                    }

                    /*
                     Display range of terms
                     */
                    termbox.setModel(new DefaultComboBoxModel(termarray));
                }
            }
        });

        JButton lookup = new JButton("View Term Appointments");
        lookup.setBounds(111, 200, 137, 23);
        frmAdministratorInterface.getContentPane().add(lookup);

        lookup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                /*
                 Create new HTML documents
                 */
                FileWriter fWriter;
                BufferedWriter newfile;
                try {
                    String desktop = System.getProperty("user.home");

                    fWriter = new FileWriter(desktop + "/Desktop/TermReport.xhtml");
                    newfile = new BufferedWriter(fWriter);
                    newfile.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n <head>\n"
                            + "<title>Term Report</title>\n </head>\n<body>\n");

                    newfile.write("Number of Appointments During <br></br><br></br>");

                    /*
                     Iterate through the term range
                     */
                    for (int i = 0; i < terms.size(); i++) {
                        newfile.write(termbox.getItemAt(i).toString() + ": ");

                        /*
                         This query returns the number of appointments made in the term in the array
                         */
                        String query = "Select count(a.appointmentID) from appointment a, exam e, forexam f where"
                                + " a.appointmentID = f.appointmentID AND f.examID = e.examID AND"
                                + " e.Term = '" + termbox.getItemAt(i) + "'";

                        java.sql.ResultSet rs = DBConnection.ExecQuery(query);

                        /*
                         Write the number of appointments to the document
                         */
                        while (rs.next()) {
                            newfile.write(rs.getString(1) + "<br></br>");
                        }

                        newfile.write("<br></br><br></br>");
                    }

                    /*
                     Close the document
                     */
                    newfile.write("\n</body>\n </html>");

                    newfile.close();
                } catch (Exception ex) {
                    //catch any exceptions here
                }
            }
        });
    }

    public void switchToEditTestingCenter(Administrator a) {

        /*
         Select a term to edit by selecting a year and a season from the year and season
         combo boxes
         */
        ArrayList<String> y = new ArrayList();
        String year = "";

        for (int i = 2015; i < 2017; i++) {
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
        frmAdministratorInterface.getContentPane().add(season);

        JComboBox yearbox = new JComboBox();
        yearbox.setModel(new DefaultComboBoxModel(years));
        yearbox.setBounds(111, 77, 94, 20);
        frmAdministratorInterface.getContentPane().add(yearbox);

        JButton lookup = new JButton("Testing Center Term");
        lookup.setBounds(111, 107, 137, 23);
        frmAdministratorInterface.getContentPane().add(lookup);

        lookup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                season.setVisible(false);
                yearbox.setVisible(false);
                lookup.setVisible(false);

                String term = season.getSelectedItem() + "_" + yearbox.getSelectedItem();

                /*
                 This query gets the testing center information from the testingcenter
                 table where the term is the selected term
                 */
                String query = "Select * from testingcenter where term = '" + term + "'";

                java.sql.ResultSet rs = DBConnection.ExecQuery(query);

                String id = "";

                try {
                    while (rs.next()) {
                        id = rs.getString(1);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(AdministratorUI.class.getName()).log(Level.SEVERE, null, ex);
                }

                TestingCenter t = new TestingCenter();

                /*
                 If there is no testing center information, it has not been entered into the database
                 and there will be information for a new term entered that administrator will edit
                 */
                if (id.equals("")) {

                    t.newterm(term);//Enter a new term to the testingcenter table with default info

                } else {
                    /*
                     If there is information for the testing center with the selected term,
                     return the testing center information
                     */
                    query = "Select * from testingcenter where testingcenterid = '" + id + "'";

                    rs = DBConnection.ExecQuery(query);

                    try {
                        while (rs.next()) {

                            t.setId(rs.getString(1));
                            t.setSeats(rs.getInt(2), term);
                            t.setOpens(rs.getTime(3), term);
                            t.setCloses(rs.getTime(4), term);
                            t.setSetasideseats(rs.getInt(5), term);
                            t.setTerm(rs.getString(6));
                            t.setGaptime(rs.getTime(7), term);
                            t.setReminder(rs.getTime(8));

                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(TestingCenter.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

                /*
                 Select the part of the testing center Administrator wishes to edit
                 */
                JButton seats = new JButton("Edit Seats");
                seats.setBounds(111, 50, 137, 23);
                frmAdministratorInterface.getContentPane().add(seats);

                JButton setaside = new JButton("Edit Set-Aside Seats");
                setaside.setBounds(111, 80, 137, 23);
                frmAdministratorInterface.getContentPane().add(setaside);

                JButton gaptime = new JButton("Edit Gap Time");
                gaptime.setBounds(111, 110, 137, 23);
                frmAdministratorInterface.getContentPane().add(gaptime);

                JButton reminder = new JButton("Edit Reminder Interval");
                reminder.setBounds(111, 140, 137, 23);
                frmAdministratorInterface.getContentPane().add(reminder);

                JButton hours = new JButton("Edit Testing Center Hours");
                hours.setBounds(111, 170, 237, 23);
                frmAdministratorInterface.getContentPane().add(hours);

                JButton closed = new JButton("Edit Testing Center Closed Dates");
                closed.setBounds(111, 200, 237, 23);
                frmAdministratorInterface.getContentPane().add(closed);

                JButton nonsb = new JButton("Edit Testing Center Non-Stony Brook Hours");
                nonsb.setBounds(111, 230, 237, 23);
                frmAdministratorInterface.getContentPane().add(nonsb);

                nonsb.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        seats.setVisible(false);
                        setaside.setVisible(false);
                        gaptime.setVisible(false);
                        reminder.setVisible(false);
                        hours.setVisible(false);
                        closed.setVisible(false);
                        nonsb.setVisible(false);

                        JButton addnonsb = new JButton("Enter for Open Time");
                        addnonsb.setBounds(20, 200, 60, 23);
                        frmAdministratorInterface.getContentPane().add(addnonsb);

                        /*
                         Create arrays of hours and minutes
                         */
                        String[] hours = new String[12];
                        String[] minutes = new String[60];

                        for (int i = 0; i < 12; i++) {
                            hours[i] = i + 1 + "";
                        }

                        for (int i = 0; i < 60; i++) {
                            minutes[i] = i + "";
                        }

                        /*
                         Select the hour the testing center will start for the 
                         non stony brook exam
                         */
                        JComboBox openhour = new JComboBox();
                        openhour.setModel(new DefaultComboBoxModel(hours));
                        openhour.setBounds(20, 30, 80, 20);
                        frmAdministratorInterface.getContentPane().add(openhour);

                        /*
                         Select the minute the testing center will start for the
                         non stony brook exam
                         */
                        JComboBox openminute = new JComboBox();
                        openminute.setModel(new DefaultComboBoxModel(minutes));
                        openminute.setBounds(20, 60, 80, 20);
                        frmAdministratorInterface.getContentPane().add(openminute);

                        /*
                         Select AM or PM for the start time
                         */
                        JComboBox openampm = new JComboBox();
                        openampm.setModel(new DefaultComboBoxModel(new String[]{"AM", "PM"}));
                        openampm.setBounds(20, 90, 80, 20);
                        frmAdministratorInterface.getContentPane().add(openampm);

                        JLabel openlabel = new JLabel();
                        openlabel.setBounds(20, 120, 200, 40);
                        frmAdministratorInterface.getContentPane().add(openlabel);

                        /*
                         Select the hour the testing center will end for the
                         non stony brook exam
                         */
                        JComboBox closehour = new JComboBox();
                        closehour.setModel(new DefaultComboBoxModel(hours));
                        closehour.setBounds(200, 30, 80, 20);
                        frmAdministratorInterface.getContentPane().add(closehour);

                        /*
                         Select the minute the testing center will end for the
                         non stony brook exam
                         */
                        JComboBox closeminute = new JComboBox();
                        closeminute.setModel(new DefaultComboBoxModel(minutes));
                        closeminute.setBounds(200, 60, 80, 20);
                        frmAdministratorInterface.getContentPane().add(closeminute);

                        /*
                         Select AM or PM for the end time
                         */
                        JComboBox closeampm = new JComboBox();
                        closeampm.setModel(new DefaultComboBoxModel(new String[]{"AM", "PM"}));
                        closeampm.setBounds(200, 90, 80, 20);
                        frmAdministratorInterface.getContentPane().add(closeampm);

                        JLabel closelabel = new JLabel();
                        closelabel.setBounds(200, 120, 250, 40);
                        frmAdministratorInterface.getContentPane().add(closelabel);

                        /*
                         Display the current time ranges where the testing center is reserved
                         */
                        JComboBox ranges = new JComboBox();
                        ranges.setModel(new DefaultComboBoxModel(t.getNonSBTimes()));
                        ranges.setBounds(150, 190, 80, 20);
                        frmAdministratorInterface.getContentPane().add(ranges);

                        /*
                         When addnonsb button is clicked, add the new time range to be reserved
                         */
                        addnonsb.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                Time opentime = new Time(openhour.getSelectedIndex() + 1, openminute.getSelectedIndex(), 0);
                                /*
                                 Adjust open and close times depending on if AM and PM are selected. Add 12 hours if PM
                                 is selected and the hour selected is not 12. Subtract 12 hours if AM is selected and
                                 the hour selected is 12. The index must have 1 added, because the index is 1 less than
                                 the number displayed
                                 */
                                if (openampm.getSelectedItem().equals("PM") && (openhour.getSelectedIndex() + 1) != 12) {
                                    opentime.setHours(opentime.getHours() + 12);
                                }

                                if (openampm.getSelectedItem().equals("AM") && (openhour.getSelectedIndex() + 1) == 12) {
                                    opentime.setHours(opentime.getHours() - 12);
                                }

                                Time closetime = new Time(closehour.getSelectedIndex() + 1, closeminute.getSelectedIndex(), 0);
                                if (closeampm.getSelectedItem().equals("PM") && (closehour.getSelectedIndex() + 1) != 12) {
                                    closetime.setHours(closetime.getHours() + 12);
                                }

                                if (closeampm.getSelectedItem().equals("AM") && (closehour.getSelectedIndex() + 1) == 12) {
                                    closetime.setHours(closetime.getHours() - 12);
                                }

                                /*
                                 Display the Open and Close times for a non sb exam
                                 */
                                openlabel.setText("Open Time Added: " + opentime);
                                closelabel.setText("Close Time Added: " + closetime);

                                /*
                                 add the new time range and display the new range in the combo box
                                 for the term
                                 */
                                t.addnonsbtime(opentime, closetime);
                                ranges.setModel(new DefaultComboBoxModel(t.getNonSBTimes()));

                            }

                        });

                    }
                });

                /*
                 Edit closed dates if closed button is clicked
                 */
                closed.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        seats.setVisible(false);
                        setaside.setVisible(false);
                        gaptime.setVisible(false);
                        reminder.setVisible(false);
                        hours.setVisible(false);
                        closed.setVisible(false);
                        nonsb.setVisible(false);

                        Calendar cal = Calendar.getInstance();
                        java.sql.Date start = new java.sql.Date(cal.getTimeInMillis());
                        java.sql.Date end = new java.sql.Date(cal.getTimeInMillis());
                        java.sql.Date current = new java.sql.Date(cal.getTimeInMillis());

                        JCalendar calendar = new JCalendar();
                        calendar.setBounds(226, 41, 198, 153);
                        frmAdministratorInterface.getContentPane().add(calendar);

                        JButton setstartdate = new JButton("Start Date");
                        setstartdate.setBounds(50, 200, 127, 23);
                        frmAdministratorInterface.getContentPane().add(setstartdate);

                        JButton setenddate = new JButton("End Date");
                        setenddate.setBounds(50, 230, 127, 23);
                        frmAdministratorInterface.getContentPane().add(setenddate);

                        JButton addrange = new JButton("Add Closed Date Range");
                        addrange.setBounds(100, 260, 160, 23);
                        frmAdministratorInterface.getContentPane().add(addrange);

                        JButton removerange = new JButton("Remove Closed Date Range");
                        removerange.setBounds(100, 290, 160, 23);
                        frmAdministratorInterface.getContentPane().add(removerange);

                        JLabel startlabel = new JLabel();
                        startlabel.setBounds(300, 200, 150, 23);
                        frmAdministratorInterface.getContentPane().add(startlabel);

                        JLabel endlabel = new JLabel();
                        endlabel.setBounds(300, 230, 150, 23);
                        frmAdministratorInterface.getContentPane().add(endlabel);

                        setstartdate.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {

                                /*
                                 Format the selected start date into an SQL format
                                 */
                                Calendar cal = Calendar.getInstance();
                                cal.set(Calendar.YEAR, calendar.getDate().getYear());
                                cal.set(Calendar.MONTH, calendar.getDate().getMonth());
                                cal.set(Calendar.DAY_OF_MONTH, calendar.getDate().getDate());

                                java.sql.Date selected = new java.sql.Date(cal.getTimeInMillis());

                                selected.setYear(selected.getYear() + 1900);

                                /*
                                 Check that the selected end date is not before the start date. If it is not,
                                 set the start date to this value
                                 */
                                if (selected.getTime() > end.getTime() && end.getTime() != current.getTime()) {
                                    System.out.println("Invalid");
                                } else {
                                    start.setTime(cal.getTimeInMillis());

                                    start.setYear(start.getYear() + 1900);
                                    startlabel.setText(start.toString());
                                }

                            }
                        });

                        setenddate.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {

                                /*
                                 Format the selected end date into SQL format
                                 */
                                Calendar cal = Calendar.getInstance();
                                cal.set(Calendar.YEAR, calendar.getDate().getYear());
                                cal.set(Calendar.MONTH, calendar.getDate().getMonth());
                                cal.set(Calendar.DAY_OF_MONTH, calendar.getDate().getDate());

                                java.sql.Date selected = new java.sql.Date(cal.getTimeInMillis());
                                selected.setYear(selected.getYear() + 1900);

                                /*
                                 Check that the selected end date is not before the start date. If it is not,
                                 set the start date to this value
                                 */
                                if (start.getTime() > selected.getTime() && start.getTime() != current.getTime()) {
                                    System.out.println("Invalid");
                                } else {
                                    end.setTime(cal.getTimeInMillis());

                                    end.setYear(end.getYear() + 1900);
                                    endlabel.setText(end.toString());
                                }

                            }
                        });

                        /*
                         If addrange button is clicked, the selected date range
                         will be closed
                         */
                        addrange.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                /*
                                 Check that the start and end dates were selected before they can
                                 be added to the closed range
                                 */
                                if (start.getTime() != current.getTime() && end.getTime() != current.getTime()) {
                                    t.setStartclosed(start);
                                    t.setEndclosed(end);

                                    /*
                                     Add the new range of closed dates
                                     */
                                    t.addClosedDates(start, end);
                                }
                            }
                        });

                        /*
                         If removerange button is clicked, the selected closed range
                         will now be open
                         */
                        removerange.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                /*
                                 Check that the start and end dates were selected before they can
                                 be added to the closed range
                                 */
                                if (start.getTime() != current.getTime() && end.getTime() != current.getTime()) {
                                    t.setStartclosed(start);
                                    t.setEndclosed(end);

                                    /*
                                     Remove the range of closed dates, making them open again
                                     */
                                    t.removeClosedDates(start, end);
                                }
                            }
                        });
                    }
                });

                /*
                 Edit hours the testing center is open
                 */
                hours.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        seats.setVisible(false);
                        setaside.setVisible(false);
                        gaptime.setVisible(false);
                        reminder.setVisible(false);
                        hours.setVisible(false);
                        closed.setVisible(false);
                        nonsb.setVisible(false);

                        JButton enteropen = new JButton("Enter for Open Time");
                        enteropen.setBounds(20, 200, 60, 23);
                        frmAdministratorInterface.getContentPane().add(enteropen);

                        JButton enterclose = new JButton("Enter for Close Time");
                        enterclose.setBounds(100, 200, 60, 23);
                        frmAdministratorInterface.getContentPane().add(enterclose);

                        /*
                         Create array for hours and minutes to select
                         */
                        String[] hours = new String[12];
                        String[] minutes = new String[60];

                        for (int i = 0; i < 12; i++) {
                            hours[i] = i + 1 + "";
                        }

                        for (int i = 0; i < 60; i++) {
                            minutes[i] = i + "";
                        }

                        JComboBox openhour = new JComboBox();
                        openhour.setModel(new DefaultComboBoxModel(hours));
                        openhour.setBounds(20, 30, 80, 20);
                        frmAdministratorInterface.getContentPane().add(openhour);

                        JComboBox openminute = new JComboBox();
                        openminute.setModel(new DefaultComboBoxModel(minutes));
                        openminute.setBounds(20, 60, 80, 20);
                        frmAdministratorInterface.getContentPane().add(openminute);

                        JComboBox openampm = new JComboBox();
                        openampm.setModel(new DefaultComboBoxModel(new String[]{"AM", "PM"}));
                        openampm.setBounds(20, 90, 80, 20);
                        frmAdministratorInterface.getContentPane().add(openampm);

                        JLabel openlabel = new JLabel("Open Time: " + t.getOpens());
                        openlabel.setBounds(20, 120, 200, 40);
                        frmAdministratorInterface.getContentPane().add(openlabel);

                        JComboBox closehour = new JComboBox();
                        closehour.setModel(new DefaultComboBoxModel(hours));
                        closehour.setBounds(200, 30, 80, 20);
                        frmAdministratorInterface.getContentPane().add(closehour);

                        JComboBox closeminute = new JComboBox();
                        closeminute.setModel(new DefaultComboBoxModel(minutes));
                        closeminute.setBounds(200, 60, 80, 20);
                        frmAdministratorInterface.getContentPane().add(closeminute);

                        JComboBox closeampm = new JComboBox();
                        closeampm.setModel(new DefaultComboBoxModel(new String[]{"AM", "PM"}));
                        closeampm.setBounds(200, 90, 80, 20);
                        frmAdministratorInterface.getContentPane().add(closeampm);

                        JLabel closelabel = new JLabel("Close Time: " + t.getCloses());
                        closelabel.setBounds(200, 120, 250, 40);
                        frmAdministratorInterface.getContentPane().add(closelabel);

                        enteropen.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {

                                /*
                                 If PM is selected and selected hour is not 12, add 12 hours to the selected hour
                                 */
                                Time opentime = new Time(openhour.getSelectedIndex() + 1, openminute.getSelectedIndex(), 0);
                                if (openampm.getSelectedItem().equals("PM") && (openhour.getSelectedIndex() + 1) != 12) {
                                    opentime.setHours(opentime.getHours() + 12);
                                }
                                /*
                                 If AM is selected and selected hour is 12, subtract 12 hours from selected hour
                                 */
                                if (openampm.getSelectedItem().equals("AM") && (openhour.getSelectedIndex() + 1) == 12) {
                                    opentime.setHours(opentime.getHours() - 12);
                                }

                                /*
                                 Set new open time
                                 */
                                t.setOpens(opentime, term);

                                openlabel.setText("Open Time: " + t.getOpens());

                            }

                        });

                        enterclose.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                /*
                                 If PM is selected and selected hour is not 12, add 12 hours to the selected hour
                                 */
                                Time closetime = new Time(closehour.getSelectedIndex() + 1, closeminute.getSelectedIndex(), 0);
                                if (closeampm.getSelectedItem().equals("PM")) {
                                    closetime.setHours(closetime.getHours() + 12);
                                }

                                /*
                                 If AM is selected and selected hour is 12, subtract 12 hours from selected hour
                                 */
                                if (closeampm.getSelectedItem().equals("AM") && (closehour.getSelectedIndex() + 1) == 12) {
                                    closetime.setHours(closetime.getHours() - 12);
                                }

                                /*
                                 Set new close time
                                 */
                                t.setCloses(closetime, term);

                                closelabel.setText("Close Time: " + t.getCloses());

                            }

                        });

                    }

                });

                reminder.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        seats.setVisible(false);
                        setaside.setVisible(false);
                        gaptime.setVisible(false);
                        reminder.setVisible(false);
                        hours.setVisible(false);
                        closed.setVisible(false);
                        nonsb.setVisible(false);

                        JLabel lbleditreminder = new JLabel("Enter Reminder Interval :");
                        lbleditreminder.setBounds(10, 30, 56, 14);
                        frmAdministratorInterface.getContentPane().add(lbleditreminder);

                        JButton enterreminder = new JButton("Enter");
                        enterreminder.setBounds(50, 107, 137, 23);
                        frmAdministratorInterface.getContentPane().add(enterreminder);

                        String[] hours = new String[24];
                        String[] minutes = new String[60];

                        for (int i = 0; i < 24; i++) {
                            hours[i] = i + "";
                        }

                        for (int i = 0; i < 60; i++) {
                            minutes[i] = i + "";
                        }

                        JComboBox hourcomboBox = new JComboBox();

                        hourcomboBox.setModel(new DefaultComboBoxModel(hours));
                        hourcomboBox.setBounds(211, 106, 80, 20);
                        frmAdministratorInterface.getContentPane().add(hourcomboBox);

                        JComboBox minutecomboBox = new JComboBox();
                        minutecomboBox.setModel(new DefaultComboBoxModel(minutes));
                        minutecomboBox.setBounds(300, 106, 80, 20);
                        frmAdministratorInterface.getContentPane().add(minutecomboBox);

                        JLabel reminderlabel = new JLabel("Reminder Interval: " + t.getReminder());
                        reminderlabel.setBounds(200, 60, 300, 40);
                        frmAdministratorInterface.getContentPane().add(reminderlabel);

                        enterreminder.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                /*
                                 Check that the reminder interval does not have 0 hours and 0 minutes
                                 */
                                if (!(hourcomboBox.getSelectedItem().equals("0") && minutecomboBox.getSelectedItem().equals("0"))) {

                                    Time time = new Time(hourcomboBox.getSelectedIndex(), minutecomboBox.getSelectedIndex(), 0);

                                    /*
                                     Set the new reminder interval
                                     */
                                    t.setReminder(time);
                                    reminderlabel.setText("Reminder Interval: " + t.getReminder());
                                }

                            }
                        });

                    }

                });

                gaptime.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        seats.setVisible(false);
                        setaside.setVisible(false);
                        gaptime.setVisible(false);
                        reminder.setVisible(false);
                        hours.setVisible(false);
                        closed.setVisible(false);
                        nonsb.setVisible(false);

                        JLabel lbleditgap = new JLabel("Enter Gap Time :");
                        lbleditgap.setBounds(10, 30, 56, 14);
                        frmAdministratorInterface.getContentPane().add(lbleditgap);

                        JButton entergap = new JButton("Enter");
                        entergap.setBounds(50, 107, 137, 23);
                        frmAdministratorInterface.getContentPane().add(entergap);

                        String[] times = new String[30];

                        for (int i = 0; i < 30; i++) {
                            times[i] = (i + 1) + " Minutes";
                        }

                        JComboBox timecomboBox = new JComboBox();

                        timecomboBox.setModel(new DefaultComboBoxModel(times));
                        timecomboBox.setBounds(211, 106, 144, 20);
                        frmAdministratorInterface.getContentPane().add(timecomboBox);

                        JLabel gaplabel = new JLabel("Gap Time for " + term + ": " + t.getGaptime());
                        gaplabel.setBounds(200, 60, 300, 40);
                        frmAdministratorInterface.getContentPane().add(gaplabel);

                        entergap.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                if (timecomboBox.getSelectedItem() != null) {

                                    System.out.println(timecomboBox.getSelectedIndex() + 1);
                                    Time time = new Time(0, timecomboBox.getSelectedIndex() + 1, 0);

                                    /*
                                     Set the new gap time
                                     */
                                    t.setGaptime(time, t.getTerm());
                                    gaplabel.setText("Gap Time for " + term + ": " + t.getGaptime());
                                }

                            }
                        });

                    }

                });

                setaside.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        seats.setVisible(false);
                        setaside.setVisible(false);
                        gaptime.setVisible(false);
                        reminder.setVisible(false);
                        hours.setVisible(false);
                        closed.setVisible(false);
                        nonsb.setVisible(false);

                        JLabel lbleditsetaside = new JLabel("Enter number of set-aside seats:");
                        lbleditsetaside.setBounds(10, 30, 56, 14);
                        frmAdministratorInterface.getContentPane().add(lbleditsetaside);

                        JButton entersetaside = new JButton("Enter");
                        entersetaside.setBounds(50, 107, 137, 23);
                        frmAdministratorInterface.getContentPane().add(entersetaside);

                        /*
                         Enter new setaside seats in the text box
                         */
                        JTextField newsetaside = new JTextField();
                        newsetaside.setText(t.getSetasideseats() + "");
                        newsetaside.setBounds(100, 30, 126, 20);
                        frmAdministratorInterface.getContentPane().add(newsetaside);
                        newsetaside.setColumns(10);

                        /*
                         Display the number of setaside seats for the selected term
                         */
                        JLabel seatslabel = new JLabel("Seats in testing center for " + term + ": " + t.getSetasideseats());
                        seatslabel.setBounds(200, 60, 300, 40);
                        frmAdministratorInterface.getContentPane().add(seatslabel);

                        entersetaside.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                int seatnum = Integer.parseInt(newsetaside.getText());

                                /*
                                 Set the new setaside seats
                                 */
                                t.editsetaside(seatnum, term);
                                t.setSetasideseats(seatnum, term);

                                seatslabel.setText("Seats in testing center for " + term + ": " + t.getSetasideseats());
                            }
                        });

                    }
                });

                seats.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        seats.setVisible(false);
                        setaside.setVisible(false);
                        gaptime.setVisible(false);
                        reminder.setVisible(false);
                        hours.setVisible(false);
                        closed.setVisible(false);
                        nonsb.setVisible(false);

                        JLabel lbleditseats = new JLabel("Enter number of seats:");
                        lbleditseats.setBounds(10, 30, 56, 14);
                        frmAdministratorInterface.getContentPane().add(lbleditseats);

                        JButton enter = new JButton("Enter");
                        enter.setBounds(50, 107, 137, 23);
                        frmAdministratorInterface.getContentPane().add(enter);

                        /*
                         Enter new seats in the text box
                         */
                        JTextField newseats = new JTextField();
                        newseats.setText(t.getSeats() + "");
                        newseats.setBounds(100, 30, 126, 20);
                        frmAdministratorInterface.getContentPane().add(newseats);
                        newseats.setColumns(10);

                        /*
                         Display the number of seats for the selected term
                         */
                        JLabel seatslabel = new JLabel("Seats in testing center for " + term + ": " + t.getSeats());
                        seatslabel.setBounds(20, 150, 300, 40);
                        frmAdministratorInterface.getContentPane().add(seatslabel);

                        enter.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                int seatnum = Integer.parseInt(newseats.getText());
                                System.out.println(seatnum);

                                /*
                                 Set the new seats
                                 */
                                t.editseats(seatnum, term);
                                t.setSeats(seatnum, term);

                                seatslabel.setText("Seats in testing center for " + term + ": " + t.getSeats());
                            }
                        });

                    }
                });
            }
        });
    }

    public void switchToCancelPage(Administrator a, String id) {

    }

    public void switchToDisplayUtilization(Administrator a) {
        /*
         Calendar of dates to select
         */
        JCalendar utilcalendar = new JCalendar();
        utilcalendar.setBounds(226, 41, 198, 153);
        frmAdministratorInterface.getContentPane().add(utilcalendar);

        JButton dateinfo = new JButton("Display Date Info");
        dateinfo.setBounds(50, 107, 137, 23);
        frmAdministratorInterface.getContentPane().add(dateinfo);

        JLabel utilization = new JLabel();
        utilization.setBounds(50, 200, 337, 123);
        frmAdministratorInterface.getContentPane().add(utilization);

        Calendar cal = Calendar.getInstance();

        dateinfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TestingCenter t = new TestingCenter();

                /*
                 Check if the date is before or after the current date
                 */
                if (utilcalendar.getDate().getYear() < cal.getTime().getYear()
                        || utilcalendar.getDate().getYear() == cal.getTime().getYear() && utilcalendar.getDate().getMonth() < cal.getTime().getMonth()
                        || utilcalendar.getDate().getYear() == cal.getTime().getYear() && utilcalendar.getDate().getMonth() == cal.getTime().getMonth()
                        && utilcalendar.getDate().getDate() <= cal.getTime().getDate()) {

                    /*
                     If the date is before the current date, calculate past utilization
                     */
                    utilization.setText(t.pastutilization(utilcalendar.getDate()));
                } else {

                    /*
                     If the date is after the current date, calculate future utilization
                     */
                    utilization.setText(t.futureutilization(utilcalendar.getDate()));
                }
            }
        });
    }

    public void switchToImport(Administrator a, String term) throws IOException {
        JLabel select = new JLabel("Select a file to open");
        select.setBounds(50, 80, 150, 60);
        frmAdministratorInterface.getContentPane().add(select);

        JButton btnroster = new JButton("roster.csv");
        btnroster.setBounds(50, 150, 100, 23);
        frmAdministratorInterface.getContentPane().add(btnroster);

        JButton btnuser = new JButton("user.csv");
        btnuser.setBounds(50, 200, 100, 23);
        frmAdministratorInterface.getContentPane().add(btnuser);

        JButton btnclass = new JButton("class.csv");
        btnclass.setBounds(50, 250, 100, 23);
        frmAdministratorInterface.getContentPane().add(btnclass);

        btnuser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    File fileName = new File("C://Users/Owner/Desktop/user.csv");

                    FileInputStream fis = new FileInputStream(fileName);

                    BufferedReader b = new BufferedReader(new InputStreamReader(fis));
                    String line = "";
                    line = b.readLine();
                    ArrayList<String> netids = new ArrayList();
                    ArrayList<String> first = new ArrayList();
                    ArrayList<String> last = new ArrayList();
                    ArrayList<String> email = new ArrayList();
                    ArrayList<String> usertype = new ArrayList();

                    while ((line = b.readLine()) != null) {
                        String[] user = line.split(", ");
                        netids.add(user[2]);
                        first.add(user[0]);
                        last.add(user[1]);
                        email.add(user[3]);
                        usertype.add(user[4]);

                    }

                    for (int i = 0; i < netids.size(); i++) {
                        String query = "Select userID from user where netid = '" + netids.get(i) + "'";
                        java.sql.ResultSet rs = DBConnection.ExecQuery(query);
                        String id = "";
                        try {
                            while (rs.next()) {
                                id = rs.getString(1);
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(AdministratorUI.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        query = "Select count(userID) from user where userID = '" + id + "'";
                        rs = DBConnection.ExecQuery(query);
                        int count = 1;
                        try {
                            while (rs.next()) {
                                count = rs.getInt(1);

                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(AdministratorUI.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        if (count == 0) {
                            query = "Select (Max(userid) + 1) from user";
                            rs = DBConnection.ExecQuery(query);

                            try {
                                while (rs.next()) {
                                    id = rs.getString(1);
                                    String query2 = "Insert into user (userid, name, email, firstname, lastname, netid) values "
                                            + "('" + rs.getString(1) + "', '" + first.get(i) + " " + last.get(i) + "', '"
                                            + email.get(i) + "', '" + first.get(i) + "', '" + last.get(i) + "', '"
                                            + netids.get(i) + "')";
                                    DBConnection.ExecUpdateQuery(query2);

                                    query2 = "Insert into isa values ('" + rs.getString(1) + "', '" + usertype.get(i) + "')";
                                    DBConnection.ExecUpdateQuery(query2);

                                    if (usertype.get(i).equals("student")) {
                                        query2 = "Insert into student (studentid, netid) values ('" + rs.getString(1) + "', '" + netids.get(i) + "')";
                                        DBConnection.ExecUpdateQuery(query2);
                                    } else if (usertype.get(i).equals("instr")) {
                                        query2 = "Insert into instructor (instructorid, netid) values ('" + rs.getString(1) + "', '" + netids.get(i) + "')";
                                        DBConnection.ExecUpdateQuery(query2);
                                    } else if (usertype.get(i).equals("admin")) {
                                        query2 = "Insert into administrator (administratorid, netid) values ('" + rs.getString(1) + "', '" + netids.get(i) + "')";
                                        DBConnection.ExecUpdateQuery(query2);
                                    }
                                }
                            } catch (SQLException ex) {
                                Logger.getLogger(AdministratorUI.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        }
                    }

                    String query = "Select * from user";
                    java.sql.ResultSet rs = DBConnection.ExecQuery(query);
                    try {
                        while (rs.next()) {
                            String query2 = "Select netID from user where userID = '" + rs.getString(1) + "'";
                            java.sql.ResultSet rs2 = DBConnection.ExecQuery(query2);
                            String netid = "";
                            try {
                                while (rs2.next()) {
                                    netid = rs2.getString(1);
                                }
                            } catch (SQLException ex) {
                                Logger.getLogger(AdministratorUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            int found = 0;

                            for (int i = 0; i < netids.size(); i++) {
                                if (netid.equals(netids.get(i))) {
                                    found = 1;
                                }
                            }

                            if (found == 0) {
                                String query5 = "Select appointmentid from has where studentid = '" + rs.getString(1) + "'";
                                java.sql.ResultSet rs5 = DBConnection.ExecQuery(query5);
                                while (rs5.next()) {

                                    String query6 = "Delete from has where appointmentid = '" + rs5.getString(1) + "'";
                                    DBConnection.ExecUpdateQuery(query6);

                                    query6 = "Delete from forexam where appointmentid = '" + rs5.getString(1) + "'";
                                    DBConnection.ExecUpdateQuery(query6);

                                    query6 = "Delete from appointment where appointmentid = '" + rs5.getString(1) + "'";
                                    DBConnection.ExecUpdateQuery(query6);

                                }

                                String query7 = "Delete from isa where userid = '" + rs.getString(1) + "'";
                                DBConnection.ExecUpdateQuery(query7);

                                query7 = "Delete from user where userid = '" + rs.getString(1) + "'";
                                DBConnection.ExecUpdateQuery(query7);
                            }
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(AdministratorUI.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    b.close();
                } catch (IOException ex) {
                    Logger.getLogger(AdministratorUI.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        btnclass.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    File fileName = new File("C://Users/Owner/Desktop/class.csv");

                    FileInputStream fis = new FileInputStream(fileName);

                    BufferedReader b = new BufferedReader(new InputStreamReader(fis));
                    String line = "";
                    line = b.readLine();
                    ArrayList<String> courses = new ArrayList();
                    ArrayList<String> departments = new ArrayList();
                    ArrayList<String> subjects = new ArrayList();
                    ArrayList<String> numbers = new ArrayList();
                    ArrayList<String> descriptions = new ArrayList();
                    ArrayList<String> sections = new ArrayList();
                    ArrayList<String> students = new ArrayList();
                    ArrayList<String> instructors = new ArrayList();

                    while ((line = b.readLine()) != null) {
                        String[] course = line.split(", ");
                        courses.add(course[0]);
                        departments.add(course[1]);
                        subjects.add(course[2]);
                        numbers.add(course[3]);
                        descriptions.add(course[4]);
                        sections.add(course[5]);
                        students.add(course[6]);
                        instructors.add(course[7]);

                    }

                    for (int i = 0; i < courses.size(); i++) {

                        String query = "Select count(courseID) from teaches where courseID = '" + courses.get(i) + "'"
                                + " AND instructorID = '" + instructors.get(i) + "'";
                        java.sql.ResultSet rs = DBConnection.ExecQuery(query);
                        int count = 1;
                        try {
                            while (rs.next()) {
                                count = rs.getInt(1);

                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(AdministratorUI.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        int term2 = 0;
                        query = "Select count(courseID) from course where courseID = '" + courses.get(i) + "'"
                                + " AND term = '" + term + "'";
                        rs = DBConnection.ExecQuery(query);

                        try {
                            while (rs.next()) {
                                term2 = rs.getInt(1);
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(AdministratorUI.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        int samecourse = 0;
                        query = "Select count(courseID) from course where coursename = '" + subjects.get(i) + " " + numbers.get(i) + "'"
                                + " AND section = '" + sections.get(i) + "' AND term = '" + term + "'";
                        rs = DBConnection.ExecQuery(query);

                        try {
                            while (rs.next()) {
                                samecourse = rs.getInt(1);
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(AdministratorUI.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        System.out.println(count + " " + term2 + " " + samecourse);

                        if (count == 0 && term2 == 0 && samecourse == 0) {
                            query = "Insert into course values ('" + courses.get(i) + "', '" + departments.get(i) + "', '"
                                    + subjects.get(i) + " " + numbers.get(i) + "', '" + descriptions.get(i) + "', '"
                                    + sections.get(i) + "', '" + term + "', '" + students.get(i) + "')";
                            DBConnection.ExecUpdateQuery(query);

                            query = "Insert into teaches values ('" + instructors.get(i) + "', '" + courses.get(i) + "')";
                            DBConnection.ExecUpdateQuery(query);
                        }
                    }

                    String query = "Select t.instructorid, t.courseid from teaches t, course c where t.courseID = c.courseID AND "
                            + "c.term = '" + term + "'";
                    java.sql.ResultSet rs = DBConnection.ExecQuery(query);
                    try {
                        while (rs.next()) {
                            int found = 0;

                            for (int i = 0; i < courses.size(); i++) {
                                if (rs.getString(1).equals(instructors.get(i)) && rs.getString(2).equals(courses.get(i))) {
                                    found = 1;

                                }
                            }

                            if (found == 0) {
                                String query2 = "Delete from teaches where instructorid = '" + rs.getString(1) + "'"
                                        + " And courseid = '" + rs.getString(2) + "'";
                                DBConnection.ExecUpdateQuery(query2);

                                query2 = "Delete from course where courseid = '" + rs.getString(2) + "'";
                                DBConnection.ExecUpdateQuery(query2);

                                query2 = "Delete from takes where courseid = '" + rs.getString(2) + "'";
                                DBConnection.ExecUpdateQuery(query2);

                                query2 = "Select examID from courseexam where courseidentifier = '" + rs.getString(2) + "'";
                                java.sql.ResultSet rs2 = DBConnection.ExecQuery(query2);

                                while (rs2.next()) {
                                    String query3 = "Select appointmentid from forexam where examid = '" + rs2.getString(1) + "'";
                                    java.sql.ResultSet rs3 = DBConnection.ExecQuery(query3);
                                    while (rs3.next()) {
                                        String query4 = "Delete from has where appointmentID = '" + rs3.getString(1) + "'";
                                        DBConnection.ExecUpdateQuery(query4);

                                        query4 = "Delete from forexam where appointmentID = '" + rs3.getString(1) + "'";
                                        DBConnection.ExecUpdateQuery(query4);

                                        query4 = "Delete from appointment where appointmentID = '" + rs3.getString(1) + "'";
                                        DBConnection.ExecUpdateQuery(query4);
                                    }

                                    query3 = "Delete from courseexam where examID = '" + rs2.getString(1) + "'";
                                    DBConnection.ExecUpdateQuery(query3);

                                    query3 = "Delete from approvedfor where examID = '" + rs2.getString(1) + "'";
                                    DBConnection.ExecUpdateQuery(query3);

                                    query3 = "Delete from exam where examID = '" + rs2.getString(1) + "'";
                                    DBConnection.ExecUpdateQuery(query3);

                                }

                            }

                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(AdministratorUI.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    b.close();
                } catch (IOException ex) {
                    Logger.getLogger(AdministratorUI.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        btnroster.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    File fileName = new File("C://Users/Owner/Desktop/roster.csv");

                    FileInputStream fis = new FileInputStream(fileName);

                    BufferedReader b = new BufferedReader(new InputStreamReader(fis));
                    String line = "";
                    line = b.readLine();
                    ArrayList<String> netids = new ArrayList();
                    ArrayList<String> courses = new ArrayList();

                    while ((line = b.readLine()) != null) {
                        String[] roster = line.split(", ");
                        netids.add(roster[0]);
                        courses.add(roster[1]);

                    }

                    for (int i = 0; i < netids.size(); i++) {
                        String query = "Select studentID from student where netid = '" + netids.get(i) + "'";
                        java.sql.ResultSet rs = DBConnection.ExecQuery(query);
                        String id = "";
                        try {
                            while (rs.next()) {
                                id = rs.getString(1);
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(AdministratorUI.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        query = "Select count(StudentID) from takes where studentID = '" + id + "'"
                                + " AND courseID = '" + courses.get(i) + "'";
                        rs = DBConnection.ExecQuery(query);
                        int count = 1;
                        try {
                            while (rs.next()) {
                                count = rs.getInt(1);

                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(AdministratorUI.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        query = "Select term from course where courseID = '" + courses.get(i) + "'";
                        rs = DBConnection.ExecQuery(query);
                        String term2 = "";
                        try {
                            while (rs.next()) {
                                term2 = rs.getString(1);
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(AdministratorUI.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        if (count == 0 && term.equals(term2)) {
                            query = "Insert into takes values ('" + id + "', '" + courses.get(i) + "')";
                            DBConnection.ExecUpdateQuery(query);
                        }
                    }

                    String query = "Select * from takes t, course c where t.courseID = c.courseID AND "
                            + "c.term = '" + term + "'";
                    java.sql.ResultSet rs = DBConnection.ExecQuery(query);
                    try {
                        while (rs.next()) {
                            String query2 = "Select netID from student where studentID = '" + rs.getString(1) + "'";
                            java.sql.ResultSet rs2 = DBConnection.ExecQuery(query2);
                            String netid = "";
                            try {
                                while (rs2.next()) {
                                    netid = rs2.getString(1);
                                }
                            } catch (SQLException ex) {
                                Logger.getLogger(AdministratorUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            int found = 0;
                            //System.out.println(netid);

                            for (int i = 0; i < courses.size(); i++) {
                                if (netid.equals(netids.get(i)) && rs.getString(2).equals(courses.get(i))) {
                                    found = 1;
                                }
                            }

                            if (found == 0) {
                                System.out.println(rs.getString(1) + " " + rs.getString(2));
                                String query3 = "Delete from takes where studentID = '" + rs.getString(1) + "'"
                                        + "AND courseID = '" + rs.getString(2) + "'";
                                //DBConnection.ExecUpdateQuery(query3);

                                query3 = "Select a.appointmentID from has h, appointment a, forexam f, courseexam c where "
                                        + "h.studentID = '" + rs.getString(1) + "' AND h.appointmentID = a.appointmentID AND "
                                        + "a.appointmentID = f.appointmentID AND f.examID = c.examID "
                                        + "AND c.courseidentifier = '" + rs.getString(2) + "'";
                                java.sql.ResultSet rs3 = DBConnection.ExecQuery(query3);
                                while (rs3.next()) {
                                    String query4 = "UPDATE appointment SET checkedin ='superfluous' WHERE appointmentID = '" + rs3.getString(1) + "'";
                                    DBConnection.ExecUpdateQuery(query4);
                                }
                            }
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(AdministratorUI.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    b.close();
                } catch (IOException ex) {
                    Logger.getLogger(AdministratorUI.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

    }

}
