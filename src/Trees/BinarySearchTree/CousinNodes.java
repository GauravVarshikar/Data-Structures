package Trees.BinarySearchTree;

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
        System.out.println("Are they cousins? " + areCousins(bst.root, 1, 6));
        System.out.println("Are they cousins? " + areCousins(bst.root, 1, 4));
        System.out.println("Are they cousins? " + areCousins(bst.root, 1, 14));
        System.out.println("Are they cousins? " + areCousins(bst.root, 1, 12));
    }

    private static boolean areCousins(Node root, int elem1, int elem2)  {
        NodeLevelPair parent1 = findParentAndLevel(root, 0, elem1);
        System.out.println("Element1: " + elem1 + " Parent1: " + parent1.node.value + " Level1: " + parent1.level);
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
