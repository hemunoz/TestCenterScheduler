package cse.pkg308.ui;

import java.awt.EventQueue;
import cse.pkg308.ui.StudentUI;
import cse.pkg308.ui.User;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Font;
import com.toedter.calendar.JCalendar;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Student extends User{

	private JFrame frmStudentInterface;
        
        private String major;
        private String status;
        private String netid;
        private String password;
        private int studentid;


	/**
	 * Create the application.
	 */
	public Student() {
                
                
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStudentInterface = Login.getLogin();
		
                frmStudentInterface.setTitle("Student Interface");
		frmStudentInterface.setBounds(100, 100, 377, 244);
		frmStudentInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStudentInterface.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblName.setBounds(21, 38, 46, 21);
		frmStudentInterface.getContentPane().add(lblName);
		
		JLabel lblNewLabel = new JLabel("Student");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(35, 11, 77, 21);
		frmStudentInterface.getContentPane().add(lblNewLabel);
		
		JLabel lblJohnSmith = new JLabel("John Smith");
		lblJohnSmith.setBounds(65, 41, 77, 14);
		frmStudentInterface.getContentPane().add(lblJohnSmith);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblId.setBounds(21, 57, 46, 14);
		frmStudentInterface.getContentPane().add(lblId);
		
		JLabel lblNewLabel_1 = new JLabel("123456789");
		lblNewLabel_1.setBounds(65, 57, 77, 14);
		frmStudentInterface.getContentPane().add(lblNewLabel_1);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(152, 11, 198, 153);
		frmStudentInterface.getContentPane().add(calendar);
		
		JButton btnTakeAnExam = new JButton("Take an Exam");
		btnTakeAnExam.setBounds(10, 82, 121, 23);
		frmStudentInterface.getContentPane().add(btnTakeAnExam);
		
		JButton btnCancelAnExam = new JButton("Cancel an Exam");
		btnCancelAnExam.setBounds(10, 116, 121, 23);
		frmStudentInterface.getContentPane().add(btnCancelAnExam);
		
		JButton btnSetAReminder = new JButton("Set a Reminder");
		btnSetAReminder.setBounds(10, 150, 121, 23);
		frmStudentInterface.getContentPane().add(btnSetAReminder);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(261, 175, 89, 23);
		frmStudentInterface.getContentPane().add(btnLogOut);
                
                btnLogOut.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        btnLogOut.setVisible(false);
                        
                        Login.lblPassword.setVisible(true);
                    }
                });
                
	}

    /**
     * @return the major
     */
    public String getMajor() {
        return major;
    }

    /**
     * @param major the major to set
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the netid
     */
    public String getNetid() {
        return netid;
    }

    /**
     * @param netid the netid to set
     */
    public void setNetid(String netid) {
        this.netid = netid;
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
     * @return the studentid
     */
    public int getStudentid() {
        return studentid;
    }

    /**
     * @param studentid the studentid to set
     */
    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }
}
