import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

public class BSTTest extends DictionaryTest {
    @Override
    public ProjOneDictionary<Integer, String> newDictionary() {
        return new BinarySearchTreeDict<Integer,String>();
    }

    @Test
    void IteratorTestSingle() throws NullValueException {
        ProjOneDictionary<Integer, String> BST = newDictionary();
        assertFalse(BST.insert(3, "three"), "Incorrect single insert return statement");
        assertEquals("three", BST.find(3), "Incorrect single element insert behavior");

        Iterator<Integer> iter = BST.iterator();

        assertTrue(iter.hasNext(), "Incorrect single element hasNext Iterator behavior");
        assertEquals(3,iter.next(), "Incorrect single element iterator behavior");
    }

}
