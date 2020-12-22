package solution.binarySearch;

import org.junit.Assert;
import org.junit.Test;

public class FlowersMinDays {

    public int solution(int[] bloomDay, int m, int k) {

        if(null == bloomDay || bloomDay.length / m < k){
            return -1;
        }

        int left = Integer.MAX_VALUE;
        int right = 0;
        for (int i : bloomDay) {
            right = Math.max(i,right);
            left = Math.min(left,i);
        }

        while (left < right){
            int mid = left + (right - left)/2;
            if(check(bloomDay,m,k,mid)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return right;
    }

    private boolean check(int[] bloomDay, int m, int k,int day){
        int mResult = 0;
        int temp = 0;
        for (int i : bloomDay) {
            if(i <= day){
                temp++;
                if(temp == k){
                    mResult++;
                    temp = 0;
                }
            }else{
                temp = 0;
            }
        }
        return mResult >= m;
    }

    @Test
    public void test() throws Exception {
        FlowersMinDays flowersMinDays = new FlowersMinDays();
        flowersMinDays.solution(new int[]{1,10,3,10,2},3,1);
        Assert.assertEquals(3,flowersMinDays.solution(new int[]{1,10,3,10,2},3,1));
        Assert.assertEquals(-1,flowersMinDays.solution(new int[]{1,10,3,10,2},3,2));
        Assert.assertEquals(12,flowersMinDays.solution(new int[]{7,7,7,7,12,7,7},2,3));
        Assert.assertEquals(1000000000,flowersMinDays.solution(new int[]{1000000000,1000000000},1,1));
    }
}
