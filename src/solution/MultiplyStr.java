package solution;

import org.junit.Test;

import java.util.Arrays;

public class MultiplyStr {

    public String multiply(String num1, String num2) {


        if(null == num1 || null == num2){
            return "0";
        }
        if("".equals(num1) || "".equals(num2)){
            return "0";
        }
        if("0".equals(num1) || "0".equals(num2)){
            return "0";
        }

        char[] chars1 = num1.toCharArray();
        int char1Len = chars1.length;
        char[] chars2 = num2.toCharArray();
        int char2Len = chars2.length;
        int[] resultArray = new int[char1Len + char2Len];

        for (int i = 0; i < char1Len; i++) {
            for (int j = 0; j < char2Len; j++) {
                int multiply = multiply(chars1[i], chars2[j]);
                resultArray[i + j + 1] += (multiply % 10);
                resultArray[i + j] += (multiply / 10);
            }
        }

        for (int i = resultArray.length - 1; i > 0; i--) {
            if(resultArray[i] >= 10){
                resultArray[i - 1 ] += resultArray[i]/10;
                resultArray[i] = resultArray[i]%10;
            }
        }

        int index = 0;
        while (index < resultArray.length && resultArray[index] == 0) {
            index++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (index < resultArray.length ) {
            stringBuilder.append(resultArray[index]);
            index++;
        }
        return stringBuilder.toString();
    }

    private int multiply(char c1, char c2) {
        return (c1 - '0') * (c2 - '0');
    }

    @Test
    public void test() {
        MultiplyStr multiplyStr = new MultiplyStr();
        System.out.println(multiplyStr.multiply("99", "99"));
    }

}
