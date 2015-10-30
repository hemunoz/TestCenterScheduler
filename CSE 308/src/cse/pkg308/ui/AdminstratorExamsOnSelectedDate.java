import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
//import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AdminstratorExamsOnSelectedDate {

	private JFrame frameScheduledExams;
	private JTextField textFieldStartTime;
	private JTextField textFieldEndTime;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminstratorExamsOnSelectedDate window = new AdminstratorExamsOnSelectedDate();
					window.frameScheduledExams.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminstratorExamsOnSelectedDate() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameScheduledExams = new JFrame();
		frameScheduledExams.setTitle("Scheduled Exams");
		frameScheduledExams.setBounds(100, 100, 337, 246);
		frameScheduledExams.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameScheduledExams.getContentPane().setLayout(null);
		
		JLabel lblExamsScheduledFor = new JLabel("Exams Scheduled For:");
		lblExamsScheduledFor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblExamsScheduledFor.setBounds(10, 11, 202, 25);
		frameScheduledExams.getContentPane().add(lblExamsScheduledFor);
		
		//JDateChooser dateChooser = new JDateChooser();
		//dateChooser.setBounds(218, 11, 91, 25);
		//frameScheduledExams.getContentPane().add(dateChooser);
		
		JLabel lblExams = new JLabel("Exams:");
		lblExams.setBounds(44, 50, 46, 14);
		frameScheduledExams.getContentPane().add(lblExams);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {""}));
		comboBox.setBounds(110, 47, 138, 20);
		frameScheduledExams.getContentPane().add(comboBox);
		
		textFieldStartTime = new JTextField();
		textFieldStartTime.setText("");
		textFieldStartTime.setBounds(110, 78, 138, 20);
		frameScheduledExams.getContentPane().add(textFieldStartTime);
		textFieldStartTime.setColumns(10);
		
		JLabel lblStartTime = new JLabel("Start Time:");
		lblStartTime.setBounds(44, 81, 56, 14);
		frameScheduledExams.getContentPane().add(lblStartTime);
		
		textFieldEndTime = new JTextField();
		textFieldEndTime.setText("");
		textFieldEndTime.setBounds(110, 109, 138, 20);
		frameScheduledExams.getContentPane().add(textFieldEndTime);
		textFieldEndTime.setColumns(10);
		
		JLabel lblEndTime = new JLabel("End Time:");
		lblEndTime.setBounds(44, 112, 56, 14);
		frameScheduledExams.getContentPane().add(lblEndTime);
		
		//JDateChooser dateChooser_1 = new JDateChooser();
		//dateChooser_1.setBounds(110, 140, 138, 20);
		//frameScheduledExams.getContentPane().add(dateChooser_1);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(44, 137, 46, 23);
		frameScheduledExams.getContentPane().add(lblDate);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(10, 171, 89, 23);
		frameScheduledExams.getContentPane().add(btnCancel);
		
		JButton btnDeleteExam = new JButton("Delete Exam");
		btnDeleteExam.setBounds(110, 171, 102, 23);
		frameScheduledExams.getContentPane().add(btnDeleteExam);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(218, 171, 89, 23);
		frameScheduledExams.getContentPane().add(btnConfirm);
	}
}
