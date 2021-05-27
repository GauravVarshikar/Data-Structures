package Stacks;

class Node {
    Node next;
    int value;
    public Node(int value){
        this.value = value;
        next = null;
    }
}

public class Stack {
    private Node top;
    private Node bottom;
    int length;
    public Stack(){
        top = null;
        bottom = null;
        length = 0;
    }
    public void push(int val) {
        Node newNode = new Node(val);
        if(isEmpty()){
            top = newNode;
            bottom = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        length++;
    }
    public Node pop() {
        if(isEmpty()) {
            bottom = null;
            return null;
        }
        Node retNode = top;
        top = top.next;
        length--;
        return retNode;
    }
    public Node peek() {
        return top;
    }
    public boolean isEmpty(){
        return length == 0;
    }
}
