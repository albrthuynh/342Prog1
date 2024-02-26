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
        assertFalse(HASHMAP.insert(3, "three"), "Incorrect single insert return statement");
        assertEquals("three", HASHMAP.find(3), "Incorrect single element insert behavior");
    }
}
