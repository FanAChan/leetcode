package solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Achan
 * @date 2018/5/7 11:34
 * <p>
 * In a string S of lowercase letters, these letters form consecutive groups of the same character.
 * <p>
 * For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".
 * <p>
 * Call a group large if it has 3 or more characters.  We would like the starting and ending positions of every large group.
 * <p>
 * The final answer should be in lexicographic order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "abbxxxxzzy"
 * Output: [[3,6]]
 * Explanation: "xxxx" is the single large group with starting  3 and ending positions 6.
 * <p>
 * Example 2:
 * <p>
 * Input: "abc"
 * Output: []
 * Explanation: We have "a","b" and "c" but no large group.
 * <p>
 * Example 3:
 * <p>
 * Input: "abcdddeeeeaabbbcd"
 * Output: [[3,5],[6,9],[12,14]]
 * <p>
 * <p>
 * <p>
 * Note:  1 <= S.length <= 1000
 **/
public class PositionsofLargeGroups {

	public static List<List<Integer>> largeGroupPositions(String S) {

		List<List<Integer>> lists = new ArrayList<>();
		if (S == null || S.length() <= 2) {
			return lists;
		}
		char cur = S.charAt(0);
		int start = 0;
		for (int i = 1; i < S.length(); i++) {
			if (S.charAt(i) == cur) {
				i++;
				continue;
			} else if (i - start >= 3) {
				List<Integer> list = new ArrayList<>();
				list.add(start);
				list.add(i - 1);
				lists.add(list);
			}
			cur = S.charAt(i);
			start = i;
		}
		if (S.length() - start >= 3) {
			List<Integer> list = new ArrayList<>();
			list.add(start);
			list.add(S.length() - 1);
			lists.add(list);
		}
		return lists;
	}

	public static void main(String[] args) {
//		PositionsofLargeGroups.largeGroupPositions("aaa");
		System.out.println(2&3&2);
		System.out.println(3^2^2);
		System.out.println(3|2);
	}

}
