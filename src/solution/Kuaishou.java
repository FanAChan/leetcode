package solution;

import java.util.Scanner;

/**
 * @author Achan
 * @date 2018/5/10 18:52
 **/
public class Kuaishou {


	public static void solution1(String input) {
//		Scanner in = new Scanner(System.in);
//		String input = in.nextLine();
		if (input.charAt(0) == '0') {
			if (input.length() == 1)
				System.out.println("L");
			return;
		}
		int cur = 0;
		int count = 0;
		char[] temp = input.toCharArray();

		int i = 0;
		int len = temp.length;
		char[] bit = new char[]{'W', 'Q', 'B', 'S', 'L'};
		StringBuilder sb = new StringBuilder();
		boolean preIsZero = false;
		for (; i < len; i++) {
			if (!preIsZero && temp[i] != '0') {
				sb.append(temp[i]);
				if (i != len - 1) {
					sb.append(bit[5 - len + i]);
				}
			} else if (preIsZero && temp[i] != '0') {
				sb.append("L");
				sb.append(temp[i]);
				if (i != len - 1) {
					sb.append(bit[5 - len + i]);
					preIsZero = false;
				}
			} else if (temp[i] == '0') {
				preIsZero = true;
			}
		}
		System.out.println(sb);
	}


	public static void s(){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] inputs = new int[n];
		for(int i =0;i<n;i++){
			inputs[i] = in.nextInt();
		}
		for(int i =0;i<n;i++){
			solution2(inputs[i]);
		}
	}

	public static void solution2(int input) {
//		Scanner in = new Scanner(System.in);
//		int input = in.nextInt();
		boolean[] temp = new boolean[input + 1];
		temp[0] = temp[1] = temp[2] = true;
		for (int i = 3; i <= input; i++) {
			boolean isLuckyInI = false;
			for (int j = 1; j <= i; ) {
				isLuckyInI = !temp[i - j];
				if (isLuckyInI) {
					temp[i] = true;
					break;
				}
				j *= 2;
			}
		}
		if(temp[input]){
			System.out.println("lucky");
		}else{
			System.out.println("don't be discouraged");
		}
		System.out.println(temp[input]);
	}


	public static void main(String[] args) {
//		Kuaishou.solution1("1001");
//		Kuaishou.solution1("1111");
//		Kuaishou.solution1("2000");
//		Kuaishou.solution1("12001");
//		Kuaishou.solution1("0");
//		System.out.println(true ^ true);
//		System.out.println(false ^ false);
//		System.out.println(true ^ false);
		Kuaishou.solution2(3);
		Kuaishou.solution2(5);
		Kuaishou.solution2(8);
	}

}
