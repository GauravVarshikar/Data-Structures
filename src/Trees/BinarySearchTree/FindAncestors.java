package Trees.BinarySearchTree;

import java.util.Stack;

public class FindAncestors {
    public static void main(String[] args) {
        //Print all ancestors of a given node in a binary search tree

        BinarySearchTree bst = BSTMain.populateTree();
        System.out.println("Find Ancestors");
        Stack<Integer> ancestors = new Stack<>();
        int val = 14;
        findAncestors(bst.root, val, ancestors);
        System.out.println("Ancestors of " + val + " : " + ancestors.toString());
        val = 17;
        ancestors = new Stack<>();
        findAncestors(bst.root, val, ancestors);
        System.out.println("Ancestors of " + val + " : " + ancestors.toString());
        val = 4;
        ancestors = new Stack<>();
        findAncestors(bst.root, val, ancestors);
        System.out.println("Ancestors of " + val + " : " + ancestors.toString());
        val = 9;
        ancestors = new Stack<>();
        findAncestors(bst.root, val, ancestors);
        System.out.println("Ancestors of " + val + " : " + ancestors.toString());
    }

    private static void findAncestors(Node root, int val, Stack<Integer> ancestors) {
        if(root == null) {
            return;
        }
        if(root.value == val) {
            return;
        }
        ancestors.push(root.value);
        if(val < root.value){
            findAncestors(root.left, val, ancestors);
        } else {
            findAncestors(root.right, val, ancestors);
        }
    }
}
