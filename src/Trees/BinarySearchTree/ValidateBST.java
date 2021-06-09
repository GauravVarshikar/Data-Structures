package Trees.BinarySearchTree;

public class ValidateBST {
    public static void main(String[] args) {
        //Check if the given binary tree is a BINARY SEARCH tree or not
        BinarySearchTree bst = BSTMain.populateTree();
        System.out.println("Is BST? " + validateBST(bst.root));

        Node root1 = new Node(44);
        root1.left = new Node(9);
        root1.right = new Node(13);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.left = new Node(6);
        root1.right.right = new Node(7);
        bst.root = root1;
        bst.display();
        System.out.println("Is BST? " + validateBST(bst.root));
    }

    private static boolean validateBST(Node node) {
        if (node == null) {
            return true;
        }
        if(node.left != null && node.left.value > node.value) {
            return false;
        } else if (node.right != null && node.right.value < node.value) {
            return false;
        }
        return validateBST(node.left) && validateBST(node.right);
    }
}
