package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JCalendar;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class EditEvent extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField eventTXT;
	private JTextField eventTimeTXT;
	private JTextField eventDateTXT;
	private JTextField eventLocationTXT;
	private JTextField eventOrganizerTXT;
	private JTextField textField;

	String selectedRingtone;
	int index = -1;

	
	private JTextField hourField;
	private JTextField minuteField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditEvent frame = new EditEvent();
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
	public EditEvent() {
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

		JLabel lblNewLabel = new JLabel("Edit Event Screen");
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
		btnWeaklyPlans.setEnabled(false);
		btnWeaklyPlans.setBackground(Color.DARK_GRAY);
		btnWeaklyPlans.setBounds(0, 184, 203, 46);
		panel.add(btnWeaklyPlans);
		
		JButton btnDeleteEvent_1_1 = new JButton("Monthly Plans");
		btnDeleteEvent_1_1.setForeground(Color.WHITE);
		btnDeleteEvent_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDeleteEvent_1_1.setEnabled(false);
		btnDeleteEvent_1_1.setBackground(Color.DARK_GRAY);
		btnDeleteEvent_1_1.setBounds(0, 227, 203, 46);
		panel.add(btnDeleteEvent_1_1);

		JLabel lblYourEvents = new JLabel("Edit Events/Plans");
		lblYourEvents.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourEvents.setForeground(Color.BLACK);
		lblYourEvents.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblYourEvents.setBackground(Color.WHITE);
		lblYourEvents.setBounds(421, 11, 203, 28);
		contentPane.add(lblYourEvents);

		JLabel lblEventPlan = new JLabel("Event / Plan:");
		lblEventPlan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEventPlan.setBackground(Color.WHITE);
		lblEventPlan.setBounds(222, 117, 96, 27);
		contentPane.add(lblEventPlan);

		eventTXT = new JTextField();
		eventTXT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		eventTXT.setColumns(10);
		eventTXT.setBackground(Color.WHITE);
		eventTXT.setBounds(337, 117, 165, 27);
		contentPane.add(eventTXT);

		JLabel colegeIdERROR = new JLabel("");
		colegeIdERROR.setHorizontalAlignment(SwingConstants.CENTER);
		colegeIdERROR.setBounds(337, 149, 165, 14);
		contentPane.add(colegeIdERROR);

		eventTimeTXT = new JTextField();

		eventDateTXT = new JTextField();
//		eventDateTXT.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		eventDateTXT.setColumns(10);
//		eventDateTXT.setBackground(Color.WHITE);
//		eventDateTXT.setBounds(365, 200, 165, 27);
//		contentPane.add(eventDateTXT);

		eventLocationTXT = new JTextField();
		eventLocationTXT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		eventLocationTXT.setColumns(10);
		eventLocationTXT.setBackground(Color.WHITE);
		eventLocationTXT.setBounds(624, 117, 169, 27);
		contentPane.add(eventLocationTXT);

		JLabel colegeIdERROR_1_1 = new JLabel("");
		colegeIdERROR_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		colegeIdERROR_1_1.setBounds(624, 149, 169, 14);
		contentPane.add(colegeIdERROR_1_1);

		JLabel lblCollegeId_1_1 = new JLabel("Location:");
		lblCollegeId_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCollegeId_1_1.setBackground(Color.WHITE);
		lblCollegeId_1_1.setBounds(529, 117, 83, 27);
		contentPane.add(lblCollegeId_1_1);

		JLabel lblCollegeId_2_1 = new JLabel("Organizer:");
		lblCollegeId_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCollegeId_2_1.setBackground(Color.WHITE);
		lblCollegeId_2_1.setBounds(223, 174, 96, 27);
		contentPane.add(lblCollegeId_2_1);

		eventOrganizerTXT = new JTextField();
		eventOrganizerTXT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		eventOrganizerTXT.setColumns(10);
		eventOrganizerTXT.setBackground(Color.WHITE);
		eventOrganizerTXT.setBounds(338, 174, 208, 27);
		contentPane.add(eventOrganizerTXT);

		JLabel colegeIdERROR_2_1 = new JLabel("");
		colegeIdERROR_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		colegeIdERROR_2_1.setBounds(338, 206, 208, 14);
		contentPane.add(colegeIdERROR_2_1);

		JLabel lblCollegeId_1_1_1 = new JLabel("Rigntone:");
		lblCollegeId_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCollegeId_1_1_1.setBackground(Color.WHITE);
		lblCollegeId_1_1_1.setBounds(222, 229, 96, 27);
		contentPane.add(lblCollegeId_1_1_1);

		JButton btnAddEventToAdd = new JButton("Edit Event");
		btnAddEventToAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// Get the event time from the text field
				String eventTime = eventTimeTXT.getText();

				// Split the event time into two parts based on the space character
				String[] parts = eventTime.split(" ");

				// Extract the hour-minute part and meridian part
				String hourMinutePart = parts[0]; // "11:59"
				String meridianPart = parts[1];   // "PM"
				
				// Parse the event time to extract hours and minutes
				LocalTime parsedEventTime = LocalTime.parse(hourMinutePart);

				// Subtract one hour from the event time
				LocalTime alarmTime = parsedEventTime.minusHours(1);

				// Format the alarm time back to a string in HH:mm format
				String alarmTimeString = alarmTime.format(DateTimeFormatter.ofPattern("HH:mm"));
				
//				System.out.println(alarmTimeString+" "+meridianPart);

				String mergeTime = alarmTimeString+" "+meridianPart;
				
				Events ev = new Events(eventTXT.getText(), eventDateTXT.getText(), eventTimeTXT.getText(),
						eventLocationTXT.getText(), eventOrganizerTXT.getText(),
						new Alarm(selectedRingtone, mergeTime, eventTimeTXT.getText()), Database.u);

//				Database.events.set(index, ev);
				Database.currentUsersEvent.set(index, ev);
				
				for(int j=0; j<Database.events.size(); j++)
				{
					if(Database.events.get(j).getEventName().matches(ev.getEventName())) {
						Database.events.set(j, ev);
					}
				}


				new EventsScreen().setVisible(true);
				dispose();
			}
		});
		btnAddEventToAdd.setForeground(Color.WHITE);
		btnAddEventToAdd.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAddEventToAdd.setBackground(Color.DARK_GRAY);
		btnAddEventToAdd.setBounds(432, 409, 203, 46);
		contentPane.add(btnAddEventToAdd);

		JLabel searchError = new JLabel("");
		searchError.setHorizontalAlignment(SwingConstants.CENTER);
		searchError.setBounds(472, 82, 208, 14);
		contentPane.add(searchError);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBackground(Color.WHITE);
		textField.setBounds(472, 50, 208, 27);
		contentPane.add(textField);

		JLabel lblSearchEvent = new JLabel("Search Event / Plan:");
		lblSearchEvent.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSearchEvent.setBackground(Color.WHITE);
		lblSearchEvent.setBounds(311, 50, 151, 27);
		contentPane.add(lblSearchEvent);

		
		// Create a JComboBox and set font, size, and background color
		JComboBox<String> ringtoneComboBox = new JComboBox<>(Database.ringTinesArray);
//				JComboBox<String> ringtoneComboBox = new JComboBox<>();
				ringtoneComboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
				ringtoneComboBox.setBackground(Color.WHITE);


				Set<String> uniqueRingtones = new HashSet<>();

				// Iterate through the items in the JComboBox
				for (int i = 0; i < ringtoneComboBox.getItemCount(); i++) {
				    String ringtone = (String) ringtoneComboBox.getItemAt(i);
				    // Add each item to the Set if it's not already present
				    uniqueRingtones.add(ringtone);
				}

				// Clear the items from the JComboBox
				ringtoneComboBox.removeAllItems();

				// Add the unique items from the Set back to the JComboBox
				for (String ringtone : uniqueRingtones) {
				    ringtoneComboBox.addItem(ringtone);
				}
				
				
				// Populate the JComboBox with unique alarm names from the alarmArrayList
				for (Events alarm : Database.currentUsersEvent) {
				    String ringtone = alarm.getAlarm().getRingtoneFilePath();
				    if (!uniqueRingtones.contains(ringtone)) {
				        ringtoneComboBox.addItem(ringtone);
				        uniqueRingtones.add(ringtone);
				    }
				}

				// Add an action listener to capture the user's selection
				ringtoneComboBox.addActionListener(e -> {
				    // Get the selected item from the JComboBox
				    selectedRingtone = (String) ringtoneComboBox.getSelectedItem();
//				    System.out.println(selectedRingtone);
				});

				// Set the bounds for the JComboBox
				ringtoneComboBox.setBounds(337, 229, 208, 27);

				// Add the JComboBox to the content pane
				contentPane.add(ringtoneComboBox);

		JButton btnSearch = new JButton("Search");
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				boolean check = false;

				if (textField.getText().isBlank()) {
					searchError.setForeground(Color.RED);
					searchError.setText("Kindly fill this.");
					
					eventTXT.setText(" ");
					eventTimeTXT.setText(" ");
					eventDateTXT.setText(" ");
					eventLocationTXT.setText(" ");
					eventOrganizerTXT.setText("");
				} else {
					searchError.setForeground(Color.RED);
					searchError.setText(" ");
					for (int i = 0; i < Database.currentUsersEvent.size(); i++) {
						if (Database.currentUsersEvent.get(i).getEventName().matches(textField.getText())) {

							eventTXT.setText(Database.currentUsersEvent.get(i).getEventName());
							eventTimeTXT.setText(Database.currentUsersEvent.get(i).getTime());
							eventDateTXT.setText(Database.currentUsersEvent.get(i).getDate());
							eventLocationTXT.setText(Database.currentUsersEvent.get(i).getLocation());
							eventOrganizerTXT.setText(Database.currentUsersEvent.get(i).getOrganizedBY());
							index = i;
							check = true;
						}
					}

					if (check == false) {
						searchError.setForeground(Color.RED);
						searchError.setText("Didn't exist.");
					}
				}
			}
		});
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSearch.setBackground(Color.DARK_GRAY);
		btnSearch.setBounds(690, 50, 102, 28);
		contentPane.add(btnSearch);
		
		
//		
		JPanel calendarPanel = new JPanel();
		calendarPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		calendarPanel.setBackground(Color.LIGHT_GRAY);
		calendarPanel.setBounds(581, 213, 218, 174);
		contentPane.add(calendarPanel);
		calendarPanel.setLayout(null);

		JCalendar calendar = new JCalendar();
		calendar.setBounds(10, 6, 198, 153);
		calendarPanel.add(calendar);

		JPanel calander = new JPanel();
		calander.setBounds(0, 0, 203, 163);
		contentPane.add(calander);
		
		
		hourField = new JTextField();
		hourField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		hourField.setColumns(10);
		hourField.setBackground(Color.WHITE);
		hourField.setBounds(291, 298, 32, 27);
		contentPane.add(hourField);

		minuteField = new JTextField();
		minuteField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		minuteField.setColumns(10);
		minuteField.setBackground(Color.WHITE);
		minuteField.setBounds(346, 298, 32, 27);
		contentPane.add(minuteField);

		JLabel lblEventDate_1 = new JLabel(":");
		lblEventDate_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEventDate_1.setBackground(Color.WHITE);
		lblEventDate_1.setBounds(333, 298, 13, 27);
		contentPane.add(lblEventDate_1);

		JComboBox<String> amPmComboBox = new JComboBox<>(new String[] { "AM", "PM" });
		amPmComboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		amPmComboBox.setBackground(Color.WHITE);
		amPmComboBox.setBounds(409, 298, 53, 27);
		contentPane.add(amPmComboBox);

		// Add an ActionListener to the JCalendar
		calendar.getDayChooser().addPropertyChangeListener("day", new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				Date selectedDate = calendar.getDate();
				// Create a SimpleDateFormat object to format the date
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				// Format the selected date
				String formattedDate = sdf.format(selectedDate);
				// Print or use the formatted date
//				System.out.println("Selected Date: " + formattedDate);

				eventDateTXT.setText(formattedDate);

				eventDateTXT.setText(formattedDate);
			}
		});

		amPmComboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		amPmComboBox.setBackground(Color.WHITE);
		amPmComboBox.setBounds(393, 298, 53, 27);
		contentPane.add(amPmComboBox);

		JButton setTimeButton = new JButton("Set Time");
		setTimeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Get the selected time
				String selectedTime = hourField.getText() + ":" + minuteField.getText() + " "
						+ amPmComboBox.getSelectedItem();

				// Print or use the selected time
//				System.out.println("Selected Time: " + selectedTime);

				eventTimeTXT.setText(selectedTime);
			}
		});
		setTimeButton.setForeground(Color.WHITE);
		setTimeButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		setTimeButton.setBackground(Color.LIGHT_GRAY);
		setTimeButton.setBounds(291, 336, 171, 27);
		contentPane.add(setTimeButton);
		
		JLabel lblEventDate_1_1 = new JLabel("HH");
		lblEventDate_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblEventDate_1_1.setForeground(Color.GRAY);
		lblEventDate_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEventDate_1_1.setBackground(Color.WHITE);
		lblEventDate_1_1.setBounds(291, 274, 33, 20);
		contentPane.add(lblEventDate_1_1);
		
		JLabel lblEventDate_1_1_1 = new JLabel("MM");
		lblEventDate_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblEventDate_1_1_1.setForeground(Color.GRAY);
		lblEventDate_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEventDate_1_1_1.setBackground(Color.WHITE);
		lblEventDate_1_1_1.setBounds(347, 274, 33, 20);
		contentPane.add(lblEventDate_1_1_1);

	}
}
