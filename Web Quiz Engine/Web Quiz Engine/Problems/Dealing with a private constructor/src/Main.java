import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

class InstanceUtils {

    public static Person createPerson(String name, int age) {
        Class<Person> clazz = Person.class;
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            Class[] params = constructor.getParameterTypes();
            if (Modifier.isPrivate(constructor.getModifiers()) &&
                    constructor.getParameterCount() == 2) {
                Class p1 = params[0];
                Class p2 = params[1];
                if (p1 == String.class && p2.isPrimitive() && "int".equals(p2.getName())) {
                    constructor.setAccessible(true);
                    try {
                        return (Person) constructor.newInstance(name, age);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        return null;
    }

    static int f(int[] array, int left, int right) {
        if (left == right) {
            if (array[left] % 2 == 0)
                return 1;
            else
                return 0;
        } else {
            int middle = (left + right) / 2;
            return f(array, left, middle)
                    + f(array, middle + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] array = {0, 2, 6, 4, 5};
        System.out.println(f(array, 0, 4));
//        Person person = InstanceUtils.createPerson("Bob", 12);
//        System.out.println(person);
    }

}

class Person {
    private String name = "unknown";
    private int age;

    private Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
