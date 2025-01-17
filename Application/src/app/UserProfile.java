package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;


import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;

public class UserProfile extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField ringtone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserProfile frame = new UserProfile();
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
	public UserProfile() {
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
		btnChangeCr.setEnabled(false);
		btnChangeCr.setForeground(Color.WHITE);
		btnChangeCr.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnChangeCr.setBackground(Color.DARK_GRAY);
		btnChangeCr.setBounds(0, 103, 203, 46);
		panel.add(btnChangeCr);
		
		JButton btnChangeCr_1_2 = new JButton("User Profile");
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
		
		JLabel lblEventPlan_1 = new JLabel("Email:");
		lblEventPlan_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEventPlan_1.setBackground(Color.WHITE);
		lblEventPlan_1.setBounds(359, 270, 96, 27);
		contentPane.add(lblEventPlan_1);
		
		JLabel emailerror = new JLabel("");
		emailerror.setHorizontalAlignment(SwingConstants.CENTER);
		emailerror.setBounds(474, 302, 208, 14);
		contentPane.add(emailerror);
		
		JLabel fnameerror = new JLabel("");
		fnameerror.setHorizontalAlignment(SwingConstants.CENTER);
		fnameerror.setBounds(474, 131, 208, 14);
		contentPane.add(fnameerror);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFirstName.setBackground(Color.WHITE);
		lblFirstName.setBounds(359, 99, 96, 27);
		contentPane.add(lblFirstName);
		
		JLabel firstNameLabel = new JLabel(Database.u.getFirstName());
		firstNameLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		firstNameLabel.setBounds(474, 101, 208, 27);
		contentPane.add(firstNameLabel);
		
		JLabel lastNameLabel = new JLabel(Database.u.getLastName());
		lastNameLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lastNameLabel.setBounds(474, 156, 208, 27);
		contentPane.add(lastNameLabel);
		
		JLabel passwordLabel = new JLabel(Database.u.getPassword());
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		passwordLabel.setBounds(474, 213, 208, 27);
		contentPane.add(passwordLabel);
		
		JLabel emailLabel = new JLabel(Database.u.getEmail());
		emailLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		emailLabel.setBounds(474, 270, 208, 27);
		contentPane.add(emailLabel);
	}
}
