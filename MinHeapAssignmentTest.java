import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MinHeapAssignmentTest {
    MinHeapAssignment.Node root;
    int size;
    MinHeapAssignment.Node tail;
    MinHeapAssignment minHeapAssignment = new MinHeapAssignment();
    static class Node {
        MinHeapAssignment.Node left;
        MinHeapAssignment.Node right;
        MinHeapAssignment.Node parent;
        MinHeapAssignment.Node previous;
        int data;
        Node(int data) {
            this.data = data;
        }
    }
    //Test case to check the max depth of heap
    @org.junit.jupiter.api.Test
    void maxDepth1() {
        //Assigning value for root1
        MinHeapAssignment.Node root1 = new MinHeapAssignment.Node(10);
        //Checking the passed case for finding the maximum depth
        assertEquals(MinHeapAssignment.maxDepth(root1), 1);
    }
    //Failed test case: Test case to check the max depth of heap
    @org.junit.jupiter.api.Test
    void maxDepth2() {
        //Assigning value for root1
        MinHeapAssignment.Node root1 = new MinHeapAssignment.Node(10);
        //Checking the failed case for finding the maximum depth
        assertEquals(MinHeapAssignment.maxDepth(root1), 3);
    }
    //Test case to get the minimum element of heap
    @org.junit.jupiter.api.Test
    void getMinimum() {
        //Checking the passed case for finding minimum node in heap
        assertEquals(MinHeapAssignment.getMinimum(), 10);
    }
    //Failed test case: Test case to get the minimum element of heap
    @org.junit.jupiter.api.Test
    void getMinimum1() {
        //Checking the failed case for finding minimum node in heap
        assertEquals(MinHeapAssignment.getMinimum(), 30);
    }
    //Test Case for inserting nodes in heap
    @org.junit.jupiter.api.Test
    void insert() {
        //check if initial value of root is null
        assertEquals(root, null);
        //first element inserted is 20 which becomes the root
        assertTrue(minHeapAssignment.insert(20));
        //check if the root data is 20
        assertEquals(minHeapAssignment.root.data, 20);
        //second element inserted is 40 which goes to left
        assertTrue(minHeapAssignment.insert(40));
        //check if left data is 40
        assertEquals(minHeapAssignment.tail.left.data, 40);
        //third element inserted is 10
        assertTrue(minHeapAssignment.insert(10));
    }
    //Failed test case: Test Case for inserting nodes in heap
    @org.junit.jupiter.api.Test
    void insert2() {
        //Checking failed status for root which is null.
        assertEquals(root, 20);
    }
    //Test Case to print postorder traversal of nodes
    @org.junit.jupiter.api.Test
    void printPreorder() {
        //Assigning value for node, left and right
        MinHeapAssignment.Node node = new MinHeapAssignment.Node(11);
        MinHeapAssignment.Node left = new MinHeapAssignment.Node(12);
        MinHeapAssignment.Node right = new MinHeapAssignment.Node(13);
        node.left = left;
        node.right = right;
        //Returns passed status for odd numbers(11)
        assertEquals(MinHeapAssignment.printPostorder(node),node);
    }
    //Failed test case: Test Case to print postorder traversal of nodes
    @org.junit.jupiter.api.Test
    void printPreorder1() {
        //Assigning value for node, left and right
        MinHeapAssignment.Node node = new MinHeapAssignment.Node(11);
        MinHeapAssignment.Node left = new MinHeapAssignment.Node(12);
        MinHeapAssignment.Node right = new MinHeapAssignment.Node(13);
        node.left = left;
        node.right = right;
        //Returns failed status for even number(12)
        assertEquals(MinHeapAssignment.printPostorder(node),node.left);
    }
    //Test Case for swapping nodes
    @org.junit.jupiter.api.Test
    byte swapNodeData() {
        //Assigning value for node a, b
        MinHeapAssignment.Node a = new MinHeapAssignment.Node(11);
        MinHeapAssignment.Node b = new MinHeapAssignment.Node(12);
        assertEquals(swapNodeData(), true);
        //Checking if swapping was correctly performed
        assertEquals(a.data, 12);
        assertEquals(b.data, 11);
        return 0;
    }
    //Failed test case: Test Case for swapping nodes
    @org.junit.jupiter.api.Test
    byte swapNodeData1() {
        //Assigning value for node a, b
        MinHeapAssignment.Node a = new MinHeapAssignment.Node(11);
        MinHeapAssignment.Node b = new MinHeapAssignment.Node(12);
        assertEquals(swapNodeData(), false);
        //Checking the failed swap.
        assertEquals(a.data, 11);
        assertEquals(b.data, 12);
        return 0;
    }
    //Test case for sorting the minheap
    @org.junit.jupiter.api.Test
    void minHeapify() {
        //Assigning value for node, node's parent
        MinHeapAssignment.Node node = new MinHeapAssignment.Node(31);
        MinHeapAssignment.Node parent = new MinHeapAssignment.Node(33);
        node.parent = parent;
        //Checking if return value of minHeapify is 31(smaller)
        assertEquals(MinHeapAssignment.minHeapify(node),node);
    }
    //Failed test case: Test case for sorting the minheap
    @org.junit.jupiter.api.Test
    void minHeapify1() {
        //Assigning value for node, node's parent
        MinHeapAssignment.Node node = new MinHeapAssignment.Node(31);
        MinHeapAssignment.Node parent = new MinHeapAssignment.Node(33);
        node.parent = parent;
        //Checking if return value of minHeapify is not 33(greater)
        assertEquals(MinHeapAssignment.minHeapify(node),node.parent);
    }
    //Test Case for postorder traversal
    @org.junit.jupiter.api.Test
    void printPostorder() {
        //Assigning values for node, node-left, node-right
        MinHeapAssignment.Node node = new MinHeapAssignment.Node(11);
        MinHeapAssignment.Node left = new MinHeapAssignment.Node(12);
        MinHeapAssignment.Node right = new MinHeapAssignment.Node(13);
        node.left = left;
        node.right = right;
        //check if the order of printPostOrder function matches
        assertEquals(MinHeapAssignment.printPostorder(node),node);
    }
    //Failed test case: Test Case for postorder traversal
    @org.junit.jupiter.api.Test
    void printPostorder1() {
        //Assigning values for node, node-left, node-right
        MinHeapAssignment.Node node = new MinHeapAssignment.Node(11);
        MinHeapAssignment.Node left = new MinHeapAssignment.Node(12);
        MinHeapAssignment.Node right = new MinHeapAssignment.Node(13);
        node.left = left;
        node.right = right;
        //check if the order of printPostOrder function does not match
        assertEquals(MinHeapAssignment.printPostorder(node),node.right);
    }
}