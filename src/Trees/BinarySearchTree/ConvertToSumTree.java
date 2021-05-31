package Trees.BinarySearchTree;

public class ConvertToSumTree {
    public static void main(String[] args) {
        //Given a binary tree, in-place convert it into its sum tree. Each node's value is equal to the sum of all the
        // elements present in the left and right subtree in a sum tree.
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
        BinarySearchTree bst = new BinarySearchTree();
        bst.root = root;
        bst.display();
        System.out.println("After converting the tree to its sum tree: ");
        convertToSumTree(root);
        bst.display();
    }

    private static int convertToSumTree(Node node) {
        if(node == null) {
            return 0;
        }
        int leftNodeVal = convertToSumTree(node.left);
        int rightNodeVal = convertToSumTree(node.right);
        return node.value += leftNodeVal + rightNodeVal;
    }
}
