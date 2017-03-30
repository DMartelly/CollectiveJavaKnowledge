package DataStructures.BinarySearchTree;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Dominick Martelly on 3/26/2017 at 11:49 PM.
 *
 * @author Dominick Martelly
 */
public class BinarySearchTreeTest {

    private BinarySearchTree testTree;

    @Before
    public void setUp() throws Exception {
        testTree = new BinarySearchTree();
    }

    @After
    public void tearDown() throws Exception {
        testTree = null;
    }

    @Test
    public void test1_insert() throws Exception {
        testTree.insert(5);
        testTree.insert(2);
        testTree.insert(1);
        testTree.insert(6);
        Assert.assertEquals("Test 1 failed", "1 2 5 6 ", testTree.toString());
    }

    @Test
    public void test2_insert() throws Exception {
        Assert.assertEquals("Test 2 failed", "", testTree.toString());
    }

    @Test
    public void test3_insert() throws Exception {
        testTree.insert(Integer.MIN_VALUE);
        testTree.insert(Integer.MAX_VALUE);
        testTree.insert(4);
        testTree.insert(-99);
        Assert.assertEquals("Test 3 failed", Integer.MIN_VALUE + " -99 4 "
                + Integer.MAX_VALUE + " ", testTree.toString());
    }
    
    @Test
    public void test4_delete() throws Exception {
        testTree.insert(Integer.MIN_VALUE);
        testTree.insert(Integer.MAX_VALUE);
        testTree.insert(4);
        testTree.insert(-99);
        testTree.remove(4);
        Assert.assertEquals("Test 4 failed", Integer.MIN_VALUE + " -99 "
                + Integer.MAX_VALUE + " ", testTree.toString());
    }

    
    @Test
    public void test5_delete() throws Exception {
        testTree.insert(5);
        testTree.remove(5);
        Assert.assertEquals("Test 5 failed", "", testTree.toString());
    }
    
}