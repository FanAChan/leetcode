package solution;

import base.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * @author Achan
 * @date 2018/10/11 1:29
 **/
public class BinaryTreeZigzagLevelOrderTraversal {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		LinkedList<List<Integer>> results = new LinkedList<>();
		int level = 0;
		Stack<TreeNode> cur = new Stack<>();
		Stack<TreeNode> next = new Stack<>();

		next.push(root);
		do {
			cur = next;
			next = new Stack<>();
			LinkedList<Integer> list = new LinkedList<>();
			while (!cur.isEmpty()) {
				TreeNode pop = cur.pop();
				if (pop != null) {
					list.add(pop.val);
					if ((level & 1) == 0) {
						next.push(pop.left);
						next.push(pop.right);
					} else {
						next.push(pop.right);
						next.push(pop.left);
					}
				}
			}
			if (!list.isEmpty()) {
				results.add(list);

			}
			level++;
		} while (!next.isEmpty());
		return results;
	}

	@Test
	public void test() {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		zigzagLevelOrder(root);
	}
}
