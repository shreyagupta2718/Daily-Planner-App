package model;

import java.util.ArrayList;

// Represents a list of unscheduled Blocks
public class BrainDump {
    private ArrayList<Block> brainDump;

    // Constructs a new empty list of Blocks
    public BrainDump() {
        brainDump = new ArrayList<Block>();
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
        int index = brainDump.indexOf(block);
        brainDump.remove(index);
    }

    // REQUIRES: Block with given title is present in the brain dump
    // MODIFIES: this
    // EFFECTS: The block with given title is deleted from the brain dump
    public void deleteFromBrainDump(String title) {
        Block block= findBlockFromTitle(title);
        brainDump.remove(brainDump.indexOf(block));
    }

    // REQUIRES: title has a non-zero length
    // EFFECTS: The block with given title is returned if present, null is returned otherwise
    public Block findBlockFromTitle(String title) {
        boolean found= false;
        Block block=null;
        for(Block blockCandidate : brainDump) {
            if (blockCandidate.getTitle().equalsIgnoreCase(title)) {
                block=blockCandidate;
                break;
            }
        }
            return block;
        }

    public ArrayList<Block> getBrainDump() {
        return brainDump;
    }
}
