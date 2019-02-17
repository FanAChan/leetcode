package solution;

import java.util.HashMap;

/**
 * @author Achan
 * @date 2018/5/7 19:24
 **/
public class Jobs {

	public static void one(String input) {
//		Scanner in = new Scanner(System.in);
//		String input = in.nextLine();

		String[] ss = input.split(";");

		System.out.println(ss[0]);
		System.out.println(ss[1]);
		int i = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		while (i < ss[0].length()) {
			int num = map.getOrDefault(ss[0].charAt(i), 0);
			num++;
			map.put(ss[0].charAt(i), num);
			i++;
		}
		i = 0;
		while (i < ss[1].length()) {
			int num = map.getOrDefault(ss[1].charAt(i), 0);
			if (num == 0) {
				System.out.println(false);
				return;
			}
			num--;
			map.put(ss[0].charAt(i), num);
			i++;
		}
		System.out.println(true);


	}

	public static void two(String input) {
//		Scanner in = new Scanner(System.in);
//		String input = in.nextLine();


		char[] inputChar = input.toCharArray();
		int countR = 0;
		int countG = 0;
		int countB = 0;
		for (int i = 0; i < inputChar.length; i++) {
			char c = inputChar[i];
			if (c == 'R') {
				countR++;
			} else if (c == 'G') {
				countG++;
			} else if (c == 'B') {
				countB++;
			}
		}
		int i = 0;
		int index =0;
		for (; i < countR; i++) {
			inputChar[index] = 'R';
			index++;
		}
		i = 0;
		for (; i < countG; i++) {
			inputChar[index++] = 'G';
		}
		i = 0;
		for (; i < countB; i++) {
			inputChar[index++] = 'B';
		}

		System.out.println(inputChar);
	}

	public static void main(String[] args) {
		Jobs.two("RGRB");
	}
}
