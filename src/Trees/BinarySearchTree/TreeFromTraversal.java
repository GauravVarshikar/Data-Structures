package Trees.BinarySearchTree;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class TreeFromTraversal {
    public static void main(String[] args) {
        // Construct tree from a given Inorder and PreOrder tree traversal
        int[] inOrder = { 4, 2, 1, 7, 5, 8, 3, 6 };
        int[] preOrder = { 1, 2, 4, 3, 5, 7, 8, 6 };

        Node tree = constructTree(inOrder, preOrder);
        BinarySearchTree bst = new BinarySearchTree();
        bst.root = tree;
        bst.display();
    }

    private static Node constructTree(int[] inOrder, int[] preOrder) {
         Map<Integer, Integer> inOrderMap = new HashMap<>();
         //Store all the values of the InOrder array in a map
         for(int i = 0; i<inOrder.length; i++){
             inOrderMap.put(inOrder[i], i);
         }
         AtomicInteger index = new AtomicInteger(0);
         return constructTree(0, inOrder.length-1, preOrder, inOrderMap, index);
    }

    private static Node constructTree(int start, int end, int[] preOrder, Map<Integer, Integer> inOrderMap, AtomicInteger index) {
        //Base case to end recursion
        if(start > end){
            return null;
        }

        //First node of the preOrder list will be the root node of the tree
        Node root = new Node(preOrder[index.getAndIncrement()]);

        //find the index of the root node in the inorder list
        int newEnd = inOrderMap.get(root.value);

        //all values to the left of the root in the inorder list will form the left subtree
        root.left = constructTree(start, newEnd -1, preOrder, inOrderMap, index);
        //all values to the right of the root in the inorder list will form the right subtree
        root.right = constructTree(newEnd+1, end, preOrder, inOrderMap, index);
        return root;
    }
}
