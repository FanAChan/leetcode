package solution.backTrace;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class SplitIntoFibonacci {

    private static String maxIntStr = String.valueOf(Integer.MAX_VALUE);

    public List<Integer> splitIntoFibonacci(String S) {

        LinkedList<Integer> list = new LinkedList<>();
        if(null == S || S.length() < 3){
            return list;
        }
        int len = S.length();
        for (int i = 0; i < len /2; i++) {
            String first = S.substring(0, i + 1);
            if (first.length() != 1 && first.charAt(0) == '0') {
                continue;
            }
            if(!isValidInt(first)){
                break;
            }
            Integer firstInt = Integer.valueOf(first);
            list.add(firstInt);
            for (int j = i + 1; j < len; j++) {
                String second = S.substring(i + 1, j + 1);
                if (second.length() != 1 && second.charAt(0) == '0') {
                    continue;
                }
                if(!isValidInt(second) || Integer.MAX_VALUE - firstInt < Integer.valueOf(second)){
                    break;
                }
                list.add(Integer.valueOf(second));
                if (isFibonacci(S, j + 1, firstInt, Integer.valueOf(second),list)) {
                    return list;
                }
                list.removeLast();
            }
            list.removeLast();
        }
        return list;
    }

    boolean isFibonacci(String s, int start, int i, int j,Deque<Integer> resultDeque) {

        String temp = String.valueOf(i + j);

        boolean result = false;
        int k = start, index = 0;
        for (; k < s.length() && index < temp.length(); k++) {
            if (s.charAt(k) != temp.charAt(index)) {
                break;
            }
            index++;
        }
        resultDeque.add(i + j);
        if (k < s.length() && index == temp.length() && Integer.MAX_VALUE - i > j) {
            result =  isFibonacci(s, k, j, i + j,resultDeque);
        }
        if (k == s.length() && index == temp.length()) {
            result = true;
        }
        if(!result) {
            resultDeque.removeLast();
        }
        return result;

    }

    boolean isValidInt(String num){
        if(num.length() <maxIntStr.length() ){
            return true;
        }
        if(num.length() == maxIntStr.length() && num.compareTo(maxIntStr) <= 0){
            return true;
        }
        return false;
    }

    @Test
    public void test() throws Exception {
//        splitIntoFibonacci("11235813");
//        splitIntoFibonacci("17522");
        splitIntoFibonacci("214748364721474836422147483641");
//        splitIntoFibonacci("123456579");
//        splitIntoFibonacci("68142236");
//        splitIntoFibonacci("112358130");
    }
}
