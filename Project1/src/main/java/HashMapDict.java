import java.util.Iterator;

public class HashMapDict<K,V> implements ProjOneDictionary<K,V> {
    private int currentSize = 10;
    private Node<K, V>[] map = new Node[currentSize];
    private int size = 0;

    private class Node<K, V> {
        K key;
        V value;

        Node(K newKey, V newValue) {
            super();
            key = newKey;
            value = newValue;
        }
    }

    private class HashIterator<K> implements Iterator<K> {

        private int currIndex = 0;
        private Node<K, V> curr;
        public HashIterator(Node<K,V>[] map){
            for(int i = currIndex; i < map.length; i++){
                if(map[i] == null){
                    currIndex++;
                }
                else{
                    break;
                }
            }

            if(currIndex < map.length){
                curr = map[currIndex];
            }
        }

        @Override
        public boolean hasNext() {
            if(curr == null){
                return false;
            }
            return true;
        }

        @Override
        public K next() {
            K key = curr.key;

            // go to next element
            currIndex++;
            // iterate to the next non-null entry
            // if currIndex is not less than the length this means it is out of range and there is no more
            // indexes to go through
            for(int i = currIndex; i < map.length; i++){
                if(map[i] == null) {
                    currIndex++;
                }
                else{
                    break;
                }
            }

            // if currIndex is less than the length then make curr equal the to value of currIndex
            if(currIndex < map.length){
                curr = (Node<K, V>) map[currIndex];
            }
            else{
                curr = null;
            }

            return key;
        }
    }

    private void resizeMap(Node<K, V>[] map, int currentSize) {
        int newSize = currentSize * 2;
        Node<K, V>[] tempMap = new Node[newSize];


        for (int i = 0; i < currentSize; i++) {
            if (map[i] == null) {
                continue;
            }
            Node<K, V> nodeToInsert = map[i];
            tempMap[i] = nodeToInsert;
        }

        this.map = tempMap;
        this.currentSize = newSize;
    }


    @Override
    public boolean insert(K key, V value) throws NullValueException {
        if (value == null) {
            throw new NullValueException();
        }

        Node<K, V> nodeToInsert = new Node(key, value);

        int indexToBePlaced = key.hashCode() % map.length; // finds the index where Node is to be placed
        System.out.println("Result of indexToBePlaced: " + indexToBePlaced);

        // REMEMBER TO RESIZING


        // works without resizing so far

//        System.out.println("Before the insert if there is already an element");

        int i = indexToBePlaced; // checking if key to be inserted already exists
//        if (i < currentSize) {
        while (i < currentSize && map[i] != null) {

            if (map[i].key.equals(key)) {
                map[i].value = value;
//                System.out.println("Result of value after insertion: " + map[indexToBePlaced].value);
                return true;
            }
            i++; //= (i + 1) % currentSize;
        }
//        }
//        while (map[i] != null && i < currentSize) {
//            if (map[i].key.equals(key)) {
//                map[i].value = value;
//                System.out.println("Result of value after insertion: " + map[indexToBePlaced].value);
//                return true;
//            }
//            i++; //= (i + 1) % currentSize;
//        }

        if (map[indexToBePlaced] == null) {
            map[indexToBePlaced] = nodeToInsert;
            size++;
        } else {
            // COLLISION!! LINEAR PROBING!!!
            i = 1;
            while (map[indexToBePlaced] != null) {
                indexToBePlaced = (key.hashCode() + i) % map.length; // ex. if key being inserted is 12 which should go at index 2 but index two but index 2 is full go to next available index
//                System.out.println("Result of indexToBePlaced at collision: " + indexToBePlaced);

                // resize will occur
                // here check if indexToBePlaced is bigger than currentSize then double it
                // create new hashmap of that size and copy everything from the first map to the new one
                // finally set the old one to be equal to the new one
                // do this is in a separate function that way this one doesn't get too long

//                System.out.println(indexToBePlaced);
//                System.out.println(map.length);
//                System.exit(0);

                // resizing once the hashmap has run out of space
                if (indexToBePlaced + 1 == map.length) {
//                    System.out.println("going to resize");
                    resizeMap(map, currentSize);
//                    System.out.println("YELLO " + currentSize);
                    //System.exit(0);
//                    break;

                }
                i++;
            }

            map[indexToBePlaced] = nodeToInsert;
            size++;
        }

//        System.out.println("Result of value after insertion: " + map[indexToBePlaced].value);
        return false;
    }

    @Override
    public V find(K key) {

        for (int i = 0; i < currentSize; i++) {
            if (map[i] != null) {
                if (map[i].key.equals(key)) {
                    return map[i].value;
                }
            }
        }

//        int i = key.hashCode() % map.length;
//        while (i < currentSize && map[i] != null) {
//            if (map[i].key.equals(key)) {
//                return map[i].value;
//            }
//            i++;
//        }

        return null;
    }

    // return true when there is an element found that can be deleted
    @Override
    public boolean delete(K key) {
        for (int i = 0; i < currentSize; i++) {
            if (map[i] != null) {
                if (map[i].key.equals(key)) {
                    map[i] = null;
                    size--;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Iterator<K> iterator() {
        return new HashIterator<>(map);
    }
}