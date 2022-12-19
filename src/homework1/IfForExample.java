package homework1;

public class IfForExample {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        { if (a<b) System.out.println(b);
        else System.out.println(a);}
        {for (int i = 10; i < 20; i++) {
            System.out.println(i);}

            {char c = (char) a;
            char v =(char)  b;
            System.out.println(c);
            System.out.println(v);}

            {int p=70;
            int d=90;
            if (p==d) System.out.println("p equal d ");
            else System.out.println("p Not equal d ");}
        }

    }
}
