package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;

public class UserCridentials extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField lnameTXT;
	private JPasswordField passwordField;
	private JTextField emailTXT;
	private JTextField fnameTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserCridentials frame = new UserCridentials();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserCridentials() {
		setResizable(false);
		setBackground(Color.DARK_GRAY);
		setTitle("User Credentials");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 867, 505);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 203, 466);
		contentPane.add(panel);

		JLabel lblNewLabel = new JLabel("User Credentials");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(0, 11, 203, 46);
		panel.add(lblNewLabel);

		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ApplicationMain().setVisible(true);
				dispose();
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBack.setBackground(Color.DARK_GRAY);
		btnBack.setBounds(0, 409, 203, 46);
		panel.add(btnBack);

		JButton btnDeleteEvent = new JButton("Event");
		btnDeleteEvent.setEnabled(false);
		btnDeleteEvent.setForeground(Color.WHITE);
		btnDeleteEvent.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDeleteEvent.setBackground(Color.DARK_GRAY);
		btnDeleteEvent.setBounds(0, 58, 203, 46);
		panel.add(btnDeleteEvent);

		JButton btnChangeCr = new JButton("Change Credentials");
		btnChangeCr.setForeground(Color.WHITE);
		btnChangeCr.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnChangeCr.setBackground(Color.DARK_GRAY);
		btnChangeCr.setBounds(0, 103, 203, 46);
		panel.add(btnChangeCr);

		JButton btnChangeCr_1_2 = new JButton("User Profile");
		btnChangeCr_1_2.setEnabled(false);
		btnChangeCr_1_2.setForeground(Color.WHITE);
		btnChangeCr_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnChangeCr_1_2.setBackground(Color.DARK_GRAY);
		btnChangeCr_1_2.setBounds(0, 148, 203, 46);
		panel.add(btnChangeCr_1_2);

		JButton btnChangeCr_1_1 = new JButton("User Feedback");
		btnChangeCr_1_1.setEnabled(false);
		btnChangeCr_1_1.setForeground(Color.WHITE);
		btnChangeCr_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnChangeCr_1_1.setBackground(Color.DARK_GRAY);
		btnChangeCr_1_1.setBounds(0, 193, 203, 46);
		panel.add(btnChangeCr_1_1);

		JButton btnChangeCr_1_1_1 = new JButton("Help");
		btnChangeCr_1_1_1.setEnabled(false);
		btnChangeCr_1_1_1.setForeground(Color.WHITE);
		btnChangeCr_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnChangeCr_1_1_1.setBackground(Color.DARK_GRAY);
		btnChangeCr_1_1_1.setBounds(0, 238, 203, 46);
		panel.add(btnChangeCr_1_1_1);

		JLabel lblEventPlan = new JLabel("Last Name:");
		lblEventPlan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEventPlan.setBackground(Color.WHITE);
		lblEventPlan.setBounds(359, 156, 96, 27);
		contentPane.add(lblEventPlan);

		lnameTXT = new JTextField(Database.u.getLastName());
		lnameTXT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lnameTXT.setColumns(10);
		lnameTXT.setBackground(Color.WHITE);
		lnameTXT.setBounds(474, 156, 208, 27);
		contentPane.add(lnameTXT);

		JLabel lnameerror = new JLabel("");
		lnameerror.setHorizontalAlignment(SwingConstants.CENTER);
		lnameerror.setBounds(474, 188, 208, 14);
		contentPane.add(lnameerror);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBackground(Color.WHITE);
		lblPassword.setBounds(359, 213, 96, 27);
		contentPane.add(lblPassword);

		JLabel passworderror = new JLabel("");
		passworderror.setHorizontalAlignment(SwingConstants.CENTER);
		passworderror.setBounds(474, 245, 208, 14);
		contentPane.add(passworderror);

		passwordField = new JPasswordField(Database.u.getPassword());
		passwordField.setBounds(474, 213, 208, 27);
		contentPane.add(passwordField);

		JLabel lblEventPlan_1 = new JLabel("Email:");
		lblEventPlan_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEventPlan_1.setBackground(Color.WHITE);
		lblEventPlan_1.setBounds(359, 270, 96, 27);
		contentPane.add(lblEventPlan_1);

		emailTXT = new JTextField(Database.u.getEmail());
		emailTXT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		emailTXT.setColumns(10);
		emailTXT.setBackground(Color.WHITE);
		emailTXT.setBounds(474, 270, 208, 27);
		contentPane.add(emailTXT);

		JLabel emailerror = new JLabel("");
		emailerror.setHorizontalAlignment(SwingConstants.CENTER);
		emailerror.setBounds(474, 302, 208, 14);
		contentPane.add(emailerror);

		JButton btnUpdateCredentials = new JButton("Update Credentials");
		btnUpdateCredentials.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				for(int i=0; i<Database.currentUsersEvent.size(); i++) 
				{
					if(Database.currentUsersEvent.get(i).getUser().equals(Database.u)) 
					{
						Database.currentUsersEvent.get(i).getUser().setEmail(emailTXT.getText());
						Database.currentUsersEvent.get(i).getUser().setFirstName(fnameTextField.getText());
						Database.currentUsersEvent.get(i).getUser().setPassword(passwordField.getText());
						Database.currentUsersEvent.get(i).getUser().setLastName(lnameTXT.getText());
					}
				}
				
				for(int i=0; i<Database.events.size(); i++) 
				{
					if(Database.events.get(i).getUser().equals(Database.u)) 
					{
						Database.events.get(i).getUser().setEmail(emailTXT.getText());
						Database.events.get(i).getUser().setFirstName(fnameTextField.getText());
						Database.events.get(i).getUser().setPassword(passwordField.getText());
						Database.events.get(i).getUser().setLastName(lnameTXT.getText());
					}
				}
				
				Database.u.setEmail(emailTXT.getText());
				Database.u.setFirstName(fnameTextField.getText());
				Database.u.setPassword(passwordField.getText());
				Database.u.setLastName(lnameTXT.getText());
  
				new ApplicationMain().setVisible(true);
				dispose();
			}
		});
		btnUpdateCredentials.setForeground(Color.WHITE);
		btnUpdateCredentials.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdateCredentials.setBackground(Color.DARK_GRAY);
		btnUpdateCredentials.setBounds(425, 347, 203, 46);
		contentPane.add(btnUpdateCredentials);

		JLabel fnameerror = new JLabel("");
		fnameerror.setHorizontalAlignment(SwingConstants.CENTER);
		fnameerror.setBounds(474, 131, 208, 14);
		contentPane.add(fnameerror);

		fnameTextField = new JTextField(Database.u.getFirstName());
		fnameTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fnameTextField.setColumns(10);
		fnameTextField.setBackground(Color.WHITE);
		fnameTextField.setBounds(474, 99, 208, 27);
		contentPane.add(fnameTextField);

		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFirstName.setBackground(Color.WHITE);
		lblFirstName.setBounds(359, 99, 96, 27);
		contentPane.add(lblFirstName);
	}
}
