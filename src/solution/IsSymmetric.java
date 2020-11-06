package solution;

import base.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        //中序遍历对称
        if(null == root) return true;
        return isSymmetric(root.left,root.right);
//        ArrayList<Integer> list = new ArrayList<>();
//        inorder(root,list);
//
//
//        int size = list.size();
//
//        for(int i = 0;i< size/2 ;i++){
//
//            Integer temp1 = list.get(i);
//            Integer temp2 = list.get(size - i - 1);
//            if(null == temp1 && null == temp2)
//                continue;
//
//            if(null == temp1 || null == temp2){
//                return false;
//            }
//            if(temp1 != temp2){
//                return false;
//            }
//        }
//        return true;
    }

    private void inorder(TreeNode root, List<Integer> list){
        if(root == null) {
            list.add(null);
            return;
        }

        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }


    public boolean isSymmetric(TreeNode left,TreeNode right) {
        if (null == left && null == right) {
            return true;
        }
        if (null == left || null == right) {
            return false;
        }
        return left.val == right.val && isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);

    }
}
