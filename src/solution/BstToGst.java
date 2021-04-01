package solution;

import base.TreeNode;
import org.junit.Test;

import java.util.Optional;
import java.util.Stack;
import java.util.TreeSet;

public class BstToGst {


    public TreeNode bstToGst(TreeNode root) {

        Stack<TreeNode> nodes = new Stack<>();
        int pre = 0;
        Stack<TreeNode> stack = new Stack<>();
        get(root,stack);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            pop.val = pop.val + pre;
            pre = pop.val;
        }
        return root;
    }

    private void get(TreeNode root,Stack<TreeNode> stack){
        if(null == root){
            return;
        }
        get(root.left,stack);
        stack.add(root);
        get(root.right,stack);
    }

    @Test
    public void test() throws Exception {

        TreeNode treeNode = TreeNode.buildTree(new int[]{4, 1, 6, 0, 2, 5, 7, -1, -1, -1, 3, -1, -1, -1, 8});
        TreeNode treeNode1 = bstToGst(treeNode);
        System.out.println(1);
    }



}
