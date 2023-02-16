package homework.homework2;

public class ArrayUtil {
    public static void main(String[] args) {
        int [] books={11,22,33,1,6,7,8,9};
        int first = books[0];
        System.out.println("first element");
        System.out.println(first);
        System.out.println();
        int last = books[books.length-1];
        System.out.println("last element");
        System.out.println(last);
        System.out.println();
        System.out.println("middle elemet");
        System.out.println(books[books.length/2]);
        System.out.println();
        System.out.println("max element");
        int max = books[0];
        for (int i = 0; i < books.length; i++) {
            if (max< books[i]){
                max=books[i];}}
        System.out.println(max);
        System.out.println();
        System.out.println("min element");
        int min = books[books.length-1];
        for (int i = 0; i < books.length; i++) {
            if (min > books[i]) {
                min = books[i];
            }}System.out.println(min);
        System.out.println();
        System.out.println("all even elements");
        for (int x : books) {
            if (x % 2 == 0)
            System.out.println(x);}
        System.out.println();
        System.out.println("all odd elements");
        for (int y : books) {
            if (y%2!=0)
            System.out.println(y);}
        System.out.println();
        System.out.println("evenCount");
        int evenCount=0;
        for (int q : books) {
            if (q%2==0){
                evenCount++;}}
        System.out.println(evenCount);
        System.out.println();
        System.out.println("oddCount");
        int oddCount =0;
        for (int n : books) {
            if (n%2 ==1){
                oddCount++;
            }
        }System.out.println(oddCount);
        System.out.println();
        System.out.println("sum");
        int sum =0;
        for (int a:books) {
            sum+=a;}
        System.out.println(sum);


        }









            }













