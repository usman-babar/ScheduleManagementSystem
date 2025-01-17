package app;

public class Events {

	// Private fields to store event details
	private String eventName;
	private String date;
	private String time;
	private String location;
	private String organizedBY;
	private Alarm alarm;
	private User user;
	
	
	// Constructor
    public Events(String eventName, String date, String time, String location, String organizedBy, Alarm alarm, User user) {
        this.eventName = eventName;
        this.date = date;
        this.time = time;
        this.location = location;
        this.organizedBY = organizedBy;
        this.alarm = alarm;
        this.user = user;
    }

	// Getter methods to retrieve event details
	public String getEventName() {
		return eventName;
	}

	public String getDate() {
		return date;
	}

	public String getTime() {
		return time;
	}

	public String getLocation() {
		return location;
	}

	// Setter methods to update event details
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getOrganizedBY() {
		return organizedBY;
	}

	public void setOrganizedBY(String organizedBY) {
		this.organizedBY = organizedBY;
	}

	public Alarm getAlarm() {
		return alarm;
	}

	public void setAlarm(Alarm alarm) {
		this.alarm = alarm;
	}
	
	public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
