package solution.divideconquer;

import base.ListNode;
import org.junit.Test;

public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        if(l1 != null && l2 != null){
            if(l1.val < l2.val){
                l1.next = mergeTwoLists(l1.next,l2);
                head.next = l1;
            }else{
                l2.next = mergeTwoLists(l1,l2.next);
                head.next = l2;
            }
        }else if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }
        return head.next;
    }

    @Test
    public void test() throws Exception {
        ListNode l1 = ListNode.listNode(new int[]{1, 2, 4});
        ListNode l2 = ListNode.listNode(new int[]{1, 3,4});
        ListNode listNode = mergeTwoLists(l1, l2);
        System.out.println(listNode);
    }
}
