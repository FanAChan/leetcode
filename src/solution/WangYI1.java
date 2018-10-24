package solution;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Achan
 * @date 2018/8/11 15:23
 **/
public class WangYI1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] scores = new int[n];
		int[] status = new int[n];
		ArrayList<Integer> sleepingIndex = new ArrayList<>();
		/**
		 * 总分
		 */
		int result = 0;
		/**
		 * 每分钟分数
		 */
		for (int i = 0; i < n; i++) {
			scores[i] = sc.nextInt();
		}
		/**
		 * 每分钟是否清醒
		 */
		for (int i = 0; i < n; i++) {
			status[i] = sc.nextInt();
			if (status[i] == 1) {
				result += scores[i];
			} else {
				sleepingIndex.add(i);
			}
		}
		int max = 0;

		for (int i = 0; i < sleepingIndex.size(); i++) {
			int temp = 0;
			int index = sleepingIndex.get(i);
			int start = index;
			int j = i;
			while (index - start < k) {
				temp += scores[index];
				j++;
				if (j < sleepingIndex.size()) {
					index = sleepingIndex.get(j);
				} else {
					break;
				}
			}
			max = Math.max(max, temp);
		}
		System.out.println(max + result);


	}
}
