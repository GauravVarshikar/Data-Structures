package Trees.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class IdenticalTrees {
    public static void main(String[] args) {
        // Write an efficient algorithm to check if two binary trees are identical or not i.e. they have identical
        // structure and their contents are also identical.
        BinarySearchTree bst1 = BSTMain.populateTree();
        BinarySearchTree bst2 = BSTMain.populateTree2();

        List<Integer> values1 = new ArrayList<>();
        List<Integer> values2 = new ArrayList<>();
        //traverse through the tree1 and store all node values in a list
        traverseTree(bst1.root, values1);
        System.out.println(new ArrayList<>(values1));
        //traverse through the tree2 and store all node values in a list
        traverseTree(bst2.root, values2);
        System.out.println(new ArrayList<>(values2));

        System.out.println("Are trees identical using list? - " + values1.equals(values2));
        System.out.println("Are trees identical InPlace? - " + areIdentical(bst1.root, bst2.root));
    }

    private static void traverseTree(Node node, List<Integer> values) {
        if(node == null){
            return;
        }
        //add each node's value in the list
        values.add(node.value);
        //traverse thru the left subtree
        traverseTree(node.left, values);
        //travers thru the right subtree
        traverseTree(node.right, values);
    }

    private static boolean areIdentical(Node node1, Node node2) {
        //return true if both the trees are empty
        if(node1 == null && node2 == null){
            return true;
        }
        //else check recursively if the value of each node is equal and traverse through left and right subtree
        return (node1 != null && node2 != null) && (node1.value == node2.value)
                && (areIdentical(node1.left, node2.left))
                && (areIdentical(node1.right, node2.right));
    }
}
