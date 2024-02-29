/****************************
 * Program 1: Dictionary
 * <p>
 * Course: CS 342, Spring 2024
 * System: macOS using IntelliJ
 * Starter Code Author: Evan McCarty
 * Student Author: Albert Huynh & Karina Perez
 * <p>
 * ***************************/

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

public class BSTTest extends DictionaryTest {
    @Override
    public ProjOneDictionary<Integer, String> newDictionary() {
        return new BinarySearchTreeDict<Integer,String>();
    }

    @Test
    void IteratorTestEmpty() throws NullValueException {
        ProjOneDictionary<Integer, String> BST = newDictionary();

        Iterator<Integer> iter = BST.iterator();
        assertFalse(iter.hasNext(), "Incorrect empty element Iterator behavior");

    }

    @Test
    void IteratorTestSingle() throws NullValueException {
        ProjOneDictionary<Integer, String> BST = newDictionary();

        BST.insert(3, "three");

        assertEquals("three", BST.find(3), "Incorrect single element find behavior");

        Iterator<Integer> iter = BST.iterator();

        assertTrue(iter.hasNext(), "Incorrect single element hasNext Iterator behavior");
        assertEquals(3,iter.next(), "Incorrect single element iterator behavior");
    }

    @Test
    void IteratorTestMultiple() throws NullValueException {
        ProjOneDictionary<Integer, String> BST = newDictionary();
        BST.insert(100, "one hundred");
        BST.insert(50, "fifty");
        BST.insert(150, "one hundred fifty");
        BST.insert(40, "forty");
        BST.insert(41, "forty one");
        BST.insert(140, "one hundred forty");
        BST.insert(160, "one hundred sixty");
        BST.insert(139, "one hundred thirty nine");
        BST.insert(141, "one hundred forty one");
        BST.insert(151, "one hundred fifty one");
        BST.insert(161, "one hundred sixty one");

        Iterator<Integer> iter = BST.iterator();

        assertTrue(iter.hasNext(), "Incorrect multiple element hasNext Iterator behavior");
        assertEquals(100,iter.next(), "Incorrect multiple element iterator behavior");

        assertTrue(iter.hasNext(), "Incorrect multiple element hasNext Iterator behavior");
        assertEquals(50,iter.next(), "Incorrect multiple element iterator behavior");

        assertTrue(iter.hasNext(), "Incorrect multiple element hasNext Iterator behavior");
        assertEquals(150,iter.next(), "Incorrect multiple element iterator behavior");

        assertTrue(iter.hasNext(), "Incorrect multiple element hasNext Iterator behavior");
        assertEquals(40,iter.next(), "Incorrect multiple element iterator behavior");

        assertTrue(iter.hasNext(), "Incorrect multiple element hasNext Iterator behavior");
        assertEquals(140,iter.next(), "Incorrect multiple element iterator behavior");

        assertTrue(iter.hasNext(), "Incorrect multiple element hasNext Iterator behavior");
        assertEquals(160,iter.next(), "Incorrect multiple element iterator behavior");

        assertTrue(iter.hasNext(), "Incorrect multiple element hasNext Iterator behavior");
        assertEquals(41,iter.next(), "Incorrect multiple element iterator behavior");

        assertTrue(iter.hasNext(), "Incorrect multiple element hasNext Iterator behavior");
        assertEquals(139,iter.next(), "Incorrect multiple element iterator behavior");
        assertTrue(iter.hasNext(), "Incorrect multiple element hasNext Iterator behavior");
        assertEquals(141,iter.next(), "Incorrect multiple element iterator behavior");

        assertTrue(iter.hasNext(), "Incorrect multiple element hasNext Iterator behavior");
        assertEquals(151,iter.next(), "Incorrect multiplee element iterator behavior");

        assertTrue(iter.hasNext(), "Incorrect multiple element hasNext Iterator behavior");
        assertEquals(161,iter.next(), "Incorrect multiple element iterator behavior");

        assertFalse(iter.hasNext(),"Incorrect multiple element hasNext Iterator behavior");
    }

    @Test
    void multipleElementLeftIterator () throws NullValueException {
        ProjOneDictionary<Integer, String> BST = newDictionary();

        BST.insert(200, "two hundred");
        BST.insert(195, "one hundred ninety-five");
        BST.insert(190, "one hundred ninety");
        BST.insert(185, "one hundred eighty-five");
        BST.insert(180, "one hundred eighty");
        BST.insert(175, "one hundred seventy-five");

        Iterator<Integer> iter = BST.iterator();

        assertTrue(iter.hasNext(), "Incorrect multiple element left children only hasNext Iterator behavior");
        assertEquals(200,iter.next(), "Incorrect multiple element left children only next Iterator behavior");

        assertTrue(iter.hasNext(), "Incorrect multiple element left children only hasNext Iterator behavior");
        assertEquals(195,iter.next(), "Incorrect multiple element left children only next Iterator behavior");

        assertTrue(iter.hasNext(), "Incorrect multiple element left children only hasNext Iterator behavior");
        assertEquals(190,iter.next(), "Incorrect multiple element left children only next Iterator behavior");

        assertTrue(iter.hasNext(), "Incorrect multiple element left children only hasNext Iterator behavior");
        assertEquals(185,iter.next(), "Incorrect multiple element left children only next Iterator behavior");

        assertTrue(iter.hasNext(), "Incorrect multiple element left children only hasNext Iterator behavior");
        assertEquals(180,iter.next(), "Incorrect multiple element left children only next Iterator behavior");

        assertTrue(iter.hasNext(), "Incorrect multiple element left children only hasNext Iterator behavior");
        assertEquals(175,iter.next(), "Incorrect multiple element left children only next Iterator behavior");

        assertFalse(iter.hasNext(), "Incorrect multiple element left children only hasNext Iterator behavior");
    }

    @Test
    void multipleElementRightIterator() throws NullValueException {
        ProjOneDictionary<Integer, String> BST = newDictionary();

        BST.insert(50, "fifty");
        BST.insert(55, "fifty-five");
        BST.insert(60, "sixty");
        BST.insert(65, "sixty-five");
        BST.insert(66, "sixty-six");
        BST.insert(67, "sixty-seven");
        BST.insert(68, "sixty-eight");
        BST.insert(69, "sixty-nine");
        BST.insert(70, "seventy");

        Iterator<Integer> iter = BST.iterator();

        assertTrue(iter.hasNext(), "Incorrect multiple element right iterator hasNext behavior");
        assertEquals(50,iter.next(), "Incorrect multiple element right next iterator behavior");

        assertTrue(iter.hasNext(), "Incorrect multiple element right iterator hasNext behavior");
        assertEquals(55,iter.next(), "Incorrect multiple element right next iterator behavior");

        assertTrue(iter.hasNext(), "Incorrect multiple element right iterator hasNext behavior");
        assertEquals(60,iter.next(), "Incorrect multiple element right next iterator behavior");

        assertTrue(iter.hasNext(), "Incorrect multiple element right iterator hasNext behavior");
        assertEquals(65,iter.next(), "Incorrect multiple element right next iterator behavior");

        assertTrue(iter.hasNext(), "Incorrect multiple element right iterator hasNext behavior");
        assertEquals(66,iter.next(), "Incorrect multiple element right next iterator behavior");

        assertTrue(iter.hasNext(), "Incorrect multiple element right iterator hasNext behavior");
        assertEquals(67,iter.next(), "Incorrect multiple element right next iterator behavior");

        assertTrue(iter.hasNext(), "Incorrect multiple element right iterator hasNext behavior");
        assertEquals(68,iter.next(), "Incorrect multiple element right next iterator behavior");

        assertTrue(iter.hasNext(), "Incorrect multiple element right iterator hasNext behavior");
        assertEquals(69,iter.next(), "Incorrect multiple element right next iterator behavior");

        assertTrue(iter.hasNext(), "Incorrect multiple element right iterator hasNext behavior");
        assertEquals(70,iter.next(), "Incorrect multiple element right next iterator behavior");
    }

    @Test
    void MassiveElementIterator() throws NullValueException{
        ProjOneDictionary<Integer, String> BST = newDictionary();

        for (int i = 0; i < 100; i++) {
            BST.insert(i, "a");
        }

        Iterator<Integer> iter = BST.iterator();

        for (int i = 0; i < 100; i++) {
            assertTrue(iter.hasNext(), "Incorrect massive element iterator hasNext behavior");
            assertEquals(i, iter.next(), "Incorrect massive element iterator hasNext behavior");
        }
    }

}
