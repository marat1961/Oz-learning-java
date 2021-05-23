import java.lang.reflect.*;

class ReflectionUtils {

    public static int countPublicMethods(Class targetClass) {
        Method[] methods = targetClass.getDeclaredMethods();
        int n = 0;
        for (Method method : methods) {
            int m = method.getModifiers();
            if (Modifier.isPublic(m)) {
                n++;
            }
        }
        return n;
    }
}

//class Main {
//    public static void main(String[] args) {
//        ReflectionUtils utils = new ReflectionUtils();
//        int n = utils.countPublicMethods(utils.getClass());
//        System.out.println(n);
//    }
//}