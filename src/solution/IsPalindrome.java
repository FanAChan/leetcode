package solution;

public class IsPalindrome {

    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        if(x == 0){
            return true;
        }
        int revertNum = 0;
        int temp = x;

        //为防止溢出只翻转一半的数字
        while (temp > revertNum) {

            revertNum *= 10;
            revertNum += temp%10;
            temp /= 10;

        }
        //revertNum / 10 过滤x为奇数个数字时的中位数的影响
        return revertNum == x || x == revertNum / 10;


    }
}
