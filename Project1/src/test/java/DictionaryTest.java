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

public abstract class DictionaryTest {
    public abstract ProjOneDictionary<Integer,String> newDictionary();

    @Test
    public void testSize(){
        ProjOneDictionary<Integer, String> dict = newDictionary();
        assertEquals(0,dict.getSize());
    }

    @Test
    public void testNullValue(){
        ProjOneDictionary<Integer, String> dict = newDictionary();
        try{
            dict.insert(0,null);
            fail();
        } catch (NullValueException e){
            return;
        }
    }

    @Test
    void emptyGetSize()  {
        ProjOneDictionary<Integer, String> dict = newDictionary();

        assertEquals(0, dict.getSize(), "Incorrect empty getSize behavior");
    }

    @Test
    void emptyDelete () {
        ProjOneDictionary<Integer, String> dict = newDictionary();

        assertFalse(dict.delete(7), "Incorrect empty delete behavior");
    }

    @Test
    void singleElementInsert() throws NullValueException {
        ProjOneDictionary<Integer, String> dict = newDictionary();
        assertFalse(dict.insert(3, "three"), "Incorrect single element insert behavior");
        assertEquals("three", dict.find(3), "Incorrect single element insert behavior");
    }

    @Test
    void singleElementInsertDuplicate() throws NullValueException {
        ProjOneDictionary<Integer, String> dict = newDictionary();

        assertFalse(dict.insert(3, "three"), "Incorrect single element insert behavior");
        assertTrue(dict.insert(3, "tres"), "Incorrect single element insert behavior");
        assertEquals("tres", dict.find(3), "Incorrect single element insert behavior");
    }

    @Test
    void singleElementDelete () throws NullValueException {
        ProjOneDictionary<Integer, String> dict = newDictionary();
        dict.insert(6, "six");

        assertTrue(dict.delete(6), "Incorrect single element delete behavior");
        assertEquals(0, dict.getSize(), "Incorrect single element delete behavior");
        assertNull(dict.find(6), "Incorrect single element delete behavior");
    }

    @Test
    void singleElementDoubleDelete () throws NullValueException {
        ProjOneDictionary<Integer, String> dict = newDictionary();
        dict.insert(6, "six");

        assertTrue(dict.delete(6), "Incorrect single element delete behavior");
        assertEquals(0, dict.getSize(), "Incorrect single element delete behavior");
        assertNull(dict.find(6), "Incorrect single element delete behavior");

        // deleting 6 again
        assertFalse(dict.delete(6), "Incorrect single element delete behavior");
    }

    @Test
    void singleElementGetSize () throws NullValueException {
        ProjOneDictionary<Integer, String> dict = newDictionary();
        dict.insert(6, "six");

        assertEquals(1, dict.getSize(), "Incorrect single element getSize behavior");
    }

    @Test
    void singleElementGetSizeDuplicate () throws NullValueException {
        ProjOneDictionary<Integer, String> dict = newDictionary();
        dict.insert(6, "six");
        dict.insert(6, "seis");

        assertEquals(1, dict.getSize(), "Incorrect single element getSize behavior");
    }

    @Test
    void singleElementGetSizeDelete () throws NullValueException {
        ProjOneDictionary<Integer, String> dict = newDictionary();
        dict.insert(6, "six");
        dict.insert(6, "seis");

        dict.delete(6);

        assertNotEquals(1, dict.getSize(), "Incorrect single element getSize behavior");
        assertEquals(0, dict.getSize(), "Incorrect single element getSize behavior");
    }

    @Test
    void singleElementFind () throws NullValueException {
        ProjOneDictionary<Integer, String> dict = newDictionary();
        dict.insert(4, "four");

        assertEquals("four", dict.find(4), "Incorrect single element find behavior");
    }

    @Test
    void singleElementFindDuplicate () throws NullValueException {
        ProjOneDictionary<Integer, String> dict = newDictionary();
        dict.insert(4, "four");
        dict.insert(4, "cuatro");

        assertNotEquals("four", dict.find(4), "Incorrect single element find behavior");
        assertEquals("cuatro", dict.find(4), "Incorrect single element find behavior");
    }

    @Test
    void multipleElementInsert() throws NullValueException {
        ProjOneDictionary<Integer, String> dict = newDictionary();

        assertFalse(dict.insert(12, "twelve"), "Incorrect multiple element insert behavior");
        assertFalse(dict.insert(14, "fourteen"), "Incorrect multiple element insert behavior");
        assertFalse(dict.insert(13, "thirteen"), "Incorrect multiple element insert behavior");
        assertFalse(dict.insert(6, "six"), "Incorrect multiple element insert behavior");
        assertFalse(dict.insert(4, "four"), "Incorrect multiple element insert behavior");
        assertFalse(dict.insert(7, "seven"), "Incorrect multiple element insert behavior");

        assertEquals("six", dict.find(6), "Incorrect multiple element insert behavior");
        assertEquals("four", dict.find(4), "Incorrect multiple element insert behavior");
        assertEquals("seven", dict.find(7), "Incorrect multiple element insert behavior");
        assertEquals("twelve", dict.find(12), "Incorrect multiple element insert behavior");
        assertEquals("fourteen", dict.find(14), "Incorrect multiple element insert behavior");
        assertEquals("thirteen", dict.find(13), "Incorrect multiple element insert behavior");
    }

    @Test
    void multipleElementInsertDuplicate() throws NullValueException {
        ProjOneDictionary<Integer, String> dict = newDictionary();

        assertFalse(dict.insert(12, "twelve"), "Incorrect multiple element insert behavior");
        assertFalse(dict.insert(14, "fourteen"), "Incorrect multiple element insert behavior");
        assertFalse(dict.insert(13, "thirteen"), "Incorrect multiple element insert behavior");
        assertFalse(dict.insert(6, "six"), "Incorrect multiple element insert behavior");
        assertFalse(dict.insert(4, "four"), "Incorrect multiple element insert behavior");
        assertFalse(dict.insert(7, "seven"), "Incorrect multiple element insert behavior");
        assertTrue(dict.insert(13, "trece"), "Incorrect multiple element insert behavior");

        assertEquals("six", dict.find(6), "Incorrect multiple element insert behavior");
        assertEquals("four", dict.find(4), "Incorrect multiple element insert behavior");
        assertEquals("seven", dict.find(7), "Incorrect multiple element insert behavior");
        assertEquals("twelve", dict.find(12), "Incorrect multiple element insert behavior");
        assertEquals("fourteen", dict.find(14), "Incorrect multiple element insert behavior");
        assertNotEquals("thirteen", dict.find(13), "Incorrect multiple element insert behavior");
        assertEquals("trece", dict.find(13), "Incorrect multiple element insert behavior");
    }

    @Test
    void multipleElementInsertDuplicates() throws NullValueException {
        ProjOneDictionary<Integer, String> dict = newDictionary();

        assertFalse(dict.insert(12, "twelve"), "Incorrect multiple element insert behavior");
        assertFalse(dict.insert(14, "fourteen"), "Incorrect multiple element insert behavior");
        assertFalse(dict.insert(13, "thirteen"), "Incorrect multiple element insert behavior");
        assertFalse(dict.insert(6, "six"), "Incorrect multiple element insert behavior");
        assertFalse(dict.insert(4, "four"), "Incorrect multiple element insert behavior");
        assertFalse(dict.insert(7, "seven"), "Incorrect multiple element insert behavior");
        assertTrue(dict.insert(13, "trece"), "Incorrect multiple element insert behavior");
        assertTrue(dict.insert(6, "seis"), "Incorrect multiple element insert behavior");
        assertTrue(dict.insert(12, "doce"), "Incorrect multiple element insert behavior");
        assertTrue(dict.insert(12, "t"), "Incorrect multiple element insert behavior");

        assertNotEquals("six", dict.find(6), "Incorrect multiple element insert behavior");
        assertEquals("four", dict.find(4), "Incorrect multiple element insert behavior");
        assertEquals("seven", dict.find(7), "Incorrect multiple element insert behavior");
        assertNotEquals("twelve", dict.find(12), "Incorrect multiple element insert behavior");
        assertEquals("fourteen", dict.find(14), "Incorrect multiple element insert behavior");
        assertNotEquals("thirteen", dict.find(13), "Incorrect multiple element insert behavior");
        assertEquals("trece", dict.find(13), "Incorrect multiple element insert behavior");
        assertEquals("seis", dict.find(6), "Incorrect multiple element insert behavior");
        assertNotEquals("doce", dict.find(12), "Incorrect multiple element insert behavior");
        assertEquals("t", dict.find(12), "Incorrect multiple element insert behavior");

    }

    @Test
    void multipleElementGetSize () throws NullValueException {
        ProjOneDictionary<Integer, String> dict = newDictionary();
        dict.insert(12, "twelve");
        dict.insert(14, "fourteen");
        dict.insert(13, "thirteen");
        dict.insert(6, "six");
        dict.insert(4, "four");
        dict.insert(7, "seven");

        assertEquals(6, dict.getSize(), "Incorrect multiple getSize behavior");
    }

    @Test
    void multipleElementGetSizeDuplicate () throws NullValueException {
        ProjOneDictionary<Integer, String> dict = newDictionary();
        dict.insert(12, "twelve");
        dict.insert(14, "fourteen");
        dict.insert(13, "thirteen");
        dict.insert(6, "six");
        dict.insert(4, "four");
        dict.insert(7, "seven");
        dict.insert(4, "cuatro");

        assertEquals(6, dict.getSize(), "Incorrect multiple getSize behavior");
    }

    @Test
    void multipleElementGetSizeDuplicates () throws NullValueException {
        ProjOneDictionary<Integer, String> dict = newDictionary();
        dict.insert(12, "twelve");
        dict.insert(14, "fourteen");
        dict.insert(13, "thirteen");
        dict.insert(6, "six");
        dict.insert(4, "four");
        dict.insert(7, "seven");

        dict.insert(4, "cuatro");
        dict.insert(12, "doce");
        dict.insert(13, "trece");

        assertEquals(6, dict.getSize(), "Incorrect multiple getSize behavior");
    }

    @Test
    void multipleElementGetSizeDelete () throws NullValueException {
        ProjOneDictionary<Integer, String> dict = newDictionary();
        dict.insert(12, "twelve");
        dict.insert(14, "fourteen");
        dict.insert(13, "thirteen");
        dict.insert(6, "six");
        dict.insert(4, "four");
        dict.insert(7, "seven");

        dict.insert(4, "cuatro");
        dict.insert(12, "doce");
        dict.insert(13, "trece");

        dict.delete(14);
        dict.delete(7);

        assertEquals(4, dict.getSize(), "Incorrect multiple getSize behavior");
    }

    @Test
    void multipleElementDelete () throws NullValueException {
        ProjOneDictionary<Integer, String> dict = newDictionary();

        dict.insert(12, "twelve");
        dict.insert(14, "fourteen");
        dict.insert(13, "thirteen");
        dict.insert(6, "six");
        dict.insert(4, "four");
        dict.insert(7, "seven");

        assertTrue(dict.delete(6), "Incorrect multiple element delete");
        assertTrue(dict.delete(13), "Incorrect multiple element delete");
        assertTrue(dict.delete(12), "Incorrect multiple element delete");
        assertTrue(dict.delete(7), "Incorrect multiple element delete");
        assertTrue(dict.delete(14), "Incorrect multiple element delete");
        assertTrue(dict.delete(4), "Incorrect multiple element delete");


        assertNull(dict.find(6), "Incorrect multiple element delete");
        assertNull(dict.find(13), "Incorrect multiple element delete");
        assertNull(dict.find(12), "Incorrect multiple element delete");
        assertNull(dict.find(7), "Incorrect multiple element delete");
        assertNull(dict.find(14), "Incorrect multiple element delete");
        assertNull(dict.find(4), "Incorrect multiple element delete");


        assertEquals(0, dict.getSize(), "Incorrect multiple element delete");
        assertNotEquals(6, dict.getSize(), "Incorrect multiple element delete");
    }

    @Test
    void multipleElementDoubleDelete () throws NullValueException {
        ProjOneDictionary<Integer, String> dict = newDictionary();

        dict.insert(12, "twelve");
        dict.insert(14, "fourteen");
        dict.insert(13, "thirteen");
        dict.insert(6, "six");
        dict.insert(4, "four");
        dict.insert(7, "seven");

        assertTrue(dict.delete(6), "Incorrect multiple element delete");
        assertTrue(dict.delete(12), "Incorrect multiple element delete");
        assertTrue(dict.delete(7), "Incorrect multiple element delete");


        assertNull(dict.find(6), "Incorrect multiple element delete");
        assertNull(dict.find(12), "Incorrect multiple element delete");
        assertNull(dict.find(7), "Incorrect multiple element delete");

        assertEquals("fourteen", dict.find(14), "Incorrect multiple element delete");
        assertEquals("four", dict.find(4), "Incorrect multiple element delete");
        assertEquals("thirteen", dict.find(13), "Incorrect multiple element delete");

        // deleting 12 again
        assertFalse(dict.delete(12), "Incorrect multiple element delete");

        assertEquals(3, dict.getSize(), "Incorrect multiple element delete");
        assertNotEquals(6, dict.getSize(), "Incorrect multiple element delete");
    }

    @Test
    void multipleElementFind () throws NullValueException {
        ProjOneDictionary<Integer, String> dict = newDictionary();

        dict.insert(12, "twelve");
        dict.insert(14, "fourteen");
        dict.insert(13, "thirteen");
        dict.insert(6, "six");
        dict.insert(4, "four");
        dict.insert(7, "seven");

        assertEquals("six", dict.find(6), "Incorrect multiple element delete");
        assertEquals("twelve", dict.find(12), "Incorrect multiple element delete");
        assertEquals("seven", dict.find(7), "Incorrect multiple element delete");
        assertEquals("fourteen", dict.find(14), "Incorrect multiple element delete");
        assertEquals("four", dict.find(4), "Incorrect multiple element delete");
        assertEquals("thirteen", dict.find(13), "Incorrect multiple element delete");

    }

    @Test
    void multipleElementFindDuplicate () throws NullValueException {
        ProjOneDictionary<Integer, String> dict = newDictionary();

        dict.insert(12, "twelve");
        dict.insert(14, "fourteen");
        dict.insert(13, "thirteen");
        dict.insert(6, "six");
        dict.insert(4, "four");
        dict.insert(7, "seven");

        dict.insert(7, "siete");

        assertEquals("six", dict.find(6), "Incorrect multiple element delete");
        assertEquals("twelve", dict.find(12), "Incorrect multiple element delete");
        assertEquals("fourteen", dict.find(14), "Incorrect multiple element delete");
        assertEquals("four", dict.find(4), "Incorrect multiple element delete");
        assertEquals("thirteen", dict.find(13), "Incorrect multiple element delete");

        assertNotEquals("seven", dict.find(7), "Incorrect multiple element delete");
        assertEquals("siete", dict.find(7), "Incorrect multiple element delete");

    }

    @Test
    void multipleElementFindDuplicates () throws NullValueException {
        ProjOneDictionary<Integer, String> dict = newDictionary();

        dict.insert(12, "twelve");
        dict.insert(14, "fourteen");
        dict.insert(13, "thirteen");
        dict.insert(6, "six");
        dict.insert(4, "four");
        dict.insert(7, "seven");

        dict.insert(7, "siete");
        dict.insert(12, "doce");
        dict.insert(14, "catorce");

        assertEquals("six", dict.find(6), "Incorrect multiple element delete");
        assertEquals("four", dict.find(4), "Incorrect multiple element delete");
        assertEquals("thirteen", dict.find(13), "Incorrect multiple element delete");

        assertNotEquals("seven", dict.find(7), "Incorrect multiple element delete");
        assertEquals("siete", dict.find(7), "Incorrect multiple element delete");

        assertEquals("catorce", dict.find(14), "Incorrect multiple element delete");
        assertNotEquals("fourteen", dict.find(14), "Incorrect multiple element delete");

        assertNotEquals("twelve", dict.find(12), "Incorrect multiple element delete");
        assertEquals("doce", dict.find(12), "Incorrect multiple element delete");

    }

    @Test
    void multipleElementFindDelete () throws NullValueException {
        ProjOneDictionary<Integer, String> dict = newDictionary();

        dict.insert(12, "twelve");
        dict.insert(14, "fourteen");
        dict.insert(13, "thirteen");
        dict.insert(6, "six");
        dict.insert(4, "four");
        dict.insert(7, "seven");

        dict.insert(7, "siete");
        dict.insert(12, "doce");
        dict.insert(14, "catorce");

        dict.delete(6);

        assertNotEquals("six", dict.find(6), "Incorrect multiple element delete");

        assertEquals("four", dict.find(4), "Incorrect multiple element delete");
        assertEquals("thirteen", dict.find(13), "Incorrect multiple element delete");

        assertNotEquals("seven", dict.find(7), "Incorrect multiple element delete");
        assertEquals("siete", dict.find(7), "Incorrect multiple element delete");

        assertEquals("catorce", dict.find(14), "Incorrect multiple element delete");
        assertNotEquals("fourteen", dict.find(14), "Incorrect multiple element delete");

        assertNotEquals("twelve", dict.find(12), "Incorrect multiple element delete");
        assertEquals("doce", dict.find(12), "Incorrect multiple element delete");

    }

    @Test
    void multipleElementDelete2 () throws NullValueException {
        ProjOneDictionary<Integer, String> dict = newDictionary();
        
        dict.insert(100, "one hundred");
        dict.insert(50, "fifty");
        dict.insert(150, "one hundred fifty");
        dict.insert(40, "forty");
        dict.insert(41, "forty one");
        dict.insert(140, "one hundred forty");
        dict.insert(160, "one hundred sixty");
        dict.insert(139, "one hundred thirty nine");
        dict.insert(141, "one hundred forty one");
        dict.insert(151, "one hundred fifty one");
        dict.insert(161, "one hundred sixty one");

        assertTrue(dict.delete(100), "Incorrect multiple element delete 2");
        assertTrue(dict.delete(150), "Incorrect multiple element delete 2");
        assertTrue(dict.delete(141), "Incorrect multiple element delete 2");
        assertTrue(dict.delete(139), "Incorrect multiple element delete");
        assertTrue(dict.delete(160), "Incorrect multiple element delete");
        assertTrue(dict.delete(40), "Incorrect multiple element delete");
        assertTrue(dict.delete(41), "Incorrect multiple element delete");
        assertTrue(dict.delete(50), "Incorrect multiple element delete");
        assertTrue(dict.delete(140), "Incorrect multiple element delete");
        assertTrue(dict.delete(161), "Incorrect multiple element delete");
        assertTrue(dict.delete(151), "Incorrect multiple element delete");
    }

    @Test
    void multipleElementDelete3 () throws NullValueException {
        ProjOneDictionary<Integer, String> dict = newDictionary();
        
        dict.insert(100, "one hundred");
        dict.insert(50, "fifty");
        dict.insert(150, "one hundred fifty");
        dict.insert(40, "forty");
        dict.insert(41, "forty one");
        dict.insert(140, "one hundred forty");
        dict.insert(160, "one hundred sixty");
        dict.insert(139, "one hundred thirty nine");
        dict.insert(141, "one hundred forty one");
        dict.insert(151, "one hundred fifty one");
        dict.insert(161, "one hundred sixty one");

        assertTrue(dict.delete(139), "Incorrect multiple element delete");
        assertTrue(dict.delete(160), "Incorrect multiple element delete");
        assertTrue(dict.delete(100), "Incorrect multiple element delete");

        assertNull(dict.find(139), "Incorrect multiple element delete");
        assertNull(dict.find(160), "Incorrect multiple element delete");
        assertNull(dict.find(100), "Incorrect multiple element delete");

        assertEquals("one hundred fifty one", dict.find(151), "Incorrect multiple element delete");
        assertEquals("forty", dict.find(40), "Incorrect multiple element delete");
        assertEquals("fifty", dict.find(50), "Incorrect multiple element delete");

    }

    @Test
    void massiveElementDelete() throws NullValueException{
        ProjOneDictionary<Integer,String> dict = newDictionary();
        
        for (int i = 0; i < 1000; i++) {
            assertFalse(dict.insert(i, "a"), "Incorrect massive element delete behavior");
        }
        
        for (int i = 0; i < 1000; i++) {
            assertTrue(dict.delete(i), "Incorrect massive element delete behavior");
        }

        for(int i = 0; i < 1000; i++) {
            assertNull(dict.find(i), "Incorrect massive element delete behavior");
        }
    }
}