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
import java.sql.Time;
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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class InstructorUI {

    public static JFrame sessionframe;
    public static JFrame frameInstructorInterface;
    public UserUI user = new UserUI();

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
    public static JButton btnexams;
    public static JButton btnAppointedRequests;
    public static JCalendar calendar;
    public static JButton btnLogOut;

    public JFrame frmTakeAnExam;
    public JTextField txtPm;

    public void initial() {
        sessionframe = new JFrame();
        //initializeLogin();
        //System.out.println("testing");
    }

    public void initializeLogin(JFrame sessionFrame) {
        sessionframe = sessionFrame;
        continueLogin();
    }

    public void continueLogin() {

        sessionframe.setTitle("Testing Center Login");
        sessionframe.setBounds(0, 0, 1200, 700);
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
        frameInstructorInterface.setBounds(0, 0, 1200, 700);
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

        btnexams = new JButton("View Exams");
        btnexams.setBounds(10, 150, 115, 23);
        frameInstructorInterface.getContentPane().add(btnexams);

        calendar = new JCalendar();
        calendar.setBounds(135, 7, 198, 153);
        frameInstructorInterface.getContentPane().add(calendar);

        btnLogOut = new JButton("Log Out");
        btnLogOut.setBounds(241, 171, 89, 23);
        frameInstructorInterface.getContentPane().add(btnLogOut);

        btnAppointedRequests.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblName.setVisible(false);
                lblName2.setVisible(false);
                lblInstructor.setVisible(false);
                calendar.setVisible(false);
                btnCreateAnExam.setVisible(false);
                btnAppointedRequests.setVisible(false);
                btnLogOut.setVisible(false);
                btnexams.setVisible(false);

                switchToTermPage(i, 3);
            }
        });

        btnexams.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblName.setVisible(false);
                lblName2.setVisible(false);
                lblInstructor.setVisible(false);
                calendar.setVisible(false);
                btnCreateAnExam.setVisible(false);
                btnAppointedRequests.setVisible(false);
                btnLogOut.setVisible(false);
                btnexams.setVisible(false);

                switchToTermPage(i, 2);
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
                btnexams.setVisible(false);

                switchToTermPage(i, 1);
                //switchToCreateExamPage(i);
            }
        });

        btnLogOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                /*
                 Close Instructor Page and open a new user frame to log out
                 */
                JFrame sessionframe = new JFrame();
                sessionframe.setVisible(true);

                user.continueLogin(sessionframe);

                frameInstructorInterface.setVisible(false);
            }
        });
    }

    public void switchToTermPage(Instructor in, int option) {
        /*
         Create an ArrayList of years
         */
        ArrayList<String> y = new ArrayList();
        String year = "";

        for (int i = 2015; i < 2019; i++) {
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
        frameInstructorInterface.getContentPane().add(season);

        JComboBox yearbox = new JComboBox();
        yearbox.setModel(new DefaultComboBoxModel(years));
        yearbox.setBounds(111, 77, 94, 20);
        frameInstructorInterface.getContentPane().add(yearbox);

        JButton lookup = new JButton("Select Term");
        lookup.setBounds(111, 107, 137, 23);
        frameInstructorInterface.getContentPane().add(lookup);

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
                if (option == 1) {
                    selectexamtype(in, term, season.getSelectedItem().toString(), yearbox.getSelectedItem().toString());
                } else if (option == 2) {
                    switchToExamSelect(in, term);
                } else if (option == 3) {
                    switchToViewRequests(in, term);
                }
            }
        });
    }

    public void selectexamtype(Instructor i, String term, String season, String year) {
        JLabel select = new JLabel("Select Exam Type");
        select.setFont(new Font("Tahoma", Font.PLAIN, 20));
        select.setBounds(133, 60, 350, 30);
        frameInstructorInterface.getContentPane().add(select);

        JButton course = new JButton("Course Exam");
        course.setBounds(110, 200, 89, 23);
        frameInstructorInterface.getContentPane().add(course);

        JButton adhoc = new JButton("Ad Hoc Exam");
        adhoc.setBounds(210, 200, 89, 23);
        frameInstructorInterface.getContentPane().add(adhoc);

        course.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                select.setVisible(false);
                course.setVisible(false);
                adhoc.setVisible(false);
                switchToCreateExamPage(i, term, season, year);
            }
        });

        adhoc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                select.setVisible(false);
                course.setVisible(false);
                adhoc.setVisible(false);
                switchToAdHocExam(i, term, season, year);
            }
        });
    }

    public void switchToAdHocExam(Instructor i, String term, String season, String year) {
        String[] hours = new String[24];
        int k = 0;

        for (int j = 0; j < 12; j++) {
            hours[k] = j + 1 + ":00";
            k++;
            hours[k] = j + 1 + ":30";
            k++;
        }

        JLabel netidlbl = new JLabel("Enter netid:");
        netidlbl.setBounds(130, 47, 46, 14);
        frameInstructorInterface.getContentPane().add(netidlbl);

        JLabel firstlbl = new JLabel("Enter first name:");
        firstlbl.setBounds(250, 47, 46, 14);
        frameInstructorInterface.getContentPane().add(firstlbl);

        JLabel lastlbl = new JLabel("Enter last name:");
        lastlbl.setBounds(370, 47, 46, 14);
        frameInstructorInterface.getContentPane().add(lastlbl);

        JTextField netid = new JTextField();
        netid.setBounds(130, 70, 100, 20);
        frameInstructorInterface.getContentPane().add(netid);
        netid.setColumns(10);

        JTextField firstname = new JTextField();
        firstname.setBounds(250, 70, 100, 20);
        frameInstructorInterface.getContentPane().add(firstname);
        firstname.setColumns(10);

        JTextField lastname = new JTextField();
        lastname.setBounds(370, 70, 100, 20);
        frameInstructorInterface.getContentPane().add(lastname);
        lastname.setColumns(10);

        JButton addstudent = new JButton("Add student");
        addstudent.setBounds(490, 70, 120, 23);
        frameInstructorInterface.getContentPane().add(addstudent);
        
        JButton remove = new JButton("Remove student");
        remove.setBounds(490, 120, 120, 23);
        frameInstructorInterface.getContentPane().add(remove);

        JComboBox students = new JComboBox();
        students.setModel(new DefaultComboBoxModel());
        students.setBounds(640, 70, 180, 20);
        frameInstructorInterface.getContentPane().add(students);

        ArrayList<String> studentlist = new ArrayList();
        ArrayList<String> display = new ArrayList();

        addstudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!(netid.getText().equals("")) && !(firstname.getText().equals("")) && !(lastname.getText().equals(""))) {
                    String query = "Select s.studentid from student s, user u where s.studentid = u.userid"
                            + " AND u.netid = '" + netid.getText() + "' AND u.firstname = '" + firstname.getText()
                            + "' AND u.lastname = '" + lastname.getText() + "'";
                    java.sql.ResultSet rs = DBConnection.ExecQuery(query);
                    try {
                        while (rs.next()) {
                            int check = 0;
                            for(int k = 0; k < studentlist.size(); k++)
                            {
                                if(rs.getString(1).equals(studentlist.get(k)))
                                    check = 1;
                            }
                            if(check != 1)
                            {
                                studentlist.add(rs.getString(1));
                                display.add(netid.getText() + ", " + lastname.getText() + ", " + firstname.getText());
                            }
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(InstructorUI.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    String[] studentarray = new String[studentlist.size()];
                    for (int k = 0; k < studentarray.length; k++) {
                        studentarray[k] = display.get(k);
                    }
                    students.setModel(new DefaultComboBoxModel(studentarray));
                }
            }
        });
        
        remove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(studentlist.size() > 0)
                {
                        studentlist.remove(students.getSelectedIndex());
                    

                    String[] studentarray = new String[studentlist.size()];
                    for (int k = 0; k < studentarray.length; k++) {
                        studentarray[k] = display.get(k);
                    }
                    students.setModel(new DefaultComboBoxModel(studentarray));
                }
                
            }
        });

        /*
         Select the hour the testing center will start for the 
         non stony brook exam
         */
        JComboBox openhour = new JComboBox();
        openhour.setModel(new DefaultComboBoxModel(hours));
        openhour.setBounds(120, 130, 80, 20);
        frameInstructorInterface.getContentPane().add(openhour);


        /*
         Select AM or PM for the start time
         */
        JComboBox openampm = new JComboBox();
        openampm.setModel(new DefaultComboBoxModel(new String[]{"AM", "PM"}));
        openampm.setBounds(220, 130, 80, 20);
        frameInstructorInterface.getContentPane().add(openampm);


        /*
         Select the hour the testing center will end for the
         non stony brook exam
         */
        JComboBox closehour = new JComboBox();
        closehour.setModel(new DefaultComboBoxModel(hours));
        closehour.setBounds(300, 130, 80, 20);
        frameInstructorInterface.getContentPane().add(closehour);

        /*
         Select AM or PM for the end time
         */
        JComboBox closeampm = new JComboBox();
        closeampm.setModel(new DefaultComboBoxModel(new String[]{"AM", "PM"}));
        closeampm.setBounds(400, 130, 80, 20);
        frameInstructorInterface.getContentPane().add(closeampm);

        JLabel lblCreateAnExam = new JLabel("Create an Exam");
        lblCreateAnExam.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblCreateAnExam.setBounds(133, 6, 150, 30);
        frameInstructorInterface.getContentPane().add(lblCreateAnExam);

        JLabel lblCourse = new JLabel("Course:");
        lblCourse.setBounds(120, 47, 46, 14);
        frameInstructorInterface.getContentPane().add(lblCourse);

        JLabel lblStartTime = new JLabel("Start Time:");
        lblStartTime.setBounds(120, 109, 120, 14);
        frameInstructorInterface.getContentPane().add(lblStartTime);

        JLabel lblEndTime = new JLabel("End Time:");
        lblEndTime.setBounds(220, 109, 120, 14);
        frameInstructorInterface.getContentPane().add(lblEndTime);

        JDateChooser startdateChooser = new JDateChooser();
        startdateChooser.setBounds(189, 200, 94, 20);
        frameInstructorInterface.getContentPane().add(startdateChooser);

        JLabel StartDate = new JLabel("Start Date:");
        StartDate.setBounds(120, 165, 46, 23);
        frameInstructorInterface.getContentPane().add(StartDate);

        JDateChooser enddateChooser = new JDateChooser();
        enddateChooser.setBounds(289, 200, 94, 20);
        frameInstructorInterface.getContentPane().add(enddateChooser);

        JLabel EndDate = new JLabel("End Date:");
        EndDate.setBounds(220, 165, 46, 23);
        frameInstructorInterface.getContentPane().add(EndDate);

        JLabel namelabel = new JLabel("Enter exam name:");
        namelabel.setBounds(100, 300, 90, 23);
        frameInstructorInterface.getContentPane().add(namelabel);

        JTextField examname = new JTextField();
        examname.setBounds(200, 300, 104, 20);
        frameInstructorInterface.getContentPane().add(examname);
        examname.setColumns(10);

        JLabel durationlabel = new JLabel("Select minutes of exam duration:");
        durationlabel.setBounds(350, 300, 90, 23);
        frameInstructorInterface.getContentPane().add(durationlabel);

        JComboBox duration = new JComboBox();
        duration.setModel(new DefaultComboBoxModel(new Integer[]{60, 90, 120, 150, 180}));
        duration.setBounds(500, 300, 104, 20);
        frameInstructorInterface.getContentPane().add(duration);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(110, 400, 89, 23);
        frameInstructorInterface.getContentPane().add(btnCancel);

        JButton btnConfirm = new JButton("Confirm");
        btnConfirm.setBounds(209, 400, 89, 23);
        frameInstructorInterface.getContentPane().add(btnConfirm);

        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                durationlabel.setVisible(false);
                duration.setVisible(false);
                namelabel.setVisible(false);
                examname.setVisible(false);
                lblCreateAnExam.setVisible(false);
                lblCourse.setVisible(false);

                lblStartTime.setVisible(false);
                lblEndTime.setVisible(false);
                startdateChooser.setVisible(false);
                StartDate.setVisible(false);
                btnCancel.setVisible(false);
                btnConfirm.setVisible(false);
                enddateChooser.setVisible(false);
                EndDate.setVisible(false);
                openhour.setVisible(false);
                closehour.setVisible(false);
                openampm.setVisible(false);
                closeampm.setVisible(false);

                switchToInstructorSplashScreen(i);
            }
        });

        btnConfirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int intyear = Integer.parseInt(year);

                Date checkdate = new Date();
                if (season.equals("Spring")) {
                    checkdate.setMonth(4);
                    checkdate.setYear(intyear);
                } else if (season.equals("Summer")) {
                    checkdate.setMonth(6);
                    checkdate.setYear(intyear);
                } else if (season.equals("Fall")) {
                    checkdate.setMonth(11);
                    checkdate.setYear(intyear);
                } else {
                    checkdate.setMonth(0);
                    checkdate.setYear(intyear + 1);
                }
                String[] start = openhour.getSelectedItem().toString().split(":");
                int starthourint = Integer.parseInt(start[0]);
                int startminuteint = Integer.parseInt(start[1]);

                String[] end = closehour.getSelectedItem().toString().split(":");
                int endhourint = Integer.parseInt(end[0]);
                int endminuteint = Integer.parseInt(end[1]);

                Time starttime = new Time(starthourint, startminuteint, 0);
                Time endtime = new Time(endhourint, endminuteint, 0);

                if (openampm.getSelectedItem().equals("AM") && (openhour.getSelectedItem().equals("12:00") || openhour.getSelectedItem().equals("12:30"))) {
                    starttime.setHours(starttime.getHours() - 12);
                }
                if (openampm.getSelectedItem().equals("PM") && (!(openhour.getSelectedItem().equals("12:00")) && !(openhour.getSelectedItem().equals("12:30")))) {
                    starttime.setHours(starttime.getHours() + 12);
                }
                if (closeampm.getSelectedItem().equals("AM") && (closehour.getSelectedItem().equals("12:00") || closehour.getSelectedItem().equals("12:30"))) {
                    endtime.setHours(endtime.getHours() - 12);
                }
                if (closeampm.getSelectedItem().equals("PM") && (!(closehour.getSelectedItem().equals("12:00")) && !(closehour.getSelectedItem().equals("12:30")))) {
                    endtime.setHours(endtime.getHours() + 12);
                }

                //System.out.println(starttime);
                //System.out.println(endtime);
                Time opentime = new Time(7, 0, 0);
                Time closetime = new Time(20, 0, 0);

                String query = "Select opens, closes from testingcenter where term = '" + term + "'";
                java.sql.ResultSet rs = DBConnection.ExecQuery(query);

                try {
                    while (rs.next()) {
                        opentime = rs.getTime(1);
                        closetime = rs.getTime(2);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(InstructorUI.class.getName()).log(Level.SEVERE, null, ex);
                }

                Calendar cal = Calendar.getInstance();

                //System.out.println(checkdate.getYear() + " " + startdateChooser.getDate().getYear());
                if (startdateChooser.getDate() == null || enddateChooser.getDate() == null
                        || startdateChooser.getDate().getTime() > enddateChooser.getDate().getTime()
                        || startdateChooser.getDate().getTime() < cal.getTime().getTime()
                        || startdateChooser.getDate().getTime() < cal.getTime().getTime()
                        || (enddateChooser.getDate().getMonth() > checkdate.getMonth()
                        || enddateChooser.getDate().getYear() + 1900 > checkdate.getYear())
                        || (startdateChooser.getDate().getMonth() > checkdate.getMonth()
                        || startdateChooser.getDate().getYear() + 1900 > checkdate.getYear())) {
                    JOptionPane.showMessageDialog(frameInstructorInterface, "Invalid Dates Entered");
                } else if (starttime.getTime() < opentime.getTime() || endtime.getTime() > closetime.getTime()) {
                    JOptionPane.showMessageDialog(frameInstructorInterface, "Invalid Time Entered");
                } else if (examname.getText().equals("")) {
                    JOptionPane.showMessageDialog(frameInstructorInterface, "Please enter an exam name");
                } else {
                    durationlabel.setVisible(false);
                    duration.setVisible(false);
                    namelabel.setVisible(false);
                    examname.setVisible(false);
                    lblCreateAnExam.setVisible(false);
                    lblCourse.setVisible(false);

                    lblStartTime.setVisible(false);
                    lblEndTime.setVisible(false);
                    startdateChooser.setVisible(false);
                    StartDate.setVisible(false);
                    btnCancel.setVisible(false);
                    btnConfirm.setVisible(false);
                    enddateChooser.setVisible(false);
                    EndDate.setVisible(false);
                    openhour.setVisible(false);
                    closehour.setVisible(false);
                    openampm.setVisible(false);
                    closeampm.setVisible(false);
                    netidlbl.setVisible(false);
                    netid.setVisible(false);
                    firstlbl.setVisible(false);
                    firstname.setVisible(false);
                    lastlbl.setVisible(false);
                    lastname.setVisible(false);
                    addstudent.setVisible(false);
                    students.setVisible(false);

                    query = "Select (Max(examID) + 1) from exam";
                    rs = DBConnection.ExecQuery(query);
                    int id = 0;
                    try {
                        while (rs.next()) {
                            id = rs.getInt(1);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(InstructorUI.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    cal.set(Calendar.YEAR, startdateChooser.getDate().getYear() + 1900);
                    cal.set(Calendar.MONTH, startdateChooser.getDate().getMonth());
                    cal.set(Calendar.DAY_OF_MONTH, startdateChooser.getDate().getDate());

                    java.sql.Date startdate = new java.sql.Date(cal.getTimeInMillis());

                    Calendar cal2 = Calendar.getInstance();
                    cal2.set(Calendar.YEAR, enddateChooser.getDate().getYear() + 1900);
                    cal2.set(Calendar.MONTH, enddateChooser.getDate().getMonth());
                    cal2.set(Calendar.DAY_OF_MONTH, enddateChooser.getDate().getDate());

                    java.sql.Date enddate = new java.sql.Date(cal2.getTimeInMillis());
                   //System.out.println(startdate + " " + enddate);
                    query = "Insert into exam values ('" + id + "', '" + startdate + "', '"
                            + enddate + "', '" + starttime + "', '" + endtime + "', '" + term
                            + "', 'course', '" + examname.getText() + "')";
                    DBConnection.ExecUpdateQuery(query);

                    query = "Insert into adhocexam  values ('"
                            + id + "')";
                    DBConnection.ExecUpdateQuery(query);
                    
                    String[] studentarray = new String[studentlist.size()];
                    
                    for (int k = 0; k < studentarray.length; k++) {
                            query = "Insert into studentexam values ('" + id + "', '" + studentarray[k] + "')";
                            DBConnection.ExecUpdateQuery(query);
                        }

                    TestingCenter t = new TestingCenter();
                    int days = 0;
                    Date tempdate = new Date();
                    tempdate.setYear(startdate.getYear());
                    tempdate.setMonth(startdate.getMonth());
                    tempdate.setDate(startdate.getDate());

                    double util = 0.0;
                    int over = 0;

                    while (tempdate.getDate() <= enddate.getDate()) {
                        util = Double.parseDouble(t.futureutilization(tempdate, 1, students.getItemCount()));
                        tempdate.setDate(tempdate.getDate() + 1);

                        if (util > 1.0) {
                            over = 1;
                        }
                    }

                    query = "Delete from adhocexam where examID = '" + id + "'";
                    DBConnection.ExecUpdateQuery(query);

                    query = "Delete from exam where examID = '" + id + "'";
                    DBConnection.ExecUpdateQuery(query);

                    if (over != 1) {
                        
                        for (int k = 0; k < studentarray.length; k++) {
                            studentarray[k] = studentlist.get(k);
                        }

                        adhocconfirmation(i, id, startdate, enddate, starttime, endtime, term,
                                examname.getText(), students.getItemCount(), studentarray);
                    } else {
                        requestnotvalid(i);
                    }

                }
            }
        });
    }

    public void adhocconfirmation(Instructor i, int id, Date startdate, Date enddate, Time starttime, Time endtime, String term, String requestname, int students, String[] studentarray) {
        String output = "<html> Testing Center Utilization <br></br><br></br> Date"
                + "                     Existing Utilization                       Utilization with all pending requests"
                + "<br></br>";

        PendingRequest p = new PendingRequest();
        p.addadhocrequest(i.getID(), startdate, enddate, starttime, endtime, term, requestname, students, studentarray);

        JLabel utilization = new JLabel();
        utilization.setBounds(100, 200, 500, 400);
        frameInstructorInterface.getContentPane().add(utilization);

        JButton submit = new JButton("Submit");
        submit.setBounds(100, 100, 121, 23);
        frameInstructorInterface.getContentPane().add(submit);

        JButton cancel = new JButton("Cancel");
        cancel.setBounds(250, 100, 121, 23);
        frameInstructorInterface.getContentPane().add(cancel);

        TestingCenter t = new TestingCenter();

        Date tempdate = new Date();
        tempdate.setYear(startdate.getYear());
        tempdate.setMonth(startdate.getMonth());
        tempdate.setDate(startdate.getDate());

        double util = 0.0;
        double potentialutil = 0.0;

        while (tempdate.getDate() <= enddate.getDate()) {
            util = Double.parseDouble(t.futureutilization(tempdate, 1, 0));
            output = output + tempdate + "          "
                    + "             " + util + "       ";

            String query = "Select * from pendingrequest where term = '" + term
                    + "' AND status = 'pending'";
            java.sql.ResultSet rs = DBConnection.ExecQuery(query);

            int x = 0;

            ArrayList<Integer> ids = new ArrayList();
            try {
                while (rs.next()) {
                    String query3 = "Select (Max(examID) + 1) from exam";
                    java.sql.ResultSet rs3 = DBConnection.ExecQuery(query3);
                    int examid = 0;
                    try {
                        while (rs3.next()) {
                            examid = rs3.getInt(1);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(InstructorUI.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    ids.add(examid);

                    if (!(rs.getString(8).equals("ad hoc"))) {
                        String query2 = "Insert into exam values ('" + examid + "', '" + rs.getDate(2) + "', '"
                                + rs.getDate(3) + "', '" + rs.getTime(4) + "', '" + rs.getTime(5) + "', '" + term
                                + "', 'course', '" + rs.getString(9) + "')";
                        DBConnection.ExecUpdateQuery(query2);

                        query2 = "Insert into courseexam (examid, courseidentifier) values ('"
                                + examid + "', '" + rs.getString(8) + "')";
                        DBConnection.ExecUpdateQuery(query2);
                    } else {
                        String query2 = "Insert into exam values ('" + examid + "', '" + rs.getDate(2) + "', '"
                                + rs.getDate(3) + "', '" + rs.getTime(4) + "', '" + rs.getTime(5) + "', '" + term
                                + "', 'ad hoc', '" + rs.getString(9) + "')";
                        DBConnection.ExecUpdateQuery(query2);

                        query2 = "Insert into adhocexam values ('"
                                + examid + "')";
                        DBConnection.ExecUpdateQuery(query2);
                        
                        query2 = "Select studentid from studentrequest where requestid = '" + rs.getString(1)
                                + "'";
                        java.sql.ResultSet rs2 = DBConnection.ExecQuery(query2);

                        while(rs2.next())
                        {
                            query2 = "Insert into studentexam values ('" + examid + "', '" + rs2.getString(1) + "')";
                            DBConnection.ExecUpdateQuery(query2);
                        }
                        
                    }

                    x++;

                }
            } catch (SQLException ex) {
                Logger.getLogger(InstructorUI.class.getName()).log(Level.SEVERE, null, ex);
            }

            potentialutil = Double.parseDouble(t.futureutilization(tempdate, 1, 0));
            output = output + "          "
                    + "             " + potentialutil + "<br></br>";

            // System.out.println(x);
            for (int j = 0; j < ids.size(); j++) {
                //System.out.println(ids.get(j));
                String query4 = "Delete from courseexam where examid = '" + ids.get(j) + "'";
                DBConnection.ExecUpdateQuery(query4);
                
                query4 = "Delete from adhocexam where examid = '" + ids.get(j) + "'";
                DBConnection.ExecUpdateQuery(query4);

                query4 = "Delete from exam where examid = '" + ids.get(j) + "'";
                DBConnection.ExecUpdateQuery(query4);
                
                query4 = "Delete from studentexam where examid = '" + ids.get(j) + "'";
                DBConnection.ExecUpdateQuery(query4);
                
                
            }
            ids.clear();

            tempdate.setDate(tempdate.getDate() + 1);
        }

        utilization.setText(output + "<html></html>");
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                utilization.setVisible(false);
                submit.setVisible(false);
                cancel.setVisible(false);

                switchToInstructorSplashScreen(i);
            }
        });

        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                utilization.setVisible(false);
                submit.setVisible(false);
                cancel.setVisible(false);

                p.deleterequest(p.getRequestid());

                switchToInstructorSplashScreen(i);
            }
        });

    }

    public void switchToCreateExamPage(Instructor i, String term, String season, String year) {

        String query = "Select c.courseID from course c, teaches t where t.instructorid = '" + i.getID()
                + "' AND t.courseID = c.courseID AND c.term = '" + term + "'";
        java.sql.ResultSet rs = DBConnection.ExecQuery(query);

        ArrayList<String> courseids = new ArrayList();
        ArrayList<Course> courses = new ArrayList();
        int j = 0;

        try {
            while (rs.next()) {
                courseids.add(rs.getString(1));
                String query2 = "Select * from course where courseid = '" + rs.getString(1) + "'";
                java.sql.ResultSet rs2 = DBConnection.ExecQuery(query2);

                while (rs2.next()) {
                    Course c = new Course();
                    courses.add(c);

                    courses.get(j).setCourseID(rs2.getString(1));
                    courses.get(j).setDepartment(rs2.getString(2));
                    courses.get(j).setCoursename(rs2.getString(3));
                    courses.get(j).setCoursedescription(rs2.getString(4));
                    courses.get(j).setSection(rs2.getInt(5));
                    courses.get(j).setTerm(rs2.getString(6));
                    courses.get(j).setStudents(rs2.getInt(7));

                    j++;
                }
                //j++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(InstructorUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        String[] coursearray = new String[courses.size()];
        for (j = 0; j < coursearray.length; j++) {
            coursearray[j] = courses.get(j).getCoursename() + " Section " + courses.get(j).getSection();
        }

        String[] hours = new String[24];
        int k = 0;

        for (j = 0; j < 12; j++) {
            hours[k] = j + 1 + ":00";
            k++;
            hours[k] = j + 1 + ":30";
            k++;
        }

        /*
         Select the hour the testing center will start for the 
         non stony brook exam
         */
        JComboBox openhour = new JComboBox();
        openhour.setModel(new DefaultComboBoxModel(hours));
        openhour.setBounds(120, 130, 80, 20);
        frameInstructorInterface.getContentPane().add(openhour);


        /*
         Select AM or PM for the start time
         */
        JComboBox openampm = new JComboBox();
        openampm.setModel(new DefaultComboBoxModel(new String[]{"AM", "PM"}));
        openampm.setBounds(220, 130, 80, 20);
        frameInstructorInterface.getContentPane().add(openampm);


        /*
         Select the hour the testing center will end for the
         non stony brook exam
         */
        JComboBox closehour = new JComboBox();
        closehour.setModel(new DefaultComboBoxModel(hours));
        closehour.setBounds(300, 130, 80, 20);
        frameInstructorInterface.getContentPane().add(closehour);

        /*
         Select AM or PM for the end time
         */
        JComboBox closeampm = new JComboBox();
        closeampm.setModel(new DefaultComboBoxModel(new String[]{"AM", "PM"}));
        closeampm.setBounds(400, 130, 80, 20);
        frameInstructorInterface.getContentPane().add(closeampm);

        JLabel lblCreateAnExam = new JLabel("Create an Exam");
        lblCreateAnExam.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblCreateAnExam.setBounds(133, 6, 150, 30);
        frameInstructorInterface.getContentPane().add(lblCreateAnExam);

        JLabel lblCourse = new JLabel("Course:");
        lblCourse.setBounds(120, 47, 46, 14);
        frameInstructorInterface.getContentPane().add(lblCourse);

        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(coursearray));
        comboBox.setBounds(189, 44, 94, 20);
        frameInstructorInterface.getContentPane().add(comboBox);

        JLabel lblStartTime = new JLabel("Start Time:");
        lblStartTime.setBounds(120, 109, 120, 14);
        frameInstructorInterface.getContentPane().add(lblStartTime);

        JLabel lblEndTime = new JLabel("End Time:");
        lblEndTime.setBounds(220, 109, 120, 14);
        frameInstructorInterface.getContentPane().add(lblEndTime);

        JDateChooser startdateChooser = new JDateChooser();
        startdateChooser.setBounds(189, 200, 94, 20);
        frameInstructorInterface.getContentPane().add(startdateChooser);

        JLabel StartDate = new JLabel("Start Date:");
        StartDate.setBounds(120, 165, 46, 23);
        frameInstructorInterface.getContentPane().add(StartDate);

        JDateChooser enddateChooser = new JDateChooser();
        enddateChooser.setBounds(289, 200, 94, 20);
        frameInstructorInterface.getContentPane().add(enddateChooser);

        JLabel EndDate = new JLabel("End Date:");
        EndDate.setBounds(220, 165, 46, 23);
        frameInstructorInterface.getContentPane().add(EndDate);

        JLabel namelabel = new JLabel("Enter exam name:");
        namelabel.setBounds(100, 300, 90, 23);
        frameInstructorInterface.getContentPane().add(namelabel);

        JTextField examname = new JTextField();
        examname.setBounds(200, 300, 104, 20);
        frameInstructorInterface.getContentPane().add(examname);
        examname.setColumns(10);

        JLabel durationlabel = new JLabel("Select minutes of exam duration:");
        durationlabel.setBounds(350, 300, 90, 23);
        frameInstructorInterface.getContentPane().add(durationlabel);

        JComboBox duration = new JComboBox();
        duration.setModel(new DefaultComboBoxModel(new Integer[]{60, 90, 120, 150, 180}));
        duration.setBounds(500, 300, 104, 20);
        frameInstructorInterface.getContentPane().add(duration);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(110, 400, 89, 23);
        frameInstructorInterface.getContentPane().add(btnCancel);

        JButton btnConfirm = new JButton("Confirm");
        btnConfirm.setBounds(209, 400, 89, 23);
        frameInstructorInterface.getContentPane().add(btnConfirm);

        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                durationlabel.setVisible(false);
                duration.setVisible(false);
                namelabel.setVisible(false);
                examname.setVisible(false);
                lblCreateAnExam.setVisible(false);
                lblCourse.setVisible(false);
                comboBox.setVisible(false);
                lblStartTime.setVisible(false);
                lblEndTime.setVisible(false);
                startdateChooser.setVisible(false);
                StartDate.setVisible(false);
                btnCancel.setVisible(false);
                btnConfirm.setVisible(false);
                enddateChooser.setVisible(false);
                EndDate.setVisible(false);
                openhour.setVisible(false);
                closehour.setVisible(false);
                openampm.setVisible(false);
                closeampm.setVisible(false);

                switchToInstructorSplashScreen(i);
            }
        });

        btnConfirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int intyear = Integer.parseInt(year);

                Date checkdate = new Date();
                if (season.equals("Spring")) {
                    checkdate.setMonth(4);
                    checkdate.setYear(intyear);
                } else if (season.equals("Summer")) {
                    checkdate.setMonth(6);
                    checkdate.setYear(intyear);
                } else if (season.equals("Fall")) {
                    checkdate.setMonth(11);
                    checkdate.setYear(intyear);
                } else {
                    checkdate.setMonth(0);
                    checkdate.setYear(intyear + 1);
                }
                String[] start = openhour.getSelectedItem().toString().split(":");
                int starthourint = Integer.parseInt(start[0]);
                int startminuteint = Integer.parseInt(start[1]);

                String[] end = closehour.getSelectedItem().toString().split(":");
                int endhourint = Integer.parseInt(end[0]);
                int endminuteint = Integer.parseInt(end[1]);

                Time starttime = new Time(starthourint, startminuteint, 0);
                Time endtime = new Time(endhourint, endminuteint, 0);

                if (openampm.getSelectedItem().equals("AM") && (openhour.getSelectedItem().equals("12:00") || openhour.getSelectedItem().equals("12:30"))) {
                    starttime.setHours(starttime.getHours() - 12);
                }
                if (openampm.getSelectedItem().equals("PM") && (!(openhour.getSelectedItem().equals("12:00")) && !(openhour.getSelectedItem().equals("12:30")))) {
                    starttime.setHours(starttime.getHours() + 12);
                }
                if (closeampm.getSelectedItem().equals("AM") && (closehour.getSelectedItem().equals("12:00") || closehour.getSelectedItem().equals("12:30"))) {
                    endtime.setHours(endtime.getHours() - 12);
                }
                if (closeampm.getSelectedItem().equals("PM") && (!(closehour.getSelectedItem().equals("12:00")) && !(closehour.getSelectedItem().equals("12:30")))) {
                    endtime.setHours(endtime.getHours() + 12);
                }

                //System.out.println(starttime);
                //System.out.println(endtime);

                Time opentime = new Time(7, 0, 0);
                Time closetime = new Time(20, 0, 0);

                String query = "Select opens, closes from testingcenter where term = '" + term + "'";
                java.sql.ResultSet rs = DBConnection.ExecQuery(query);

                try {
                    while (rs.next()) {
                        opentime = rs.getTime(1);
                        closetime = rs.getTime(2);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(InstructorUI.class.getName()).log(Level.SEVERE, null, ex);
                }

                Calendar cal = Calendar.getInstance();

                //System.out.println(checkdate.getYear() + " " + startdateChooser.getDate().getYear());
                if (startdateChooser.getDate() == null || enddateChooser.getDate() == null
                        || startdateChooser.getDate().getTime() > enddateChooser.getDate().getTime()
                        || startdateChooser.getDate().getTime() < cal.getTime().getTime()
                        || startdateChooser.getDate().getTime() < cal.getTime().getTime()
                        || (enddateChooser.getDate().getMonth() > checkdate.getMonth()
                        || enddateChooser.getDate().getYear() + 1900 > checkdate.getYear())
                        || (startdateChooser.getDate().getMonth() > checkdate.getMonth()
                        || startdateChooser.getDate().getYear() + 1900 > checkdate.getYear())) {
                    JOptionPane.showMessageDialog(frameInstructorInterface, "Invalid Dates Entered");
                } else if (starttime.getTime() < opentime.getTime() || endtime.getTime() > closetime.getTime()) {
                    JOptionPane.showMessageDialog(frameInstructorInterface, "Invalid Time Entered");
                } else if (examname.getText().equals("")) {
                    JOptionPane.showMessageDialog(frameInstructorInterface, "Please enter an exam name");
                } else {
                    durationlabel.setVisible(false);
                    duration.setVisible(false);
                    namelabel.setVisible(false);
                    examname.setVisible(false);
                    lblCreateAnExam.setVisible(false);
                    lblCourse.setVisible(false);
                    comboBox.setVisible(false);
                    lblStartTime.setVisible(false);
                    lblEndTime.setVisible(false);
                    startdateChooser.setVisible(false);
                    StartDate.setVisible(false);
                    btnCancel.setVisible(false);
                    btnConfirm.setVisible(false);
                    enddateChooser.setVisible(false);
                    EndDate.setVisible(false);
                    openhour.setVisible(false);
                    closehour.setVisible(false);
                    openampm.setVisible(false);
                    closeampm.setVisible(false);

                    //System.out.println(courses.get(comboBox.getSelectedIndex()).getCourseID());
                    query = "Select (Max(examID) + 1) from exam";
                    rs = DBConnection.ExecQuery(query);
                    int id = 0;
                    try {
                        while (rs.next()) {
                            id = rs.getInt(1);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(InstructorUI.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    cal.set(Calendar.YEAR, startdateChooser.getDate().getYear() + 1900);
                    cal.set(Calendar.MONTH, startdateChooser.getDate().getMonth());
                    cal.set(Calendar.DAY_OF_MONTH, startdateChooser.getDate().getDate());

                    java.sql.Date startdate = new java.sql.Date(cal.getTimeInMillis());

                    Calendar cal2 = Calendar.getInstance();
                    cal2.set(Calendar.YEAR, enddateChooser.getDate().getYear() + 1900);
                    cal2.set(Calendar.MONTH, enddateChooser.getDate().getMonth());
                    cal2.set(Calendar.DAY_OF_MONTH, enddateChooser.getDate().getDate());

                    java.sql.Date enddate = new java.sql.Date(cal2.getTimeInMillis());
                   // System.out.println(startdate + " " + enddate);
                    query = "Insert into exam values ('" + id + "', '" + startdate + "', '"
                            + enddate + "', '" + starttime + "', '" + endtime + "', '" + term
                            + "', 'course', '" + examname.getText() + "')";
                    DBConnection.ExecUpdateQuery(query);

                    query = "Insert into courseexam (examid, courseidentifier) values ('"
                            + id + "', '" + courses.get(comboBox.getSelectedIndex()).getCourseID() + "')";
                    DBConnection.ExecUpdateQuery(query);

                    TestingCenter t = new TestingCenter();
                    int days = 0;
                    Date tempdate = new Date();
                    tempdate.setYear(startdate.getYear());
                    tempdate.setMonth(startdate.getMonth());
                    tempdate.setDate(startdate.getDate());

                    double util = 0.0;
                    int over = 0;

                    while (tempdate.getDate() <= enddate.getDate()) {
                        util = Double.parseDouble(t.futureutilization(tempdate, 1, 0));
                        tempdate.setDate(tempdate.getDate() + 1);

                        if (util > 1.0) {
                            over = 1;
                        }
                    }

                    query = "Delete from courseexam where examID = '" + id + "'";
                    DBConnection.ExecUpdateQuery(query);

                    query = "Delete from exam where examID = '" + id + "'";
                    DBConnection.ExecUpdateQuery(query);

                    if (over != 1) {
                        requestconfirmation(i, id, startdate, enddate, starttime, endtime, term,
                                courses.get(comboBox.getSelectedIndex()).getSection(),
                                courses.get(comboBox.getSelectedIndex()).getCourseID(), examname.getText(),
                                courses.get(comboBox.getSelectedIndex()).getStudents());
                    } else {
                        requestnotvalid(i);
                    }

                }
            }
        });

    }

    public void requestnotvalid(Instructor i) {
        JLabel invalid = new JLabel("Request not schedulable");
        invalid.setBounds(100, 200, 190, 23);
        frameInstructorInterface.getContentPane().add(invalid);

        JButton btnbacktohome = new JButton("Back to Home");
        btnbacktohome.setBounds(100, 250, 121, 23);
        frameInstructorInterface.getContentPane().add(btnbacktohome);

        btnbacktohome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                invalid.setVisible(false);
                btnbacktohome.setVisible(false);

                switchToInstructorSplashScreen(i);
            }
        });
    }

    public void requestconfirmation(Instructor i, int id, Date startdate, Date enddate, Time starttime, Time endtime, String term, int section, String courseid, String requestname, int students) {
        String output = "<html> Testing Center Utilization <br></br><br></br> Date"
                + "                     Existing Utilization                       Utilization with all pending requests"
                + "<br></br>";

        PendingRequest p = new PendingRequest();
        p.addrequest(i.getID(), startdate, enddate, starttime, endtime, term, section, courseid, requestname, students);

        JLabel utilization = new JLabel();
        utilization.setBounds(100, 200, 500, 400);
        frameInstructorInterface.getContentPane().add(utilization);

        JButton submit = new JButton("Submit");
        submit.setBounds(100, 100, 121, 23);
        frameInstructorInterface.getContentPane().add(submit);

        JButton cancel = new JButton("Cancel");
        cancel.setBounds(250, 100, 121, 23);
        frameInstructorInterface.getContentPane().add(cancel);

        TestingCenter t = new TestingCenter();

        Date tempdate = new Date();
        tempdate.setYear(startdate.getYear());
        tempdate.setMonth(startdate.getMonth());
        tempdate.setDate(startdate.getDate());

        double util = 0.0;
        double potentialutil = 0.0;

        while (tempdate.getDate() <= enddate.getDate()) {
            util = Double.parseDouble(t.futureutilization(tempdate, 1, 0));
            output = output + tempdate + "          "
                    + "             " + util + "       ";

            String query = "Select * from pendingrequest where term = '" + term
                    + "' AND status = 'pending'";
            java.sql.ResultSet rs = DBConnection.ExecQuery(query);

            int x = 0;

            ArrayList<Integer> ids = new ArrayList();
            try {
                while (rs.next()) {
                    String query3 = "Select (Max(examID) + 1) from exam";
                    java.sql.ResultSet rs3 = DBConnection.ExecQuery(query3);
                    int examid = 0;
                    try {
                        while (rs3.next()) {
                            examid = rs3.getInt(1);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(InstructorUI.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    ids.add(examid);

                    if (!(rs.getString(8).equals("ad hoc"))) {
                        String query2 = "Insert into exam values ('" + examid + "', '" + rs.getDate(2) + "', '"
                                + rs.getDate(3) + "', '" + rs.getTime(4) + "', '" + rs.getTime(5) + "', '" + term
                                + "', 'course', '" + rs.getString(9) + "')";
                        DBConnection.ExecUpdateQuery(query2);

                        query2 = "Insert into courseexam (examid, courseidentifier) values ('"
                                + examid + "', '" + rs.getString(8) + "')";
                        DBConnection.ExecUpdateQuery(query2);
                    } else {
                        String query2 = "Insert into exam values ('" + examid + "', '" + rs.getDate(2) + "', '"
                                + rs.getDate(3) + "', '" + rs.getTime(4) + "', '" + rs.getTime(5) + "', '" + term
                                + "', 'ad hoc', '" + rs.getString(9) + "')";
                        DBConnection.ExecUpdateQuery(query2);

                        query2 = "Insert into adhocexam values ('"
                                + examid + "')";
                        DBConnection.ExecUpdateQuery(query2);
                        
                        query2 = "Select studentid from studentrequest where requestid = '" + rs.getString(1)
                                + "'";
                        java.sql.ResultSet rs2 = DBConnection.ExecQuery(query2);

                        while(rs2.next())
                        {
                            query2 = "Insert into studentexam values ('" + examid + "', '" + rs2.getString(1) + "')";
                            DBConnection.ExecUpdateQuery(query2);
                        }
                        
                    }
                    x++;

                }
            } catch (SQLException ex) {
                Logger.getLogger(InstructorUI.class.getName()).log(Level.SEVERE, null, ex);
            }

            potentialutil = Double.parseDouble(t.futureutilization(tempdate, 1, 0));
            output = output + "          "
                    + "             " + potentialutil + "<br></br>";

            // System.out.println(x);
            for (int j = 0; j < ids.size(); j++) {
               // System.out.println(ids.get(j));
                String query4 = "Delete from courseexam where examid = '" + ids.get(j) + "'";
                DBConnection.ExecUpdateQuery(query4);
                
                query4 = "Delete from adhocexam where examid = '" + ids.get(j) + "'";
                DBConnection.ExecUpdateQuery(query4);

                query4 = "Delete from exam where examid = '" + ids.get(j) + "'";
                DBConnection.ExecUpdateQuery(query4);
                
                query4 = "Delete from studentexam where examid = '" + ids.get(j) + "'";
                DBConnection.ExecUpdateQuery(query4);
                
                
            }
            ids.clear();

            tempdate.setDate(tempdate.getDate() + 1);
        }

        utilization.setText(output + "<html></html>");
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                utilization.setVisible(false);
                submit.setVisible(false);
                cancel.setVisible(false);

                switchToInstructorSplashScreen(i);
            }
        });

        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                utilization.setVisible(false);
                submit.setVisible(false);
                cancel.setVisible(false);

                p.deleterequest(p.getRequestid());

                switchToInstructorSplashScreen(i);
            }
        });

    }

    public void switchToInstructorSplashScreen(Instructor i) {
        lblName.setVisible(true);
        lblName2.setVisible(true);
        lblInstructor.setVisible(true);
        calendar.setVisible(true);
        btnCreateAnExam.setVisible(true);
        btnAppointedRequests.setVisible(true);
        btnLogOut.setVisible(true);
    }

    public void switchToViewRequests(Instructor i, String term) {
        ArrayList<String> requestlist = new ArrayList();
        ArrayList<Integer> ids = new ArrayList();
        String query = "Select p.requestname, p.startdate, p.enddate, p.requestID from "
                + "pendingrequest p, requests r, instructor i where p.term = '" + term + "' AND "
                + "p.requestID = r.requestID"
                + " AND r.instructorID = i.instructorID AND i.instructorID = '" + i.getID() + "'";
        java.sql.ResultSet rs = DBConnection.ExecQuery(query);
        try {
            while (rs.next()) {
                requestlist.add(rs.getString(1) + "     " + rs.getDate(2) + "-" + rs.getDate(3));
                ids.add(rs.getInt(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(InstructorUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        String[] requestarray = new String[requestlist.size()];
        for (int j = 0; j < requestarray.length; j++) {
            requestarray[j] = requestlist.get(j);
        }

        JComboBox requests = new JComboBox();
        requests.setModel(new DefaultComboBoxModel(requestarray));
        requests.setBounds(111, 147, 294, 20);
        frameInstructorInterface.getContentPane().add(requests);

        JLabel submit = new JLabel();
        submit.setBounds(100, 200, 350, 200);
        frameInstructorInterface.getContentPane().add(submit);

        requests.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String output = "<HTML> <br></br>";
                String query = "Select p.status, p.students from pendingrequest p "
                        + "where p.requestid = '" + ids.get(requests.getSelectedIndex()) + "'";
                java.sql.ResultSet rs = DBConnection.ExecQuery(query);
                //System.out.println(ids.get(requests.getSelectedIndex()));
                String checkedin = "";

                try {
                    while (rs.next()) {
                        output = output + "Request is " + rs.getString(1) + "<br></br>"
                                + rs.getString(2) + " students must take the exam";
                        checkedin = rs.getString(1);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(InstructorUI.class.getName()).log(Level.SEVERE, null, ex);
                }

                query = "Select count(a.appointmentid) from appointment a, forexam f, exam e, approvedfor ap, pendingrequest p  "
                        + "where a.checkedin = 'checked in' AND a.appointmentID = f.appointmentID AND f.examID = e.examID"
                        + " AND e.examID = ap.examID AND ap.requestID = p.requestID AND p.requestID = '"
                        + ids.get(requests.getSelectedIndex()) + "'";
                rs = DBConnection.ExecQuery(query);
                int taken = 0;
                try {
                    while (rs.next()) {
                        taken = rs.getInt(1);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(InstructorUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                output = output + "<br></br>" + taken + " students have taken the exam";
                output = output + "</html>";
                submit.setText(output);

                JButton cancel = new JButton("Cancel Request");
                cancel.setBounds(300, 300, 150, 23);
                frameInstructorInterface.getContentPane().add(cancel);

                JButton backtohome = new JButton("Back To Home");
                backtohome.setBounds(300, 300, 121, 23);
                frameInstructorInterface.getContentPane().add(backtohome);

                cancel.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        switchToInstructorSplashScreen(i);
                    }
                });

                cancel.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        String query = "Select status from pendingrequest where requestid = '"
                                + ids.get(requests.getSelectedIndex()) + "'";
                        java.sql.ResultSet rs = DBConnection.ExecQuery(query);
                        String status = "";
                        try {
                            while (rs.next()) {
                                status = rs.getString(1);
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(InstructorUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        if (status.equals("pending")) {
                            query = "Delete from requests where "
                                    + "requestid = '" + ids.get(requests.getSelectedIndex()) + "'";
                            DBConnection.ExecUpdateQuery(query);

                            query = "Delete from pendingrequest where "
                                    + "requestid = '" + ids.get(requests.getSelectedIndex()) + "'";
                            DBConnection.ExecUpdateQuery(query);

                            switchToInstructorSplashScreen(i);
                        } else {
                            JOptionPane.showMessageDialog(frameInstructorInterface, "Approved or Denied requests cannot be cancelled");
                        }

                    }
                });

            }
        });
    }

    public void switchToExamSelect(Instructor i, String term) {
        ArrayList<String> examlist = new ArrayList();
        ArrayList<Integer> ids = new ArrayList();
        String query = "Select e.examname, e.startdate, e.enddate, e.examID from exam e, approvedfor a, "
                + "pendingrequest p, requests r, instructor i where e.term = '" + term + "' AND "
                + "e.examID = a.examID AND a.requestID = p.requestID AND p.requestID = r.requestID"
                + " AND r.instructorID = i.instructorID AND i.instructorID = '" + i.getID() + "'";
        java.sql.ResultSet rs = DBConnection.ExecQuery(query);
        try {
            while (rs.next()) {
                examlist.add(rs.getString(1) + "     " + rs.getDate(2) + "-" + rs.getDate(3));
                ids.add(rs.getInt(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(InstructorUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        String[] examarray = new String[examlist.size()];
        for (int j = 0; j < examarray.length; j++) {
            examarray[j] = examlist.get(j);
        }

        JComboBox exams = new JComboBox();
        exams.setModel(new DefaultComboBoxModel(examarray));
        exams.setBounds(111, 147, 294, 20);
        frameInstructorInterface.getContentPane().add(exams);

        JLabel submit = new JLabel();
        submit.setBounds(100, 200, 350, 200);
        frameInstructorInterface.getContentPane().add(submit);

        exams.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String output = "<HTML> <br></br>";
                String query = "Select u.name, a.date, a.starttime, a.endtime, a.seat, a.checkedin from user u, student s, has h, "
                        + "appointment a, forexam f where f.examID = '" + ids.get(exams.getSelectedIndex())
                        + "' AND f.appointmentID = a.appointmentID AND a.appointmentID = h.appointmentID"
                        + " AND h.studentID = s.studentID AND s.studentID = u.userID";
                java.sql.ResultSet rs = DBConnection.ExecQuery(query);
                //System.out.println(ids.get(exams.getSelectedIndex()));

                try {
                    while (rs.next()) {
                        output = output + rs.getString(1) + "     " + rs.getString(2) + "     "
                                + rs.getString(3) + " - " + rs.getString(4) + " Seat "
                                + rs.getString(5) + "   " + rs.getString(6) + "  <br></br>";
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(InstructorUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                output = output + "</html>";
                submit.setText(output);
            }
        });
    }

}
