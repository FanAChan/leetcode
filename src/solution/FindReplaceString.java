package solution;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class FindReplaceString {

    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {

        int[] match = new int[S.length()];
        Arrays.fill(match,-1);

        for(int i = 0;i<indexes.length;i++){
            boolean equals = S.substring(indexes[i], indexes[i] + sources[i].length()).equals(sources[i]);
            if(equals){
                match[indexes[i]] = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<S.length();){
            if(match[i] >= 0){
                sb.append(targets[match[i]]);
                i+= sources[match[i]].length();
            }else{
                sb.append(S.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }

    @Test
    public void test() throws Exception {
        //S = "abcd", indexes = [0,2], sources = ["a","cd"], targets = ["eee","ffff"]
        Assert.assertEquals(findReplaceString("abcd",new int[]{0,2},new String[]{"a","cd"},new String[]{"eee","ffff"}),"eeebffff");
    }
}
