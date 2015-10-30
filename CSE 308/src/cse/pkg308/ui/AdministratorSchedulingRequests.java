import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class AdministratorSchedulingRequests {

	private JFrame frameSchedulingRequets;

	/**
	 * Launch the application.
	 */
	public static void AdministratorSchedulingRequests() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministratorSchedulingRequests window = new AdministratorSchedulingRequests();
					window.frameSchedulingRequets.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdministratorSchedulingRequests() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameSchedulingRequets = new JFrame();
		frameSchedulingRequets.setTitle("Scheduling Requests");
		frameSchedulingRequets.setBounds(100, 100, 253, 233);
		frameSchedulingRequets.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameSchedulingRequets.getContentPane().setLayout(null);
		
		JLabel lblSchedulingRequests = new JLabel("Scheduling Requests");
		lblSchedulingRequests.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSchedulingRequests.setBounds(23, 11, 190, 31);
		frameSchedulingRequets.getContentPane().add(lblSchedulingRequests);
		
		JLabel lblSelectRequest = new JLabel("Select Request:");
		lblSelectRequest.setBounds(21, 55, 76, 14);
		frameSchedulingRequets.getContentPane().add(lblSelectRequest);
		
		JComboBox comboBoxSelectRequest = new JComboBox();
		comboBoxSelectRequest.setModel(new DefaultComboBoxModel(new String[] {""}));
		comboBoxSelectRequest.setBounds(107, 52, 122, 20);
		frameSchedulingRequets.getContentPane().add(comboBoxSelectRequest);
		
		JRadioButton rdbtnApprove = new JRadioButton("Approve");
		rdbtnApprove.setBounds(40, 121, 76, 23);
		frameSchedulingRequets.getContentPane().add(rdbtnApprove);
                
		JRadioButton rdbtnDeny = new JRadioButton("Deny");
		rdbtnDeny.setBounds(122, 121, 109, 23);
		frameSchedulingRequets.getContentPane().add(rdbtnDeny);
		
		//JLabel lblThisRequestIs = new JLabel("This request is able to be scheduled.");
		//lblThisRequestIs.setForeground(new Color(0, 128, 0));
		//lblThisRequestIs.setBounds(23, 100, 203, 14);
		//frameSchedulingRequets.getContentPane().add(lblThisRequestIs);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(27, 162, 89, 23);
		frameSchedulingRequets.getContentPane().add(btnCancel);
                
                btnCancel.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        frameSchedulingRequets.setVisible(false);
                    }
                });
                
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(124, 162, 89, 23);
		frameSchedulingRequets.getContentPane().add(btnConfirm);
		
                btnConfirm.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        frameSchedulingRequets.setVisible(false);
                    }
                });
                
                frameSchedulingRequets.setDefaultCloseOperation(2);
                
		//JLabel lblScheduledFor = new JLabel("9:00 AM to 11:00 AM on 1/1/2015");
		//lblScheduledFor.setBounds(43, 80, 206, 20);
		//frameSchedulingRequets.getContentPane().add(lblScheduledFor);
	}
}
