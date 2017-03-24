package DataStructures.BinarySearchTree;

/**
 * A Binary Search Tree that can hold multiple Nodes
 * (Should the methods to change the BST be in the BinarySearchTree class,
 * or the Node class?)
 *
 * @author Dominick Martelly
 */
public class BinarySearchTree {

    /**
     * The root Node of the Binary Search Tree
     */
    Node root;

    /**
     * Creates an empty BST
     */
    public BinarySearchTree() {
        root = null;
    }

    /**
     * Inserts a new node containing x into the tree
     *
     * @param x - an integer value
     */
    public void insert(int x) {
        Node newNode = new Node(x);

        if (root == null)
            root = newNode;
        else
            root.add(x);
    }

    /**
     * Removes a Node from a BST
     *
     * @param x if the Node contains this element, the Node will be
     *          removed
     * @return true if removed
     */
    public boolean remove(int x) {
        if (root == null)
            return false;
        else if (root.getData() == x) {
            Node newRoot = new Node(Integer.MAX_VALUE);
            newRoot.left = root;
            boolean result = newRoot.delete(x, null);
            root = newRoot.left;
            return result;
        } else
            return root.delete(x, null);
    }

    /**
     * Gets the right most element in the BST
     *
     * @return the largest integer in the BST
     */
    public int getLargest() {
        return root.getLargestChild().getData();
    }

    /**
     * Gets the left most element in the BST
     *
     * @return the smallest integer in the BST
     */
    public int getSmallest() {
        return root.getSmallestChild().getData();
    }

    /**
     * Searches if there is a node containing x within the BST
     *
     * @param x an integer value
     * @return true if the value is found
     */
    boolean binarySearch(int x) {
        if (root == null)
            return false;
        else
            return root.search(x);
    }

    @Override
    public String toString() {
        return root.toString();
    }

    /**
     * A Binary Search Tree's node. Holds a value, and two children nodes
     *
     * @author Dominick Martelly
     */

    private class Node {

        int value;

        /**
         * The node's left child. Should have a lower value than the node
         */
        Node left;

        /**
         * The node's right child. Should have a greater value than the node
         */
        Node right;

        /**
         * Creates a Node holding an integer value
         *
         * @param x An integer value
         */
        Node(int x) {
            this.value = x;
        }

        /**
         * Adds a new Node to a tree containing x as it's value
         *
         * @param x An integer value
         */
        void add(int x) {
            if (x <= this.value)
                if (this.left == null) {
                    Node newNode = new Node(x);
                    this.left = newNode;
                } else
                    this.left.add(x);
            else if (x > this.value)
                if (this.right == null) {
                    Node newNode = new Node(x);
                    this.right = newNode;
                } else
                    this.right.add(x);
        }

        /**
         * @param x An integer value
         * @return The node containing x
         */
        private Node find(int x) {
            if (x == this.value)
                return this;
            if (this.isLeaf())
                return null;

            if (x < this.value && this.left != null)
                return this.left.find(x);
            else if (x > this.value && this.right != null)
                return this.right.find(x);
            else
                return null;
        }

        /**
         * Removes a Node from a tree
         *
         * @param x          An integer value
         * @param parentNode The parent node
         * @return True if the Node was found and deleted
         */
        boolean delete(int x, Node parentNode) {
            if (this.value == x) {
                if (this.isFull()) {
                    this.value = this.right.getSmallestChild().value;
                    this.right.delete(this.value, this);
                } else if (this == parentNode.left) {
                    if (this.left == null)
                        parentNode.left = this.left;
                    else
                        parentNode.right = this.right;
                } else if (this == parentNode.right) {
                    if (this.right == null)
                        parentNode.right = this.left;
                    else
                        parentNode.right = this.right;
                }
            } else if (x < this.getData()) {
                if (this.left == null)
                    return false;
                else
                    return this.left.delete(x, this);
            } else if (x > this.getData()) {
                if (this.right == null)
                    return false;
                else
                    return this.right.delete(x, this);
            }
            return true;
        }

        /**
         * Searches though the tree of the Node for a Node containing the
         * current value
         *
         * @param x An integer value
         * @return True if a Node containing x was found
         */
        boolean search(int x) {
            if (x == this.value)
                return true;
            if (this.isLeaf())
                return false;

            if (x < this.value && this.left != null)
                return this.left.search(x);
            else if (x > this.value && this.right != null)
                return this.right.search(x);
            else
                return false;
        }

        /**
         * Checks if the Node has any child Nodes
         *
         * @return True if Node is a leaf
         */
        boolean isLeaf() {
            return (this.left == null && this.right == null);
        }

        /**
         * Checks if the Node has two children Nodes
         *
         * @return True if Node is full
         */
        boolean isFull() {
            return (this.left != null && this.right != null);
        }

        /**
         * @return The int in the node
         */
        int getData() {
            return this.value;
        }

        /**
         * @return The largest node of the current tree
         */
        Node getLargestChild() {
            while (this.right != null)
                return (this.right.getLargestChild());
            return this;
        }

        /**
         * @return The smallest node of the current tree
         */
        Node getSmallestChild() {
            while (this.left != null)
                return (this.left.getSmallestChild());
            return this;
        }

        @Override
        public String toString() {
            // If there is only one element
            if (this.isLeaf())
                return Integer.toString(this.value) + " ";

            String listofNodes = "";

            if (this.left != null)
                listofNodes += this.left.toString();

            listofNodes += this.value + " ";

            if (this.right != null)
                listofNodes += this.right.toString();

            return listofNodes;
        }
    }
}
