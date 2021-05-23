import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Get value for a given public field or null if the field does not exist or is not accessible.
 */
class FieldGetter {

//    public String mm = "wer";
//    private int pf = 0;

    public Object getFieldValue(Object object, String fieldName) throws IllegalAccessException {
        Field field = null;
        try {
            field = object.getClass().getField(fieldName);
        } catch (NoSuchFieldException e) {
            return null;
        }
        if (Modifier.isPrivate(field.getModifiers())) {
            return null;
        }
        return field.get(object);
    }

}

//public class Main {
//    public static void main(String[] args) throws Exception {
//        FieldGetter fieldGetter = new FieldGetter();
//        Object f = fieldGetter.getFieldValue(fieldGetter, "mm");
//        System.out.println(f.toString());
//        f = fieldGetter.getFieldValue(fieldGetter, "pf");
//        System.out.println(f == null);
//        f = fieldGetter.getFieldValue(fieldGetter, "invalid");
//        System.out.println(f == null);
//    }
//}