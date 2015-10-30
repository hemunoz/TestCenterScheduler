package cse.pkg308.ui;

import cse.pkg308.ui.InstructorUI;
import cse.pkg308.ui.User;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Font;
import com.toedter.calendar.JCalendar;
import properties_manager.PropertiesManager;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Instructor extends User{

	private JFrame frameInstructorInterface;
        
        private String department;
        
	

	/**
	 * Create the application.
	 */
	public Instructor () {
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		/*frameInstructorInterface = new JFrame();
		frameInstructorInterface.setTitle("Instructor Interface");
		frameInstructorInterface.setBounds(100, 100, 356, 239);
		frameInstructorInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameInstructorInterface.getContentPane().setLayout(null);
		
		JLabel lblInstructor = new JLabel("Instructor");
		lblInstructor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInstructor.setBounds(23, 8, 96, 25);
		frameInstructorInterface.getContentPane().add(lblInstructor);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblName.setBounds(10, 44, 46, 14);
		frameInstructorInterface.getContentPane().add(lblName);
		
		JLabel lblName2 = new JLabel("");
		lblName2.setBounds(60, 44, 59, 14);
		frameInstructorInterface.getContentPane().add(lblName2);
		
		JButton btnCreateAnExam = new JButton("Create an Exam");
		btnCreateAnExam.setBounds(10, 84, 115, 23);
		frameInstructorInterface.getContentPane().add(btnCreateAnExam);
		
                btnCreateAnExam.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        InstructorCreateAnExam instructorCreateAnExam = new InstructorCreateAnExam();
                        instructorCreateAnExam.InstructorCreateAnExam();
                    }
                });
                
		JButton btnAppointedRequests = new JButton("View Requests");
		btnAppointedRequests.setBounds(10, 118, 115, 23);
		frameInstructorInterface.getContentPane().add(btnAppointedRequests);
		
                btnAppointedRequests.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        InstructorViewRequests instructorViewRequests = new InstructorViewRequests();
                        instructorViewRequests.InstructorViewRequests();
                    }
                });
                
		//JCalendar calendar = new JCalendar();
		//calendar.setBounds(135, 7, 198, 153);
		//frameInstructorInterface.getContentPane().add(calendar);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(241, 171, 89, 23);
		frameInstructorInterface.getContentPane().add(btnLogOut);
                
                btnLogOut.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        login.getFrameLogin().setVisible(true);
                        frameInstructorInterface.setVisible(false);
                    }
                });
                
                frameInstructorInterface.setDefaultCloseOperation(2*/
	}

    /**
     * @return the department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(String department) {
        this.department = department;
    }
}
