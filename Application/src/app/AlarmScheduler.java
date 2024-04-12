package app;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class AlarmScheduler {
    private Timer timer;

    public AlarmScheduler() {
        this.timer = new Timer();
    }

    public void startScheduler() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                // Call your function here
                checkAndRingAlarm(Database.currentUsersEvent);
                System.out.println(1);
            }
        }, 0, 10 * 1000); // Run every 10 seconds (10 * 1000 milliseconds)
    }

    public void stopScheduler() {
        timer.cancel();
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
			System.out.println("Date " + event.getDate() + "  " + currentDateTimeStr.split(" ")[0]);
			System.out.println("Time " + event.getAlarm().getDeadline() + "  " + currentDateTimeStr.split(" ")[1] + " "
					+ currentDateTimeStr.split(" ")[2]);
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


}
