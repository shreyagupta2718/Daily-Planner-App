package model;

// A Block represents an activity with a title, length in time, and start time (if decided)
public class Block {
    private String title;      // name of block or activity
    private float length;      // length of block i.e. duration of activity in decimal hours
    private float startTime;   // start time represented in 24-hour format in decimal hours

    // REQUIRES: title has a non-zero length, length is in decimal hours
    // EFFECTS: Constructs a Block with given title and length in time
    // startTime is initialized to impossible 24-hour time value 24.00
    public Block(String title, float length) {
        this.title = title;
        this.length = length;
        startTime = 24.00F;
    }

    // REQUIRES: startTime is in decimal hours, 24-hr format
    // MODIFIES: this
    // EFFECTS: Assigns a time of the day to start the activity
    public void setStartTime(float startTime) {
        this.startTime = startTime;
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

    // EFFECTS: Overrides toString in class Object, returns the title of the object
    @Override
    public String toString() {
        return title;
    }
}
