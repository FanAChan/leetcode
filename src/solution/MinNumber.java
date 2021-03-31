package solution;

import java.util.Arrays;

public class MinNumber {


    public String minNumber(int[] nums) {


        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            strings[i] = String.valueOf(num);
        }
        Arrays.sort(strings,(o1,o2)->{
            return (o1 + o2).compareTo(o2+o1);
        });

        StringBuilder stringBuilder = new StringBuilder();
        for (String string : strings) {
            stringBuilder.append(string);
        }

        return stringBuilder.toString();

    }
}
