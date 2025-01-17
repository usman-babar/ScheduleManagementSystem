package app;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Alarm {
    private Timer timer;
    private String ringtoneFilePath;
    private String startTime;
    private String deadline;

    public Alarm(String ringtoneFilePath, String startTime, String deadline) {
        this.timer = new Timer();
        this.ringtoneFilePath = ringtoneFilePath;
        this.startTime = startTime;
        this.deadline = deadline;
    }

    public void setAlarm(Date date, TimerTask task) {
        timer.schedule(task, date);
    }

    public void setRepeatingAlarm(Date date, long interval, TimerTask task) {
        timer.scheduleAtFixedRate(task, date, interval);
    }

    public void cancelAlarm() {
        timer.cancel();
    }

    public String getRingtoneFilePath() {
        return ringtoneFilePath;
    }

    public void setRingtoneFilePath(String ringtoneFilePath) {
        this.ringtoneFilePath = ringtoneFilePath;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
}
