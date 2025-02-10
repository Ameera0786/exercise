package inClass;

public class FunctionalExample {
    public static void main(String[] args) {
        DoMath myMath = (a, b) -> a + b;
        DoMath myMath2 = (a, b) -> a - b;
        System.out.println(myMath.theMath(80, 23.5));
        System.out.println(myMath2.theMath(34.7, 11.13));
        System.out.println(allMath(3,4, (double a, double b) -> a * b));
        System.out.println(allMath(4,0, (double a, double _) -> a * a));
    }

    private static double allMath(double a, double b, DoMath m){
        return m.theMath(a,b);
    }
    public interface DoMath{
        double theMath(double a, double b);

    }
}
