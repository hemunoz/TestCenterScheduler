package cse.pkg308.ui;

import cse.pkg308.ui.AdministratorUI;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JCalendar;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import cse.pkg308.ui.Login;
import javax.swing.JButton;

public class Administrator extends User{

	private JFrame frmAdministratorInterface;
	private JTextField textFieldOpenTime;
	private JTextField textFieldCloseTime;
	private JTextField textFieldID;
        
	/**
	 * Launch the application.
	 */
	public static void openadministrator() {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administrator window = new Administrator();
					window.frmAdministratorInterface.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
	}

	/**
	 * Create the application.
	 */
	public Administrator() {
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		/*frmAdministratorInterface = Login.getLogin();
		frmAdministratorInterface.setTitle("Administrator Interface");
		frmAdministratorInterface.setBounds(100, 100, 451, 441);
		frmAdministratorInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdministratorInterface.getContentPane().setLayout(null);
		
		JLabel lblAdministrator = new JLabel("Administrator");
		lblAdministrator.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAdministrator.setBounds(158, 11, 121, 19);
		frmAdministratorInterface.getContentPane().add(lblAdministrator);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblName.setBounds(10, 41, 46, 14);
		frmAdministratorInterface.getContentPane().add(lblName);
		
		JLabel lblName2 = new JLabel("");
		lblName2.setBounds(57, 41, 74, 14);
		frmAdministratorInterface.getContentPane().add(lblName2);
		
		JLabel lblNumberOfSeats = new JLabel("Number of Seats Available:");
		lblNumberOfSeats.setBounds(10, 77, 144, 14);
		frmAdministratorInterface.getContentPane().add(lblNumberOfSeats);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {""}));
		comboBox.setBounds(156, 74, 46, 20);
		frmAdministratorInterface.getContentPane().add(comboBox);
		
		JLabel lblNumberOfReserved = new JLabel("Number of Reserved Seats:");
		lblNumberOfReserved.setBounds(10, 102, 144, 14);
		frmAdministratorInterface.getContentPane().add(lblNumberOfReserved);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {""}));
		comboBox_1.setBounds(156, 99, 46, 20);
		frmAdministratorInterface.getContentPane().add(comboBox_1);
		
		//JCalendar calendar = new JCalendar();
		//calendar.setBounds(226, 41, 198, 153);
		//frmAdministratorInterface.getContentPane().add(calendar);
		
		JLabel lblSemester = new JLabel("Semester:");
		lblSemester.setBounds(10, 146, 56, 14);
		frmAdministratorInterface.getContentPane().add(lblSemester);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {""}));
		comboBox_2.setBounds(76, 143, 126, 20);
		frmAdministratorInterface.getContentPane().add(comboBox_2);
		
		JLabel lblOpenTime = new JLabel("Open Time:");
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
		
		JLabel lblCloseTime = new JLabel("Close Time:");
		lblCloseTime.setBounds(10, 200, 56, 14);
		frmAdministratorInterface.getContentPane().add(lblCloseTime);
		
		JLabel lblOpenDate = new JLabel("Open Date:");
		lblOpenDate.setBounds(10, 225, 56, 23);
		frmAdministratorInterface.getContentPane().add(lblOpenDate);
		
		//JDateChooser dateChooser = new JDateChooser();
		//dateChooser.setBounds(76, 228, 91, 20);
		//frmAdministratorInterface.getContentPane().add(dateChooser);
		
		//JDateChooser dateChooser_1 = new JDateChooser();
		//dateChooser_1.setBounds(75, 259, 91, 20);
		//frmAdministratorInterface.getContentPane().add(dateChooser_1);
		
		JLabel lblCloseDate = new JLabel("Close Date:");
		lblCloseDate.setBounds(10, 259, 56, 14);
		frmAdministratorInterface.getContentPane().add(lblCloseDate);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(335, 371, 89, 23);
		frmAdministratorInterface.getContentPane().add(btnLogOut);
		
                btnLogOut.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        login.getFrameLogin().setVisible(true);
                        frmAdministratorInterface.setVisible(false);
                    }
                });
                
		JButton btnImportData = new JButton("Import Data");
		btnImportData.setBounds(262, 205, 137, 23);
		frmAdministratorInterface.getContentPane().add(btnImportData);
		
		JButton btnApply = new JButton("Apply");
		btnApply.setBounds(57, 290, 89, 23);
		frmAdministratorInterface.getContentPane().add(btnApply);
		
		JButton btnSchedulingRequests = new JButton("Scheduling Requests");
		btnSchedulingRequests.setBounds(262, 239, 137, 23);
		frmAdministratorInterface.getContentPane().add(btnSchedulingRequests);
		
                btnSchedulingRequests.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        AdministratorSchedulingRequests administratorSchedulingRequests = new AdministratorSchedulingRequests();
                        administratorSchedulingRequests.AdministratorSchedulingRequests();
                    }
                });
                
		JButton btnMakeAnAppointment = new JButton("Make an Appointment");
		btnMakeAnAppointment.setBounds(262, 273, 137, 23);
		frmAdministratorInterface.getContentPane().add(btnMakeAnAppointment);
                
                btnMakeAnAppointment.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        AdministratorMakeAnAppointment administratorMakeAnAppointment = new AdministratorMakeAnAppointment();
                        administratorMakeAnAppointment.AdministratorMakeAnAppointment();
                    }
                });
                
		JButton btnCheckInStudent = new JButton("Check In Student");
		btnCheckInStudent.setBounds(41, 371, 137, 23);
		frmAdministratorInterface.getContentPane().add(btnCheckInStudent);
		
		JLabel lblStudentId = new JLabel("Student ID:");
		lblStudentId.setBounds(10, 346, 56, 14);
		frmAdministratorInterface.getContentPane().add(lblStudentId);
		
		textFieldID = new JTextField();
		textFieldID.setText("");
		textFieldID.setBounds(76, 340, 126, 20);
		frmAdministratorInterface.getContentPane().add(textFieldID);
		textFieldID.setColumns(10);
		
		JButton btnGenerateReport = new JButton("Generate Report");
		btnGenerateReport.setBounds(262, 305, 137, 23);
		frmAdministratorInterface.getContentPane().add(btnGenerateReport);*/
	}
}
