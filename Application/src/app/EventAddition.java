package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class EventAddition extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameTxt;
	private JPasswordField passwordField;
	private JTextField collegeIDTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EventAddition frame = new EventAddition();
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
	public EventAddition() {
		setBackground(Color.DARK_GRAY);
		setTitle("User Registration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 812, 505);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 796, 75);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Create Account");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(0, 11, 796, 53);
		panel.add(lblNewLabel);
		
		JLabel username = new JLabel("Username:");
		username.setFont(new Font("Tahoma", Font.PLAIN, 16));
		username.setBackground(Color.WHITE);
		username.setBounds(259, 141, 96, 27);
		contentPane.add(username);
		
		usernameTxt = new JTextField();
		usernameTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		usernameTxt.setBackground(Color.WHITE);
		usernameTxt.setBounds(374, 141, 208, 27);
		contentPane.add(usernameTxt);
		usernameTxt.setColumns(10);
		
		JLabel lblCollegeId = new JLabel("College ID:");
		lblCollegeId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCollegeId.setBackground(Color.WHITE);
		lblCollegeId.setBounds(259, 195, 96, 27);
		contentPane.add(lblCollegeId);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(374, 252, 208, 27);
		contentPane.add(passwordField);
		
		JLabel passwordTxt = new JLabel("Password:");
		passwordTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordTxt.setBackground(Color.WHITE);
		passwordTxt.setBounds(259, 252, 96, 27);
		contentPane.add(passwordTxt);
		
		collegeIDTxt = new JTextField();
		collegeIDTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		collegeIDTxt.setColumns(10);
		collegeIDTxt.setBackground(Color.WHITE);
		collegeIDTxt.setBounds(374, 195, 208, 27);
		contentPane.add(collegeIDTxt);
		
		JLabel usernameERROR = new JLabel("");
		usernameERROR.setHorizontalAlignment(SwingConstants.CENTER);
		usernameERROR.setBounds(374, 170, 208, 14);
		contentPane.add(usernameERROR);
		
		JLabel colegeIdERROR = new JLabel("");
		colegeIdERROR.setHorizontalAlignment(SwingConstants.CENTER);
		colegeIdERROR.setBounds(374, 227, 208, 14);
		contentPane.add(colegeIdERROR);
		
		JLabel passwordERROR = new JLabel("");
		passwordERROR.setHorizontalAlignment(SwingConstants.CENTER);
		passwordERROR.setBounds(374, 282, 208, 14);
		contentPane.add(passwordERROR);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(437, 317, 110, 38);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBack.setBackground(Color.DARK_GRAY);
		btnBack.setBounds(303, 317, 110, 38);
		contentPane.add(btnBack);
	}
}
