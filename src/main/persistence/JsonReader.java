package persistence;

import model.BrainDump;
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

    // EFFECTS: reads either schedule or brain dump from file and returns it;
    // throws IOException if an error occurs reading data from file
    public BrainDump readBrainDump() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        JSONObject jsonObjectWanted = jsonObject.getJSONObject(key);
        return parseJsonObject(jsonObjectWanted);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines( Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses either schedule or brain dump from JSON object and returns it
    private Object parseJsonObject(JSONObject jsonObject) {
        return null;
    }
}
