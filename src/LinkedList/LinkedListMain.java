package LinkedList;

public class LinkedListMain {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList(1);
        list.append(2);
        list.prepend(0);
        list.insert(2, 10);
        list.insert(2, 44);
        list.insert(2, 22);
        System.out.println(list.getLength());
        list.printLinkedList();
        list.remove(44);
        System.out.println("After removing 44");
        System.out.println(list.getLength());
        list.printLinkedList();
        list.remove(10);
        System.out.println("After removing 10");
        System.out.println(list.getLength());
        list.printLinkedList();
        list.remove(0);
        System.out.println("After removing 0");
        System.out.println(list.getLength());
        list.printLinkedList();
        list.remove(4);
        System.out.println("After removing 4");
        System.out.println(list.getLength());
        list.printLinkedList();
    }
}
