abstract class Shape {

    abstract double getPerimeter();

    abstract double getArea();
}

class Triangle extends Shape {
    double a;
    double b;
    double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getArea() {
        double s = getPerimeter() * 0.5;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    double getPerimeter() {
        return a + b + c;
    }
}

class Circle extends Shape {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * (radius * radius);
    }

    @Override
    double getPerimeter() {
        return  2 * Math.PI * radius;
    }
}

class Rectangle extends Shape {
    double width;
    double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    double getPerimeter() {
        return width * 2 + height * 2;
    }

    public static void main(String[] args) {
        Triangle t = new Triangle(3, 4, 5);
        System.out.println("perimeter="+ t.getPerimeter() + ", area=" + t.getArea());
        Rectangle r = new Rectangle(5, 10);
        System.out.println("perimeter="+ r.getPerimeter() + ", area=" + r.getArea());
        Circle c = new Circle(10);
        System.out.println("perimeter="+ c.getPerimeter() + ", area=" + c.getArea());
    }
}