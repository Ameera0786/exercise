package inClass;

public class Rectangle extends Shape{
    private double width;
    private double height;

    public Rectangle(double x, double y, String color, double width, double height) {
        super(x, y, color);
        this.width = width;
        this.height = height;
    }

    public double getArea(){
        return width * height;
    }

    public String toString(){
        return "The area of this rectangle is " + getArea();
    }
}
