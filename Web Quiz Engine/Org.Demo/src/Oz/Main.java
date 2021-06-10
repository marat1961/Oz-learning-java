package Oz;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

interface a {
    void a();
}
interface b extends a {
    void b();
}

class Cinema {
    int[][] tickets;
    int rows;
    int cols;
    int seat;
    int seq;

    public void read() {
        final Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);
        rows = scanner.nextInt();
        cols = scanner.nextInt();
        tickets = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int v = scanner.nextInt();
                tickets[i][j] = v;
            }
        }
        seat = scanner.nextInt();
    }

    public int findSeats() {
        for (int i = 0; i < rows; i++) {
            int seq = 0;
            for (int j = 0; j < cols; j++) {
                if (tickets[i][j] != 0) {
                    seq = 0;
                } else {
                    seq = seq + 1;
                    if (seq >= seat) {
                        return i + 1;
                    }
                }
            }
        }
        return 0;
    }

}
class P2d implements P2dI {
    double x;
    double y;

    public P2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public P2d plus(P2d p) {
        return new P2d(x + p.x, y + p.y);
    }

    public P2d minus(P2d p) {
        return new P2d(x - p.x, y - p.y);
    }

    public double dot(P2d p) {
        return x * p.x + y * p.y;
    }

    public double cross(P2d p) {
        return x * p.y - y * p.x;
    }

    public double magnitude() {
        return Math.hypot(x, y);
    }

    public double angle() {
        double a = Math.atan2(y, x);
        return Math.PI + (a - Math.PI) % (2 * Math.PI);
    }

    public double angleTo(final P2d p) {
        return Math.acos(dot(p) / (magnitude() * p.magnitude()));
    }

    @Override
    public P2d plus_plus(P2d p) {
        return null;
    }
}


public class Main {


    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);
        P2d a = new P2d(scanner.nextDouble(), scanner.nextDouble());
        P2d b = new P2d(scanner.nextDouble(), scanner.nextDouble());
        double delta = a.angle() - b.angle();
        double alpha = Math.PI + (delta - Math.PI) % (2 * Math.PI);
        System.out.println(Math.toDegrees(alpha));
        System.out.println(Math.toDegrees(a.angleTo(b)));
    }

    public static void printRangeToFile(String file, boolean append, int fromIncl, int toExcl) {
        try (FileWriter writer = new FileWriter(file, append)) {
            for (int i = fromIncl; i < toExcl; i++) {
                writer.write(i + " ");
            }
        } catch (IOException e) {
            System.out.printf("An exception occurs %s", e.getMessage());
        }
    }

    private static int calcSyllables(String w) {
        return Math.max(1, w.toLowerCase()
                .replaceAll("e$", "")
                .replaceAll("[aeiouy]{2}", "a")
                .replaceAll("[^aeiouy]", "")
                .length());
    }

    public static String concatenateStringsWithoutDigits(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch) || Character.isWhitespace(ch)) {
                continue;
            }
            sb.append(ch);
        }
        return sb.toString();
    }

    private static void quadraticEquationw(double a, double b, double c) {
        double root1, root2;
        double determinant = b * b - 4 * a * c;
        if (determinant > 0) {
            root1 = (-b + Math.sqrt(determinant)) / (2 * a);
            root2 = (-b - Math.sqrt(determinant)) / (2 * a);
            if (root1 < root2) {
                System.out.println(root1 + " " + root2);
            } else {
                System.out.println(root2 + " " + root1);
            }
        } else if (determinant == 0) {
            root1 = root2 = -b / (2 * a);
            System.out.println(root1);
        } else {
            double real = -b / (2 * a);
            double imaginary = Math.sqrt(-determinant) / (2 * a);
            System.out.println(real + " - i" + imaginary);
            System.out.format(real + " + i" + imaginary);
        }
    }

    private static void geron() {
        final Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        double p = (a + b + c) * 0.5;
        double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        System.out.println(s);
    }

}

class Matrix {

    int[][] rotatedMatrix;
    int[][] sourceMatrix;
    int m;
    int n;

    public void read() {
        final Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);
        m = scanner.nextInt();
        n = scanner.nextInt();
        sourceMatrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int v = scanner.nextInt();
                sourceMatrix[i][j] = v;
            }
        }
    }

    public void rotate() {
        rotatedMatrix = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int v = sourceMatrix[i][j];
                rotatedMatrix[j][m - i - 1] = v;
            }
        }

    }

    public void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(rotatedMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
