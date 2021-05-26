package LinkedList;

class Node {
    int value;
    Node next;
    Node prev; //For doubly linkedlist
    public Node(int val) {
        value = val;
        next = null;
        prev = null;
    }
}

public class MyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    public MyLinkedList(int value){
        head = new Node(value);
        tail = head;
        length++;
    }
    public void append(int value){
        Node n = new Node(value);
        tail.next = n;
        n.prev = tail;
        tail = n;
        length++;
    }
    public void prepend(int value) {
        Node n = new Node(value);
        n.next = head;
        head.prev = n;
        head = n;
        length++;
    }
    public void insert(int index, int value) {
        if(index == 0){
            prepend(value);
        }
        else if(index >= length-1){
            append(value);
        }
        else {
            Node temp = head;
            int n = 0;
            while (temp != null) {
                if (n == index) {
                    Node newNode = new Node(value);
                    newNode.next = temp.next;
                    newNode.prev = temp;
                    temp.next = newNode;
                    length++;
                    break;
                }
                temp = temp.next;
                n++;
            }
        }
    }
    public void remove(int value) {
        Node temp = head;
        if(temp.value == value) {
            head = head.next;
            head.prev = null;
            length--;
            return;
        }
        while(temp.next != null) {
            if(temp.next.value == value){
                temp.next = temp.next.next;
                if(temp.next.next == null){ //if the node to be removed is tail node
                    temp.next = temp.next.next;
                    tail = temp; //new tail will be the node before
                } else {
                    temp.next.prev = temp;
                }
                length--;
                break;
            }
            temp = temp.next;
        }
    }
    public int getLength(){
        return length;
    }
    public void printLinkedList(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + "- prev=" + temp.prev + " - next=" + temp.next +" --> ");
            temp = temp.next;
        }
        System.out.println();
    }
}


