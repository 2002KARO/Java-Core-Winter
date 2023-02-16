package homework.homework2;

public class MaxMinMassive {
    public static void main(String[] args) {
        int[]book={7000,89000,700000,};
        int max = book[0];
        for (int i = 1; i < book.length ; i++) {
            if (max<book[i]){
                max=book[i];
            }
        }System.out.println(max);
        int min = book[0];
        for (int i = 1; i < book.length; i++) {
            if (min>book[i]){
                min=book[i];
            }

        }
        System.out.println(min);

    }
}
