import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Achan
 * @date 2018/9/6 20:50
 **/
public class Huya3 {
	static class MyObject {
		int id;
		int score;

		public MyObject(int id, int score) {
			this.id = id;
			this.score = score;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getScore() {
			return score;
		}

		public void setScore(int score) {
			this.score = score;
		}

		@Override
		public String toString() {
			return "{" + id + ":" + score + '}';
		}
	}

	public static void sort(MyObject[] a) {
		//你要完成的代码，根据需求可以自己加类方法

		boolean changed = false;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - i - 1; j++) {
				if (a[j].getScore() > a[j + 1].getScore()) {
					swap(a, j, j + 1);
					changed = true;
				}
			}
			if (!changed) {
				break;
			}
		}
		System.out.println("Result:" + a);
	}

	public static void swap(MyObject[] a, int i, int j) {
		MyObject temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	//解析牛客网输入数据
	public static MyObject[] parseSampleInput() {
		Scanner in = new Scanner(System.in);
		List<MyObject> inList = new ArrayList<>();
		while (in.hasNextInt()) {
			int id = in.nextInt();
			int score = in.nextInt();
			inList.add(new MyObject(id, score));
		}
		MyObject[] a = new MyObject[inList.size()];
		return inList.toArray(a);
	}

	public static void main(String[] args) {
		MyObject[] a = parseSampleInput();
		sort(a);
		System.out.println("Result: " + Arrays.toString(a));
	}
}
