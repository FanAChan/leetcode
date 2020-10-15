package sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * 冒泡排序
 * 比较相邻两个数的大小，将大的数往后挪，
 * 相当于每轮在未排序的数组中将最大的数挪到了数组最后一位
 * 每一轮比较都可以进行一次值的交换
 * 时间复杂度 O(n2)
 */
public class BubbleSort implements SortSolution {
    @Override
    public void deal(int[] array) {
        if(null == array || array.length == 0){
            return;
        }
        int len = array.length;

        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }

    }

}
