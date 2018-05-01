package solution;

import java.util.Scanner;

/**
 * @author Achan
 * @date 2018/4/5 16:19
 **/
public class TC {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int K = 5;
        int X = 2;
        int XN = 3;
        int Y = 3;
        int YN = 3;
        if (X > Y) {
            counts(K, X, XN, XN, Y, YN, YN);
        } else {
            counts(K, Y, YN, YN, X, XN, XN);
        }
    }

    //X > Y
    public static int counts(int K, int X, int XN, int XTotal, int Y, int YN, int YTotal) {
        if (K < Y) {
            return 0;
        }
        if (K == Y && YN >= 1) {
            return YN / (YTotal + 1 - YN);
        }
        if (K == X && XN >= 1) {
            return XN / (XTotal + 1 - XN) + counts(K - Y, X, XN - 1, XTotal, Y, YN, YTotal);
        }
        return YN / (YTotal + 1 - YN) * counts(K - Y, X, XN, XTotal, Y, YN - 1, YTotal);
    }

}
