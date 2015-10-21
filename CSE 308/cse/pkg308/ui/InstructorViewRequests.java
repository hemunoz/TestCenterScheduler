import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class InstructorViewRequests {

	private JFrame frameViewRequests;

	/**
	 * Launch the application.
	 */
	public static void InstructorViewRequests() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InstructorViewRequests window = new InstructorViewRequests();
					window.frameViewRequests.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InstructorViewRequests() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameViewRequests = new JFrame();
		frameViewRequests.setTitle("Requests");
		frameViewRequests.setBounds(100, 100, 316, 266);
		frameViewRequests.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameViewRequests.getContentPane().setLayout(null);
		
		JLabel lblRequests = new JLabel("Requests");
		lblRequests.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRequests.setBounds(103, 11, 94, 33);
		frameViewRequests.getContentPane().add(lblRequests);
		
		JLabel lblPendingRequests = new JLabel("Pending Requests:");
		lblPendingRequests.setBounds(10, 48, 101, 14);
		frameViewRequests.getContentPane().add(lblPendingRequests);
		
		JTextPane textPanePendingRequests = new JTextPane();
		textPanePendingRequests.setText("");
		textPanePendingRequests.setBounds(10, 74, 130, 98);
		frameViewRequests.getContentPane().add(textPanePendingRequests);
		
		JLabel lblApprovedRequests = new JLabel("Approved Requests:");
		lblApprovedRequests.setBounds(163, 48, 120, 14);
		frameViewRequests.getContentPane().add(lblApprovedRequests);
		
		JTextPane textPaneApprovedRequests = new JTextPane();
		textPaneApprovedRequests.setText("");
		textPaneApprovedRequests.setBounds(163, 74, 130, 98);
		frameViewRequests.getContentPane().add(textPaneApprovedRequests);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(108, 194, 89, 23);
		frameViewRequests.getContentPane().add(btnClose);
                
                btnClose.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        frameViewRequests.setVisible(false);
                    }
                });
                
                frameViewRequests.setDefaultCloseOperation(2);
	}
}
