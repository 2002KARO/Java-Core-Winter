package homework.Homework9;

public class DynamicArrayDemo {
    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();
        for (int i = 0; i < 10; i++) {
            dynamicArray.add(i + 1);

        }


        dynamicArray.print();
        System.out.println(dynamicArray.getIndexByValue(5));
        dynamicArray.print();


    }

}
