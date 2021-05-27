package LinkedList;

public class ReverseLinkedList {
    public static void main(String[] args) {
        MySingleLinkedList list = new MySingleLinkedList(1);
        list.append(2);
        list.prepend(0);
        list.insert(2, 10);
        list.insert(2, 44);
        list.insert(2, 22);
        list.printLinkedList();
        System.out.println("Reverse List: ");
        MySingleLinkedList revLL = list.reverse();
        revLL.printLinkedList();

        System.out.println("Reverse List In-place: ");
        list.reverseInPlace();
        list.printLinkedList();

    }
}
