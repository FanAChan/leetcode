package solution;

import base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTraversal {



    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        if(null == root){
            return  list;
        }
        list.add(root.val);
        list.addAll(preorderTraversal(root.left));
        list.addAll(preorderTraversal(root.right));
        return list;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if(null == root){
            return  list;
        }
        Stack<TreeNode> stack = new Stack<>();


        while ( !stack.isEmpty() || null != root){
            while (null != root){
                list.add(root.val);
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return list;
    }



    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(null == root){
            return  list;
        }
        list.addAll(postorderTraversal(root.left));
        list.addAll(postorderTraversal(root.right));
        list.add(root.val);
        return list;
    }


    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if(null == root){
            return  list;
        }
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || null != root){
            while (null != root){
                stack.push(root);
                root = root.left;
            }
            root = stack.peek();

            if(root == null){
                root = stack.pop();
                list.add(root.val);
                root = stack.peek().right;
            }else{
                stack.push(root);
                root = root.right;
            }
        }

        return list;

    }

}
