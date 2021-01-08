package solution.doublepointer;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class TotalFruit {

    public int totalFruit(int[] tree) {


        if(null == tree){
            return 0;
        }
        if(tree.length <= 2){
            return tree.length;
        }

        int start = 0;
        int end = 0;
        HashMap<Integer, Integer> countMap = new HashMap<>();

        int max = 0;
        while (start <= end && end < tree.length) {
            if (countMap.size() == 2 && countMap.containsKey(tree[end])) {
                countMap.put(tree[end], countMap.get(tree[end]) + 1);
                max = Math.max(max, end - start + 1);
                end++;
            } else if (countMap.size() == 2 && !countMap.containsKey(tree[end])) {
                Integer count = countMap.remove(tree[start]);
                count--;
                if (count > 0) {
                    countMap.put(tree[start], count);
                }
                start++;
            } else if(countMap.containsKey(tree[end])) {
                countMap.put(tree[end], countMap.get(tree[end]) + 1);
                max = Math.max(max, end - start + 1);
                end++;
            }else{
                countMap.put(tree[end], 1);
                max = Math.max(max, end - start + 1);
                end++;
            }
        }
        return max;

    }

    @Test
    public void test() throws Exception {
        Assert.assertEquals(3,totalFruit(new int[]{1,2,1}));
        Assert.assertEquals(3,totalFruit(new int[]{0,1,2,2}));
        Assert.assertEquals(4,totalFruit(new int[]{1,2,3,2,2}));
        Assert.assertEquals(5,totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
    }
}
