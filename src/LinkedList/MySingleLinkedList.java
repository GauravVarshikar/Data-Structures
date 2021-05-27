package LinkedList;

class LinkNode {
    int value;
    LinkNode next;
    public LinkNode(int val) {
        value = val;
        next = null;
    }
}

public class MySingleLinkedList {
    private LinkNode head;
    private LinkNode tail;
    private int length;

    private MySingleLinkedList() {

    }

    public MySingleLinkedList(int value){
        head = new LinkNode(value);
        tail = head;
        length++;
    }
    public void append(int value){
        LinkNode n = new LinkNode(value);
        tail.next = n;
        tail = n;
        length++;
    }
    public void prepend(int value) {
        LinkNode n = new LinkNode(value);
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
            LinkNode temp = head;
            int n = 0;
            while (temp != null) {
                if (n == index) {
                    LinkNode newNode = new LinkNode(value);
                    newNode.next = temp.next;
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
        LinkNode temp = head;
        if(temp.value == value) {
            head = head.next;
            length--;
            return;
        }
        while(temp.next != null) {
            if(temp.next.value == value){
                temp.next = temp.next.next;
                if(temp.next.next == null){ //if the node to be removed is tail node
                    temp.next = temp.next.next;
                    tail = temp; //new tail will be the node before
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
        LinkNode temp = head;
        while(temp != null){
            System.out.print(temp.value + " --> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public MySingleLinkedList reverse() {
        if(length < 2){
            return this;
        }
        LinkNode temp = head;
        MySingleLinkedList reverseLL = new MySingleLinkedList();
        while (temp != null){
            reverseLL.prepend(temp.value);
            temp = temp.next;
        }
        return reverseLL;
    }

    public void reverseInPlace(){
        if(length >= 2){
            LinkNode first = head; //pointer to the first node
            tail = first; //first node will become the new tail
            LinkNode second = first.next; //pointer to the second node
            while(second != null){
                LinkNode third = second.next; //pointer to the third node
                second.next = first; //reverse the pointer between the first and seconde node
                first = second; //move the pointer to next by node for first
                second = third; //move the pointer to next by node for second
            }
            head.next = null;
            head = first;
        }
    }
}


