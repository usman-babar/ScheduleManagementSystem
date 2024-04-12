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
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DeleteEvent extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField ringtone;
	private JTextField textField;
	JLabel searchError;

	int index = -1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteEvent frame = new DeleteEvent();
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
	public DeleteEvent() {
		setResizable(false);
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

		searchError = new JLabel("");
		searchError = new JLabel("");
		searchError.setHorizontalAlignment(SwingConstants.CENTER);
		searchError.setBounds(472, 118, 208, 14);
		contentPane.add(searchError);

		JLabel lblNewLabel = new JLabel("Delete Event Screen");
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
		btnWeaklyPlans.setEnabled(false);
		btnWeaklyPlans.setBackground(Color.DARK_GRAY);
		btnWeaklyPlans.setBounds(0, 185, 203, 46);
		panel.add(btnWeaklyPlans);
		
		JButton btnDeleteEvent_1_1 = new JButton("Monthly Plans");
		btnDeleteEvent_1_1.setForeground(Color.WHITE);
		btnDeleteEvent_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDeleteEvent_1_1.setEnabled(false);
		btnDeleteEvent_1_1.setBackground(Color.DARK_GRAY);
		btnDeleteEvent_1_1.setBounds(0, 228, 203, 46);
		panel.add(btnDeleteEvent_1_1);

		JLabel lblYourEvents = new JLabel("Delete Events/Plans");
		lblYourEvents.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourEvents.setForeground(Color.BLACK);
		lblYourEvents.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblYourEvents.setBackground(Color.WHITE);
		lblYourEvents.setBounds(421, 38, 203, 28);
		contentPane.add(lblYourEvents);

		JButton btnAddEventToAdd = new JButton("Delete Event");
		btnAddEventToAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					// Remove the event from currentUsersEvent ArrayList
					Database.currentUsersEvent.remove(index);

					// Remove the event from Database.events ArrayList based on event name
					for (int j = 0; j < Database.events.size(); j++) {
						if (Database.events.get(j).getEventName().matches(textField.getText())) {
							Database.events.remove(j);
							break;
						}
					}

					// Open the EventsScreen
					new EventsScreen().setVisible(true);
					dispose();
				} catch (IndexOutOfBoundsException e1) {
					// Handle IndexOutOfBoundsException
					// This exception occurs if the index is out of bounds
					e1.printStackTrace(); // Or handle it according to your application's logic
				} catch (Exception e2) {
					// Handle any other exceptions that may occur
					e2.printStackTrace(); // Or handle it according to your application's logic
				}
			}
		});
		btnAddEventToAdd.setForeground(Color.WHITE);
		btnAddEventToAdd.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAddEventToAdd.setBackground(Color.DARK_GRAY);
		btnAddEventToAdd.setBounds(421, 325, 203, 46);
		contentPane.add(btnAddEventToAdd);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBackground(Color.WHITE);
		textField.setBounds(472, 86, 208, 27);
		contentPane.add(textField);

		JLabel lblSearchEvent = new JLabel("Search Event / Plan:");
		lblSearchEvent.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSearchEvent.setBackground(Color.WHITE);
		lblSearchEvent.setBounds(311, 86, 151, 27);
		contentPane.add(lblSearchEvent);

		JButton btnSearch = new JButton("Search");
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean check = false;

				if (textField.getText().isBlank()) {
					searchError.setForeground(Color.RED);
					searchError.setText("Kindly fill this.");
				} else {
					searchError.setForeground(Color.RED);
					searchError.setText(" ");

					try {
						for (int i = 0; i < Database.currentUsersEvent.size(); i++) {
							if (Database.currentUsersEvent.get(i).getEventName().matches(textField.getText())) {

								index = i;
								check = true;
								break;
							}
						}

						if (check == false) {
							searchError.setForeground(Color.RED);
							searchError.setText("Didn't exist.");
						}
					} catch (IndexOutOfBoundsException e1) {
						// Handle IndexOutOfBoundsException
						// This exception occurs if the index is out of bounds
						e1.printStackTrace(); // Or handle it according to your application's logic
						searchError.setForeground(Color.RED);
						searchError.setText("An error occurred while searching.");
					} catch (Exception e1) {
						// Handle any other exceptions that may occur
						e1.printStackTrace(); // Or handle it according to your application's logic
						searchError.setForeground(Color.RED);
						searchError.setText("An unexpected error occurred.");
					}
				}

			}
		});
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSearch.setBackground(Color.DARK_GRAY);
		btnSearch.setBounds(472, 143, 102, 28);
		contentPane.add(btnSearch);
	}
}
