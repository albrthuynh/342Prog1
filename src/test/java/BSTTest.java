import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BSTTest extends DictionaryTest {
    @Override
    public ProjOneDictionary<Integer, String> newDictionary() {
        return new BinarySearchTreeDict<Integer,String>();
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

}
