package solution.backTrace;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Permutation {


    public String[] permutation(String s) {

        if(null == s || s.length() == 0){
            return new String[0];
        }

        char[] array = s.toCharArray();
        boolean[] visit = new boolean[array.length];
        ArrayList<String> list = new ArrayList<>();
        backTrace(list,array,visit,0,new StringBuilder());
        String[] resultArray = new String[list.size()];
        list.toArray(resultArray);
        return resultArray;
    }


    private void backTrace(List<String> resultList,char[] arr, boolean[] visit, int len, StringBuilder s){
        if(len == arr.length){
            resultList.add(s.toString());
            return;
        }
        //当前位置字符相同时进行剪枝，避免相同排列
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if(visit[i]){
                continue;
            }
            if(!set.add(arr[i])){
                continue;
            }
            s.append(arr[i]);
            visit[i] = true;
            backTrace(resultList,arr,visit,len + 1,s);
            s = s.delete(s.length() - 1,s.length());
            visit[i] = false;
        }
    }


    @Test
    public void test() throws Exception {

        permutation("aab");
    }

}
