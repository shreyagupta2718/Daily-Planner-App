package ui;

import model.Block;
import model.BrainDump;
import model.Schedule;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.tools.LoadTool;
import ui.tools.SaveTool;
import ui.tools.Tool;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

// Represents main window frame of the Daily Time-Blocking Planner Application
public class DailyPlannerApp extends JFrame {
    private BrainDump brainDump;
    private Schedule schedule;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/Plan.json";
    JPanel toolPanel;

    // EFFECTS: constructs daily planner GUI with a tools panel, a brain dump, and a schedule
    public DailyPlannerApp() throws FileNotFoundException {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        initializeUserData();
        initializeUI();
    }

    // MODIFIES: this
    // EFFECTS: initializes the brain dump and schedule
    private void initializeUserData() {
        brainDump = new BrainDump();
        schedule = new Schedule();
    }

    // MODIFIES: this
    // EFFECTS: Sets the layout of the UI and adds components representing a tools panel, a brain dump, and a schedule
    private void initializeUI() {
        setTitle("Daily Time-Blocking Planner");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800, 800));
        BrainDumpPanel brainDumpPanel = new BrainDumpPanel(brainDump);
        brainDumpPanel.drawBlocks();
        SchedulePanel schedulePanel = new SchedulePanel(schedule);
        schedulePanel.drawBlocks();
        GridLayout layoutUI = new GridLayout(1, 3);
        this.setLayout(layoutUI);
        createTools();
        add(brainDumpPanel);
        add(schedulePanel);
        pack();
        setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: creates tools panel, adds tools in it, and adds it to the UI
    private void createTools() {
        toolPanel = new JPanel();
        BoxLayout toolPanelLayout = new BoxLayout(toolPanel, BoxLayout.Y_AXIS);
        toolPanel.setLayout(toolPanelLayout);
        toolPanel.setMaximumSize(new Dimension(1, 4));

        createAddPanel();
        createSchedulePanel();
        Tool saveTool = new SaveTool(this, toolPanel);
        toolPanel.add(Box.createVerticalGlue());
        saveTool.addToParent(toolPanel);
        toolPanel.add(Box.createVerticalGlue());
        Tool loadTool = new LoadTool(this, toolPanel);
        loadTool.addToParent(toolPanel);
        toolPanel.add(Box.createVerticalGlue());

        add(toolPanel);
    }

    // MODIFIES: this
    // EFFECTS: Sets a common layout for the panels to add a block to brain dump and to schedule a block
    private void createPanelLayout(JPanel panel) {
        panel.setMaximumSize(new Dimension(400, 180));
        panel.setPreferredSize(new Dimension(180, 180));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    }

    // MODIFIES: this
    // EFFECTS: Creates the area that lets user schedule a block by taking block no. and start time as input
    private void createSchedulePanel() {
        JPanel schedulePanel = new JPanel();
        createPanelLayout(schedulePanel);
        schedulePanel.setBorder(BorderFactory.createTitledBorder("Schedule a block"));
        schedulePanel.add(new JLabel("Block no.:"));
        JTextField blockNumField = new JTextField(2);
        schedulePanel.add(blockNumField);
        schedulePanel.add(new JLabel("Start at:"));
        JTextField timeField = new JTextField(2);
        schedulePanel.add(timeField);
        schedulePanel.add(createScheduleButton(blockNumField, timeField));
        toolPanel.add(Box.createVerticalGlue());
        toolPanel.add(schedulePanel);
    }

    // EFFECTS: Makes a button to schedule a block and returns it
    private JButton createScheduleButton(JTextField blockNumField, JTextField timeField) {
        JButton scheduleButton = new JButton("Schedule Block");
        scheduleButton.addActionListener(e -> {
            int blockIndex = Integer.parseInt(blockNumField.getText()) - 1;
            float startTime = Float.parseFloat(timeField.getText());
            if (blockIndex >= 0 && blockIndex < brainDump.getBrainDump().size()) {
                Block block = brainDump.getBrainDump().get(blockIndex);
                block.setStartTime(startTime);
                schedule.addToSchedule(block);
                brainDump.deleteFromBrainDump(block);
                blockNumField.setText("");
                timeField.setText("");
                updateUI();
            } else {
                JOptionPane.showMessageDialog(DailyPlannerApp.this, "Invalid block index!");
            }
        });
        return scheduleButton;
    }

    // MODIFIES: this
    // EFFECTS: Creates the area that lets user add a block taking title and length of block as input
    private void createAddPanel() {
        JPanel addPanel = new JPanel();
        createPanelLayout(addPanel);
        addPanel.setBorder(BorderFactory.createTitledBorder("Add a block"));
        addPanel.add(new JLabel("Title:"));
        JTextField titleField = new JTextField(30);
        addPanel.add(titleField);
        addPanel.add(new JLabel("Length:"));
        JTextField lengthField = new JTextField(2);
        addPanel.add(lengthField);
        addPanel.add(createAddButton(titleField, lengthField));
        toolPanel.add(Box.createVerticalGlue());
        toolPanel.add(addPanel);
    }

    // EFFECTS: Creates the button for adding to the add panel and returns it
    private JButton createAddButton(JTextField titleField, JTextField lengthField) {
        JButton addButton = new JButton("Add Block");
        addButton.addActionListener(e -> {
            String title = titleField.getText();
            float length = Float.parseFloat(lengthField.getText());
            Block block = new Block(title, length);
            brainDump.addToBrainDump(block);
            titleField.setText("");
            lengthField.setText("");
            updateUI();
        });

        return addButton;
    }

    // MODIFIES: this
    // EFFECTS: saves the brain dump and schedule to file
    public void savePlan() {
        try {
            jsonWriter.open();
            jsonWriter.write(brainDump, schedule);
            jsonWriter.close();
            JOptionPane.showMessageDialog(this, "Plan saved successfully to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads brain dump and schedule from file
    public void loadPlan() {
        try {
            brainDump = jsonReader.readBrainDump();
            schedule = jsonReader.readSchedule();
            updateUI();
            JOptionPane.showMessageDialog(this, "Plan loaded successfully from " + JSON_STORE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Unable to read from file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: updates the GUI components with the updated brain dump and schedule
    private void updateUI() {
        getContentPane().removeAll();
        initializeUI();
    }
}