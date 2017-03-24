package DataStructures.BinarySearchTree;

/**
 * Created by Dominick Martelly on 3/23/2017 at 12:04 AM.
 *
 * @author Dominick Martelly
 */
public class BSTTester {
    public static void main(String[] args) {
        BinarySearchTree myTestBST = new BinarySearchTree();

        // Add nodes to the tree
        myTestBST.insert(5);
        myTestBST.insert(3);
        myTestBST.insert(8);
        myTestBST.insert(2);
        myTestBST.insert(12);
        myTestBST.insert(7);
        myTestBST.insert(50);
        System.out.println("My Binary Search Tree\n" + myTestBST + "\n");

        // Search for a node
        System.out.println("Search for 3 returned: " + myTestBST.binarySearch(3));
        System.out.println("Search for 8 returned: " + myTestBST.binarySearch(8));
        System.out.println("Search for 5 returned: " + myTestBST.binarySearch(5));
        System.out.println("Search for -1 returned: " + myTestBST.binarySearch(-1));
        System.out.println();

        // Remove the root node
        System.out.println("Removal of 5 returned: " + myTestBST.remove(5));
        System.out.println(myTestBST + "\n");

        // Remove a node
        System.out.println("Removal of 8 returned: " + myTestBST.remove(8));
        System.out.println(myTestBST + "\n");

        //Remove an element that is not there
        System.out.println("Removal of 11 returned: " + myTestBST.remove(11));
        System.out.println(myTestBST + "\n");
        System.out.println("Removal of -5 returned: " + myTestBST.remove(-5));
        System.out.println(myTestBST + "\n");
    }
}
