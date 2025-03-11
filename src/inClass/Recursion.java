package inClass;

public class Recursion {
    public static void main(String[] args) {
        sayHi(3); //prints hi thrice
        System.out.println(factorial(5));
        System.out.println(bunnyEars(128));

    }

    private static void sayHi(int count){

        System.out.println("hi");
        if (count <= 1){
            return;
        }
        sayHi(count - 1);
    }

    public static int factorial(int n) {
        if (n == 1){
            return 1; //base case
        }
        int answer = n * factorial(n-1);
        return answer;
    }

    private static int bunnyEars(int bunnies){
        //each bunny has two ears
        if (bunnies == 0){
            return 0;
        }
        int answer = 2 + bunnyEars(bunnies - 1);
        return answer;
    }

}
