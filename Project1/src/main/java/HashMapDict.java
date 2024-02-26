import java.util.Iterator;

public class HashMapDict<K,V> implements ProjOneDictionary<K,V> {
    private Node<K,V>[] map = new Node[10];
    private int size = 0;

    private class Node <K,V> {
        K key;
        V value;

        Node (K newKey, V newValue) {
            super();
            key = newKey;
            value = newValue;
        }
    }



    @Override
    public boolean insert(K key, V value) throws NullValueException {
        if (value == null) {throw new NullValueException();}

        Node <K,V> nodeToInsert = new Node(key, value);

        int indexToBePlaced = Math.abs(key.hashCode() % map.length); // finds the index where Node is to be placed
        System.out.println("Result of indexToBePlaced: " + indexToBePlaced);

        // REMEMBER TO ADD DUPLICATES CASE AND RESIZING

        if (map[indexToBePlaced] == null) {
            map[indexToBePlaced] = nodeToInsert;
            size++;
        }
        else {
            // COLLISION!! LINEAR PROBING!!!
        }


        return false;
    }

    @Override
    public V find(K key) {
        return null;
    }

    @Override
    public boolean delete(K key) {
        return false;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Iterator<K> iterator() {
        return null;
    }
}
