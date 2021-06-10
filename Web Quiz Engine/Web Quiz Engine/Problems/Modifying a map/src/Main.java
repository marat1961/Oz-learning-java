import java.util.*;

class MapUtils {

    public static void mapShare(Map<String, String> map) {
        String a = map.get("a");
        if (a != null) {
            map.put("b", a);
        }
        map.remove("c");
    }

}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> map = new HashMap<>();
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String[] pair = s.split(":");
            map.put(pair[0], pair[1]);
        }
//        map.put("a", "abstraction");
//        map.put("b", "boolean");
//        map.put("c", "xyz");
        MapUtils.mapShare(map);
        map.forEach((key, value) -> System.out.println(key + ":" + value));
    }
}