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
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode result = new ListNode(0);
        ListNode head = result;

        for (ListNode list : lists) {
            if (list != null) {
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

    public ListNode mergeKLists2(ListNode[] lists) {
        ListNode listNode = new ListNode(0);
		ListNode temp = listNode;
        boolean isEmpty = true;
        int index = 0;
        ListNode minNode = null;
        while (true) {
        	isEmpty = true;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) {
                    isEmpty &= true;
                    continue;
                }
                isEmpty = false;
                if(minNode == null){
                	minNode = lists[i];
                	index = i;
				}else if (lists[i].val < minNode.val) {
                    minNode = lists[i];
                    index = i;
                }
            }
            if(isEmpty){
            	break;
			}
			temp.next = minNode;
            temp = temp.next;
            lists[index] = lists[index].next;
            minNode = null;
        }
        return listNode.next;


    }

    @Test
    public void test() {
        ListNode list1 = ListNode.listNode(new int[]{1, 4, 5});
        ListNode list2 = ListNode.listNode(new int[]{1, 3, 4});
        ListNode list3 = ListNode.listNode(new int[]{2, 6});
        ListNode[] lists = {list1, list2, list3};
        ListNode result = mergeKLists2(lists);

        System.out.println(result);

    }
}
