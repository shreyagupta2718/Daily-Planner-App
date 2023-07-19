package ui;

// The following code is based on and taken from the TellerApp class in the TellerApp project:
// https://github.students.cs.ubc.ca/CPSC210/TellerApp/blob/main/src/main/ca/ubc/cpsc210/bank/ui/TellerApp.java

import model.Block;
import model.BrainDump;
import model.Schedule;

import java.util.Scanner;

// Daily Time-Blocking Planner Application
public class PlannerApp {
    private Block block;
    private BrainDump brainDump;
    private Schedule schedule;
    private Scanner input;

    // EFFECTS: runs the planner application
    public PlannerApp() {
        runPlanner();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runPlanner() {
        boolean keepGoing = true;
        int command = 0;

        brainDump = new BrainDump();
        schedule = new Schedule();
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
            default:
                System.out.println("Selection not valid...");
        }
    }

    // EFFECTS: delete a block from brain dump
    private void delete() {
        System.out.println("Enter the title of block you want to delete");
        String title = input.next();
        if(brainDump.findBlockFromTitle(title).equals(null))
            System.out.println("Title not found");
        else
        brainDump.deleteFromBrainDump(title);
    }

    // EFFECTS: move a block from schedule to brain dump
    private void move2() {
        System.out.println("Enter the index of block you want to move back to brain dump");
        int index = input.nextInt();
        if (index < schedule.getSchedule().size()) {
            block = schedule.getSchedule().get(index);
            block.setStartTime(24.00F);
            schedule.deleteFromSchedule(block);
            brainDump.addToBrainDump(block);
        } else {
            System.out.println("Invalid index");
        }
    }

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
        } else {
            System.out.println("Invalid index");
        }
    }

    // EFFECTS: displays the list of unscheduled blocks (brain-dump)
    private void view() {
        System.out.println("BrainDump: " + brainDump.getBrainDump());
        System.out.println("Schedule: " + schedule.getSchedule());
    }

    // EFFECTS: adds a block to brain dump
    private void add() {
        System.out.println("Enter title with non-zero length");
        String title = input.next();
        System.out.println("Enter length of block in decimal hours");
        Float length = input.nextFloat();
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
    }
}