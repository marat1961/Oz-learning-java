class Holder<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}

class MyClass<T> {

    private T t;

    public MyClass(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}

class Main {
    public static void main(String... args) {
        MyClass instance = new MyClass("Hello!");
        System.out.println(instance.get().getClass());

        // initialize an instance of Holder to make the code below compiled
        Holder<String> holder = new Holder<>();

        // do not change the code below
        holder.set("This is an instance of String");

        String value = holder.get();
        System.out.println(value);
    }
}