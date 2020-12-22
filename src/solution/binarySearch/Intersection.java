package solution.binarySearch;

import org.junit.Test;

import java.util.Arrays;

public class Intersection {


    public int[] intersection(int[] nums1, int[] nums2) {
        if(null == nums1 || 0 == nums1.length || null == nums2 || 0 == nums2.length){
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;

        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] result = new int[len1 > len2 ? len2 : len1];
        int resultIndex = 0;
        while (i < len1 && j < len2){
            if(nums1[i] == nums2[j]){
                int pre = nums1[i];
                while (i < len1 && pre == nums1[i] ){
                    i++;
                }
                while (j < len2 && pre == nums2[j]){
                    j++;
                }
                result[resultIndex++] = pre;
            }else if (nums1[i] < nums2[j]){
                i++;
            }else if (nums1[i] > nums2[j]){
                j++;
            }
        }
        return Arrays.copyOf(result,resultIndex);
    }

    @Test
    public void test(){
        Intersection intersection = new Intersection();
        int[] intersection1 = intersection.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        for (int i : intersection1) {
            System.out.print(i);
        }

    }
}
