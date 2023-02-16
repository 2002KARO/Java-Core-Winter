package group2.chapter6.bracechecker;

public class Stack {
    int[] array = new int[10];
    int tos;

    Stack() {

    }

    void push(int item) {
        if (tos == 9) {
            System.out.println("Ստեկում տեշ չկա ");
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

    public boolean isEmpty(){
        return tos==-1;


    }
 }