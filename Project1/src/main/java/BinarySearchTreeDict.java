import java.util.Iterator;

public class BinarySearchTreeDict<K extends Comparable<K>,V> implements ProjOneDictionary<K,V> {
    private int size = 0;
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
                current.left.parent = current;
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

    private Node successor(Node root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        
        return root;
    }
    
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
            System.out.println("KEY WASNT FOUND");
            return false;
        }

        // finding key
        if (key.compareTo(curr.key) > 0) {
            System.out.println("KEY IS GREATER THAN CURR SO GO RIGHT");
            return recursiveDelete(curr.right, key);
        }
        else if (key.compareTo(curr.key) < 0) {
            System.out.println("KEY IS LESS THAN CURR SO GO LEFT");
            return recursiveDelete(curr.left, key);
        }

        // key found!!!
        else {

            // delete if leaf node
            if (curr.right == null && curr.left == null){

                if (curr.parent != null) {
                    //If the parent right is the same as the current node then delete
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

        //return true;
    }

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
        if (root == null){
            return false;
        }

        boolean isDeleted = recursiveDelete(root, key);

        if (isDeleted) {
            return true;
        }

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
