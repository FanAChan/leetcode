package solution;

import org.junit.Test;

/**
 * @author Achan
 * @date 2018/10/4 15:43
 **/
public class CanPlaceFlowers {

	public boolean canPlaceFlowers(int[] flowerbed, int n) {

		int count = 0;
		for (int i = 0; i < flowerbed.length && count < n; i++) {
			if (flowerbed[i] == 0) {
				int next = i == flowerbed.length - 1 ? 0 : flowerbed[i + 1];
				int prev = i == 0 ? 0 : flowerbed[i - 1];
				if ((next | prev) == 0) {
					count++;
					flowerbed[i] = 1;
				}
			}
		}
		return count >= n;
	}

	@Test
	public void test(){
		canPlaceFlowers(new int[]{1,0,0,0,1},2);
	}
}
