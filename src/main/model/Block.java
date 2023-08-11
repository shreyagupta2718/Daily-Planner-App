package model;

import org.json.JSONObject;

import java.text.DecimalFormat;

// A Block represents an activity with a title, length in time, and start time (if decided)
public class Block {
    private String title;      // name of block or activity
    private float length;      // length of block i.e. duration of activity in decimal hours
    private float startTime;   // start time represented in 24-hour format in decimal hours

    // REQUIRES: title has a non-zero length, length is in decimal hours
    // EFFECTS: Constructs a Block with given title and length in time
    // startTime is initialized to illegal time value 24.00
    public Block(String title, float length) {
        this.title = title;
        this.length = length;
        startTime = 24.00F;
    }

    // REQUIRES: startTime is in decimal hours, 24-hr format
    // MODIFIES: this
    // EFFECTS: Assigns a time of the day to start the activity
    public void setStartTime(float startTime) {
        String temp = toString();
        this.startTime = startTime;
        EventLog.getInstance().logEvent(new Event(temp + " was assigned the start time " + startTime));
    }

    // EFFECTS: returns true if a start time has been assigned to the activity, false otherwise
    public boolean isScheduled() {
        return (this.startTime != 24.00);
    }

    public float getLength() {
        return length;
    }

    public String getTitle() {
        return title;
    }

    public Float getStartTime() {
        return startTime;
    }

    // EFFECTS: Overrides toString in class Object, returns the string representation of block
    @Override
    public String toString() {
        String blockAsString;
        DecimalFormat df = new DecimalFormat();
        df.setMinimumFractionDigits(2);
        float endTime = startTime + length;
        if (isScheduled()) {
            blockAsString = title + " from " + df.format(startTime) + " to " + df.format(endTime);
        } else {
            blockAsString = title + " of length " + df.format(length);
        }
        return blockAsString;
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("title", title);
        json.put("length", length);
        json.put("start time", startTime);
        return json;
    }
}
