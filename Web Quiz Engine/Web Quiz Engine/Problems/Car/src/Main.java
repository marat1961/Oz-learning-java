class Car {

    int yearModel;
    String make;
    int speed;

    void accelerate() {
        this.speed += 5;
    }

    void brake() {
        this.speed = Math.max(0, this.speed - 5);
    }
}