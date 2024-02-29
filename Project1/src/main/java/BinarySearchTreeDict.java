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

public class BinarySearchTreeDict<K extends Comparable<K>,V> implements ProjOneDictionary<K,V> {
    private int size = 0;
    private Node root = null;

    private class Node {
        K key;
        V value;
        Node left;
        Node right;
        Node parent;

        Node (K newKey, V newValue) {
            super();
            key = newKey;
            value = newValue;
            left = null;
            right = null;
            parent = null;
        }
    }

    // breadth First Search on Binary Tree
    private class BFS<K> implements Iterator<K> {
        private ListQueue<Node> queue;

        // constructor for BST iterator, inserting root for iteration
        public BFS(Node root) {
            queue = new ListQueue<>();
            if (root != null) {
                queue.enqueue(root);
            }
        }

        // returning true if the iterator has more elements to iterate through
        @Override
        public boolean hasNext() {
            if (queue.isEmpty()){
                return false;
            }
            return true;
        }

        // getting the next key to iterate through and returning the current key
        @Override
        public K next() {
            Node toKey = queue.dequeue();

            // if left key exists then add left key to the queue
            if (toKey.left != null) {
                queue.enqueue(toKey.left);
            }

            // if right key exists then add right key to the queue
            if (toKey.right != null) {
                queue.enqueue(toKey.right);
            }

            return (K) toKey.key;
        }
    }

    // using recursion for insertion to find the correct placement of a node
    private boolean recursiveInsertion (Node current, K key, V value) {
        if (key.compareTo(current.key) < 0) {
            // go left
            if (current.left != null) {
                // keep going into a null spot is found
                return recursiveInsertion(current.left, key, value);
            }
            else {
                current.left = new Node(key, value);
                current.left.parent = current;
                size++;
                return false;
            }
        }
        else if (key.compareTo(current.key) > 0) {
            // go right
            if (current.right != null) {
                return recursiveInsertion(current.right, key, value);
            }
            else {
                current.right = new Node(key, value);
                current.right.parent = current;
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

    // using recursion to search for a node given a key
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

    // returns the next node based off the position of the current node
    private Node successor(Node root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // goes to the previous node based off the position of the current node
    private Node predecessor(Node root){
        root = root.left;
        while (root.right != null){
            root = root.right;
        }
        return root;
    }

    // recursiveDelete (recursively deletes a node)
    // returns false when it doesn't find the node to delete
    // returns true when it does find the node to delete
    private boolean recursiveDelete(Node curr, K key){

        // key not found
        if (curr == null) {
            return false;
        }

        // finding key
        if (key.compareTo(curr.key) > 0) {
            return recursiveDelete(curr.right, key);
        }
        else if (key.compareTo(curr.key) < 0) {
            return recursiveDelete(curr.left, key);
        }

        // key found
        else {

            // delete if leaf node
            if (curr.right == null && curr.left == null){

                if (curr.parent != null) {
                    if (curr.parent.right == curr) {
                        curr.parent.right = null;
                    }
                    else if (curr.parent.left == curr) {
                        curr.parent.left = null;
                    }
                }
                else {
                    root = null;
                }

                size--;
                return true;
            }
            // if curr has a right child
            else if (curr.right != null) {
                curr.key = successor(curr).key;
                curr.value = successor(curr).value;
                return recursiveDelete(curr.right, curr.key);
            }
            // if curr has left child
            else {
                curr.key = predecessor(curr).key;
                curr.value = predecessor(curr).value;
                return recursiveDelete(curr.left, curr.key);
            }
        }
    }

    // insert a node given a key and value into the binary search tree
    @Override
    public boolean insert(K key, V value) throws NullValueException {

        if (value == null) {
            throw new NullValueException();
        }

        if (root == null) {
            root = new Node(key, value);
            root.parent = null;
            size++;
            return false;
        }
        else {
            return recursiveInsertion(root, key, value);
        }

    }

    // given a key, return the value of the node based off the key
    @Override
    public V find(K key) {
        Node foundValue = recursiveSearch(root, key);

        if (foundValue != null) {
            return foundValue.value;
        }

        return null;
    }

    // deleting a node given the key of the node
    @Override
    public boolean delete(K key) {
        if (root == null){
            return false;
        }

        boolean isDeleted = recursiveDelete(root, key);

        if (isDeleted) {
            return true;
        }

        return false;
    }

    // returning current size of the BST
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Iterator<K> iterator() {
        return new BFS<>(root);
    }
}
