package solution.binarySearch;

import org.junit.Assert;
import org.junit.Test;

public class SearchMatrix {

    public boolean solution(int[][] matrix, int target) {

        if(null == matrix || matrix.length == 0){
            return false;
        }
        if(matrix[0].length == 0){
            return false;
        }
        int i = 0;
        int j = matrix[0].length - 1;

        while (i < matrix.length && j>=0){
            if(target == matrix[i][j]){
                return true;
            }else if(target > matrix[i][j]){
                i++;
            }else if(target < matrix[i][j]){
                j--;
            }
        }
        return false;
    }

    @Test
    public void test() throws Exception {
        SearchMatrix searchMatrix = new SearchMatrix();
        int[][] ints = new int[5][5];
        ints[0] = new int[]{1,   4,  7, 11, 15};
        ints[1] = new int[]{2,   5,  8, 12, 19};
        ints[2] = new int[]{3,   6,  9, 16, 22};
        ints[3] = new int[]{10, 13, 14, 17, 24};
        ints[4] = new int[]{18, 21, 23, 26, 30};
        Assert.assertEquals(true,searchMatrix.solution(ints,5));
        Assert.assertEquals(false,searchMatrix.solution(ints,20));
        Assert.assertEquals(true,searchMatrix.solution(ints,30));
        Assert.assertEquals(true,searchMatrix.solution(ints,1));
    }

}
