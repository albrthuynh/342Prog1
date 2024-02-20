import java.util.Iterator;

public class BinarySearchTreeDict<K extends Comparable<K>,V> implements ProjOneDictionary<K,V> {
    private int size = 0;
    private boolean isDuplicate = false;
    private Node root = null;

    private class Node {
        K key;
        V value;
        Node left;
        Node right;
        Node parent; // is this needed???
        boolean isDuplicate = false;

        Node (K newKey, V newValue) {
            super();
            key = newKey;
            value = newValue;
            left = null;
            right = null;
            parent = null;
        }
    }

    private boolean recursiveInsertion (Node current, K key, V value) {
        if (key.compareTo(current.key) < 0) {
            // go left
            if (current.left != null) {
                // keep going into a null spot is found
                return recursiveInsertion(current.left, key, value);
            }
            else {
                current.left = new Node(key, value);
                size++;
                return false;
            }
        }
        else if (key.compareTo(current.key) > 0) {
            // gor right
            if (current.right != null) {
                return recursiveInsertion(current.right, key, value);
            }
            else {
                current.right = new Node(key, value);
                size++;
                return false;
            }
        }
        else {
            // key already exists
            current.value = value;
            return true;
        }
    }

    private Node recursiveSearch (Node current, K key) {
        // if root is null then key wasn't found
        if (current == null) {
            return current;
        }
        else if (key.compareTo(current.key) == 0) {
            return current;
        }
        else if (key.compareTo(current.key) < 0) {
            return recursiveSearch(current.left, key);
        }
        else {
             return recursiveSearch(current.right, key);
        }
    }

    @Override
    public boolean insert(K key, V value) throws NullValueException {

        if (value == null) {
            throw new NullValueException();
        }

        if (root == null) {
            root = new Node(key, value);
            size++;
            return false;
        }
        else {
            return recursiveInsertion(root, key, value);
        }

    }

    @Override
    public V find(K key) {
        Node foundValue = recursiveSearch(root, key);
        
        if (foundValue != null) {
            return foundValue.value;
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
