package solution;

import java.util.ArrayList;

public class MyAtoi {

    public int myAtoi(String s) {

        char[] chars = s.toCharArray();
        boolean start = false;
        char temp = '+';
        int result = 0;
        int minValue = Integer.MIN_VALUE / -10;
        for (char aChar : chars) {
            if(!(aChar == ' ' || aChar == '+' || aChar == '-' || (aChar >= '0' && aChar <= '9'))){
                break;
            }

            if(!start){
                if(aChar == ' '){
                    continue;
                }else if(aChar == '+' || aChar == '-'){
                    start = true;
                    temp = aChar;
                    continue;
                }
            }

            if(aChar >= '0' && aChar <= '9'){
                start = true;
                if(temp == '+' && (result > Integer.MAX_VALUE/10 || result == Integer.MAX_VALUE /10 && aChar - '0' > Integer.MAX_VALUE % 10)){
                    return Integer.MAX_VALUE;
                }
                if(temp == '-' && (result > minValue || result == minValue && '0' - aChar < Integer.MIN_VALUE % 10)){
                    return Integer.MIN_VALUE;
                }
                result *= 10 ;
                result += aChar - '0';
            }else{
                break;
            }
        }
        return result * (temp == '+'? 1 : -1);

    }

    public static void main(String[] args) {
        MyAtoi myAtoi = new MyAtoi();
        System.out.println(myAtoi.myAtoi("-91283472332"));
    }
}
