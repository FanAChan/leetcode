package base;

/**
 * @author Achan
 * @date 2018/4/7 14:41
 **/
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode buildTree(int[] arrays){

        TreeNode treeNode = buildTree(arrays, 0);
        return treeNode;
    }

    private static TreeNode buildTree(int[] arrays,int index){
        if (index >= arrays.length || -1 == arrays[index]) {
            return null;
        }
        TreeNode treeNode = new TreeNode(arrays[index]);

        treeNode.left = buildTree(arrays,index * 2 + 1);
        treeNode.right = buildTree(arrays,index * 2 + 2);
        return treeNode;
    }



}
