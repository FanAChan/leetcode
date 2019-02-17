package solution;

import base.ListNode;
import org.junit.Test;

/**
 * @author Achan
 * @date 2018/10/25 14:21
 **/
public class RemoveNthFromEndOfList {


	public ListNode removeNthFromEnd(ListNode head, int n) {

		ListNode second = head;
		ListNode prev = null;

		for (int i = 0; i < n; i++) {
			second = second.next;
		}
		ListNode temp = head;
		while (second != null){
			prev = temp;
			temp = temp.next;
			second = second.next;
		}
		ListNode next = temp.next;
		if(next != null){
			temp.val = next.val;
			temp.next = next.next;
		}else if(prev != null){
			prev.next = null;
		}else{
			head = null;
		}
		return head;
	}


	@Test
	public void test() {
		removeNthFromEnd(ListNode.listNode(new int[]{1,2,3,4,5,6}),6);
	}
}
