package Trees.BinarySearchTree;

public class BSTMain {
    public static void main(String[] args) {

/*      System.out.println("Looking up 10: " + bst.lookup(10));
        System.out.println("Looking up 13: " + bst.lookup(13));*/
        BinarySearchTree bst = populateTree();
        bst.remove(15);
        bst.display();
    }
    public static BinarySearchTree populateTree(){
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);bst.insert(5);bst.insert(15);bst.insert(7);
        bst.insert(3);bst.insert(12);bst.insert(6); bst.insert(19);
        bst.insert(9);bst.insert(17);bst.insert(14);
        bst.insert(1);bst.insert(4);
        bst.display();
        return bst;
    }
    public static BinarySearchTree populateTree2(){
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);bst.insert(5);bst.insert(15);bst.insert(7);
        bst.insert(3);bst.insert(12);bst.insert(6); bst.insert(19);
        bst.insert(9);bst.insert(17);bst.insert(14);
        bst.insert(1);bst.insert(4); bst.insert(2);
        bst.display();
        return bst;
    }
}
