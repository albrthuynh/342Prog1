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
    void singleElementInsert() throws NullValueException {
        ProjOneDictionary<Integer, String> BST = newDictionary();
        assertFalse(BST.insert(3, "three"), "Incorrect single insert return statement");
        assertEquals("three", BST.find(3), "Incorrect single element insert behavior");
    }

    @Test
    void multipleElementInsert() throws NullValueException {
        ProjOneDictionary<Integer, String> BST = newDictionary();
        assertFalse(BST.insert(6, "six"), "Incorrect multiple element insert return statement");
        assertFalse(BST.insert(4, "four"), "Incorrect multiple element insert return statement");
        assertFalse(BST.insert(7, "seven"), "Incorrect multiple element insert return statement");

        assertEquals("six", BST.find(6), "Incorrect multiple element insert behavior");
        assertEquals("four", BST.find(4), "Incorrect multiple element insert behavior");
        assertEquals("seven", BST.find(7), "Incorrect multiple element insert behavior");
    }

    @Test
    void multipleElementInsertWithDuplicate() throws NullValueException {
        ProjOneDictionary<Integer, String> BST = newDictionary();
        assertFalse(BST.insert(6, "six"), "Incorrect multiple element insert return statement");
        assertFalse(BST.insert(4, "four"), "Incorrect multiple element insert return statement");
        assertTrue(BST.insert(6, "seven"), "Incorrect multiple element insert return statement");

        assertEquals("seven", BST.find(6), "Incorrect multiple element insert behavior");
        assertEquals("four", BST.find(4), "Incorrect multiple element insert behavior");
        assertNotEquals("six", BST.find(6), "Incorrect multiple element insert behavior");
        assertNotEquals(null, BST.find(6), "Incorrect multiple element insert behavior");
        assertEquals(null, BST.find(5), "Incorrect multiple element insert behavior");
    }

    @Test
    void emptyGetSize() throws NullValueException {
        ProjOneDictionary<Integer, String> BST = newDictionary();

        assertEquals(0, BST.getSize(), "Incorrect empty getSize behavior");
    }

    @Test
    void singleElementGetSize () throws NullValueException {
        ProjOneDictionary<Integer, String> BST = newDictionary();
        BST.insert(6, "six");

        assertEquals(1, BST.getSize(), "Incorrect empty getSize behavior");
    }

    @Test
    void multipleElementGetSize () throws NullValueException {
        ProjOneDictionary<Integer, String> BST = newDictionary();
        BST.insert(6, "six");
        BST.insert(4, "four");
        BST.insert(7, "four");

        assertEquals(3, BST.getSize(), "Incorrect empty getSize behavior");
    }

    @Test
    void emptyDelete () {
        ProjOneDictionary<Integer, String> BST = newDictionary();

        assertFalse(BST.delete(7), "Incorrect multiple element delete");
    }

    @Test
    void singleElementDelete () throws NullValueException {
        ProjOneDictionary<Integer, String> BST = newDictionary();
        BST.insert(6, "six");

        assertTrue(BST.delete(6), "Incorrect single element delete behavior");
        assertEquals(0, BST.getSize(), "Incorrect single element delete behavior");
        assertNull(BST.find(6), "Incorrect single element delete behavior");
        assertFalse(BST.delete(6), "Incorrect single element delete behavior");
    }


    @Test
    void multipleElementDelete () throws NullValueException {
        // deletes all elements
        ProjOneDictionary<Integer, String> BST = newDictionary();
        BST.insert(6, "six");
        BST.insert(4, "four");
        BST.insert(7, "seven");

        assertTrue(BST.delete(6), "Incorrect multiple element delete");
        assertTrue(BST.delete(4), "Incorrect multiple element delete");
        assertTrue(BST.delete(7), "Incorrect multiple element delete");

        assertNull(BST.find(6), "Incorrect multiple element delete");
        assertNull(BST.find(4), "Incorrect multiple element delete");
        assertNull(BST.find(7), "Incorrect multiple element delete");

        assertFalse(BST.delete(6), "Incorrect multiple element delete");
        assertFalse(BST.delete(4), "Incorrect multiple element delete");
        assertFalse(BST.delete(7), "Incorrect multiple element delete");
    }

    @Test
    void multipleElementDelete2 () throws NullValueException {
        // big tree and deleting all elements
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

        assertTrue(BST.delete(100), "Incorrect multiple element delete 2");
        assertTrue(BST.delete(150), "Incorrect multiple element delete 2");
        assertTrue(BST.delete(141), "Incorrect multiple element delete 2");
        assertTrue(BST.delete(139), "Incorrect multiple element delete");
        assertTrue(BST.delete(160), "Incorrect multiple element delete");
        assertTrue(BST.delete(40), "Incorrect multiple element delete");
        assertTrue(BST.delete(41), "Incorrect multiple element delete");
        assertTrue(BST.delete(50), "Incorrect multiple element delete");
        assertTrue(BST.delete(140), "Incorrect multiple element delete");
        assertTrue(BST.delete(161), "Incorrect multiple element delete");
        assertTrue(BST.delete(151), "Incorrect multiple element delete");




    }

    @Test
    void multipleElementDelete3 () throws NullValueException {
        // big tree only deleting some elements
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

        assertTrue(BST.delete(139), "Incorrect multiple element delete");
        assertTrue(BST.delete(160), "Incorrect multiple element delete");
        assertTrue(BST.delete(100), "Incorrect multiple element delete");

        assertNull(BST.find(139), "Incorrect multiple element delete");
        assertNull(BST.find(160), "Incorrect multiple element delete");
        assertNull(BST.find(100), "Incorrect multiple element delete");

        assertEquals("one hundred fifty one", BST.find(151), "Incorrect multiple element delete");
        assertEquals("forty", BST.find(40), "Incorrect multiple element delete");
        assertEquals("fifty", BST.find(50), "Incorrect multiple element delete");

    }
}