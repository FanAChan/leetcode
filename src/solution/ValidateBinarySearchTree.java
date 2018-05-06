package solution;

import base.TreeNode;

import java.util.ArrayList;

/**
 * @author Achan
 * @date 2018/5/6 11:04
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 2
 * / \
 * 1   3
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * Output: false
 * Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
 * is 5 but its right child's value is 4.
 **/
public class ValidateBinarySearchTree {

	public boolean isValidBST(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
		InOrderTree(root, list);
		boolean res = true;
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i) >= list.get(i + 1)) {
				res = false;
				break;
			}
		}
		return res;
	}

	public void InOrderTree(TreeNode root, ArrayList<Integer> list) {
		if (root == null) {
			return;
		}
		InOrderTree(root.left, list);
		list.add(root.val);
		InOrderTree(root.right, list);
	}
}
