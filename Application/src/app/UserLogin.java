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
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class UserLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField email;

	public static int count = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					if (count == 0) {
						dummyUsers();
						count++;
					}

					UserLogin frame = new UserLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void dummyUsers() {

		Database.path = "C:\\Users\\Usman Babar\\Desktop\\college schedule\\Application\\Ringtone\\";

		// Get the event time from the text field
		String eventTime = "11:59 PM";

		// Split the event time into two parts based on the space character
		String[] parts = eventTime.split(" ");

		// Extract the hour-minute part and meridian part
		String hourMinutePart = parts[0]; // "11:59"
		String meridianPart = parts[1]; // "PM"

		// Parse the event time to extract hours and minutes
		LocalTime parsedEventTime = LocalTime.parse(hourMinutePart);

		// Subtract one hour from the event time
		LocalTime alarmTime = parsedEventTime.minusHours(1);

		// Format the alarm time back to a string in HH:mm format
		String alarmTimeString = alarmTime.format(DateTimeFormatter.ofPattern("HH:mm"));

//		System.out.println(alarmTimeString + " " + meridianPart);

		// String username, String password, String firstName, String lastName, int age,
		// String email, String studentID
		User u1 = new User("usmanbabar", "1234", "Usman", "Babar", 23, "u", "Student-ID-123");
		User u2 = new User("babar", "12345", "Usman", "Babar", 23, "u", "Student-ID-124");

		// String eventName, String date, String time, String location, String
		// organizedBy, Alarm alarm, User user
		// String ringtoneFilePath, Date startTime, Date deadline
		Events e1 = new Events("Assignment 1", "19-04-2024", "11:59 PM", "Sir's office", "Sir xyz",
				new Alarm("cartoonic_music_call_alert_tone_ringtone_galaxy_ringtones.mp3", "8:00 PM", "11:59 PM"), u1);
		Events e2 = new Events("Assignment 2", "11-04-2024", "11:59 PM", "Sir's office", "Sir abc",
				new Alarm("galaxy_ringtones.mp3", "8:00 PM", "11:59 PM"), u2);

		Database.users.add(u1);
		Database.events.add(e1);
		Database.users.add(u2);
		Database.events.add(e2);
	}

	/**
	 * Create the frame.
	 */
	public UserLogin() {
		setBackground(Color.DARK_GRAY);
		setTitle("User Login");
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

		JLabel lblNewLabel = new JLabel("User Login");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 11, 776, 53);
		panel.add(lblNewLabel);

		JLabel lblCollegeId = new JLabel("Email ID:");
		lblCollegeId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCollegeId.setBackground(Color.WHITE);
		lblCollegeId.setBounds(259, 160, 96, 27);
		contentPane.add(lblCollegeId);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordField.setBounds(374, 226, 208, 27);
		contentPane.add(passwordField);

		JLabel passwordTxt = new JLabel("Password:");
		passwordTxt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordTxt.setBackground(Color.WHITE);
		passwordTxt.setBounds(259, 226, 96, 27);
		contentPane.add(passwordTxt);

		email = new JTextField();
		email.setFont(new Font("Tahoma", Font.PLAIN, 16));
		email.setColumns(10);
		email.setBackground(Color.WHITE);
		email.setBounds(374, 160, 208, 27);
		contentPane.add(email);

		JLabel colegeIdERROR = new JLabel("");
		colegeIdERROR.setHorizontalAlignment(SwingConstants.CENTER);
		colegeIdERROR.setBounds(374, 192, 208, 14);
		contentPane.add(colegeIdERROR);

		JLabel passwordERROR = new JLabel("");
		passwordERROR.setHorizontalAlignment(SwingConstants.CENTER);
		passwordERROR.setBounds(374, 256, 208, 14);
		contentPane.add(passwordERROR);

		JButton btnNewButton = new JButton("Sign In");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {

				boolean check = false;

				if (email.getText().isBlank()) {
					colegeIdERROR.setText("Please fill this field.");
					colegeIdERROR.setForeground(Color.RED);
				}
				if (passwordField.getText().isBlank()) {
					passwordERROR.setText("Please fill this field.");
					passwordERROR.setForeground(Color.RED);
				}

				if (!(email.getText().isBlank() && passwordField.getText().isBlank())) {

					for (int i = 0; i < Database.users.size(); i++) {
						if (Database.users.get(i).getEmail().equals(email.getText())
								&& Database.users.get(i).getPassword().equals(passwordField.getText())) {
							Database.u = Database.users.get(i);

//							System.out.println("Database.users.get(i).getEmail() " + Database.users.get(i).getEmail());
//							System.out.println("email.getText() " + email.getText());
							colegeIdERROR.setText("");
							passwordERROR.setText("");

							new ApplicationMain().setVisible(true);
							dispose();

							check = true;
							break;
						}
					}
				}
				if (check == false) {
					passwordERROR.setForeground(Color.RED);
					colegeIdERROR.setForeground(Color.RED);
					colegeIdERROR.setText("email or password didn't match.");
					passwordERROR.setText("email or password didn't match.");
					;
				}
			}
		});
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(351, 304, 110, 38);
		contentPane.add(btnNewButton);

		JButton btnBack = new JButton("Sign Up");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				new UserRegistration().setVisible(true);
				dispose();
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBack.setBackground(Color.DARK_GRAY);
		btnBack.setBounds(488, 304, 110, 38);
		contentPane.add(btnBack);

		JButton btnExit = new JButton("Exit");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnExit.setBackground(Color.DARK_GRAY);
		btnExit.setBounds(215, 304, 110, 38);
		contentPane.add(btnExit);
	}
}
