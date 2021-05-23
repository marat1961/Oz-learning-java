import java.lang.reflect.Method;

import static java.lang.Class.*;

class MethodFinder {

    public static String findMethod(String methodName, String[] classNames) {
        for (String s : classNames) {
            try {
                Class cls = forName(s);
                Method[] methods = cls.getMethods();
                for (Method method : methods) {
                    if (method.getName().equals(methodName)) {
                        return cls.getName();
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

//public class Main {
//    public static void main(String[] args) {
//        String methodName = "abs";
//        String[] classNames = {"java.lang.String", "java.lang.StringBuffer", "java.lang.Math"};
//        String s = MethodFinder.findMethod(methodName, classNames);
//        System.out.println(s);
//    }
//}