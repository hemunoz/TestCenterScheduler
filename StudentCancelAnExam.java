import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class StudentCancelAnExam {

	private JFrame frmCancelAnExam;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentCancelAnExam window = new StudentCancelAnExam();
					window.frmCancelAnExam.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StudentCancelAnExam() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCancelAnExam = new JFrame();
		frmCancelAnExam.setTitle("Cancel an Exam");
		frmCancelAnExam.setBounds(100, 100, 240, 185);
		frmCancelAnExam.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCancelAnExam.getContentPane().setLayout(null);
		
		JLabel lblCancelAnExam = new JLabel("Cancel an Exam");
		lblCancelAnExam.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCancelAnExam.setBounds(33, 11, 142, 25);
		frmCancelAnExam.getContentPane().add(lblCancelAnExam);
		
		JLabel lblCourse = new JLabel("Course:");
		lblCourse.setBounds(33, 47, 46, 14);
		frmCancelAnExam.getContentPane().add(lblCourse);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"CSE 308"}));
		comboBox.setBounds(104, 44, 81, 20);
		frmCancelAnExam.getContentPane().add(comboBox);
		
		JLabel lblExam = new JLabel("Exam:");
		lblExam.setBounds(33, 77, 46, 14);
		frmCancelAnExam.getContentPane().add(lblExam);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Midterm 1"}));
		comboBox_1.setBounds(104, 74, 81, 20);
		frmCancelAnExam.getContentPane().add(comboBox_1);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(15, 113, 89, 23);
		frmCancelAnExam.getContentPane().add(btnCancel);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(114, 113, 89, 23);
		frmCancelAnExam.getContentPane().add(btnConfirm);
	}

}
