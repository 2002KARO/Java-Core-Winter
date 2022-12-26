package homework2;

public class ArrayUtil2 {
    public static void main(String[] args) {
        int[]Shortsarr={12,33,6,90,88,7,5,0};
        int arrlen = Shortsarr.length;
        int numeralsCount = 0;
        int notnumeralsCount = 0;
        int arrsum = 0;
        int arrFirstElement=Shortsarr[0];
        int arrLastElement=Shortsarr[arrlen -1];
        int arrMiddleElement = Shortsarr[arrlen /2];
        //all elements
        System.out.println("All Elemenets; ");
        for (int i = 0; i < Shortsarr.length ; i++) {
            arrsum+=Shortsarr[i];
            System.out.print(i+")" +Shortsarr[i]);
            if (i!=arrlen -1);{
                System.out.print(", ");
            }
            System.out.println();
            //All numerals not numerals
            // numerals and not numerals count
            System.out.println();
            for (int j = 0; j < Shortsarr.length; j++) {
                if (Shortsarr[i]% 2 == 0){
                    numeralsCount++;{
                        System.out.print(Shortsarr[i]);}
                    if (i != arrlen -1){
                        System.out.print(", ");
                    }notnumeralsCount ++;


                }


            }
            System.out.println();
            System.out.print("notnumeralsCount:"+ numeralsCount+ "\n");
            System.out.println("notnumeralsCount:"+ notnumeralsCount);
            System.out.println("sum of array elemnts:"+ arrsum);
            System.out.println("the arihmetic mean of the numbers:" +(double)arrsum/arrlen);
            System.out.println("LastElement:"+arrLastElement);
            System.out.println("FirstElement:"+arrFirstElement);
            System.out.println("MiddleElement:"+arrMiddleElement);


        }


    }
}
