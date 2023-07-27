package persistence;

// REFERENCE: JsonSerializationDemo for saving/reading data
// link: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

import model.Block;
import model.BrainDump;
import model.Schedule;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Represents a reader that reads a plan from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads brain dump from file and returns it;
    // throws IOException if an error occurs reading data from file
    public BrainDump readBrainDump() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseBrainDump(jsonObject);
    }

    // EFFECTS: parses brain dump from JSON object and returns it
    private BrainDump parseBrainDump(JSONObject jsonObject) {
        BrainDump brainDump = new BrainDump();
        addBrainDumpBlocks(brainDump, jsonObject);
        return brainDump;
    }

    // MODIFIES: wr
    // EFFECTS: parses (unscheduled) blocks from JSON object and adds them to brain dump
    private void addBrainDumpBlocks(BrainDump brainDump, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("Brain Dump");
        for (Object json : jsonArray) {
            JSONObject nextBlock = (JSONObject) json;
            addBrainDumpBlock(brainDump, nextBlock);
        }
    }

    // MODIFIES: wr
    // EFFECTS: parses (unscheduled) block from JSON object and adds it to brain dump
    private void addBrainDumpBlock(BrainDump brainDump, JSONObject jsonObject) {
        String title = jsonObject.getString("title");
        float length = jsonObject.getFloat("length");
        brainDump.addToBrainDump(title, length);
    }

    // EFFECTS: reads schedule from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Schedule readSchedule() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseSchedule(jsonObject);
    }

    // EFFECTS: parses schedule from JSON object and returns it
    private Schedule parseSchedule(JSONObject jsonObject) {
        Schedule schedule = new Schedule();
        addScheduleBlocks(schedule, jsonObject);
        return schedule;
    }

    // MODIFIES: wr
    // EFFECTS: parses (scheduled) blocks from JSON object and adds them to brain dump
    private void addScheduleBlocks(Schedule schedule, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("Schedule");
        for (Object json : jsonArray) {
            JSONObject nextBlock = (JSONObject) json;
            addScheduleBlock(schedule, nextBlock);
        }
    }

    // MODIFIES: wr
    // EFFECTS: parses (scheduled) block from JSON object and adds it to brain dump
    private void addScheduleBlock(Schedule schedule, JSONObject jsonObject) {
        String title = jsonObject.getString("title");
        float length = jsonObject.getFloat("length");
        float startTime = jsonObject.getFloat("start time");
        Block b = new Block(title, length);
        b.setStartTime(startTime);
        schedule.addToSchedule(b);
    }


    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }
}
