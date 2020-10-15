package sort;


/**
 * 选择排序
 *
 * 在未排序的数组序列中，查询最小的值放在未排序数组的首位
 *  最多进行n轮交换
 * 时间复杂度 O(n2)
 *
 */
public class SelectSot implements SortSolution {

    @Override
    public void deal(int[] array) {
        if(null == array || array.length == 0){
            return;
        }

        int len = array .length;
        for(int i =0;i<len;i++){
            int smallest = array[i];
            int index = i;
            for(int j = i;j<len;j++){
                if(array[j] < smallest){
                    smallest = array[j];
                    index = j;
                }
            }
            if(index != i){
                array[index] = array[i];
                array[i] = smallest;
            }
        }
    }
}
