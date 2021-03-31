package solution;

import base.ListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class NextLargerNodes {


    public int[] nextLargerNodes(ListNode head) {

        Stack<Integer> stack = new Stack<>();

        while (head != null){
            stack.push(head.val);
            head = head.next;
        }
        int[] result = new int[stack.size()];
        Stack<Integer> temp = new Stack<>();
        int i = stack.size() - 1;
        while (!stack.isEmpty()){

            Integer pop = stack.pop();
            int biggerNum = 0;
            while (!temp.isEmpty()){
                if (temp.peek() > pop) {
                    biggerNum = temp.peek();
                    break;
                }else{
                    temp.pop();
                }
            }
            temp.push(pop);
            result[i] = biggerNum;
            i--;
        }
        return result;
    }

    @Test
    public void test() throws Exception {
        Assert.assertArrayEquals(nextLargerNodes(ListNode.listNode(new int[]{2,1,5})),new int[]{5,5,0});
        Assert.assertArrayEquals(nextLargerNodes(ListNode.listNode(new int[]{2,7,4,3,5})),new int[]{7,0,5,5,0});
        Assert.assertArrayEquals(nextLargerNodes(ListNode.listNode(new int[]{1,7,5,1,9,2,5,1})),new int[]{7,9,9,9,0,5,0,0});
    }
}
