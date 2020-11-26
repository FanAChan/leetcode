package solution;

public class MaxArea {

    //双指针，
    public int maxArea(int[] height) {

        if (null == height) {
            return 0;
        }

        int start = 0;
        int end = height.length - 1;
        int result = 0;
        while (start < end) {
            int min = 0;
            if(height[start]<height[end]){
                min = height[start];
                start++;
            }else{
                min = height[end];
                end--;
            }
            result = Math.max(min * (end - start + 1), result);

        }
        return result;
    }
}
