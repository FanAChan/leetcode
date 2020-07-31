package codewar;

import org.junit.Test;

import java.util.HashMap;
import java.util.Stack;

import static org.junit.Assert.assertArrayEquals;

public class DirReduction {

    public static String[] dirReduc(String[] arr) {
        // Your code here.
        if(null == arr || 0 == arr.length){
            return arr;
        }

        //North | East | West | South
        HashMap<String, String> hashMap = new HashMap<String, String>() {{
            put("NORTH", "SOUTH");
            put("SOUTH", "NORTH");
            put("EAST", "WEST");
            put("WEST", "EAST");
        }};

        Stack<String> stack = new Stack<>();
        for (String s : arr) {
            if(stack.empty()){
                stack.push(s);
                continue;
            }
            String peek = stack.peek();
            if (peek.equals(hashMap.get(s))) {
                stack.pop();
            }else{
                stack.push(s);
            }
        }
        String[] result = new String[stack.size()];
        stack.toArray(result);
        return result;
    }

    @Test
    public void testSimpleDirReduc() {
        assertArrayEquals("\"NORTH\", \"SOUTH\", \"SOUTH\", \"EAST\", \"WEST\", \"NORTH\", \"WEST\"",
                new String[]{"WEST"},
                DirReduction.dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"}));
        assertArrayEquals("\"NORTH\",\"SOUTH\",\"SOUTH\",\"EAST\",\"WEST\",\"NORTH\"",
                new String[]{},
                DirReduction.dirReduc(new String[]{"NORTH","SOUTH","SOUTH","EAST","WEST","NORTH"}));
        assertArrayEquals("\"EAST\",\"NORTH\"",
                new String[]{"EAST", "NORTH"},
                DirReduction.dirReduc(new String[]{"EAST", "EAST", "WEST", "NORTH", "WEST", "EAST", "EAST", "SOUTH", "NORTH", "WEST"}));
    }

}
