package persistence;

import model.BrainDump;
import model.Schedule;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Schedule s = reader.readSchedule();
            BrainDump br = reader.readBrainDump();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyPlan() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyPlan.json");
        try {
            BrainDump brainDump = reader.readBrainDump();
            Schedule schedule = reader.readSchedule();
            assertEquals(0, brainDump.getBrainDump().size());
            assertEquals(0, schedule.getSchedule().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralPlan() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralPlan.json");
        try {
            Schedule schedule = reader.readSchedule();
            BrainDump brainDump = reader.readBrainDump();

            assertEquals(1, brainDump.getBrainDump().size());
            assertEquals(1, schedule.getSchedule().size());

            checkBlock("Sleeping", 8.0F, 0.50F, schedule.getSchedule().get(0));
            checkBlock("Jogging", 0.75F, 24.00F, brainDump.getBrainDump().get(0));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}