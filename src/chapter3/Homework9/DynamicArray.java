package chapter3.Homework9;

public class DynamicArray {
    private int[] array = new int[10];
    //This is  my massive new element
    private int size = 0;

    public void add(int value) {
        if (size == array.length) {
            extend();

        }
        array[size++] = value;


    }

    private void extend() {
        int[] newArray = new int[array.length + 10];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];


        }
        array = newArray;

    }

    public int getByIndex(int index) {
        if (index < 0 || index > size - 1) {
            System.out.println("Error Index");
            return -1;


        }
        return array[index];

    }
//System.out.print massive plus element
    public void print() {
        for (int i = 0; i < size ; i++) {
            System.out.println(array[i]+" ");

        }

    }


}
