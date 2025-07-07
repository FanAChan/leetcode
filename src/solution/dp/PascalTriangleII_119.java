package solution.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 *  while j = 0 || i = j
 *      f(i)(j) = 1
 *  else
 *      f(i)(j) = f(i-1)f(j-1) + f(i-1)f(j)
 */
public class PascalTriangleII_119 {


    public List<Integer> getRow(int rowIndex) {
        if(rowIndex == 0){
            return Arrays.asList(1);
        }
        if(rowIndex == 1){
            return Arrays.asList(1,1);
        }
        List<Integer> preRow = getRow(rowIndex - 1);

        List<Integer> result = new ArrayList<>();

        result.add(1);
        int j = 1;
        while (j < rowIndex){
            result.add(preRow.get(j-1) + preRow.get(j));
            j++;
        }
        result.add(1);

        return result;

    }
}
