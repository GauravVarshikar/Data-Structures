package Trees.BinarySearchTree;

public class TreeTraversal {
    public static void main(String[] args) {
        BinarySearchTree bst = BSTMain.populateTree();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

        root = bst.root;
        //Pre-order traversal
        System.out.println("Printing PreOrder");
        preOrder(root);
        //In-order traversal
        System.out.println(); System.out.println("Printing InOrder");
        inOrder(root);
        //Post-order traversal
        System.out.println(); System.out.println("Printing PostOrder");
        postOrder(root);
    }

    private static void postOrder(Node node) {
        if(node == null){
            return;
        }
        //Traverse left subtree
        postOrder(node.left);
        //Travers right subtree
        postOrder(node.right);
        //Print current node
        System.out.print(node.value + " --> ");
    }

    private static void inOrder(Node node) {
        if(node == null){
            return;
        }
        //Traverse left subtree
        inOrder(node.left);
        //Print current node
        System.out.print(node.value + " --> ");
        //Travers right subtree
        inOrder(node.right);
    }

    private static void preOrder(Node node) {
        if(node == null){
            return;
        }
        //Print current node
        System.out.print(node.value + " --> ");
        //Traverse left subtree
        preOrder(node.left);
        //Travers right subtree
        preOrder(node.right);
    }
}
