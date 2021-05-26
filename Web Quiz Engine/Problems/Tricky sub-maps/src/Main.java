import java.util.*;

class MapUtils {
    public static Map<Integer, String> getSubMap(TreeMap<Integer, String> map) {
/*        Map<Integer, String> r = new LinkedHashMap<>();
        NavigableSet<Integer> set;
        Integer lo;
        Integer hi;
        if (map.firstKey() % 2 != 0) {
            set = map.navigableKeySet();
            lo = set.first();
            hi = lo + 4;
        } else {
            set = map.descendingKeySet();
            hi = set.first();
            lo = hi - 4;
        }
        for (int key = hi; key >= lo && key <= hi; key--) {
            String value = map.get(key);
            if (value != null) {
                r.put(key, value);
            }
        }
        return r;*/
        return map.firstKey() % 2 != 0 ?
                map.subMap(map.firstKey(), true, map.firstKey() + 4, true).descendingMap() :
                map.subMap(map.lastKey() - 4, true, map.lastKey(), true).descendingMap();
    }
}

/* Do not modify code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<Integer, String> map = new TreeMap<>();
        Arrays.stream(scanner.nextLine().split("\\s")).forEach(s -> {
            String[] pair = s.split(":");
            map.put(Integer.parseInt(pair[0]), pair[1]);
        });

        Map<Integer, String> res = MapUtils.getSubMap(map);
        res.forEach((k, v) -> System.out.println(k + " : " + v));
    }
}