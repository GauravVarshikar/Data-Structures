package Queues;

public class QueueMain {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.enqueue("First");
        myQueue.enqueue("Second");
        myQueue.enqueue("Third");
        System.out.println(myQueue);
        System.out.println("Dequeue First - " + myQueue.dequeue()); //popped First
        System.out.println(myQueue);
        System.out.println("Dequeue Second - " + myQueue.dequeue()); //popped Second
        System.out.println(myQueue);
        System.out.println("Dequeue Third - " + myQueue.dequeue()); //popped Third
        System.out.println(myQueue);
        System.out.println("Dequeue when queue is empty - " + myQueue.dequeue());
        System.out.println(myQueue);
    }
}
