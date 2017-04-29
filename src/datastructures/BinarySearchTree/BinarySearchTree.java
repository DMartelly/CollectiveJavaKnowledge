package datastructures.binarySearchTree;

/**
 * A Binary Search Tree that can hold multiple Nodes
 *
 * @author Dominick Martelly
 */
public class BinarySearchTree {

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
     * Searches if there is a node containing x within the BST
     *
     * @param x an integer value
     * @return true if the value is found
     */
    boolean search(int x) {
        return root != null && root.find(root, x) != null;
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
        if (root.find(root, x) != null) {
            root = root.delete(root, x);
            return true;
        }
        return false;
    }

    /**
     * Gets the right most element in the BST
     *
     * @return the largest integer in the BST
     */
    int getLargest() {
        if (root == null) {
            return (Integer.MIN_VALUE);
        }
        return root.getLargestChild(root).value;
    }

    /**
     * Gets the left most element in the BST
     *
     * @return the smallest integer in the BST
     */
    int getSmallest() {
        if (root == null) {
            return (Integer.MIN_VALUE);
        }
        return root.getSmallestChild(root).value;
    }

    @Override
    public String toString() {
        if (root == null) {
            return "";
        }
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
		 * The node's left child. Should have a number lower than value
		 */
		Node left;
		/**
		 * The node's right child. Should have a number greater than value
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
		 * @param root the current root node
		 * @param x An integer value
		 * @return the modified / original node
		 */
		private Node add(Node root, int x) {
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
         *
         * @param root The current root node
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
		private Node delete(Node root, int x) {
            assert root != null;
            if (root.value == x){
				root = recDelete(root);
			} else if (x < root.value){
				root.left = delete(root.left, x);
			} else {
				root.right = delete(root.right, x);
			}
			return root;
		}

		private Node recDelete(Node toDelete) {
			if (toDelete.right == null && toDelete.left != null){
				return toDelete.left;
			} else if (toDelete.left == null && toDelete.right != null){
				return toDelete.right;
			} else if (toDelete.isLeaf()){
				return null;
			}
            assert toDelete.right != null;
            toDelete.value = toDelete.right.value;
			toDelete.right = recDelete(toDelete.right);
			return toDelete;
		}

		/**
		 * Checks if the Node has any child Nodes
		 *
		 * @return True if Node is a leaf
		 */
		private boolean isLeaf() {
			return (this.left == null && this.right == null);
		}

		/**
		 * @return The largest node of the current tree
		 */
        private Node getLargestChild(Node root) {
            if (root.right == null)
                return root;
            return (root.getLargestChild(root.right));
        }

		/**
		 * @return The smallest node of the current tree
		 */
        private Node getSmallestChild(Node root) {
            if (root.left == null)
                return root;
            return (root.getSmallestChild(root.left));
        }

		@Override
		public String toString() {
			// If there is only one element
            if (this.isLeaf())
                return Integer.toString(this.value) + " ";

            String listOfNodes = "";

            if (this.left != null)
                listOfNodes += this.left.toString();

            listOfNodes += this.value + " ";

            if (this.right != null)
                listOfNodes += this.right.toString();

            return listOfNodes;
        }
    }
}
