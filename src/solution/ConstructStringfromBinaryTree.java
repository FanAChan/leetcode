package solution;

import base.TreeNode;
import org.junit.Test;

/**
 * @author Achan
 * @date 2018/10/3 21:06
 **/
public class ConstructStringfromBinaryTree {

	public String tree2str(TreeNode t) {
		if(t == null){
			return "";
		}
		StringBuilder result = new StringBuilder();
		result.append(t.val);
		String left = leftTree(t.left);
		String right = rightTree(t.right);
		if (!("()".equals(left) && "".equals(right))) {
			result.append(left).append(right);
		}
		return result.toString();
	}

	private String leftTree(TreeNode t) {
		if (t != null) {
			StringBuilder result = new StringBuilder();
			result.append("(");
			result.append(tree2str(t)).append(")");
			return result.toString();
		} else {
			return "()";

		}
	}

	private String rightTree(TreeNode t) {
		if (t != null) {
			StringBuilder result = new StringBuilder();
			result.append("(");
			result.append(tree2str(t)).append(")");
			return result.toString();
		} else {
			return "";

		}
	}

	@Test
	public void test() {
		TreeNode head = new TreeNode(1);
		head.left = new TreeNode(2);
		head.right = new TreeNode(3);
		head.left.right = new TreeNode(4);
		String s = tree2str(head);
		System.out.println(s);
	}
}
