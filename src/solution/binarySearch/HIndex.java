package solution.binarySearch;

import org.junit.Test;

public class HIndex {

    //顺序数组，h篇大于h以上 h最大值 citations[mid] < citations.length - mid
    public int hIndex(int[] citations) {

        if (citations == null || citations.length == 0 || citations[citations.length - 1] == 0) {
            return 0;
        }

        int hStart = 0;
        int hEnd = citations.length;

        while (hStart < hEnd){

            int mid = hStart + (hEnd - hStart)/2;
            if(citations[mid] < citations.length - mid){
                hStart = mid+1;
            }else{
                hEnd = mid;
            }
        }
        return citations.length - hStart;
    }

    @Test
    public void test(){

        HIndex hIndex = new HIndex();
        int i = hIndex.hIndex(new int[]{0,1,3,5,6});
        System.out.println(i);

    }
}
