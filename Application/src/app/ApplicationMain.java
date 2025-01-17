package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import com.toedter.calendar.JCalendar;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.FileInputStream;
import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;

public class ApplicationMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationMain frame = new ApplicationMain();
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
	public ApplicationMain() {
		setBackground(Color.DARK_GRAY);
		setTitle("Main Screen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 867, 505);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 203, 466);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Main Screen");
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(0, 11, 203, 46);
		panel.add(lblNewLabel);

		JButton btnDeleteEvent = new JButton("Event");
		btnDeleteEvent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new EventsScreen().setVisible(true);
				dispose();
			}
		});
		btnDeleteEvent.setForeground(Color.WHITE);
		btnDeleteEvent.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDeleteEvent.setBackground(Color.DARK_GRAY);
		btnDeleteEvent.setBounds(0, 68, 203, 46);
		panel.add(btnDeleteEvent);

		JButton btnChangeCr = new JButton("Change Credentials");
		btnChangeCr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new UserCridentials().setVisible(true);
				dispose();
			}
		});
		btnChangeCr.setForeground(Color.WHITE);
		btnChangeCr.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnChangeCr.setBackground(Color.DARK_GRAY);
		btnChangeCr.setBounds(0, 113, 203, 46);
		panel.add(btnChangeCr);

		JButton btnChangeCr_1_1 = new JButton("User Feedback");
		btnChangeCr_1_1.setForeground(Color.WHITE);
		btnChangeCr_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnChangeCr_1_1.setBackground(Color.DARK_GRAY);
		btnChangeCr_1_1.setBounds(0, 203, 203, 46);
		panel.add(btnChangeCr_1_1);

		JButton btnChangeCr_1_1_1 = new JButton("Help");
		btnChangeCr_1_1_1.setForeground(Color.WHITE);
		btnChangeCr_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnChangeCr_1_1_1.setBackground(Color.DARK_GRAY);
		btnChangeCr_1_1_1.setBounds(0, 248, 203, 46);
		panel.add(btnChangeCr_1_1_1);

		JButton btnChangeCr_1_2 = new JButton("User Profile");
		btnChangeCr_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new UserProfile().setVisible(true);
				dispose();
			}
		});
		btnChangeCr_1_2.setForeground(Color.WHITE);
		btnChangeCr_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnChangeCr_1_2.setBackground(Color.DARK_GRAY);
		btnChangeCr_1_2.setBounds(0, 158, 203, 46);
		panel.add(btnChangeCr_1_2);

		JButton btnLogout = new JButton("Logout");
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Database.u = null;
				new UserLogin().setVisible(true);
				dispose();
			}
		});
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLogout.setBackground(Color.DARK_GRAY);
		btnLogout.setBounds(676, 11, 110, 38);
		contentPane.add(btnLogout);

		// Calendar Panel
		JPanel calendarPanel = new JPanel();
		calendarPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		calendarPanel.setBackground(Color.LIGHT_GRAY);
		calendarPanel.setBounds(623, 202, 218, 174);
		contentPane.add(calendarPanel);

		JPanel calander = new JPanel();
		calander.setBounds(635, 213, 203, 163);
		contentPane.add(calander);

		// Clock Panel
		JPanel clockPanel = new JPanel();
		clockPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		clockPanel.setBackground(Color.WHITE);
		clockPanel.setBounds(623, 119, 218, 51);
		contentPane.add(clockPanel);

		JPanel events = new JPanel();
		events.setBounds(205, 83, 408, 326);
		contentPane.add(events);
		events.setLayout(new BorderLayout());

		// Clear the current user's event list before adding events to it
		Database.currentUsersEvent.clear();

		// Table columns
		String[] columns = { "ID", "Event", "Date", "Time", "Location", "Organizer" };

		for (int i = 0; i < Database.events.size(); i++) {
			if (Database.events.get(i).getUser().getEmail().equals(Database.u.getEmail())) {
				Database.currentUsersEvent.add(Database.events.get(i));
			}
		}

		// Sort the eventsList based on date and time
		Collections.sort(Database.currentUsersEvent, new Comparator<Events>() {
			@Override
			public int compare(Events e1, Events e2) {
				int dateComparison = e1.getDate().compareTo(e2.getDate());
				if (dateComparison != 0) {
					return dateComparison;
				} else {
					return e1.getTime().compareTo(e2.getTime());
				}
			}
		});

		// Determine the size of the ArrayList
		int numRows = Database.currentUsersEvent.size();
		int numCols = 6; // Assuming there are 6 columns for event details

		// Create a 2D array to store the data
		Object[][] data = new Object[numRows][numCols];

		// Populate the 2D array with data from the ArrayList
		for (int i = 0; i < numRows; i++) {
			Events event = Database.currentUsersEvent.get(i);
			data[i][0] = i + 1; // Assuming the first column is for serial numbers
			data[i][1] = event.getEventName();
			data[i][2] = event.getDate();
			data[i][3] = event.getTime();
			data[i][4] = event.getLocation();
			data[i][5] = event.getOrganizedBY();
		}

		// Create table model
		DefaultTableModel model = new DefaultTableModel(data, columns);

		// Create JTable with the model
		JTable table = new JTable(model);

		// Add the table to a scroll pane
		JScrollPane scrollPane = new JScrollPane(table);
		events.add(scrollPane, BorderLayout.CENTER);

		// For Calendar Panel
		JCalendar calendar = new JCalendar();
		calendarPanel.add(calendar);
		clockPanel.setLayout(null);

		// For Clock Panel
		JLabel clockLabel = new JLabel();
		clockLabel.setHorizontalAlignment(SwingConstants.CENTER);
		clockLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		clockPanel.add(clockLabel);

		// Update clock label every second
		Timer timer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateClock(clockLabel);
			}
		});
		timer.start();

		// Set the bounds for the clock label
		clockLabel.setBounds(0, 0, 218, 51);

		// Initial update of clock label
		updateClock(clockLabel);

		JLabel lblEvents = new JLabel("Timetable");
		lblEvents.setHorizontalAlignment(SwingConstants.CENTER);
		lblEvents.setForeground(Color.BLACK);
		lblEvents.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEvents.setBackground(Color.WHITE);
		lblEvents.setBounds(301, 38, 203, 38);
		contentPane.add(lblEvents);

		// Compare system date and time with events
//		checkAndRingAlarm(Database.currentUsersEvent);

		AlarmScheduler scheduler = new AlarmScheduler();
		scheduler.startScheduler();

	}

	public static void checkAndRingAlarm(List<Events> eventsList) {
		// Get current system date and time
		LocalDateTime currentDateTime = LocalDateTime.now();

		// Format current date and time to match event date and time format
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm a");
		String currentDateTimeStr = currentDateTime.format(formatter);

		System.out.println("\nCalling");
		// Check each event
		for (Events event : eventsList) {
//			System.out.println("Date " + event.getDate() + "  " + currentDateTimeStr.split(" ")[0]);
//			System.out.println("Time " + event.getAlarm().getDeadline() + "  " + currentDateTimeStr.split(" ")[1] + " "
//					+ currentDateTimeStr.split(" ")[2]);
			if (event.getDate().equals(currentDateTimeStr.split(" ")[0]) && event.getAlarm().getDeadline()
					.equals(currentDateTimeStr.split(" ")[1] + " " + currentDateTimeStr.split(" ")[2])) {
				// If date and time match, call ringAlarm function
				ringAlarm(Database.path + event.getAlarm().getRingtoneFilePath());
				break; // No need to check further events
			}
		}
	}

	public static void ringAlarm(String fileName) {
		MP3Player mp3Player = new MP3Player();
		System.out.println(fileName);
		mp3Player.play(fileName);
	}

	// Method to update clock label
	private void updateClock(JLabel clockLabel) {
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a"); // 'a' for AM/PM
		String time = sdf.format(new Date());
		clockLabel.setText(time);
	}
}
