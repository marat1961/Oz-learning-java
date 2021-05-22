import java.util.ArrayList;

class Main {
    ArrayList<String> list = new ArrayList<>();

    void init() {
        list.add("one");
        list.add("two");
        list.add("three");
    }
}

class Test {
    public static void main(String[] args) {
        Main main = new Main();
        int i = 0;
        System.out.println(i);
    }
}