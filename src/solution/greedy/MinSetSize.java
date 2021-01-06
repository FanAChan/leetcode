package solution.greedy;

import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class MinSetSize {

    public int minSetSize(int[] arr) {

        int num = arr.length;

        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i,map.getOrDefault(i,0) + 1);
        }


        ArrayList<Integer> list = new ArrayList<>(map.values());
        list.sort((i, j)->j - i);

        int i = 0;
        for(;i < list.size();i++) {
            sum+= list.get(i);
            if((num >> 1) < sum){
                break;
            }
        }
        return i;

    }
}
