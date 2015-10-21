import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JTextField;
//import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class InstructorCreateAnExam {

	private JFrame frameCreateAnExam;
	private JTextField textFieldExam;
	private JTextField textFieldStartTime;
	private JTextField textFieldEndTime;

	/**
	 * Launch the application.
	 */
	public static void InstructorCreateAnExam() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InstructorCreateAnExam window = new InstructorCreateAnExam();
					window.frameCreateAnExam.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InstructorCreateAnExam() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameCreateAnExam = new JFrame();
		frameCreateAnExam.setTitle("Create an Exam");
		frameCreateAnExam.setBounds(100, 100, 223, 271);
		frameCreateAnExam.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameCreateAnExam.getContentPane().setLayout(null);
		
		JLabel lblCreateAnExam = new JLabel("Create an Exam");
		lblCreateAnExam.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCreateAnExam.setBounds(33, 6, 150, 30);
		frameCreateAnExam.getContentPane().add(lblCreateAnExam);
		
		JLabel lblCourse = new JLabel("Course:");
		lblCourse.setBounds(20, 47, 46, 14);
		frameCreateAnExam.getContentPane().add(lblCourse);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {""}));
		comboBox.setBounds(89, 44, 94, 20);
		frameCreateAnExam.getContentPane().add(comboBox);
		
		JLabel lblExam = new JLabel("Exam:");
		lblExam.setBounds(20, 78, 46, 14);
		frameCreateAnExam.getContentPane().add(lblExam);
		
		textFieldExam = new JTextField();
		textFieldExam.setBounds(89, 75, 94, 20);
		frameCreateAnExam.getContentPane().add(textFieldExam);
		textFieldExam.setColumns(10);
		
		textFieldStartTime = new JTextField();
		textFieldStartTime.setText("");
		textFieldStartTime.setBounds(89, 106, 94, 20);
		frameCreateAnExam.getContentPane().add(textFieldStartTime);
		textFieldStartTime.setColumns(10);
		
		JLabel lblStartTime = new JLabel("Start Time:");
		lblStartTime.setBounds(20, 109, 53, 14);
		frameCreateAnExam.getContentPane().add(lblStartTime);
		
		textFieldEndTime = new JTextField();
		textFieldEndTime.setText("");
		textFieldEndTime.setBounds(89, 137, 94, 20);
		frameCreateAnExam.getContentPane().add(textFieldEndTime);
		textFieldEndTime.setColumns(10);
		
		JLabel lblEndTime = new JLabel("End Time:");
		lblEndTime.setBounds(20, 140, 53, 14);
		frameCreateAnExam.getContentPane().add(lblEndTime);
		
		//JDateChooser dateChooser = new JDateChooser();
		//dateChooser.setBounds(89, 168, 94, 20);
		//frameCreateAnExam.getContentPane().add(dateChooser);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(20, 165, 46, 23);
		frameCreateAnExam.getContentPane().add(lblDate);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(10, 203, 89, 23);
		frameCreateAnExam.getContentPane().add(btnCancel);
		
                btnCancel.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        frameCreateAnExam.setVisible(false);
                    }
                });
                
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(109, 203, 89, 23);
		frameCreateAnExam.getContentPane().add(btnConfirm);
                
                btnConfirm.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        frameCreateAnExam.setVisible(false);
                    }
                });
                frameCreateAnExam.setDefaultCloseOperation(2);
	}
}
