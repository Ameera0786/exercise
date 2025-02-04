package inClass;

public class Circle extends Shape{
    private double radius;

    public Circle(double x, double y, String color, double radius) {
        super(x, y, color);
        this.radius = radius;
    }

    @Override
    double getArea() {
        return Math.PI * radius * radius;
    }

    public String toString(){
        return "The area of this circle is " + getArea();
    }
}
