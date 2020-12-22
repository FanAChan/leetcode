package solution.binarySearch;

import org.junit.Test;

public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {

        if(null == s){
            return true;
        }
        if(s.length() == 0){
            return true;
        }
        if(null == t || t.length() == 0){
            return false;
        }
        char[] scharArray = s.toCharArray();
        char[] tcharArray = t.toCharArray();

        int i = 0;
        int j = 0;

        while (i< scharArray.length && j < tcharArray.length){
            if(scharArray[i] == tcharArray[j]){
                i++;
                j++;
            }else{
                j++;
            }
        }
        return i == scharArray.length;

    }

    @Test
    public void test(){
        IsSubsequence isSubsequence = new IsSubsequence();
        boolean subsequence = isSubsequence.isSubsequence("abc", "addbec");
        System.out.println(subsequence);

    }
}
