package codewar;

import java.util.Stack;

public class Finder {

    static boolean pathFinder(String maze) {
        // Your code here!!、

        String[] split = maze.split("\n");
        char[][] chars = new char[split.length][];
        int i = 0;
        for (String s : split) {
            chars[i] = s.toCharArray();
            i++;
        }
        Stack stack = new Stack<Character>();
        for (i = 0; i < chars.length;) {
            for (int j = 0; j < chars[i].length;) {
                char c = chars[i][j];
                if('W' == c){
                    break;
                }else{
                    stack.push(c);
                    j++;
                }
                if(stack.isEmpty()){
                    stack.push(c);
                }
            }
        }


        return false;
    }

    public static void main(String[] args) {

    }
}
