package ui;

// The following code is based on and taken from the TellerApp class in the TellerApp project:
// https://github.students.cs.ubc.ca/CPSC210/TellerApp/blob/main/src/main/ca/ubc/cpsc210/bank/ui/TellerApp.java

import model.Block;
import model.BrainDump;
import model.Schedule;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

// Daily Time-Blocking Planner Application
public class PlannerApp {
    private Block block;
    private BrainDump brainDump;
    private Schedule schedule;
    private Scanner input;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/Plan.json";

    // EFFECTS: constructs brain dump and schedule, and runs the planner application
    public PlannerApp() {
        brainDump = new BrainDump();
        schedule = new Schedule();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runPlanner();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runPlanner() {

        boolean keepGoing = true;
        int command;
        input = new Scanner(System.in);
        input.useDelimiter("\n");

        while (keepGoing) {
            displayMenu();
            command = input.nextInt();

            if (command == 0) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(int command) {
        switch (command) {
            case 1:
                add();
                break;
            case 2:
                view();
                break;
            case 3:
                move1();
                break;
            case 4:
                move2();
                break;
            case 5:
                delete();
                break;
            case 6:
                savePlan();
            case 7:
                loadPlan();
            default:
                System.out.println("Selection not valid...");
        }
    }

    // MODIFIES: this
    // EFFECTS: delete a block from brain dump
    private void delete() {
        System.out.println("Enter the title of block you want to delete");
        String title = input.next();
        if (brainDump.findBlockFromTitle(title) == null) {
            System.out.println("Title not found in brain dump!");
        } else {
            brainDump.deleteFromBrainDump(title);
            System.out.println("Deleted!");
        }
    }

    // MODIFIES: this
    // EFFECTS: move a block from schedule to brain dump
    private void move2() {
        System.out.println("Enter the index of block you want to move back to brain dump");
        int index = input.nextInt();
        if (index < schedule.getSchedule().size()) {
            block = schedule.getSchedule().get(index);
            block.setStartTime(24.00F);
            schedule.deleteFromSchedule(block);
            brainDump.addToBrainDump(block);
            System.out.print("Block moved");
        } else if (schedule.getSchedule().size() == 0) {
            System.out.println("First add a block to the schedule, it's empty!");
        } else {
            System.out.println("Invalid index");
        }
    }

    // MODIFIES: this
    // EFFECTS: moves a block from brain-dump to schedule
    private void move1() {
        System.out.println("Enter the index of block you want to set a start time for");
        int index = input.nextInt();
        if (index < brainDump.getBrainDump().size()) {
            System.out.println("Enter the start time");
            float time = input.nextFloat();
            block = brainDump.getBrainDump().get(index);
            block.setStartTime(time);
            schedule.addToSchedule(block);
            brainDump.deleteFromBrainDump(block);
            System.out.print("Block has been scheduled for " + time);

        } else if (brainDump.getBrainDump().size() == 0) {
            System.out.println("First add a block to brain dump, it's empty!");
        } else {
            System.out.println("Invalid index");
        }
    }

    // EFFECTS: displays the list of unscheduled blocks (brain-dump)
    private void view() {
        System.out.println("Here you go :)");
        System.out.println();
        System.out.println("BrainDump:");
        System.out.println(brainDump.toString());
        System.out.println("Schedule:");
        System.out.println(schedule.toString());
    }

    // MODIFIES: this
    // EFFECTS: adds a block to brain dump
    private void add() {
        System.out.println("Enter title of block (non-zero length)");
        String title = input.next();
        System.out.println("Enter length of block in decimal hours");
        float length = input.nextFloat();
        brainDump.addToBrainDump(title, length);
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\t0 -> quit");
        System.out.println("\t1 -> add a block to brain dump");
        System.out.println("\t2 -> view the list of blocks in brain-dump and schedule");
        System.out.println("\t3 -> move a block from brain-dump to schedule");
        System.out.println("\t4 -> move a block from schedule to brain dump");
        System.out.println("\t5 -> delete a block from brain dump");
        System.out.println("\t6 -> save plan");
        System.out.println("\t7 -> load plan");
    }

    // EFFECTS: saves the brain dump and schedule to file
    private void savePlan() {
        try {
            jsonWriter.open();
            jsonWriter.write(brainDump, schedule);
            jsonWriter.close();
            System.out.println("Saved plan to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads workroom from file
    private void loadWorkRoom() {
        try {
            brainDump = jsonReader.read("BrainDump");
            schedule = jsonReader.read("Schedule");
            System.out.println("Loaded plan from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }
}