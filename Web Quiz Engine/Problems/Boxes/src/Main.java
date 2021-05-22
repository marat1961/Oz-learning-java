import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] a1 = new int[3];
        a1[0] = scanner.nextInt();
        a1[1] = scanner.nextInt();
        a1[2] = scanner.nextInt();

        int[] a2 = new int[3];
        a2[0] = scanner.nextInt();
        a2[1] = scanner.nextInt();
        a2[2] = scanner.nextInt();

        Arrays.sort(a1);
        Arrays.sort(a2);
        int ge = 0;
        int le = 0;
        for (int i = 0; i < a1.length; i++) {
            int a = a1[i];
            int b = a2[i];
            if (a > b) {
                ge++;
            }
            if (a < b) {
                le++;
            }
        }
        if (ge == 3) {
            System.out.println("Box 1 > Box 2");
        } else if (le == 3) {
            System.out.println("Box 1 < Box 2");
        } else {
            System.out.println("Incompatible");
        }
    }
}