import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wc = Integer.parseInt(scanner.nextLine());
        Set<String> dict = new TreeSet<>();
        for (int i = 0; i < wc; i++) {
            String w = scanner.nextLine().toLowerCase();
            dict.add(w);
        }
        int tc = Integer.parseInt(scanner.nextLine());
        Set<String> err = new TreeSet<>();
        for (int i = 0; i < tc; i++) {
            String text = scanner.nextLine().toLowerCase();
            String[] items = text.split("\\s+");
            for (String item : items) {
                if (!dict.contains(item)) {
                    err.add(item);
                }
            }
        }
        scanner.close();
        err.forEach(System.out::println);
    }
}