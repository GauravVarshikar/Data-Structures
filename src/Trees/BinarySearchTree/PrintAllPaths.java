package Trees.BinarySearchTree;

import java.util.Stack;

public class PrintAllPaths {
    public static void main(String[] args) {
        BinarySearchTree bst = BSTMain.populateTree();
        Stack<Integer> pathStack = new Stack<>();
        printAllPaths(bst.root, pathStack);
    }

    private static void printAllPaths(Node node, Stack<Integer> pathStack) {
        if(node == null){
            return;
        }
        //Push the node to a stack
        pathStack.push(node.value);
        //if reached till the leaf node, print the stack content as the path
        if(node.left == null && node.right == null){
            System.out.println(pathStack);
        }
        printAllPaths(node.left, pathStack);
        printAllPaths(node.right, pathStack);

        //Pop from the stack
        pathStack.pop();
    }
}
