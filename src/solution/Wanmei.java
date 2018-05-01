package solution;

import java.util.Scanner;

/**
 * @author Achan
 * @date 2018/4/27 17:14
 *
 *
 * 背包问题
 **/
public class Wanmei {


    public static void main(String[] args) {
        solution1();
        solution2();
    }

    /**
     * 非递归，自下而上
     */
    public static void solution1() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        int[][] arrays = new int[n][2];
        int i = 0;
        for (; i < n; i++) {
            arrays[i][0] = in.nextInt();
        }
        in.nextLine();
        for (i = 0; i < n; i++) {
            arrays[i][1] = in.nextInt();
        }
        in.nextLine();

        int time = in.nextInt();

        int[][] temp = new int[n + 1][time + 1];
        for (i = 0; i < n; i++) {
            temp[i][0] = 0;
        }
        for (i = 0; i <= time; i++) {
            temp[0][i] = 0;
        }
        for (i = 1; i <= n; i++) {
            temp[i][0] = 0;

            for (int j = 1; j <= time; j++) {
                if (j < arrays[i-1][1]) {
                    temp[i][j] = temp[i - 1][j];
                } else {
                    temp[i][j] = Math.max(temp[i - 1][j], temp[i - 1][j - arrays[i-1][1]] + arrays[i-1][0]);
                }
            }
        }

        System.out.println(temp[n][time]);
    }

    /**
     * 递归实现，自上而下
     */
    public static void solution2() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        int[] weights = new int[n];
        int[] values = new int[n];
        int i = 0;
        for (; i < n; i++) {
            weights[i] = in.nextInt();
        }
        in.nextLine();
        for (i = 0; i < n; i++) {
            values[i] = in.nextInt();
        }
        in.nextLine();

        int time = in.nextInt();

        int[][] temp = new int[n + 1][time + 1];

        for (i = 1; i <= n; i++) {
            temp[i][0] = 0;
        }
        for (i = 1; i < time; i++) {
            temp[0][i] = 0;
        }

        for (i = 1; i <= n; i++) {
            for (int j = 1; j <= time; j++) {
                temp[i][j] = -1;
            }
        }

        System.out.println(getMaxValue(weights,values,temp,n,time));
    }

    static int getMaxValue(int[] weights,int[] values,int[][] temps,int i,int j){
        if(temps[i][j]<0){
            if(j < weights[i-1]){
                temps[i][j] = getMaxValue(weights,values,temps,i-1,j);
            }else{
                temps[i][j] = Math.max(getMaxValue(weights,values,temps,i-1,j),
                        getMaxValue(weights,values,temps,i-1,j-weights[i-1])+values[i-1]);
            }
        }
        return  temps[i][j];
    }
}
