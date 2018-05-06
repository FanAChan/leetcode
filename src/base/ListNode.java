package base;

/**
 * Definition for singly-linked list.
 *
 * @author Achan
 *
 */
public class ListNode {
	public int val;
	public ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}

	public static ListNode listNode(int[] arrays){
		if(arrays != null){
			ListNode head = new ListNode(arrays[0]);
			ListNode temp = head;
			for (int i = 1; i < arrays.length; i++) {
				int array = arrays[i];
				temp.next = new ListNode(array);
				temp = temp.next;
			}
			return head;
		}
		return null;
	}

	@Override
	public String toString() {
		if(next == null){
			return "["+val+"]";
		}
		return "["+val+"]"+next.toString();
	}
}
