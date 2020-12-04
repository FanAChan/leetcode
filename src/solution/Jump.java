package solution;

import org.junit.Assert;
import org.junit.Test;

public class Jump {


    //超时
    public int jump(int[] nums) {

        int[] jumpArray = new int[nums.length];

        for (int i = 1; i < nums.length; i++) {
            int min = i;
            for (int j = i - 1; j >= 0; j--) {
                if(nums[j] >= i - j && min > jumpArray[j] + 1 ){
                    min = jumpArray[j] + 1;
                }
            }
            jumpArray[i] = min;
        }
        return jumpArray[nums.length - 1];
    }

    //计算最远可达位置，从上次最远可达位置到此次最远可达位置所跳的最小步数是相同的，再从这个区间范围内计算下一次最远可达位置
    public int jump2(int[] nums) {

        if(null == nums || nums.length <= 1){
            return 0;
        }

        int step = 0;
        int maxArriveIndex = 0;
        for (int i = 0; i < nums.length;) {
            if(maxArriveIndex >= nums.length - 1){
                break;
            }
            int max = maxArriveIndex + 1;
            for (int j = maxArriveIndex; j >= i ; j--) {
                if(max < nums[j] + j){
                    max = nums[j] + j;
                }
            }
            i = maxArriveIndex + 1;
            maxArriveIndex = max;
            step++;
        }
        return step;
    }

    @Test
    public void test(){
        Jump jump = new Jump();
        int[] nums = new int[25000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = 25000 - i;
        }
        Assert.assertEquals(jump.jump2(nums),1);
        Assert.assertEquals(jump.jump2(new int[]{2,3,1,1,4}),2);
        Assert.assertEquals(jump.jump2(new int[]{3,1,1,1,1}),2);
    }
}
