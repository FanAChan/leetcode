package solution.binarySearch;

import org.junit.Test;

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 */
public class MinArray {

    public int minArray(int[] numbers) {

        if(numbers.length < 1){
            return numbers[0];
        }

        int start = 0;
        int end = numbers.length - 1;
        while (start < end){
            int mid = start + (end - start)/2;
            if(numbers[mid] > numbers[start]){
                start = mid + 1;
            }else if(numbers[mid] < numbers[start]) {
                end = mid;
            }else{
                start++;
            }
        }
        return numbers[start];
    }

    public int minArray2(int[] numbers) {

        if(numbers.length < 1){
            return numbers[0];
        }

        int start = 0;
        int end = numbers.length - 1;
        while (start < end){
            int mid = start + (end - start)/2;

            if(numbers[mid] < numbers[end]){
                end = mid;
            }else if(numbers[mid] > numbers[end]){
                start = mid + 1;
            }else{
                start++;
            }
        }
        return numbers[start];
    }

    @Test
    public void test(){

        long x = System.currentTimeMillis();
        int y = 0;
        for(int i = 0;i<10000;i++){
            y++;
        };
        System.out.println(System.currentTimeMillis() - x);

    }
}
