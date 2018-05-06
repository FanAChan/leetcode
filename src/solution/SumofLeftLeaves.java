package solution;

import base.TreeNode;

/**
 * @author Achan
 * @date 2018/5/6 10:49
 * <p>
 * Find the sum of all left leaves in a given binary tree.
 * <p>
 * Example:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 **/
public class SumofLeftLeaves {
	public int sumOfLeftLeaves(TreeNode root) {
		int res = 0;
		if (root == null) {
			return res;
		}
		TreeNode left = root.left;
		if (left != null && left.left == null && left.right == null) {
			res += left.val;
		}
		return res +sumOfLeftLeaves(left) + sumOfLeftLeaves(root.right);
	}
}
