package datastructures.QueuesAndLists;

/**
 * @author Dominick Martelly
 */
public class Node {

    /**
     * The data of the node is an int
     */
    private int data;
    private Node next;

    /**
     * Creates a node containing an int
     *
     * @param x an int
     */
    Node(int x) {
        this.data = x;
    }

    Node getNext() {
        return next;
    }

    void setNext(Node next) {
        this.next = next;
    }

    int getData() {
        return this.data;
    }

    @Override
    public String toString() {
        return Integer.toString(this.data);
    }
}
