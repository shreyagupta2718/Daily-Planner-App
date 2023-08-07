package ui;

import model.Block;
import model.BrainDump;
import model.Schedule;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

// Represents main window frame of the Daily Time-Blocking Planner Application
public class DailyPlannerApp extends JFrame {
    private Block block;
    private BrainDump brainDump;
    private Schedule schedule;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/Plan.json";

    // EFFECTS: constructs daily planner GUI with a brain dump and schedule
    public DailyPlannerApp()  throws FileNotFoundException {
        brainDump = new BrainDump();
        schedule = new Schedule();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        initializeUI();
    }

    //EFFECTS: initializes the UI by setting the layout and adding components
    private void initializeUI() {
        loadPlan();
        setTitle("Daily Time-Blocking Planner");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800, 800));
        // Create and add the BrainDumpPanel and SchedulePanel
        BrainDumpPanel brainDumpPanel = new BrainDumpPanel(brainDump);
        brainDumpPanel.drawBlocks();
        SchedulePanel schedulePanel = new SchedulePanel(schedule);
        schedulePanel.drawBlocks();

        setLayout(new GridLayout());
        add(brainDumpPanel, new GridLayout(1,1));
        add(schedulePanel, new GridLayout(1,2));
        pack();

        // TODO: Add other components and functionality
        setVisible(true);
    }

    // TODO: Add more methods for adding, moving, and deleting blocks

    private void loadPlan() {
        try {
            brainDump = jsonReader.readBrainDump();
            schedule = jsonReader.readSchedule();
            System.out.println("Loaded plan from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }
}