package solution;

import base.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class GenerateTrees {


    public List<TreeNode> generateTrees(int n) {
        if( n == 0) return new ArrayList<>();
        List<TreeNode> treeNodes = generateTrees(1, n);
        return treeNodes;
    }


    private List<TreeNode> generateTrees(int from,int end) {
        ArrayList<TreeNode> list = new ArrayList<>();
        if(from > end) {
            list.add(null);
            return list;
        }
        int i = from;
        while (i <= end){
            List<TreeNode> rightTreeList = generateTrees(i + 1, end);
            List<TreeNode> leftTreeList = generateTrees(from, i-1);
            for (TreeNode right : rightTreeList) {
                for (TreeNode left : leftTreeList) {
                    TreeNode node = new TreeNode(i);
                    list.add(node);
                    node.right = right;
                    node.left = left;
                }
            }
            i++;
        }
        return list;
    }


    public static void main(String[] args) {

        InorderTraversal inorderTraversal = new InorderTraversal();
        GenerateTrees generateTrees = new GenerateTrees();
        List<TreeNode> treeNodes = generateTrees.generateTrees(1, 2);
        for (TreeNode treeNode : treeNodes) {
            List<Integer> integers = inorderTraversal.inorderTraversal(treeNode);
            System.out.println(integers);
        }
    }



}
