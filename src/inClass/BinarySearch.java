package inClass;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] ints = {1,2,4,5,7,9,11};
        String[] words = {"this", "list", "needs", "to", "be",
                "sorted", "so", "it", "works"};
        System.out.println(binarySearch(ints, 5));
        Arrays.sort(words);
        System.out.println(Arrays.toString(words));
        System.out.println(binarySearch2(words, "works"));

    }

    //returns the index of number to find for int collection
    private static int binarySearch(int[] number, int numberToFind){
        int left = 0; //first element
        int right = number.length -1; //last element

        while(left <= right){
            int middle = (right + left)/2;
            int middleNumber = number[middle];
            if (numberToFind == middleNumber){
                return middle;
            }
            if (numberToFind < middleNumber){
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1; //if not found
    }

    //returns the index of number to find for String collection
    private static int binarySearch2(String[] words, String wordToFind){
        int left = 0; //first element
        int right = words.length -1; //last element

        while(left <= right){
            int middle = (right + left)/2;
            String middleWord = words[middle];
            if (wordToFind.compareTo(middleWord) == 0){
                return middle;
            }
            if (middleWord.compareTo(wordToFind) > 0){
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1; //if not found
    }

    //binary search using recursion
    private static int binarySearch3(Integer[] ints, int numToFind, int left, int right){
        int middle = (right + left) / 2;

        if (ints[middle].compareTo(numToFind) == 0){
            return middle;
        }
        if (left > right){
            return -1; //base case
        }
        if (ints[middle].compareTo(numToFind) < 0){
            return binarySearch3(ints, numToFind, middle + 1, right);
        } else {
            return binarySearch3(ints, numToFind, left, middle - 1);
        }
    }


}
