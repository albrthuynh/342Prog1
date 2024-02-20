import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BSTTest extends DictionaryTest {
    @Override
    public ProjOneDictionary<Integer, String> newDictionary() {
        return new BinarySearchTreeDict<Integer,String>();
    }

    @Test
    void singleElementInsert() throws NullValueException {
        ProjOneDictionary<Integer, String> BST = newDictionary();
        BST.insert(3, "three");
        assertEquals("three", BST.find(3), "Incorrect single element insert behavior");
    }

    @Test
    void multipleElementInsert() throws NullValueException {
        ProjOneDictionary<Integer, String> BST = newDictionary();
        BST.insert(6, "six");
        BST.insert(4, "four");
        BST.insert(7, "seven");

        assertEquals("six", BST.find(6), "Incorrect multiple element insert behavior");
        assertEquals("four", BST.find(4), "Incorrect multiple element insert behavior");
        assertEquals("seven", BST.find(7), "Incorrect multiple element insert behavior");
    }
}
