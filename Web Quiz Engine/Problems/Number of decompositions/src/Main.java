import java.util.ArrayList;
import java.util.Scanner;

class Main {

    static ArrayList<String> lines = new ArrayList<>();
    static int[] iArr = new int[100];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        part(n, n, 0);
        for (int i = lines.size(); i > 0; i--) {
            String s = lines.get(i - 1);
            System.out.println(s);
        }
    }

    static void part(int n, int k, int i) {
        if (n < 0) {
            return;
        }
        if (n == 0) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < i; j++) {
                sb.append(iArr[j] + " ");
            }
            lines.add(sb.toString());
        } else {
            if (n >= k) {
                iArr[i] = k;
                part(n - k, k, i + 1);
            }
            if (k > 1) {
                part(n, k - 1, i);
            }
        }
    }

}