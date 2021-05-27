package Stacks;

public class StackArrayMain {
    public static void main(String[] args) {
        StackArray stackArray = new StackArray();
        System.out.println(stackArray.length);
        stackArray.push(1);stackArray.push(2);stackArray.push(3);stackArray.push(4);
        System.out.println(stackArray);

        System.out.println(stackArray.peek());
        System.out.println(stackArray.pop()); System.out.println(stackArray);
        System.out.println(stackArray.pop()); System.out.println(stackArray);
        System.out.println(stackArray.pop()); System.out.println(stackArray);
        System.out.println(stackArray.pop());System.out.println(stackArray);
        System.out.println(stackArray.pop());System.out.println(stackArray);
    }
}
