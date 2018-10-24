package solution;

import base.ListNode;
import org.junit.Test;

import java.util.Stack;

/**
 * @author Achan
 * @date 2018/10/22 22:00
 **/
public class AddTwoNumbersII {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Stack<ListNode> s1 = new Stack<>();
		while (l1 != null){
			s1.push(l1);
			l1 = l1.next;
		}
		Stack<ListNode> s2 = new Stack<>();
		while (l2 != null){
			s2.push(l2);
			l2 = l2.next;
		}
		int add = 0;
		ListNode result = new ListNode(0);
		while (!s1.isEmpty() && !s2.isEmpty()){
			int temp = s1.pop().val + s2.pop().val + add;
			add = temp / 10;
			temp %= 10;
			ListNode node = new ListNode(temp);
			node.next = result.next;
			result.next = node;
		}
		if(s1.isEmpty()){
			s1 = s2;
		}
		while (!s1.isEmpty()){
			int temp = s1.pop().val + add;
			add = temp / 10;
			temp %= 10;
			ListNode node = new ListNode(temp);
			node.next = result.next;
			result.next = node;
		}
		if(add == 1){
			result.val = 1;
		}else{
			result = result.next;
		}
		return result;

	}

	@Test
	public void test() {

	}
}
