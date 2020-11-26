package solution;

import base.ListNode;

public class ReverseKGroup {

    /**
     * 每K个节点翻转一次
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode temp = new ListNode(0);

        int i = 0;
        ListNode from = head;
        while (i < k && head != null){
            head = head.next;
        }
        ListNode next = from.next.next;

        from.next.next = from;
        from.next = next;

        return null;
    }


}
