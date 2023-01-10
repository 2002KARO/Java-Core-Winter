package chapter3.homework5;

public class ArraySort {
    public static void main(String[] args) {
        int[]numbers={43,55,5,-9,0,12,5,65};
        int o =0;
        System.out.print("StartMassive");
        for (int el : numbers) {
            System.out.print(el+" ");

        }
        System.out.println("\nSort Asceding");
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                o++;
                if (numbers[i] > numbers[j])
                    o=numbers[i];
                numbers[i]=numbers[j];
                numbers[j]=o;

            }

        }
        for (int el : numbers) {
            System.out.print(el+" ");

        }
        System.out.println("/nSort descending");
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length ; j++) {
                o++;
               if (numbers[i]<numbers[j]){
                   o=numbers[i];
                   numbers[i]=numbers[j];
                   numbers[j]=o;}
            }
        }
    }
}
