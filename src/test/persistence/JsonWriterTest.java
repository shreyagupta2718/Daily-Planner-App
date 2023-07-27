package persistence;

import model.Block;
import model.Schedule;
import model.BrainDump;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyPlan() {
        try {
            Schedule schedule = new Schedule();
            BrainDump brainDump = new BrainDump();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyPlan.json");
            writer.open();
            writer.write(brainDump, schedule);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyPlan.json");
            brainDump = reader.readBrainDump();
            schedule = reader.readSchedule();
            assertEquals(0, brainDump.getBrainDump().size());
            assertEquals(0, schedule.getSchedule().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralPlan() {
        try {
            Schedule schedule = new Schedule();
            BrainDump brainDump = new BrainDump();
            brainDump.addToBrainDump("Jogging", 0.75F);
            Block testBlock = new Block("Sleeping", 8.0F);
            testBlock.setStartTime(0.50F);
            schedule.addToSchedule(testBlock);

            JsonWriter writer = new JsonWriter("./data/testWriterGeneralPlan.json");
            writer.open();
            writer.write(brainDump, schedule);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralPlan.json");
            schedule = reader.readSchedule();
            brainDump = reader.readBrainDump();

            assertEquals(1, brainDump.getBrainDump().size());
            assertEquals(1, schedule.getSchedule().size());

            checkBlock("Sleeping", 8.0F, 0.50F, schedule.getSchedule().get(0));
            checkBlock("Jogging", 0.75F, 24.00F, brainDump.getBrainDump().get(0));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}