package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BrainDumpTest {
    BrainDump testBrainDump;

    @BeforeEach
    void runBefore() {
        testBrainDump = new BrainDump();
    }

    @Test
    void testConstructor() {
        assertNotNull(testBrainDump);
        assertEquals(0, testBrainDump.getBrainDump().size());
    }

    @Test
    void testAddByTitleOnce() {
        testBrainDump.addToBrainDump("jogging", 0.75F);
        int size = testBrainDump.getBrainDump().size();
        Block block = testBrainDump.getBrainDump().get(0);
        String blockTitle = block.getTitle();
        Float blockLength = block.getLength();
        assertEquals(1, size);
        assertEquals("jogging", blockTitle);
        assertEquals(0.75F, blockLength);

    }

    @Test
    void testAddByTitleTwice() {
        testBrainDump.addToBrainDump("jogging", 0.75F);
        testBrainDump.addToBrainDump("sleeping", 7.00F);
        int size = testBrainDump.getBrainDump().size();
        Block block0 = testBrainDump.getBrainDump().get(0);
        String blockTitle0 = block0.getTitle();
        Float blockLength0 = block0.getLength();
        Block block1 = testBrainDump.getBrainDump().get(1);
        String blockTitle1 = block1.getTitle();
        Float blockLength1 = block1.getLength();
        assertEquals(2, size);
        assertEquals("jogging", blockTitle0);
        assertEquals(0.75F, blockLength0);
        assertEquals("sleeping", blockTitle1);
        assertEquals(7.00F, blockLength1);
    }

    @Test
    void testAddByBlockOnce() {
        Block block0 = new Block("jogging", 0.75F);
        testBrainDump.addToBrainDump(block0);
        int size = testBrainDump.getBrainDump().size();
        assertEquals(1, size);
        Block actual0 = testBrainDump.getBrainDump().get(0);
        assertEquals(block0, actual0);
    }

    @Test
    void testAddByBlockTwice() {
        Block block0 = new Block("jogging", 0.75F);
        Block block1 = new Block("sleeping", 7.00F);
        testBrainDump.addToBrainDump(block0);
        testBrainDump.addToBrainDump(block1);
        int size = testBrainDump.getBrainDump().size();
        assertEquals(2, size);
        Block actual0 = testBrainDump.getBrainDump().get(0);
        Block actual1 = testBrainDump.getBrainDump().get(1);
        assertEquals(block0, actual0);
        assertEquals(block1, actual1);
    }

    @Test
    void testDeleteByBlock0() {
        Block block0 = new Block("jogging", 0.75F);
        testBrainDump.addToBrainDump(block0);
        testBrainDump.deleteFromBrainDump(block0);
        int size = testBrainDump.getBrainDump().size();
        assertEquals(0, size);
    }

    @Test
    void testDeleteByBlock1() {
        Block block0 = new Block("jogging", 0.75F);
        Block block1 = new Block("sleeping", 7.00F);
        testBrainDump.addToBrainDump(block0);
        testBrainDump.addToBrainDump(block1);
        testBrainDump.deleteFromBrainDump(block0);
        int size = testBrainDump.getBrainDump().size();
        assertEquals(1, size);
        Block actual0 = testBrainDump.getBrainDump().get(0);
        assertEquals(block1, actual0);
    }

    @Test
    void testDeleteByTitle0() {
        Block block0 = new Block("jogging", 0.75F);
        testBrainDump.addToBrainDump(block0);
        testBrainDump.deleteFromBrainDump("jogging");
        int size = testBrainDump.getBrainDump().size();
        assertEquals(0, size);
    }

    @Test
    void testDeleteByTitle1() {
        Block block0 = new Block("jogging", 0.75F);
        Block block1 = new Block("sleeping", 7.00F);
        testBrainDump.addToBrainDump(block0);
        testBrainDump.addToBrainDump(block1);
        testBrainDump.deleteFromBrainDump("jogging");
        int size = testBrainDump.getBrainDump().size();
        assertEquals(1, size);
        Block actual0 = testBrainDump.getBrainDump().get(0);
        assertEquals(block1, actual0);
    }

    @Test
    void testFindBlockFromTitlePresent() {
        Block block0 = new Block("jogging", 0.75F);
        Block block1 = new Block("sleeping", 7.00F);
        testBrainDump.addToBrainDump(block0);
        testBrainDump.addToBrainDump(block1);
        Block actual0 = testBrainDump.findBlockFromTitle("jogging");
        Block actual1 = testBrainDump.findBlockFromTitle("sleeping");
        assertEquals(block0, actual0);
        assertEquals(block1, actual1);
    }

    @Test
    void testFindBlockFromTitleAbsent() {
        Block block0 = new Block("jogging", 0.75F);
        Block block1 = new Block("sleeping", 7.00F);
        testBrainDump.addToBrainDump(block0);
        testBrainDump.addToBrainDump(block1);
        Block actual0 = testBrainDump.findBlockFromTitle("jog");
        Block actual1 = testBrainDump.findBlockFromTitle("sleep");
        assertNull(actual0);
        assertNull(actual1);
    }

    @Test
    void testToString1() {
        Block block0 = new Block("jogging", 0.75F);
        testBrainDump.addToBrainDump(block0);
        String expected= "jogging\n";
        assertEquals(expected, testBrainDump.toString());
    }

    @Test
    void testToString2() {
        Block block0 = new Block("jogging", 0.75F);
        Block block1 = new Block("sleeping", 7.00F);
        testBrainDump.addToBrainDump(block0);
        testBrainDump.addToBrainDump(block1);
        String expected= "jogging\nsleeping\n";
        assertEquals(expected, testBrainDump.toString());
    }
}
