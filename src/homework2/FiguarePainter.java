package homework2;

public class FiguarePainter {
    public static void main(String[] args) {
        for (int i = 4; i > 0; i--) {
            for (int j = 7; j > i ; j--) {
                System.out.print("  ");

            }
            for (int j = 0; j < i ; j++) {
                System.out.print("* ");

            }
            System.out.println();

        }
        for (int i = 0; i <=4; i++) {
            for (int j = i; j < 4; j++) {
                System.out.print(" ");

            }
            for (int j = 0; j < i ; j++) {
                System.out.print("* ");

            }
            System.out.println();

        }
        for (int i = 3; i > 0 ; i--) {
            for (int j = 4; j > i; j--) {
                System.out.print(" ");

            }
            for (int j = 0; j < i ; j++) {
                System.out.print("* ");

            }
            System.out.println();

        }
    }
}
