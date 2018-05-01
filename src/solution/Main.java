package solution;

/**
 * @author Achan
 * @date 2018/4/9 19:56
 **/
import java.util.Scanner;

public class Main{

    public static void main(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arrays = new long[n];


        for (int i = 0;i<n;i++){
            arrays[i] = sc.nextLong();
        }

        for (long N:arrays) {
            solution(N);
        }

    }

    public static void solution(long n ){
        if(!isdouble(n)){
            System.out.println("No");
            return;
        }
        long Y = 2;
        long X = n >> 1;
        while(X > 0) {
            if(isdouble(X)){
                Y = Y << 1;
                X = X >> 1;
            }else{
                System.out.println(X + " " + Y);
                break;
            }
        }
    }

    public static boolean isdouble(long n){
        return (n & 1) == 0;
    }


}
