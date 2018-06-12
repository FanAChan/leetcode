package solution;

import base.ListNode;
import org.junit.Test;

import java.util.*;

/**
 * @author Achan
 * @date 2018/6/12 21:34
 **/
public class MergekSortedLists {

	public ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<ListNode> minQueue = new PriorityQueue<>(lists.length,
				(n1, n2) -> Integer.compare(n1.val, n2.val));
		if(lists == null || lists.length == 0){
			return null;
		}
		ListNode result = new ListNode(0);
		ListNode head = result;

		for (ListNode list : lists) {
			if(list != null) {
				minQueue.add(list);
			}
		}

		while (minQueue.size() > 0) {
			ListNode temp = minQueue.poll();
			result.next = temp;
			result = result.next;
			if (temp.next != null) {
				minQueue.add(temp.next);
			}
		}
		return head.next;
	}

	@Test
	public void test() {
		ListNode list1 = ListNode.listNode(new int[]{1, 4, 5});
		ListNode list2 = ListNode.listNode(new int[]{1, 3, 4});
		ListNode list3 = ListNode.listNode(new int[]{2, 6});
		ListNode[] lists = {list1, list2, list3};
		ListNode result = mergeKLists(lists);

		System.out.println(result);

	}
}
