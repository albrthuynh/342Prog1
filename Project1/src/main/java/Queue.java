/****************************
 * Program 1: Dictionary
 * <p>
 * Course: CS 342, Spring 2024
 * System: macOS using IntelliJ
 * Starter Code Author: Evan McCarty
 * <p>
 * ***************************/
public interface Queue<E> {
    /**
     * this method adds the element toAdd to the back of the queue
     * @param toAdd the element to add
     */
    public void enqueue(E toAdd);

    /**
     * this method returns the element at the front of the queue and removes it
     * @return the value at the front of the queue
     */
    public E dequeue();

    /**
     * this method returns the element at the front of the queue but does not remove it
     * @return the value at the front of the queue
     */
    public E front();

    public boolean isEmpty();
}
