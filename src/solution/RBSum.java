package solution;

import java.util.Scanner;

/**
 * @author Achan
 * @date 2018/9/12 19:21
 **/
public class RBSum {


	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int red = scanner.nextInt();
		int black = scanner.nextInt();

		if (red < 0 || black > 0) {
			return;
		}

		if (red + black < 0) {
			int i = black * -1 / red;
			if (i > 6) {
				i = 6;
			}
			int j = black * -1 - i * red;
			int result = 17 / (i + 1) * j * -1;
			result += 17 % (i + 1) * red;
			System.out.println(result);
		} else {
			int i = red / (-black);
			if (i > 6) {
				return;
			}
			int j = red + (i + 1) * black;
			int result = 17 / (i + 1) * j * -1;
			result += 17 % (i + 1) * red;
			System.out.println(result);
		}


	}

}


