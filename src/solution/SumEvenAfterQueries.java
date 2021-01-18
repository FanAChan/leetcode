package solution;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SumEvenAfterQueries {

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {


        int[] result = new int[queries.length];
        int sum = 0;
        for (int i : A) {
            if((i & 1) == 0){
                sum += i;
            }
        }

        int i = 0;
        for (int[] query : queries) {
            int temp = A[query[1]];
            if((temp & 1) == 0){
                sum -= temp;
            }
            A[query[1]] += query[0];
            temp = A[query[1]];
            if(( temp & 1) == 0){
                sum +=  temp;
            }
            result[i] = sum;
            i++;
        }
        return result;

    }

    @Test
    public void test() throws Exception {

        int[][] arr = {{1,0},{-3,1},{-4,0},{2,3}};
        sumEvenAfterQueries(new int[]{1,2,3,4},arr);
    }
}
