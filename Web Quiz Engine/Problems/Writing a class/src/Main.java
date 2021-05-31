//write code of the Shelf class here
class Shelf<T extends Book> {

    private T element;

    public void setElement(T e) {
        this.element = e;
    }

    public T getElement() {
        return element;
    }
}
