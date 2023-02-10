package classwork.bracechecker;

public class BraceChecker {
    private String text;

    public BraceChecker(String text) {
        this.text = text;

    }

    public void check() {
        int last;
        char lastBracket;

        Stack stack = new Stack();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    last = stack.pop();
                    if (last == 0) {
                        System.out.println("Error at" + i + "closed " + c + ")but not opened");
                    } else {
                        lastBracket = (char) last;
                        if (lastBracket != '(') {
                            System.out.println("Error at" + "opened" + lastBracket + "but closed" + c);
                        }
                    }
                    break;
                case '}':
                    last = stack.pop();
                    if (last == 0) {
                        System.out.println("Error at" + i + "closed " + c + ")but not opened");
                    } else {
                        lastBracket = (char) last;
                        if (lastBracket != '{') {
                            System.out.println("Error at" + "opened" + lastBracket + "but closed" + c);
                        }
                    }
                    break;
                case ']':
                    last = stack.pop();
                    if (last == 0) {
                        System.out.println("Error at" + i + "closed " + c + ")but not opened");
                    } else {
                        lastBracket = (char) last;
                        if (lastBracket != '[') {
                            System.out.println("Error at" + "opened" + lastBracket + "but closed" + c);

                        }
                    }


            }
        }
        while ((lastBracket = (char) stack.pop()) != 0) {
        System.out.println("Error:opened" + lastBracket + "but not closed");
       // while (!stack.isEmpty()) {
         //   System.out.println("Error:opened" + (char) stack.pop() + "but not closed");
        }


    }
}

