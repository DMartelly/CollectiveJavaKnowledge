package datastructures.binarySearchTree;

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
    public void test_insert1() throws Exception {
        testTree.insert(5);
        testTree.insert(2);
        testTree.insert(1);
        testTree.insert(6);
        Assert.assertEquals("Test insert1 failed", "1 2 5 6 ", testTree.toString());
    }

    @Test
    public void test_insert2() throws Exception {
        Assert.assertEquals("Test insert2 failed", "", testTree.toString());
    }

    @Test
    public void test_insert3() throws Exception {
        testTree.insert(Integer.MIN_VALUE);
        testTree.insert(Integer.MAX_VALUE);
        testTree.insert(4);
        testTree.insert(-99);
        Assert.assertEquals("Test insert3 failed", Integer.MIN_VALUE + " -99 4 "
                + Integer.MAX_VALUE + " ", testTree.toString());
    }
    
    @Test
    public void test_delete1() throws Exception {
        testTree.insert(Integer.MIN_VALUE);
        testTree.insert(Integer.MAX_VALUE);
        testTree.insert(4);
        testTree.insert(-99);
        testTree.remove(4);
        Assert.assertEquals("Test delete1 failed", Integer.MIN_VALUE + " -99 "
                + Integer.MAX_VALUE + " ", testTree.toString());
    }

    
    @Test
    public void test_delete2() throws Exception {
        testTree.insert(5);
        testTree.remove(5);
        Assert.assertEquals("Test delete2 failed", "", testTree.toString());
    }
    
    @Test
    public void test_delete3() throws Exception {
        Assert.assertEquals("Test delete3 failed", false, testTree.remove(5));
    }
    
    @Test
    public void test_delete4() throws Exception {
    	testTree.insert(8);
    	testTree.insert(12);
    	testTree.insert(Integer.MIN_VALUE);
        Assert.assertEquals("Test delete4 failed", false, testTree.remove(5));
    }
    
    @Test
    public void test_delete5() throws Exception {
    	testTree.insert(8);
    	testTree.insert(12);
    	testTree.insert(-25);
    	testTree.insert(-4);
    	testTree.insert(5);
    	testTree.insert(6);
    	testTree.insert(4);
    	testTree.insert(3);
    	testTree.insert(7);
    	testTree.remove(5);
        Assert.assertEquals("Test delete5 failed", "-25 -4 3 4 6 7 8 12 ", testTree.toString());
    }
    
    @Test
    public void test_search1() throws Exception {
        testTree.insert(5);
        Assert.assertEquals("Test search1 failed", true, testTree.search(5));
    }
    
    @Test
    public void test_search2() throws Exception {
        Assert.assertEquals("Test search2 failed", false, testTree.search(3));
    }
    
    @Test
    public void test_search3() throws Exception {
    	testTree.insert(4);
    	testTree.insert(-1);
    	testTree.insert(6);
        Assert.assertEquals("Test search3 failed", false, testTree.search(5));
    }
    
    @Test
    public void test_largest1() throws Exception {
        Assert.assertEquals("Test largest1 failed", Integer.MIN_VALUE, testTree.getLargest());
    }
    
    @Test
    public void test_largest2() throws Exception {
    	testTree.insert(0);
    	testTree.insert(-1);
    	testTree.insert(-14);
    	testTree.insert(123);
    	testTree.insert(124);
    	testTree.insert(84);
        Assert.assertEquals("Test largest2 failed", 124, testTree.getLargest());
    }
    
    @Test
    public void test_smallest1() throws Exception {
        Assert.assertEquals("Test largest1 failed", Integer.MIN_VALUE, testTree.getSmallest());
    }
    
    @Test
    public void test_smallest2() throws Exception {
    	testTree.insert(0);
    	testTree.insert(-1);
    	testTree.insert(-1);
    	testTree.insert(124);
    	testTree.insert(84);
        Assert.assertEquals("Test smallest2 failed", -1, testTree.getSmallest());
    }
}