


import java.util.Scanner;

//Class MinHeapAssignment with data members declared
public class MinHeapAssignment {
    static Node root;
    Node tail;
    //size variable used to obtain the number of nodes in the tree.
    int size;

    //Class Node defining various data members related to Node
    static class Node{
        //Left child of Node
        Node left;
        //Right child of Node
        Node right;
        //parent of Node
        Node parent;
        //previous of Node
        Node previous;
        //data of Node
        int data;

        Node(int data)
        {
            // Assignment data using this.data
            this.data = data;
        }

    }
    //maxDepth - To maintain height of both subtrees(left subtree and right subtree)
    static int maxDepth(Node node){
        //no tree present
        if (node == null)
            return 0;
        else
        {
            // compute the depth of each subtree
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);
            // returns the greater depth one
            if (lDepth > rDepth)
                return(lDepth + 1);
            else return(rDepth + 1);
        }
    }
    //getMinimum - Finds the minimum of all nodes(i.e root)since it is Min Heap
    static int getMinimum(){
        return root.data;
    }
    //setTail- Setting tail for next node to be inserted.
     void setTail(Node node){
        if (node.parent == null) {
            tail = node;
            while (tail.left != null) {
                tail = tail.left;
            }
        } else if (node.parent.left == node) {
            tail = node.parent.right;
            while (tail.left != null) {
                tail = tail.left;
            }
        } else if (node.parent.right == node) {
            setTail(node.parent);
        }
    }
    //Inserting nodes
    boolean insert(int data) {
        //setting left and right depths to 0.
        int left_depth = 0;
        int right_depth = 0;
        if(root != null) {
            left_depth = maxDepth(root.left);
            right_depth = maxDepth(root.right);
            //System.out.println("left height: " + left_depth);
            //System.out.println("right height: " + right_depth);
        }
        //When root is null, new node becomes the root.
        if (root == null) {
            root = new Node(data);
            tail = root;
        }
        //If tail.left is null, new node is inserted at that position.
        else if(tail.left == null) {
            tail.left = new Node(data);
            tail.left.parent = tail;
            minHeapify(tail.left);
        }
        else {
            //If tail.right is null, new node is inserted at that position.
            tail.right = new Node(data);
            tail.right.parent = tail;
            minHeapify(tail.right);
            Node previous = tail;
            setTail(tail);
            tail.previous = previous;
        }//counter for size of nodes is incremented
        size++;
        //Displaying message for each insertion
        System.out.println("The node" +" "+data+" " + "is added");
        return true;
    }
    //printPostorder - Print out the values in the heap in postorder (the left sub-heap, right sub-heap, root).
    static Node printPostorder(Node node) {
        if (node == null){
            return null;
        }
        // then recur on left subtree
        printPostorder(node.left);
        // then recur on right subtree
        printPostorder(node.right);
        System.out.print(node.data + " ");
        return node;
    }
    //printPreorder - Printing out the odd numbers in the heap in preorder.
    static Node printPreorder(Node node) {
        if (node == null){
            return null;
        }
        //Condition to check the odd number nodes
        if(node.data % 2 != 0){
            System.out.print(node.data + " ");
        }
        //then recur on left subtree
        printPreorder(node.left);
        // now recur on right subtree
        printPreorder(node.right);
        return node;
    }
    //swapNodeData - swap the values of a and b
    static boolean swapNodeData(Node a, Node b) {
        int temp = a.data;
        a.data = b.data;
        b.data = temp;
        return true;
    }
    //minHeapify- To sort the heap.
    static Node minHeapify(Node node) {
        if (node.parent != null) {
            //if parent element is greater than inserted element, swap the 2 data
            if (node.parent.data > node.data) {
                swapNodeData(node.parent, node);
                //recursive call till root is reached
                minHeapify(node.parent);
            }
        }
        return node;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        //creating an instance of MinHeapAssignment class
        MinHeapAssignment minHeapAssignment = new MinHeapAssignment();
        //allow user to choose the input operation
        System.out.println("Please select operation\n1.Insert Node\t2.Find Minimum element\t3.Size of Heap\t4.Postorder traversal\t5.Preorder traversal of odd numbers");
        int type = scanner.nextInt();
        //continuous loop for the user input
        while('0' != type) {
            switch (type) {
                case 1:
                    //calls insert operation
                    minHeapAssignment.insert(scanner.nextInt());
                    break;
                case 2:
                    //if heap is empty, no minimum element
                    if(minHeapAssignment.root == null)
                        System.out.println("Empty heap");
                    else
                        //calls getMinimum operation
                        System.out.println("Minimum Element in Heap:" +minHeapAssignment.getMinimum());
                    break;
                case 3:
                    //prints the size of heap
                    System.out.println("size :" + minHeapAssignment.size);
                    break;
                case 4:
                    //calls printPostorder operation
                    System.out.println("Postorder traversal: \n");
                    minHeapAssignment.printPostorder(minHeapAssignment.root);
                    break;
                case 5:
                    //calls printPreorder operation
                    System.out.println("Preorder traversal of odd numbers ");
                    minHeapAssignment.printPreorder(minHeapAssignment.root);
                    break;
                default:
                    //Default case
                    System.out.println("Please select correct operation code");
                    break;
            }
            type = scanner.nextInt();
        }
    }
}
