package chapter3.Homework4;

public class CharrArrayExample {
    public static void main(String[] args) {
        char[] chars = {'j','a','v',' ','a','l','o','v','e'};
        char c = 'o';
        int count =0;
        for (char a : chars) {
            if (a==c){
                count++;

            }

        }
        System.out.println("count."+count);
        System.out.println();
        if (chars[chars.length - 2] == 'l'
                && chars[chars.length-1]=='y'){
            System.out.println(true);

        }else
            System.out.println(false);
        System.out.println();
        System.out.println(chars[chars.length/2]+" ");
        System.out.println();
        for (char aChar : chars) {
            if (aChar!=' '){
                System.out.print(aChar);
            }
            
        }





    }
}
