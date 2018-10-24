package solution;

import base.ListNode;
import org.junit.Test;

/**
 * @author Achan
 * @date 2018/10/12 13:40
 **/
public class DeleteNodeinaLinkedList {


	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;


	}
	@Test
	public void test() {

	}
}
