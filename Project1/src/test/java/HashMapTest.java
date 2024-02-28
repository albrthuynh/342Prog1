import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class HashMapTest extends DictionaryTest{
    @Override
    public ProjOneDictionary<Integer, String> newDictionary() {
        return new HashMapDict<Integer,String>();
    }

    @Test
    void singleElementInsert() throws NullValueException {
        ProjOneDictionary<Integer, String> HASHMAP = newDictionary();
        assertFalse(HASHMAP.insert(2, "two"), "Incorrect single insert return statement");
        assertFalse(HASHMAP.insert(12, "twelve"), "Incorrect single insert return statement");
        assertFalse(HASHMAP.insert(3, "three"), "Incorrect single insert return statement");
        assertFalse(HASHMAP.insert(5, "five"), "Incorrect single insert return statement");
        //assertFalse(HASHMAP.insert(12, ""), "Incorrect single insert return statement");
        assertFalse(HASHMAP.insert(13, "thirteen"), "Incorrect single insert return statement");
        assertFalse(HASHMAP.insert(4, "four"), "Incorrect single insert return statement");
        assertFalse(HASHMAP.insert(14, "fourteen"), "Incorrect single insert return statement");
        assertFalse(HASHMAP.insert(10, "ten"), "Incorrect single insert return statement");
        assertFalse(HASHMAP.insert(11, "eleven"), "Incorrect single insert return statement");
        assertFalse(HASHMAP.insert(9, "nine"), "Incorrect single insert return statement");

        assertFalse(HASHMAP.insert(15, "fifteen"), "Incorrect single insert return statement");


        assertEquals("three", HASHMAP.find(3), "Incorrect single element insert behavior");
        assertEquals("fourteen", HASHMAP.find(14), "Incorrect single element insert behavior");
    }

    @Test
    void emptyElementIterator() {
        ProjOneDictionary<Integer, String> hashmap = newDictionary();
        Iterator<Integer> iter = hashmap.iterator();

        assertFalse(iter.hasNext(), "Incorrect empty element hasNext Iterator behavior");
    }

    @Test
    void singleElementIterator() throws NullValueException {
        ProjOneDictionary<Integer, String> HASHMAP = newDictionary();
        assertFalse(HASHMAP.insert(2, "two"), "Incorrect single insert return statement");

        Iterator<Integer> iter = HASHMAP.iterator();

        assertTrue(iter.hasNext(), "Incorrect single element hasNext Iterator behavior");
        assertEquals(2,iter.next(), "Incorrect single element Iterator behavior");
        assertFalse(iter.hasNext(), "Incorrect single element hasNext Iterator behavior");
    }

    @Test
    void multipleElementIterator() throws NullValueException {
        ProjOneDictionary<Integer, String> HASHMAP = newDictionary();
        assertFalse(HASHMAP.insert(2, "two"));
        assertFalse(HASHMAP.insert(12, "twelve"));
        assertFalse(HASHMAP.insert(3, "three"));
        assertFalse(HASHMAP.insert(5, "five"));

        Iterator<Integer> iter = HASHMAP.iterator();

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
}
