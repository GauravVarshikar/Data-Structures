package Trees.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

class NodeLevelPair {
    public Node node;
    public int level;
    NodeLevelPair(Node node, int level){
        this.node = node;
        this.level = level;
    }
}
public class CousinNodes {
    public static void main(String[] args) {
        // Given a binary tree, determine if two given nodes are cousins of each other or not. Two nodes of a binary
        // tree are cousins of each other only if they have different parents, but they have the same level.

        BinarySearchTree bst = BSTMain.populateTree();
        System.out.println("Are they cousins? " + areCousins(bst.root, 6));
        System.out.println("Are they cousins? " + areCousins(bst.root, 4));
        System.out.println("Are they cousins? " + areCousins(bst.root, 14));
        System.out.println("Are they cousins? " + areCousins(bst.root, 12));

        // Given a binary tree, print all cousins of a given node. Two nodes of a binary tree are cousins of each
        // other only if they have different parents, but they have the same level.
        int elem = 1;
        System.out.println("Cousins of " + elem + " are :" + findCousins(bst.root, elem));
        elem = 3;
        System.out.println("Cousins of " + elem + " are :" + findCousins(bst.root, elem));
        elem = 5;
        System.out.println("Cousins of " + elem + " are :" + findCousins(bst.root, elem));
    }

    private static String findCousins(Node root, int elem) {
        NodeLevelPair parent = findParentAndLevel(root, 0, elem);
        List<Integer> cousins = new ArrayList<>();
        getChildrenOfOtherParents(root, 0, parent, cousins);
        return cousins.toString();
    }

    private static void getChildrenOfOtherParents(Node root, int level, NodeLevelPair parent, List<Integer> cousins) {
       if (root == null) return;
       // Check if the node is at the same level as the parent of given element and the value dont match with that of parent
        // add the left and right child in the list of cousins
       if(level == parent.level && root.value != parent.node.value){
           if(root.left != null) cousins.add(root.left.value);
           if(root.right != null) cousins.add(root.right.value);
       }
       level++;
       getChildrenOfOtherParents(root.left, level, parent, cousins);
       getChildrenOfOtherParents(root.right, level, parent, cousins);
    }

    private static boolean areCousins(Node root, int elem2)  {
        NodeLevelPair parent1 = findParentAndLevel(root, 0, 1);
        System.out.println("Element1: " + 1 + " Parent1: " + parent1.node.value + " Level1: " + parent1.level);
        NodeLevelPair parent2 = findParentAndLevel(root, 0, elem2);
        System.out.println("Element2: " + elem2 + " Parent2: " + parent2.node.value + " Level2: " + parent2.level);
        return parent1.node.value != parent2.node.value && parent1.level == parent2.level;
    }

    private static NodeLevelPair findParentAndLevel(Node node, int level, int val){
        if((node.left != null && node.left.value == val) || (node.right!=null && node.right.value == val)){
            return new NodeLevelPair(node, level);
        }
        level++;
        if(val < node.value){
            assert node.left != null;
            return findParentAndLevel(node.left, level, val);
        } else {
            assert node.right != null;
            return findParentAndLevel(node.right, level, val);
        }
    }
}
