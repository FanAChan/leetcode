import java.util.Scanner;
import java.util.Stack;

/**
 * @author Achan
 * @date 2018/9/6 20:18
 **/
public class Huya {

	public static void order(String[] a) {
		if (a == null) {
			return;
		}
		int len = a.length;

		StringBuffer result = new StringBuffer();
		Stack<Integer> indexStack = new Stack<>();
		indexStack.push(0);
		result.append(a[0]);
		int index = 0;
		int nextIndex = 0;
		while (!indexStack.isEmpty()) {
			if (nextIndex < len) {
				if (!"#".equals(a[nextIndex])) {
					indexStack.push(nextIndex);
					result.append(a[nextIndex]);
				} else {
					nextIndex++;
					if (nextIndex < len) {
						indexStack.push(nextIndex);
						result.append(nextIndex);
					}
				}
				nextIndex = nextIndex << 1 + 1;
			} else {
				indexStack.pop();
			}

		}
	}


	public static String[] parseSampleInput() {
		Scanner in = new Scanner(System.in);
		if (in.hasNext()) {
			return in.nextLine().split(" ");
		}
		return null;
	}

	public static void main(String[] args) {
		String[] a = parseSampleInput();
		order(a);
	}


}
