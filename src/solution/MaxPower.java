package solution;

import org.junit.Test;

public class MaxPower {

    public int maxPower(String s) {

        char[] charArray = s.toCharArray();
        int result = 0;

        char pre = charArray[0];

        int count = 1;
        for (int i = 1; i < charArray.length; i++) {
            char c = charArray[i];
            if(c == pre){
                count++;
            }else{
                result = Math.max(result,count);
                count = 1;
                pre = c;
            }
        }
        result = Math.max(result,count);
        return result;
    }

    @Test
    public void test() throws Exception {
        System.out.println(maxPower("leetcode"));
    }

}
