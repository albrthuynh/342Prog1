/****************************
 * Program 1: Dictionary
 * <p>
 * Course: CS 342, Spring 2024
 * System: macOS using IntelliJ
 * Starter Code Author: Evan McCarty
 * Student Author: Albert Huynh & Karina Perez
 * <p>
 * ***************************/

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

            // loops through the hashmap until it hits a non-null index
            for(int i = currIndex; i < map.length; i++){
                if (map[i] == null){
                    currIndex++;
                }
                else {
                    break;
                }
            }

            // once that non-null index is found set curr to that node
            // ensures it doesn't go out of bounds of the hashmap
            if (currIndex < map.length){
                curr = map[currIndex];
            }
        }

        @Override
        public boolean hasNext() {

            // returns true if the curr node isn't null (meaning there is a next element)
            // returns false otherwise
            if (curr == null){
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
            for (int i = currIndex; i < map.length; i++){
                if(map[i] == null) {
                    currIndex++;
                }
                else {
                    break;
                }
            }

            // if currIndex is less than the length then make curr equal the to value of currIndex
            if (currIndex < map.length){
                curr = (Node<K, V>) map[currIndex];
            }
            else {
                curr = null;
            }

            return key;
        }
    }

    // resizeMap takes in the hashmap and its current size and resizes the hashmap to accomodate the insertion of multiple elements
    // each time it is resized, the size doubles
    private void resizeMap(Node<K, V>[] map, int currentSize) {
        int newSize = currentSize * 2;
        Node<K, V>[] tempMap = new Node[newSize]; // a temporary map that is bigger than the old map where the old map's contents will be dumped into

        // loops through old map at each index at copies its contents into tempMap
        for (int i = 0; i < currentSize; i++) {
            if (map[i] == null) {
                continue;
            }
            Node<K, V> nodeToInsert = map[i];
            tempMap[i] = nodeToInsert;
        }

        this.map = tempMap; // the old map is then set to now be the new map with a bigger size aka tempMap
        this.currentSize = newSize;
    }


    @Override
    public boolean insert(K key, V value) throws NullValueException {
        if (value == null) {
            throw new NullValueException();
        }

        Node<K, V> nodeToInsert = new Node(key, value);

        int indexToBePlaced = key.hashCode() % map.length; // finds the index where Node is to be placed in the hashmap

        // goes through the map and checks if the key to be inserted is a duplicate or not
        int i = indexToBePlaced;
        while (i < currentSize && map[i] != null) {
            if (map[i].key.equals(key)) {
                map[i].value = value;
                return true;
            }
            i++;
        }

        // inserts node if its hash index is null
        if (map[indexToBePlaced] == null) {
            map[indexToBePlaced] = nodeToInsert;
            size++;
        }

        // node's hash index isn't null so a collision has occurred
        // the node will be placed in the next available index
        else {
            i = 1;
            while (map[indexToBePlaced] != null) {

                // recalculates the node's hash index adding one each time if the next available spot
                indexToBePlaced = (key.hashCode() + i) % map.length;

                // if the node's hash index is out of bounds then resizeMap is called
                if (indexToBePlaced + 1 == map.length) {
                    resizeMap(map, currentSize);
                }
                i++;
            }

            // node is inserted at the next available spot
            map[indexToBePlaced] = nodeToInsert;
            size++;
        }

        return false;
    }

    @Override
    public V find(K key) {

        // loops through the hashmap in search of the node with the key value that is passed in
        // returns true if it is found and false if not
        for (int i = 0; i < currentSize; i++) {
            if (map[i] != null && map[i].key.equals(key)) {
                return map[i].value;
            }
        }

        return null;
    }

    @Override
    public boolean delete(K key) {

        // loops through the hashmap in search of the node with the key passed in
        // if found deletes it by setting that index to null and returns true
        // returns false otherwise
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
