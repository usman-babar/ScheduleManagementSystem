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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EventsScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EventsScreen frame = new EventsScreen();
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
	public EventsScreen() {
		setBackground(Color.DARK_GRAY);
		setTitle("Events");
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

		JLabel lblNewLabel = new JLabel("Event Screen");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setBounds(0, 11, 203, 46);
		panel.add(lblNewLabel);

		JButton btnAddEvent = new JButton("Add Event");
		btnAddEvent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new AddEvent().setVisible(true);
				dispose();
			}
		});
		btnAddEvent.setForeground(Color.WHITE);
		btnAddEvent.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAddEvent.setBackground(Color.DARK_GRAY);
		btnAddEvent.setBounds(0, 55, 203, 46);
		panel.add(btnAddEvent);

		JButton btnEditEvent = new JButton("Edit Event");
		btnEditEvent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new EditEvent().setVisible(true);
				dispose();
			}
		});
		btnEditEvent.setForeground(Color.WHITE);
		btnEditEvent.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEditEvent.setBackground(Color.DARK_GRAY);
		btnEditEvent.setBounds(0, 98, 203, 46);
		panel.add(btnEditEvent);

		JButton btnDeleteEvent = new JButton("Delete Event");
		btnDeleteEvent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new DeleteEvent().setVisible(true);
				dispose();
			}
		});
		btnDeleteEvent.setForeground(Color.WHITE);
		btnDeleteEvent.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDeleteEvent.setBackground(Color.DARK_GRAY);
		btnDeleteEvent.setBounds(0, 141, 203, 46);
		panel.add(btnDeleteEvent);

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

		JButton btnWeaklyPlans = new JButton("Weakly Plans");
		btnWeaklyPlans.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new WeeklyEventScreen().setVisible(true);
				dispose();
			}
		});
		btnWeaklyPlans.setForeground(Color.WHITE);
		btnWeaklyPlans.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnWeaklyPlans.setBackground(Color.DARK_GRAY);
		btnWeaklyPlans.setBounds(0, 186, 203, 46);
		panel.add(btnWeaklyPlans);

		JButton btnDeleteEvent_1_1 = new JButton("Monthly Plans");
		btnDeleteEvent_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new MonthlyEventScreen().setVisible(true);
				dispose();
			}
		});
		btnDeleteEvent_1_1.setForeground(Color.WHITE);
		btnDeleteEvent_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDeleteEvent_1_1.setBackground(Color.DARK_GRAY);
		btnDeleteEvent_1_1.setBounds(0, 229, 203, 46);
		panel.add(btnDeleteEvent_1_1);

		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(227, 64, 600, 342);
		contentPane.add(scrollPane);

		JLabel lblYourEvents = new JLabel("Your Events/Plans");
		lblYourEvents.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourEvents.setForeground(Color.BLACK);
		lblYourEvents.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblYourEvents.setBackground(Color.WHITE);
		lblYourEvents.setBounds(421, 11, 203, 46);
		contentPane.add(lblYourEvents);

		String[] columns = { "ID", "Event", "Date", "Time", "Location", "Organizer" };

		for (int i = 0; i < Database.currentUsersEvent.size(); i++) {
			System.out.println(Database.currentUsersEvent.get(i).getDate());
		}

		// Determine the size of the ArrayList
		int numCols = 6; // Assuming there are 6 columns for event details

		// Create a 2D array to store the data
		Object[][] data = new Object[Database.currentUsersEvent.size()][numCols];

		// Populate the 2D array with data from the ArrayList
		for (int i = 0; i < Database.currentUsersEvent.size(); i++) {
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

		scrollPane.setViewportView(table);
	}
}
