package Trees.BinarySearchTree;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class TreeFromTraversal {
    private static final String IN_ORDER = "IN_ORDER";
    private static final String PRE_ORDER = "PRE_ORDER";
    private static final String POST_ORDER = "POST_ORDER";

    public static void main(String[] args) {
        // Construct tree from a given Inorder and PreOrder tree traversal
        int[] inOrder = { 4, 2, 1, 7, 5, 8, 3, 6 };
        int[] preOrder = { 1, 2, 4, 3, 5, 7, 8, 6 };
        int[] postOrder = { 4, 2, 7, 8, 5, 6, 3, 1 };

        //Construct tree from InOrder and PreOrder traversals
        Node tree = constructTree(inOrder, preOrder, IN_ORDER, PRE_ORDER);
        BinarySearchTree bst = new BinarySearchTree();
        bst.root = tree;
        System.out.println("Tree created from In and Pre Order");
        bst.display();

        //Construct tree from InOrder and PostOrder traversals
        tree = constructTree(inOrder, postOrder, IN_ORDER, POST_ORDER);
        bst = new BinarySearchTree();
        bst.root = tree;
        System.out.println("Tree created from In and Post Order");
        bst.display();

        //Construct tree from PreOrder and PostOrder traversals
        int[] preOrder2 = { 1, 2, 4, 5, 3, 6, 8, 9, 7 };
        int[] postOrder2 = { 4, 5, 2, 8, 9, 6, 7, 3, 1 };
        if(preOrder2.length == postOrder2.length && preOrder2.length%2 == 1) {
            tree = constructTree(postOrder2, preOrder2, PRE_ORDER, POST_ORDER);
        }
        bst = new BinarySearchTree();
        bst.root = tree;
        System.out.println("Tree created from Pre and Post Order");
        bst.display();

    }

    private static Node constructTree(int[] order1, int[] order2, String tra1, String tra2) {
         Map<Integer, Integer> order1Map = new HashMap<>();
         //Store all the values of the InOrder array in a map
         for(int i = 0; i<order1.length; i++){
             order1Map.put(order1[i], i);
         }
         AtomicInteger index;
         if(tra1.equals(IN_ORDER) && tra2.equals(PRE_ORDER)) {
             index = new AtomicInteger(0); //in preorder traversal first node is the root node
             return constructTreeFromInAndPre(0, order1.length - 1, order2, order1Map, index);
         } else if(tra1.equals(IN_ORDER) && tra2.equals(POST_ORDER)) {
             index = new AtomicInteger(order1.length-1); //in postorder last node is the root node
             return constructTreeFromInAndPost(0, order1.length - 1, order2, order1Map, index);
         } else if(tra1.equals(PRE_ORDER) && tra2.equals(POST_ORDER)) {
             index = new AtomicInteger(0); //in preorder first node is the root node
             return constructTreeFromPreAndPost(0, order1.length - 1, order2, order1Map, index);
         }
         return null;
    }

    //int[] preOrder2 = { 1, 2, 4, 5, 3, 6, 8, 9, 7 };
    //        int[] postOrder2 = { 4, 5, 2, 8, 9, 6, 7, 3, 1 };
    private static Node constructTreeFromPreAndPost(int start, int end, int[] preOrder, Map<Integer, Integer> order1Map,
                                                    AtomicInteger index) {
        Node root = new Node(preOrder[index.getAndIncrement()]);
        if(index.get() == preOrder.length){
            return root;
        }
        int newIndex = order1Map.get(preOrder[index.get()]);

        if (start <= newIndex && newIndex + 1 <= end - 1) {
            root.left = constructTreeFromPreAndPost(start, newIndex, preOrder, order1Map, index);
            root.right = constructTreeFromPreAndPost(newIndex + 1, end - 1, preOrder, order1Map, index);
        }
        return root;
    }

    /* int[] inOrder = { 4, 2, 1, 7, 5, 8, 3, 6 };
       int[] postOrder = { 4, 2, 7, 8, 5, 6, 3, 1 };

    * The idea is to start with the root node, which would be the last item in the postorder sequence, and find the
    * boundary of its left and right subtree in the inorder sequence. To find the boundary, search for the index of the
    * root node in the inorder sequence. All keys before the root node in the inorder sequence become part of the left
    * subtree, and all keys after the root node become part of the right subtree. Repeat this recursively for all nodes
    * in the tree and construct the tree in the process.
    */
    private static Node constructTreeFromInAndPost(int start, int end, int[] postOrder, Map<Integer, Integer> inOrderMap, AtomicInteger index) {
        //Base case to end recursion
        if(start > end){
            return null;
        }
        //First node of the postOrder list will be the root node of the tree
        Node root = new Node(postOrder[index.getAndDecrement()]);
        //find the index of the root node in the inorder list
        int newIndex = inOrderMap.get(root.value);
        //all values to the right of the root in the inorder list will form the right subtree
        root.right = constructTreeFromInAndPost(newIndex + 1, end, postOrder, inOrderMap, index);
        //all values to the left of the root in the inorder list will form the left subtree
        root.left = constructTreeFromInAndPost(start, newIndex - 1, postOrder, inOrderMap, index);
        return root;
    }

    /*
        int[] inOrder = { 4, 2, 1, 7, 5, 8, 3, 6 };
        int[] preOrder = { 1, 2, 4, 3, 5, 7, 8, 6 };
    * The idea is to start with the root node, which would be the first item in the preorder sequence, and find the
    * boundary of its left and right subtree in the inorder sequence. To find the boundary, search for the index of the
    * root node in the inorder sequence. All keys before the root node in the inorder sequence become part of the left
    * subtree, and all keys after the root node become part of the right subtree. Repeat this recursively for all nodes
    * in the tree and construct the tree in the process.
    */
    private static Node constructTreeFromInAndPre(int start, int end, int[] preOrder, Map<Integer, Integer> inOrderMap, AtomicInteger index) {
        //Base case to end recursion
        if(start > end){
            return null;
        }
        //First node of the preOrder list will be the root node of the tree
        Node root = new Node(preOrder[index.getAndIncrement()]);
        //find the index of the root node in the inorder list
        int newEnd = inOrderMap.get(root.value);
        //all values to the left of the root in the inorder list will form the left subtree
        root.left = constructTreeFromInAndPre(start, newEnd -1, preOrder, inOrderMap, index);
        //all values to the right of the root in the inorder list will form the right subtree
        root.right = constructTreeFromInAndPre(newEnd+1, end, preOrder, inOrderMap, index);
        return root;
    }
}
