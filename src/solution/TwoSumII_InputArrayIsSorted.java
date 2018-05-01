package solution;

/**
 * @author Achan
 * @date 2018/4/7 13:25
 *
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution and you may not use the same element twice.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
 **/
public class TwoSumII_InputArrayIsSorted {

    public int[] twoSum(int[] numbers, int target) {
        int[] results = new int[2];
        int length = numbers.length;
        int pre = 0;
        int last = length - 1;
        while (pre < last){
            if(numbers[pre] + numbers[last] >target){
                last--;
            }else if(numbers[pre] + numbers[last] < target) {
                pre++;
            }else{
                results[0] = pre + 1;
                results[1] = last + 1;
                break;
            }
        }
        return results;
    }


    public static void main(String[] args) {
        TwoSumII_InputArrayIsSorted test = new TwoSumII_InputArrayIsSorted();
        int[] array = new int[]{2,7,11,15};
        int[] result = test.twoSum(array,17);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
