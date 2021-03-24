package solution;

import base.ListNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

public class ReversePrint {

    public int[] reversePrint(ListNode head) {

        if(null == head){
            return new int[0];
        }
        Stack<Integer> stack = new Stack<Integer>();
        while (head!= null){
            stack.push(head.val);
            head = head.next;
        }
        int[] result = new int[stack.size()];

        int size = stack.size();
        for(int i = 0; i< size; i++){
            result[i] = stack.pop();
        }
        return result;
    }

    @Test
    public void test() throws Exception {
        System.out.println(Arrays.toString(reversePrint(ListNode.listNode(new int[]{1,3,2}))));
    }
}
