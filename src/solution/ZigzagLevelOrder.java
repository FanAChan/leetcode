package solution;

import base.ListNode;
import base.TreeNode;

import java.util.*;

public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        //将第一层放入集合
        //遍历集合 取值并把下一层的节点放入集合
        List<List<Integer>> result = new ArrayList<>();
        if(null == root){
            return result;
        }
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);

        boolean zigzag = false;

        while (!treeNodes.isEmpty()) {
            int size = treeNodes.size();
            LinkedList thisLevelNum = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode next = treeNodes.poll();
                if (null != next.left) {
                    treeNodes.offer(next.left);
                }
                if (null != next.right) {
                    treeNodes.offer(next.right);
                }
                if(zigzag){
                    //尾部插入
                    thisLevelNum.add(next.val);
                }else{
                    //头部插入
                    thisLevelNum.push(next.val);
                }
            }
            zigzag = !zigzag;
            result.add(thisLevelNum);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        treeNode.left = left;
        TreeNode right = new TreeNode(20);
        treeNode.right = right;

        right.left = new TreeNode(18);
        right.right = new TreeNode(30);
        ZigzagLevelOrder zigzagLevelOrder = new ZigzagLevelOrder();
        List<List<Integer>> lists = zigzagLevelOrder.zigzagLevelOrder(treeNode);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }
}
