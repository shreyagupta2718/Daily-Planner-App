package model;

import org.json.JSONArray;

import java.util.ArrayList;

// Represents a list of scheduled Blocks
public class Schedule {
    private ArrayList<Block> schedule; // Daily schedule, a list of scheduled blocks

    // Constructs a new empty list of Blocks
    public Schedule() {
        schedule = new ArrayList<>();
    }

    // REQUIRES: A scheduled block i.e. start time of block is set
    // MODIFIES: this
    // EFFECTS: The given Block is added to the schedule
    public void addToSchedule(Block block) {
        schedule.add(block);
        EventLog.getInstance().logEvent(new Event(block.toString() + " added to the schedule."));
    }

    // REQUIRES: Block is present in the schedule
    // MODIFIES: this
    // EFFECTS: The given block is deleted from the schedule
    public void deleteFromSchedule(Block block) {
        schedule.remove(block);
        EventLog.getInstance().logEvent(new Event(block.toString() + " deleted from the schedule."));
    }

    public ArrayList<Block> getSchedule() {
        return schedule;
    }

    // EFFECTS: Overrides toString in class Object, returns the titles of the block objects in schedule along with the
    // start and end time of the block
    @Override
    public String toString() {
        String s = "";
        for (Block scheduledBlock : schedule) {
            s += scheduledBlock.toString() + "\n";
        }
        return s;
    }

    public JSONArray toJson() {
        JSONArray jsonArray = new JSONArray();

        for (Block b : schedule) {
            jsonArray.put(b.toJson());
        }

        return jsonArray;
    }
}
