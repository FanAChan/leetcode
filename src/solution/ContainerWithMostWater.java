package solution;

import org.junit.Test;

/**
 * @author Achan
 * @date 2018/10/24 14:32
 **/
public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		int start = 0;
		int end = height.length - 1;
		int maxArea = 0;
		while (start < end) {
			int shorter = height[start] > height[end] ? height[end] : height[start];

			int area = shorter * (end - start);
			if (maxArea < area) {
				maxArea = area;
			}
			if (shorter == height[start]) {
				start++;
			} else {
				end--;
			}
		}
		return maxArea;
	}

	@Test
	public void test() {
		maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
	}
}
