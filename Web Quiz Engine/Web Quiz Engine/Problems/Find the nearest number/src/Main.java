import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = readArrayList(scanner);
        int num = scanner.nextInt();
        ArrayList<Integer> r = findNearest(list, num);
        Collections.sort(r);
        r.forEach(n -> System.out.print(n + " "));
    }

    private static ArrayList<Integer> findNearest(ArrayList<Integer> list, int num) {
        ArrayList<Integer> r = new ArrayList<>();
        int nearest = Integer.MAX_VALUE;
        for (int n : list) {
            int delta = Math.abs(num - n);
            nearest = Math.min(delta, nearest);
        }
        for (int n : list) {
            int delta = Math.abs(num - n);
            if (delta == nearest) {
                r.add(n);
            }
        }
        return r;
    }

    private static ArrayList<Integer> readArrayList(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}