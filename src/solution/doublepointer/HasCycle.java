package solution.doublepointer;

import base.ListNode;

public class HasCycle {

    public boolean hasCycle(ListNode head) {

        if(head == null){
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;

        }
        return true;
    }
}
