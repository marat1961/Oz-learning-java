import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt = scanner.nextInt();
        int[] a = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            a[i] = scanner.nextInt();
        }
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        boolean ok = true;
        for (int i = 1; i < cnt; i++) {
            int p = a[i - 1];
            int c = a[i];
            if ((p == n && c == m) || (p == m && c == n)) {
                ok = false;
                break;
            }
        }
        System.out.println(ok);
    }
}