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

        //Check if the given binary tree is a sum tree or not
        Node root1 = new Node(44);
        root1.left = new Node(9);
        root1.right = new Node(13);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.left = new Node(6);
        root1.right.right = new Node(7);
        bst.root = root1;
        bst.display();
        if (isSumTree(root1) == Integer.MIN_VALUE) {
            System.out.println("NOT a sum tree");
        } else {
            System.out.println("It is a sum tree");
        }
    }

    private static int isSumTree(Node node) {
        if(node == null){
            return 0;
        }
        if(node.left == null && node.right == null){
            return node.value;
        }
        int leftNodeVal = isSumTree(node.left);
        int rightNodeVal = isSumTree(node.right);
        System.out.println(node.value + " - " + leftNodeVal + " + " + rightNodeVal);
        if(node.value == (leftNodeVal + rightNodeVal)){
            return node.value + node.value;
        }
        return Integer.MIN_VALUE;
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
