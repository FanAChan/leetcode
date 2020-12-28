package solution.backTrace;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Partition {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();

        if(null == s || s.length() == 0){
            return result;
        }
        backTrace(result,new Stack<>(),0,s.length(),s);
        return result;
    }


    private void backTrace(List<List<String>> result, Stack<String> subResult, int start, int end, String s) {
        if (start == end) {
            result.add(new ArrayList<>(subResult));
            return;
        }
        for (int i = start; i < end; i++) {
            if (!isPalindrome(s, start, i)) {
                continue;
            }

            String substring = s.substring(start, i + 1);
            subResult.add(substring);
            backTrace(result, subResult, i + 1, end, s);
            subResult.pop();
        }
    }

    private boolean isPalindrome(String s,int start,int end){
        while (start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    @Test
    public void test() throws Exception {
        Partition partition = new Partition();
        List<List<String>> aab = partition.partition("a");
        for (List<String> strings : aab) {
            System.out.println(strings);
        }
    }
}
