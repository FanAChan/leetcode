package solution;

public class ValidMountainArray {

    public boolean validMountainArray(int[] arr) {


       int i = 0;
       while (i < arr.length - 1 && arr[i] < arr[i-1]){
           i++;
       }
       if(i == 0 || i == arr.length){
           return false;
       }
        while (i < arr.length - 1 && arr[i] > arr[i-1]){
            i++;
        }
        return i == arr.length - 1;

    }
}
