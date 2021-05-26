package LinkedList;

class Node {
    int value;
    Node next;
    public Node(int val) {
        value = val;
        next = null;
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
        tail = n;
        length++;
    }
    public void prepend(int value) {
        Node n = new Node(value);
        n.next = head;
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
                    Node nod = new Node(value);
                    nod.next = temp.next;
                    temp.next = nod;
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
            length--;
            return;
        }
        while(temp.next != null) {
            if(temp.next.value == value){
                temp.next = temp.next.next;
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
            System.out.print(temp.value + " --> ");
            temp = temp.next;
        }
    }
}


