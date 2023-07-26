package persistence;

import model.BrainDump;
import model.Category;
import model.Schedule;
import model.Thingy;
import model.WorkRoom;
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
    public BrainDump readBrainDump() {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        JSONObject jsonObjectSchedule = jsonObject.getJSONObject("Schedule");
        return parseBrainDump(jsonObject);
    }

    // EFFECTS: parses brain dump from JSON object and returns it
    private BrainDump parseBrainDump(JSONObject jsonObject) {
        BrainDump brainDump = new BrainDump();
        addUnscheduledBlock(brainDump, jsonObject);
        return brainDump;
    }

    // MODIFIES: brainDump
    // EFFECTS: parses braindump from JSON object and adds them to brain dump
    private void addUnscheduledBlock(BrainDump brainDump, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("Schedule");
        for (Object json : jsonArray) {
            JSONObject nextThingy = (JSONObject) json;
            addThingy(wr, nextThingy);
        }
    }


    private void addThingies(WorkRoom wr, JSONObject jsonObject) {

    }


    // EFFECTS: reads schedule from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Schedule readSchedule() {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseSchedule(jsonObject);
    }

    private Schedule parseSchedule(JSONObject jsonObject) {
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines( Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }




    // MODIFIES: wr
    // EFFECTS: parses thingy from JSON object and adds it to workroom
    private void addThingy(WorkRoom wr, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Category category = Category.valueOf(jsonObject.getString("category"));
        Thingy thingy = new Thingy(name, category);
        wr.addThingy(thingy);
    }
}
