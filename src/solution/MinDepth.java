package solution;

import base.TreeNode;

public class MinDepth {


    public int minDepth(TreeNode root) {
        if(null == root){
            return 0;
        }
        int right = minDepth(root.right);
        int left = minDepth(root.left);
        if(0 == right || 0 == left)
            return right + left + 1;
        else
            return Math.min(right,left) + 1;
    }

}
