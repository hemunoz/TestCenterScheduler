package cse.pkg308.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class StudentTakeAnExam {

	private JFrame frmTakeAnExam;
	private JTextField txtPm;

	/**
	 * Launch the application.
	 */
	public void makeappointment() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentTakeAnExam window = new StudentTakeAnExam();
					window.frmTakeAnExam.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StudentTakeAnExam() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTakeAnExam = new JFrame();
		frmTakeAnExam.setTitle("Take an Exam");
		frmTakeAnExam.setBounds(100, 100, 236, 246);
		frmTakeAnExam.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTakeAnExam.getContentPane().setLayout(null);
		
		JLabel lblTakeAnExam = new JLabel("Take an Exam");
		lblTakeAnExam.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTakeAnExam.setBounds(44, 11, 140, 25);
		frmTakeAnExam.getContentPane().add(lblTakeAnExam);
		
		JLabel lblCourses = new JLabel("Courses:");
		lblCourses.setBounds(28, 50, 46, 14);
		frmTakeAnExam.getContentPane().add(lblCourses);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"CSE 308"}));
		comboBox.setBounds(111, 47, 94, 20);
		frmTakeAnExam.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Midterm 1"}));
		comboBox_1.setBounds(111, 75, 94, 20);
		frmTakeAnExam.getContentPane().add(comboBox_1);
		
		JLabel lblExam = new JLabel("Exam:");
		lblExam.setBounds(28, 78, 46, 14);
		frmTakeAnExam.getContentPane().add(lblExam);
		
		txtPm = new JTextField();
		txtPm.setText("12:00 PM");
		txtPm.setBounds(111, 106, 94, 20);
		frmTakeAnExam.getContentPane().add(txtPm);
		txtPm.setColumns(10);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setBounds(28, 109, 46, 14);
		frmTakeAnExam.getContentPane().add(lblTime);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(111, 137, 94, 20);
		frmTakeAnExam.getContentPane().add(dateChooser);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(28, 132, 46, 25);
		frmTakeAnExam.getContentPane().add(lblDate);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(17, 173, 89, 23);
		frmTakeAnExam.getContentPane().add(btnCancel);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(116, 173, 89, 23);
		frmTakeAnExam.getContentPane().add(btnSubmit);
	}
}
