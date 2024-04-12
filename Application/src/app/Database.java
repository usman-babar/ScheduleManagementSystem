package app;

import java.util.ArrayList;

public class Database {

	public static User u = null;

	// cover only added users
	public static ArrayList<User> users = new ArrayList<User>();

	// cover only added events
	public static ArrayList<Events> events = new ArrayList<Events>();
	// cover only current user events
	public static ArrayList<Events> currentUsersEvent = new ArrayList<Events>();

	public static ArrayList<Alarm> alarms = new ArrayList<Alarm>();
	
	public static String path = "";
	
	public static String[] ringTinesArray = new String[] {"cartoonic_music_call_alert_tone_ringtone_galaxy_ringtones.mp3" ,"galaxy_ringtones.mp3"};
}
