package readability;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println(checkText(line) ? "EASY" : "HARD");
    }

    private static boolean checkText(String line) {
        String[] sentences = line.split("[.!?]");
        int sc = 0;
        int wc = 0;
        for (String s : sentences) {
            sc = sc + 1;
            String[] words = s.split("\\s");
            for (String w : words) {
                if (w.length() > 0) {
                    wc = wc + 1;
                }
            }
        }
        double average = (double)wc / (double)sc;
        return (sc == 0) || (average <= 10.0);
    }

}
