package inClass;

import java.util.Stack;

public class StackDriver {
    public static void main(String[] args) {
        final Integer[] nums = {1, 4, 2, 6, 7, 9};
        Stack<Integer> stack = new Stack<>();
        TheStack<Integer> theStack = new TheStack();
        for (int i = 0; i < nums.length; i++) {
            stack.push(nums[i]);
            theStack.push(nums[i]);
        }
    }
}
