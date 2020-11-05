package solution;

import base.TreeNode;

import java.util.List;

public class IsValidBST {


    public boolean isValidBST(TreeNode root) {
        if(null == root) return true;
        return isValidBST(root,null,null);
    }

    private boolean isValidBST(TreeNode root,TreeNode min,TreeNode max){

        if(null == root) return true;

        if(null != min && root.val <=min.val) return false;

        if(null != max && root.val >= max.val) return false;

        return isValidBST(root.left,min,root) && isValidBST(root.right,root,max);


    }


    public boolean isValidBST2(TreeNode root) {
        if(null == root) return true;
        InorderTraversal inorderTraversal = new InorderTraversal();
        List<Integer> inorderTraversalList = inorderTraversal.inorderTraversal(root);
        Integer preNum = null;
        for (Integer integer : inorderTraversalList) {

            if(preNum != null && preNum.compareTo(integer) > 0){
                return false;
            }
            preNum = integer;
        }
        return true;
    }
}
