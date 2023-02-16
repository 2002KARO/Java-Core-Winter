package homework.homework5;

public class ArraySpaceExample {
    public static void main(String[] args) {
        char[] spaceArray = {' ', 'c', 'a', 't', ' ', 'b', 'i', ' ', 'b', ' ', ' '};
        int started =0;
        int finalid= spaceArray.length;
        for (char value : spaceArray) {
            if (value!= ' '){
                break;
            }started++;

        }
        for (int i = spaceArray.length-1; i > 0; i--) {
            if (spaceArray[i]!= ' '){
                break;
            }
            finalid--;
        }
        char[]result=new char[finalid-(started-1)];
        int a=0;
        for (int i = started; i <finalid+1 ; i++) {
            result[a]=spaceArray[i];
            a++;

        }
        for (Character c : result) {
            System.out.println(c);
            System.out.println();

        }
    }
}
