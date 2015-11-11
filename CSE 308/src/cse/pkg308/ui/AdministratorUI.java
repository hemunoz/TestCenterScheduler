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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
        /*
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
         frmAdministratorInterface.getContentPane().add(comboBox_1);*/

        calendar = new JCalendar();
        calendar.setBounds(226, 41, 198, 153);
        frmAdministratorInterface.getContentPane().add(calendar);
        /*
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
         frmAdministratorInterface.getContentPane().add(lblCloseDate);*/

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
                /*textFieldOpenTime.setVisible(false);
                 textFieldCloseTime.setVisible(false);*/
                textFieldID.setVisible(false);
                lblAdministrator.setVisible(false);
                lblName2.setVisible(false);
                calendar.setVisible(false);
                /*lblNumberOfSeats.setVisible(false);
                 comboBox.setVisible(false);
                 lblNumberOfReserved.setVisible(false);*/
                btnLogOut.setVisible(false);
                lblName2.setVisible(false);
                /*comboBox_1.setVisible(false);
                 lblSemester.setVisible(false);
                 comboBox_2.setVisible(false);
                 lblOpenTime.setVisible(false);
                 dateChooser.setVisible(false);
                 lblCloseTime.setVisible(false);
                 lblOpenDate.setVisible(false);
                 dateChooser_1.setVisible(false);
                 lblCloseDate.setVisible(false);
                 lblOpenTime.setVisible(false);*/
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

        btnedittestingcenter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblName.setVisible(false);
                /*textFieldOpenTime.setVisible(false);
                 textFieldCloseTime.setVisible(false);*/
                textFieldID.setVisible(false);
                lblAdministrator.setVisible(false);
                lblName2.setVisible(false);
                calendar.setVisible(false);
                /*lblNumberOfSeats.setVisible(false);
                 comboBox.setVisible(false);
                 lblNumberOfReserved.setVisible(false);*/
                btnLogOut.setVisible(false);
                lblName2.setVisible(false);
                /*comboBox_1.setVisible(false);
                 lblSemester.setVisible(false);
                 comboBox_2.setVisible(false);
                 lblOpenTime.setVisible(false);
                 dateChooser.setVisible(false);
                 lblCloseTime.setVisible(false);
                 lblOpenDate.setVisible(false);
                 dateChooser_1.setVisible(false);
                 lblCloseDate.setVisible(false);
                 lblOpenTime.setVisible(false);*/
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
                /*textFieldOpenTime.setVisible(false);
                 textFieldCloseTime.setVisible(false);*/
                textFieldID.setVisible(false);
                lblAdministrator.setVisible(false);
                lblName2.setVisible(false);
                calendar.setVisible(false);
                /*lblNumberOfSeats.setVisible(false);
                 comboBox.setVisible(false);
                 lblNumberOfReserved.setVisible(false);*/
                btnLogOut.setVisible(false);
                lblName2.setVisible(false);
                /*comboBox_1.setVisible(false);
                 lblSemester.setVisible(false);
                 comboBox_2.setVisible(false);
                 lblOpenTime.setVisible(false);
                 dateChooser.setVisible(false);
                 lblCloseTime.setVisible(false);
                 lblOpenDate.setVisible(false);
                 dateChooser_1.setVisible(false);
                 lblCloseDate.setVisible(false);
                 lblOpenTime.setVisible(false);*/
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
                /*textFieldOpenTime.setVisible(false);
                 textFieldCloseTime.setVisible(false);*/
                textFieldID.setVisible(false);
                lblAdministrator.setVisible(false);
                lblName2.setVisible(false);
                calendar.setVisible(false);
                /*lblNumberOfSeats.setVisible(false);
                 comboBox.setVisible(false);
                 lblNumberOfReserved.setVisible(false);*/
                btnLogOut.setVisible(false);
                lblName2.setVisible(false);
                /*comboBox_1.setVisible(false);
                 lblSemester.setVisible(false);
                 comboBox_2.setVisible(false);
                 lblOpenTime.setVisible(false);
                 dateChooser.setVisible(false);
                 lblCloseTime.setVisible(false);
                 lblOpenDate.setVisible(false);
                 dateChooser_1.setVisible(false);
                 lblCloseDate.setVisible(false);
                 lblOpenTime.setVisible(false);*/
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
                /*textFieldOpenTime.setVisible(false);
                 textFieldCloseTime.setVisible(false);*/
                textFieldID.setVisible(false);
                lblAdministrator.setVisible(false);
                lblName2.setVisible(false);
                calendar.setVisible(false);
                /*lblNumberOfSeats.setVisible(false);
                 comboBox.setVisible(false);
                 lblNumberOfReserved.setVisible(false);*/
                btnLogOut.setVisible(false);
                lblName2.setVisible(false);
                /*comboBox_1.setVisible(false);
                 lblSemester.setVisible(false);
                 comboBox_2.setVisible(false);
                 lblOpenTime.setVisible(false);
                 dateChooser.setVisible(false);
                 lblCloseTime.setVisible(false);
                 lblOpenDate.setVisible(false);
                 dateChooser_1.setVisible(false);
                 lblCloseDate.setVisible(false);
                 lblOpenTime.setVisible(false);*/
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

        btnMakeAnAppointment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                lblName.setVisible(false);
                /*textFieldOpenTime.setVisible(false);
                 textFieldCloseTime.setVisible(false);*/
                textFieldID.setVisible(false);
                lblAdministrator.setVisible(false);
                lblName2.setVisible(false);
                calendar.setVisible(false);
                /*lblNumberOfSeats.setVisible(false);
                 comboBox.setVisible(false);
                 lblNumberOfReserved.setVisible(false);*/
                btnLogOut.setVisible(false);
                lblName2.setVisible(false);
                /*comboBox_1.setVisible(false);
                 lblSemester.setVisible(false);
                 comboBox_2.setVisible(false);
                 lblOpenTime.setVisible(false);
                 dateChooser.setVisible(false);
                 lblCloseTime.setVisible(false);
                 lblOpenDate.setVisible(false);
                 dateChooser_1.setVisible(false);
                 lblCloseDate.setVisible(false);
                 lblOpenTime.setVisible(false);*/
                btnImportData.setVisible(false);
                btnUtilization.setVisible(false);
                btnSchedulingRequests.setVisible(false);
                btnMakeAnAppointment.setVisible(false);
                btnCheckInStudent.setVisible(false);
                lblStudentId.setVisible(false);
                btnGenerateReport.setVisible(false);
                btnAppointments.setVisible(false);
                btnedittestingcenter.setVisible(false);

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
                ArrayList<JButton> btnapp = new ArrayList();
                ArrayList<JLabel> lblapp = new ArrayList();

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

                for (j = 0; j < i; j++) {
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
                            for (int k = 0; k < btnapp.size(); k++) {
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
                ArrayList<JButton> btnapp = new ArrayList();
                ArrayList<JLabel> lblapp = new ArrayList();

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

                for (j = 0; j < i; j++) {
                    lblapp.get(j).setBounds(10, 50 + (j * 35), 137, 23);
                    frmAdministratorInterface.getContentPane().add(lblapp.get(j));

                    btnapp.get(j).setBounds(176, 50 + (j * 35), 137, 23);
                    frmAdministratorInterface.getContentPane().add(btnapp.get(j));

                    btnapp.get(j).addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {

                            for (int k = 0; k < btnapp.size(); k++) {
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

    public void switchToSelectExamPage(Administrator a, String studentID) {

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
                String[] stringdates = new String[5];
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
                    switchToCannotSchedulePage(a, "You are not currently enrolled in this course");
                } else if (exam.lookupstudent(studentID) == true) {
                    switchToCannotSchedulePage(a, "You already have an appointment for this exam");
                } else {
                    switchToAppointmentConfirmationPage(a, studentID, exam);
                }

            }

        });

    }

    public void switchToAppointmentConfirmationPage(Administrator a, String studentID, Exam exam) {
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

                switchToAdminSplashScreen(a);

            }

        });
    }

    public void switchToAdminSplashScreen(Administrator a) {
        lblName.setVisible(true);
                /*textFieldOpenTime.setVisible(false);
                 textFieldCloseTime.setVisible(false);*/
                textFieldID.setVisible(true);
                lblAdministrator.setVisible(true);
                lblName2.setVisible(true);
                calendar.setVisible(true);
                /*lblNumberOfSeats.setVisible(false);
                 comboBox.setVisible(false);
                 lblNumberOfReserved.setVisible(false);*/
                btnLogOut.setVisible(true);
                lblName2.setVisible(true);
                /*comboBox_1.setVisible(false);
                 lblSemester.setVisible(false);
                 comboBox_2.setVisible(false);
                 lblOpenTime.setVisible(false);
                 dateChooser.setVisible(false);
                 lblCloseTime.setVisible(false);
                 lblOpenDate.setVisible(false);
                 dateChooser_1.setVisible(false);
                 lblCloseDate.setVisible(false);
                 lblOpenTime.setVisible(false);*/
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

                switchToAdminSplashScreen(a);

            }

        });
    }

    public void switchToViewAppointments(Administrator a) {
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

                String query = "Select u.name, e.examname, a.date, a.checkedin, e.examID, "
                        + "a.appointmentID, s.studentID from appointment a, "
                        + "exam e, student s, user u, has h, forexam f where e.examID = f.examID AND "
                        + "f.appointmentID = a.appointmentID AND a.appointmentID = h.appointmentID AND "
                        + "h.studentID = s.studentID AND s.studentID = u.userID AND e.term = '" + term + "'";

                java.sql.ResultSet rs = DBConnection.ExecQuery(query);
                ArrayList<String> appstrings = new ArrayList();
                ArrayList<Appointment> appointments = new ArrayList();
                ArrayList<String> names = new ArrayList();

                try {
                    while (rs.next()) {
                        appstrings.add(rs.getString(1) + ": " + rs.getString(2) + "-" + rs.getString(3));
                        Appointment a = new Appointment();
                        a.setAppointmentid(rs.getString(6));
                        a.setCheckedin(rs.getString(4));
                        a.setExamid(rs.getInt(5));
                        a.setStudentid(rs.getString(7));
                        a.setDate(rs.getDate(3));

                        //a.getDate().setYear(a.getDate().getYear() + 1900);
                        appointments.add(a);
                        System.out.println(rs.getString(1) + ": " + rs.getString(2) + "-" + a.getDate().getYear());
                        names.add(rs.getString(1));
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(AdministratorUI.class.getName()).log(Level.SEVERE, null, ex);
                }

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

                                JLabel date = new JLabel("Date: " + ap.getDate());
                                date.setFont(new Font("Tahoma", Font.PLAIN, 15));
                                date.setBounds(50, 151, 207, 21);
                                frmAdministratorInterface.getContentPane().add(date);

                                JCalendar appcalendar = new JCalendar();
                                appcalendar.setBounds(226, 41, 198, 153);
                                frmAdministratorInterface.getContentPane().add(appcalendar);

                                JButton setdate = new JButton("Print Date");
                                setdate.setBounds(50, 200, 127, 23);
                                frmAdministratorInterface.getContentPane().add(setdate);

                                setdate.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                        Calendar cal = Calendar.getInstance();

                                        cal.set(Calendar.YEAR, appcalendar.getDate().getYear());
                                        cal.set(Calendar.MONTH, appcalendar.getDate().getMonth());
                                        cal.set(Calendar.DAY_OF_MONTH, appcalendar.getDate().getDate());
                                        java.sql.Date newdate = new java.sql.Date(cal.getTimeInMillis());

                                        newdate.setYear(newdate.getYear() + 1900);

                                        ap.setDate(newdate);
                                        String query = "UPDATE `scheduler`.`appointment` SET `date`= '" + newdate + "' WHERE `appointmentID`='" + ap.getAppointmentid() + "'";
                                        DBConnection.ExecUpdateQuery(query);

                                        date.setText("Date: " + ap.getDate());

                                    }
                                });

                            }
                        });

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

                        CheckedIn.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                String query = "UPDATE `scheduler`.`appointment` SET `checkedin`='checked in' "
                                        + "WHERE `appointmentID`= '" + appid + "'";

                                DBConnection.ExecUpdateQuery(query);

                                appointments.get(termappointments.getSelectedIndex()).setCheckedin("checked in");

                                studentcheckedin.setText(name + " is checked in");

                            }

                        });

                        Pending.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                String query = "UPDATE `scheduler`.`appointment` SET `checkedin`='checked in' "
                                        + "WHERE `appointmentID`= '" + appid + "'";

                                DBConnection.ExecUpdateQuery(query);

                                appointments.get(termappointments.getSelectedIndex()).setCheckedin("pending");

                                studentcheckedin.setText(name + " is pending");

                            }

                        });

                        NotCheckedIn.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                String query = "UPDATE `scheduler`.`appointment` SET `checkedin`='checked in' "
                                        + "WHERE `appointmentID`= '" + appid + "'";

                                DBConnection.ExecUpdateQuery(query);

                                appointments.get(termappointments.getSelectedIndex()).setCheckedin("not checked in");

                                studentcheckedin.setText(name + " is not checked in");

                            }

                        });

                    }
                });
            }
        });
    }

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
        instr.setVisible(false);
        startdate.setVisible(false);
        enddate.setVisible(false);
        starttime.setVisible(false);
        endtime.setVisible(false);
        course.setVisible(false);
        approve.setVisible(false);
        deny.setVisible(false);
        approvelabel.setVisible(false);
        denylabel.setVisible(false);

        lookup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                season.setVisible(false);
                yearbox.setVisible(false);
                lookup.setVisible(false);
                frmAdministratorInterface.getContentPane().remove(season);
                frmAdministratorInterface.getContentPane().remove(yearbox);
                frmAdministratorInterface.getContentPane().remove(lookup);

                String term = season.getSelectedItem().toString() + " " + yearbox.getSelectedItem().toString();

                String query = "Select requestname from pendingrequest where term = '" + term + "'"
                        + "AND status = 'pending'";

                java.sql.ResultSet rs = DBConnection.ExecQuery(query);

                ArrayList<String> names = new ArrayList();

                try {
                    while (rs.next()) {
                        names.add(rs.getString(1));
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(AdministratorUI.class.getName()).log(Level.SEVERE, null, ex);
                }

                String[] namearray = new String[names.size()];
                for (int i = 0; i < namearray.length; i++) {
                    namearray[i] = names.get(i);
                }

                JComboBox exams = new JComboBox();
                exams.setModel(new DefaultComboBoxModel(namearray));
                exams.setBounds(100, 47, 124, 20);
                frmAdministratorInterface.getContentPane().add(exams);

                /*JButton info = new JButton("Request Info");

                 info.setBounds(10, 47, 80, 20);
                 frmAdministratorInterface.getContentPane().add(info);*/
                instrlabel.setVisible(true);
                startdatelabel.setVisible(true);
                enddatelabel.setVisible(true);
                starttimelabel.setVisible(true);
                endtimelabel.setVisible(true);
                courselabel.setVisible(true);

                exams.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        String query = "Select u.name, p.StartDate, p.EndDate, p.startTime, p.endTime, "
                                + "p.requestID, p.course, i.instructorid from pendingrequest p, "
                                + "requests r, instructor i, user u where r.requestID = p.requestID AND "
                                + "r.instructorID = i.instructorID AND i.instructorID = u.userID AND p.Term = '"
                                + term + "' AND p.requestname = '" + exams.getSelectedItem().toString() + "'";

                        java.sql.ResultSet rs = DBConnection.ExecQuery(query);

                        PendingRequest p = new PendingRequest();

                        try {
                            while (rs.next()) {

                                p.setStartDate(rs.getDate(2));
                                p.setEndDate(rs.getDate(3));
                                p.setStartTime(rs.getTime(4));
                                p.setEndTime(rs.getTime(5));
                                p.setRequestid(rs.getString(6));
                                p.setCourse(rs.getString(7));
                                p.setRequestname(exams.getSelectedItem().toString());
                                p.setTerm(term);

                                instr.setVisible(true);
                                startdate.setVisible(true);
                                enddate.setVisible(true);
                                starttime.setVisible(true);
                                endtime.setVisible(true);
                                course.setVisible(true);

                                instr.setText(rs.getString(1));
                                startdate.setText(rs.getString(2));
                                enddate.setText(rs.getString(3));
                                starttime.setText(rs.getString(4));
                                endtime.setText(rs.getString(5));
                                course.setText(rs.getString(7));

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
                                instr.setVisible(false);
                                startdate.setVisible(false);
                                enddate.setVisible(false);
                                starttime.setVisible(false);
                                endtime.setVisible(false);
                                course.setVisible(false);
                                approve.setVisible(false);
                                deny.setVisible(false);
                                exams.setVisible(false);

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

                                query = "INSERT INTO `scheduler`.`exam` (`examID`, `startDate`, `endDate`, `StartTime`, "
                                        + "`endTime`, `seatsAvailable`, `term`, `examtype`, `examname`) VALUES "
                                        + "('" + id + "', '" + p.getStartDate() + "', '" + p.getEndDate() + "', '"
                                        + p.getStartTime() + "', '" + p.getEndTime() + "', '100', '" + p.getTerm()
                                        + "', 'course', '" + p.getRequestname() + "')";
                                DBConnection.ExecUpdateQuery(query);

                                query = "INSERT INTO `scheduler`.`approvedfor` (`requestid`, `examid`) VALUES ('"
                                        + p.getRequestid() + "', '" + id + "')";
                                DBConnection.ExecUpdateQuery(query);

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

                                System.out.println(seats);

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

                                    String query3 = "INSERT INTO `scheduler`.`individualexam` (`individualid`, `examid`, `date`, "
                                            + "`starttime`, `endtime`, `seatsavailable`) VALUES ('" + rangeid + "', '" + id
                                            + "', '" + curs + "', '" + p.getStartTime() + "', '" + p.getEndTime() + "', '" + seats + "')";
                                    DBConnection.ExecUpdateQuery(query3);

                                    query3 = "UPDATE `scheduler`.`individualexam` SET `seatsavailable`='" + seats + "' where date = '" + curs
                                            + "' AND ((starttime <= '" + p.getEndTime() + "' AND endtime >= '" + p.getEndTime() + "') OR "
                                            + "(starttime <= '" + p.getStartTime() + "' AND endtime >= '" + p.getEndTime() + "') OR (starttime >= '" + p.getStartTime() + "' AND "
                                            + "endtime <= '" + p.getEndTime() + "') OR (starttime <= '" + p.getStartTime() + "' AND endtime >= '" + p.getStartTime() + "'))";
                                    DBConnection.ExecUpdateQuery(query3);

                                    System.out.println(seats);

                                    curs.setDate(curs.getDate() + 1);

                                }

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
                Date startdate = new Date();
                Date enddate = new Date();
                int year = Integer.parseInt(yearbox.getSelectedItem().toString());

                FileWriter fWriter;
                BufferedWriter newfile;
                try {
                    fWriter = new FileWriter("C:/Users/Owner/Desktop/TermReport.xhtml");
                    newfile = new BufferedWriter(fWriter);
                    newfile.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n <head>\n"
                            + "<title>Term Report</title>\n </head>\n<body>\n");

                    newfile.write("Courses that used Testing Center in " + season.getSelectedItem()
                            + " " + yearbox.getSelectedItem() + "<br></br><br></br>");

                    if (season.getSelectedItem().equals("Fall")) {
                        startdate.setYear(year);
                        startdate.setMonth(7);
                        startdate.setDate(25);
                        enddate.setYear(year);
                        enddate.setMonth(11);
                        enddate.setDate(18);
                        System.out.println(startdate);
                        System.out.println(enddate);
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
                    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

                    cal.set(Calendar.YEAR, currentdate.getYear());
                    cal.set(Calendar.MONTH, currentdate.getMonth());
                    cal.set(Calendar.DAY_OF_MONTH, currentdate.getDate());
                    java.sql.Date newdate = new java.sql.Date(cal.getTimeInMillis());

                    while (currentdate.getYear() != enddate.getYear() || currentdate.getMonth() != enddate.getMonth() || currentdate.getDate() != enddate.getDate()) {

                        String query = "Select count(a.appointmentID) from appointment a where"
                                + " a.date = '" + newdate + "'";

                        java.sql.ResultSet rs = DBConnection.ExecQuery(query);

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

                    newfile.write("\n</body>\n </html>");

                    //newfile.newLine();
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
                Date startdate = new Date();
                Date enddate = new Date();
                int year = Integer.parseInt(yearbox.getSelectedItem().toString());

                FileWriter fWriter = null;
                BufferedWriter newfile = null;
                try {
                    fWriter = new FileWriter("C:/Users/Owner/Desktop/TermReport.xhtml");
                    newfile = new BufferedWriter(fWriter);
                    newfile.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n <head>\n"
                            + "<title>Term Report</title>\n </head>\n<body>\n");

                    newfile.write("Courses that used Testing Center in " + season.getSelectedItem()
                            + " " + yearbox.getSelectedItem() + "<br></br><br></br>");

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
                    //SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

                    cal.set(Calendar.YEAR, currentdate.getYear());
                    cal.set(Calendar.MONTH, currentdate.getMonth());
                    cal.set(Calendar.DAY_OF_MONTH, currentdate.getDate());
                    java.sql.Date newdate = new java.sql.Date(cal.getTimeInMillis());
                    int week = cal.get(Calendar.WEEK_OF_YEAR);
                    int num = 0;

                    //java.sql.Date startweek = new java.sql.Date(cal.getTimeInMillis());
                    //System.out.println(startweek.getYear());
                    Date startweek = new Date();
                    startweek.setYear(currentdate.getYear());
                    startweek.setMonth(currentdate.getMonth());
                    startweek.setDate(currentdate.getDate());
                    Date endweek = startweek;

                    ArrayList<String> courses = new ArrayList();

                    while (currentdate.getYear() != enddate.getYear() || currentdate.getMonth() != enddate.getMonth() || currentdate.getDate() != enddate.getDate()) {
                        endweek = startweek;

                        String query = "Select count(a.appointmentID) from appointment a where"
                                + " a.date = '" + newdate + "'";

                        java.sql.ResultSet rs = DBConnection.ExecQuery(query);

                        while (rs.next()) {
                            num = num + rs.getInt(1);
                            //System.out.println(startweek.getYear());
                        }

                        query = "Select ce.courseidentifier from exam e, courseexam ce, appointment a, forexam f"
                                + " where a.date = '" + newdate + "' AND a.appointmentID = f.appointmentID"
                                + " AND f.examID = e.examID AND e.examID = ce.examID";

                        rs = DBConnection.ExecQuery(query);

                        while (rs.next()) {
                            courses.add(rs.getString(1));
                        }

                        currentdate.setDate(currentdate.getDate() + 1);
                        cal.set(Calendar.YEAR, currentdate.getYear());
                        cal.set(Calendar.MONTH, currentdate.getMonth());
                        cal.set(Calendar.DAY_OF_MONTH, currentdate.getDate());
                        newdate = new java.sql.Date(cal.getTimeInMillis());
                        endweek = currentdate;

                        if (cal.get(Calendar.WEEK_OF_YEAR) != week) {
                            currentdate.setDate(currentdate.getDate() - 1);
                            week = cal.get(Calendar.WEEK_OF_YEAR);

                            newfile.write((startweek.getMonth() + 1) + "/" + startweek.getDate() + "/"
                                    + startweek.getYear() + " - " + (endweek.getMonth() + 1) + "/" + endweek.getDate() + "/"
                                    + endweek.getYear() + ": " + num + "   ");

                            for (int i = 0; i < courses.size(); i++) {
                                newfile.write(courses.get(i) + "  ");
                            }
                            newfile.write("<br></br>");

                            int j = courses.size();

                            for (int i = j - 1; i >= 0; i--) {
                                courses.remove(i);
                            }

                            num = 0;

                            startweek.setYear(currentdate.getYear());
                            startweek.setMonth(currentdate.getMonth());
                            startweek.setDate(currentdate.getDate());

                        }

                    }
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

                FileWriter fWriter;
                BufferedWriter newfile;
                try {
                    fWriter = new FileWriter("C:/Users/Owner/Desktop/TermReport.xhtml");
                    newfile = new BufferedWriter(fWriter);
                    newfile.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n <head>\n"
                            + "<title>Term Report</title>\n </head>\n<body>\n");

                    newfile.write("Courses that used Testing Center in " + season.getSelectedItem()
                            + " " + yearbox.getSelectedItem() + "<br></br><br></br>");

                    String query = "Select c.course from courseexam c, exam e where"
                            + " e.Term = '" + term + "' AND e.examID = c.examID Group By course";

                    java.sql.ResultSet rs = DBConnection.ExecQuery(query);

                    while (rs.next()) {
                        newfile.write(rs.getString(1) + "<br></br>");
                    }

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

        addterm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (season.getSelectedItem() != null && yearbox.getSelectedItem() != null) {
                    terms.add(season.getSelectedItem() + "_" + yearbox.getSelectedItem());
                    String[] termarray = new String[terms.size()];
                    for (int i = 0; i < termarray.length; i++) {
                        termarray[i] = terms.get(i);
                    }

                    termbox.setModel(new DefaultComboBoxModel(termarray));
                }
            }
        });

        JButton lookup = new JButton("View Term Appointments");
        lookup.setBounds(111, 200, 137, 23);
        frmAdministratorInterface.getContentPane().add(lookup);

        lookup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // termbox.getItemAt(buttonindex)
                //String term = season.getSelectedItem() + "_" + yearbox.getSelectedItem();

                FileWriter fWriter;
                BufferedWriter newfile;
                try {
                    fWriter = new FileWriter("C:/Users/Owner/Desktop/TermReport.xhtml");
                    newfile = new BufferedWriter(fWriter);
                    newfile.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n <head>\n"
                            + "<title>Term Report</title>\n </head>\n<body>\n");

                    newfile.write("Number of Appointments During <br></br><br></br>");

                    for (int i = 0; i < terms.size(); i++) {
                        newfile.write(termbox.getItemAt(i).toString() + ": ");

                        String query = "Select count(a.appointmentID) from appointment a, exam e, forexam f where"
                                + " a.appointmentID = f.appointmentID AND f.examID = e.examID AND"
                                + " e.Term = '" + termbox.getItemAt(i) + "'";

                        java.sql.ResultSet rs = DBConnection.ExecQuery(query);

                        while (rs.next()) {
                            newfile.write(rs.getString(1) + "<br></br>");
                        }

                        newfile.write("<br></br><br></br>");
                    }

                    newfile.write("\n</body>\n </html>");

                    newfile.close();
                } catch (Exception ex) {
                    //catch any exceptions here
                }
            }
        });
    }

    public void switchToEditTestingCenter(Administrator a) {
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

                String term = season.getSelectedItem() + " " + yearbox.getSelectedItem();

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
                if (id.equals("")) {

                    t.newterm(term);

                } else {
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

                        JLabel openlabel = new JLabel();
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

                        JLabel closelabel = new JLabel();
                        closelabel.setBounds(200, 120, 250, 40);
                        frmAdministratorInterface.getContentPane().add(closelabel);

                        JComboBox ranges = new JComboBox();
                        ranges.setModel(new DefaultComboBoxModel(t.getNonSBTimes()));
                        ranges.setBounds(150, 190, 80, 20);
                        frmAdministratorInterface.getContentPane().add(ranges);

                        addnonsb.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                Time opentime = new Time(openhour.getSelectedIndex() + 1, openminute.getSelectedIndex(), 0);
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

                                openlabel.setText("Open Time Added: " + opentime);
                                closelabel.setText("Close Time Added: " + closetime);

                                t.addnonsbtime(opentime, closetime);

                                ranges.setModel(new DefaultComboBoxModel(t.getNonSBTimes()));

                            }

                        });

                    }
                });

                closed.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        seats.setVisible(false);
                        setaside.setVisible(false);
                        gaptime.setVisible(false);
                        reminder.setVisible(false);
                        hours.setVisible(false);
                        closed.setVisible(false);

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

                                Calendar cal = Calendar.getInstance();
                                cal.set(Calendar.YEAR, calendar.getDate().getYear());
                                cal.set(Calendar.MONTH, calendar.getDate().getMonth());
                                cal.set(Calendar.DAY_OF_MONTH, calendar.getDate().getDate());
                                //java.sql.Date newdate = new java.sql.Date(cal.getTimeInMillis());
                                //start = new java.sql.Date(cal.getTimeInMillis());
                                java.sql.Date selected = new java.sql.Date(cal.getTimeInMillis());
                                selected.setYear(selected.getYear() + 1900);

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
                                Calendar cal = Calendar.getInstance();

                                cal.set(Calendar.YEAR, calendar.getDate().getYear());
                                cal.set(Calendar.MONTH, calendar.getDate().getMonth());
                                cal.set(Calendar.DAY_OF_MONTH, calendar.getDate().getDate());

                                java.sql.Date selected = new java.sql.Date(cal.getTimeInMillis());
                                selected.setYear(selected.getYear() + 1900);

                                if (start.getTime() > selected.getTime() && start.getTime() != current.getTime()) {
                                    System.out.println("Invalid");
                                } else {
                                    end.setTime(cal.getTimeInMillis());

                                    end.setYear(end.getYear() + 1900);
                                    endlabel.setText(end.toString());
                                }

                            }
                        });

                        addrange.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                if (start.getTime() != current.getTime() && end.getTime() != current.getTime()) {
                                    t.setStartclosed(start);
                                    t.setEndclosed(end);

                                    t.addClosedDates(start, end);
                                }
                            }
                        });

                        removerange.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                if (start.getTime() != current.getTime() && end.getTime() != current.getTime()) {
                                    t.setStartclosed(start);
                                    t.setEndclosed(end);

                                    t.removeClosedDates(start, end);
                                }
                            }
                        });
                    }
                });

                hours.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        seats.setVisible(false);
                        setaside.setVisible(false);
                        gaptime.setVisible(false);
                        reminder.setVisible(false);
                        hours.setVisible(false);
                        closed.setVisible(false);

                        /* JLabel lbleditopen = new JLabel("Enter Open Time :");
                         lbleditopen.setBounds(10, 230, 56, 14);
                         frmAdministratorInterface.getContentPane().add(lbleditopen);
                         */
                        JButton enteropen = new JButton("Enter for Open Time");
                        enteropen.setBounds(20, 200, 60, 23);
                        frmAdministratorInterface.getContentPane().add(enteropen);
                        /*
                         JLabel lbleditclose = new JLabel("Enter Close Time :");
                         lbleditclose.setBounds(100, 230, 56, 14);
                         frmAdministratorInterface.getContentPane().add(lbleditclose);
                         */
                        JButton enterclose = new JButton("Enter for Close Time");
                        enterclose.setBounds(100, 200, 60, 23);
                        frmAdministratorInterface.getContentPane().add(enterclose);

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
                                Time opentime = new Time(openhour.getSelectedIndex() + 1, openminute.getSelectedIndex(), 0);
                                if (openampm.getSelectedItem().equals("PM")) {
                                    opentime.setHours(opentime.getHours() + 12);
                                }

                                if (openampm.getSelectedItem().equals("AM") && (openhour.getSelectedIndex() + 1) == 12) {
                                    opentime.setHours(opentime.getHours() - 12);
                                }

                                t.setOpens(opentime, term);

                                openlabel.setText("Open Time: " + t.getOpens());
                                /*
                                 */
                            }

                        });

                        enterclose.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                Time closetime = new Time(closehour.getSelectedIndex() + 1, closeminute.getSelectedIndex(), 0);
                                if (closeampm.getSelectedItem().equals("PM")) {
                                    closetime.setHours(closetime.getHours() + 12);
                                }

                                if (closeampm.getSelectedItem().equals("AM") && (closehour.getSelectedIndex() + 1) == 12) {
                                    closetime.setHours(closetime.getHours() - 12);
                                }

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
                                if (!(hourcomboBox.getSelectedItem().equals("0") && minutecomboBox.getSelectedItem().equals("0"))) {

                                    Time time = new Time(hourcomboBox.getSelectedIndex(), minutecomboBox.getSelectedIndex(), 0);

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

                        JLabel lbleditsetaside = new JLabel("Enter number of set-aside seats:");
                        lbleditsetaside.setBounds(10, 30, 56, 14);
                        frmAdministratorInterface.getContentPane().add(lbleditsetaside);

                        JButton entersetaside = new JButton("Enter");
                        entersetaside.setBounds(50, 107, 137, 23);
                        frmAdministratorInterface.getContentPane().add(entersetaside);

                        JTextField newsetaside = new JTextField();
                        newsetaside.setText(t.getSetasideseats() + "");
                        newsetaside.setBounds(100, 30, 126, 20);
                        frmAdministratorInterface.getContentPane().add(newsetaside);
                        newsetaside.setColumns(10);

                        JLabel seatslabel = new JLabel("Seats in testing center for " + term + ": " + t.getSetasideseats());
                        seatslabel.setBounds(200, 60, 300, 40);
                        frmAdministratorInterface.getContentPane().add(seatslabel);

                        entersetaside.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                int seatnum = Integer.parseInt(newsetaside.getText());

                                t.setSetasideseats(seatnum, term);
                            }
                        });

                    }
                });

                seats.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        seats.setVisible(false);
                        setaside.setVisible(false);

                        JLabel lbleditseats = new JLabel("Enter number of seats:");
                        lbleditseats.setBounds(10, 30, 56, 14);
                        frmAdministratorInterface.getContentPane().add(lbleditseats);

                        JButton enter = new JButton("Enter");
                        enter.setBounds(50, 107, 137, 23);
                        frmAdministratorInterface.getContentPane().add(enter);

                        JTextField newseats = new JTextField();
                        newseats.setText(t.getSeats() + "");
                        newseats.setBounds(100, 30, 126, 20);
                        frmAdministratorInterface.getContentPane().add(newseats);
                        newseats.setColumns(10);

                        JLabel seatslabel = new JLabel("Seats in testing center for " + term + ": " + t.getSeats());
                        seatslabel.setBounds(20, 150, 300, 40);
                        frmAdministratorInterface.getContentPane().add(seatslabel);

                        enter.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                int seatnum = Integer.parseInt(newseats.getText());
                                System.out.println(seatnum);

                                t.setSeats(seatnum, term);
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
                if(utilcalendar.getDate().getYear() < cal.getTime().getYear()
                        || utilcalendar.getDate().getYear() == cal.getTime().getYear() && utilcalendar.getDate().getMonth() < cal.getTime().getMonth()
                        || utilcalendar.getDate().getYear() == cal.getTime().getYear() && utilcalendar.getDate().getMonth() == cal.getTime().getMonth()
                        && utilcalendar.getDate().getDate() <= cal.getTime().getDate())
                {
                    TestingCenter t = new TestingCenter();
                    utilization.setText(t.pastutilization(utilcalendar.getDate()));
                }
                else
                {
                    TestingCenter t = new TestingCenter();
                    utilization.setText(t.futureutilization(utilcalendar.getDate()));
                }
            }
        });
    }

}
