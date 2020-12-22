package solution;

import org.junit.Test;

public class Trap {


    public int trap(int[] height) {

        int result = 0;

        if(null == height || height.length <= 2){
            return result;
        }

        for (int i = 0; i < height.length; ) {
            int thisLevelHeight = height[i];
            if(thisLevelHeight == 0){
                i++;
                continue;
            }
            int thisLevelTrap = 0;
            int j = i + 1;
            while (j < height.length && height[j] < thisLevelHeight){
                thisLevelTrap += thisLevelHeight - height[j];
                j++;
            }
            if(j < height.length){
                result += thisLevelTrap;
                i = j;
            }else{
                i++;
            }
        }

        return result;
    }

    @Test
    public void test(){
        Trap trap = new Trap();
        int trap1 = trap.trap(new int[]{1,2,3});
        System.out.println(trap1);
    }
}
