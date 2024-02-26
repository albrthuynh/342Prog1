import java.util.Iterator;

public class HashMapDict<K,V> implements ProjOneDictionary<K,V> {
    private int currentSize = 10;
    private Node<K,V>[] map = new Node[currentSize];
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

        int indexToBePlaced = key.hashCode() % map.length; // finds the index where Node is to be placed
        System.out.println("Result of indexToBePlaced: " + indexToBePlaced);

        // REMEMBER TO RESIZING


        // works without resizing so far

        int i = indexToBePlaced; // checking if key to be inserted already exists
        while (map[i] != null) {
            if (map[i].key.equals(key)) {
                map[i].value = value;
                System.out.println("Result of value after insertion: " + map[indexToBePlaced].value);
                return true;
            }
            i++; //= (i + 1) % currentSize;
        }

        if (map[indexToBePlaced] == null) {
            map[indexToBePlaced] = nodeToInsert;
            size++;
        }
        else {
            // COLLISION!! LINEAR PROBING!!!
            i = 1;
            while (map[indexToBePlaced] != null) {
                indexToBePlaced = (key.hashCode() + i) % map.length; // ex. if key being inserted is 12 which should go at index 2 but index two but index 2 is full go to next available index
                System.out.println("Result of indexToBePlaced at collision: " + indexToBePlaced);
                i++;
            }

            map[indexToBePlaced] = nodeToInsert;
            size++;
        }

        System.out.println("Result of value after insertion: " + map[indexToBePlaced].value);
        return false;
    }

    @Override
    public V find(K key) {

        int i = key.hashCode() % map.length;
        while (map[i] != null) {
            if (map[i].key.equals(key)) {
                return map[i].value;
            }
            i++;
        }

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