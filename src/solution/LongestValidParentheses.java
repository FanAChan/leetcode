package solution;

import sun.security.krb5.KrbApRep;

import java.util.Stack;

public class LongestValidParentheses {


    private static char right = ')';

    private static char left = '(';


    public int longestValidParentheses(String s) {


        if(null == s || s.length() == 0){
            return 0;
        }
        if(s.length() == 1){
            return 0;
        }

        char[] chars = s.toCharArray();
        int length = chars.length;

        Stack<Character> stack = new Stack<>();

        for(int i = 0;i<length;i++){

//            for(int j = 0;i+j<length;j++){
//                if(stack.isEmpty() && chars[j] == left){
//                    stack.push(chars[j]);
//                }else if ()
//
//
//
//
//            }


        }

        return 0;
    }

    public static void main(String[] args) {
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        System.out.println(longestValidParentheses.longestValidParentheses("("));
    }

}
