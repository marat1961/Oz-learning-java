import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt = scanner.nextInt();
        int maxn = Integer.MIN_VALUE;
        while (cnt-- > 0) {
            int n = scanner.nextInt();
            if (n % 4 == 0 && n > maxn) {
                maxn = n;
            }
        }
        System.out.println(maxn);
    }
}