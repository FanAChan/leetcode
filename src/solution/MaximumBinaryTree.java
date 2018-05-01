package solution;

import base.TreeNode;

/**
 * @author Achan
 * @date 2018/4/10 23:19
 * <p>
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
 * <p>
 * The root is the maximum number in the array.
 * The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
 * The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
 * <p>
 * Construct the maximum tree by the given array and output the root node of this tree.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,1,6,0,5]
 * Output: return the tree root node representing the following tree:
 * <p>
 * 6
 * /   \
 * 3     5
 * \    /
 * 2  0
 * \
 * 1
 **/
public class MaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums, int from, int end) {
        if(from == end){
            return  new TreeNode(nums[from]);
        }
        int maxIndex = findMax(nums, from, end);

        TreeNode root = new TreeNode(nums[maxIndex]);
        if (maxIndex > from) {
            root.left = constructMaximumBinaryTree(nums, from, maxIndex - 1);
        }
        if (maxIndex < end) {
            root.right = constructMaximumBinaryTree(nums, maxIndex + 1, end);
        }
        return root;
    }

    public static int findMax(int[] nums, int from, int end) {
        int maxIndex = from;
        while (from <= end) {
            if (nums[maxIndex] < nums[from]) {
                maxIndex = from;
            }
            from++;
        }
        return maxIndex;
    }
}
