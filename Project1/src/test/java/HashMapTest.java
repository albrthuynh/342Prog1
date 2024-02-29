/****************************
 * Program 1: Dictionary
 * <p>
 * Course: CS 342, Spring 2024
 * System: macOS using IntelliJ
 * Starter Code Author: Evan McCarty
 * Student Author: Albert Huynh & Karina Perez
 * <p>
 * ***************************/

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class HashMapTest extends DictionaryTest{
    @Override
    public ProjOneDictionary<Integer, String> newDictionary() {
        return new HashMapDict<Integer,String>();
    }


    @Test
    void resizeTest() throws NullValueException {
        ProjOneDictionary<Integer, String> hashmap = newDictionary();

        assertFalse(hashmap.insert(2, "two"), "Incorrect resize behavior");
        assertFalse(hashmap.insert(12, "twelve"), "Incorrect resize behavior");
        assertFalse(hashmap.insert(3, "three"), "Incorrect resize behavior");
        assertFalse(hashmap.insert(5, "five"), "Incorrect resize behavior");
        assertFalse(hashmap.insert(13, "thirteen"), "Incorrect resize behavior");
        assertFalse(hashmap.insert(4, "four"), "Incorrect resize behavior");
        assertFalse(hashmap.insert(14, "fourteen"), "Incorrect resize behavior");
        assertFalse(hashmap.insert(10, "ten"), "Incorrect resize behavior");
        assertFalse(hashmap.insert(11, "eleven"), "Incorrect resize behavior");
        assertFalse(hashmap.insert(9, "nine"), "Incorrect resize behavior");
        assertFalse(hashmap.insert(15, "fifteen"), "Incorrect resize behavior");

        assertEquals("three", hashmap.find(3), "Incorrect resize behavior");
        assertEquals("fourteen", hashmap.find(14), "Incorrect resize behavior");
        assertEquals("two", hashmap.find(2), "Incorrect resize behavior");
        assertEquals("twelve", hashmap.find(12), "Incorrect resize behavior");
        assertEquals("five", hashmap.find(5), "Incorrect resize behavior");
        assertEquals("thirteen", hashmap.find(13), "Incorrect resize behavior");
        assertEquals("four", hashmap.find(4), "Incorrect resize behavior");
        assertEquals("ten", hashmap.find(10), "Incorrect resize behavior");
        assertEquals("eleven", hashmap.find(11), "Incorrect resize behavior");
        assertEquals("nine", hashmap.find(9), "Incorrect resize behavior");
        assertEquals("fifteen", hashmap.find(15), "Incorrect resize behavior");
    }

    @Test
    void emptyElementIterator() {
        ProjOneDictionary<Integer, String> hashmap = newDictionary();
        Iterator<Integer> iter = hashmap.iterator();

        assertFalse(iter.hasNext(), "Incorrect empty element hasNext Iterator behavior");
    }

    @Test
    void singleElementIterator() throws NullValueException {
        ProjOneDictionary<Integer, String> hashmap = newDictionary();

        hashmap.insert(2, "two");

        Iterator<Integer> iter = hashmap.iterator();

        assertTrue(iter.hasNext(), "Incorrect single element hasNext Iterator behavior");
        assertEquals(2,iter.next(), "Incorrect single element Iterator behavior");
        assertFalse(iter.hasNext(), "Incorrect single element hasNext Iterator behavior");
    }

    @Test
    void multipleElementIteratorNullValues() throws NullValueException {
        ProjOneDictionary<Integer, String> hashmap = newDictionary();

        hashmap.insert(2, "two");
        hashmap.insert(7, "seven");
        hashmap.insert(9, "nine");

        Iterator<Integer> iter = hashmap.iterator();

        assertTrue(iter.hasNext(), "Incorrect multiple element iterator null hasNext Iterator behavior");
        assertEquals(2,iter.next(), "Incorrect multiple element iterator null hasNext Iterator behavior");

        assertTrue(iter.hasNext(), "Incorrect multiple element iterator null hasNext Iterator behavior");
        assertEquals(7,iter.next(), "Incorrect multiple element iterator null hasNext Iterator behavior");

        assertTrue(iter.hasNext(), "Incorrect multiple element iterator null hasNext Iterator behavior");
        assertEquals(9,iter.next(), "Incorrect multiple element iterator null hasNext Iterator behavior");

        assertFalse(iter.hasNext(), "Incorrect multiple element iterator null hasNext Iterator behavior");
    }

    @Test
    void multipleElementIterator() throws NullValueException {
        ProjOneDictionary<Integer, String> hashmap = newDictionary();
        hashmap.insert(2, "two");
        hashmap.insert(12, "twelve");
        hashmap.insert(3, "three");
        hashmap.insert(5, "five");

        Iterator<Integer> iter = hashmap.iterator();

        assertTrue(iter.hasNext(), "Incorrect multiple element hasNext Iterator behavior");
        assertEquals(2,iter.next(), "Incorrect multiple element next Iterator behavior");

        assertTrue(iter.hasNext(), "Incorrect multiple element hasNext Iterator behavior");
        assertEquals(12, iter.next(), "Incorrect multiple element next Iterator behavior");

        assertTrue(iter.hasNext(), "Incorrect multiple element hasNext Iterator behavior");
        assertEquals(3, iter.next(), "Incorrect multiple element next Iterator behavior");

        assertTrue(iter.hasNext(), "Incorrect multiple element hasNext Iterator behavior");
        assertEquals(5, iter.next(), "Incorrect multiple element next Iterator behavior");

        assertFalse(iter.hasNext(), "Incorrect multiple element hasNext Iterator behavior");
    }

    @Test
    void multipleElementResizeIterator() throws NullValueException {
        ProjOneDictionary<Integer, String> hashmap = newDictionary();

        assertFalse(hashmap.insert(2, "two"), "Incorrect multiple element resize iterator behavior");
        assertFalse(hashmap.insert(3, "three"), "Incorrect multiple element resize iterator behavior");
        assertFalse(hashmap.insert(4, "four"), "Incorrect multiple element resize iterator behavior");
        assertFalse(hashmap.insert(20, "twenty"), "Incorrect multiple element resize iterator behavior");
        assertFalse(hashmap.insert(21, "twenty-one"), "Incorrect multiple element resize iterator behavior");
        assertFalse(hashmap.insert(49, "forty-nine"), "Incorrect multiple element resize iterator behavior");
        assertFalse(hashmap.insert(51, "fifty-one"), "Incorrect multiple element resize iterator behavior");
        assertFalse(hashmap.insert(19, "nineteen"), "Incorrect multiple element resize iterator behavior");
        assertFalse(hashmap.insert(100, "one hundred"), "Incorrect multiple element resize iterator behavior");
        assertFalse(hashmap.insert(46, "forty-six"), "Incorrect multiple element resize iterator behavior");
        assertFalse(hashmap.insert(35, "thirty-five"), "Incorrect multiple element resize iterator behavior");
        assertFalse(hashmap.insert(17, "seventeen"), "Incorrect multiple element resize iterator behavior");

        Iterator<Integer> iter = hashmap.iterator();

        assertTrue(iter.hasNext(), "Incorrect multiple element resize hasNext Iterator behavior");
        assertEquals(20, iter.next(), "Incorrect multiple resize element next Iterator behavior");

        assertTrue(iter.hasNext(), "Incorrect multiple element resize hasNext Iterator behavior");
        assertEquals(21,iter.next(), "Incorrect multiple resize element next Iterator behavior");

        assertTrue(iter.hasNext(), "Incorrect multiple element resize hasNext Iterator behavior");
        assertEquals(2,iter.next(), "Incorrect multiple resize element next Iterator behavior");

        assertTrue(iter.hasNext(), "Incorrect multiple element resize hasNext Iterator behavior");
        assertEquals(3,iter.next(), "Incorrect multiple resize element next Iterator behavior");

        assertTrue(iter.hasNext(), "Incorrect multiple element resize hasNext Iterator behavior");
        assertEquals(4,iter.next(), "Incorrect multiple resize element next Iterator behavior");

        assertTrue(iter.hasNext(), "Incorrect multiple element resize hasNext Iterator behavior");
        assertEquals(51,iter.next(), "Incorrect multiple resize element next Iterator behavior");

        assertTrue(iter.hasNext(), "Incorrect multiple element resize hasNext Iterator behavior");
        assertEquals(19,iter.next(), "Incorrect multiple resize element next Iterator behavior");

        assertTrue(iter.hasNext(), "Incorrect multiple element resize hasNext Iterator behavior");
        assertEquals(100,iter.next(), "Incorrect multiple element resize next Iterator behavior");

        assertTrue(iter.hasNext(), "Incorrect multiple element resize hasNext Iterator behavior");
        assertEquals(46,iter.next(), "Incorrect multiple resize element next Iterator behavior");

        assertTrue(iter.hasNext(), "Incorrect multiple element resize hasNext Iterator behavior");
        assertEquals(49,iter.next(), "Incorrect multiple resize element next Iterator behavior");

        assertTrue(iter.hasNext(), "Incorrect multiple element resize hasNext Iterator behavior");
        assertEquals(35,iter.next(), "Incorrect multiple resize element next Iterator behavior");

        assertTrue(iter.hasNext(), "Incorrect multiple element resize hasNext Iterator behavior");
        assertEquals(17,iter.next(), "Incorrect multiple resize element next Iterator behavior");

        assertFalse(iter.hasNext(), "Incorrect single element hasNext Iterator behavior");
    }

    @Test
    void MassiveElementIterator() throws NullValueException{
        ProjOneDictionary<Integer, String> hashmap = newDictionary();

        for (int i = 0; i < 100; i++) {
            hashmap.insert(i, "a");
        }

        Iterator<Integer> iter = hashmap.iterator();

        for (int i = 0; i < 100; i++) {
            assertTrue(iter.hasNext(), "Incorrect massive element iterator hasNext behavior");
            assertEquals(i, iter.next(), "Incorrect massive element iterator hasNext behavior");
        }
    }
}
