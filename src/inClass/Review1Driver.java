package inClass;

public class Review1Driver {
    public static void main(String[] args) {
        Shape shape = (Math.random() < 0.5) ?
                new Rectangle(0,0,"orange", 2, 5) :
                new Circle(0,0, "red", 5);
    }
}
