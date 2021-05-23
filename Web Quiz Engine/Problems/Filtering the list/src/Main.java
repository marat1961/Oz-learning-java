import java.util.*;
import java.util.stream.Collectors;

class Main {

    public static List<String> make(List<String> lst) {
        List<String> r = new ArrayList<>();
        for (int i = 0; i < lst.size(); i++) {
            if (i % 2 != 0) {
                r.add(lst.get(i) + " ");
            }
        }
        Collections.reverse(r);
        return r;
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final List<String> values = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        List<String> r = make(values);
        r.forEach(System.out::print);
    }
}