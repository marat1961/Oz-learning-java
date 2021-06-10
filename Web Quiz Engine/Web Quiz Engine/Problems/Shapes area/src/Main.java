class Shape {
    public double area() {
        return 0;
    }
}

class Triangle extends Shape {
    double height;
    double base;

    public double area() {
        return base * height * 0.5;
    }
}

class Circle extends Shape {
    double radius;

    public double area() {
        return Math.PI * (radius * radius);
    }
}

class Square extends Shape {
    double side;

    public double area() {
        return side * side;
    }
}

class Rectangle extends Shape {
    double width;
    double height;

    public double area() {
        return width * height;
    }
}