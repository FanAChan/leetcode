package solution.backTrace;

import org.junit.Test;

import java.util.*;

public class GetHappyString {



    public String getHappyString(int n, int k) {
        char[] c = {'a','b','c'};
        ArrayList<String> resultList = new ArrayList<>();
        backTrace(n, new Stack<>(),resultList,c);
        if(resultList.size() < k){
            return "";
        }
        return resultList.get(k - 1);
    }

    private void backTrace(int n, Stack<Character> stack, List<String> result,char[] charArray){
        if(stack.size() == n){
            result.add(parse(stack));
            return;
        }

        for (Character character : charArray) {
            if(!stack.isEmpty() && stack.peek().equals(character)){
                continue;
            }
            stack.push(character);
            backTrace(n, stack,result,charArray);
            stack.pop();
        }
    }

    private String parse(Stack<Character> stack){
        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : stack) {
            stringBuilder.append(character);
        }
        return stringBuilder.toString();
    }

    @Test
    public void test() throws Exception {
        GetHappyString getHappyString = new GetHappyString();
        System.out.println(getHappyString.getHappyString(1, 3));
    }

}
