package solution;

import base.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {


    public List<Integer> inorderTraversal(TreeNode root) {
        List result = new ArrayList<Integer>();
       if(root != null){
           inorderTraversal(root,result);
       }
       return result;
    }

    private void inorderTraversal(TreeNode root,List<Integer> list) {
        if(root == null){
            return;
        }
        this.inorderTraversal(root.left,list);
        list.add(root.val);
        this.inorderTraversal(root.right,list);

    }
}

