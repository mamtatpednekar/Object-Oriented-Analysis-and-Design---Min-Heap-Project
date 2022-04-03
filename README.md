# Object-Oriented-Analysis-and-Design---Min-Heap-Project

A min-heap is a heap in which the root has the smallest value in the heap. Normally one would 
implement a heap using an array. In this assignment you are to use pointers, not an array. In 
our min-heap each node has a value and 0, 1 or 2 children heaps. The root node of a minheap contains the smallest value in the heap. If you pick any node in the heap it has a value 
that is equal to or less than all the nodes in either the left or right sub-heaps of the node. See 
the figure 1 below for an example. To add a new value to the heap add it to the top of the 
heap. If the heap is empty the new value becomes the root. If heap is not empty than the 
smaller of the two values (current value in heap and the new value) is kept in the root. The 
larger of the two values is added the sub-heap with the smallest height. If both sub-heaps have 
the same height then the larger of the two values is added to the left heap. The process is 
repeated until a value is added to a new node at the bottom of the heap. 

Your code is to have the following functionality:
1. Add integers to your min-heap. There is no need to implement delete.
2. Print out the values in the heap in postorder (the left sub-heap, right sub-heap, root).
3. Print out the odd numbers in the heap in preorder.
Don't store the heap in an array or vector like structure. Do not convert the heap into an array 
or vector like structure to traverse the heap.
