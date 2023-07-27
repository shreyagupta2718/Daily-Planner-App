package model;

import org.json.JSONArray;

import java.util.ArrayList;

// Represents a list of unscheduled Blocks
public class BrainDump {
    private ArrayList<Block> brainDump; // Brain dump of activities for the day, a list of unscheduled blocks

    // Constructs a new empty list of Blocks
    public BrainDump() {
        brainDump = new ArrayList<>();
    }

    // REQUIRES: title has a non-zero length, length is in decimal hours
    // MODIFIES: this
    // EFFECTS: A new Block is created and added to the brain dump
    public void addToBrainDump(String title, float length) {
        Block block = new Block(title, length);
        brainDump.add(block);
    }

    // REQUIRES: An unscheduled block i.e. start time of block is not set
    // MODIFIES: this
    // EFFECTS: The given Block is added to the brain dump
    public void addToBrainDump(Block block) {
        brainDump.add(block);
    }

    // REQUIRES: Block is present in the brain dump
    // MODIFIES: this
    // EFFECTS: The given block is deleted from the brain dump
    public void deleteFromBrainDump(Block block) {
        brainDump.remove(block);
    }

    // REQUIRES: Block with given title is present in the brain dump
    // MODIFIES: this
    // EFFECTS: The block with given title is deleted from the brain dump
    public void deleteFromBrainDump(String title) {
        Block block = findBlockFromTitle(title);
        brainDump.remove(block);
    }

    // REQUIRES: title has a non-zero length
    // EFFECTS: The block with given title is returned if present, null is returned otherwise
    public Block findBlockFromTitle(String title) {
        Block block = null;
        for (Block blockCandidate : brainDump) {
            if (blockCandidate.getTitle().equalsIgnoreCase(title)) {
                block = blockCandidate;
                break;
            }
        }
        return block;
    }

    public ArrayList<Block> getBrainDump() {
        return brainDump;
    }

    // EFFECTS: Overrides toString in class Object, returns the titles of the block objects in brain dump along with
    // their length
    @Override
    public String toString() {
        String s = "";
        for (Block b : brainDump) {
            s += b.toString() + "\n";
        }
        return s;
    }

    public JSONArray toJson() {
        JSONArray jsonArray = new JSONArray();

        for (Block b : brainDump) {
            jsonArray.put(b.toJson());
        }

        return jsonArray;
    }
}
