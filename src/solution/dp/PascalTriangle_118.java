package solution.dp;

import java.util.ArrayList;
import java.util.List;


/**
 *  while j = 0 || i = j
 *      f(i)(j) = 1
 *  else
 *      f(i)(j) = f(i-1)f(j-1) + f(i-1)f(j)
 */
public class PascalTriangle_118 {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();


        List<Integer> preRowList = new ArrayList<>();
        int i = 0;
        while (i < numRows){
            int j = 0;
            List<Integer> currentRowList = new ArrayList<>();
            while (j <= i){
                if (j == 0 || i == j) {
                    currentRowList.add(1);
                }else{
                    currentRowList.add(preRowList.get(j-1) + preRowList.get(j));
                }
                j++;
            }
            i++;
            preRowList = currentRowList;
            result.add(currentRowList);
        }
        return result;
    }
}
