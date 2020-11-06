package solution;

import base.TreeNode;

public class SortedArrayToBST {


    public TreeNode sortedArrayToBST(int[] nums) {

        if(null == nums || nums.length == 0){
            return null;
        }
        return sortedArrayToBST(nums,0,nums.length - 1);

    }


    public TreeNode sortedArrayToBST(int[] nums,int from,int end) {


        if(from > end){
            return null;
        }
        int mid = (from + end)/2;

        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left =sortedArrayToBST(nums,from,mid - 1);
        treeNode.right =sortedArrayToBST(nums,mid + 1,end);
        return treeNode;
    }
}
