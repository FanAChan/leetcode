package solution;

import base.TreeNode;

import java.util.Stack;

public class SumNumbers {

    public int sumNumbers(TreeNode root) {
        if(null == root){
            return 0;
        }
        return sumNumbers(root,0);
    }

    public int sumNumbers(TreeNode root,int preSum) {

        if(null == root){
            return 0;
        }
        int sum = preSum * 10 + root.val;
        if(root.left == null && root.right == null){
            return sum;
        }
        return sumNumbers(root.left,sum) + sumNumbers(root.right,sum);

    }
}
