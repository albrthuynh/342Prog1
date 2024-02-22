import java.util.Iterator;

public class BinarySearchTreeDict<K extends Comparable<K>,V> implements ProjOneDictionary<K,V> {

    private int size = 0;
    private boolean isDuplicate = false;

    private Node root;

    private class Node {
        Node left;
        Node right;
        Node parent;
        K key;
        V value;

        Node() {
            super();
        }

        Node(K newKey, V newVal) {
            super();
            key = newKey;
            value = newVal;

            parent = null;
            left = null;
            right = null;
            root = null;
        }
    }

    private Node RecursiveInsertion(Node root, Node add) {
        if(root == null) {
            root = add;
            size++;
            System.out.println("ROOT CHANGED");
            System.out.println(" Root is " + root.key);
            return root;
        }
        else if(root.key.compareTo(add.key) == 0){
            root.value = add.value;
            isDuplicate = true;
        }
        else if(add.key.compareTo(root.key) < 0) {
            root.left = RecursiveInsertion(root.left, add);
            isDuplicate = false;
            System.out.println("Added the key to the left");
        }
        else if(add.key.compareTo(root.key) > 0) {
            root.right = RecursiveInsertion(root.right, add);
            isDuplicate = false;
            System.out.println("Added the key to the right");
        }

        return root;
    }

    private Node RecursiveSearch(Node root, K key) {
        if(root == null) {
            System.out.println("ROOT NULL");
            return root;
        }

        if(root.key == key) {
            System.out.println("ROOT FOUND");
            return root;
        }

        if(key.compareTo(root.key) < 0) {
            return RecursiveSearch(root.left, key);
        }
        else {
            return RecursiveSearch(root.right, key);
        }
    }

    @Override
    public boolean insert(K key, V value) throws NullValueException {
        if(value == null){ throw new NullValueException();}

        Node add = new Node(key, value);
        System.out.println("New Node Created");

        root = RecursiveInsertion(this.root, add);

        System.out.println("Recursive Insertion Done");
        System.out.println("THIS IS ISDUPLICATE" + isDuplicate);
        System.out.println("The root value " + root.value);

        return isDuplicate;
    }

    @Override
    public V find(K key) {
        System.out.println("Start of find");

        Node foundValue = RecursiveSearch(this.root, key);


        System.out.println("foundValue.value after " + foundValue.value);

        System.out.println("End of find");

        return foundValue.value;
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
