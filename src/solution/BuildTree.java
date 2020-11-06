package solution;

import base.TreeNode;

import java.util.Arrays;

public class BuildTree {


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (null == preorder || inorder == null)
            return null;

        if (preorder.length != inorder.length || preorder.length == 0) {
            return null;
        }
        if(preorder.length == 1){
            return new TreeNode(preorder[0]);
        }
        TreeNode treeNode = new TreeNode(preorder[0]);
        int index = this.indexOfNum(preorder[0], inorder, 0, inorder.length);

        int[] leftInOrder = Arrays.copyOfRange(inorder, 0, index);
        int[] rightInOrder = Arrays.copyOfRange(inorder, index + 1, inorder.length);

        int[] leftPreOrder = Arrays.copyOfRange(preorder, 1, index + 1);
        int[] rightPreOrder = Arrays.copyOfRange(preorder, index + 1, preorder.length);

        treeNode.left = buildTree(leftPreOrder,leftInOrder);
        treeNode.right = buildTree(rightPreOrder,rightInOrder);
        return treeNode;

    }

    private int indexOfNum(int num, int[] arrays, int from, int end) {
        for (; from < end; from++) {
            if (arrays[from] == num) {
                return from;
            }
        }
        return -1;
    }

    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        if (null == postorder || inorder == null)
            return null;

        int length = postorder.length;
        if (length != inorder.length || length == 0) {
            return null;
        }
        if(length == 1){
            return new TreeNode(postorder[0]);
        }
        TreeNode treeNode = new TreeNode(postorder[length - 1]);
        int index = this.indexOfNum(postorder[length - 1], inorder, 0, inorder.length);

        int[] leftInOrder = Arrays.copyOfRange(inorder, 0, index);
        int[] rightInOrder = Arrays.copyOfRange(inorder, index + 1, inorder.length);

        int[] leftPostOrder = Arrays.copyOfRange(postorder, 0, index);
        int[] rightPostOrder = Arrays.copyOfRange(postorder, index, length - 1);

        treeNode.left = buildTree2(leftInOrder,leftPostOrder);
        treeNode.right = buildTree2(rightInOrder,rightPostOrder);
        return treeNode;
    }


    public static void main(String[] args) {

        BuildTree buildTree = new BuildTree();
        int[] i = {9,3,15,20,7};
        int[] j=  {9,15,7,20,3};
        TreeNode treeNode = buildTree.buildTree2(i, j);

        System.out.println();

    }


}
