
class Box<T extends Animal> {

    private List<T> objects;

    public Box() {
        this.objects =  new ArrayList<>();
    }

    public void add(T obj) {
        this.objects.add(obj);
    }
}

// Don't change the code below
class Animal {}