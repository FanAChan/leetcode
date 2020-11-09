package solution;

import base.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryToLink {


    public void flatten(TreeNode root) {
        if(null == root){
            return;
        }
        //前序遍历
        List<TreeNode> treeNodes = new ArrayList<>();
        preOrder(treeNodes,root);


        TreeNode head = null;
        for (TreeNode treeNode : treeNodes) {
            treeNode.left = null;
            treeNode.right = null;
            if(null != head){
                head.right = treeNode;
            }
            head = treeNode;
        }
    }

    private void preOrder(List<TreeNode> list,TreeNode root){
        if(null == root){
            return;
        }
        list.add(root);
        preOrder(list,root.left);
        preOrder(list,root.right);
    }


}
