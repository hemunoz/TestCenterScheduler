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
import cse.pkg308.ui.UserUI;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
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

public class AdministratorUI {

    public static JFrame sessionframe;
    public static JFrame frmAdministratorInterface;

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
    public static JButton btnApply;
    public static JButton btnSchedulingRequests;
    public static JButton btnMakeAnAppointment;
    public static JButton btnCheckInStudent;
    public static JLabel lblStudentId;
    public static JButton btnGenerateReport;
    
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

        lblAdministrator = new JLabel("Administrator");
        lblAdministrator.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblAdministrator.setBounds(158, 11, 121, 19);
        frmAdministratorInterface.getContentPane().add(lblAdministrator);

        lblName = new JLabel("Name:");
        lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblName.setBounds(10, 41, 46, 14);
        frmAdministratorInterface.getContentPane().add(lblName);

        lblName2 = new JLabel("");
        lblName2.setBounds(57, 41, 74, 14);
        frmAdministratorInterface.getContentPane().add(lblName2);

        lblNumberOfSeats = new JLabel("Number of Seats Available:");
        lblNumberOfSeats.setBounds(10, 77, 144, 14);
        frmAdministratorInterface.getContentPane().add(lblNumberOfSeats);

        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[]{""}));
        comboBox.setBounds(156, 74, 46, 20);
        frmAdministratorInterface.getContentPane().add(comboBox);

        lblNumberOfReserved = new JLabel("Number of Reserved Seats:");
        lblNumberOfReserved.setBounds(10, 102, 144, 14);
        frmAdministratorInterface.getContentPane().add(lblNumberOfReserved);

        comboBox_1 = new JComboBox();
        comboBox_1.setModel(new DefaultComboBoxModel(new String[]{""}));
        comboBox_1.setBounds(156, 99, 46, 20);
        frmAdministratorInterface.getContentPane().add(comboBox_1);

        calendar = new JCalendar();
        calendar.setBounds(226, 41, 198, 153);
        frmAdministratorInterface.getContentPane().add(calendar);

        lblSemester = new JLabel("Semester:");
        lblSemester.setBounds(10, 146, 56, 14);
        frmAdministratorInterface.getContentPane().add(lblSemester);

        comboBox_2 = new JComboBox();
        comboBox_2.setModel(new DefaultComboBoxModel(new String[]{""}));
        comboBox_2.setBounds(76, 143, 126, 20);
        frmAdministratorInterface.getContentPane().add(comboBox_2);

        lblOpenTime = new JLabel("Open Time:");
        lblOpenTime.setBounds(10, 173, 56, 14);
        frmAdministratorInterface.getContentPane().add(lblOpenTime);

        textFieldOpenTime = new JTextField();
        textFieldOpenTime.setBounds(76, 170, 86, 20);
        frmAdministratorInterface.getContentPane().add(textFieldOpenTime);
        textFieldOpenTime.setColumns(10);

        textFieldCloseTime = new JTextField();
        textFieldCloseTime.setBounds(76, 197, 86, 20);
        frmAdministratorInterface.getContentPane().add(textFieldCloseTime);
        textFieldCloseTime.setColumns(10);

        lblCloseTime = new JLabel("Close Time:");
        lblCloseTime.setBounds(10, 200, 56, 14);
        frmAdministratorInterface.getContentPane().add(lblCloseTime);

        lblOpenDate = new JLabel("Open Date:");
        lblOpenDate.setBounds(10, 225, 56, 23);
        frmAdministratorInterface.getContentPane().add(lblOpenDate);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(76, 228, 91, 20);
        frmAdministratorInterface.getContentPane().add(dateChooser);

        dateChooser_1 = new JDateChooser();
        dateChooser_1.setBounds(75, 259, 91, 20);
        frmAdministratorInterface.getContentPane().add(dateChooser_1);

        lblCloseDate = new JLabel("Close Date:");
        lblCloseDate.setBounds(10, 259, 56, 14);
        frmAdministratorInterface.getContentPane().add(lblCloseDate);

        btnLogOut = new JButton("Log Out");
        btnLogOut.setBounds(335, 371, 89, 23);
        frmAdministratorInterface.getContentPane().add(btnLogOut);

        btnLogOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        btnImportData = new JButton("Import Data");
        btnImportData.setBounds(262, 205, 137, 23);
        frmAdministratorInterface.getContentPane().add(btnImportData);

        btnApply = new JButton("Apply");
        btnApply.setBounds(57, 290, 89, 23);
        frmAdministratorInterface.getContentPane().add(btnApply);

        btnSchedulingRequests = new JButton("Scheduling Requests");
        btnSchedulingRequests.setBounds(262, 239, 137, 23);
        frmAdministratorInterface.getContentPane().add(btnSchedulingRequests);

        btnSchedulingRequests.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

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

        btnMakeAnAppointment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                lblName.setVisible(false);
                textFieldOpenTime.setVisible(false);
                textFieldCloseTime.setVisible(false);
                textFieldID.setVisible(false);
                lblAdministrator.setVisible(false);
                lblName2.setVisible(false);
                calendar.setVisible(false);
                lblNumberOfSeats.setVisible(false);
                comboBox.setVisible(false);
                lblNumberOfReserved.setVisible(false);
                btnLogOut.setVisible(false);
                lblName2.setVisible(false);
                comboBox_1.setVisible(false);
                lblSemester.setVisible(false);
                comboBox_2.setVisible(false);
                lblOpenTime.setVisible(false);
                dateChooser.setVisible(false);
                lblCloseTime.setVisible(false);
                lblOpenDate.setVisible(false);
                dateChooser_1.setVisible(false);
                lblCloseDate.setVisible(false);
                lblOpenTime.setVisible(false);
                btnImportData.setVisible(false);
                btnApply.setVisible(false);
                btnSchedulingRequests.setVisible(false);
                btnMakeAnAppointment.setVisible(false);
                btnCheckInStudent.setVisible(false);
                lblStudentId.setVisible(false);
                btnGenerateReport.setVisible(false);

                switchToMakeStudentAppointment(a);
            }
        });
    }

    public void switchToMakeStudentAppointment(Administrator a) {
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
        
        btnname.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StudentID.setVisible(false);
                IDtext.setVisible(false);
                btnID.setVisible(false);
                Studentname.setVisible(false);
                nametext.setVisible(false);
                btnname.setVisible(false);
                
                int i = 0;
                ArrayList <JButton> btnapp = new ArrayList();
                ArrayList <JLabel> lblapp = new ArrayList();

                String query = "SELECT u.name from user u, student s where u.lastname = '" + nametext.getText() + "'"
                        + "AND s.studentid = u.userid";

                //String query = "Select name from student";
        //Connection connection = DBConnection.getconnection();
                //System.out.println(connection);
                java.sql.ResultSet rs = DBConnection.ExecQuery(query);
                //System.out.println(DBConnection.getconnection());
                try {
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
              
                for(j = 0; j<i; j++)
                {
                    lblapp.get(j).setBounds(10, 50 + (j * 35), 137, 23);
                    frmAdministratorInterface.getContentPane().add(lblapp.get(j));
                    
                    btnapp.get(j).setBounds(176, 50 + (j * 35), 137, 23);
                    frmAdministratorInterface.getContentPane().add(btnapp.get(j));
                    
                    btnapp.get(j).addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String query = "Select userid from user where name = '" + e.getActionCommand() + "'";
                        String id = "";
                        java.sql.ResultSet rs = DBConnection.ExecQuery(query);
                        
                        //System.out.println(e.getActionCommand());
                        
                        try {
                    while (rs.next()) {
                        id = rs.getString(1);

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                        //System.out.println(id);
                        for(int k = 0; k < btnapp.size(); k++)
                        {
                            btnapp.get(k).setVisible(false);
                            lblapp.get(k).setVisible(false);
                        }
                        
                        
                        switchToSelectExamPage(a, id);
                        
                    }
                    });
                }
            }
        });
        
        btnID.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StudentID.setVisible(false);
                IDtext.setVisible(false);
                btnID.setVisible(false);
                Studentname.setVisible(false);
                nametext.setVisible(false);
                btnname.setVisible(false);
                
                int i = 0;
                ArrayList <JButton> btnapp = new ArrayList();
                ArrayList <JLabel> lblapp = new ArrayList();

                String query = "SELECT u.name from user u where u.userid = '" + IDtext.getText() + "'";

                //String query = "Select name from student";
        //Connection connection = DBConnection.getconnection();
                //System.out.println(connection);
                java.sql.ResultSet rs = DBConnection.ExecQuery(query);
                //System.out.println(DBConnection.getconnection());
                try {
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
              
                for(j = 0; j<i; j++)
                {
                    lblapp.get(j).setBounds(10, 50 + (j * 35), 137, 23);
                    frmAdministratorInterface.getContentPane().add(lblapp.get(j));
                    
                    btnapp.get(j).setBounds(176, 50 + (j * 35), 137, 23);
                    frmAdministratorInterface.getContentPane().add(btnapp.get(j));
                    
                    btnapp.get(j).addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        
                        for(int k = 0; k < btnapp.size(); k++)
                        {
                            btnapp.get(k).setVisible(false);
                            lblapp.get(k).setVisible(false);
                        }
                        
                        switchToSelectExamPage(a, IDtext.getText());
                        
                    }
                    });
                }
            }
        });
    }
    
    public void switchToSelectExamPage(Administrator a, String studentID){
        
        JLabel lblTakeAnExam = new JLabel("Take an Exam");
        lblTakeAnExam.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblTakeAnExam.setBounds(44, 11, 140, 25);
        frmAdministratorInterface.getContentPane().add(lblTakeAnExam);

        JLabel lblCourses = new JLabel("Courses:");
        lblCourses.setBounds(28, 50, 46, 14);
        frmAdministratorInterface.getContentPane().add(lblCourses);

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

        JComboBox coursecomboBox = new JComboBox();
        coursecomboBox.setModel(new DefaultComboBoxModel(courselist));
        coursecomboBox.setBounds(111, 47, 94, 20);
        frmAdministratorInterface.getContentPane().add(coursecomboBox);
        
        JComboBox examcomboBox = new JComboBox();
        examcomboBox.setModel(new DefaultComboBoxModel());
        examcomboBox.setBounds(111, 75, 194, 20);
        frmAdministratorInterface.getContentPane().add(examcomboBox);

        coursecomboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //System.out.println(coursecomboBox.getSelectedItem().toString());
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

        //String select = coursecomboBox.getSelectedItem().toString();
        //System.out.println(select);

        
        
        examcomboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //System.out.println(coursecomboBox.getSelectedItem().toString());
                Date[] dates = new Date[5];
                String [] stringdates = new String[5];
                String query = "Select startDate from exam where "
                        + "examname = '" + examcomboBox.getSelectedItem().toString() + "'";
                        //System.out.println(examcomboBox.getSelectedItem().toString());
                java.sql.ResultSet rs = DBConnection.ExecQuery(query);
                int i = 0;
                try {
                    while (rs.next()) {

                        dates[i] = rs.getDate(1);

                        i++;

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                Time[] times = new Time[5];
                
                query = "Select StartTime from exam where "
                        + "examname = '" + examcomboBox.getSelectedItem().toString() + "'";
                        //System.out.println(examcomboBox.getSelectedItem().toString());
                rs = DBConnection.ExecQuery(query);
                i = 0;
                try {
                    while (rs.next()) {

                        times[i] = rs.getTime(1);

                        i++;

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }

                datecomboBox.setModel(new DefaultComboBoxModel(dates));
                timecomboBox.setModel(new DefaultComboBoxModel(times));
        //examcomboBox.setBounds(111, 75, 94, 20);
                //frmStudentInterface.getContentPane().add(examcomboBox);
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
        //timecomboBox.setModel(new DefaultComboBoxModel(new String[]{"1:00", "1:30", "2:00", "2:30"
        //    + "3:00", "3:30", "4:00", "4:30", "5:00", "5:30", "6:00", "6:30", "7:00", "7:30", "8:00"
        //    + "8:30", "9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30"}));
        timecomboBox.setModel(new DefaultComboBoxModel());
        timecomboBox.setBounds(111, 106, 144, 20);
        frmAdministratorInterface.getContentPane().add(timecomboBox);

        /*ampmcomboBox = new JComboBox();
        ampmcomboBox.setModel(new DefaultComboBoxModel(new String[]{"AM", "PM"}));
        ampmcomboBox.setBounds(171, 106, 44, 20);
        frmStudentInterface.getContentPane().add(ampmcomboBox);*/

        JLabel lblTime = new JLabel("Time:");
        lblTime.setBounds(28, 109, 46, 14);
        frmAdministratorInterface.getContentPane().add(lblTime);

        /*dateChooser = new JDateChooser();
        dateChooser.setBounds(111, 137, 94, 20);
        frmStudentInterface.getContentPane().add(dateChooser);*/

        JLabel lblDate = new JLabel("Date:");
        lblDate.setBounds(28, 132, 46, 25);
        frmAdministratorInterface.getContentPane().add(lblDate);
        
        

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(17, 173, 89, 23);
        frmAdministratorInterface.getContentPane().add(btnCancel);

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(116, 173, 89, 23);
        frmAdministratorInterface.getContentPane().add(btnSubmit);

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

                //switchToStudentSplashScreen();

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
                for (i = 0; i < courses.length; i++) {
                    if (courses[i].getCoursename().equals(coursecomboBox.getSelectedItem())) {
                        break;
                    }
                }

                Exam exam = new Exam();

                String query = "Select * from Exam where examname = '" + examcomboBox.getSelectedItem().toString() + "'"
                        + " AND startDate = '" + datecomboBox.getSelectedItem() + "'"
                        + " AND startTime = '" + timecomboBox.getSelectedItem() + "'";
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
                //System.out.println(courses[i].getCoursename());

                System.out.println(exam.getExamID());
                if (courses[i].lookupstudent(studentID) == false) {
                    switchToCannotSchedulePage("You are not currently enrolled in this course");
                } else if (exam.lookupstudent(studentID) == true) {
                    switchToCannotSchedulePage("You already have an appointment for this exam");
                } else {
                    switchToAppointmentConfirmationPage(studentID, exam);
                }

            }

        });

        
        

    }
    
    public void switchToAppointmentConfirmationPage(String studentID, Exam exam) {
        JLabel confirmation = new JLabel("Your Appointment Has Been Confirmed");
        confirmation.setFont(new Font("Tahoma", Font.PLAIN, 15));
        confirmation.setBounds(35, 11, 177, 21);
        frmAdministratorInterface.getContentPane().add(confirmation);

        JButton btnbacktohome = new JButton("Back to Home");
        btnbacktohome.setBounds(10, 150, 121, 23);
        frmAdministratorInterface.getContentPane().add(btnbacktohome);

        /*String query = "Select (Max(appointmentID)+1) from appointment";
        java.sql.ResultSet rs = DBConnection.ExecQuery(query);

        String id = "";

        try {
            while (rs.next()) {
                id = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        query = "INSERT INTO appointment VALUES ("
                + "' " + id + "', 'pending')";
        DBConnection.ExecUpdateQuery(query);

        query = "INSERT INTO has VALUES ('" + s.getID() + "', '" + id + "')";
        DBConnection.ExecUpdateQuery(query);

        query = "INSERT INTO forexam VALUES ('" + id + "', '" + exam.getExamID() + "')";
        DBConnection.ExecUpdateQuery(query);*/
        
        Appointment app = new Appointment();
        app.addappointment(exam.getExamID(), studentID, exam.getStartDate());
        

        btnbacktohome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                confirmation.setVisible(false);
                btnbacktohome.setVisible(false);

                switchToAdminSplashScreen();

            }

        });
    }
    
    public void switchToAdminSplashScreen(){
        lblName.setVisible(true);
                textFieldOpenTime.setVisible(true);
                textFieldCloseTime.setVisible(true);
                textFieldID.setVisible(true);
                lblAdministrator.setVisible(true);
                lblName2.setVisible(true);
                calendar.setVisible(true);
                lblNumberOfSeats.setVisible(true);
                comboBox.setVisible(true);
                lblNumberOfReserved.setVisible(true);
                btnLogOut.setVisible(true);
                lblName2.setVisible(true);
                comboBox_1.setVisible(true);
                lblSemester.setVisible(true);
                comboBox_2.setVisible(true);
                lblOpenTime.setVisible(true);
                dateChooser.setVisible(true);
                lblCloseTime.setVisible(true);
                lblOpenDate.setVisible(true);
                dateChooser_1.setVisible(true);
                lblCloseDate.setVisible(true);
                lblOpenTime.setVisible(true);
                btnImportData.setVisible(true);
                btnApply.setVisible(true);
                btnSchedulingRequests.setVisible(true);
                btnMakeAnAppointment.setVisible(true);
                btnCheckInStudent.setVisible(true);
                lblStudentId.setVisible(true);
                btnGenerateReport.setVisible(true);
    }
    
    public void switchToCannotSchedulePage(String m) {
        JLabel notapproved = new JLabel(m);
        notapproved.setFont(new Font("Tahoma", Font.PLAIN, 15));
        notapproved.setBounds(35, 11, 277, 21);
        frmAdministratorInterface.getContentPane().add(notapproved);

        JButton btnbacktohome = new JButton("Back to Home");
        btnbacktohome.setBounds(10, 150, 121, 23);
        frmAdministratorInterface.getContentPane().add(btnbacktohome);

        btnbacktohome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                notapproved.setVisible(false);
                btnbacktohome.setVisible(false);

                switchToAdminSplashScreen();

            }

        });
    }

}
