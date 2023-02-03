package classwork.homework10;

public class StackDemo {
    public static void main(String[] args) {
        Stack myStack = new Stack();
        myStack.push(4);
        myStack.push(8);
        myStack.push(9);
        myStack.push(10);
        myStack.push(99);
        myStack.push(35);
        myStack.push(22);
        myStack.push(11);
        myStack.push(88);
        myStack.push(87);

        System.err.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());

    }
}
