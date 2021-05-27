package Stacks;

public class StacksMain {
    public static void main(String[] args) {
        Stack stack = new Stack();
        System.out.println("New Stack created: isEmpty? " + stack.isEmpty());
        stack.push(1); stack.push(2); stack.push(3); stack.push(4);
        System.out.println("Peek() " + stack.peek().value + " -- Length = " + stack.length);
        System.out.println("Pop() " + stack.pop().value + " -- Length = " + stack.length);
        System.out.println("Pop() " + stack.pop().value + " -- Length = " + stack.length);
        System.out.println("Pop() " + stack.pop().value + " -- Length = " + stack.length);
        System.out.println("Pop() " + stack.pop().value + " -- Length = " + stack.length);
    }
}
