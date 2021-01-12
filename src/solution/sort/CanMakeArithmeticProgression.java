package solution.sort;

import java.util.Arrays;

public class CanMakeArithmeticProgression {

    public boolean canMakeArithmeticProgression(int[] arr) {

        Arrays.sort(arr);

        int num = arr[1] - arr[0];

        int len = arr.length;

        for(int i = 2;i<len;i++){
            if(num != arr[i] - arr[i-1]){
                return false;
            }

        }

        return true;
    }
}
