package solution;

import base.TreeNode;

import java.util.List;

public class HasPathSum {

    public boolean hasPathSum(TreeNode root, int sum) {

        if(null == root){
            return false;
        }
        if(null == root.left && null == root.right ) {
            return root.val == sum;
        }
        return hasPathSum(root.left,sum - root.val) || hasPathSum(root.right,sum -root.val);
    }

}
