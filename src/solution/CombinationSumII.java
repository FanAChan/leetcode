package solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Achan
 * @date 2018/11/2 13:57
 **/
public class CombinationSumII {

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(candidates);
		combinationSum(result, new ArrayList<>(),0, candidates, target);
		return result;
	}

	public void combinationSum(List<List<Integer>> result, List<Integer> temp, int start, int[] candidates, int target) {
		for (int i = start; i < candidates.length; i++) {
			int num = candidates[i];
			if(num < target){
				temp.add(num);
				combinationSum(result,temp,i + 1,candidates,target - num);
				Integer remove = temp.remove(temp.size() - 1);
			}else if(num == target){
				temp.add(num);
				result.add(new ArrayList<>(temp));
				temp.remove(temp.size() - 1);
				return;
			}else{
				break;
			}
		}
	}

	@Test
	public void test() {
		CombinationSumII combinationSumII = new CombinationSumII();
		List<List<Integer>> lists = combinationSumII.FindContinuousSequence(100);
		for (List<Integer> list : lists) {
			for (Integer integer : list) {
				System.out.print(integer);
			}
			System.out.println();
		}

    }

    public List<List<Integer>> FindContinuousSequence(int sum) {
        List<List<Integer>> ret = new ArrayList<>();
        int start = 1, end = 2;
        int curSum = 3;
        while (end < sum) {
            if (curSum > sum) {
                curSum -= start;
                start++;
            } else if (curSum < sum) {
                end++;
                curSum += end;
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = start; i <= end; i++)
                    list.add(i);
                ret.add(list);
                curSum -= start;
                start++;
            }
        }
        return ret;
    }
}
