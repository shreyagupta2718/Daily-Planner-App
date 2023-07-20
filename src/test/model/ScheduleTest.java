package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ScheduleTest {
    Schedule testSchedule;

    @BeforeEach
    void runBefore() {
        testSchedule = new Schedule();
    }

    @Test
    void testConstructor() {
        assertNotNull(testSchedule);
        assertEquals(0, testSchedule.getSchedule().size());
    }

    @Test
    void testAddToScheduleOnce() {
        Block block0 = new Block("jogging", 0.75F);
        block0.setStartTime(22.00F);
        testSchedule.addToSchedule(block0);
        int size = testSchedule.getSchedule().size();
        assertEquals(1, size);
        Block actual0 = testSchedule.getSchedule().get(0);
        assertEquals(block0, actual0);
    }

    @Test
    void testAddToScheduleTwice() {
        Block block0 = new Block("jogging", 0.75F);
        block0.setStartTime(22.00F);
        Block block1 = new Block("sleeping", 7.00F);
        block0.setStartTime(00.00F);
        testSchedule.addToSchedule(block0);
        testSchedule.addToSchedule(block1);
        int size = testSchedule.getSchedule().size();
        assertEquals(2, size);
        Block actual0 = testSchedule.getSchedule().get(0);
        Block actual1 = testSchedule.getSchedule().get(1);
        assertEquals(block0, actual0);
        assertEquals(block1, actual1);
    }

    @Test
    void testDeleteFromSchedule0() {
        Block block0 = new Block("jogging", 0.75F);
        block0.setStartTime(22.00F);
        testSchedule.addToSchedule(block0);
        testSchedule.deleteFromSchedule(block0);
        int size = testSchedule.getSchedule().size();
        assertEquals(0, size);
    }

    @Test
    void testDeleteFromSchedule1() {
        Block block0 = new Block("jogging", 0.75F);
        block0.setStartTime(22.00F);
        Block block1 = new Block("sleeping", 7.00F);
        block0.setStartTime(00.00F);
        testSchedule.addToSchedule(block0);
        testSchedule.addToSchedule(block1);
        testSchedule.deleteFromSchedule(block0);
        int size = testSchedule.getSchedule().size();
        assertEquals(1, size);
        Block actual0 = testSchedule.getSchedule().get(0);
        assertEquals(block1, actual0);
    }

    @Test
    void testToString1() {
        Block block0 = new Block("jogging", 0.75F);
        testSchedule.addToSchedule(block0);
        String expected= "jogging\n";
        assertEquals(expected, testSchedule.toString());
    }
    
    @Test
    void testToString2() {
        Block block0 = new Block("jogging", 0.75F);
        Block block1 = new Block("sleeping", 7.00F);
        testSchedule.addToSchedule(block0);
        testSchedule.addToSchedule(block1);
        String expected= "jogging\nsleeping\n";
        assertEquals(expected, testSchedule.toString());
    }
}
