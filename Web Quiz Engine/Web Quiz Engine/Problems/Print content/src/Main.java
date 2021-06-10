// do not remove imports

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

class ArrayUtils {
    public static <T> String info(T[] array) {
        String r = "";
        for (Object obj : array) {
            if (!r.isEmpty()) {
                r = r + ", ";
            }
            r = r + obj.toString();
        }
        return "[" + r + "]";
    }

//    public static void main(String[] args) {
//        Integer[] ai = {8, 11, 3, 7};
//        System.out.println(info(ai));
//        String[] as = {"one", "two", "three"};
//        System.out.println(info(as));
//    }
}