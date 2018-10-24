package solution;

import org.junit.Test;

/**
 * @author Achan
 * @date 2018/10/5 0:17
 **/
public class TeemoAttacking {


	public int findPoisonedDuration(int[] timeSeries, int duration) {

		if (timeSeries == null || timeSeries.length == 0) {
			return 0;
		}
		int len = timeSeries.length;
		int from = timeSeries[0];
		int to = from + duration;
		int result = 0;
		for (int i = 1; i < len; i++) {
			if (timeSeries[i] < to) {
				to = timeSeries[i] + duration;
			} else {
				result += to - from;
				from = timeSeries[i];
				to = from + duration;
			}
		}
		result += to - from;
		return result;
	}

	@Test
	public void test() {
		findPoisonedDuration(new int[]{1, 4}, 2);
		findPoisonedDuration(new int[]{1, 2}, 2);
	}
}
