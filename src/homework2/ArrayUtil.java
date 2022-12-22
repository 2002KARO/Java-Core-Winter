package homework2;

public class ArrayUtil {
    public static void main(String[] args) {
        int[]myArray={2,5,8,10,32,22,11,66,12,30};
        for (int i = 0; i < 10 ; i++) {
            System.out.println(myArray[i]);

        }
        int min = myArray[0];
        for (int i = 0; i < myArray.length; i++) {
            if (min>myArray[i]){
                min=myArray[i];}
        }
        System.out.println();
        System.out.println(min);

        {
            int max= myArray[0] ;
            for (int i = 0; i < myArray.length; i++) {
                if (max<myArray[i]){
                    max =myArray[i];
                    System.out.println(max);}}
        }

    }

}
