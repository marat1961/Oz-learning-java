import java.util.Scanner;

class Main {
    public static void main(String... args) {
        ClassLoader mainClassLoader = Main.class.getClassLoader();
        System.out.println(mainClassLoader.getName());
    }
}

class Main1 {
    public static void main(String[] args) {
        ClassLoader classLoader = A.class.getClassLoader();
        System.out.println(classLoader.getName());
    }
}

class A {
}