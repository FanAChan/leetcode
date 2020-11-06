package solution;

import base.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderBottom {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();

        if(null == root){
            return result;
        }
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);

        while (!treeNodes.isEmpty()){

            int size = treeNodes.size();

            List<Integer> list = new ArrayList<>();
            for(int i = 0;i<size;i++){
                TreeNode node = treeNodes.poll();

                list.add(node.val);

                if(null != node.left){
                    treeNodes.offer(node.left);
                }
                if(null != node.right){
                    treeNodes.offer(node.right);
                }

            }

            result.add(0,list);

        }
        return result;
    }
}
