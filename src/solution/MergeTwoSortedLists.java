package solution;

import base.ListNode;
import org.junit.Test;

/**
 * @author Achan
 * @date 2018/10/25 15:12
 **/
public class MergeTwoSortedLists {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		ListNode result = new ListNode(0);
		ListNode node = result;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				node.next = l1;
				l1 = l1.next;
			} else {
				node.next = l2;
				l2 = l2.next;
			}
			node = node.next;
		}
		if (l1 == null) {
			l1 = l2;
		}
		node.next = l1;
		return result.next;
	}

	@Test
	public void test() {
		mergeTwoLists(ListNode.listNode(new int[]{1, 2, 4}), ListNode.listNode(new int[]{1, 3, 4}));
	}
}
