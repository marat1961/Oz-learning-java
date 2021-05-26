import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int cnt = Integer.parseInt(s);
        double[] incomes = getNumbers(scanner, cnt);
        double[] taxes = getNumbers(scanner, cnt);
        int no = 0;
        double max = 0.0;
        for (int i = 0; i < cnt; i++) {
            double r = incomes[i] * taxes[i] * 0.01;
            if (r > max) {
                max = r;
                no = i + 1;
            }
        }
        System.out.println(no);
    }

    private static double[] getNumbers(Scanner scanner, int cnt) {
        String s = scanner.nextLine();
        String[] ss = s.split(" ");
        double[] r = new double[cnt];
        for (int i = 0; i < cnt; i++) {
            r[i] = Integer.parseInt(ss[i]);
        }
        return r;
    }

}