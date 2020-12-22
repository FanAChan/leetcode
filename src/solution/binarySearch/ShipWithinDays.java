package solution.binarySearch;

import org.junit.Test;

public class ShipWithinDays {
    //当最小承重量K可在D天内运送完成时，大于K的必然也可以，所以是查找左边界
    public int solution(int[] weights, int D) {

        if(null == weights || weights.length == 0){
            return 0;
        }

        //最小承载量为包裹的最大值，否则运送不过去
        int left = 0;
        //最大的承载量是重量总和
        int right = 0;

        for (int weight : weights) {
            left = Math.max(left,weight);
            right += weight;
        }

        while (left < right){
            int mid = left + (right - left)/2;
            if(canShipWithDays(weights,D,mid)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return right;
    }

    private boolean canShipWithDays(int[] nums,int D,int K){

        int result = 0;
        int temp = 0;
        for (int num : nums) {
            temp += num;
            if(temp > K){
                result++;
                temp = num;
            }
        }
        result++;
        return result <= D;
    }


    @Test
    public void test() throws Exception {

        ShipWithinDays shipWithinDays = new ShipWithinDays();
        shipWithinDays.solution(new int[]{3,2,2,4,1,4},1);
    }
}
