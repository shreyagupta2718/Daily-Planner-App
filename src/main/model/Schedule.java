package model;

import java.util.ArrayList;

// Represents a list of scheduled Blocks
public class Schedule {
    private ArrayList<Block> schedule;

    // Constructs a new empty list of Blocks
    public Schedule() {
        schedule = new ArrayList<Block>();
    }

    // REQUIRES: A scheduled block i.e. start time of block is set
    // MODIFIES: this
    // EFFECTS: The given Block is added to the brain dump
    public void addToSchedule(Block block) {
        schedule.add(block);
    }

    // REQUIRES: Block is present in the schedule
    // MODIFIES: this
    // EFFECTS: The given block is deleted from the schedule
    public void deleteFromSchedule(Block block) {
        int index = schedule.indexOf(block);
        schedule.remove(index);
    }

    public ArrayList<Block> getSchedule() {
        return schedule;
    }
}
