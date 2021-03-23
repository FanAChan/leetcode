package solution;

import com.sun.deploy.util.OrderedHashSet;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.*;

public class AvoidFlood {
    public int[] avoidFlood(int[] rains) {

//        1,2,0,0,2,1
        TreeSet<Integer> emptyList = new TreeSet<>();
        HashMap<Integer,Integer> fullMap = new HashMap<>();

        int[] result = new int[rains.length];

        for (int i = 0; i < rains.length; i++) {
            int rain = rains[i];
            if (rain > 0) {
                result[i] = -1;
                if (fullMap.containsKey(rain)) {
                    //getEmptyDay
                    Integer emptyDay = getEmptyDay(emptyList, fullMap.get(rain));
                    if (null == emptyDay) {
                        return new int[0];
                    } else {
                        emptyList.remove(emptyDay);
                        result[emptyDay] = rain;
                        fullMap.put(rain,i);
                    }
                } else {
                    fullMap.put(rain,i);
                }
            } else {
                result[i]= 1;
                emptyList.add(i);
            }
        }
        return result;
    }

    private Integer getEmptyDay(TreeSet<Integer> set,Integer rainDay){
        Integer result = null;
        Iterator<Integer> iterator = set.iterator();

        while (iterator.hasNext()){
            int day = iterator.next();
            if(day > rainDay ){
                if(result == null){
                    result = day;
                }else{
                    result = Math.min(result,day);
                }
            }
        }
        return result;
    }

    @Test
    public void test() throws Exception {
        System.out.println(Arrays.toString(avoidFlood(new int[]{1,0,2,0,2,1})));
    }

}
