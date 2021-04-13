package solution;

import base.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class IsSubStructure {

    public boolean isSubStructure(TreeNode A, TreeNode B) {

        if (A == null || B == null) {
            return false;
        }
        boolean result = false;
        if (A.val == B.val) {
            result = isSubStructureV2(A, B);
        }
        return result || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean isSubStructureV2(TreeNode A, TreeNode B) {

        if(B == null){
            return true;
        }
        if (A == null ) {
            return false;
        }
        if (A.val != B.val) {
            return false;
        }
        return isSubStructureV2(A.left, B.left) && isSubStructureV2(A.right, B.right);
    }

    @Test
    public void test() throws Exception {
        TreeNode A = TreeNode.buildTree(new int[]{3, 5, 0, 3, 4});
        TreeNode B = TreeNode.buildTree(new int[]{1, -4, 2, -1, 3, -3, -4, 0, -3, -1});
        Assert.assertFalse(isSubStructure(A, B));

//        TreeNode A = TreeNode.buildTree(new int[]{1,0,1,-4,3});
//        TreeNode B = TreeNode.buildTree(new int[]{1,-4});
//        Assert.assertFalse(isSubStructure(A,B));
    }
}
