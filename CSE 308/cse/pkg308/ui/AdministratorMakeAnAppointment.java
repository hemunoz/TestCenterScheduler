import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
//import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;

public class AdministratorMakeAnAppointment{

	private JFrame frameMakeAnAppointment;
	private JTextField textFieldID;
	private JTextField textFieldStartTime;
	private JTextField textFieldEndTime;

	/**
	 * Launch the application.
	 */
	public static void AdministratorMakeAnAppointment() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministratorMakeAnAppointment window = new AdministratorMakeAnAppointment();
					window.frameMakeAnAppointment.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdministratorMakeAnAppointment() {
		initialize();
                //this.showAndWait();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameMakeAnAppointment = new JFrame();
		frameMakeAnAppointment.setTitle("Make an Appointment");
		frameMakeAnAppointment.setBounds(100, 100, 274, 402);
		frameMakeAnAppointment.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMakeAnAppointment.getContentPane().setLayout(null);
		
		JLabel lblMakeAnAppointment = new JLabel("Make an Appointment");
		lblMakeAnAppointment.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMakeAnAppointment.setBounds(23, 11, 225, 25);
		frameMakeAnAppointment.getContentPane().add(lblMakeAnAppointment);
		
		JLabel lblStudentId = new JLabel("Student ID:");
		lblStudentId.setBounds(20, 46, 69, 14);
		frameMakeAnAppointment.getContentPane().add(lblStudentId);
		
		textFieldID = new JTextField();
		textFieldID.setText("");
		textFieldID.setBounds(99, 43, 128, 20);
		frameMakeAnAppointment.getContentPane().add(textFieldID);
		textFieldID.setColumns(10);
		
		JLabel lblStudentName = new JLabel("Student Name:");
		lblStudentName.setBounds(21, 71, 81, 14);
		frameMakeAnAppointment.getContentPane().add(lblStudentName);
		
		JLabel lblStudentName2 = new JLabel("");
		lblStudentName2.setBounds(98, 71, 81, 14);
		frameMakeAnAppointment.getContentPane().add(lblStudentName2);
		
		JLabel lblClass = new JLabel("Class:");
		lblClass.setBounds(21, 103, 46, 14);
		frameMakeAnAppointment.getContentPane().add(lblClass);
		
		JComboBox comboBoxClass = new JComboBox();
		comboBoxClass.setModel(new DefaultComboBoxModel(new String[] {""}));
		comboBoxClass.setBounds(99, 100, 129, 20);
		frameMakeAnAppointment.getContentPane().add(comboBoxClass);
		
		JLabel lblExam = new JLabel("Exam:");
		lblExam.setBounds(21, 134, 46, 14);
		frameMakeAnAppointment.getContentPane().add(lblExam);
		
		JComboBox comboBoxExam = new JComboBox();
		comboBoxExam.setModel(new DefaultComboBoxModel(new String[] {""}));
		comboBoxExam.setBounds(99, 131, 129, 20);
		frameMakeAnAppointment.getContentPane().add(comboBoxExam);
		
		textFieldStartTime = new JTextField();
                textFieldStartTime.setText("");
		textFieldStartTime.setBounds(99, 162, 86, 20);
		frameMakeAnAppointment.getContentPane().add(textFieldStartTime);
		textFieldStartTime.setColumns(10);
		
		JLabel lblTime = new JLabel("Start Time:");
		lblTime.setBounds(21, 165, 68, 14);
		frameMakeAnAppointment.getContentPane().add(lblTime);
		
		textFieldEndTime = new JTextField();
		textFieldEndTime.setText("");
		textFieldEndTime.setBounds(99, 191, 86, 20);
		frameMakeAnAppointment.getContentPane().add(textFieldEndTime);
		textFieldEndTime.setColumns(10);
		
		JLabel lblEndTime = new JLabel("End Time:");
		lblEndTime.setBounds(21, 194, 68, 14);
		frameMakeAnAppointment.getContentPane().add(lblEndTime);
		
		//JDateChooser dateChooser = new JDateChooser();
		//dateChooser.setBounds(99, 222, 91, 20);
		//frameMakeAnAppointment.getContentPane().add(dateChooser);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(21, 219, 46, 23);
		frameMakeAnAppointment.getContentPane().add(lblDate);
		
                JLabel lblSeatNumber = new JLabel("Seat Number:");
		lblSeatNumber.setBounds(23, 261, 79, 14);
		frameMakeAnAppointment.getContentPane().add(lblSeatNumber);
                
		JComboBox comboBoxSeatNumber = new JComboBox();
		comboBoxSeatNumber.setModel(new DefaultComboBoxModel(new String[] {""}));
		comboBoxSeatNumber.setBounds(99, 258, 68, 20);
		frameMakeAnAppointment.getContentPane().add(comboBoxSeatNumber);
		
		JLabel lblTypeOfSeat = new JLabel("Type of Seat:");
		lblTypeOfSeat.setBounds(21, 292, 68, 14);
		frameMakeAnAppointment.getContentPane().add(lblTypeOfSeat);
		
		JComboBox TypeOfSeat = new JComboBox();
		TypeOfSeat.setModel(new DefaultComboBoxModel(new String[] {""}));
		TypeOfSeat.setBounds(99, 289, 129, 20);
		frameMakeAnAppointment.getContentPane().add(TypeOfSeat);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(21, 330, 89, 23);
		frameMakeAnAppointment.getContentPane().add(btnCancel);
		
                btnCancel.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        frameMakeAnAppointment.setVisible(false);
                    }
                });
                
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(139, 330, 89, 23);
		frameMakeAnAppointment.getContentPane().add(btnConfirm);
                
                btnConfirm.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        frameMakeAnAppointment.setVisible(false);
                    }
                });
                
                frameMakeAnAppointment.setDefaultCloseOperation(2);
	}
}
