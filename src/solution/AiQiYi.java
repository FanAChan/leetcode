package solution;

import java.util.Scanner;

/**
 * @author Achan
 * @date 2018/4/19 18:59
 **/
public class AiQiYi {




    public static void main(String[] args){
        solution1();
    }

    public static void solution1(){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char[] cs = s.toCharArray();

        int length = cs.length;
        int start = 0;

        StringBuffer sb = new StringBuffer();
        while (start <= length - 1){
            start = getMaxCharIndexFromStart(cs,start);//获取之后字符串中最大的字符下标
            sb.append(cs[start]);
            start++;//在最大字符下标之后继续查找字符
        }
        System.out.println(sb);

    }

    public static int getMaxCharIndexFromStart(char[] cs,int start){
        int maxIndex = start;
        if(start == cs.length - 1){
            return start;
        }
        for(int i = start + 1 ;i < cs.length;i++){
            if(cs[i] > cs[maxIndex]){
                maxIndex = i;
            }
        }
        return  maxIndex;
    }




    public static void solution2(){
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int B = in.nextInt();
        int C = in.nextInt();
        int max = getMax(A,B,C);
        int cha = 3*max - A- B-C;
        if( (cha & 1) == 0){
            System.out.println(cha>>1);
        }else{
            System.out.println(((cha-3)>>1) + 3);
        }

    }

    public static int getMax(int A,int B,int C){
        return A>B&&A>C?A:(B>C&&B>A?B:C);
    }

    public static int getMin(int A,int B,int C){
        return A<B&&A<C?A:(B<C&&B<A?B:C);
    }








    public static void solution3(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] lr = new int[n][2];
        int max = 0;
        int min = 0;
        for(int i = 0;i<n;i++){
            lr[i][0] = in.nextInt();
            lr[i][1] = in.nextInt();
            max += lr[i][1];
            min += lr[i][0];
        }

        int result = 1;
        if(max < m || min > m){
            System.out.println(0);
            return;
        }

        for(int i = 0;i < n;i++) {
            int allowedMax = m - min > lr[i][1] ? lr[i][1]: m - min;//允许的最大值
            int allowedMin = m - max < lr[i][0] ? lr[i][0]: m - max;//允许的最小值
            result *= (allowedMax - allowedMin + 1);
            m -= allowedMax;
            max -= lr[i][1];
            min -= lr[i][0];
            if(m <= min || max <= m)
                break;
        }

        System.out.println(result);





    }
}
