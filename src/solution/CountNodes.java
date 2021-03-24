package solution;

import base.TreeNode;

public class CountNodes {



    public int countNodes(TreeNode root) {
        if(null == root){
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);

    }

}
