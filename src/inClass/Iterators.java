package inClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

//Iterate through list
//Linked list - start at head and go through each time
//Iterates through linked list and grabs inside data
public class Iterators {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> list2 = new LinkedList<>();
        Collection<String> collection =  new ArrayList<>();
        String[] words = {"Happy", "Sad", "Mad", "Angry", "Acceptance"};
        list.addAll(Arrays.asList(words));
        list2.addAll(Arrays.asList(words));
        collection.addAll(Arrays.asList(words));

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        //LinkedList (manual)
        Iterator<String> iterator = list2.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        //Collections
        for (String s: collection) {
            System.out.println(s);
        }
        List<String> list3 = new TheLinkedList<>();
        list3.addAll(Arrays.asList(words));
        for (String s: list3) {
            System.out.println(s);
        }
    }
}
