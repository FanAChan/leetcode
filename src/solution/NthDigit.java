package solution;

import org.junit.Test;

/**
 * @author Achan
 * @date 2018/10/10 14:33
 **/
public class NthDigit {

	public int findNthDigit(int n) {

		int from = 1;
		long count = 9;
		int len = 1;
		while (n > count * len) {
			n -= count * len;
			len++;
			from *= 10;
			count *= 10;
		}
		int index = n / len + 1;
		int i = n % len;
		if(i == 0){
			index--;
			i = len;
		}
		int num = from + index - 1;
		return String.valueOf(num).charAt(i - 1)-'0';
	}

	@Test
	public void test() {
//		System.out.println(findNthDigit(2147483647));

		String name = "fanwuyin";
		char[] nameToChar = name.toCharArray();

		int[] result = new int[8];
		int i = 0;
		for (char c : nameToChar) {
			result[i++] = findComplement(c);
		}


		for (int i1 : result) {
			System.out.print((char)(i1-1+'A'));
		}

		//Y6QHJFVQ
	}

	public int findComplement(int num) {

		int result = 0;
		int n = 1;
		do {
			int temp = 1 - num & 1;
			result += n * temp;
			num >>= 1;
			n <<= 1;

		} while (num > 0);
		return result;
	}
}
