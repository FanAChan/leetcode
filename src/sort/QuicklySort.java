package sort;


import org.junit.Test;

public class QuicklySort implements SortSolution {

    @Override
    public void deal(int[] array) {
        if (null == array || array.length == 0) {
            return;
        }
        int len = array.length;



    }


    private void sort(int[] array, int start, int end){
        if(start >= end){
            return;
        }

        int compare = array[start];

        int i = start + 1;
        int j = end;
        while (i <= j){
            while (i<j && array[i] < compare){
                i++;
            }
            while (j>i && array[j] > compare){
                j++;
            }
            if(j > i) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

    }

    public void dealSub(int[] array, int start, int end) {
        if(start >= end){
            return;
        }
        int startLeft = start;
        int endLeft = start;
        int startRight = end;
        int endRight = end;

        int midNum = array[start];

        for (int i = start; i < end; i++) {

        }


    }


    @Test
    public void test(){

        int[] a = {2,5,1,3,8,4,9};
        this.sort(a,0,6);
        System.out.println(a);
    }

}
