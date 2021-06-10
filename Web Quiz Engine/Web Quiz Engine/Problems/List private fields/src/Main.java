import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Get sorted list of private fields the object declares (inherited fields should be skipped).
 */
class FieldGetter {

//    private int n = 0;
//    private int a = 0;

    public List<String> getPrivateFields(Object object) {
        List<String> r = new ArrayList<>();
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            int m = field.getModifiers();
            if (Modifier.isPrivate(m)) {
                r.add(field.getName());
            }
        }
        r.sort(String::compareTo);
        return r;
    }

}

public class Main {

    public static void main(String[] args) throws Exception {
        Main.class.getMethod("hello").invoke(null);
    }

    static void hello() {
        System.out.println("Hello world!");
    }

}
//class Main {
//    public static void main(String[] args) {
//        FieldGetter utils = new FieldGetter();
//        List<String> fields = utils.getPrivateFields(utils);
//        fields.forEach(System.out::println);
//    }
//}