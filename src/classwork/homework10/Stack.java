package classwork.homework10;

public class Stack {
    int[] array = new int[10];
    int tos;

    Stack() {

    }

    void push(int item) {
        if (tos == 9) {
            System.out.println("Stack filled");
        } else {
            array[++tos] = item;
        }
    }

    int pop() {
        if (tos < 0) {
            System.out.println("Stack Clean");
            return 0;
        }

        return array[tos--];

    }
}
