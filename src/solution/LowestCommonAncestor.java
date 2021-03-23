package solution;

import base.TreeNode;

public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        TreeNode result = null;

        while (root != null){

            if(root.val < p.val && root.val < q.val){
                root = root.right;
            }
            else if(root.val > p.val && root.val > q.val){
                root = root.left;
            }else{
                result = root;
                break;
            }
        }
        return result;
    }
}
