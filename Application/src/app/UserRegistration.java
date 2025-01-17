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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserRegistration extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameTxt;
	private JPasswordField passwordField;
	private JTextField collegeIDTxt;
	private JTextField email;
	private JTextField fnameTXT;
	private JTextField lnameTXT;
	private JTextField ageTXT;

	JLabel emailError, fnameError, passwordERROR_1, ageError;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserRegistration frame = new UserRegistration();
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
	public UserRegistration() {
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
		username.setBounds(61, 138, 96, 27);
		contentPane.add(username);

		usernameTxt = new JTextField();
		usernameTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		usernameTxt.setBackground(Color.WHITE);
		usernameTxt.setBounds(176, 138, 208, 27);
		contentPane.add(usernameTxt);
		usernameTxt.setColumns(10);

		JLabel lblCollegeId = new JLabel("College ID:");
		lblCollegeId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCollegeId.setBackground(Color.WHITE);
		lblCollegeId.setBounds(61, 192, 96, 27);
		contentPane.add(lblCollegeId);

		passwordField = new JPasswordField();
		passwordField.setBounds(176, 249, 208, 27);
		contentPane.add(passwordField);

		JLabel passwordTxt = new JLabel("Password:");
		passwordTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordTxt.setBackground(Color.WHITE);
		passwordTxt.setBounds(61, 249, 96, 27);
		contentPane.add(passwordTxt);

		collegeIDTxt = new JTextField();
		collegeIDTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		collegeIDTxt.setColumns(10);
		collegeIDTxt.setBackground(Color.WHITE);
		collegeIDTxt.setBounds(176, 192, 208, 27);
		contentPane.add(collegeIDTxt);

		JLabel usernameERROR = new JLabel("");
		usernameERROR.setHorizontalAlignment(SwingConstants.CENTER);
		usernameERROR.setBounds(176, 167, 208, 14);
		contentPane.add(usernameERROR);

		JLabel colegeIdERROR = new JLabel("");
		colegeIdERROR.setHorizontalAlignment(SwingConstants.CENTER);
		colegeIdERROR.setBounds(176, 224, 208, 14);
		contentPane.add(colegeIdERROR);

		JLabel passwordERROR = new JLabel("");
		passwordERROR.setHorizontalAlignment(SwingConstants.CENTER);
		passwordERROR.setBounds(176, 279, 208, 14);
		contentPane.add(passwordERROR);

		JButton btnNewButton = new JButton("Create");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				boolean check = false;

				if (email.getText().isBlank()) {
					emailError.setText("Please fill this field.");
					emailError.setForeground(Color.RED);
				}
				if (passwordField.getText().isBlank()) {
					passwordERROR.setText("Please fill this field.");
					passwordERROR.setForeground(Color.RED);
				}
				if (usernameTxt.getText().isBlank()) {
					usernameERROR.setText("Please fill this field.");
					usernameERROR.setForeground(Color.RED);
				}
				if (collegeIDTxt.getText().isBlank()) {
					colegeIdERROR.setText("Please fill this field.");
					colegeIdERROR.setForeground(Color.RED);
				}
				if (fnameTXT.getText().isBlank()) {
					fnameError.setText("Please fill this field.");
					fnameError.setForeground(Color.RED);
				}
				if (lnameTXT.getText().isBlank()) {
					passwordERROR_1.setText("Please fill this field.");
					passwordERROR_1.setForeground(Color.RED);
				}
				if (ageTXT.getText().isBlank()) {
					ageError.setText("Please fill this field.");
					ageError.setForeground(Color.RED);
				} else {

					for (char c : ageTXT.getText().toCharArray()) {
						if (!Character.isDigit(c)) {
							ageError.setText("Must be numeric");
							ageError.setForeground(Color.RED);
							break;
						}
					}

					if (!(ageTXT.getText().isBlank() && lnameTXT.getText().isBlank() && collegeIDTxt.getText().isBlank()
							&& fnameTXT.getText().isBlank() && usernameTxt.getText().isBlank()
							&& passwordField.getText().isBlank() && email.getText().isBlank())) {

						User u = new User(usernameTxt.getText(), passwordField.getText(), fnameTXT.getText(),
								lnameTXT.getText(), Integer.parseInt(ageTXT.getText()), email.getText(),
								collegeIDTxt.getText());

						Database.users.add(u);
						new UserLogin().setVisible(true);
						dispose();
					}
				}
			}
		});
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(421, 363, 110, 38);
		contentPane.add(btnNewButton);

		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new UserLogin().setVisible(true);
				dispose();
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBack.setBackground(Color.DARK_GRAY);
		btnBack.setBounds(287, 363, 110, 38);
		contentPane.add(btnBack);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBackground(Color.WHITE);
		lblEmail.setBounds(406, 138, 96, 27);
		contentPane.add(lblEmail);

		email = new JTextField();
		email.setFont(new Font("Tahoma", Font.PLAIN, 16));
		email.setColumns(10);
		email.setBackground(Color.WHITE);
		email.setBounds(521, 138, 208, 27);
		contentPane.add(email);

		emailError = new JLabel("");
		emailError.setHorizontalAlignment(SwingConstants.CENTER);
		emailError.setBounds(521, 167, 208, 14);
		contentPane.add(emailError);

		fnameTXT = new JTextField();
		fnameTXT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fnameTXT.setColumns(10);
		fnameTXT.setBackground(Color.WHITE);
		fnameTXT.setBounds(521, 192, 208, 27);
		contentPane.add(fnameTXT);

		fnameError = new JLabel("");
		fnameError.setHorizontalAlignment(SwingConstants.CENTER);
		fnameError.setBounds(521, 224, 208, 14);
		contentPane.add(fnameError);

		passwordERROR_1 = new JLabel("");
		passwordERROR_1.setHorizontalAlignment(SwingConstants.CENTER);
		passwordERROR_1.setBounds(521, 279, 208, 14);
		contentPane.add(passwordERROR_1);

		JLabel lblLastname = new JLabel("LastName:");
		lblLastname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLastname.setBackground(Color.WHITE);
		lblLastname.setBounds(406, 249, 96, 27);
		contentPane.add(lblLastname);

		JLabel lblFirstname = new JLabel("FirstName:");
		lblFirstname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFirstname.setBackground(Color.WHITE);
		lblFirstname.setBounds(406, 192, 96, 27);
		contentPane.add(lblFirstname);

		lnameTXT = new JTextField();
		lnameTXT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lnameTXT.setColumns(10);
		lnameTXT.setBackground(Color.WHITE);
		lnameTXT.setBounds(521, 249, 208, 27);
		contentPane.add(lnameTXT);

		JLabel age = new JLabel("Age:");
		age.setFont(new Font("Tahoma", Font.PLAIN, 16));
		age.setBackground(Color.WHITE);
		age.setBounds(299, 304, 51, 27);
		contentPane.add(age);

		ageTXT = new JTextField();
		ageTXT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ageTXT.setColumns(10);
		ageTXT.setBackground(Color.WHITE);
		ageTXT.setBounds(360, 304, 208, 27);
		contentPane.add(ageTXT);

		ageError = new JLabel("");
		ageError.setHorizontalAlignment(SwingConstants.CENTER);
		ageError.setBounds(360, 334, 208, 14);
		contentPane.add(ageError);
	}
}
