import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

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
}
