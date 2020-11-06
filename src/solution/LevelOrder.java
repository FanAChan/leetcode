package solution;

import base.TreeNode;
import jdk.nashorn.internal.ir.CallNode;

import java.lang.reflect.Array;
import java.util.*;

public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {

        //将第一层放入集合
        //遍历集合 取值并把下一层的节点放入集合
        List<List<Integer>> result = new ArrayList<>();

        List<TreeNode> treeNodes = new ArrayList<>();
        List<TreeNode> treeNodes2 = new ArrayList<>();
        treeNodes.add(root);
        while (treeNodes.size() > 0) {
            int size = treeNodes.size();
            ArrayList<Integer> thisLevelNum = new ArrayList<>();
            for(int i = 0;i<size;i++){
                TreeNode next = treeNodes.get(i);
                thisLevelNum.add(next.val);
                if(null != next.left){
                    treeNodes2.add(next.left);
                }
                if(null != next.right){
                    treeNodes2.add(next.right);
                }
            }
            result.add(thisLevelNum);

            List<TreeNode> temp = treeNodes;
            treeNodes = treeNodes2;
            treeNodes2 = temp;
            treeNodes2.clear();
        }
        return result;

    }

    public List<List<Integer>> levelOrder2(TreeNode root) {

        //将第一层放入集合
        //遍历集合 取值并把下一层的节点放入集合
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        while (!treeNodes.isEmpty()) {
            int size = treeNodes.size();
            ArrayList<Integer> thisLevelNum = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode next = treeNodes.poll();
                thisLevelNum.add(next.val);
                if (null != next.left) {
                    treeNodes.offer(next.left);
                }
                if (null != next.right) {
                    treeNodes.offer(next.right);
                }
            }
            result.add(thisLevelNum);
        }
        return result;

    }
}
