package inClass;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Comparing {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            list.add((int)(Math.random() * 10) + 1);
        }
        list.sort(Comparator.naturalOrder());
        list.sort(Comparator.reverseOrder());
        list.sort((a, b) -> a % 2 == 0 && b % 2 == 1 ? 1 : a-b);
        String[] array = {"I", " hate", " driving", " in", " the", " snow"};
        List<String> words = Arrays.asList(array);
        words.sort(Comparator.naturalOrder());
        words.sort(Comparator.reverseOrder());
        words.sort((a, b) -> a.charAt(a.length() - 1) -
                b.charAt(b.length() - 1));
        words.sort(Comparator.comparingInt(a -> a.charAt(a.length() - 1)));
    }
}
