package solution;

public class ReverseNum {

    public int reverse(int x) {

        if ((10 > x && x >= 0) || (x > -10 && x < 0))
            return x;

        int result = 0;
        while (x != 0){

            int i = x % 10;
            if (Integer.MAX_VALUE / 10 < result || (Integer.MAX_VALUE / 10 == result && Integer.MAX_VALUE % 10 < i))
                return 0;
            if (Integer.MIN_VALUE / 10 > result || (Integer.MIN_VALUE / 10 == result && Integer.MIN_VALUE % 10 > i))
                return 0;
            result *= 10;
            result += i;

            x /= 10;
        }
        return result;

    }

    public static void main(String[] args) {
        ReverseNum reverseNum = new ReverseNum();

        System.out.println(Integer.MAX_VALUE);
        System.out.println(reverseNum.reverse(-12374));
    }

}
