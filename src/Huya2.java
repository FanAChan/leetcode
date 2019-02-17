import java.util.Scanner;

/**
 * @author Achan
 * @date 2018/9/6 21:00
 **/
public class Huya2 {

	public static void main(String[] args) {
		int[] a = parseSampleInput();
		encode(a);
	}

	public static void encode(int[] a) {
		StringBuffer result = new StringBuffer();
		int[] code = {5, 3, 1, 2, 4};
		for (int i = 0; i < a.length; i++) {
			result.append(code[a[i] - 1]);
		}
		System.out.println(result);
	}

	public static int[] parseSampleInput() {
		Scanner in = new Scanner(System.in);
		if (in.hasNext()) {
			String[] t1 = in.nextLine().split(" ");
			int[] t2 = new int[t1.length];
			for (int i = 0; i < t1.length; i++) {
				t2[i] = Integer.parseInt(t1[i]);
			}
			return t2;
		}
		return null;
	}
}
