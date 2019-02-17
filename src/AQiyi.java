import java.util.Scanner;

/**
 * @author Achan
 * @date 2018/9/15 10:35
 **/
public class AQiyi {

//	public static void main(String[] args) {
//
//		Scanner scanner = new Scanner(System.in);
//		String id = scanner.nextLine();
//		char[] nums = id.toCharArray();
//		char[] before = Arrays.copyOfRange(nums, 0, 3);
//		char[] after = Arrays.copyOfRange(nums, 3, 6);
//		Arrays.sort(before);
//		Arrays.sort(after);
//		int cha = (nums[3] + nums[4] + nums[5]) - (nums[0] + nums[1] + nums[2]);
//		if (cha < 0) {
//			char[] temp = before;
//			before = after;
//			after = temp;
//			cha *= -1;
//		}
//
//		int result = 0;
//		int beforeIndex = 0;
//		int afterIndex = 2;
//		while (cha > 0) {
//			int temp = cha > 9 ? 9 : cha;
//			result++;
//			if (temp - (before[beforeIndex] - '0') > after[afterIndex] - '0') {
//				cha -= temp - (before[beforeIndex] - '0');
//				beforeIndex++;
//			} else {
//				cha -= after[afterIndex] - '0';
//				afterIndex--;
//			}
//		}
//		System.out.println(result);
//	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int p = scanner.nextInt();
		int[] ai = new int[n];
		for (int i = 0; i < n; i++) {
			ai[i] = scanner.nextInt();
		}
		scanner.nextLine();
		for (int i = 0; i < m; i++) {
			String[] input = scanner.nextLine().split(" ");
			String operator = input[0];
			int num = Integer.valueOf(input[1]);
			switch (operator) {
				case "A":
					ai[num] += 1;
					break;
				case "B":
					ai[num] -= 1;
					break;
				default:
					break;
			}
		}
		int result = 1;
		for (int i : ai) {
			if (i > ai[p - 1]) {
				result++;
			}
		}
		System.out.println(result);
	}
}
