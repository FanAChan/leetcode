package solution;

import base.ListNode;


/**
 * @author Achan
 * @date 2018/5/5 23:02
 * <p>
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * <p>
 * Example 2:
 * <p>
 * Input: 1->1->1->2->3
 * Output: 2->3
 **/
public class RemoveDuplicatesfromSortedListII {

	public static ListNode deleteDuplicates(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}
		ListNode cur = head;
		ListNode pre = null;
		ListNode next = null;
		int val = 0;
		boolean bool = false;

		while (cur != null) {

			val = cur.val;
			next = cur.next;

			while (next != null && next.val == val) {
				next = next.next;
				bool = true;
			}
			//头部开始有重复的值
			if (bool && pre == null) {
				return deleteDuplicates(next);
			} else if (bool) {//非头部开始有重复值
				cur = next;
				pre.next = cur;
			} else {//当前节点没有重复值
				pre = cur;
				cur = next;
			}
			bool = false;
		}

		return head;
	}

	public static void main(String[] args) {
		System.out.println(deleteDuplicates(ListNode.listNode(new int[]{1,2,3,3,4,4,5})));
	}
}
