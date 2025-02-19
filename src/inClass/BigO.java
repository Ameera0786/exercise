package inClass;

import java.util.List;
public class BigO {
    public static void main(String[] args) {

    }
    private static int count(List<String> list){
        int count = 0; // 1
        // n times (depends on list size)
        for (int i = 0; i < list.size(); ++i){ // 1 initialize i
            count += list.get(i).length(); // 3 get, get length, add to count
        }
        // Increment i, check condition 2
        // n * numOfSteps = n * 5 = 5n
        // 5n + 3
        return count; // 1

        // Big O is O(n)
    }

    private static int wordLength(int index, List<String> list){
        return list.get(index).length(); // 3 get, get length, return'
        // O(1)
    }

    private static int wordLengthMath(List<String> list){
        int total = 0; // 1
        // n (size of list)
        for (int i = 0; i < list.size(); ++i){ // 1 initialize
            // n (size of list)
            for (int j = i + 1; j < list.size(); ++j){ // 1 initialize
                total += list.get(i).length() * list.get(j).length(); // 5 get, get length, get, get length, multiply
                // increment and exit 2
            } // 7n + 1(j inner loop)
            // increment and exit 2
        }
        return total; // 1
        //n(7n + 1) + 3 = 7n^2 + n + 3
        // O(n^2)
    }
}
