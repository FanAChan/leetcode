package solution;

import base.ListNode;

/**
 * @author Achan
 * @date 2018/5/5 22:56
 * <p>
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->1->2
 * Output: 1->2
 * <p>
 * Example 2:
 * <p>
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 **/
public class RemoveDuplicatesfromSortedList {

	public ListNode deleteDuplicates(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}
		ListNode cur = head;
		int pre = cur.val;
		while (cur.next!=null){
			if(cur.next.val == pre){
				cur.next = cur.next.next;
			}else{
				cur = cur.next;
				pre = cur.val;
			}
		}
		return head;
	}
}
