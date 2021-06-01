import java.util.ArrayList;
import java.util.List;

class BoxInside {

    // Complete this method
    public static void showAnimal(Box<? extends Animal> box) {
        System.out.println(box.getAnimal());
    }
}

// Don't change the code below
class Animal {

    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}

class Box<T> {

    private T animal;

    void setAnimal(T animal) {
        this.animal = animal;
    }

    T getAnimal() {
        return animal;
    }
    public static void main(String[] args) {
        System.out.println(wildcardsTest(new ArrayList<>()));
    }

    public static Integer wildcardsTest(List<? extends Integer> numbers) {
        numbers.add(null);
        return numbers.get(0);
    }
}
