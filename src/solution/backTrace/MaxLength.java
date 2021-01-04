package solution.backTrace;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class MaxLength {

    public int maxLength(List<String> arr) {

        List<Integer> bitNumList = getBitNum(arr);

        return dfs(arr, bitNumList, 0, 0);
    }

    private int dfs(List<String> arr, List<Integer> bitNumList,int start,int num){

        if(start == arr.size()){
            return 0;
        }
        int len = 0;
        for (int i = start; i < bitNumList.size(); i++) {
            Integer temp = bitNumList.get(i);
            if(temp == 0 || (temp & num ) != 0){
                continue;
            }
            len = Math.max(len,dfs(arr,bitNumList,i + 1,temp + num) + arr.get(i).length());
        }
        return len;
    }

    private List<Integer> getBitNum(List<String> list){

        ArrayList<Integer> result = new ArrayList<>(list.size());
        for (String s : list) {
            if(s.length() > 26){
                result.add(0);
                continue;
            }
            char[] charArray = s.toCharArray();
            int i = 0;
            for (char c : charArray) {
                int index = c - 'a';
                int charNum = 1 << index;
                if((i & charNum) != 0){
                    i = 0;
                    break;
                }
                i += charNum;
            }
            result.add(i);
        }
        return result;
    }




    @Test
    public void test() throws Exception {
//        Assert.assertEquals(4,maxLength(Arrays.asList("un","iq","ue")));
//        Assert.assertEquals(6,maxLength(Arrays.asList("cha","r","act","ers")));
//        Assert.assertEquals(26, maxLength(Arrays.asList("abcdefghijklmnopqrstuvwxyz")));
        Assert.assertEquals(16, maxLength(Arrays.asList("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p")));
    }

}
