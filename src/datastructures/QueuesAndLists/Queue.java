package datastructures.QueuesAndLists;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 * A single linked-list queue
 *
 * @author Dominick Martelly
 */
public class Queue {

    private int sizeofQueue;
    private Node first;
    private Node last;

    /**
     * Creates a queue with size zero and no elements
     */
    Queue() {
        this.sizeofQueue = 0;
    }

    /**
     * Places a node at the end of the Queue, in last place
     *
     * @param x an int
     */
    void enqueue(int x) {
        Node newNode = new Node(x);
        if (this.isEmpty()) {
            this.first = newNode;
            this.last = newNode;
        }
        this.last.setNext(newNode);
        this.last = newNode;
        this.sizeofQueue++;
    }

    int dequeue() {
        if (this.isEmpty())
            throw new EmptyStackException();
        int ans = first.getData();
        first = first.getNext();
        if (first == null) {
            last = null;
        }
        return ans;
    }

    /**
     * Places a node in the beginning of the Queue, in first place
     *
     * @param x an int
     */
    void addFirst(int x) {
        Node newNode = new Node(x);
        if (this.isEmpty()) {
            this.first = newNode;
            this.last = newNode;
        } else {
            Node temp = first;
            first = newNode;
            first.setNext(temp);
        }
        this.sizeofQueue++;
    }

    /**
     * @return the first element of the queue as an int
     */
    int getFirst() {
        if (this.isEmpty())
            throw new NoSuchElementException("The List is Empty");
        else
            return first.getData();
    }

    /**
     * Returns the nth element of a Queue
     *
     * @param n the place of the element in the list
     * @return the int of the nth element
     */
    int nthElement(int n) {
        if (n > this.sizeofQueue)
            throw new NoSuchElementException("You are searching of the " + n
                    + "th element in a queue the size of " + this.sizeofQueue);

        Node current = first;
        while (n > 1) {
            current = current.getNext();
            n--;
        }
        return current.getData();
    }


    /**
     * Returns the size of the queue
     *
     * @return the size of the queue as an int
     */
    int sizeofQueue() {
        return this.sizeofQueue;
    }

    /**
     * Checks if the Queue has any elements
     *
     * @return true if there are no elements in the queue
     */
    boolean isEmpty() {
        return (this.sizeofQueue == 0 && first == null);
    }

    @Override
    public String toString() {
        if (this.isEmpty())
            return "The Queue is Empty";
        else {
            Node current = first;
            String result = "Queue: ";

            while (current != null) {
                result += current.toString() + " ";
                current = current.getNext();
            }
            return result;
        }
    }
}
