package sort;

import org.junit.Test;

import java.util.Arrays;

public class SortTest {

    static final int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
    @Test
    public void bubbleSortTest(){
        // 只需要修改成对应的方法名就可以了

        SortSolution sort = new BubbleSort();
        sort.deal(array);
        System.out.println(Arrays.toString(array));
    }

    @Test
    public void selectSortTest(){
        // 只需要修改成对应的方法名就可以了

        SortSolution sort = new SelectSot();
        sort.deal(array);
        System.out.println(Arrays.toString(array));
    }
}
