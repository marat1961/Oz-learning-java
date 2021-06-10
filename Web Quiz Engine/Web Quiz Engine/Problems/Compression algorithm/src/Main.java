import java.util.Scanner;

class Parser {

    private String s;
    private int index = 0;

    public Parser(String s) {
        this.s = s;
    }

    public char getc() {
        if (index < s.length()) {
            return s.charAt(index++);
        } else {
            return 0;
        }
    }
}

class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Parser parser = new Parser(s);
        char ch = parser.getc();
        StringBuffer sb = new StringBuffer();
        do {
            int count = 1;
            char c = parser.getc();
            while (c == ch) {
                c = parser.getc();
                count++;
            }
            sb.append(ch);
            sb.append(count);
            ch = c;
        } while (ch != 0);
        System.out.println(sb.toString());
    }
}