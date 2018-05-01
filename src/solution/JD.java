package solution;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Achan
 * @date 2018/4/9 19:30
 **/
public class JD {

    public void two(){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        char[] c = s.toCharArray();







    }


    public void three(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] ss = new String[n];
        for (int i = 0;i < n;i++){
            ss[i] = sc.nextLine();
        }

        for (String s:ss) {
            if((s.length() & 1) != 0 ){
                System.out.println("No");
                continue;
            }
            char[] c = s.toCharArray();
            threee(c);
        }

    }

    public static void threee(char[] cs){
        int length = cs.length;

        Stack<Character> stack = new Stack<>();


        int i = 0;
        for (;i < length ;i++) {
            if(cs[i] == '('){
                stack.push(cs[i]);
            }else if(!stack.empty()){
                stack.pop();
            }else {
                cs[i] = '(';
                break;
            }
        }

        stack.clear();

        int j = length - 1;
        for(;j>i;j--){
            if(cs[j] == ')'){
                stack.push(cs[j]);
            }else if(!stack.empty()){
                stack.pop();
            }else {
                cs[j] = ')';
                break;
            }
        }

        stack.clear();

        for (i= 0;i < length ;i++) {
            if(cs[i] == '('){
                stack.push(cs[i]);
            }else if(!stack.empty()){
                stack.pop();
            }else {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }






    public void one(){
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

    public void solution(long n ){
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

    public static void main(String[] args) {

//        System.out.println(isdouble(10));
        JD jd = new JD();
//        jd.one();
        jd.three();

    }



}
