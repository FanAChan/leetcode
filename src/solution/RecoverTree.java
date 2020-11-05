package solution;

import base.TreeNode;

public class RecoverTree {

    private TreeNode pre;

    public void recoverTree(TreeNode root) {
        if(null == root) return;
        recoverTree(root,null,null);
    }

    public void recoverTree(TreeNode root,TreeNode min,TreeNode max) {


    }
}
