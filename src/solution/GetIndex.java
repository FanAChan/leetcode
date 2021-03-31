package solution;

import org.junit.Assert;
import org.junit.Test;

public class GetIndex {

    public int getIndex(int[] array,int target){



        int start = 0;
        int end = array.length - 1;
        while (start <= end){

            int mid = (start + end) / 2;
            if(array[mid] == target){
                return mid;
            }
            if(array[start] <= array[mid]){
                if(array[start] <= target && array[mid] > target){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }else{

                if(array[end] >= target && array[mid] < target){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }
        return -1;
    }


    public int getIndex2(int[] array,int target){

        int start = 0;
        int end = array.length - 1;
        while (start <= end){

            int mid = (start + end) / 2;
            if(array[mid] == target){
                return mid;
            }
            if(array[mid] > array[end]){
                if(array[start] >= target && array[mid] < target){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }
            else{
                if(array[mid] < target && array[end] >= target){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    @Test
    public void test() throws Exception {
        Assert.assertEquals(getIndex2(new int[]{7,6,5,0,1,2,3,4},3),6);
        Assert.assertEquals(getIndex2(new int[]{7,6,5,0,1,2,3,4},7),0);
        Assert.assertEquals(getIndex2(new int[]{7,6,5,0,1,2,3,4},4),7);
        Assert.assertEquals(getIndex2(new int[]{7,6,5,0,1,2,3,4},0),3);
    }

}
