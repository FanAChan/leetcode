package solution;

import base.TreeNode;

public class MaxDepth {

    public int maxDepth(TreeNode root) {
        if(null == root) return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + (leftDepth > rightDepth ? leftDepth:rightDepth);
    }


}
