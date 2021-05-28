package Queues;

class Node{
    Node next;
    String value;
    public Node(String val){
        value = val;
        next = null;
    }

    @Override
    public String toString() {
        return "Node{" + "value='" + value + '\'' +'}';
    }
}
public class MyQueue {
    private Node first;
    private Node last;
    private int length;
    public String seek(){
        return first != null ? first.value: null;
    }
    private boolean isEmpty(){
        return length == 0;
    }
    public void enqueue(String val){
        Node newNode = new Node(val);
        if(isEmpty()){
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        length++;
    }
    public Node dequeue(){
        if(isEmpty()){
            return null;
        }
        Node retNode = first;
        first = first.next;
        length--;
        if(isEmpty()){
            last = null;
        }
        return retNode;
    }

    @Override
    public String toString() {
        return "MyQueue{" +
                "first=" + first +
                ", last=" + last +
                ", length=" + length +
                '}';
    }
}
