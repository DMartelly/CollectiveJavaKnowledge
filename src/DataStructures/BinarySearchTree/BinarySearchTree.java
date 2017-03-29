package DataStructures.BinarySearchTree;

/**
 * A Binary Search Tree that can hold multiple Nodes
 *
 * @author Dominick Martelly
 */
public class BinarySearchTree {

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
        Node add(Node root, int x) {
            if (root == null) {
                return new Node(x);
            }
            if (x < root.value) {
                root.left = add(root.left, x);
            } else {
                root.right = add(root.right, x);
            }
            return root;
        }

        /**
         * @param x An integer value
         * @return The node containing x
         */
        private Node find(Node root, int x) {
            if (root == null)
                return null;
            if (root.value == x)
                return root;
            if (x < root.value)
                return find(root.left, x);
            else
                return find(root.right, x);
        }

        /**
         * Removes a Node from a tree
         *
         * @param root the tree to use
         * @param x    An integer value
         * @return True if the Node was found and deleted
         */
        boolean delete(Node root, int x) {
            Node toDelete = find(root, x);
            if (toDelete == null) {
                return false;
            }
            root = recDelete(toDelete);
            return true;
        }

        private Node recDelete(Node toDelete) {
			if (toDelete.right == null){
				return null;
			}
			toDelete.value = toDelete.right.getData();
			toDelete.right = recDelete(toDelete.right);
			return toDelete;
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

    /**
     * The root Node of the Binary Search Tree
     */
    private Node root;

    /**
     * Creates an empty BST
     */
    BinarySearchTree() {
        root = null;
    }

    /**
     * Inserts a new node containing x into the tree
     *
     * @param x - an integer value
     */
    void insert(int x) {
        if (root == null)
            root = new Node(x);
        else
            root.add(root, x);
    }

    /**
     * Removes a Node from a BST
     *
     * @param x if the Node contains this element, the Node will be
     *          removed
     * @return true if removed
     */
    boolean remove(int x) {
        if (root == null)
            return false;
        else
            return root.delete(root, x);
    }

    /**
     * Gets the right most element in the BST
     *
     * @return the largest integer in the BST
     */
    int getLargest() {
        return root.getLargestChild().getData();
    }

    /**
     * Gets the left most element in the BST
     *
     * @return the smallest integer in the BST
     */
    int getSmallest() {
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
        if (root == null) {
            return "";
        }
        return root.toString();
    }
}
