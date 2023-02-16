package homework.Homework7;

public class ArrayExampleDemo {


    public static void main(String[] args) {
        ArrayExample ay = new ArrayExample();
        char[] chars = {' ', ' ', 'H', 'e', ' ', 'l', 'l', 'o', ' ', ' ', ' ',};
        ay.trim(chars);
        System.out.println();

        int[] numbers = {4, 3, 5, 6, 2, 1, 8, 9, 0};
        for (int number : numbers) {
            System.out.print(number + " ");

        }
        System.out.println();

        ay.sort(numbers);
        for (int number : numbers) {
            System.out.print(number + " ");


        }


    }
}
