package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BlockTest {
    private Block testBlock;
    private String testTitle = "CPSC210 project";
    private float testLength = 4.50F;

    @BeforeEach
    void runBefore() {
        testBlock = new Block(testTitle, testLength);
    }

    @Test
    void testConstructor() {
        String title = testBlock.getTitle();
        Float length = testBlock.getLength();
        Float startTime = testBlock.getStartTime();
        assertEquals(this.testTitle, title);
        assertEquals(this.testLength, length);
        assertEquals(24.00F, startTime);
    }

    @Test
    void testSetStartTimeOnce() {
        testBlock.setStartTime(1.00F);
        assertEquals(1.00F, testBlock.getStartTime());
    }

    @Test
    void testSetStartTimeTwice() {
        testBlock.setStartTime(1.00F);
        testBlock.setStartTime(11.50F);
        assertEquals(11.50F, testBlock.getStartTime());
    }

    @Test
    void testIsScheduledFalse() {
        assertFalse(testBlock.isScheduled());
    }

    @Test
    void testIsScheduledTrue() {
        testBlock.setStartTime(23.99F);
        assertTrue(testBlock.isScheduled());
    }

    @Test
    void testToString() {
        assertEquals(testTitle, testBlock.toString());
    }
}
