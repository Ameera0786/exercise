package inClass;

abstract class Shape {
    private double x;
    private double y;
    private String color;

    public Shape(double x, double y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    abstract double getArea();

    public String toString(){
        return "With a center of " + x + ", " + y +
                "has an area of " + getArea();
    }
}