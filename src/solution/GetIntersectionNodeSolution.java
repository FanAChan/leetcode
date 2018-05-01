package solution;

import base.ListNode;

import java.util.Stack;
/**
 * 
 * @author Achan
 *
 * @date 2018年4月1日
 * 
 *  Write a program to find the node at which the intersection of two singly linked lists begins.
 *	For example, the following two linked lists:
 *	
 *	A:          a1 → a2
 *	                   ↘
 *	                     c1 → c2 → c3
 *	                   ↗            
 *	B:     b1 → b2 → b3
 *	
 *	begin to intersect at node c1.
 *	
 *	Notes:
 *
 *  If the two linked lists have no intersection at all, return null.
 *  The linked lists must retain their original structure after the function returns.
 *  You may assume there are no cycles anywhere in the entire linked structure.
 *  Your code should preferably run in O(n) time and use only O(1) memory.
 *
 */
public class GetIntersectionNodeSolution {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int aLength = 0;
		int bLength = 0;
		ListNode tempA = headA;
		ListNode tempB = headB;
		while (tempA != null) {
			tempA = tempA.next;
			aLength++;
		}
		while (tempB != null) {
			tempB = tempB.next;
			bLength++;
		}
		if (aLength < bLength) {
			ListNode temp = headA;
			headA = headB;
			headB = temp;
			aLength = aLength + bLength;
			bLength = aLength - bLength;
			aLength = aLength - bLength;
		}
		for (int i = 0; i < aLength - bLength; i++) {
			headA = headA.next;
		}
		while(headA != null && headB != null && headA != headB){
			headA = headA.next;
			headB = headB.next;
		}
		if((headA == null && headB != null)
				||(headA != null && headB == null)){
			return null;
		}
		return headA;
	}
	
	
	public ListNode getIntersectionNodeByStack(ListNode headA, ListNode headB) {
		Stack<ListNode> stackA = new Stack<>();
		Stack<ListNode> stackB = new Stack<>();
		while (headA != null) {
			stackA.push(headA);
		}
		while (headB != null) {
			stackB.push(headB);
		}
		if(stackA.isEmpty()||stackB.isEmpty()){
			return null;
		}
		ListNode temp = stackA.peek();
		while(!stackA.isEmpty()&&!stackB.isEmpty()){
			if((temp = stackA.pop()) != stackB.pop())
				break;
		}
		return temp;
	}
}

