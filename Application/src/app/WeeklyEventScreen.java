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
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class WeeklyEventScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WeeklyEventScreen frame = new WeeklyEventScreen();
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
	public WeeklyEventScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 864, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(Color.WHITE);
		contentPane_1.setBounds(0, 0, 851, 466);
		contentPane.add(contentPane_1);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 203, 466);
		contentPane_1.add(panel);

		JLabel lblNewLabel = new JLabel("Event Screen");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setBounds(0, 11, 203, 46);
		panel.add(lblNewLabel);

		JButton btnAddEvent = new JButton("Add Event");
		btnAddEvent.setEnabled(false);
		btnAddEvent.setForeground(Color.WHITE);
		btnAddEvent.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAddEvent.setBackground(Color.DARK_GRAY);
		btnAddEvent.setBounds(0, 55, 203, 46);
		panel.add(btnAddEvent);

		JButton btnEditEvent = new JButton("Edit Event");
		btnEditEvent.setEnabled(false);
		btnEditEvent.setForeground(Color.WHITE);
		btnEditEvent.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEditEvent.setBackground(Color.DARK_GRAY);
		btnEditEvent.setBounds(0, 98, 203, 46);
		panel.add(btnEditEvent);

		JButton btnDeleteEvent = new JButton("Delete Event");
		btnDeleteEvent.setEnabled(false);
		btnDeleteEvent.setForeground(Color.WHITE);
		btnDeleteEvent.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDeleteEvent.setBackground(Color.DARK_GRAY);
		btnDeleteEvent.setBounds(0, 141, 203, 46);
		panel.add(btnDeleteEvent);

		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new EventsScreen().setVisible(true);
				dispose();
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBack.setBackground(Color.DARK_GRAY);
		btnBack.setBounds(0, 409, 203, 46);
		panel.add(btnBack);

		JButton btnWeaklyPlans = new JButton("Weakly Plans");
		btnWeaklyPlans.setForeground(Color.WHITE);
		btnWeaklyPlans.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnWeaklyPlans.setBackground(Color.DARK_GRAY);
		btnWeaklyPlans.setBounds(0, 186, 203, 46);
		panel.add(btnWeaklyPlans);

		JButton btnDeleteEvent_1_1 = new JButton("Monthly Plans");
		btnDeleteEvent_1_1.setEnabled(false);
		btnDeleteEvent_1_1.setForeground(Color.WHITE);
		btnDeleteEvent_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDeleteEvent_1_1.setBackground(Color.DARK_GRAY);
		btnDeleteEvent_1_1.setBounds(0, 229, 203, 46);
		panel.add(btnDeleteEvent_1_1);

		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(227, 64, 600, 342);
		contentPane_1.add(scrollPane);

		JLabel lblYourWeeklyEventsplans = new JLabel("Your weekly Events/Plans");
		lblYourWeeklyEventsplans.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourWeeklyEventsplans.setForeground(Color.BLACK);
		lblYourWeeklyEventsplans.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblYourWeeklyEventsplans.setBackground(Color.WHITE);
		lblYourWeeklyEventsplans.setBounds(227, 11, 600, 46);
		contentPane_1.add(lblYourWeeklyEventsplans);

		String[] columns = { "ID", "Event", "Date", "Time", "Location", "Organizer" };

		for (int i = 0; i < Database.currentUsersEvent.size(); i++) {
			System.out.println(Database.currentUsersEvent.get(i).getDate());
		}

		// Get the week number of the current week
		TemporalField woy = WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear();
		int currentWeekNumber = LocalDate.now().get(woy);

		// Determine the size of the ArrayList
		int numCols = 6; // Assuming there are 6 columns for event details

		// Create a 2D array to store the data
		List<Object[]> weekEvents = new ArrayList<>();
		for (Events event : Database.currentUsersEvent) {
			// Extract the week number from the event's date

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			LocalDate date = LocalDate.parse(event.getDate(), formatter);

			// Get the week number using WeekFields
			WeekFields weekFields = WeekFields.ISO;
			int eventWeekNumber = date.get(weekFields.weekOfWeekBasedYear());
			// Check if the event's week number matches the current week number
			if (eventWeekNumber == currentWeekNumber) {
				Object[] rowData = new Object[numCols];
				rowData[0] = weekEvents.size() + 1; // Assuming the first column is for serial numbers
				rowData[1] = event.getEventName();
				rowData[2] = event.getDate();
				rowData[3] = event.getTime();
				rowData[4] = event.getLocation();
				rowData[5] = event.getOrganizedBY();
				weekEvents.add(rowData);
			}
		}

		// Create a 2D array from the filtered events
		Object[][] data = weekEvents.toArray(new Object[0][]);

		// Create table model
		DefaultTableModel model = new DefaultTableModel(data, columns);

		// Create JTable with the model
		JTable table = new JTable(model);

		scrollPane.setViewportView(table);
	}

}
