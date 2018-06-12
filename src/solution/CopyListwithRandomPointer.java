package solution;

import base.RandomListNode;

/**
 * @author Achan
 * @date 2018/6/12 20:28
 **/
public class CopyListwithRandomPointer {


	public RandomListNode copyRandomList(RandomListNode head) {

		if(head == null){
			return null;
		}

		RandomListNode result = head;
		RandomListNode cur = head;

		while (cur != null) {
			RandomListNode copy = new RandomListNode(cur.label);
			copy.next = cur.next;
			cur.next = copy;
			cur = copy.next;
		}
		cur = head;
		while (cur != null) {
			RandomListNode copy = cur.next;
			if(cur.random != null){
				copy.random = cur.random.next;
			}
			cur = copy.next;
		}
		cur = head;
		RandomListNode copy = null;
		if(cur != null){
			result = copy =  cur.next;
			cur.next = copy.next;
			cur = cur.next;
		}
		while (cur != null) {
			copy.next = cur.next;
			copy = copy.next;
			cur.next = copy.next;
			cur = cur.next;
		}
		return result;

	}

}
