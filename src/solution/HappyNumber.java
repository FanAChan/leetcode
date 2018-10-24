package solution;

import org.junit.Test;

import java.util.HashSet;

/**
 * @author Achan
 * @date 2018/10/11 1:07
 **/
public class HappyNumber {

	public boolean isHappy(int n) {

		if (n <= 0) {
			return false;
		}
		HashSet<Integer> set = new HashSet<>();
		int sum = n;
		set.add(n);
		while (sum != 1) {
			int temp = 0;
			while (sum > 0) {
				int num = sum % 10;
				temp += num * num;
				sum /= 10;
			}
			sum = temp;
			if (!set.add(sum)) {
				return false;
			}
		}
		return true;
	}

	@Test
	public void test() {
		isHappy(19);
	}
}
