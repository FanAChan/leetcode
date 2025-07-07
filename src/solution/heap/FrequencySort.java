package solution.heap;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class FrequencySort {

    public String frequencySort(String s) {



        int i = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (i < s.length()) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) + 1);
            i++;
        }

        List<Map.Entry<Character, Integer>> countList = map.entrySet().stream().sorted(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        }).collect(Collectors.toList());


        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : countList) {

            for(int j = 0;j < entry.getValue();j++) {
                result.append(entry.getKey());
            }
        }
        return result.toString();
    }

    @Test
    public void test() throws Exception {
        Assert.assertEquals("eert",frequencySort("tree"));
    }

}
