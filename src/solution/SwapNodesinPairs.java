package solution;

import base.ListNode;

/**
 * @author Achan
 * @date 2018/5/7 16:38
 * <p>
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * Example:
 * <p>
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * <p>
 * Note:
 * <p>
 * Your algorithm should use only constant extra space.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 **/
public class SwapNodesinPairs {

	public ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}
		ListNode temp = head.next.next;
		head.next.next = head;
		head = head.next;
		head.next.next = swapPairs(temp);
		return head;
	}
}
