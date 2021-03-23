package solution.linked;

import base.ListNode;
import org.junit.Test;

import java.util.List;

public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {

        ListNode newHead = new ListNode(0);
        newHead.next = head;


        ListNode pre = newHead;
        ListNode cur = pre.next;

        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                cur = pre.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return newHead.next;

    }

    @Test
    public void test() throws Exception {
        ListNode listNode = ListNode.listNode(new int[]{1, 2, 6, 3, 4, 5, 6});
        System.out.println(removeElements(listNode,6));
    }

}
