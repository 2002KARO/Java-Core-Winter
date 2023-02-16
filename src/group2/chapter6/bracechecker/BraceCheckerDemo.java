package group2.chapter6.bracechecker;

public class BraceCheckerDemo {
    public static void main(String[] args) {
        String text ="(Hello {Java] (((2022";
        BraceChecker braceChecker =new BraceChecker(text);
        braceChecker.check();

    }
}
