package Trees.BinarySearchTree;

class Node {
    int value;
    Node left;
    Node right;
    public Node(int value){
        this.value = value;
    }
    @Override
    public String toString() {
        return "Node{" + "value=" + value +'}';
    }
}

public class BinarySearchTree {
    public Node root;
    public void insert(int val){
        Node newNode = new Node(val);
        if(root == null) {
            root = newNode;
            return;
        }
        root = insertNode(root, newNode);
    }
    private Node insertNode(Node node, Node newNode) {
        if(node == null) {
            node = newNode;
            return node;
        }
        if(node.value > newNode.value){
            node.left = insertNode(node.left, newNode);
        } else {
            node.right = insertNode(node.right, newNode);
        }
        return node;
    }
    public Node lookup(int val){
        if(root == null){
            return null;
        }
        return lookupNode(root, val);
    }
    private Node lookupNode(Node node, int val) {
        if(node == null){
            return null; //Lookup node does not exist in the tree, return null
        }
        if(node.value == val){
            return node; //Lookup node exist in the tree, return the node
        }
        if(val < node.value){
            node = lookupNode(node.left, val);
        } else {
            node = lookupNode(node.right, val);
        }
        return node;
    }
    public Node remove(int val){
        if(root == null) {
            return null;
        }
        return removeNode(root, val);
    }

    //I could not complete the logic for removing nodes. It was just too complicated for me.
    private Node removeNode(Node node, int val) {
        Node retNode;
        if (node == null) {
            return null;
        } else if(node.left!=null && node.left.value == val){
            retNode = node.left;
            node.left = node.left.right;
            node.left.left = retNode.left;
            return retNode;
        } else if (node.right != null && node.right.value == val){
            retNode = node.right;
            node.right = node.right.left;
            node.right.right = retNode.right;
            return retNode;
        }

        if(val < node.value) {
            node = removeNode(node.left, val);
        } else {
            node = removeNode(node.right, val);
        }
        return node;
    }

    public void display() {
        final int height = 5, width = 30;
        int len = width * height * 2 + 2;
        StringBuilder sb = new StringBuilder(len);
        for (int i = 1; i <= len; i++)
            sb.append(i < len - 2 && i % width == 0 ? "\n" : ' ');

        displayR(sb, width / 2, 1, width / 4, width, root, " ");
        System.out.println(sb);
    }
    private void displayR(StringBuilder sb, int c, int r, int d, int w, Node n,
                          String edge) {
        if (n != null) {
            displayR(sb, c - d, r + 2, d / 2, w, n.left, " /");

            String s = String.valueOf(n.value);
            int idx1 = r * w + c - (s.length() + 1) / 2;
            int idx2 = idx1 + s.length();
            int idx3 = idx1 - w;
            if (idx2 < sb.length())
                sb.replace(idx1, idx2, s).replace(idx3, idx3 + 2, edge);

            displayR(sb, c + d, r + 2, d / 2, w, n.right, "\\ ");
        }
    }
}
