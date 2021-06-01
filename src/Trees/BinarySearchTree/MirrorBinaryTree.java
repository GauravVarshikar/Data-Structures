package Trees.BinarySearchTree;

public class MirrorBinaryTree {
    public static void main(String[] args) {
        //Given a binary tree, write a program to convert the binary tree to its mirror.
        BinarySearchTree bst = BSTMain.populateTree();
        if(bst.root != null){
            System.out.println("Mirror Tree");
            mirrorBinaryTree(bst.root);
            bst.display();
        }
    }

    private static Node mirrorBinaryTree(Node node) {
        if(node == null){
            return null;
        }
        //Get the left node and the right node, and swap the nodes for the current node
        // that is current.left=right and current.right=left
        Node leftNode = mirrorBinaryTree(node.left);
        node.left = mirrorBinaryTree(node.right);
        node.right = leftNode;
        return node;
    }


}
