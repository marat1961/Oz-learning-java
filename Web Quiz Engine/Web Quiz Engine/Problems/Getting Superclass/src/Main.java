class SuperClassGetter {

    public Class getSuperClassByName(String name) throws ClassNotFoundException {
        Class forName = Class.forName(name);
        return forName.getSuperclass();
    }

    public Class getSuperClassByInstance(Object object) {
        return object.getClass().getSuperclass();
    }
}

//public class Main {
//    public static void main(String[] args) {
//        SuperClassGetter cg = new SuperClassGetter();
//        String c = null;
//        try {
//            c = cg.getSuperClassByName("java.lang.Integer").getName();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        System.out.println(c);
//        Integer s = 0;
//        System.out.println(s.getClass().getName());
//        c = cg.getSuperClassByInstance(s).getName();
//        System.out.println(c);
//    }
//}