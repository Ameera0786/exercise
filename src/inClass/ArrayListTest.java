package inClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ArrayListTest {
    private TheArrayList<Integer> list;
    @BeforeEach
    void setUp() {
        list = new TheArrayList<>();
    }

    @Test
    @DisplayName("Testing ArrayList size")
    void size(){
        final int numTests = 10_000;
        Assertions.assertEquals(0, list.size());
        Assertions.assertTrue(list.add(1));
        Assertions.assertEquals(1, list.size());
        list = new TheArrayList<>();
        for (int i = 0; i < numTests; ++i){
            Assertions.assertEquals(i, list.size());
            Assertions.assertTrue(list.add(i));
        }
    }
    @Test
    @DisplayName("Testing Contains")
    void contains(){
        //boundary Conditions
        //1. list is empty - false
        //2. list not empty but item not there - false
        //3. list not empty but item is there - true
        //4 list not empty but multiple copies - true
        //5. list has 1 item - our item - true
        //6. list has 1 item - not our item - false;
        //7. list has many items - ours is last - true;
        list = new TheArrayList<>();
        Assertions.assertFalse(list.contains(1));
        list.add(0);
        Assertions.assertFalse(list.contains(1));
        Assertions.assertFalse(list.contains(0));
        list.add(1);
        list.add(2);
        Assertions.assertTrue(list.contains(1));
        Assertions.assertTrue(list.contains(2));
        Assertions.assertFalse(list.contains(3));

    }
}