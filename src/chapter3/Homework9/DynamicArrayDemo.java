package chapter3.Homework9;

public class DynamicArrayDemo {
    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.add(9);
        dynamicArray.add(4);
        dynamicArray.add(80);
        dynamicArray.add(900);
        for (int i = 0; i < 1000; i++) {
            dynamicArray.add(i + 1);

        }


        dynamicArray.print();


    }
}
