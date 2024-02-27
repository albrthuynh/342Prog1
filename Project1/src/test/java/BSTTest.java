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
        assertFalse(BST.insert(3, "three"), "Incorrect single insert return statement");
        assertEquals("three", BST.find(3), "Incorrect single element insert behavior");

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

        assertTrue(iter.hasNext(), "Incorrect single element hasNext Iterator behavior");
        assertEquals(100,iter.next(), "Incorrect single element iterator behavior");

        assertTrue(iter.hasNext(), "Incorrect single element hasNext Iterator behavior");
        assertEquals(50,iter.next(), "Incorrect single element iterator behavior");

        assertTrue(iter.hasNext(), "Incorrect single element hasNext Iterator behavior");
        assertEquals(150,iter.next(), "Incorrect single element iterator behavior");

        assertTrue(iter.hasNext(), "Incorrect single element hasNext Iterator behavior");
        assertEquals(40,iter.next(), "Incorrect single element iterator behavior");

        assertTrue(iter.hasNext(), "Incorrect single element hasNext Iterator behavior");
        assertEquals(140,iter.next(), "Incorrect single element iterator behavior");

        assertTrue(iter.hasNext(), "Incorrect single element hasNext Iterator behavior");
        assertEquals(160,iter.next(), "Incorrect single element iterator behavior");

        assertTrue(iter.hasNext(), "Incorrect single element hasNext Iterator behavior");
        assertEquals(41,iter.next(), "Incorrect single element iterator behavior");

        assertTrue(iter.hasNext(), "Incorrect single element hasNext Iterator behavior");
        assertEquals(139,iter.next(), "Incorrect single element iterator behavior");
        assertTrue(iter.hasNext(), "Incorrect single element hasNext Iterator behavior");
        assertEquals(141,iter.next(), "Incorrect single element iterator behavior");

        assertTrue(iter.hasNext(), "Incorrect single element hasNext Iterator behavior");
        assertEquals(151,iter.next(), "Incorrect single element iterator behavior");
        assertTrue(iter.hasNext(), "Incorrect single element hasNext Iterator behavior");
        assertEquals(161,iter.next(), "Incorrect single element iterator behavior");

        assertFalse(iter.hasNext(),"Incorrect single element hasNext Iterator behavior");
    }

}
