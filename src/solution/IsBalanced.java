package solution;

import base.TreeNode;

public class IsBalanced {


    public boolean isBalanced(TreeNode root) {
        return this.height(root) != -1;
    }

    private int height(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        if (-1 == left || -1 == right || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;

    }
}
