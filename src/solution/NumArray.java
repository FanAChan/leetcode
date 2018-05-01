package solution;

/**
 * @author Achan
 * @date 2018/4/27 23:24
 * <p>
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j),
 * inclusive.
 * <p>
 * Example:
 * <p>
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * <p>
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 **/
class NumArray {

    int[] nums;

    public NumArray(int[] nums) {
        if (nums != null) {
            for (int i = 1; i < nums.length; i++) {
                nums[i] += nums[i - 1];
            }
        }
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (i < 0 || j >= nums.length || i > j) {
            return 0;
        }
        if (i == 0) {
            return nums[j];
        }
        return nums[j] - nums[i - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
