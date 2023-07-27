package persistence;

import model.Block;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkBlock(String title, Float length, Float startTime, Block block) {
        assertEquals(title, block.getTitle());
        assertEquals(length, block.getLength());
        assertEquals(startTime, block.getStartTime());
    }
}
