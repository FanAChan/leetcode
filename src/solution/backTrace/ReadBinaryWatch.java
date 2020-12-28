package solution.backTrace;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ReadBinaryWatch {

    public List<String> solution(int num) {
        ArrayList<String> result = new ArrayList<>();
        int[] times = {1, 2, 4, 8, 1, 2, 4, 8, 16, 32};
        int[] selected = new int[10];
        backTrace(result,num,0,times,selected,0);

        result.sort(Comparator.comparing(String::toString));
        return result;
    }

    private void backTrace(List<String> result,int num,int level,int[] times,int[] selected,int start){
//        判断是否结束回溯
//        for i in nums
//                做出一个选择
//        backtrack(...)
//        撤销选择
        if(level == num){
            //结束回溯
            System.out.println(Arrays.toString(selected));
            result.add((this.parse(times,selected)));
            return;
        }

        for(int i = start;i < times.length;i++){
            if(selected[i] == 1){
                continue;
            }
            selected[i] = 1;
            level++;
            if(isValid(times,selected)) {
                backTrace(result, num, level, times, selected,i + 1);
            }
            selected[i] = 0;
            level--;
        }

    }

    private boolean isValid(int[] times, int[] selected) {
        int hour = 0;
        int minute = 0;
        for (int i = 0; i < times.length; i++) {
            if (i < 4) {
                hour += times[i] * selected[i];
            } else {
                minute += times[i] * selected[i];
            }
        }
        return hour < 12 && minute < 60;
    }

    private String parse(int[] times,int[] selected){
        int hour = 0;
        int minute = 0;
        for (int i = 0; i < times.length; i++) {

            if (i < 4) {
                hour += times[i] * selected[i];
            } else {
                minute += times[i] * selected[i];
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(hour);
        stringBuilder.append(":");
        if(minute < 10){
            stringBuilder.append("0");
        }
        stringBuilder.append(minute);

        return stringBuilder.toString();
    }

    @Test
    public void test() throws Exception {
        ReadBinaryWatch readBinaryWatch = new ReadBinaryWatch();
        readBinaryWatch.solution(2);
    }
}
