package persistence;

import model.BrainDump;
import model.Schedule;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

// Represents a writer that writes JSON representation of plan to file
public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    // EFFECTS: constructs writer to write to destination file
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot
    // be opened for writing
    public void open() throws FileNotFoundException {
       writer = new PrintWriter(new File(destination));
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of plan to file
    public void write(BrainDump b, Schedule s) {
        JSONObject jsonBrainDump = b.toJson();
        JSONObject jsonSchedule = s.toJson();
        JSONObject storePlan = new JSONObject();
        storePlan.put("Brain Dump", jsonBrainDump);
        storePlan.put("Schedule", jsonSchedule);

        saveToFile(storePlan.toString(TAB));
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        writer.close();
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    private void saveToFile(String json) {
        writer.print(json);
    }
}
