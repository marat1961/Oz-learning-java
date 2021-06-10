// do not remove imports

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

class ArrayUtils {

    public static <T> T[] invert(T[] a) {
        int b = 0;
        int e = a.length - 1;
        while (b < e) {
            T temp = a[b];
            a[b] = a[e];
            a[e] = temp;
            b++;
            e--;
        }
        return a;
    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String t = scanner.nextLine();
//        String s = scanner.nextLine();
//        String[] a = s.split(" ");
//        String[] r = invert(a);
//        for (String e : r) {
//            System.out.print(e + " ");
//        }
//    }

}