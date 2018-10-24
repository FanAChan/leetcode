package solution;

import base.TreeLinkNode;
import org.junit.Test;

/**
 * @author Achan
 * @date 2018/10/12 10:37
 **/
public class PopulatingNextRightPointersinEachNode {

	public void connect(TreeLinkNode root) {
		connectEachLevel(root);
	}

	public void connectEachLevel(TreeLinkNode first) {
		//下层头节点
		TreeLinkNode head;
		TreeLinkNode temp = new TreeLinkNode(0);
		TreeLinkNode prev = temp;
		while (first != null) {
			if (first.left != null) {
				prev.next = first.left;
				prev = prev.next;
			}
			if (first.right != null) {
				prev.next = first.right;
				prev = prev.next;
			}
			first = first.next;
		}
		head = temp.next;
		if (head != null) {
			connect(head);
		}
	}


	@Test
	public void test() {
		TreeLinkNode root = new TreeLinkNode(1);
		root.left = new TreeLinkNode(2);
		root.right = new TreeLinkNode(3);
		connect(root);
	}
}
